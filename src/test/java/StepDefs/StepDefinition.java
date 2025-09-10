package StepDefs;

import Utils.Base;
import io.cucumber.java.en.*;

public class StepDefinition extends Base {

    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
        loginPage.clickSignupButton();

    }

    @When("User enters name {}")
    public void user_enters_name(String name) {
        signupPage.enterFirstName(name);

    }

    @And("User enters last name {}")
    public void user_enters_last_name(String lastName) {
        signupPage.enterLastName(lastName);

    }

    @And("User enters email {}")
    public void user_enters_email(String email) {
        signupPage.enterEmail(email);

    }

    @And("User enters new password {}")
    public void user_enters_new_password(String password) {
        signupPage.enterPassword(password);

    }

    @And("User enters confirm password {}")
    public void user_enters_confirm_password(String comfirmPassword) {
        signupPage.enterConfirmPassword(comfirmPassword);
    }

    @And("User clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        signupPage.clickCreateAccount();

    }

    @Then("User should see an error message {}")
    public void user_should_see_an_error_message(String errorMessage) {

        signupPage.confirmIfErrorMessageIsDisplayed(errorMessage);

    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        assessmentPage.confirmYouAreOnAssessmentPage();

    }
    @When("User enters username ")
    public void user_enters_username(String email) {
    loginPage.enterEmail(email);        // Write code here that turns the phrase above into concrete actions

    }
    @When("User enters password ")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);        // Write code here that turns the phrase above into concrete actions


    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
        assessmentPage.confirmYouAreOnAssessmentPage();
    }
    @Then("User should see the homepage or an error message Login failed: Missing required fields")
    public void user_should_see_the_homepage_or_an_error_message_login_failed_missing_required_fields() {

    }


}