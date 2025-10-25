package StepDefs;

import PageObjects.ConfirmPurchasePage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ConfirmPurchaseSteps extends Base {

    WebDriver driver;
    ConfirmPurchasePage confirmPage = new ConfirmPurchasePage(driver);


    @When("I click Confirm Purchase")
    public void i_click_confirm_purchase() {
        confirmPage.clickConfirmPurchase();
    }

    @Then("the form should reset to defaults")
    public void the_form_should_reset_to_defaults() {
        confirmPage.assertFormReset();
    }

    @And("I fill in valid product details {string} {string} {string} {string} {string}")
    public void i_fill_in_valid_product_details(String deviceType, String brand, String storage, String color, int quantity) {
        confirmPage.fillProductDetails(deviceType, brand, storage, color, quantity);
    }
}
