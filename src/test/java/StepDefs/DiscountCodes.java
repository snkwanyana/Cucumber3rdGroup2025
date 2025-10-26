package StepDefs;

import Utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import PageObjects.ExtrasPricingShipping;

public class DiscountCodes extends Base {
    private ExtrasPricingShipping extrasPricingShipping;

    public DiscountCodes() {
        extrasPricingShipping = new ExtrasPricingShipping(driver);
    }

    @When("I enter {string} in the discount code field and click Apply")
    public void i_enter_code_in_the_discount_code_field_and_click_apply(String code) {
        extrasPricingShipping.applyDiscount(code);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String message) {
        String actualMessage = extrasPricingShipping.getDiscountFeedbackText();
        if (!actualMessage.equals(message)) {
            throw new AssertionError("Expected message: " + message + " but got: " + actualMessage);
        }
    }


  /*  @When("I clear the discount code field and apply")
    public void i_clear_the_discount_code_field_and_apply() {
        // Clear the discount code field and click Apply
    }

    @Then("I should not see any discount message")
    public void i_should_not_see_any_discount_message() {
        // Assert that no discount message is displayed
    }*/
}
