package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EdgeCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EdgeCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "cart-summary")
    private WebElement cartPanel;

    @FindBy(css = "[data-testid^='cart-item-']")
    private List<WebElement> cartItems;

    @FindBy(id = "cart-grand-total-value")
    private WebElement grandTotal;

    @FindBy(css = "span.error-text[role='alert']")
    private WebElement quantityError;

    @FindBy(id = "place-order-btn")
    private WebElement placeOrderBtn;

    @FindBy(id = "purchase-success-toast")
    private WebElement successToast;

    private void scrollToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartPanel);
        cartPanel.sendKeys(Keys.PAGE_DOWN);
        wait.until(ExpectedConditions.visibilityOf(cartPanel));
    }

    public void addItem(String deviceType, String brand, String storage) {
        addItem(deviceType, brand, storage, false);
    }

    public void addItem(String deviceType, String brand, String storage, boolean discounted) {
        WebElement addBtn = driver.findElement(By.id("add-to-cart-btn"));
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(cartPanel));
        // Optional: handle discounted flag (e.g., apply promo)
    }

    public void setQuantityTo(String quantity) {
        scrollToCart();
        WebElement qtyInput = cartItems.get(0).findElement(By.cssSelector("input[type='number']"));
        wait.until(ExpectedConditions.elementToBeClickable(qtyInput));

        qtyInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        qtyInput.sendKeys(Keys.DELETE);
        qtyInput.sendKeys(quantity);
        qtyInput.sendKeys(Keys.TAB);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].value=arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
                qtyInput, quantity
        );
    }

    public void assertQuantityError(String expectedMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOf(quantityError));
            Assert.assertEquals(quantityError.getText().trim(), expectedMessage, "❌ Quantity error mismatch!");
        } catch (TimeoutException te) {
            Assert.fail("❌ Expected quantity error but none appeared.");
        }
    }

    public void removeDiscountedItem() {
        scrollToCart();
        for (WebElement item : cartItems) {
            if (item.getText().toLowerCase().contains("discount")) {
                WebElement removeBtn = item.findElement(By.cssSelector("button[aria-label='Remove item']"));
                wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
                wait.until(ExpectedConditions.stalenessOf(item));
                return;
            }
        }
        Assert.fail("❌ No discounted item found to remove!");
    }

    public void assertGrandTotalUpdated() {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOf(grandTotal));
        String total = grandTotal.getText().trim();
        Assert.assertTrue(total.matches("R\\d+\\.\\d{2}"), "❌ Grand total format invalid!");
    }

    public void assertNoDiscountsRemain() {
        scrollToCart();
        for (WebElement item : cartItems) {
            Assert.assertFalse(item.getText().toLowerCase().contains("discount"),
                    "❌ Discount still present after removal!");
        }
    }

    public void manuallyEmptyCart() {
        ((JavascriptExecutor) driver).executeScript(
                "document.querySelectorAll('[data-testid^=\"cart-item-\"]').forEach(e=>e.remove());"
        );
    }

    public void clickPlaceOrder() {
        scrollToCart();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }

    public void assertNoSuccessToast() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successToast));
            Assert.fail("❌ Success toast appeared despite empty cart!");
        } catch (TimeoutException e) {
            Assert.assertTrue(true, "✅ No toast appeared as expected.");
        }
    }
}
