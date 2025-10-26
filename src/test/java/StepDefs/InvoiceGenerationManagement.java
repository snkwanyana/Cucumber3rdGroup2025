package StepDefs;

import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class InvoiceGenerationManagement extends Base {

    public InvoiceGenerationManagement() {
        if (driver != null) {
            initializePages();
        }
    }

    @Then("an invoice should be automatically created with a unique sequential ID")
    public void anInvoiceShouldBeAutomaticallyCreatedWithAUniqueSequentialID() {
        history

    }


    @And("the invoice should include the company logo, customer details, itemized list, totals, and professional formatting")
    public void theInvoiceShouldIncludeTheCompanyLogoCustomerDetailsItemizedListTotalsAndProfessionalFormatting() {

    }

    @And("the invoice should be stored with customerName, customerEmail, deliveryAddress, items, total, and htmlContent")
    public void theInvoiceShouldBeStoredWithCustomerNameCustomerEmailDeliveryAddressItemsTotalAndHtmlContent() {

    }

    @When("the user clicks the view button for the latest invoice")
    public void theUserClicksTheViewButtonForTheLatestInvoice() {
        invoiceHistoryPanel.clickAnyViewInvoiceButton();
    }

    @Then("the invoice should open in a new tab")
    public void theInvoiceShouldOpenInANewTab() {
        invoice.isCompanyLogoVisible();
    }
}
