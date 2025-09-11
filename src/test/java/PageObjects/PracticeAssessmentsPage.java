package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public PracticeAssessmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitUntilLogoutButtonIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(logout_id));
        Assert.assertTrue(logout_id.isDisplayed(), "Logout button is NOT displayed!");
    }

    public void clickLogoutButton() {
        logout_id.click();
    }

    public void clickWebAutomation() {
        wait.until(ExpectedConditions.elementToBeClickable(WebAutomation_id)).click();
    }

    public void selectDeviceType(String deviceType) {
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

    public void selectBrand(String brand) {
        new Select(brandSelect).selectByVisibleText(brand);
    }

    public void selectStorage(String storage) {
        switch (storage) {
            case "64GB": storage64Select.click(); break;
            case "128GB": storage128Select.click(); break;
            case "256GB": storage256Select.click(); break;
        }
    }

    public void selectColor(String color) {
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

    public void clickPurchaseDevice() {
        purchaseButton.click();
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
}
