//package StepDefs;
//
//
//import PageObjects.LoginPage;
//import Utils.Base;
//import io.cucumber.java.en.*;
//
//
//public class StepDefinition extends Base {
//LoginPage loginPage = new LoginPage(driver);
//    public StepDefinition() throws InterruptedException {
//        super();
//    }
//
//
//
//    @When("User enters name {}")
//    public void user_enters_name(String name) {
//        signupPage.enterFirstName(name);
//
//    }
//
//    @And("User enters last name {}")
//    public void user_enters_last_name(String lastName) {
//        signupPage.enterLastName(lastName);
//
//    }
//
//    @And("User enters email {}")
//    public void user_enters_email(String email) {
//        signupPage.enterEmail(email);
//
//    }
//
//    @And("User enters new password {}")
//    public void user_enters_new_password(String password) {
//        signupPage.enterPassword(password);
//
//    }
//
//    @And("User enters confirm password {}")
//    public void user_enters_confirm_password(String comfirmPassword) {
//        signupPage.enterConfirmPassword(comfirmPassword);
//    }
//
//    @And("User clicks on the create account button")
//    public void user_clicks_on_the_create_account_button() {
//        signupPage.clickCreateAccount();
//
//    }
//
//    @Then("User should see an error message {}")
//    public void user_should_see_an_error_message(String errorMessage) {
//
//        signupPage.confirmIfErrorMessageIsDisplayed(errorMessage);
//
//    }
//
//
//
//
//    @And("the user selects device type {string}")
//    public void theUserSelectsDeviceType(String deviceType)  {
//        practiceAssessmentsPage.selectDeviceType(deviceType);
//    }
//
//    @And("the user selects brand {string}")
//    public void theUserSelectsBrand(String brand) {
//        practiceAssessmentsPage.selectBrand(brand);
//    }
//
//
//    @And("the user selects storage {string}")
//    public void theUserSelectsStorage(String storage) {
//        practiceAssessmentsPage.selectStorage(storage);
//    }
//
//    @And("the user selects color {string}")
//    public void theUserSelectsColor(String color) {
//        practiceAssessmentsPage.selectColor(color);
//    }
//
//    @And("the user sets quantity {string}")
//    public void theUserSetsQuantity(String quantity) {
//        int qty = Integer.parseInt(quantity);
//        practiceAssessmentsPage.setQuantity(qty);
//    }
//
//
//    @And("the user enters delivery address {string}")
//    public void theUserEntersDeliveryAddress(String deliveryAddress) {
//        practiceAssessmentsPage.enterDeliveryAddress(deliveryAddress);
//
//    }
//
//
//    @And("the user clicks Purchase Device")
//    public void theUserClicksPurchaseDevice() {
//        practiceAssessmentsPage.clickPurchaseDevice();
//    }
//
//
//    @Then("the success toast should appear with order summary")
//    public void theSuccessToastShouldAppearWithOrderSummary() {
//        practiceAssessmentsPage.assertSuccessToastVisible();
//
//    }
//
//    @And("the form should reset to default values")
//    public void theFormShouldResetToDefaultValues() {
//        practiceAssessmentsPage.assertFormReset();
//    }
//
//
//    @And("the user clicks Logout")
//    public void theUserClicksLogout() {
//       loginPage.clickLogout();
//    }
//}