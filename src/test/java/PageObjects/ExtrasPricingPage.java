package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class ExtrasPricingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ExtrasPricingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Device/Brand/Storage/Quantity/Address
    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect;

    @FindBy(id = "brand")
    WebElement brandSelect;

    @FindBy(id = "storage")
    WebElement storageSelect;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "next-button")
    WebElement nextButton;

    // Shipping toggles
    @FindBy(id = "shipping-option-standard")
    WebElement shippingStandardToggle;

    @FindBy(id = "shipping-option-express")
    WebElement shippingExpressToggle;

    // Warranty toggles
    @FindBy(id = "warranty-option-none")
    WebElement warrantyNone;

    @FindBy(id = "warranty-option-1yr")
    WebElement warranty1yr;

    @FindBy(id = "warranty-option-2yr")
    WebElement warranty2yr;

    // Extras & Pricing rows
    @FindBy(id = "breakdown-shipping-value")
    WebElement shippingRow;

    @FindBy(id = "breakdown-warranty-value")
    WebElement warrantyRow;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceRow;

    @FindBy(id = "subtotal-value")
    WebElement subtotalRow;

    @FindBy(id = "address")
    WebElement deliveryAddressInput;

    // ======================== Helpers ========================
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    private void waitForClickable(WebElement element) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void waitForVisible(WebElement element) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // ======================== Device / Brand / Storage / Quantity ========================
    public void selectDeviceType(String device) {
        waitForClickable(deviceTypeSelect);
        deviceTypeSelect.sendKeys(device); // could switch to Select if dropdown is <select>
    }

    public void selectBrand(String brand) {
        try {
            // 1️⃣ Guard clause for null/empty brand
            if (brand == null || brand.trim().isEmpty()) {
                System.out.println("⚠️ Brand name is null or empty — skipping selection.");
                return;
            }

            // 2️⃣ Wait for the dropdown to be visible & enabled
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(brandSelect));
            wait.until(ExpectedConditions.elementToBeClickable(brandSelect));

            // 3️⃣ Clean up input and select by visible text
            Select brandDropdown = new Select(brandSelect);
            brand = brand.trim();

            boolean optionFound = brandDropdown.getOptions().stream()
                    .anyMatch(option -> option.getText().trim().equalsIgnoreCase(String.valueOf(brandSelect)));

            if (optionFound) {
                brandDropdown.selectByVisibleText(brand);
                System.out.println("✅ Selected brand: " + brand);
            } else {
                System.out.println("❌ Brand '" + brand + "' not found in dropdown options.");
            }

        } catch (Exception e) {
            System.out.println("🚨 Error while selecting brand '" + brand + "': " + e.getMessage());
        }
    }


    public void selectStorage(String storage) {
        waitForClickable(storageSelect);
        storageSelect.sendKeys(storage);
    }

    public void setQuantity(int quantity) {
        waitForVisible(quantityInput);
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void enterAddress(String address) {
        waitForVisible(addressInput);
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void clickNext() {
        waitForClickable(nextButton);
        nextButton.click();
    }

    // ======================== Shipping / Warranty ========================
    public void toggleShipping(String shippingType) {
        WebElement shippingElement;

        if (shippingType.equalsIgnoreCase("Express")) {
            shippingElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("shipping-express")));
        } else {
            shippingElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("shipping-standard")));
        }

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", shippingElement);
        shippingElement.click();
    }



    public void selectWarranty(String warranty) {
        driver.switchTo().frame("warranty-frame"); // Replace with actual frame ID or WebElement

        WebElement warrantyElement;
        switch (warranty.toLowerCase()) {
            case "1yr":
                warrantyElement = warranty1yr;
                break;
            case "2yr":
                warrantyElement = warranty2yr;
                break;
            default:
                warrantyElement = warrantyNone;
                break;
        }

        waitForClickable(warrantyElement);
        warrantyElement.click();

        waitABit(500); // Allow UI to recalc totals
        driver.switchTo().defaultContent();
    }

    // ======================== Assertions ========================
    public void assertExtras(String expectedShipping, String expectedWarranty) {
        waitForVisible(shippingRow);
        waitForVisible(warrantyRow);

        String actualShipping = shippingRow.getText().trim();
        String actualWarranty = warrantyRow.getText().trim();

        Assert.assertEquals(actualShipping, expectedShipping, "❌ Shipping price mismatch!");
        Assert.assertEquals(actualWarranty, expectedWarranty, "❌ Warranty price mismatch!");
    }


    public void assertPricingWithRobotScroll(String expectedUnit, String expectedSubtotal) {
        try {
            // 1️⃣ Scroll down using Robot
            Robot robot = new Robot();
            // Scroll multiple times to ensure the section is visible
            for (int i = 0; i < 5; i++) {
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                Thread.sleep(300); // wait for the scroll to settle
            }

            // 2️⃣ Wait until elements are visible
            By unitLocator = By.id("unit-price-value");
            By subtotalLocator = By.id("subtotal-value");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(unitLocator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(subtotalLocator));

            // 3️⃣ Get the elements
            WebElement unitEl = driver.findElement(unitLocator);
            WebElement subtotalEl = driver.findElement(subtotalLocator);

            // 4️⃣ Optional: scroll element into view in case still partially hidden
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", unitEl
            );
            Thread.sleep(400);

            // 5️⃣ Read text
            String actualUnit = unitEl.getText().trim();
            String actualSubtotal = subtotalEl.getText().trim();
            String expectedUnitFormatted = expectedUnit.contains("Unit:") ? expectedUnit : "Unit: " + expectedUnit;

            System.out.println("💡 Found Unit Price: " + actualUnit);
            System.out.println("💡 Found Subtotal: " + actualSubtotal);

            // 6️⃣ Assertions
            Assert.assertEquals(actualUnit, expectedUnitFormatted, "❌ Unit price mismatch!");
            Assert.assertEquals(actualSubtotal, expectedSubtotal, "❌ Subtotal mismatch!");

        } catch (Exception e) {
            throw new RuntimeException("⚠️ Error asserting pricing after scrolling: " + e.getMessage(), e);
        }
    }




    // ======================== Utilities ========================
    private void waitABit(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
