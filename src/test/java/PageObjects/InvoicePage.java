package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class InvoicePage {
    WebDriver driver;

    public InvoicePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className =  ".customer-info .info-line strong")
    WebElement customerName_css;

    @FindBy(className = ".customer-info .info-line:nth-of-type(2)")
    WebElement customerEmail_css;

    @FindBy(className = ".customer-info .info-line:nth-of-type(3)")
    WebElement customerAddress_css;

    @FindBy(xpath="//div[contains(text(),'Status:')]/span")
    WebElement invoiceStatus_xpath;

    public void verifyCompanyLogo(){
        WebElement logo = driver.findElement(By.cssSelector("img.company-logo"));
        Assert.assertTrue(logo.isDisplayed());
       // String src = logo.getAttribute("src");
       // Assert.assertTrue("Logo should be embedded image", src.startsWith("data:image"));
    }

    public void getCustomerName(String expectedName) {
        Assert.assertEquals(expectedName, customerName_css.getText());

    }

    public void getCustomerEmail(String expectedEmail) {
        Assert.assertEquals(expectedEmail, customerEmail_css.getText());
    }

    public void getCustomerAddress(String expectedAddress) {
        Assert.assertEquals(expectedAddress, customerAddress_css.getText());

    }

    public void getInvoiceStatus(String expectedStatus){
        String getStatus = invoiceStatus_xpath.getText();
        Assert.assertEquals(expectedStatus, getStatus.trim());
    }

    public String getSubtotal() {
        return driver.findElement(By.xpath("//div[contains(text(),'Subtotal:')]")).getText().replace("Subtotal:", "").trim();
    }

    public String getShipping() {
        return driver.findElement(By.xpath("//div[contains(text(),'Shipping:')]")).getText().replace("Shipping:", "").trim();
    }

    public String getTotal() {
        return driver.findElement(By.xpath("//div[contains(@class,'final')]")).getText().replace("Total:", "").trim();
    }

    public String getThankYouMessage() {
        return driver.findElement(By.cssSelector(".thank-you")).getText();
    }
}
