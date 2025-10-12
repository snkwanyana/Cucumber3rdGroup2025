package StepDefs;

import Utils.Hooks;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class StepDefinition {
    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        Hooks.base.landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        Hooks.base.landingPage.clickLearnMoreButton();
        Hooks.base.loginPage.clickSignupButton();
    }

    @When("User enters name {}")
    public void user_enters_name(String name) {
        Hooks.base.signupPage.enterFirstName(name);
        Hooks.base.takeScreenshots.takesSnapShot(Hooks.driver, "Signup Page");
        Allure.addAttachment("Signup Page",new ByteArrayInputStream(((TakesScreenshot)Hooks.driver).getScreenshotAs(OutputType.BYTES)));
    }

    @And("User enters last name {}")
    public void user_enters_last_name(String lastName) {
        Hooks.base.signupPage.enterLastName(lastName);
    }

    @And("User enters email {}")
    public void user_enters_email(String email) {
        Hooks.base.signupPage.enterEmail(email);
    }

    @And("User enters new password {}")
    public void user_enters_new_password(String password) {
        Hooks.base.signupPage.enterPassword(password);
    }

    @And("User enters confirm password {}")
    public void user_enters_confirm_password(String comfirmPassword) {
        Hooks.base.signupPage.enterConfirmPassword(comfirmPassword);
    }

    @And("User clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        Hooks.base.signupPage.clickCreateAccount();
    }

    @Then("User should see a message {}")
    public void user_should_see_an_error_message(String expectedMessage) {
        Hooks.base.signupPage.confirmIfErrorMessageIsDisplayed(expectedMessage);
    }

}