package StepDefs;

import Utils.Base;
import io.cucumber.java.en.*;

public class SignUpSteps extends Base {

    public SignUpSteps() {
        super(); // ensures driver and PageObjects are initialized
    }

    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        landingPage.waitForHeroSection(); // make sure hero section is visible
        landingPage.clickLearnMoreButton();
        landingPage.clickSignup();

    }
    @When("User enters name {string}")
    public void user_enters_name(String name) {
        signupPage.enterFirstName(name);

    }
    @When("User enters last name {string}")
    public void user_enters_last_name(String lastName) {
        signupPage.enterLastName(lastName);

    }
    @When("User enters email {string}")
    public void user_enters_email(String email) {
        signupPage.enterEmail(email);

    }
    @When("User enters new password {string}")
    public void user_enters_new_password(String password) {
        signupPage.enterPassword(password);

    }
    @When("User enters confirm password {string}")
    public void user_enters_confirm_password(String confirmPassword) {
        signupPage.enterConfirmPassword(confirmPassword);

    }
    @When("User clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        signupPage.clickCreateAccount();

    }
    @Then("User should see an error message {string}")
    public void user_should_see_an_error_message(String errorMessage) {
        signupPage.confirmIfErrorMessageIsDisplayed(errorMessage);

    }

}
