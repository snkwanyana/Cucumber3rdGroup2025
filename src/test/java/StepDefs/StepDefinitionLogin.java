package StepDefs;

import PageObjects.SelectDevicePage;
import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;

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

    @And("User clicks on About Us button")
    public void user_clicks_on_the_about_us_button() {
       loginPage.clickAboutUSbutton();
    }

    @Then("User should see About Nkosi Cele")
    public void user_should_see_about_nkosi_cele()
    {
        loginPage.verifyAboutNkosiCeleisDisplayed();
    }

    @And ("User clicks on learning material button")
    public  void user_clicks_on_learning_material_button(){
        loginPage.clickslearningmaterialButton();
    }

    @And("User if forced to login again")
    public void user_if_forced_to_login_again() {
        loginPage.login("testuser", "password123");
    }


    @And("User Clicks on Web Automation Advance")
    public void user_Clicks_on_Web_Automation_Advance() {
        selectDevicePage.clickWebAutomationAdvance();
    }

    @And("User select the device")
    public void user_select_the_device() {
        selectDevicePage.selectDropdown("Tablet");
    }

    @And("User Select the brand")
    public void user_select_the_brand() {
        selectDevicePage.selectBrand("Samsung");
    }

    @And("User select the storage")
    public void user_select_the_storage() {
        selectDevicePage.clickStorage();
    }

    @And("User select the color")
    public void user_select_the_color() {
        selectDevicePage.selectColor("Gold");
    }

   @And("User select Quantity")
    public void user_select_the_quality() {
       selectDevicePage.inputquality("2");
    }

 @And("User enters Deliveryemailadd {}")
    public void andUserEntersDeliveryemailaddEmailaddressadd(String emailaddressadd) {
        selectDevicePage.enterDeliveryemailadd(emailaddressadd);
    }

   @And("Calculate the total price")
   public  void validatePriceCalculation()
    {
         selectDevicePage.validatePriceCalculation();

   }

    @And("User clicks on the next button")
    public void user_clicks_on_the_next_button() {
        selectDevicePage.clickNextButton();
    }




}
