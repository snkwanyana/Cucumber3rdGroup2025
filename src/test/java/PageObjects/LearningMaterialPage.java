package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

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

    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[3]/div")
    WebElement Storage_xpath;


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

    @FindBy(id = "logout-button")
    WebElement logoutbtn_id;

    @FindBy(id = "practice-heading")
    WebElement practice_id;

    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/div[1]/h4")
    WebElement successmsg_id;

    @FindBy(xpath = "//*[@id=\"inventory-form-grid\"]/div[6]/div/span")
    WebElement quantityErrorMsg_xpath;

    @FindBy(id = "unit-price-label")
    WebElement unitprice_id;

    @FindBy(id = "subtotal-label")
    WebElement subtotal_id;

    @FindBy(id = "breakdown-total-value")
    WebElement discountTotal_id;

    @FindBy(id = "breakdown-total-value")
    WebElement Discount_id;

    @FindBy(id = "shipping-options")
    WebElement ShippingOptions_id;

    @FindBy(id = "warranty-options")
    WebElement warrantyOptions_id;
    @FindBy(xpath = "//*[@id=\"shipping-option-express\"]")
    static WebElement experes_xpath;
    @FindBy(id = "cancel-cart-btn")
    static WebElement Cancelcart_id;

    @FindBy(id = "//input[@type='radio' and @value='express' and @name='shippingMethod']")
    static WebElement Shipment_id;

    @FindBy(id = "shipping-option-standard")
    static WebElement Standard_id;

    @FindBy(css = "div[data-testid='shipping-options']")
    static WebElement shipmentOptions_css;

    @FindBy(xpath = "//label[@data-testid='shipping-option-express']/input[@type='radio']")
    static WebElement express_xpath;

    @FindBy(id = "discount-feedback")
    static WebElement discountfeedback_id;

    @FindBy(id = "add-to-cart-btn")
    static WebElement addtoCart_id;

    @FindBy(id = "confirm-cart-btn")
    static WebElement placeorderbtn_id;

    @FindBy(id = "review-cart-btn")
    static WebElement reviecartbtn_id;


    @FindBy(xpath = "//button[starts-with(@id, 'cart-item-remove-')]")
    static WebElement removeitembtn_xpath;

    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/p[1]")
    static WebElement OrderSuccessmessage_xpath;
    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/div[2]/p")
    WebElement Orderdetails_xpath;

    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/p[2]")
    WebElement Totalonsuccessorder_xpath;
    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/div[1]/button")
    WebElement Tclosebtnonsuccess_xpath;
    @FindBy(id = "invoices-toggle-btn")
    WebElement ViewInvoicesbtn_id;

    @FindBy(xpath = "//button[text()='\uD83D\uDC41\uFE0F View']")
    WebElement ViewinvoiceOnHistory_xpath;
    @FindBy(xpath = "//button[contains(text(), 'Save as PDF')]")
    WebElement SaveAsPdf_xpath;
    @FindBy(xpath = "//*[@id=\"purchase-success-toast\"]/div[3]/p")
    WebElement TimeStampOnSuccess_xpath;
    @FindBy(id = "view-history-btn")
    WebElement ViewInvo_id;

    @FindBy(id = "close-invoice-history-btn")
    WebElement CloseinvoiceHistorybtn_id;

    @FindBy(id = "warranty-option-1yr")
    WebElement warrantyoption1yr_id;

    @FindBy(id = "warranty-option-2yr")
    WebElement warrantyoption2yr_id;
    @FindBy(id = "breakdown-warranty-value")
    WebElement warrant_id;


    public boolean isTabVisible(By uniqueElementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(uniqueElementLocator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public By getWebautomationId() {
        return (By) Webautomation_id;
    }

    public void VerifyPracticeTextAppeared() throws InterruptedException {
        Thread.sleep(7000);
        String elem = practice_id.getText();
        if (elem.equals("Practice Page")) {
            System.out.println("Welcome back, Tester!");
        } else {
            System.out.println("User is not logged in");
        }
    }

    public void ClickLogoutBtn() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(logoutbtn_id));
        logoutbtn_id.click();
    }

    public void ClickCancelCartButton() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(Cancelcart_id));
        Cancelcart_id.click();
    }

    public void VerifyCancelcardisvisible() {
        boolean isVisible = Cancelcart_id.isDisplayed();
        Assert.assertTrue(isVisible, "Cancel Cart button should be visible.");
    }

    public void verifyreviewcartisvisible() {
        boolean isVisible = reviecartbtn_id.isDisplayed();
        Assert.assertTrue(isVisible, "Review Cart button should be visible.");
    }

    public void verifyplaceorderisvisible() {
        boolean isVisible = placeorderbtn_id.isDisplayed();
        Assert.assertTrue(isVisible, "Place Order button should be visible.");
    }

    public void ClickWebAutomation() throws InterruptedException {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(Webautomation_id));
        Webautomation_id.click();

    }

    public boolean isDeviceTypeSelected(String expectedValue) {
        Select select = new Select(DeviceType_id);
        String selectedOption = select.getFirstSelectedOption().getText();
        return selectedOption.equals(expectedValue);
    }

    public void SelectDeviceType(String visibleText) {

        Select select = new Select(DeviceType_id);
        select.selectByVisibleText(visibleText);

    }

    public void SelectStorage(String storage) {

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

    public void VerifyNoStorageselected() {
        List<WebElement> radioButtons = Collections.singletonList(Storage_xpath);

        boolean isOneSelected = false;
        for (WebElement radio : radioButtons) {
            if (radio.isSelected()) {
                isOneSelected = true;
                break;
            }
        }
        if (isOneSelected) {
            System.out.println("Success: At least one radio button is selected.");
        } else {
            System.out.println(" Failure: No radio button is selected.");
        }
    }

    public boolean isBrandSelected(String expectedValue) {
        Select select = new Select(Brand_id);
        String selectedOption = select.getFirstSelectedOption().getText();
        return selectedOption.equals(expectedValue);
    }

    public void VerifyNoBrandselected() {
        List<WebElement> radioButtons = Collections.singletonList(Brand_id);

        boolean isOneSelected = false;
        for (WebElement radio : radioButtons) {
            if (radio.isSelected()) {
                isOneSelected = true;
                break;
            }
        }
        if (isOneSelected) {
            System.out.println("Success: At least one radio button is selected.");
        } else {
            System.out.println(" Failure: No radio button is selected.");
        }
    }

    public void SelectBrand(String visibleText) {
        Select select = new Select(Brand_id);
        select.selectByVisibleText(visibleText);
    }

    public void SelectColor(String color) {
        color_id.sendKeys(color);
    }

    public void EnterQuantity(String quantity) {
        quantity_id.clear();
        String trimmedQuantity = quantity.trim();
        quantity_id.sendKeys(trimmedQuantity);
    }

    public void quantityErrorMsg(String errorMsg) {
        String error = quantityErrorMsg_xpath.getText();
        Assert.assertEquals(error, errorMsg);
    }

    public void EnterDeleveryAddress(String address) {
        deleveryAddress_id.sendKeys(address);
    }

    public void ClickInventoryNextButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(inventoryNextbtn_id));
        inventoryNextbtn_id.click();
    }

    public void enterDiscountCode(String code) {
        discountcode_id.sendKeys(code);
    }

    public void ClickApplyDiscountButton() {
        applydiscountcode_id.click();
    }

    public void ClickBackButton() {
        backbtn_id.click();
    }

    public void ClickConfirmPurchaseButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(confirmpurchasebtn_id));
        confirmpurchasebtn_id.click();
    }

    public void ClickAddToCartButton() {
        addtocartbtn_id.click();
    }

    public void verifysuccespurchase() throws InterruptedException {
        Thread.sleep(5000);
        String elem = successmsg_id.getText();
        if (elem.equals("Success!")) {
            System.out.println("Purchase completed successfully");
        } else {
            System.out.println("Purchase not completed");
        }
    }

    public void verifyOrderSuccessMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(OrderSuccessmessage_xpath));
        String actualMessage = OrderSuccessmessage_xpath.getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, "Order success message should match.");
    }

    public void UnitPriceVerification() {
        String fullUnitText = unitprice_id.getText().trim();
        String unitText = fullUnitText.split(":")[1].trim();
        System.out.println("Actual Unit text: " + unitText);
        //String expectedDash = unitText;
        if (unitText.equals("-")) {
            System.out.println("The Unit price field is a dash when no options are selected.");
        } else {
            System.out.println("The Unit price field is not a dash when no options are selected.");
        }


    }

    public void SubVerification() {
        String fullUnitText = subtotal_id.getText().trim();
        String subtext = fullUnitText.split(":")[1].trim();
        System.out.println("Actual subtotal text: " + subtext);
        if (subtext.equals("-")) {
            System.out.println("The Subtotal field is a dash when no options are selected.");
        } else {
            System.out.println("The Subtotal field is not a dash when no options are selected.");


        }
    }


    public void DiscountFeedback(String msgFeedback) {
        String feedback = discountfeedback_id.getText();
        Assert.assertEquals(feedback, msgFeedback);
    }

    public void ClickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addtoCart_id));
        addtoCart_id.click();
    }

    public void ClickReviewCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(reviecartbtn_id));
        reviecartbtn_id.click();
    }

    public void ClickPlaceOrderButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(placeorderbtn_id));
        Actions actions = new Actions(driver);
        actions.doubleClick(placeorderbtn_id).perform();

    }

    public void ClickRemoveItemButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(removeitembtn_xpath));
        removeitembtn_xpath.click();
    }

    @FindBy(xpath = "//div[starts-with(@id, 'cart-item-total-')]")
    WebElement TotalTokeep_xpath;

    @FindBy(id = "cart-grand-total-value")
    WebElement GrandTotal_id;

    public void verifyGrandTotalUpdateAfterRemoval() {
        String totalText = TotalTokeep_xpath.getText().trim();
        String grandTotalText = GrandTotal_id.getText().trim();
        Assert.assertEquals(grandTotalText, totalText, "Grand Total should update correctly after item removal.");
        System.out.println("Grand Total after item removal: " + totalText);
    }

    public void clickshipmentOptions() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(shipmentOptions_css));
        shipmentOptions_css.click();
    }

    public void SelectShipmentmethod(String shipment) {

        switch (shipment) {
            case "Standard":
                Standard_id.click();
                break;
            case "Express":
                express_xpath.click();
                break;
            default:
                System.out.println("Invalid option option");
        }
    }

    public void SelectWarrantyOption(String warranty) {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            switch (warranty) {
                case "1 Year":
                    wait.until(ExpectedConditions.visibilityOf(warrantyoption1yr_id));
                    warrantyoption1yr_id.click();
                    break;
                case "2 Year":
                    wait.until(ExpectedConditions.visibilityOf(warrantyoption2yr_id));
                    warrantyoption2yr_id.click();
                    break;
                default:
                    System.out.println("Invalid option option");
            }
    }

    public void VerifyWarrantyPrice() {
        String warrantyText = warrant_id.getText().trim();
        System.out.println("Warranty price: " + warrantyText);

    }

    public void verifyorderdetailsisvisible() {
        boolean isVisible = Orderdetails_xpath.isDisplayed();
        Assert.assertTrue(isVisible, "Order details should be visible.");
    }

    public void verifytotalonsuccessorderisvisible() {
        boolean isVisible = Totalonsuccessorder_xpath.isDisplayed();
        Assert.assertTrue(isVisible, "Total on success order should be visible.");
    }

    public void ClickTclosebtnonsuccess() {
        Tclosebtnonsuccess_xpath.click();
    }

    public void ClickViewInvoicesbtn() {
        ViewInvoicesbtn_id.click();
    }

    public void verifyTimestampOnSuccessisvisible() {
        boolean isVisible = TimeStampOnSuccess_xpath.isDisplayed();
        Assert.assertTrue(isVisible, "Timestamp on success order should be visible.");
    }

    public void ClickViewinvoiceOnHistory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ViewInvo_id));
        ViewInvo_id.click();
    }

    public void ClickCloseinvoiceHistorybtn() {
        CloseinvoiceHistorybtn_id.click();
    }

    public void Verifyshipingprice() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOf(express_xpath));
        String shippingText = express_xpath.getText().trim();
        System.out.println("Shipping price: " + shippingText);
    }
}













