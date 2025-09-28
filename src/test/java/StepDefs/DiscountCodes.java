package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DiscountCodes {

    @Given("I am on the pricing page")
    public void i_am_on_the_pricing_page() {
        // Navigate to the pricing page
    }

    @When("I enter {string} in the discount code field and click Apply")
    public void i_enter_code_in_the_discount_code_field_and_click_apply(String code) {
        // Enter the discount code and click Apply
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        // Assert that the expected message is displayed
    }

    @Given("I have applied {string} discount code")
    public void i_have_applied_discount_code(String code) {
        // Apply the given discount code
    }

    @When("I clear the discount code field and apply")
    public void i_clear_the_discount_code_field_and_apply() {
        // Clear the discount code field and click Apply
    }

    @Then("I should not see any discount message")
    public void i_should_not_see_any_discount_message() {
        // Assert that no discount message is displayed
    }
}
