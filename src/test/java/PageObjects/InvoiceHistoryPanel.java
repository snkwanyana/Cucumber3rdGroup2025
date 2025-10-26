package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class InvoiceHistoryPanel {
    private WebDriver driver;

    @FindBy(id = "invoice-history-panel")
    WebElement invoiceHistoryPanel;

    @FindBy(id = "invoice-history-title")
    WebElement invoiceHistoryTitle;

    @FindBy(id = "invoices-list")
    WebElement invoicesList;

    @FindBy(xpath = "//button[starts-with(@id, 'view-invoice-INV')]")
    WebElement viewInvoiceInvButton;


    public InvoiceHistoryPanel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPanelVisible() {
        try {
            return invoiceHistoryPanel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public String getTitle() {
        return invoiceHistoryTitle.getText();
    }

    public List<WebElement> getAllInvoices() {
        return invoicesList.findElements(By.xpath(".//div[starts-with(@id,'invoice-item-')]"));
    }

    public String getLatestInvoiceId() {
        List<WebElement> invoices = getAllInvoices();
        if (!invoices.isEmpty()) {
            WebElement latest = invoices.get(0); // Assuming newest is first
            WebElement idElem = latest.findElement(By.xpath(".//div[starts-with(@id,'invoice-number-')]"));
            return idElem.getText();
        }
        return "";
    }

    public boolean hasInvoiceWithId(String invoiceId) {
        return !invoicesList.findElements(By.xpath(".//div[@id='invoice-number-" + invoiceId + "']")).isEmpty();
    }

    public boolean isInvoiceListVisible() {
        return invoicesList.isDisplayed();
    }

    public void scrollToPanel() {
        org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
        org.openqa.selenium.WebElement panel = getPanelElement();
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", panel);
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }

    private WebElement getPanelElement() {
        return invoiceHistoryPanel;
    }


    /**
     * Clicks the 'View' button for a given invoice id.
     * @param invoiceId The invoice id (e.g. INV-1760114408749)
     */
    public void clickViewInvoiceById(String invoiceId) {
        String buttonId = "view-invoice-" + invoiceId;
        WebElement viewButton = driver.findElement(By.id(buttonId));
        viewButton.click();
    }

    /**
     * Clicks the 'View' button for the latest invoice in the list.
     */
    public void clickViewInvoiceForLatest() {
        String latestInvoiceId = getLatestInvoiceId();
        if (!latestInvoiceId.isEmpty()) {
            clickViewInvoiceById(latestInvoiceId);
        } else {
            throw new RuntimeException("No invoices found to view.");
        }
    }

    /**
     * Clicks the 'View' button for any invoice whose id starts with 'view-invoice-INV'.
     */
    public void clickAnyViewInvoiceButton() {
        viewInvoiceInvButton.click();
    }



}
