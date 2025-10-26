package StepDefs;
import PageObjects.ExtrasPricingShipping;
import Utils.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class ExtrasPricing extends Base {
    private ExtrasPricingShipping extrasPricingShipping;

    public ExtrasPricing() {
        extrasPricingShipping = new ExtrasPricingShipping(driver);
    }

    @When("the user selects {} shipping")
    public void the_user_selects_shipping(String shipping) {
        extrasPricingShipping.selectShipping(shipping);
       // pricingParnel.selectShipping(shipping);
    }

    @When("selects {} warranty")
    public void selects_warranty(String warranty) {
        extrasPricingShipping.selectWarranty(warranty);
        //pricingParnel.selectWarranty(warranty);
    }

    @When("enters discount code {}")
    public void enters_discount_code(String code) {
        if (code != null && !code.trim().isEmpty()) {
            extrasPricingShipping.applyDiscount(code);
           // pricingParnel.enterDiscountCode(code);
        }
    }

    @Then("the discount on price breakdown should be {}")
    public void the_discount_on_price_price_breakdown_should_be(String expected) {
        assertEquals(expected, extrasPricingShipping.getBreakdownDiscount());
    }

    @And("the total on Price breakdown should be {}")
    public void the_total_on_price_breakdown_should_be_total(String expected) {
        assertEquals(expected, extrasPricingShipping.getBreakdownTotal());
    }

    @And("the subtotal on price breakdown should be {}")
    public void the_subtotal_on_price_breakdown_should_be_subtotal(String expected) {
        assertEquals(expected, extrasPricingShipping.getBreakdownSubtotal());

    }

    @And("the quantity on price breakdown should be {}")
    public void the_quantity_on_price_breakdown_should_be_quantity(String expected) {
        assertEquals(expected, extrasPricingShipping.getBreakdownQuantity());
    }

    @Then("the base price on price breakdown should be {}")
    public void the_base_price_on_price_breakdown_should_be_base(String expected) {
        assertEquals(expected, extrasPricingShipping.getBasePrice());
    }
}
