//package PageObjects;
//
//import Utils.Base;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//
//
//
//public class AdditionalCoveragePage extends Base {
//
//    public AdditionalCoveragePage(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(driver, this);
//    }
//
//    // ===== ELEMENTS =====
//    @FindBy(id = "deviceSelect")
//    private WebElement deviceSelect;
//    @FindBy(id = "brandSelect")  WebElement brandSelect;
//    @FindBy(id = "colorSelect")  WebElement colorSelect;
//    @FindBy(id = "quantity") WebElement quantityInput;
//    @FindBy(id = "discountCode") WebElement discountCodeInput;
//    @FindBy(id = "applyDiscount")  WebElement applyDiscountBtn;
//    @FindBy(id = "clearDiscount") WebElement clearDiscountBtn;
//    @FindBy(css = ".discount-message") WebElement discountMessage;
//    @FindBy(id = "subtotal") WebElement subtotalValue;
//    @FindBy(id = "confirmPurchase")  WebElement confirmPurchaseBtn;
//    @FindBy(id = "previewImg") WebElement previewImg;
//    @FindBy(css = ".success-toast")  WebElement successToast;
//
//    // ===== ACTION METHODS =====
//    public void selectDevice(String device) {
//        selectDropdownByVisibleText(deviceSelect, device);
//    }
//
//    public void selectBrand(String brand) {
//        selectDropdownByVisibleText(brandSelect, brand);
//    }
//
//    public void selectColor(String color) {
//        selectDropdownByVisibleText(colorSelect, color);
//    }
//
//    public void setQuantity(int qty) {
//        type(quantityInput, String.valueOf(qty));
//    }
//
//    public void applyDiscount(String code) {
//        type(discountCodeInput, code);
//        click(applyDiscountBtn);
//        waitForVisible(discountMessage);
//    }
//
//    public void removeDiscount() {
//        click(clearDiscountBtn);
//        waitForInvisible(discountMessage);
//    }
//
//    public void confirmPurchase() {
//        click(confirmPurchaseBtn);
//    }
//
//    // ===== ASSERTION METHODS =====
//    public void assertBrandDisabled() {
//        Assert.assertFalse(brandSelect.isEnabled(), "❌ Brand field should be disabled!");
//    }
//
//    public void assertDevicePreviewDisplayed() {
//        Assert.assertTrue(isDisplayed(previewImg), "❌ Device preview image not displayed!");
//    }
//
//    public void assertDiscountRemoved() {
//        Assert.assertFalse(isDisplayed(discountMessage), "❌ Discount message still visible!");
//    }
//
//    public void assertSubtotal(double expected) {
//        String text = getText(subtotalValue).replace("$", "").trim();
//        double actual = Double.parseDouble(text);
//        Assert.assertEquals(actual, expected, 0.01, "❌ Subtotal mismatch!");
//    }
//
//    public void assertColorDefault(String expected) {
//        String selected = colorSelect.getAttribute("value");
//        Assert.assertEquals(selected, expected, "❌ Color default mismatch!");
//    }
//
//    public void assertSuccessToastVisible() {
//        Assert.assertTrue(isDisplayed(successToast), "❌ Success toast missing!");
//    }
//}
