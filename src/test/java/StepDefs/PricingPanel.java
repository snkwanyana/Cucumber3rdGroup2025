package StepDefs;
import Utils.Base;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class PricingPanel extends Base {

    public PricingPanel() {
        if (driver != null) {
            initializePages();
        }
    }

    @Then("the unit price should be {}")
    public void the_unit_price_should_be(String expectedBasePrice) {
        assertEquals(pricingParnel.getUnitPrice(), expectedBasePrice);
    }

    @And("the subtotal should be {}")
    public void the_subtotal_should_be(String expectedSubtotal) {
        assertEquals(pricingParnel.getSubtotal(), expectedSubtotal);
    }
}
