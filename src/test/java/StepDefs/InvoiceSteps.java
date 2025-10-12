package StepDefs;

import Utils.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class InvoiceSteps {
    @Given("I am on the invoice page")
    public void i_am_on_the_invoice_page() {
        Hooks.base.landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        Hooks.base.landingPage.clickLearnMoreButton();

        Hooks.base.loginPage.enterEmail("HisenseCrock@example.com");
        Hooks.base.loginPage.enterPassword("Pass1234");
        Hooks.base.loginPage.clickLoginButton();

        Hooks.base.invoicePage.clickWebAutomationAdvance();

        Hooks.base.invoicePage.clickInvoiceToggleButton();

        //Hooks.base.inventoryFormPage.clickViewInvoicePopUp();

        //Hooks.base.inventoryFormPage.clickViewButtonInsidePop();

    }

    @Then("I should see the company logo")
    public void i_should_see_the_company_logo() {
        //Hooks.base.invoicePage.getCompanyLogo();
    }

    @And("I should see customer details")
    public void i_should_see_customer_details() {

    }

    @And("I should see invoice details")
    public void i_should_see_invoice_details() {

    }

    @And("I should see the itemized list of products")
    public void i_should_see_the_itemized_list_of_products() {

    }

    @And("I should see the totals including discounts and final total {}")
    public void i_should_see_the_totals_including_discounts_and_final_total(String expectedTotal) {

    }

    @And("I should see professional formatting elements")
    public void i_should_see_professional_formatting_elements() {


    }


}
