package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtrasPricingShipping {
    @FindBy(id = "base-price-value")
    WebElement basePriceValue;

    @FindBy(id = "breakdown-quantity-value")
    WebElement breakdownQuantityValue;

    @FindBy(id = "breakdown-subtotal-value")
    WebElement breakdownSubtotalValue;

    @FindBy(id = "breakdown-warranty-value")
    WebElement breakdownWarrantyValue;

    @FindBy(id = "breakdown-shipping-value")
    WebElement breakdownShippingValue;

    @FindBy(id = "breakdown-total-value")
    WebElement breakdownTotalValue;

    @FindBy(id = "shipping-standard")
    WebElement shippingStandardRadio;

    @FindBy(id = "shipping-express")
    WebElement shippingExpressRadio;

    @FindBy(id = "warranty-none")
    WebElement warrantyNoneRadio;

    @FindBy(id = "warranty-1yr")
    WebElement warranty1YrRadio;

    @FindBy(id = "warranty-2yr")
    WebElement warranty2YrRadio;

    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountBtn;

    public void selectShipping(String method) {
        if (method.equalsIgnoreCase("standard")) {
            shippingStandardRadio.click();
        } else if (method.equalsIgnoreCase("express")) {
            shippingExpressRadio.click();
        }
    }

    public void selectWarranty(String warranty) {
        if (warranty.equalsIgnoreCase("none")) {
            warrantyNoneRadio.click();
        } else if (warranty.equalsIgnoreCase("1yr")) {
            warranty1YrRadio.click();
        } else if (warranty.equalsIgnoreCase("2yr")) {
            warranty2YrRadio.click();
        }
    }

    public void applyDiscount(String code) {
        discountCodeInput.clear();
        discountCodeInput.sendKeys(code);
        applyDiscountBtn.click();
    }

    public String getBasePrice() { return basePriceValue.getText(); }
    public String getBreakdownQuantity() { return breakdownQuantityValue.getText(); }
    public String getBreakdownSubtotal() { return breakdownSubtotalValue.getText(); }
    public String getBreakdownWarranty() { return breakdownWarrantyValue.getText(); }
    public String getBreakdownShipping() { return breakdownShippingValue.getText(); }
    public String getBreakdownTotal() { return breakdownTotalValue.getText(); }
}
