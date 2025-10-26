package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice {
    private WebDriver driver;

    @FindBy(className = "company-logo")
    WebElement companyLogo;

    @FindBy(className = "customer-info")
    WebElement customerDetails;

    @FindBy(id = "itemized-list")
    WebElement itemizedList;

    @FindBy(id = "invoice-totals")
    WebElement invoiceTotals;

    @FindBy(id = "invoice-customer-name")
    WebElement invoiceCustomerName;

    @FindBy(css = ".invoice-professional")
    WebElement professionalFormatting;

    public Invoice(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCompanyLogoVisible() {
        return companyLogo.isDisplayed();
    }

    public boolean isCustomerDetailsVisible() {
        return customerDetails.isDisplayed();
    }

    public boolean isItemizedListVisible() {
        return itemizedList.isDisplayed();
    }

    public boolean isTotalsVisible() {
        return invoiceTotals.isDisplayed();
    }

    public boolean isProfessionalFormattingApplied() {
        return professionalFormatting.isDisplayed();
    }

    public String getCustomerNameOnInvoice() {
        return invoiceCustomerName.getText();
    }
}
