package StepDefs;

import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StepDefinitionExtras extends Base {

//    @Given("User is on the extras page")
//    public void user_is_on_the_extras_page() {
//        addExtrasPage.verifyinventorytitleIsDisplayed();
//
//    }
    @When("User clicks on the shipping method radio button")
    public void user_clicks_on_the_shipping_method_radio_button() {

       addExtrasPage.selectExpressShipping();
    }
    @And("User clicks on warranty radio button")
    public void user_clicks_on_warranty_radio_button() {
       addExtrasPage.select2YearWarranty();
    }
    @And("User enters discount code {}")
    public void user_enters_discount_code(String DiscountCode) {

        addExtrasPage.enterDiscountCode(DiscountCode);
    }
    @And("User clicks on Apply button")
    public void user_clicks_on_apply_button() {


    }




















}
