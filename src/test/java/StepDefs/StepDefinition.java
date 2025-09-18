package StepDefs;

import PageObjects.LoginPage;
import PageObjects.PracticeAssessmentsPage;
import Utils.Base;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

public class StepDefinition extends Base {

//    @Given("User is on the signup page")
//    public void user_is_on_the_signup_page() {
//        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
//        landingPage.clickLearnMoreButton();
//        loginPage.clickSignupButton();
//
//    }
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

    /// ///////////////Log in Steps ///////////////////////
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        landingPage.clickLearnMoreButton();
    }

    @And("User enters Email {}")
    public void user_enters_Email(String emails) {
        loginPage.enterEmail(emails);
    }

    @And("User enters password {}")
    public void user_enters_password_plan_j(String Password) {
        loginPage.enterPassword(Password);
    }

    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {

        loginPage.clickLoginButton();

    }

    @Then("User should be redirected to learning material page")
    public void user_should_be_redirected_to_learning_material_page() {
        loginPage.verifyPracticeAssessmentIsDisplayed();

    }

    /// ///Practice Assessments Steps /////
    @Given("User is on the practice assessments page")
    public void user_is_on_the_practice_assessments_page() {
        loginPage.verifyPracticeAssessmentIsDisplayed();
    }

    @When("User clicks on the web automation link")
    public void user_clicks_on_the_web_automation_link() {
        loginPage.clickWebTab();
        // practiceAssessmentsPage.selectDeviceType(deviceType);
    }

    @And("User selects device type {string}")
    public void user_selects_device_type(String deviceType) {
        practiceAssessmentsPage.selectDeviceType(deviceType);
    }

    @And("User selects brand {string}")
    public void user_selects_brand(String brand) {
        practiceAssessmentsPage.selectBrand(brand);
    }

    @And("User selects storage {string}")
    public void user_selects_storage(String storage) {
        if (storage.equals("64GB")) {
            practiceAssessmentsPage.selectStorage128(storage);
        } else if (storage.equals("128GB")) {
            practiceAssessmentsPage.selectStorage128(storage);
        } else if (storage.equals("256GB")) {
            practiceAssessmentsPage.selectStorage256(storage);
        } else {
            throw new IllegalArgumentException("Invalid storage option: " + storage);
        }
    }

    @And("User selects color {string}")
    public void user_selects_color(String color) {
        practiceAssessmentsPage.selectColor(color);
    }

    @Then("User should be redirected to the web automation assessment page")
    public void user_should_be_redirected_to_the_web_automation_assessment_page() {

    }


}