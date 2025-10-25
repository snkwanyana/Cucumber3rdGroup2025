package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MultiDeviceCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public MultiDeviceCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // --- Product configuration fields ---
    @FindBy(id = "deviceType") WebElement deviceTypeSelect;
    @FindBy(id = "brand") WebElement brandSelect;
    @FindBy(id = "storage-64GB") WebElement storage64GB;
    @FindBy(id = "storage-128GB") WebElement storage128GB;
    @FindBy(id = "storage-256GB") WebElement storage256GB;
    @FindBy(id = "quantity") WebElement quantityInput;
    @FindBy(id = "shipping-standard") WebElement shippingStandard;
    @FindBy(id = "shipping-express") WebElement shippingExpress;
    @FindBy(id = "warranty-none") WebElement warrantyNone;
    @FindBy(id = "warranty-1yr") WebElement warranty1yr;
    @FindBy(id = "warranty-2yr") WebElement warranty2yr;
    @FindBy(id = "discount-code") WebElement discountInput;
    @FindBy(id = "apply-discount-btn") WebElement applyDiscountBtn;
    @FindBy(id = "add-to-cart-btn") WebElement addToCartBtn;

    // --- Cart section ---
    @FindBy(id = "cart-summary") WebElement cartPanel;
    @FindBy(css = "[data-testid^='cart-item-']") List<WebElement> cartItems;
    @FindBy(id = "cart-grand-total-value") WebElement grandTotalValue;

    // --- Helpers ---
    private void waitForCartItemCount(int expectedCount) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("[data-testid^='cart-item-']"), expectedCount));
    }

    private void scrollToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartPanel);
    }

    // --- Configure device ---
    public void configureDevice(String type, String brand, String storage, int qty, String ship, String warranty, String discount) {
        new Select(deviceTypeSelect).selectByVisibleText(type);
        new Select(brandSelect).selectByVisibleText(brand);

        if (storage.equalsIgnoreCase("64GB")) storage64GB.click();
        else if (storage.equalsIgnoreCase("128GB")) storage128GB.click();
        else if (storage.equalsIgnoreCase("256GB")) storage256GB.click();

        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(qty));

        if (ship.equalsIgnoreCase("standard")) shippingStandard.click();
        else shippingExpress.click();

        if (warranty.equalsIgnoreCase("none")) warrantyNone.click();
        else if (warranty.equalsIgnoreCase("1yr")) warranty1yr.click();
        else warranty2yr.click();

        discountInput.clear();
        if (!discount.equalsIgnoreCase("none")) {
            discountInput.sendKeys(discount);
            applyDiscountBtn.click();
            wait.until(ExpectedConditions.textToBePresentInElement(cartPanel, "Discount"));
        }
    }

    public void clickAddToCart() {
        int currentCount = cartItems.size();
        addToCartBtn.click();
        waitForCartItemCount(currentCount + 1);
        scrollToCart();
    }

    // --- Assertions ---
    public void assertBothDeviceTypesPresent(String firstType, String secondType) {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        String allText = cartPanel.getText().toLowerCase();
        Assert.assertTrue(allText.contains(firstType.toLowerCase()), "❌ Missing first device type in cart: " + firstType);
        Assert.assertTrue(allText.contains(secondType.toLowerCase()), "❌ Missing second device type in cart: " + secondType);
    }

    public void assertOnlyDeviceShowsDiscount(String discountedDevice) {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        for (WebElement item : cartItems) {
            String text = item.getText().toLowerCase();
            if (text.contains(discountedDevice.toLowerCase()))
                Assert.assertTrue(text.contains("discount"), "❌ Discount missing for " + discountedDevice);
            else
                Assert.assertFalse(text.contains("discount"), "❌ Unexpected discount for " + text);
        }
    }

    public void assertGrandTotalEqualsSum() {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        double sum = 0;
        for (WebElement item : cartItems) {
            String totalText = item.findElement(By.cssSelector("[data-testid*='cart-item-total']")).getText();
            double value = Double.parseDouble(totalText.replaceAll("[^0-9.]", ""));
            sum += value;
        }
        double displayed = Double.parseDouble(grandTotalValue.getText().replaceAll("[^0-9.]", ""));
        Assert.assertEquals(Math.round(displayed * 100.0) / 100.0, Math.round(sum * 100.0) / 100.0, "❌ Grand total mismatch!");
    }

    public void removeDevice(String deviceType) {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        for (WebElement item : cartItems) {
            if (item.getText().toLowerCase().contains(deviceType.toLowerCase())) {
                item.findElement(By.cssSelector("button[aria-label='Remove item']")).click();
                wait.until(ExpectedConditions.stalenessOf(item));
                return;
            }
        }
        Assert.fail("❌ Could not find device to remove: " + deviceType);
    }

    public void assertRemainingTotals(String remainingDevice) {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        Assert.assertEquals(cartItems.size(), 1, "❌ More than one item remains!");
        String text = cartItems.get(0).getText().toLowerCase();
        Assert.assertTrue(text.contains(remainingDevice.toLowerCase()), "❌ Remaining device mismatch");
    }

    public void assertSelectionsUnchanged(String firstStorage, String secondStorage) {
        scrollToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
        boolean firstOk = false, secondOk = false;
        for (WebElement item : cartItems) {
            String text = item.getText().toLowerCase();
            if (text.contains(firstStorage.toLowerCase())) firstOk = true;
            if (text.contains(secondStorage.toLowerCase())) secondOk = true;
        }
        Assert.assertTrue(firstOk && secondOk, "❌ One or both device selections changed unexpectedly");
    }
}
