package StepDefs;

import PageObjects.SelectDevicePage;
import Utils.Base;
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
    }

    @And("User enters emailaddress {}")
    public void user_enters_emailaddress(String emailaddress) {
        loginPage.enterEmailAddress(emailaddress);
    }

    @And("User enters password {}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }


    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickloginButton();
    }

    @And("User clicks on About Us button")
    public void user_clicks_on_the_about_us_button() {
        loginPage.clickAboutUSbutton();
    }

    @Then("User should see About Nkosi Cele")
    public void user_should_see_about_nkosi_cele() {
        loginPage.verifyAboutNkosiCeleisDisplayed();
    }

    @And("User clicks on learning material button")
    public void user_clicks_on_learning_material_button() {
        loginPage.clickslearningmaterialButton();
    }

    @And("User if forced to login again")
    public void user_if_forced_to_login_again() {
        loginPage.login("sama23@gmail.com", "Password123");
    }


    @And("User Clicks on Web Automation Advance")
    public void user_Clicks_on_Web_Automation_Advance() {
        selectDevicePage.clickWebAutomationAdvance();
    }

    @And("User select the device")
    public void user_select_the_device() {
        selectDevicePage.selectDropdown("Tablet");
    }

    @And("User Select the brand")
    public void user_select_the_brand() {
        selectDevicePage.selectBrand("Samsung");
    }

    @And("User select the storage")
    public void user_select_the_storage() {
        selectDevicePage.clickStorage();
    }

    @And("User select the color")
    public void user_select_the_color() {
        selectDevicePage.selectColor("Gold");
    }

    @And("User select Quantity")
    public void user_select_the_quality() {
        selectDevicePage.inputquality("2");
    }

    @And("User enters Deliveryemailadd {}")
    public void andUserEntersDeliveryemailaddEmailaddressadd(String emailaddressadd) {
        selectDevicePage.enterDeliveryemailadd(emailaddressadd);
    }

    @And("Calculate the total price")
    public void validatePriceCalculation() {
        selectDevicePage.validatePriceCalculation();

    }

    @And("User clicks on the next button")
    public void user_clicks_on_the_next_button() {
        selectDevicePage.clickNextButton();
    }

    //add the extra page here
    @When("User clicks on the shipping method radio button")
    public void user_clicks_on_the_shipping_method_radio_button() {

        addExtrasPage.selectExpressShipping();
    }

    @And("User clicks on warranty radio button")
    public void user_clicks_on_warranty_radio_button() {
        addExtrasPage.select2YearWarranty();
    }

    @And("User enters discount code {}")
    public void user_enters_discount_code(String DiscountCode) {

        addExtrasPage.enterDiscountCode(DiscountCode);
    }

    @And("User reenters discount code {}")
    public void user_reenters_discount_code(String DiscountsCode) {
        addExtrasPage.reenterDiscountCode(DiscountsCode);
    }


    @And("User clicks on Apply button")
    public void user_clicks_on_apply_button() {

        addExtrasPage.clickApplyButton();
    }

    @Then("User Verifies the discount is applied")

    public void user_verifies_the_discount_is_applied() {
        addExtrasPage.Verifiesdiscount();
    }

    @And("User clicks on the Add to cart button")
    public void user_clicks_on_add_to_cart_button() {
        addExtrasPage.clickAddToCartButton();
    }

    // Select Product from second device page
    @And("User select DeviceType")
    public void user_select_DeviceType() {
        addSecondDevice.selectDeviceType("Laptop");
    }

    @And("User Select DeviceBrand")
    public void user_select_Brand() {
        addSecondDevice.selectdeviceBrand("Macbook pro");
    }

    @And("User Select deviceStorage")
    public void user_Select_deviceStorage() {
        addSecondDevice.selectdeviceStorage256GB();

    }

    @And("User Select DeviceColor")
    public void user_Select_DeviceColor() {

        addSecondDevice.selectdeviceColorWhite("White");
    }

    @And("user Enters deviceqty {}")
    public void user_Enters_deviceqty(String deviceqty) {
        addSecondDevice.enterdeviceQuantity2(deviceqty);
    }

    @And("User Enters Deliveryaddress {}")
    public void user_Enters_Deliveryaddress(String DeliveryAdd) {
        addSecondDevice.enterdeviceDeliveryAddress(DeliveryAdd);
    }

    @And("User Confirms DeviceCurrentPrice")
    public void user_Confirms_DeviceCurrentPrice() {
        addSecondDevice.confirmdeviceCurrentPrice();

    }

    @And("User clicks on the device next button")
    public void User_clicks_on_the_device_next_button() {
        addSecondDevice.clickNextbutton();
    }

    @And("User clicks on the add to care button")
    public void user_clicks_on_the_add_to_care_button() {
        addSecondDevice.clickAddToCaretButton();
    }

    @Then("User should see correct cart items and pricing")
    public void user_should_see_correct_cart_items_and_pricing() {
        reviewOrder.verify_cart_items_and_pricing();
    }

    @And("User clicks on remove button")
    public void user_clicks_on_remove_button() {
        reviewOrder.clickremove_item_from_cart();
    }

    @Then("reconfirms the cart items and pricing")
    public void reconfirms_the_cart_items_and_pricing() {
        reviewOrder.reconfirms_total_price();
    }

    @And("Remove the remaining item from the cart")
    public void user_clicks_on_remove_remaining_item_from_the_cart() {
        reviewOrder.click_Remove_remaining_item_from_the_cart();


    }

}


