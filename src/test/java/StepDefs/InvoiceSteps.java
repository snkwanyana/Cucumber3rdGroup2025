package StepDefs;

import PageObjects.InvoicePage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class InvoiceSteps extends Base {

    WebDriver driver;
    InvoicePage invoicePage;

    public InvoiceSteps() {
        if (driver == null) {
            driver = Base.getDriver(); // Ensure driver reference is initialized
        }
        this.invoicePage = new InvoicePage(driver);
    }

    // --- Invoice Item Verification ---
    @Given("I have completed a purchase with {string}")
    public void i_have_completed_purchase(String items) {
        invoicePage.waitForInvoiceToLoad();
    }

    @Then("the invoice should list {string} items")
    public void the_invoice_should_list_items(String count) {
        invoicePage.verifyItemCount(Integer.parseInt(count));
    }

    @Then("each item should have correct calculated totals")
    public void each_item_should_have_correct_totals() {
        invoicePage.verifyTotalsCalculated();
    }

    // --- Discount and Extra Charges ---
    @Given("I have completed a purchase with {string} discount, {string} shipping, and {string} warranty")
    public void i_have_completed_purchase_with_discount(String discount, String shipping, String warranty) {
        invoicePage.waitForInvoiceToLoad();
    }

    @Then("the invoice should display discount and all extra charges correctly")
    public void the_invoice_should_display_discount_and_extras_correctly() {
        invoicePage.verifyDiscountAndExtras();
    }

    // --- PDF Layout ---
    @Given("I view the generated PDF invoice")
    public void i_view_pdf_invoice() {
        invoicePage.waitForInvoiceToLoad();
    }

    @Then("the PDF should display logo, proper layout, and customer info")
    public void pdf_should_display_logo_and_layout() {
        invoicePage.verifyPDFLayout();
    }

    @Then("the {string} message and footer should stay within margins")
    public void thank_you_and_footer_within_margins(String ignored) {
        invoicePage.verifyPDFLayout(); // Includes margin/footer validation
    }

    // --- Invoice Numbering & History ---
    @Given("I have placed {string} purchases")
    public void i_have_placed_purchases(String invoiceCount) {
        invoicePage.waitForInvoiceToLoad();
    }

    @Then("invoice numbers should increment sequentially")
    public void invoice_numbers_should_increment() {
        invoicePage.verifyInvoiceNumberSequence();
    }

    @Then("only the last 10 invoices should be retained")
    public void only_last_10_invoices_retained() {
        invoicePage.verifyHistoryLimit();
    }

    // --- Invoice Actions ---
    @Given("I have an invoice available")
    public void i_have_invoice_available() {
        invoicePage.waitForInvoiceToLoad();
    }

    @When("I {string} the invoice")
    public void i_perform_invoice_action(String action) {
        invoicePage.performInvoiceAction(action);
    }

    @Then("the system should respond appropriately")
    public void system_should_respond() {
        invoicePage.waitForInvoiceToLoad();
    }

    // --- History Panel ---
    @When("I open the invoice history panel")
    public void i_open_invoice_history_panel() {
        invoicePage.verifyHistoryPanelBehavior();
    }

    @Then("it should scroll smoothly and expand")
    public void history_should_expand() {
        invoicePage.verifyHistoryPanelBehavior();
    }

    @Then("if empty, show {string} message")
    public void if_empty_show_message(String ignored) {
        invoicePage.verifyEmptyHistoryMessage();
    }

    // --- Logo and Customer Info ---
    @Given("I open the invoice")
    public void i_open_the_invoice() {
        invoicePage.waitForInvoiceToLoad();
    }

    @Then("the company logo should display in both HTML and PDF")
    public void logo_should_display_in_both_versions() {
        invoicePage.verifyLogoAndCustomerData();
    }

    @Then("customer name, email, and delivery address should appear in Bill To section")
    public void customer_data_should_display() {
        invoicePage.verifyLogoAndCustomerData();
    }
}
