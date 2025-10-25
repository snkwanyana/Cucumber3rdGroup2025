package StepDefs;

import PageObjects.ReviewCartPage;
import Utils.Base;
import io.cucumber.java.en.*;

public class ReviewCartSteps extends Base {

    ReviewCartPage reviewCartPage;

    public ReviewCartSteps() {
        if (driver == null) {
            driver = Base.getDriver(); // Ensure driver is available
        }
        this.reviewCartPage = new ReviewCartPage(driver);
    }

    @Given("I am on the cart page")
    public void i_am_on_cart_page() {
        // Assuming user already added items to cart — nothing extra needed here.
    }

    @When("I click Review Cart Order")
    public void i_click_review_cart_order() {
        reviewCartPage.clickReviewCartOrder();
    }

    @Then("Place Order and Cancel buttons with info box should appear")
    public void place_cancel_buttons_visible() {
        reviewCartPage.assertPlaceOrderAndCancelVisible();
    }

    @Given("I clicked Review Cart Order")
    public void i_clicked_review_cart_order() {
        reviewCartPage.clickReviewCartOrder();
    }

    @When("I click Cancel")
    public void i_click_cancel() {
        reviewCartPage.clickCancel();
    }

    @Then("the Review Cart Order button should be visible again")
    public void review_cart_button_visible_again() {
        reviewCartPage.assertReviewCartVisibleAgain();
    }

    @When("I click Place Order")
    public void i_click_place_order() {
        reviewCartPage.clickPlaceOrder();
    }

    @Then("a success toast should appear with message {string}")
    public void success_toast_with_message(String expectedMessage) {
        reviewCartPage.assertSuccessToast(expectedMessage);
    }

    @Then("the success popup should show user {string} with cart items and grand total")
    public void success_popup_with_details(String userName) {
        reviewCartPage.assertSuccessPopup(userName);
    }

    @Then("the invoice should be generated with all items and totals")
    public void invoice_should_generate() {
        reviewCartPage.assertInvoiceGenerated();
    }

    @Given("I placed an order")
    public void i_placed_an_order() {
        reviewCartPage.clickReviewCartOrder();
        reviewCartPage.clickPlaceOrder();
    }

    @Then("the success popup should have dismiss and view history buttons")
    public void popup_controls_visible() {
        reviewCartPage.assertPopupControls();
    }

    @When("I double-click Place Order quickly")
    public void double_click_place_order() {
        reviewCartPage.doubleClickPlaceOrder();
    }

    @Then("only one success toast should appear")
    public void only_one_success_toast() {
        reviewCartPage.assertOnlyOneToast();
    }
}
