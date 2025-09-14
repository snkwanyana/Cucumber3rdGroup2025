package StepDefs;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class StepDefinition extends Base {

    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMaterialsTab();
        loginPage.clickSignupButton();

    }

    /** Signup step definitions **/

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

    /** longin step definations **/

    @Given("I navigate to the login page")
    public void i_navigate_to_the_login_page() {
        loginPage.confirmIfHomePageIsDisplayed();
        loginPage.clickLearningMaterialsButton();
        loginPage.confirmIfLoginPageIsDisplayed();
    }
    @When("User enter the username {}")
    public void user_enter_the_username(String username) {
        loginPage.enterUsername(username);
    }
    @When("User enter the password {}")
    public void user_enter_the_password(String password) {
        loginPage.enterPassword(password);

    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User confirms the above steps executed successfully {}")
    public void user_confirms_the_above_steps_executed_successfully(String string) {
        loginPage.vilidateLoginIfPassedOrFailed(string);

    }

    @When("User switch to any tab and back to learning materials tab")
    public void user_switch_to_any_tab_and_back_to_learning_materials_tab() {
        landingPage.clickContactDetailsTab();
        landingPage.clickLearnMaterialsTab();
    }

    @Then("User confirms the user is logged out and redirected to the login page")
    public void userConfirmsTheUserIsLoggedOutAndRedirectedToTheLoginPage() {
        loginPage.confirmIfLoginPageIsDisplayed();
    }

    @When("User clicks on the logout button")
    public void userClicksOnTheLogoutButton() {
        learningMaterialsPage.clickLogoutButton();
    }

    @After
    public void quitBrowser() {
        driver.quit();
    }

}