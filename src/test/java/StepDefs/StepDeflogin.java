package StepDefs;

import PageObjects.LoginPage;
import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDeflogin extends Base {

    @Given("User is on the login page")
    public void user_is_on_the_login_page(){
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
    }

    @When(" User enters email {}")
    public void user_enters_email (String email){
        loginPage.enteremail(email);
    }

    @And("User enters password {}")
    public void user_enters_password (String password){
        loginPage.enterpassword(password);
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button(){
        loginPage.clickSignupButton();
    }


}
