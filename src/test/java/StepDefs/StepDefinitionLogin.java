package StepDefs;

import Utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinitionLogin extends Base {

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.verifyLogintoAccessLearningMaterialsIsDisplayed();
       // loginPage.clickLoginButton();

        }


    @When("User enters password Password123")
    public void user_enters_password_password123() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
