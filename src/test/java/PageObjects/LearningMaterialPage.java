package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearningMaterialPage {
    @FindBy(id = "tab-btn-web")
    WebElement Webautomation_id;

    @FindBy(id = "deviceType")
    WebElement DeviceType_id;

    @FindBy(id = "storage-64GB")
    WebElement Storage1_id;

    @FindBy(id = "storage-128GB")
    WebElement Storage2_id;

    @FindBy(id = "storage-256GB")
    WebElement Storage3_id;

    @FindBy(id = "brand")
    WebElement Brand_id;

    @FindBy(id = "color")
    WebElement color_id;


    @FindBy(id = "quantity")
    WebElement quantity_id;

    @FindBy(id = "address")
    WebElement deleveryAddress_id;

    @FindBy(id = "inventory-next-btn")
    WebElement inventoryNextbtn_id;

    @FindBy(id = "discount-code")
    WebElement ddiscountcode_id;

    @FindBy(id = "apply-discount-btn")
    WebElement applydiscountcode_id;

    @FindBy(id = "inventory-back-btn")
    WebElement backbtn_id;

    @FindBy(id = "purchase-device-btn")
    WebElement confirmpurchasebtn_id;

    @FindBy(id = "add-to-cart-btn")
    WebElement addtocartbtn_id;
}