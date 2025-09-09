package StepDefs;

import PageObjects.SignupPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class StepDefinition  {

    WebDriver driver;
    SignupPage signupPage = new SignupPage(driver);

    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {


        signupPage.confirmIfSignupPageIsDisplayed();

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

    }

}