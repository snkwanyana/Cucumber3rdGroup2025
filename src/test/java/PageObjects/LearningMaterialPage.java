package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

    @FindBy(id = "breakdown-shipping-value")
    static WebElement Shipment_id;

    @FindBy(id = "shipping-option-standard")
    static WebElement Standard_id;

    @FindBy(id = "shipping-option-express")
    static WebElement express_id;
    @FindBy(id = "discount-feedback")
    static WebElement discountfeedback_id;

    @FindBy(id = "add-to-cart-btn")
    static WebElement addtoCart_id;

    @FindBy(id = "confirm-cart-btn")
    static WebElement placeorderbtn_id;

 @FindBy(id = "review-cart-btn")
    static WebElement reviecartbtn_id;


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

    public void ClickLogoutButton() throws InterruptedException {
        Thread.sleep(8000);
        logoutbtn_id.click();
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public static void selectShippingOption(String option) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        String labelId;
        String readableName;

        switch (option.toLowerCase()) {
            case "standard":
                // Use the data-testid from the <label>  shipping-section
                labelId = "shipping-option-standard";
                readableName = "Standard";
                break;
            case "express":
                // Use the data-testid from the <label>
                labelId = "shipping-option-express";
                readableName = "Express (+R25)";
                break;
            default:
                System.err.println("Invalid shipping option specified: " + option + ". Must be 'standard' or 'express'.");
                return;
        }

        try {
            // Locate the <label> element using its data-testid attribute
            WebElement shippingLabel = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("label[data-testid='" + labelId + "']"))
            );

            // Click the label, which usually triggers the radio button selection
            shippingLabel.click();
            System.out.println("✅ Successfully selected the '" + readableName + "' shipping option by clicking its label.");

            // Optional: Verify the underlying radio button is selected
            WebElement radioButton = driver.findElement(By.id("shipping-" + option.toLowerCase()));
            if (radioButton.isSelected()) {
                System.out.println("   Verification passed: Radio button is checked.");
            } else {
                System.out.println("   Verification failed: Radio button is NOT checked.");
            }

        } catch (Exception e) {
            System.err.println("❌ Failed to select the shipping option: " + e.getMessage());
            e.printStackTrace();
        }


//    public void verifyExpressShipmentIs25() {
//        // Click the Express radio button
//        express_id.click();
//
//        // Wait for the shipment value to be visible and updated
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        String shipmentValue = wait.until(ExpectedConditions.visibilityOf(Shipment_id)).getText().trim();
//
//        // Assert the shipment value is "R25"
//        Assert.assertEquals(shipmentValue, "R25", "Shipment value should be R25 when Express is selected.");
//    }
    }
    public void DiscountFeedback(String msgFeedback) {
        String feedback = discountfeedback_id.getText();
        Assert.assertEquals(feedback, msgFeedback);
    }
    public  void ClickAddToCart() {
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
        placeorderbtn_id.click();

    }
}











