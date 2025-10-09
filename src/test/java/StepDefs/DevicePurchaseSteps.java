package StepDefs;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;

public class DevicePurchaseSteps extends Base {


    public WebDriver driver;

    public DevicePurchaseSteps() {
        this.driver = super.driver;
    }

    @Given("I am on the login screen")
    public void i_am_on_the_login_screen() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
    }

    @And("I enter valid credentials")
    public void i_enter_valid_credentials() {
        loginPage.enterEmail("HisenseCrock@example.com");
        loginPage.enterPassword("Pass1234");
        loginPage.clickLoginButton();
    }

    @And("I am redirected to the landing page")
    public void i_am_redirected_to_the_landing_page() {
        inventoryFormPage.isLogoutButtonDisplayed();
    }

    @When("I navigate to the Web Automation Advanced tab for multi devices")
    public void i_navigate_to_web_automation_advanced_tab_multi_devices() {
        inventoryFormPage.clickToWebAutomationAdvance();
    }

    // ----------- First Device -----------

    @And("I select first device type {string}")
    public void i_select_first_device_type(String deviceType1) {
        inventoryFormPage.selectDeviceType(deviceType1);
    }

    @And("I select first device brand {string}")
    public void i_select_first_device_brand(String brand1) {
        inventoryFormPage.selectDeviceBrand(brand1);
    }

    @And("I choose first storage option {string}")
    public void i_choose_first_storage_option(String storage1) {
        inventoryFormPage.selectDeviceStorage(storage1);
    }

    @And("I choose first color {string}")
    public void i_choose_first_color(String color1) {
        inventoryFormPage.selectDeviceColor(color1);
    }

    @And("I enter first quantity {string}")
    public void i_enter_first_quantity(String quantity1) {
        inventoryFormPage.enterQuantity(quantity1);
    }

    @And("I enter first valid delivery address {string}")
    public void i_enter_first_valid_delivery_address(String address1) {
        inventoryFormPage.enterAddress(address1);
    }

    @And("I click the first Next button")
    public void i_click_the_first_next_button() {
        inventoryFormPage.clickNextButton();
    }

    @And("I select first shipping method {string}")
    public void i_select_first_shipping_method(String shipping1) {
        inventoryFormPage.clickShippingMethod(shipping1);
    }

    @And("I choose first warranty option {string}")
    public void i_choose_first_warranty_option(String warranty1) {
        inventoryFormPage.clickWarranty(warranty1);
    }

    @And("I apply first valid discount code {string}")
    public void i_apply_first_valid_discount_code(String code1) {
        inventoryFormPage.enterDiscountCode(code1);
        inventoryFormPage.clickApplyDiscountButton();
    }

    @And("I click the first add to cart button")
    public void i_click_the_first_add_to_cart_button() {
        takeScreenshots.takesSnapShot(driver, "First Item on Cart");
        Allure.addAttachment("First Item on cart",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        inventoryFormPage.clickAddToCartButton();
    }

    // ----------- Second Device -----------

    @And("I select second device type {string}")
    public void i_select_second_device_type(String deviceType2) {
        inventoryFormPage.selectDeviceType(deviceType2);
    }

    @And("I select second device brand {string}")
    public void i_select_second_device_brand(String brand2) {
        inventoryFormPage.selectDeviceBrand(brand2);
    }

    @And("I choose second storage option {string}")
    public void i_choose_second_storage_option(String storage2) {
        inventoryFormPage.selectDeviceStorage(storage2);
    }

    @And("I choose second color {string}")
    public void i_choose_second_color(String color2) {
        inventoryFormPage.selectDeviceColor(color2);
    }

    @And("I enter second quantity {string}")
    public void i_enter_second_quantity(String quantity2) {
        inventoryFormPage.enterQuantity(quantity2);
    }

    @And("I enter second valid delivery address {string}")
    public void i_enter_second_valid_delivery_address(String address2) {
        inventoryFormPage.enterAddress(address2);
    }

    @And("I click the second Next button")
    public void i_click_the_second_next_button() {
        inventoryFormPage.clickNextButton();
    }

    @And("I select second shipping method {string}")
    public void i_select_second_shipping_method(String shipping2) {
        inventoryFormPage.clickShippingMethod(shipping2);
    }

    @And("I choose second warranty option {string}")
    public void i_choose_second_warranty_option(String warranty2) {
        inventoryFormPage.clickWarranty(warranty2);
    }

    @And("I apply second valid discount code {string}")
    public void i_apply_second_valid_discount_code(String code2) {
        inventoryFormPage.enterDiscountCode(code2);
        inventoryFormPage.clickApplyDiscountButton();
    }

    @And("I click the second add to cart button")
    public void i_click_the_second_add_to_cart_button() {
        takeScreenshots.takesSnapShot(driver, "Second Item on cart");
        Allure.addAttachment("Second Item on cart",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        inventoryFormPage.clickAddToCartButton();
    }

    // ----------- Assertions -----------

    @Then("I should see both devices listed in the cart {int}")
    public void i_should_see_both_devices_listed_in_cart(int cartTotal) {
        inventoryFormPage.verifyCartItemCount(cartTotal);
    }

    @And("the total price should reflect applied discounts {double}")
    public void total_price_should_reflect_discounts(double expectedTotal) {
        inventoryFormPage.verifyCartTotal(expectedTotal);
    }

    @And("I click the review cart button")
    public void i_click_review_cart_button() {
        inventoryFormPage.clickReviewCartButton();
    }
    @When("I click the place order button")
    public void i_click_the_place_order_button(){
        inventoryFormPage.clickPlaceOrder();
    }

    @Then("an invoice for multi device should be generated")
    public void invoice_for_multi_device_should_be_generated() {
        inventoryFormPage.clickViewInvoicePopUp();
        inventoryFormPage.clickViewButtonInsidePop();
        takeScreenshots.takesSnapShot(driver, "Invoice Page");
    }

    @And("I close the invoice browser tab for multi devices")
    public void i_close_invoice_tab_for_multi_devices() {
        inventoryFormPage.closeInvoiceBrowser();
    }

    @And("I logout from the website for the multi devices")
    public void i_logout_from_website_for_multi_devices() {
        inventoryFormPage.clickCloseModalPopUp();
        inventoryFormPage.clickLogoutButton();
        inventoryFormPage.teardown();
    }

    // ----------- Remove second item -----------

    @And("I remove the second device from the cart")
    public void i_remove_the_second_device_from_the_cart(){
        // CSS selector targeting the second cart item's remove button
        String removeButtonSelector = "div[style*='flex-direction: column'][style*='gap: 10px'] > div:nth-child(2) button[aria-label='Remove item']";

        WebElement removeButton = driver.findElement(By.cssSelector(removeButtonSelector));
        removeButton.click();
    }
    @Then("I should see only the first device in the cart")
    public void i_should_see_only_the_first_device_in_the_cart(){
        inventoryFormPage.verifyCartItemCount(1);
        Allure.addAttachment("Item on cart for 1 cart item",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @And("the total price should update to reflect one device {double}")
    public void the_total_price_should_update_to_reflect_one_device(double updatedTotal){
        inventoryFormPage.verifyCartTotal(updatedTotal);
    }

    @Then("an invoice for single device should be generated")
    public void an_invoice_for_single_device_should_be_generated(){
        inventoryFormPage.clickViewInvoicePopUp();
        inventoryFormPage.clickViewButtonInsidePop();
        takeScreenshots.takesSnapShot(driver, "Invoice for single device");
    }

    @And("I close the invoice browser tab for single device")
    public void i_close_the_invoice_browser_tab_for_single_device(){
        inventoryFormPage.closeInvoiceBrowser();
    }

    @And("I logout from the website for the single device order")
    public void i_logout_from_the_website_for_the_single_device_order(){
        inventoryFormPage.clickCloseModalPopUp();
        inventoryFormPage.clickLogoutButton();
        inventoryFormPage.teardown();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}
