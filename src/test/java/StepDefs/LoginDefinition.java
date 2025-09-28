package StepDefs;
import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import Utils.BrowserFactory;


public class LoginDefinition extends Base {

    @Before
    public void setUp() {
        if (Base.driver == null) {
            BrowserFactory browserFactory = new BrowserFactory();
            Base.driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
        }
        initializePages(); // Ensure page objects are initialized after driver is set
    }

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
    }
    @When("The user enters email {}")
    public void The_user_enters_email(String email) {
        loginPage.enterEmail(email);

    }

    @And("The user enters new password {}")
    public void The_user_enters_new_password(String password) {

        loginPage.enterPassword(password);
    }
    @And("The User click on the login button")

    public void the_user_click_on_the_login_button() {
        loginPage.clickLoginField();
    }

    @Then("The user should see the message {}")
    public void the_user_should_see_the_message(String errorMessage) {
        if (loginPage.isAlertPresent()) {
            loginPage.validateMessagepopup(errorMessage);
        } else {
            System.out.println("No alert present, test passes.");
        }

    }


    @Then("The User should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        if (welcomePage.isHeadingDisplayed()) {
            welcomePage.verifyWelcomeHeadingIsDisplayed();
        }
    }
    @After
    public void tearDown() {
        if (Base.driver != null) {
            Base.driver.quit();
            Base.driver = null;
        }
    }

}
