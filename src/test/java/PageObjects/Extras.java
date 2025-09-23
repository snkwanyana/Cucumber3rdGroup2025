package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Extras {
    WebDriver driver;

    public Extras(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id="shipping-standard")
    WebElement standard_id;

    @FindBy(id="shipping-express")
    WebElement express_id;

    @FindBy(id="warranty-none")
    WebElement nowaranty_id;

    @FindBy(id="warranty-1yr")
    WebElement warranty1yr_id;

    @FindBy(id="warranty-2yr")
    WebElement warranty2yr_id;

    @FindBy(id="discount-code")
    WebElement discountCode_id;

    @FindBy(id="apply-discount-btn")
    WebElement btndiscount_id;

    @FindBy(id="purchase-device-btn")
    WebElement btnpurchase_id;


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
}
