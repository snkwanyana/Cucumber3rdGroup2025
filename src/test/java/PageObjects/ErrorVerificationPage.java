package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class ErrorVerificationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ErrorVerificationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // 🔹 Common form elements
    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect;

    @FindBy(id = "brand")
    WebElement brandSelect;

    @FindBy(id = "storage-64GB")
    WebElement storage64Option;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountBtn;

    @FindBy(name = "loginButton")
    WebElement loginButton;

    // 🔹 Error messages
    @FindBy(css = "span.error-text[role='alert']")
    WebElement fieldError;

    @FindBy(css = "[data-testid='discount-feedback']")
    WebElement discountError;

    @FindBy(css = "#login-alert")
    WebElement loginAlert;

    @FindBy(css = "#error-summary, [data-testid='error-summary']")
    WebElement errorSummary;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;

    // 🔹 Actions
    public void triggerError(String errorCase) {
        switch (errorCase) {
            case "missingDeviceType":
                // Skip selecting device, try next
                nextButton.click();
                break;

            case "missingBrand":
                selectDeviceType("Phone");
                nextButton.click();
                break;

            case "missingStorage":
                selectDeviceType("Phone");
                selectBrand("Apple");
                nextButton.click();
                break;

            case "quantityBelowMin":
                selectDeviceType("Phone");
                selectBrand("Apple");
                selectStorage("64GB");
                setQuantity("0");
                nextButton.click();
                break;

            case "quantityAboveMax":
                selectDeviceType("Phone");
                selectBrand("Apple");
                selectStorage("64GB");
                setQuantity("11");
                nextButton.click();
                break;

            case "missingAddress":
                selectDeviceType("Phone");
                selectBrand("Apple");
                selectStorage("64GB");
                setQuantity("1");
                addressInput.clear();
                nextButton.click();
                break;

            case "invalidDiscountCode":
                discountCodeInput.clear();
                discountCodeInput.sendKeys("random");
                applyDiscountBtn.click();
                break;

            case "invalidLogin":
                loginButton.click(); // simulate invalid login click
                break;

            case "errorSummary":
                nextButton.click();
                break;

            default:
                throw new IllegalArgumentException("⚠ Unknown error case: " + errorCase);
        }
    }

    // 🔹 Element actions
    public void selectDeviceType(String type) {
        new Select(deviceTypeSelect).selectByVisibleText(type);
    }

    public void selectBrand(String brand) {
        new Select(brandSelect).selectByVisibleText(brand);
    }

    public void selectStorage(String size) {
        if (size.equalsIgnoreCase("64GB")) storage64Option.click();
    }

    public void setQuantity(String qty) {
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));
        quantityInput.clear();
        quantityInput.sendKeys(qty);
    }

    // 🔹 Error verification
    public void verifyExactErrorMessage(String expectedMessage) {
        WebElement errorElement = null;
        String actualMessage = "";

        try {
            // Detect which error element is currently visible
            if (isVisible(fieldError)) {
                errorElement = fieldError;
            } else if (isVisible(discountError)) {
                errorElement = discountError;
            } else if (isVisible(loginAlert)) {
                errorElement = loginAlert;
            } else if (isVisible(errorSummary)) {
                errorElement = errorSummary;
            }

            if (errorElement != null) {
                wait.until(ExpectedConditions.visibilityOf(errorElement));
                actualMessage = errorElement.getText().trim();
            } else {
                Assert.fail("❌ No visible error element found for verification.");
            }

            Assert.assertEquals(actualMessage, expectedMessage,
                    "❌ Error message mismatch!\nExpected: " + expectedMessage + "\nActual: " + actualMessage);

        } catch (TimeoutException e) {
            Assert.fail("❌ Expected error message '" + expectedMessage + "' but none was visible.");
        }
    }

    private boolean isVisible(WebElement element) {
        try {
            return element.isDisplayed() && element.getText().trim().length() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
