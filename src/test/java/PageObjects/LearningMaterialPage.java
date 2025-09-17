package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utils.BrowserFactory.driver;

public class LearningMaterialPage {
    @FindBy(id = "tab-btn-web")
    WebElement Webautomation_id;

    @FindBy(id = "deviceType")
    WebElement DeviceType_id;

    @FindBy(id = "storage-64GB")
    WebElement storage64GB_id;

    @FindBy(id = "storage-128GB")
    WebElement storage128GB_id;

    @FindBy(id = "storage-256GB")
    WebElement storage256GB_id;

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
    WebElement discountcode_id;

    @FindBy(id = "apply-discount-btn")
    WebElement applydiscountcode_id;

    @FindBy(id = "inventory-back-btn")
    WebElement backbtn_id;

    @FindBy(id = "purchase-device-btn")
    WebElement confirmpurchasebtn_id;

    @FindBy(id = "add-to-cart-btn")
    WebElement addtocartbtn_id;

    @FindBy(id = "logout-btn")
    WebElement logoutbtn_id;

    public void ClickWebAutomation() throws InterruptedException {
//
        Thread.sleep(6000);
        Webautomation_id.click();

    }

    public void SelectDeviceType(String visibleText) {
        Select select = new Select(DeviceType_id);
        select.selectByVisibleText(visibleText);

    }

        public void SelectStorage (String storage){
            switch (storage) {
                case "64GB":
                    storage64GB_id.click();
                    break;
                case "128GB":
                    storage128GB_id.click();
                    break;
                case "256GB":
                    storage256GB_id.click();
                    break;
                default:
                    System.out.println("Invalid storage option");
            }
        }

        public void SelectBrand (String visibleText){
            Select select = new Select(Brand_id);
            select.selectByVisibleText(visibleText);
        }

        public void SelectColor (String color){
            color_id.sendKeys(color);
        }

        public void EnterQuantity (String quantity){
        quantity_id.clear();
        quantity_id.sendKeys(quantity);
        }

        public void EnterDeleveryAddress (String address){
            deleveryAddress_id.sendKeys(address);
        }
        public void ClickInventoryNextButton () {
            inventoryNextbtn_id.click();
        }
        public void enterDiscountCode (String code){
            discountcode_id.sendKeys(code);
        }
        public void ClickApplyDiscountButton () {
            applydiscountcode_id.click();
        }
        public void ClickBackButton () {
            backbtn_id.click();
        }
        public void ClickConfirmPurchaseButton () {
            confirmpurchasebtn_id.click();
        }
        public void ClickAddToCartButton () {
            addtocartbtn_id.click();
        }
        public void logoutbtn_idDisplayed () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.valueOf(logoutbtn_id)))).getText();
            String elem = logoutbtn_id.getText();
            if (elem.equals("Log Out")) {
                System.out.println("User is successfully logged in and see practice page");
            } else {
                System.out.println("User is not logged in");
            }

        }

}