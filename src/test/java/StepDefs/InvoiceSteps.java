package StepDefs;

import Utils.Base;
import io.cucumber.java.en.*;
import org.junit.Assert;
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


    }

    @Then("the company logo should be visible")
    public void the_company_logo_should_be_visible() {
        invoicePage.verifyCompanyLogo();
    }

    @And("customer name {}, email{}, and address {} should be visible")
    public void customer_details_should_be_visible(String expectedName,String expectedEmail,String expectedAddress) {
        invoicePage.getCustomerName(expectedName);
        invoicePage.getCustomerEmail(expectedEmail);
        invoicePage.getCustomerAddress(expectedAddress);

    }

    @And("the invoice should contain an itemized list")
    public void the_invoice_should_contain_an_itemized_list() {
        List<WebElement> rows = driver.findElements(By.cssSelector(".items-table tbody tr"));
        Assert.assertTrue("Itemized list should have at least one item", rows.size() > 0);
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            Assert.assertEquals("Each row should have 4 columns", 4, columns.size());
        }
    }

    @And("the invoice status should be { }")
    public void the_invoice_status_should_be_paid(){

    }

    @And("the totals section should display subtotal{}, shipping{}, and total{}")
    public void totals_should_be_displayed() {
        Assert.assertFalse(invoicePage.getSubtotal().isEmpty());
        Assert.assertFalse(invoicePage.getShipping().isEmpty());
        Assert.assertFalse(invoicePage.getTotal().isEmpty());
    }

    @And("the page should display a thank you message {}")
    public void thank_you_message_should_be_displayed() {
        String message = invoicePage.getThankYouMessage();
        Assert.assertTrue(message.toLowerCase().contains("thank you"));
    }

    @And("the invoice should have professional formatting")
    public void the_invoice_should_have_professional_formatting() {
        WebElement container = driver.findElement(By.cssSelector(".invoice-container"));
        Assert.assertTrue("Invoice container should be displayed", container.isDisplayed());

        String bgColor = container.getCssValue("background-color");
        Assert.assertNotNull("Should have a background color", bgColor);

        String fontSize = container.getCssValue("font-size");
        Assert.assertNotNull("Font size should be defined", fontSize);
    }
}
