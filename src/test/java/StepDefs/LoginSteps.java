package StepDefs;

import Utils.Base;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class LoginSteps extends Base {

    public LoginSteps() throws InterruptedException {
        super(); // initialize driver and page objects from Base
    }

    @Given("I navigate to the login page")
    public void iNavigateToLoginPage() {
        landingPage.waitForHeroSection();
        landingPage.clickLearnMoreButton();
    }

    @When("I enter username {string} and password {string}")
    public void iEnterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click on the login button")
    public void iClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should see {string}")
    public void iShouldSee(String expectedMessage) {
        loginPage.confirmIfMessageIsDisplayed(expectedMessage);
    }

    @When("I login with valid credentials")
    public void iLoginValid() {
        login("ree@test.com", "Password@123");
    }

    @When("I switch to another tab and back")
    public void iSwitchTabs() {
        loginPage.clickEnrolTab();
        loginPage.isEnrolTabHeadingVisible();
        loginPage.clickLearnMoreButton();
    }

    @Then("I must be forced to login again")
    public void iMustLoginAgain() {
        loginPage.assertSignUpButtonIsVisible();
    }

    @When("I click logout")
    public void iClickLogout() {
        loginPage.clickLogout();
    }

    @Then("Token is removed and login screen is visible")
    public void tokenRemovedLoginVisible() {
        Assert.assertFalse(loginPage.isTokenPresent(), "Auth token still present!");
    }
}
