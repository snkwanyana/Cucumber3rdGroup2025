package StepDefs;

import PageObjects.SignupPage;
import Utils.Base;
import Utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import java.time.Duration;

public class StepDefinition extends Base {

    public WebDriver driver;
    @Before
    public void setUp() {
        if (Base.driver == null) {
            BrowserFactory browserFactory = new BrowserFactory();
            Base.driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
        }
        initializePages(); // Ensure page objects are initialized after driver is set
    }

    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        landingPage.clickLearnMoreButton();
        loginPage.clickSignupButton();

    }

    @When("User enters name {}")
    public void user_enters_name(String name) {
        signupPage.enterFirstName(name);
      //  takeScreenshots.takesSnapShot(driver, "Signup Page");

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
        try {
            Thread.sleep(20000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        signupPage.confirmIfErrorMessageIsDisplayed(errorMessage);
    }
    @When ("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        signupPage.clickLoginField();
    }
    @Then("User is redirected to the login page")
    public void User_is_redirected_to_the_login_page() {
        loginPage.verifyLoginHeadingIsDisplayed();
    }


   // @After
    //public void quitBrowser() {
    //    driver.quit();
    //}

}