package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ReviewCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ReviewCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // 🔹 Elements
    @FindBy(id = "review-cart-btn")
    WebElement reviewCartBtn;

    @FindBy(id = "place-order-btn")
    WebElement placeOrderBtn;

    @FindBy(id = "cancel-order-btn")
    WebElement cancelOrderBtn;

    @FindBy(id = "order-info-box")
    WebElement orderInfoBox;

    @FindBy(id = "cart-success-toast")
    WebElement successToast;

    @FindBy(id = "success-popup")
    WebElement successPopup;

    @FindBy(id = "success-popup-username")
    WebElement successPopupUser;

    @FindBy(css = "[data-testid^='cart-item-description']")
    List<WebElement> popupCartItems;

    @FindBy(id = "success-popup-grand-total")
    WebElement popupGrandTotal;

    @FindBy(css = "button.dismiss-popup")
    WebElement dismissBtn;

    @FindBy(css = "button.view-history")
    WebElement viewHistoryBtn;

    @FindBy(id = "invoice-download")
    WebElement invoiceDownload;

    // 🔹 Utility: Scroll before interaction
    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    private void safeClick(WebElement element) {
        scrollIntoView(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // 🔹 Actions
    public void clickReviewCartOrder() {
        safeClick(reviewCartBtn);
    }

    public void assertPlaceOrderAndCancelVisible() {
        wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
        wait.until(ExpectedConditions.visibilityOf(cancelOrderBtn));
        wait.until(ExpectedConditions.visibilityOf(orderInfoBox));
        Assert.assertTrue(
                placeOrderBtn.isDisplayed() && cancelOrderBtn.isDisplayed() && orderInfoBox.isDisplayed(),
                "❌ Place/Cancel/Info box not visible after clicking Review Cart!"
        );
    }

    public void clickCancel() {
        safeClick(cancelOrderBtn);
    }

    public void assertReviewCartVisibleAgain() {
        wait.until(ExpectedConditions.visibilityOf(reviewCartBtn));
        Assert.assertTrue(reviewCartBtn.isDisplayed(), "❌ Review Cart button not visible again after Cancel!");
    }

    public void clickPlaceOrder() {
        safeClick(placeOrderBtn);
    }

    public void assertSuccessToast(String expectedMessage) {
        wait.until(ExpectedConditions.visibilityOf(successToast));
        String actual = successToast.getText().trim();
        Assert.assertEquals(actual, expectedMessage, "❌ Success toast message mismatch!");
    }

    public void waitForToastToDisappear() {
        wait.until(ExpectedConditions.invisibilityOf(successToast));
    }

    public void assertSuccessPopup(String userName) {
        wait.until(ExpectedConditions.visibilityOf(successPopup));
        Assert.assertTrue(successPopup.isDisplayed(), "❌ Success popup not visible!");
        Assert.assertEquals(successPopupUser.getText().trim(), userName, "❌ Username mismatch in popup!");
        Assert.assertTrue(popupCartItems.size() > 0, "❌ No cart items in success popup!");
        Assert.assertTrue(popupGrandTotal.getText().startsWith("R"), "❌ Grand total format incorrect!");
    }

    public void assertInvoiceGenerated() {
        wait.until(ExpectedConditions.visibilityOf(invoiceDownload));
        Assert.assertTrue(invoiceDownload.isDisplayed(), "❌ Invoice not generated or missing!");
    }

    public void assertPopupControls() {
        wait.until(ExpectedConditions.visibilityOf(dismissBtn));
        wait.until(ExpectedConditions.visibilityOf(viewHistoryBtn));
        Assert.assertTrue(dismissBtn.isDisplayed() && viewHistoryBtn.isDisplayed(),
                "❌ Popup dismiss/view history buttons missing!");
    }

    public void doubleClickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        scrollIntoView(placeOrderBtn);
        new Actions(driver).doubleClick(placeOrderBtn).perform();
    }

    public void assertOnlyOneToast() {
        List<WebElement> toasts = driver.findElements(By.id("cart-success-toast"));
        Assert.assertEquals(toasts.size(), 1, "❌ More than one success toast appeared!");
    }
}
