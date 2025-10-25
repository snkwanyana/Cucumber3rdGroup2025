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

public class WizardStep1Page {

    private WebDriver driver;
    private WebDriverWait wait;

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

    @FindBy(id = "nextStepBtn")
    WebElement nextButton;

    @FindBy(id = "errorSummary")
    WebElement errorSummary;

    @FindBy(css = ".success-toast")
    WebElement successMessage; // for successful order

    public WizardStep1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectDeviceType(String deviceType) {
        if (!deviceType.isEmpty()) {
            new Select(deviceTypeSelect).selectByVisibleText(deviceType);
        }
    }

    public void selectBrand(String brand) {
        if (!brand.isEmpty()) {
            new Select(brandSelect).selectByVisibleText(brand);
        }
    }

    public void selectStorage(String storage) {
        if (!storage.isEmpty()) {
            new Select(storageSelect).selectByVisibleText(storage);
        }
    }

    public void setQuantity(int quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void enterDeliveryAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void clickPurchaseDevice(String expectedResult) {
        // If NextDisabled scenario, just check the button is disabled
        if ("NextDisabled".equalsIgnoreCase(expectedResult)) {
            Assert.assertFalse(nextButton.isEnabled(), "Next button should be disabled!");
        } else {
            nextButton.click();
        }
    }

    public void confirmErrorMessage(String expectedMessage) {
        if ("Order placed successfully!".equalsIgnoreCase(expectedMessage)) {
            // wait for toast
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            Assert.assertEquals(successMessage.getText().trim(), expectedMessage);
        } else if (expectedMessage.contains("QUANTITY MUST")) {
            wait.until(ExpectedConditions.visibilityOf(errorSummary));
            Assert.assertEquals(errorSummary.getText().trim(), expectedMessage);
        }
    }

    public void assertFormReset() {
        // Reset checks: fields should be blank/default
        Assert.assertEquals(new Select(deviceTypeSelect).getFirstSelectedOption().getText(), "");
        Assert.assertEquals(new Select(brandSelect).getFirstSelectedOption().getText(), "");
        Assert.assertEquals(new Select(storageSelect).getFirstSelectedOption().getText(), "");
        Assert.assertEquals(quantityInput.getAttribute("value"), "");
        Assert.assertEquals(addressInput.getAttribute("value"), "");
    }
}
