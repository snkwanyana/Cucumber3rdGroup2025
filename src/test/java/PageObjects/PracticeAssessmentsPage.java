package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class PracticeAssessmentsPage {
    WebDriver driver;

    public PracticeAssessmentsPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "deviceType")
    WebElement deviceType_id;

    @FindBy(id = "brand")
    WebElement Brand_id;

    @FindBy(id = "storage-64GB")
    WebElement storage64_id;

    @FindBy(id = "storage-128GB")
    WebElement storage128_id;

    @FindBy(id = "storage-256GB")
    WebElement storage256_id;

    @FindBy(id = "color")
    WebElement color_id;

    @FindBy(id = "quantity")
    WebElement quantity_id;

    @FindBy(id = "address")
    WebElement address_id;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton_id;

    @FindBy(xpath = "//*[@id=\"step1-pricing-summary\"]/div/div[2]/span[1]/text()[1]")
    WebElement unitPrice_id;

    @FindBy(xpath = "//*[@id=\"step1-pricing-summary\"]/div/div[2]/span[2]/text()[1]")
    WebElement qty_id;

    @FindBy(xpath = "//*[@id=\"step1-pricing-summary\"]/div/div[2]/span[3]/text()[1]")
    WebElement subTot_id;



    public void selectDeviceType(String deviceType) {
        deviceType_id.click();
        Select select = new Select(deviceType_id);
        select.selectByVisibleText(deviceType);
    }

    public void selectBrand(String brand) {
        Brand_id.click();
        Select select = new Select(Brand_id);
        select.selectByVisibleText(brand);
    }

    public void selectStorage64(String storage) {
        storage64_id.click();
    }

    public void selectStorage128(String storage) {
        storage128_id.click();
    }

    public void selectStorage256(String storage) {
        storage256_id.click();
    }

    public void selectColor(String color) {
        color_id.click();
        Select select = new Select(color_id);
        select.selectByVisibleText(color);
    }

    public void enterQuantity(String quantity) {
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
    }

    public void enterAddress(String address) {
        address_id.clear();
        address_id.sendKeys(address);
    }

    public void clickNextButton() {
        nextButton_id.click();
    }

    public void verifyPricingDetailsDisplayed() {
        if (deviceType_id.isSelected()) {
            System.out.println(unitPrice_id.getText() + qty_id.getText() + subTot_id.getText());
        } else if (deviceType_id.isSelected() && !quantity_id.getText().equalsIgnoreCase("")) {
            System.out.println(unitPrice_id.getText() + qty_id.getText() + subTot_id.getText());
        } else {
            System.out.println("Unit Price, Quantity and Sub Total are not displayed correctly");
        }
    }

}

