package StepDefs;

import PageObjects.EdgeCartPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class EdgeCartSteps extends Base {

    WebDriver driver;
    EdgeCartPage edgeCartPage = new EdgeCartPage(driver);

    @Given("I have added {string} {string} {string} to the cart")
    public void i_have_added_item(String deviceType, String brand, String storage) {
        edgeCartPage.addItem(deviceType, brand, storage);
    }

    @When("I set the quantity to {string}")
    public void i_set_quantity(String quantity) {
        edgeCartPage.setQuantityTo(quantity);
    }

    @Then("I should see the quantity error message {string}")
    public void i_should_see_quantity_error(String expectedMessage) {
        edgeCartPage.assertQuantityError(expectedMessage);
    }

    @Given("I have added a discounted {string} {string} {string} to the cart")
    public void i_have_added_discounted_item(String deviceType, String brand, String storage) {
        edgeCartPage.addItem(deviceType, brand, storage, true);
    }

    @And("I have added a non-discounted {string} {string} {string} to the cart")
    public void i_have_added_non_discounted_item(String deviceType, String brand, String storage) {
        edgeCartPage.addItem(deviceType, brand, storage, false);
    }

    @When("I remove the discounted item")
    public void i_remove_discounted_item() {
        edgeCartPage.removeDiscountedItem();
    }

    @Then("the grand total should update correctly and no discounts should remain")
    public void i_verify_updated_total_and_no_discount() {
        edgeCartPage.assertGrandTotalUpdated();
        edgeCartPage.assertNoDiscountsRemain();
    }

    @Given("I manually empty the cart")
    public void i_manually_empty_cart() {
        edgeCartPage.manuallyEmptyCart();
    }

    @When("I attempt to place the order")
    public void i_attempt_place_order() {
        edgeCartPage.clickPlaceOrder();
    }

    @Then("no success toast should appear")
    public void i_verify_no_toast() {
        edgeCartPage.assertNoSuccessToast();
    }
}
