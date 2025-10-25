package StepDefs;

import PageObjects.DiscountPage;
import Utils.Base;
import io.cucumber.java.en.*;

public class DiscountSteps extends Base {

    DiscountPage discountPage;

    @Given("I am on thee product page")
    public void i_am_on_the_product_page() {
        // ✅ Log in and navigate from Base setup
        login("ree@test.com", "Password@123");
        practiceAssessmentsPage.clickWebAutomation();

        // Pre-selects before reaching discount field
        pricingPanelPage.selectDeviceType("Phone");
        pricingPanelPage.selectBrand("Apple");
        pricingPanelPage.selectStorage("128GB");
        pricingPanelPage.setQuantity(1);
        pricingPanelPage.enterAddress("123 Main St, City, Country");
        pricingPanelPage.clickNext();

        // Initialize discount page once loaded
        discountPage = new DiscountPage(driver);
    }

    @When("I enter discount code {string} and click apply")
    public void i_enter_discount_code_and_click_apply(String code) {
        discountPage.enterDiscountCode(code);
        discountPage.clickApply();
    }

    @When("I clear the discount input and click apply")
    public void i_clear_the_discount_input_and_click_apply() {
        discountPage.clearDiscountInput();
        discountPage.clickApply();
    }

    @Then("I should see thee message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        discountPage.assertDiscountMessage(expectedMessage);
    }

    @Then("no discount message should be displayed")
    public void no_discount_message_should_be_displayed() {
        discountPage.assertDiscountMessage("");
    }
}
