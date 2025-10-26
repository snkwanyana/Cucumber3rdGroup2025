package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    // Next button
    @FindBy(id = "inventory-next-btn")
    WebElement nextButton;


    // --- Interaction methods ---


    public void selectDeviceType(String type) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new Select(deviceType).selectByVisibleText(type);
        // Wait for the brand dropdown to show expected options for the selected device type
        wait.until(d -> {
            Select brandSelect = new Select(brand);
            java.util.List<String> options = new java.util.ArrayList<>();
            for (org.openqa.selenium.WebElement option : brandSelect.getOptions()) {
                options.add(option.getText().toLowerCase());
            }
            if (type.equalsIgnoreCase("Phone")) {
                return options.contains("apple") && options.contains("samsung") && options.contains("xiaomi") && options.contains("other");
            } else if (type.equalsIgnoreCase("Laptop")) {
                return options.contains("macbook pro") && options.contains("macbook air") && options.contains("other");
            }
            return options.size() > 1; // fallback for other device types
        });
    }

    public void selectBrand(String brandName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(brand));
        wait.until(ExpectedConditions.elementToBeClickable(brand));
        // Wait for the dropdown to have more than one option (indicating refresh)
        wait.until(d -> {
            Select brandSelect = new Select(brand);
            return brandSelect.getOptions().size() > 1;
        });
        // Wait for the desired brand option to appear
        wait.until(d -> {
            Select brandSelect = new Select(brand);
            return brandSelect.getOptions().stream().anyMatch(option -> option.getText().equalsIgnoreCase(brandName));
        });
        Select brandSelect = new Select(brand);
        brandSelect.selectByVisibleText(brandName);
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

    public void clickNext() {

        nextButton.click();
    }


}
