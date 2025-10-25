package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PracticeAssessmentsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "logoutButton")
    WebElement logout_id;

    @FindBy(id = "tab-btn-web")
    WebElement WebAutomation_id;

    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect;

    @FindBy(id = "brand")
    WebElement brandSelect;

    @FindBy(id = "storage-64GB")
    WebElement storage64Select;

    @FindBy(id = "storage-128GB")
    WebElement storage128Select;

    @FindBy(id = "storage-256GB")
    WebElement storage256Select;

    @FindBy(id = "color")
    WebElement colorSelect;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "address")
    WebElement deliveryAddressInput;

    @FindBy(id = "purchase-device-btn")
    WebElement purchaseButton;

    @FindBy(id = "purchase-success-toast")
    WebElement successToast;

    @FindBy(css = "svg[aria-label='Device phone']")
    WebElement phoneDeviceSvg;

    @FindBy(css = "img[alt='Device laptop']")
    WebElement laptopDeviceImg;

    @FindBy(css = "img[alt='Device tablet']")
    WebElement tabletDeviceImg;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    public PracticeAssessmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickWebAutomation() {
        wait.until(ExpectedConditions.elementToBeClickable(WebAutomation_id)).click();
    }

    public void selectDeviceType(String deviceType) {
        if (deviceType != null && !deviceType.isEmpty()) {
            new Select(deviceTypeSelect).selectByVisibleText(deviceType);

            switch (deviceType.toLowerCase()) {
                case "phone":
                    wait.until(ExpectedConditions.visibilityOf(phoneDeviceSvg));
                    Assert.assertTrue(phoneDeviceSvg.isDisplayed(), "Phone device SVG not displayed");
                    break;
                case "laptop":
                    wait.until(ExpectedConditions.visibilityOf(laptopDeviceImg));
                    Assert.assertTrue(laptopDeviceImg.isDisplayed(), "Laptop image not displayed");
                    break;
                case "tablet":
                    wait.until(ExpectedConditions.visibilityOf(tabletDeviceImg));
                    Assert.assertTrue(tabletDeviceImg.isDisplayed(), "Tablet image not displayed");
                    break;
            }
        }
    }

    public void selectBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            System.out.println("⚠ Skipping brand selection because value is empty.");
            return;
        }
        if (!brandSelect.isEnabled()) {
            System.out.println("⚠ Brand dropdown is disabled, cannot select: " + brand);
            return;
        }
        new Select(brandSelect).selectByVisibleText(brand);
    }

    public void selectStorage(String storage) {
        if (storage == null || storage.isEmpty()) {
            System.out.println("⚠ Skipping storage selection because value is empty.");
            return;
        }
        switch (storage) {
            case "64GB": storage64Select.click(); break;
            case "128GB": storage128Select.click(); break;
            case "256GB": storage256Select.click(); break;
        }
    }

    public void selectColor(String color) {
        if (color == null || color.isEmpty()) {
            System.out.println("⚠ Skipping color selection because value is empty.");
            return;
        }
        new Select(colorSelect).selectByVisibleText(color);
    }

    public void setQuantity(int quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void enterDeliveryAddress(String address) {
        deliveryAddressInput.clear();
        deliveryAddressInput.sendKeys(address);
    }





    public void assertSuccessToastVisible() {
        wait.until(ExpectedConditions.visibilityOf(successToast));
        Assert.assertTrue(successToast.isDisplayed(), "Success toast not visible!");
    }

    public void assertFormReset() {
        Assert.assertEquals(new Select(deviceTypeSelect).getFirstSelectedOption().getText(), "Select Device");
        Assert.assertEquals(new Select(brandSelect).getFirstSelectedOption().getText(), "Select Brand");
        Assert.assertEquals(quantityInput.getAttribute("value"), "1");
        Assert.assertEquals(deliveryAddressInput.getAttribute("value"), "");
    }

    // 🔹 Wizard Step 1 error helper
// 🔹 Inside PracticeAssessmentsPage
    public void clickPurchaseDevice(String expectedResult) {
        // Step 1: Check Next button state
        if (!nextButton.isEnabled()) {
            Assert.assertEquals(expectedResult, "NextDisabled",
                    "❌ Expected Next button disabled, but test expected: " + expectedResult);
            return;
        } else {
            Assert.assertTrue(nextButton.isEnabled(),
                    "❌ Expected Next button enabled, but it is disabled!");
            nextButton.click();

            // Small wait for page updates or inline validation errors
            try {
                WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
                shortWait.until(ExpectedConditions.or(
                        ExpectedConditions.urlContains("purchase"),
                        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.error-text[role='alert']"))
                ));
            } catch (TimeoutException e) {
                // Ignore: page did not navigate, probably validation error
            }
        }

        // Step 2: Attempt to click purchase button if present
        try {
            WebElement purchaseBtn = wait.until(ExpectedConditions.elementToBeClickable(purchaseButton));
            purchaseBtn.click();
        } catch (TimeoutException | NoSuchElementException e) {
            // Purchase button not present → probably validation error
        }

        // Step 3: Assert expected message
        confirmErrorMessage(expectedResult);
    }

    public void confirmErrorMessage(String expectedResult) {
        wait.until(ExpectedConditions.visibilityOf(nextButton));

        // Case 1: Next button disabled
        if (expectedResult.equalsIgnoreCase("NextDisabled")) {
            Assert.assertFalse(nextButton.isEnabled(), "❌ Next button should be disabled!");
            return;
        }

        // Case 2: Quantity errors
        if (expectedResult.startsWith("Quantity")) {
            try {
                WebElement quantityError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("span.error-text[role='alert']")
                ));
                String actual = quantityError.getText().trim();
                Assert.assertEquals(actual, expectedResult, "❌ Quantity error mismatch!");
            } catch (TimeoutException te) {
                Assert.fail("❌ Expected quantity error '" + expectedResult + "' but none was shown.");
            }
            return;
        }

        // Case 3: Success toast
        if (expectedResult.equalsIgnoreCase("Order placed successfully!")) {
            assertSuccessToastVisible();
            return;
        }
    }


    public void assertNextButtonDisabled() {
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        Assert.assertFalse(nextButton.isEnabled(), "❌ Next button should be disabled but it is enabled!");
    }

    public void assertNextButtonEnabled() {
        wait.until(ExpectedConditions.visibilityOf(nextButton));
        Assert.assertTrue(nextButton.isEnabled(), "❌ Next button should be enabled but it is disabled!");
    }

}
