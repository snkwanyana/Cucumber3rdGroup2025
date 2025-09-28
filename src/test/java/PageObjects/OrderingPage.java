package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderingPage {

    WebDriver driver;

    // Device Type dropdown
    @FindBy(id = "deviceType")
    WebElement deviceType;

    // Brand dropdown
    @FindBy(id = "brand")
    WebElement brand;

    // Storage radio buttons
    @FindBy(id = "storage-64GB")
    WebElement storage64GB;

    @FindBy(id = "storage-128GB")
    WebElement storage128GB;

    @FindBy(id = "storage-256GB")
    WebElement storage256GB;

    // Color dropdown
    @FindBy(id = "color")
    WebElement color;

    // Quantity input
    @FindBy(id = "quantity")
    WebElement quantity;

    // Address input
    @FindBy(id = "address")
    WebElement address;

    // Pricing summary
    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    @FindBy(id = "quantity-value")
    WebElement quantityValue;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;

    // Next button
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;
/*No device → Select a device type
Device chosen, no brand → Select a brand
No storage → Choose storage size
Quantity 0 / blank → Quantity must be ≥ 1
Quantity 11 → Quantity must be ≤ 10
Address blank → Address required
All corrected + Next → Step 2 shown.*/

    // --- Interaction methods ---


    public void selectDeviceType(String type) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        new Select(deviceType).selectByVisibleText(type);
    }

    public void selectBrand(String brandName) {
        new Select(brand).selectByVisibleText(brandName);
    }

    public void selectStorage(String size) {
        switch (size) {
            case "64GB":
                storage64GB.click();
                break;
            case "128GB":
                storage128GB.click();
                break;
            case "256GB":
                storage256GB.click();
                break;
        }
    }

    public void selectColor(String colorName) {
        new Select(color).selectByVisibleText(colorName);
    }

    public void setQuantity(int qty) {
        quantity.clear();
        quantity.sendKeys(String.valueOf(qty));
    }

    public void setAddress(String addr) {
        address.clear();
        address.sendKeys(addr);
    }

    public String getUnitPrice() {

        return unitPriceValue.getText();
    }

    public String getQuantityValue() {

        return quantityValue.getText();
    }

    public String getSubtotal() {

        return subtotalValue.getText();
    }

    public void clickNext() {

        nextButton.click();
    }


}
