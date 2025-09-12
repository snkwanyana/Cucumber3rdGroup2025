package StepDefs;

import Utils.Base;
import io.cucumber.java.PendingException;
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

    }

}