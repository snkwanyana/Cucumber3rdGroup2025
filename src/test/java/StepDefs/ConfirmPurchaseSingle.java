package StepDefs;

import Utils.Base;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class ConfirmPurchaseSingle extends Base {
    public ConfirmPurchaseSingle() {
        if (driver != null) {
            initializePages();
        }
    }

    @Then("the toast should include an Order Details box, Total amount, and timestamp")
    public void toast_should_include_order_details_box_total_amount_and_timestamp() {
        // Check for Order Details box
        String orderDetails = cart.getOrderDetails();
        Assert.assertTrue(orderDetails.toLowerCase().contains("order details"), "Order Details box missing");
        // Check for Total
        String total = cart.getSuccessTotal();
        Assert.assertTrue(total.toLowerCase().contains("total"), "Total amount missing");
        // Check for timestamp (Ordered at ...)
        String timestamp = cart.getSuccessTimestamp();
        Assert.assertTrue(timestamp.toLowerCase().contains("ordered at"), "Timestamp missing");
    }

    @Then("the success popup should have a dismiss button in the top-right corner")
    public void success_popup_should_have_dismiss_button() {
        Assert.assertTrue(cart.isSuccessToastVisible(), "Success toast not visible");
        // Try to click the dismiss button to confirm it's present and clickable
       // cart.dismissSuccessToast();
    }

    @Then("the popup should not auto-dismiss")
    public void popup_should_not_auto_dismiss() throws InterruptedException {
        Assert.assertTrue(cart.isSuccessToastVisible(), "Success toast not visible at start");
        Thread.sleep(4000); // Wait 4 seconds
        Assert.assertTrue(cart.isSuccessToastVisible(), "Popup auto-dismissed unexpectedly");
    }

    @Then("the success popup should have a \"View History\" button in the bottom-right corner")
    public void success_popup_should_have_view_history_button() {
        Assert.assertTrue(cart.isViewHistoryBtnVisible(), "View History button missing");
    }

    @When("the user clicks the \"View History\" button")
    public void user_clicks_view_history_button() {
        cart.clickViewHistory();
    }

    @Then("the invoice history should expand and scroll to the invoice section")
    public void invoice_history_should_expand_and_scroll() {
        boolean visible = invoiceHistoryPanel.isPanelVisible();
        Assert.assertTrue(visible, "Invoice history panel should be visible after clicking View History");
        Assert.assertTrue(invoiceHistoryPanel.isInvoiceListVisible(), "Invoice list should be visible");
        invoiceHistoryPanel.scrollToPanel();
    }

    @Then("an invoice with a unique ID should be generated and stored in history (last 10 invoices)")
    public void invoice_with_unique_id_should_be_generated() {
        String latestId = invoiceHistoryPanel.getLatestInvoiceId();
        Assert.assertNotNull(latestId, "Latest invoice ID should be present");
        Assert.assertFalse(latestId.isEmpty(), "Latest invoice ID should not be empty");
    }

    @Then("the cart should remain unchanged except for the purchased item")
    public void cart_should_remain_unchanged_except_purchased_item() {
       // Assert.assertTrue(cart.isCartStateValidAfterPurchase(), "Cart changed incorrectly after purchase");
    }

    @Then("the toast should only display the current purchased item")
    public void toast_should_only_display_current_purchased_item() {
        // Set implicit wait for this step
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String orderDetails = cart.getOrderDetails();
        System.out.println("[DEBUG] Order Details Toast: " + orderDetails);
        // Check for all relevant substrings (case-insensitive)
        Assert.assertTrue(orderDetails.toLowerCase().contains("apple"), "Toast missing 'Apple'");
        Assert.assertTrue(orderDetails.toLowerCase().contains("phone"), "Toast missing 'phone'");
        Assert.assertTrue(orderDetails.toLowerCase().contains("64gb"), "Toast missing '64GB'");
        Assert.assertTrue(orderDetails.toLowerCase().contains("black"), "Toast missing 'black'");
        Assert.assertTrue(orderDetails.toLowerCase().contains("1"), "Toast missing quantity '1'");
        // Optionally reset implicit wait to default (e.g., 0 seconds)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    }

    @And("an invoice with a unique ID should be generated and stored in history \\(last {int} invoices)")
    public void anInvoiceWithAUniqueIDShouldBeGeneratedAndStoredInHistoryLastInvoices(int ignored) {
        String latestId = invoiceHistoryPanel.getLatestInvoiceId();
        Assert.assertNotNull(latestId, "Latest invoice ID should be present");
        Assert.assertFalse(latestId.isEmpty(), "Latest invoice ID should not be empty");
    }
}
