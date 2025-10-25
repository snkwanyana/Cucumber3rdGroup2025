package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class ResetsAndNavigationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ResetsAndNavigationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ----- Form Elements -----
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

    @FindBy(id = "purchase-device-btn")
    WebElement confirmPurchaseBtn;

    @FindBy(id = "purchase-success-toast")
    WebElement successToast;

    // ----- Cart Elements -----
    @FindBy(id = "cart-summary")
    WebElement cartSummary;

    @FindBy(css = "[data-testid^='cart-item-']")
    List<WebElement> cartItems;

    @FindBy(id = "place-order-btn")
    WebElement placeOrderBtn;

    // ----- Tab & Wizard Elements -----
    @FindBy(id = "tab-btn-web")
    WebElement webTab;

    @FindBy(css = "[id^='tab-btn-']")
    List<WebElement> allTabs;

    @FindBy(css = "[data-testid='wizard-step-indicator']")
    WebElement wizardStepIndicator;

    // ----- Helper Methods -----
    private void waitAndScroll(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    // ----- Form Handling -----
    public void fillProductDetails(String deviceType, String brand, String storage, String color, int quantity) {
        waitAndScroll(deviceTypeSelect);
        new Select(deviceTypeSelect).selectByVisibleText(deviceType);
        new Select(brandSelect).selectByVisibleText(brand);
        new Select(colorSelect).selectByVisibleText(color);

        switch (storage) {
            case "64GB" -> wait.until(ExpectedConditions.elementToBeClickable(storage64Select)).click();
            case "128GB" -> wait.until(ExpectedConditions.elementToBeClickable(storage128Select)).click();
            case "256GB" -> wait.until(ExpectedConditions.elementToBeClickable(storage256Select)).click();
            default -> throw new IllegalArgumentException("❌ Unknown storage: " + storage);
        }

        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void clickConfirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPurchaseBtn)).click();
        try {
            wait.until(ExpectedConditions.visibilityOf(successToast));
        } catch (TimeoutException ignored) {
            // In some UI runs, toast may vanish quickly – safely ignore
        }
    }

    public void assertFormReset() {
        waitAndScroll(deviceTypeSelect);
        String selectedType = new Select(deviceTypeSelect).getFirstSelectedOption().getText();
        String selectedBrand = new Select(brandSelect).getFirstSelectedOption().getText();
        String selectedColor = new Select(colorSelect).getFirstSelectedOption().getText();
        String quantity = quantityInput.getAttribute("value");

        Assert.assertTrue(selectedType.isEmpty() || selectedType.equalsIgnoreCase("Select..."), "❌ Device Type not reset!");
        Assert.assertTrue(selectedBrand.isEmpty() || selectedBrand.equalsIgnoreCase("Select..."), "❌ Brand not reset!");
        Assert.assertTrue(selectedColor.isEmpty() || selectedColor.equalsIgnoreCase("Select..."), "❌ Color not reset!");
        Assert.assertTrue(quantity.equals("1") || quantity.isEmpty(), "❌ Quantity not reset!");
    }

    // ----- Cart Methods -----
    public void placeCartOrder() {
        waitAndScroll(cartSummary);
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        wait.until(ExpectedConditions.invisibilityOf(cartSummary));
    }

    public void assertCartEmpty() {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.cssSelector("[data-testid^='cart-item-']"), 1));
        } catch (TimeoutException e) {
            Assert.assertTrue(cartItems.isEmpty(), "❌ Cart not empty after order!");
        }
    }

    // ----- Navigation & Wizard -----
    public void navigateToTab(String tabName) {
        for (WebElement tab : allTabs) {
            if (tab.getText().trim().equalsIgnoreCase(tabName)) {
                waitAndScroll(tab);
                wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
                return;
            }
        }
        Assert.fail("❌ Tab not found: " + tabName);
    }

    public void navigateBackToWebTab() {
        waitAndScroll(webTab);
        wait.until(ExpectedConditions.elementToBeClickable(webTab)).click();
    }

    public void assertWizardResetToStep1() {
        waitAndScroll(wizardStepIndicator);
        String stepText = wizardStepIndicator.getText().trim();
        Assert.assertTrue(stepText.contains("Step 1"), "❌ Wizard not reset to Step 1!");
    }
}
