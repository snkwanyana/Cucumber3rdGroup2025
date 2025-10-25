package StepDefs;

import PageObjects.ExtrasPricingPage;
import Utils.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import java.awt.*;

import static com.ndosi.utils.BrowserFactory.getDriver;

public class ExtrasPricingSteps extends Base {
    ExtrasPricingPage extrasPricing;

    @Before
    public void setUpPage() {
        extrasPricing = new ExtrasPricingPage(getDriver());
    }

    @When("the user toggles shipping {string}")
    public void the_user_toggles_shipping(String shipping) {
        extrasPricing.toggleShipping(shipping);
    }

    @When("the user selects warranty {string}")
    public void the_user_selects_warranty(String warranty) {
        extrasPricing.selectWarranty(warranty);
    }

    @Then("the extras panel should show Shipping {string} and Warranty {string}")
    public void the_extras_panel_should_show_shipping_and_warranty(String shippingPrice, String warrantyPrice) {
        extrasPricing.assertExtras(shippingPrice, warrantyPrice);
    }

    @And("the user clicks Purchase Device")
    public void theUserClicksPurchaseDevice() {
        extrasPricing.clickNext();
    }

    @And("the user enters the delivery address {string}")
    public void theUserEntersTheDeliveryAddress(String address) {
        extrasPricing.enterAddress(address);
    }

    @And("the user selects the brand {string}")
    public void theUserSelectsTheBrand(String brand) {
        extrasPricing.selectBrand(brand);
    }



    @And("the user sets the quantity {int}")
    public void theUserSetsTheQuantity(int quantity) {
        extrasPricing.setQuantity(quantity);
    }

    @Then("the pricing panel should show {string} and Subtotal {string}")
    public void thePricingPanelShouldShowAndSubtotal(String unitPrice, String subtotal) throws InterruptedException, AWTException {
        pricingPanelPage.assertPricing(unitPrice, subtotal);
    }


}
