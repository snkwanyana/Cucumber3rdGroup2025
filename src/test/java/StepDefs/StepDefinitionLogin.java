package StepDefs;

import PageObjects.AddDeviceAfterRemoval;
import PageObjects.SelectDevicePage;
import Utils.Base;
import Utils.TabManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class StepDefinitionLogin extends Base {


    @Given("User is on the homepage")
    public void user_is_on_the_home_page() {
        loginPage.verifyLearnAutomationtheRightWayisDisplayed();
    }

    @When("User clicks on the learning material button")
    public void user_clicks_on_the_learning_material_button() {
        loginPage.clicklearningmaterialButton();
        Hooks.test.info("User clicks on the learning material button");
    }

    @And("User enters emailaddress {}")
    public void user_enters_emailaddress(String emailaddress) {
        loginPage.enterEmailAddress(emailaddress);
        Hooks.test.info("User enters emailaddress " + emailaddress);
    }

    @And("User enters password {}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
        Hooks.test.info("User enters password ******" );
    }


    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickloginButton();
        Hooks.test.info("User clicks on the login button");
    }

    @And("User clicks on About Us button")
    public void user_clicks_on_the_about_us_button() {
        loginPage.clickAboutUSbutton();
        Hooks.test.info("User clicks on About Us button");
    }

    @Then("User should see About Nkosi Cele")
    public void user_should_see_about_nkosi_cele() {
        loginPage.verifyAboutNkosiCeleisDisplayed();
        Hooks.test.info("User should see About Nkosi Cele");
    }

    @And("User clicks on learning material button")
    public void user_clicks_on_learning_material_button() {
        loginPage.clickslearningmaterialButton();
        Hooks.test.info("User clicks on learning material button");
    }

    @And("User is forced to login again")
    public void user_if_forced_to_login_again() {
        loginPage.login("Pretty25@gmail.com", "Password123");
        Hooks.test.info("User is forced to login again");
    }

    @And("User Clicks on Web Automation Advance")
    public void user_Clicks_on_Web_Automation_Advance() {
        selectDevicePage.clickWebAutomationAdvance();
        Hooks.test.info("User Clicks on Web Automation Advance");
    }


    @And("User select the device")
    public void user_select_the_device() {
        selectDevicePage.selectDropdown("Tablet");
        Hooks.test.info("User select the device");
    }

    @And("User Select the brand")
    public void user_select_the_brand() {
        selectDevicePage.selectBrand("Samsung");
        Hooks.test.info("User Select the brand");
    }

    @And("User select the storage")
    public void user_select_the_storage() {
        selectDevicePage.clickStorage();
        Hooks.test.info("User select the storage");
    }

    @And("User select the color")
    public void user_select_the_color() {
        selectDevicePage.selectColor("Gold");
        Hooks.test.info("User select the color");
    }

    @And("User select Quantity")
    public void user_select_the_quality() {
        selectDevicePage.inputquality("2");
        Hooks.test.info("User select Quantity");
    }

    @And("User enters Deliveryemailadd {}")
    public void andUserEntersDeliveryemailaddEmailaddressadd(String emailaddressadd) {
        selectDevicePage.enterDeliveryemailadd(emailaddressadd);
        Hooks.test.info("User enters Deliveryemailadd " + emailaddressadd);
    }

    @And("Calculate the total price")
    public void validatePriceCalculation() {
        selectDevicePage.validatePriceCalculation();
        Hooks.test.info("Calculate the total price");

    }

    @And("User clicks on the next button")
    public void user_clicks_on_the_next_button() {
        selectDevicePage.clickNextButton();
        Hooks.test.info("User clicks on the next button");
    }

    //add the extra page here
    @When("User clicks on the shipping method radio button")
    public void user_clicks_on_the_shipping_method_radio_button() {
        addExtrasPage.selectExpressShipping();
        Hooks.test.info("User clicks on the shipping method radio button");
    }

    @And("User clicks on warranty radio button")
    public void user_clicks_on_warranty_radio_button() {
        addExtrasPage.select2YearWarranty();
        Hooks.test.info("User clicks on warranty radio button");
    }

    @And("User enters discount code {}")
    public void user_enters_discount_code(String DiscountCode) {
        addExtrasPage.enterDiscountCode(DiscountCode);
        Hooks.test.info("User enters discount code " + DiscountCode);
    }

    @And("User reenters discount code {}")
    public void user_reenters_discount_code(String DiscountsCode) {
        addExtrasPage.reenterDiscountCode(DiscountsCode);
        Hooks.test.info("User reenters discount code " + DiscountsCode);
    }


    @And("User clicks on Apply button")
    public void user_clicks_on_apply_button() {
        addExtrasPage.clickApplyButton();
        Hooks.test.info("User clicks on Apply button");
    }

    @Then("User Verifies the discount is applied")

    public void user_verifies_the_discount_is_applied() {
        addExtrasPage.Verifiesdiscount();
        Hooks.test.info("User Verifies the discount is applied");
    }

    @And("User clicks on the Add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        addExtrasPage.clickAddToCartButton();
        Hooks.test.info("User clicks on the Add to cart button");
    }

    // Select Product from second device page
    @And("User select DeviceType")
    public void user_select_DeviceType() {
        addSecondDevice.selectDeviceType("Laptop");
        Hooks.test.info("User select DeviceType");
    }

    @And("User Select DeviceBrand")
    public void user_select_Brand() {
        addSecondDevice.selectdeviceBrand("Macbook pro");
        Hooks.test.info("User Select DeviceBrand");
    }

    @And("User Select deviceStorage")
    public void user_Select_deviceStorage() {
        addSecondDevice.selectdeviceStorage256GB();
        Hooks.test.info("User Select deviceStorage");
    }

    @And("User Select DeviceColor")
    public void user_Select_DeviceColor() {
        addSecondDevice.selectdeviceColorWhite("White");
        Hooks.test.info("User Select DeviceColor");
    }

    @And("user Enters deviceqty {}")
    public void user_Enters_deviceqty(String deviceqty) {
        addSecondDevice.enterdeviceQuantity2(deviceqty);
        Hooks.test.info("user Enters deviceqty " + deviceqty);
    }

    @And("User Enters Deliveryaddress {}")
    public void user_Enters_Deliveryaddress(String DeliveryAdd) {
        addSecondDevice.enterdeviceDeliveryAddress(DeliveryAdd);
        Hooks.test.info("User Enters Deliveryaddress " + DeliveryAdd);
    }

    @And("User Confirms DeviceCurrentPrice")
    public void user_Confirms_DeviceCurrentPrice() {
        addSecondDevice.confirmdeviceCurrentPrice();
        Hooks.test.info("User Confirms DeviceCurrentPrice");

    }

    @And("User clicks on the device next button")
    public void User_clicks_on_the_device_next_button() {
        addSecondDevice.clickNextbutton();
        Hooks.test.info("User clicks on the device next button");
    }

    @And("User clicks on the add to care button")
    public void user_clicks_on_the_add_to_care_button() {
        addSecondDevice.clickAddToCaretButton();
        Hooks.test.info("User clicks on the add to care button");
    }

    @Then("User should see correct cart items and pricing")
    public void user_should_see_correct_cart_items_and_pricing() {
        reviewOrder.verify_cart_items_and_pricing();
        Hooks.test.info("User should see correct cart items and pricing");
    }

    @And("User clicks on remove button")
    public void user_clicks_on_remove_button() {
        reviewOrder.clickremove_item_from_cart();
        Hooks.test.info("User clicks on remove button");
    }

    @Then("reconfirms the cart items and pricing")
    public void reconfirms_the_cart_items_and_pricing() {
        reviewOrder.reconfirms_total_price();
        Hooks.test.info("reconfirms the cart items and pricing");
    }

    @And("Remove the remaining item from the cart")
    public void user_clicks_on_remove_remaining_item_from_the_cart() {
        reviewOrder.click_Remove_remaining_item_from_the_cart();
        Hooks.test.info("Remove the remaining item from the cart");

    }
    // Order an Item again after CART ITEM WAS CLEARED

    @And("User select the deviceA")
    public void user_select_the_deviceA() {
        addaDeviceAgainAter.selectDropdown("Tablet");
        Hooks.test.info("User select the deviceA");
    }

    @And("User Select the brandA")
    public void user_select_the_brandA() {
        addaDeviceAgainAter.selectBrand("Other");
        Hooks.test.info("User Select the brandA");
    }

    @And("User select the colorA")
    public void user_select_the_colorA() {
        addaDeviceAgainAter.selectColor("White");
        Hooks.test.info("User select the colorA");
    }

    @And("User select QuantityA")
    public void user_select_the_qualityA() {
        addaDeviceAgainAter.inputquality("1");
        Hooks.test.info("User select QuantityA");
    }

    @And("User enters DeliveryemailaddA {}")
    public void user_enters_DeliveryemailaddA(String emailaddressadd) {
        addaDeviceAgainAter.enterDeliveryemailadd(emailaddressadd);
        Hooks.test.info("User enters DeliveryemailaddA " + emailaddressadd);
    }

    @And("User clicks on the next buttonA")
    public void user_clicks_on_the_next_buttonA() {
        addaDeviceAgainAter.clickNextButton();
        Hooks.test.info("User clicks on the next buttonA");
    }

    @And("User select the storageA")
    public void user_select_the_storageA() {
        addaDeviceAgainAter.clickStorage();
        Hooks.test.info("User select the storageA");
    }

    @And("User clicks on the next buttonN")
    public void user_clicks_on_the_next_buttonN() {
        addaDeviceAgainAter.clickNextButtonN();
        Hooks.test.info("User clicks on the next buttonN");
    }

    @And("User clicks on the Add to cart buttonA")
    public void user_clicks_on_add_to_cart_buttonA() {
        addaDeviceAgainAter.clickAddToCartA();
        Hooks.test.info("User clicks on add to cart buttonA");
    }

    @Then("User should see correct cart items and pricingA")
    public void user_should_see_correct_cart_items_and_pricingA() {
        addaDeviceAgainAter.CartitemsDisplays();
        Hooks.test.info("User should see correct cart items and pricingA");
    }

    @And("User clicks on the Review button")
    public void user_clicks_on_the_Review_button() {
        addaDeviceAgainAter.clickReviewCartA();
        Hooks.test.info("User clicks on the Review button");
    }

    @And("User clicks on Cancel button")
    public void user_clicks_on_Cancel_button() {
        addaDeviceAgainAter.clickCancelCartA();
        Hooks.test.info("User clicks on Cancel button");
    }

    @And("User clicks on the ReviewA button")
    public void user_Clicks_on_review_an_order_button() {
        addaDeviceAgainAter.clickReviewAButton();
        Hooks.test.info("User clicks on the ReviewA button");
    }

    @And("User click on Place an Order")
    public void user_Clicks_on_place_an_order_button() {
        addaDeviceAgainAter.clickPlaceOrder();
        Hooks.test.info("User click on Place an Order");
    }

    @And("User clicks viewInvoice button")
    public void user_clicks_view_invoice_button() {
        addaDeviceAgainAter.cliickViewInvoiceButon();
        Hooks.test.info("User clicks viewInvoice button");
    }

    @Then("User should see the order confirmation details")
    public void user_should_see_the_order_confirmation_details() {
        addaDeviceAgainAter.orderConfirmationDetails();
        Hooks.test.info("User should see the order confirmation details");
        Hooks.test.info("*******End of the Test***************************");
    }



}



