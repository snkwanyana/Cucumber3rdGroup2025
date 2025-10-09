package StepDefs;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class LoginSteps extends Base {
    public WebDriver driver;

    public LoginSteps() {
        this.driver = super.driver;
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        takeScreenshots.takesSnapShot(driver, "Landing Page");
        landingPage.clickLearnMoreButton();

    }

    @When("I enter email {} and password {} and click login")
    public void i_enter_email_and_password_and_click_login(String email, String password) {
        takeScreenshots.takesSnapShot(driver, "Login Page");
        Allure.addAttachment("Login Page",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();


    }

    @Then("I should see all tabs")
    public void I_should_see_all_tabs(){
        loginPage.verifyTabs();
        takeScreenshots.takesSnapShot(driver, "Learning Materials Page");
        Allure.addAttachment("Learning Materials Page",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
    }

    @And("localStorage should contain authToken")
    public void localStorage_should_contain_authToken(){
        loginPage.verifyToken();

    }

    @When("I navigate to a different menu tab")
    public void i_navigate_to_a_different_menu_tab(){
        loginPage.clickContactTab();
    }

    @And("I return to the original tab")
    public void i_return_to_the_original_tab(){
        loginPage.clickLearnMoreButton();
    }

    @Then("I should be redirected to the login page due to session timeout")
    public void i_should_be_redirected_to_the_login_page_due_to_session_timeout(){
        loginPage.verifyLoginText();
        Allure.addAttachment("Login Page After session timed out",new  ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }

    @When("I re-enter email {} and password {} and click login again")
    public void i_re_enter_email_and_password_and_click_login_again(String email, String password){
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @And("I click the logout button")
    public void I_click_on_the_logout_button(){
        loginPage.verifyTabs();
        loginPage.clickLogoutButton();


    }
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page(){
        loginPage.verifyLoginText();
        Allure.addAttachment("Login Page After logged Out",new  ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }

    @When("I enter a valid email {} and an invalid password {}")
    public void I_enter_a_valid_email_and_an_invalid_password(String email,String invalid_password){
        loginPage.enterEmail(email);
        loginPage.enterPassword(invalid_password);
        loginPage.clickLoginButton();

    }


    @Then("I should see an alert containing {}")
    public void i_should_see_an_alert_containing(String expectedMessage) {
        loginPage.verifyAlertMessage(expectedMessage);
        takeScreenshots.takesSnapShot(driver, "Incorrect credentials login error");
        Allure.addAttachment("Incorrect credentials login error",new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

    }

    @After
    public void quitBrowser() {
        driver.quit();
    }


}
