package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Extras {
    WebDriver driver;

    public Extras(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "shipping-standard")
    WebElement standard_id;

    @FindBy(id = "shipping-express")
    WebElement express_id;

    @FindBy(id = "warranty-none")
    WebElement nowaranty_id;

    @FindBy(id = "warranty-1yr")
    WebElement warranty1yr_id;

    @FindBy(id = "warranty-2yr")
    WebElement warranty2yr_id;

    @FindBy(id = "discount-code")
    WebElement discountCode_id;

    @FindBy(id = "apply-discount-btn")
    WebElement btndiscount_id;

    @FindBy(id = "purchase-device-btn")
    WebElement btnpurchase_id;

    @FindBy(id = "view-history-btn")
    WebElement btnviewhistory_id;

    @FindBy(id = "view-invoice-INV-1759080957647")
    WebElement btnviewinvoice_id;

    public void selectStandardShipping(String standard) {
        standard_id.click();
    }

    public void selectExpressShipping(String Express) {
        express_id.click();
    }

    public void selectNoWarranty(String warranty) {
        nowaranty_id.click();
    }

    public void select1YearWarranty(String warranty) {
        warranty1yr_id.click();
    }

    public void select2YearWarranty(String warranty) {
        warranty2yr_id.click();
    }

    public void enterDiscountCode(String code) {
        discountCode_id.sendKeys(code);
    }

    public void clickApplyDiscount() {
        btndiscount_id.click();
    }

    public void clickCorfirmPurchase() {
        btnpurchase_id.click();
    }

    public void clickViewHistory() {
        btnviewhistory_id.click();
    }

    public void clickViewInvoice() {
        new WebDriverWait(driver, Duration.ofSeconds(8)).until(ExpectedConditions.visibilityOf(btnviewinvoice_id));
        btnviewinvoice_id.isDisplayed();
        btnviewinvoice_id.click();
    }
}
