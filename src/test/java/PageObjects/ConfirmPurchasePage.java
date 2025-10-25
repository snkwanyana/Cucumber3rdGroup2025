package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;

public class ConfirmPurchasePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ConfirmPurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ----- Form Elements -----
    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect;

    @FindBy(id = "brand")
    WebElement brandSelect;

    @FindBy(id = "color")
    WebElement colorSelect;

    @FindBy(id = "quantity")
    WebElement quantityInput;

    @FindBy(id = "storage-64GB")
    WebElement storage64Select;

    @FindBy(id = "storage-128GB")
    WebElement storage128Select;

    @FindBy(id = "storage-256GB")
    WebElement storage256Select;

    @FindBy(id = "purchase-device-btn")
    WebElement confirmPurchaseBtn;

    @FindBy(id = "purchase-success-toast")
    WebElement successToast;

    // ================= METHODS ================= //

    public void fillProductDetails(String deviceType, String brand, String storage, String color, int quantity) {
        new Select(deviceTypeSelect).selectByVisibleText(deviceType);
        new Select(brandSelect).selectByVisibleText(brand);
        new Select(colorSelect).selectByVisibleText(color);

        switch (storage) {
            case "64GB": wait.until(ExpectedConditions.elementToBeClickable(storage64Select)).click(); break;
            case "128GB": wait.until(ExpectedConditions.elementToBeClickable(storage128Select)).click(); break;
            case "256GB": wait.until(ExpectedConditions.elementToBeClickable(storage256Select)).click(); break;
        }

        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void clickConfirmPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmPurchaseBtn)).click();
        try {
            wait.until(ExpectedConditions.visibilityOf(successToast));
        } catch (TimeoutException ignored) {}
    }

    public void assertFormReset() {
        wait.until(ExpectedConditions.visibilityOf(deviceTypeSelect));

        String selectedType = new Select(deviceTypeSelect).getFirstSelectedOption().getText();
        String selectedBrand = new Select(brandSelect).getFirstSelectedOption().getText();
        String selectedColor = new Select(colorSelect).getFirstSelectedOption().getText();
        String quantity = quantityInput.getAttribute("value");

        Assert.assertTrue(selectedType.isEmpty() || selectedType.equals("Select..."), "❌ Device Type not reset!");
        Assert.assertTrue(selectedBrand.isEmpty() || selectedBrand.equals("Select..."), "❌ Brand not reset!");
        Assert.assertTrue(selectedColor.isEmpty() || selectedColor.equals("Select..."), "❌ Color not reset!");
        Assert.assertTrue(quantity.equals("1") || quantity.isEmpty(), "❌ Quantity not reset!");
    }
}
