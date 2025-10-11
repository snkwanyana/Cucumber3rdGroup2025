package StepDefs;

import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class InvoiceSteps extends Base {
    public WebDriver driver;

    public InvoiceSteps() {
        this.driver = super.driver;
    }

    @Given("I am on the invoice page")
    public void i_am_on_the_invoice_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();

        loginPage.enterEmail("HisenseCrock@example.com");
        loginPage.enterPassword("Pass1234");
        loginPage.clickLoginButton();

        invoicePage.clickWebAutomationAdvance();


    }

    @Then("I should see the company logo")
    public void i_should_see_the_company_logo() {

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

    @After
    public void quitBrowser() {
        driver.quit();
    }
}
