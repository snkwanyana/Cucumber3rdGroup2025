package StepDefs;

import PageObjects.ResetsAndNavigationPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ResetsAndNavigationSteps extends Base {

    WebDriver driver;
    ResetsAndNavigationPage resetsPage;

    public ResetsAndNavigationSteps() {
        if (driver == null) {
            driver = Base.getDriver(); // ✅ Ensures driver consistency
        }
        this.resetsPage = new ResetsAndNavigationPage(driver);
    }

    // ----- Confirm Purchase Reset -----
    @Given("I am on the product page")
    public void i_am_on_product_page() {
        // assumed handled via Base or navigation hooks
    }

    @Given("I fill in valid product details {string} {string} {string} {string} {int}")
    public void i_fill_in_valid_product_details(String deviceType, String brand, String storage, String color, int quantity) {
        resetsPage.fillProductDetails(deviceType, brand, storage, color, quantity);
    }


    // ----- Cart Reset -----
    @Given("I have multiple items in the cart {string} {string} {string} and {string} {string} {string}")
    public void i_have_multiple_items_in_cart(String device1, String brand1, String storage1, String device2, String brand2, String storage2) {
        resetsPage.fillProductDetails(device1, brand1, storage1, "Black", 1);
        resetsPage.clickConfirmPurchase();
        resetsPage.fillProductDetails(device2, brand2, storage2, "Silver", 1);
        resetsPage.clickConfirmPurchase();
    }

    @When("I place the cart order")
    public void i_place_cart_order() {
        resetsPage.placeCartOrder();
    }

    @Then("the cart should be empty")
    public void cart_should_be_empty() {
        resetsPage.assertCartEmpty();
    }

    // ----- Navigation & Wizard Reset -----
    @And("I navigate to the {string} tab")
    public void i_navigate_to_tab(String tabName) {
        resetsPage.navigateToTab(tabName);
    }

    @When("I return to the {string} tab")
    public void i_return_to_tab(String tabName) {
        resetsPage.navigateBackToWebTab();
    }

    @Then("the wizard should return to Step1 and be cleared")
    public void wizard_should_return_to_step1() {
        resetsPage.assertWizardResetToStep1();
        resetsPage.assertFormReset();
    }
}
