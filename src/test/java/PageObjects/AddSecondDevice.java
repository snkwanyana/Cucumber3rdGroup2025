package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddSecondDevice {



    public static WebDriver driver;
    public AddSecondDevice(WebDriver driver) {
        this.driver = driver;

    }

    @FindBy(id = "deviceType")
    WebElement devicestype_id;

    @FindBy(id = "brand")
    WebElement brands_id;

    @FindBy(id = "storage-256GB" )
    WebElement storage_256GB_id;

    @FindBy(id = "color")
    WebElement colorwhite_id;

    @FindBy(id = "quantity" )
    WebElement quantity2_id;

    @FindBy(id = "address")
    WebElement deliveryaddressField_id;

    @FindBy(id = "unit-price-value")
    WebElement currentprice_id;

    @FindBy(id ="subtotal-value")
    WebElement subtotalprice_id;


  public void selectDeviceType(String laptop) {
        WebElement dropdownElement = driver.findElement(By.id("deviceType"));
        Select deviceDropdown = new Select(dropdownElement);
        deviceDropdown.selectByVisibleText(laptop);
    }

    public void selectdeviceBrand(String deviebrand) {
        WebElement dropdownElement = driver.findElement(By.id("brand"));
        Select deviceDropdown = new Select(dropdownElement);
        deviceDropdown.selectByVisibleText(deviebrand);
    }

    public void selectdeviceStorage256GB() {
        storage_256GB_id.click();
    }

    public void selectdeviceColorWhite(String colors) {
        WebElement dropdownElement = driver.findElement(By.id("color"));
        Select deviceDropdown = new Select(dropdownElement);
        deviceDropdown.selectByVisibleText(colors);
    }

    public void enterdeviceQuantity2(String quantity2) {
        quantity2_id.clear();
        quantity2_id.sendKeys(quantity2.trim());
    }

    public void enterdeviceDeliveryAddress(String deliveryaddress) {
        deliveryaddressField_id.clear();
        deliveryaddressField_id.sendKeys(deliveryaddress.trim());
    }


    public  void confirmdeviceCurrentPrice() {
        WebElement currentPriceElement = driver.findElement(By.id("unit-price-value"));
        WebElement QuantityElement = driver.findElement(By.id("quantity"));
        WebElement subtotalPriceElement = driver.findElement(By.id("subtotal-value"));

        String currentPrice = currentPriceElement.getText();
        System.out.println ("Unit Price: " + currentPrice);

        String currentQuantity = QuantityElement.getText();
        System.out.println("QTY: " + currentQuantity);

        String subtotalPrice = subtotalPriceElement.getText();
        System.out.println("Subtotal Price: " + subtotalPrice);


    }




}
