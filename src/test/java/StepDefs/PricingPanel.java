package StepDefs;
import Utils.Base;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertEquals;

public class PricingPanel extends Base {

    @Given("The User is on the Form page")
    public void The_user_is_on_the_form_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
        loginPage.enterEmail("Amytest@gmail.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginField();
        welcomePage.clickWebTabButton();
    }

    @Then("user selects device type price panel {}")
    public void the_user_selects_device_type_price_panel (String type) {
        orderingPage.selectDeviceType(type);

    }
    @Then("user selects brand {}")
    public void the_user_selects_brand(String brand) {
        orderingPage.selectBrand(brand);

    }
    @Then("user selects storage {}")
    public void the_user_selects_storage(String storage) {
        orderingPage.selectStorage(storage);

    }
    @Then("user selects color {}")
    public void the_user_selects_color( String color) {
        orderingPage.selectColor(color);

    }
    @Then("user enters quantity {int}")
    public void the_user_enters_quantity(Integer quantity) {
        orderingPage.setQuantity(quantity);

    }
    @Then("user enters address {}")
    public void the_user_enters_address_main_st_cityville(String address) {
        orderingPage.setAddress(address);

    }
    @When("user clicks the Next button")
    public void the_user_clicks_the_next_button() {
        orderingPage.clickNext();

    }
    @Then("Pricing Panel should be displayed")
    public void step_should_be_displayed() {
        pricingParnel.verifyPricingBreakdownTitleIsDisplayed();

    }
    @Then("the base price should display {}")
    public void the_base_price_should_display(String expectedPrice) {
        String actualPrice = pricingParnel.getBasePrice();
        assertEquals(expectedPrice, actualPrice);
    }

    @Then("the subtotal should display {}")
    public void the_subtotal_should_display(String expectedSubtotal) {
        String actualSubtotal = pricingParnel.getBreakdownSubtotal();
        assertEquals(expectedSubtotal, actualSubtotal);
    }

}
