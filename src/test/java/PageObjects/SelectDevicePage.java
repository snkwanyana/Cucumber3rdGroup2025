package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectDevicePage {


    @FindBy(id = "tab-btn-web")
    WebElement practiceTab_id;

    public static WebDriver driver;
    //WebDriver driver;

    @FindBy(id = "deviceType")
    WebElement devicetype_id;

    @FindBy(id = "brand")
    WebElement brand_id;

    @FindBy(xpath = "//*[@id='storage-128GB']")

    WebElement storage_128GB_id;

    @FindBy(id ="address")
    WebElement addressField_id;

    @FindBy(id = "quantity")
    WebElement quantity_id;

    public SelectDevicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebAutomationAdvance() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(practiceTab_id));
        practiceTab_id.click();
    }


    public void selectDropdown(String tablet) {
        WebElement dropdownElement = driver.findElement(By.id("deviceType"));
        Select deviceDropdown = new Select(dropdownElement);
        deviceDropdown.selectByVisibleText(tablet);
    }

    public void selectBrand(String brand) {
        WebElement brandElement = driver.findElement(By.id("brand"));
        Select brandDropdown = new Select(brandElement);
        brandDropdown.selectByVisibleText(brand);
    }


    public void clickStorage() {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement storageOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='storage-128GB']")));
            storageOption.click();

        }

        public void selectColor(String color) {
            WebElement colorElement = driver.findElement(By.id("color"));
            Select colorDropdown = new Select(colorElement);
            colorDropdown.selectByVisibleText(color);
        }

        public void inputquality(String quality) {
            //WebElement quantityElement = driver.findElement(By.id("quantity"));
            quantity_id.clear();
            quantity_id.sendKeys(quality);

        }

    public  void enterDeliveryemailadd(String emailadd) {
        addressField_id.clear();
        addressField_id.sendKeys(emailadd.trim());


    }
// Validate the subtotal
public void validatePriceCalculation() {
    WebElement unitPriceElement = driver.findElement(By.id("unit-price-label"));
    WebElement quantityElement = driver.findElement(By.id("quantity-label"));
    WebElement subtotalElement = driver.findElement(By.id("subtotal-label"));

    String unitPriceText = unitPriceElement.getText().replaceAll("[^\\d.]", "").trim();
//    String quantityText = quantityElement.getText().trim();
    String quantityText = quantityElement.getText().replace("Qty:", "").trim();
    String subtotalText = subtotalElement.getText().replace("R", "").replace("Subtotal:", "").trim();

    if (unitPriceText.isEmpty() || subtotalText.isEmpty()) {
        throw new IllegalStateException("Price or subtotal text is empty. Cannot perform calculation.");
    }

    double unitPrice = Double.parseDouble(unitPriceText);
    int quantity = Integer.parseInt(quantityText);
    double subtotal = Double.parseDouble(subtotalText);

    double expectedSubtotal = unitPrice * quantity;

    Assert.assertEquals("Subtotal calculation mismatch", expectedSubtotal, subtotal, 0.01);
    //System.out.println("Current Price is: " + subtotal);
    System.out.println("Unit Price Text: '" + unitPriceText + "'");
    System.out.println("Quantity Text: '" + quantityText + "'");
    System.out.println("Subtotal Text: '" + subtotalText + "'");
}


    public  void clickNextButton() {
        WebElement nextButton = driver.findElement(By.id("inventory-next-btn"));
        nextButton.click();

    }
    }
