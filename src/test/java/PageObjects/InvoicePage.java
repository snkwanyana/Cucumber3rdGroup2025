package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InvoicePage {

    @FindBy(id="invoices-toggle-btn")
    WebElement invoiceToggleButton_id;

    @FindBy(id="tab-btn-web")
    WebElement webAutomationAdvanceButton_id;

    @FindBy(xpath = "//img[@class='company-logo']")
    WebElement companyLogo_xpath;

    @FindBy(xpath = "//div[@class='customer-info']//strong[text()='Hisense Crock']")
    WebElement customerName_xpath;

    @FindBy(xpath = "//div[@class='customer-info']//div[contains(text(),'@')]")
    WebElement customerEmail_xpath;

    @FindBy(xpath = "//div[@class='invoice-info']//strong[contains(text(),'Invoice #:')]")
    WebElement invoiceNumber_xpath;

    @FindBy(xpath = "//table[@class='items-table']")
    WebElement itemTable_xpath;

    @FindBy(xpath = "//div[@class='totals']//div[contains(text(),'Total:')]")
    WebElement totalAmount_xpath;

    @FindBy(xpath = "//div[contains(text(),'Thank you for your business')]")
    WebElement thankYouMessage_xpath;

    @FindBy(xpath = "//div[@class='footer']")
    WebElement footer_xpath;


    WebDriver driver;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators using XPath or ID (Assuming IDs are not available, using XPath)

    public void clickInvoiceToggleButton(){
        invoiceToggleButton_id.click();
    }


    public void getCompanyLogo() {

        companyLogo_xpath.isDisplayed();

    }

    public void getCustomerName() {
        customerName_xpath.isDisplayed();
    }

    public void getCustomerEmail() {
        customerEmail_xpath.isDisplayed();
    }

    public void getInvoiceNumber() {
        invoiceNumber_xpath.isDisplayed();
    }

    public void getItemTable() {
        itemTable_xpath.isDisplayed();
    }

    public void getTotalAmount(String expectedTotal) {
        Assert.assertEquals(expectedTotal,totalAmount_xpath.getText().contains("R5934.60"));
    }

    public void getThankYouMessage() {
        thankYouMessage_xpath.isDisplayed();

    }

    public void clickWebAutomationAdvance(){
        webAutomationAdvanceButton_id.click();
    }

    public void getFooter() {
        footer_xpath.isDisplayed();

    }
}
