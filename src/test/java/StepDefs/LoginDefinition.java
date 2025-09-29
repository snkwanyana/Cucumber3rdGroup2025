package StepDefs;
import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import Utils.BrowserFactory;
import org.openqa.selenium.devtools.DevTools;


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

    @Then("The error message should be displayed {}")
    public void theErrorMessageShouldBeDisplayedMessage(String errorMessage) {
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
    @And("The User token presence should be {}")
    public void the_user_token_presence_should_be(String tokenPresent) {
        String token = welcomePage.getAuthToken();
        System.out.println("Auth token: " + token); // Print the token for debugging
        boolean tokenFound = token != null && !token.isEmpty();
        if ("true".equals(tokenPresent)) {
            assert tokenFound : "Token not found in localStorage!";
        } else {
            assert !tokenFound : "Token should not be present!";
        }
    }
    @After
    public void tearDown() {
        if (Base.driver != null) {
            Base.driver.quit();
            Base.driver = null;
        }
    }


    @When("The user switch to new tab")
    public void theUserSwitchToNewTab() {
        welcomePage.clickContactTabButton();
    }

    @Then("The User should be logged out")
    public void theUserShouldBeLoggedOut() {
        landingPage.clickLearnMoreButton();
        loginPage.verifyLoginHeadingIsDisplayed();

    }
}
