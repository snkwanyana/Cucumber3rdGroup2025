package StepDefs;

import Utils.Hooks;
import io.cucumber.java.en.*;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class LoginSteps {
    // Use Hooks.base and Hooks.driver for all actions

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Hooks.base.landingPage.verifyPageLogo();
        Hooks.base.takeScreenshots.takesSnapShot(Hooks.driver, "Landing Page");
        Hooks.base.landingPage.clickLoginButton();
    }

    @When("I enter email {} and password {} and click login")
    public void i_enter_email_and_password_and_click_login(String email, String password) {
        Hooks.base.takeScreenshots.takesSnapShot(Hooks.driver, "Login Page");
        Allure.addAttachment("Login Page", new ByteArrayInputStream(((TakesScreenshot)Hooks.driver).getScreenshotAs(OutputType.BYTES)));
        Hooks.base.loginPage.enterEmail(email);
        Hooks.base.loginPage.enterPassword(password);
        Hooks.base.loginPage.clickLoginButton();
    }

    @Then("I should see welcome Message")
    public void I_should_see_welcome_Message(){
      //  Hooks.base.loginPage.verifyTabs();
      //  Hooks.base.takeScreenshots.takesSnapShot(Hooks.driver, "Learning Materials Page");
        Allure.addAttachment("LandingPage",new ByteArrayInputStream(((TakesScreenshot)Hooks.driver).getScreenshotAs(OutputType.BYTES)));
    }

    @And("localStorage should contain authToken")
    public void localStorage_should_contain_authToken(){
        Hooks.base.loginPage.verifyToken();

    }

    @When("I navigate to a different menu tab")
    public void i_navigate_to_a_different_menu_tab(){
       // Hooks.base.loginPage.clickContactTab();
    }

    @And("I return to the original tab")
    public void i_return_to_the_original_tab(){
        //Hooks.base.loginPage.clickLearnMoreButton();
    }

    @Then("I should be redirected to the login page due to session timeout")
    public void i_should_be_redirected_to_the_login_page_due_to_session_timeout(){
      //  Hooks.base.loginPage.verifyLoginText();
       // Allure.addAttachment("Login Page After session timed out",new  ByteArrayInputStream(((TakesScreenshot)Hooks.driver).getScreenshotAs(OutputType.BYTES)));

    }

    @When("I re-enter email {} and password {} and click login again")
    public void i_re_enter_email_and_password_and_click_login_again(String email, String password){
      //  Hooks.base.loginPage.enterEmail(email);
     //   Hooks.base.loginPage.enterPassword(password);
      //  Hooks.base.loginPage.clickLoginButton();
    }

    @And("I click the logout button")
    public void I_click_on_the_logout_button(){
       // Hooks.base.loginPage.verifyTabs();
       // Hooks.base.loginPage.clickLogoutButton();


    }
    @Then("I should be redirected to the login page")
    public void i_should_be_redirected_to_the_login_page(){
       // Hooks.base.loginPage.verifyLoginText();
        //Allure.addAttachment("Login Page After logged Out",new  ByteArrayInputStream(((TakesScreenshot)Hooks.driver).getScreenshotAs(OutputType.BYTES)));

    }

    @When("I enter a valid email {} and an invalid password {}")
    public void I_enter_a_valid_email_and_an_invalid_password(String email,String invalid_password){
      //  Hooks.base.loginPage.enterEmail(email);
      //  Hooks.base.loginPage.enterPassword(invalid_password);
      //  Hooks.base.loginPage.clickLoginButton();

    }


    @Then("I should see an alert containing {}")
    public void i_should_see_an_alert_containing(String expectedMessage) {
       // Hooks.base.loginPage.verifyAlertMessage(expectedMessage);
      //  Hooks.base.takeScreenshots.takesSnapShot(Hooks.driver, "Incorrect credentials login error");
       // Allure.addAttachment("Incorrect credentials login error",new ByteArrayInputStream(((TakesScreenshot)Hooks.driver).getScreenshotAs(OutputType.BYTES)));

    }




}
