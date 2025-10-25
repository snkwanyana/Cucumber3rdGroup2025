package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class InvoicePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // --- Invoice core elements ---
    @FindBy(id = "invoice-container")
    WebElement invoiceContainer;

    @FindBy(css = "[data-testid='invoice-item-row']")
    List<WebElement> invoiceItemRows;

    @FindBy(css = "[data-testid='invoice-total']")
    WebElement invoiceTotal;

    @FindBy(css = "[data-testid='invoice-discount']")
    WebElement invoiceDiscount;

    @FindBy(css = "[data-testid='invoice-shipping']")
    WebElement invoiceShipping;

    @FindBy(css = "[data-testid='invoice-warranty']")
    WebElement invoiceWarranty;

    @FindBy(css = "[data-testid='invoice-number']")
    WebElement invoiceNumber;

    @FindBy(css = "[data-testid='invoice-logo']")
    WebElement invoiceLogo;

    @FindBy(css = "[data-testid='customer-name']")
    WebElement customerName;

    @FindBy(css = "[data-testid='customer-email']")
    WebElement customerEmail;

    @FindBy(css = "[data-testid='customer-address']")
    WebElement customerAddress;

    @FindBy(css = "[data-testid='thank-you-message']")
    WebElement thankYouMessage;

    @FindBy(css = "[data-testid='invoice-footer']")
    WebElement invoiceFooter;

    @FindBy(css = "[data-testid='invoice-history-item']")
    List<WebElement> invoiceHistoryItems;

    @FindBy(css = "[data-testid='no-invoices-message']")
    WebElement noInvoicesMessage;

    @FindBy(css = "[data-testid='view-invoice-btn']")
    WebElement viewInvoiceBtn;

    @FindBy(css = "[data-testid='download-pdf-btn']")
    WebElement downloadPdfBtn;

    @FindBy(css = "[data-testid='delete-invoice-btn']")
    WebElement deleteInvoiceBtn;

    @FindBy(css = "[data-testid='invoice-history-panel']")
    WebElement historyPanel;

    // --- Helper ---
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    private void safeWait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollIntoView(element);
    }

    // --- Core Methods ---
    public void waitForInvoiceToLoad() {
        safeWait(invoiceContainer);
    }

    public void verifyItemCount(int expectedCount) {
        waitForInvoiceToLoad();
        wait.until(ExpectedConditions.visibilityOfAllElements(invoiceItemRows));
        Assert.assertEquals(invoiceItemRows.size(), expectedCount, "❌ Invoice item count mismatch!");
    }

    public void verifyTotalsCalculated() {
        waitForInvoiceToLoad();
        for (WebElement row : invoiceItemRows) {
            String subtotal = row.findElement(By.cssSelector("[data-testid='item-subtotal']")).getText();
            Assert.assertTrue(subtotal.startsWith("R"), "❌ Missing subtotal for item!");
        }
        Assert.assertTrue(invoiceTotal.getText().contains("R"), "❌ Invoice total not found!");
    }

    public void verifyDiscountAndExtras() {
        waitForInvoiceToLoad();
        Assert.assertTrue(invoiceDiscount.isDisplayed(), "❌ Discount not displayed!");
        Assert.assertTrue(invoiceShipping.isDisplayed(), "❌ Shipping not displayed!");
        Assert.assertTrue(invoiceWarranty.isDisplayed(), "❌ Warranty not displayed!");
    }

    public void verifyPDFLayout() {
        waitForInvoiceToLoad();
        Assert.assertTrue(invoiceLogo.isDisplayed(), "❌ Logo missing in PDF!");
        Assert.assertTrue(customerName.isDisplayed(), "❌ Customer name missing!");
        Assert.assertTrue(customerEmail.isDisplayed(), "❌ Customer email missing!");
        Assert.assertTrue(customerAddress.isDisplayed(), "❌ Customer address missing!");
        Assert.assertTrue(thankYouMessage.isDisplayed(), "❌ Thank-you message missing!");
        Assert.assertTrue(invoiceFooter.isDisplayed(), "❌ Footer missing or out of margins!");
    }

    public void verifyInvoiceNumberSequence() {
        wait.until(ExpectedConditions.visibilityOfAllElements(invoiceHistoryItems));
        int prev = -1;
        for (WebElement item : invoiceHistoryItems) {
            String text = item.getText().replaceAll("[^0-9]", "");
            int num = Integer.parseInt(text);
            if (prev != -1) {
                Assert.assertTrue(num > prev, "❌ Invoice number not sequential!");
            }
            prev = num;
        }
    }

    public void verifyHistoryLimit() {
        wait.until(ExpectedConditions.visibilityOfAllElements(invoiceHistoryItems));
        Assert.assertTrue(invoiceHistoryItems.size() <= 10, "❌ More than 10 invoices retained!");
    }

    public void performInvoiceAction(String action) {
        waitForInvoiceToLoad();
        switch (action.toLowerCase()) {
            case "view" -> wait.until(ExpectedConditions.elementToBeClickable(viewInvoiceBtn)).click();
            case "download" -> wait.until(ExpectedConditions.elementToBeClickable(downloadPdfBtn)).click();
            case "delete" -> wait.until(ExpectedConditions.elementToBeClickable(deleteInvoiceBtn)).click();
            default -> throw new IllegalArgumentException("Unknown action: " + action);
        }
    }

    public void verifyHistoryPanelBehavior() {
        wait.until(ExpectedConditions.visibilityOf(historyPanel));
        scrollIntoView(historyPanel);
        Assert.assertTrue(historyPanel.isDisplayed(), "❌ History panel not expanded or not scrollable!");
    }

    public void verifyEmptyHistoryMessage() {
        if (invoiceHistoryItems.isEmpty()) {
            wait.until(ExpectedConditions.visibilityOf(noInvoicesMessage));
            Assert.assertTrue(noInvoicesMessage.getText().contains("No invoices"), "❌ No invoices message missing!");
        }
    }

    public void verifyLogoAndCustomerData() {
        waitForInvoiceToLoad();
        Assert.assertTrue(invoiceLogo.isDisplayed(), "❌ Logo missing!");
        Assert.assertTrue(customerName.isDisplayed(), "❌ Customer name missing!");
        Assert.assertTrue(customerEmail.isDisplayed(), "❌ Customer email missing!");
        Assert.assertTrue(customerAddress.isDisplayed(), "❌ Customer address missing!");
    }
}
