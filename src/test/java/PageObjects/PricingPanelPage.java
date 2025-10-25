package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class PricingPanelPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "deviceType") WebElement deviceTypeSelect;
    @FindBy(id = "storage-64GB") WebElement storage64Select;
    @FindBy(id = "storage-128GB") WebElement storage128Select;
    @FindBy(id = "storage-256GB") WebElement storage256Select;
    @FindBy(id = "quantity") WebElement quantityInput;
    @FindBy(id = "unit-price-value") WebElement unitPriceLabel;
    @FindBy(id = "subtotal-value") WebElement subtotalLabel;
    @FindBy(id = "clearDeviceBtn") WebElement clearDeviceBtn;
    @FindBy(id = "address") WebElement addressInput;
    @FindBy(id = "inventory-next-btn") WebElement nextButton;
    @FindBy(id = "brand") WebElement brandSelect;
    @FindBy(id = "current-price-header")
    WebElement currentPriceHeader;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;

    @FindBy(id = "pricing-note")
    WebElement pricingNote;
    public PricingPanelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void ensureVisible(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void ensureClickable(WebElement element) {
        ensureVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectDeviceType(String deviceType) {
        if (deviceType == null || deviceType.isEmpty()) return;
        new Select(deviceTypeSelect).selectByVisibleText(deviceType);
    }

    public void selectStorage(String storage) {
        if (storage == null || storage.isEmpty()) return;

        WebElement storageElement = switch (storage) {
            case "64GB" -> storage64Select;
            case "128GB" -> storage128Select;
            case "256GB" -> storage256Select;
            default -> null;
        };

        if (storageElement != null) {
            ensureClickable(storageElement);
            storageElement.click();
        }
    }

    public void setQuantity(int quantity) {
        ensureClickable(quantityInput);
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void clearDeviceSelection() {
        ensureClickable(clearDeviceBtn);
        clearDeviceBtn.click();
    }

    public void scrollDownUsingKeys() throws AWTException, InterruptedException {
        Robot robot = new Robot();

        // Scroll down multiple times to trigger lazy loading
        for (int i = 0; i < 6; i++) {
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            Thread.sleep(400);
        }
    }

    public void assertPricing(String expectedUnit, String expectedSubtotal) throws InterruptedException, AWTException {
        // Realistic wait time (20 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1️⃣ Scroll down gradually
        scrollDownUsingKeys();

        // 2️⃣ Wait for the "Current Price" header to appear
        WebElement priceHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("current-price-header")
        ));

        // 3️⃣ Wait for the Unit and Subtotal value elements (directly by ID)
        WebElement unitValueEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("unit-price-value")
        ));
        WebElement subtotalValueEl = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("subtotal-value")
        ));

        // 4️⃣ Scroll into view
        js.executeScript("arguments[0].scrollIntoView({behavior:'smooth', block:'center'});", unitValueEl);

        // 5️⃣ Read and assert
        String actualUnit = unitValueEl.getText().trim();
        String actualSubtotal = subtotalValueEl.getText().trim();

        System.out.println("💡 Actual Unit Price: " + actualUnit);
        System.out.println("💡 Actual Subtotal: " + actualSubtotal);

        // Optional: ensure expected text formatting consistency
        String expectedUnitFormatted = expectedUnit.startsWith("Unit:") ? expectedUnit.replace("Unit:", "").trim() : expectedUnit.trim();

        // 6️⃣ Assertions
        Assert.assertEquals("❌ Unit price mismatch!", expectedUnitFormatted, actualUnit);
        Assert.assertEquals("❌ Subtotal mismatch!", expectedSubtotal, actualSubtotal);
    }

    public void selectBrand(String brand) {
        if (brand == null || brand.isEmpty()) return;
        ensureClickable(brandSelect);
        new Select(brandSelect).selectByVisibleText(brand);
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void clickNext() {
        ensureClickable(nextButton);
        nextButton.click();
    }
}
