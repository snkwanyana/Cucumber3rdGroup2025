package StepDefs;

import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinitionLogin extends Base {

    @Given("User is on the homepage")
    public void user_is_on_the_home_page() {
        loginPage.verifyLearnAutomationtheRightWayisDisplayed();
    }

    @When("User clicks on the learning material button")
    public  void user_clicks_on_the_learning_material_button()
    {
        loginPage.clicklearningmaterialButton();
    }

    @And("User enters emailaddress {}")
    public void user_enters_emailaddress(String emailaddress) {
       loginPage.enterEmailAddress(emailaddress);

    }

    @And("User enters password {}")
    public  void user_enters_password(String password) {
          loginPage.enterPassword(password);
    }


    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
       loginPage.clickloginButton();
    }


}
