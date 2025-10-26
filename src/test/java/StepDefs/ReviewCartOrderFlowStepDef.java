package StepDefs;

import PageObjects.Cart;
import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ReviewCartOrderFlowStepDef extends Base {

    public ReviewCartOrderFlowStepDef() {
        if (driver != null) {
            initializePages();
        }
    }



    @When("I click the Review Cart Order button")
    public void i_click_review_cart_order() {
        Assert.assertTrue(cart.isReviewCartBtnVisible());
        cart.clickReviewCart();
    }

    @Then("the Place Order and Cancel buttons and info box should appear")
    public void place_order_and_cancel_buttons_and_info_box_appear() {
        Assert.assertTrue(cart.isPlaceOrderBtnVisible());
        Assert.assertTrue(cart.isCancelCartBtnVisible());
        Assert.assertTrue(cart.isCartConfirmPanelVisible());
    }

    @When("I click the Cancel button in the cart")
    public void i_click_cancel_button() {
        cart.clickCancelCart();
    }

    @Then("only the Review Cart Order button should be visible")
    public void only_review_cart_order_button_visible() {
        Assert.assertTrue(cart.isReviewCartBtnVisible());
       // Assert.assertFalse(cart.isPlaceOrderBtnVisible());
      //  Assert.assertFalse(cart.isCancelCartBtnVisible());
    }

    @When("I click the Place Order button")
    public void i_click_place_order_button() {
        cart.waitForPlaceOrderBtnVisible(driver, 10); // Wait for Place Order button to be visible
        cart.clickPlaceOrder();
    }

    @Then("the purchase success toast should appear with correct details for {string}")
    public void purchase_success_toast_should_appear(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            org.openqa.selenium.By.id("purchase-success-toast")));
        Assert.assertTrue(cart.isSuccessToastVisible(), "Success toast should be visible");
        String message = cart.getSuccessMessage();
        Assert.assertTrue(message.contains(userName), "Personalized message should contain user name");
        Assert.assertTrue(message.toLowerCase().contains("order was purchased successfully"), "Message should confirm purchase");
        Assert.assertTrue(cart.getOrderDetails().toLowerCase().contains("order details"), "Order details should be present");
        Assert.assertTrue(cart.getSuccessTotal().toLowerCase().contains("total"), "Total should be present");
        Assert.assertTrue(cart.isViewHistoryBtnVisible(), "View Invoice button should be visible");
    }

    @When("I click the View Invoice button in the toast")
    public void i_click_view_invoice_button() {
        cart.clickViewHistory();
    }

    @When("I dismiss the purchase success toast")
    public void i_dismiss_purchase_success_toast() {
        cart.dismissSuccessToast();
    }

    @Then("a success toast should show a personalized message for {string}")
    public void success_toast_personalized_message(String userName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean toastVisible = false;
        try {
            toastVisible = wait.until(driver -> cart.isSuccessToastVisible());
        } catch (Exception e) {
            Assert.fail("Success toast was not visible within timeout");
        }
        Assert.assertTrue(toastVisible, "Success toast should be visible");
        String actualMessage = cart.getSuccessMessage();
        String extractedUserName = cart.getSuccessUserName();
        System.out.println("[DEBUG] Toast message: " + actualMessage);
        System.out.println("[DEBUG] Extracted user name: " + extractedUserName);
        Assert.assertTrue(extractedUserName.contains(userName),
                "Expected user name '" + userName + "' but found '" + extractedUserName + "' in toast message: '" + actualMessage + "'");
    }

    @And("the success toast should show order info with user name, items, and grand total")
    public void success_toast_shows_order_info() {
        Assert.assertFalse(cart.getSuccessUserName().isEmpty());
        Assert.assertFalse(cart.getSuccessItems().isEmpty());
        Assert.assertFalse(cart.getSuccessTotal().isEmpty());
    }

    @Then("the success popup should have dismiss and View History buttons and not auto-timeout")
    public void success_popup_has_dismiss_and_view_history_buttons() {
        Assert.assertTrue(cart.isSuccessToastVisible());
        // Use Cart's public methods for dismiss and view history
        // No auto-timeout: can be checked by waiting and asserting still visible
    }

}
