package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PricingParnel {

    @FindBy(id = "base-price-value")
    WebElement basePriceValue;

    @FindBy(id = "breakdown-quantity-value")
    WebElement breakdownQuantityValue;

    @FindBy(id = "breakdown-subtotal-value")
    WebElement breakdownSubtotalValue;

    @FindBy(id = "breakdown-shipping-value")
    WebElement breakdownShippingValue;

    @FindBy(id = "breakdown-warranty-value")
    WebElement breakdownWarrantyValue;

    @FindBy(id = "breakdown-discount-value")
    WebElement breakdownDiscountValue;

    @FindBy(id = "breakdown-total-value")
    WebElement breakdownTotalValue;

    @FindBy(id = "pricing-breakdown-title")
    WebElement pricingBreakdownTitle;
// locators for extras and pricing breakdown values
@FindBy(id = "shipping-standard")
WebElement shippingStandardRadio;

    @FindBy(id = "shipping-express")
    WebElement shippingExpressRadio;

    @FindBy(id = "warranty-none")
    WebElement warrantyNoneRadio;

    @FindBy(id = "warranty-1yr")
    WebElement warranty1yrRadio;

    @FindBy(id = "warranty-2yr")
    WebElement warranty2yrRadio;

    // discount section locator
    @FindBy(id = "discount-code")
    WebElement discountCodeInput;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountBtn;

    @FindBy(id = "discount-feedback")
    private WebElement discountMessage;

    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartButton;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;




    public void verifyPricingBreakdownTitleIsDisplayed() {

    	pricingBreakdownTitle.isDisplayed();
    }

    public String getBasePrice() {

        return basePriceValue.getText();
    }

    public String getBreakdownQuantity() {

        return breakdownQuantityValue.getText();
    }

    public String getBreakdownSubtotal() {

        return breakdownSubtotalValue.getText();
    }

    public String getBreakdownTotal() {
        return breakdownTotalValue.getText();
    }

    public String getBreakdownShipping() {
        return breakdownShippingValue.getText();
    }

    public String getBreakdownWarranty() {
        return breakdownWarrantyValue.getText();
    }

    public String getBreakdownDiscount() {
        try {
            if (breakdownDiscountValue.isDisplayed()) {
                String value = breakdownDiscountValue.getText();
                return "R0.00".equals(value) ? "" : value;
            }
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            // Element not present or not attached to DOM
        }
        return "";
    }

    public String getUnitPrice() {
        return unitPriceValue.getText();
    }
    public String getSubtotal() {
        return subtotalValue.getText();
    }

    //methods for Extras section
    public void selectShipping(String shipping) {
        if (shipping.equalsIgnoreCase("Standard")) {
            shippingStandardRadio.click();
        } else if (shipping.equalsIgnoreCase("Express")) {
            shippingExpressRadio.click();
        }
    }

    public void selectWarranty(String warranty) {
        if (warranty.equalsIgnoreCase("None")) {
            warrantyNoneRadio.click();
        } else if (warranty.equalsIgnoreCase("1yr")) {
            warranty1yrRadio.click();
        } else if (warranty.equalsIgnoreCase("2yr")) {
            warranty2yrRadio.click();
        }
    }

   public void enterDiscountCode(String code) {
        discountCodeInput.clear();
        discountCodeInput.sendKeys(code);
        applyDiscountBtn.click();
    }


    public void clickApply() {
        applyDiscountBtn.click();
    }

    // Method to get the message displayed after applying the discount code
    public String getDiscountMessage() {
        return discountMessage.getText().trim();  // Return the message
    }

    // Method to clear the discount code input (if needed)
    public void clearDiscountInput() {
        discountCodeInput.clear();
    }

    //method to click add to cart button
    public void clickAddToCart() {
        addToCartButton.click();
    }


}
