package StepDefs;

import Utils.Base;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddSecondItemStepDef extends Base {

    public AddSecondItemStepDef() {
        if (driver != null) {
            initializePages();
        }
    }

    @When("User selects device type order1 {string}")
    public void user_selects_device_type_order1_second(String typeOrder2) {
        orderingPage.selectDeviceType(typeOrder2);
    }

    @And("the user selects brand {string}")
    public void the_user_selects_brand_second(String brand2) {
        orderingPage.selectBrand(brand2);
    }

    @And("the user selects storage {string}")
    public void the_user_selects_storage_second(String storage2) {
        orderingPage.selectStorage(storage2);
    }

    @And("the user selects color {string}")
    public void the_user_selects_color_second(String color2) {
        orderingPage.selectColor(color2);
    }

    @And("user enters quantity for second item {int}")
    public void the_user_enters_quantity_second(Integer quantity2) {
        orderingPage.setQuantity(quantity2);
    }

    @And("the user enters address {string}")
    public void the_user_enters_address_second(String address2) {
        orderingPage.setAddress(address2);
    }

    @And("the user clicks the Next button for second item")
    public void the_user_clicks_the_next_button_second() {
        orderingPage.clickNext();
    }

    @Then("Step 2 should be displayed for second item")
    public void step_2_should_be_displayed_second() {
        // Add validation logic if needed
    }

    @When("The user clicks the add to cart button")
    public void the_user_clicks_the_add_to_cart_button_second() {

        pricingParnel.clickAddToCart();
    }

    @Then("The item should be added to the cart")
    public void the_item_should_be_added_to_the_cart_second() {
        // Add validation logic if needed
    }
}
