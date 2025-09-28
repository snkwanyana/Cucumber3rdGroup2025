package StepDefs;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class ExtrasPricing extends Base {
    WebDriver drive;
    @Given("the user is on the pricing panel")
    public void the_user_is_on_the_pricing_panel() {
        landingPage.clickLearnMoreButton();
        loginPage.enterEmail("Amytest@gmail.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginField();
        welcomePage.clickWebTabButton();
        orderingPage.selectDeviceType("Phone");
        orderingPage.selectBrand("Apple");
        orderingPage.selectStorage("64GB");
        orderingPage.selectColor("Black");
        orderingPage.setQuantity(1);
        orderingPage.setAddress("123 Main St, Cityville");
        orderingPage.clickNext();
    }

    @When("the user selects {string} shipping")
    public void the_user_selects_shipping(String shipping) {
        pricingParnel.selectShipping(shipping);
    }

    @When("selects {string} warranty")
    public void selects_warranty(String warranty) {
        pricingParnel.selectWarranty(warranty);
    }

    @When("enters discount code {string}")
    public void enters_discount_code(String code) {
        if (code != null && !code.trim().isEmpty()) {
            pricingParnel.enterDiscountCode(code);
        }
    }

    @When("sets quantity to {int}")
    public void sets_quantity_to(Integer qty) {
        // Implement this if you have a quantity input in your page object
        // pricingPanel.setQuantity(qty);
    }

    @Then("the base price should be {string}")
    public void the_base_price_should_be(String expected) {
        assertEquals(expected, pricingParnel.getBasePrice());
    }

    @Then("the subtotal should be {string}")
    public void the_subtotal_should_be(String expected) {
        assertEquals(expected, pricingParnel.getBreakdownSubtotal());
    }

    @Then("the discount should be {string}")
    public void the_discount_should_be(String expected) {
        assertEquals(expected, pricingParnel.getBreakdownDiscount());
    }

    @Then("the total should be {string}")
    public void the_total_should_be(String expected) {
        assertEquals(expected, pricingParnel.getBreakdownTotal());
    }

}
