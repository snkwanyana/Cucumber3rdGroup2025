package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "deviceType")
    WebElement deviceDropdown;

    @FindBy(id = "brand")
    WebElement brandDropdown;

    @FindBy(css = ".radio-bundle input[name='storage']")
    List<WebElement> storageRadios;

    @FindBy(id = "inventory-next-btn")
    WebElement nextBtn;

    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartBtn;

    @FindBy(id = "cart-summary")
    WebElement cartPanel;

    @FindBy(id = "cart-title")
    WebElement cartTitle;

    @FindBy(css = "[data-testid^='cart-item-']")
    List<WebElement> cartItems;

    @FindBy(id = "cart-grand-total-value")
    WebElement grandTotal;

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }

    public void addDevice(String deviceType, String brand, String storage) {
        wait.until(ExpectedConditions.elementToBeClickable(deviceDropdown));
        deviceDropdown.sendKeys(deviceType);

        wait.until(ExpectedConditions.elementToBeClickable(brandDropdown));
        brandDropdown.sendKeys(brand);

        if (storage != null && !storage.isEmpty()) {
            boolean selected = false;
            for (WebElement radio : storageRadios) {
                if (radio.getAttribute("value").equalsIgnoreCase(storage)) {
                    wait.until(ExpectedConditions.elementToBeClickable(radio)).click();
                    selected = true;
                    break;
                }
            }
            if (!selected) throw new NoSuchElementException("Storage option '" + storage + "' not found!");
        }

        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(cartPanel));
    }

    public void AddToCart() {
        scrollIntoView(addToCartBtn);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.visibilityOf(cartPanel));
    }

    public void assertCartTitle(String expected) {
        scrollIntoView(cartPanel);
        wait.until(ExpectedConditions.visibilityOf(cartTitle));
        String actual = cartTitle.getText().trim();
        Assert.assertEquals(actual, expected, "❌ Cart title mismatch!");
    }

    public void assertDiscountOnlyFirstItem() {
        scrollIntoView(cartPanel);
        List<WebElement> items = driver.findElements(By.cssSelector("[data-testid^='cart-item-']"));

        boolean firstHasDiscount = items.get(0).getText().toLowerCase().contains("discount");
        boolean secondHasDiscount = items.size() > 1 && items.get(1).getText().toLowerCase().contains("discount");

        Assert.assertTrue(firstHasDiscount, "❌ First item should have a discount!");
        Assert.assertFalse(secondHasDiscount, "❌ Second item should NOT have a discount!");
    }

    public void removeItemAtIndex(int index) {
        scrollIntoView(cartPanel);
        wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));

        WebElement removeBtn = cartItems.get(index - 1).findElement(By.cssSelector("button[aria-label='Remove item']"));
        removeBtn.click();

        // Wait for item to disappear
        wait.until(ExpectedConditions.stalenessOf(removeBtn));
    }

    public void assertGrandTotal(String expectedTotal) {
        scrollIntoView(cartPanel);
        wait.until(ExpectedConditions.visibilityOf(grandTotal));
        String actual = grandTotal.getText().trim();
        Assert.assertEquals(actual, expectedTotal, "❌ Grand total mismatch!");
    }

    public void assertCartPanelVisible(boolean visible) {
        scrollIntoView(cartPanel);
        if (visible) {
            Assert.assertTrue(cartPanel.isDisplayed(), "❌ Cart panel should be visible!");
        } else {
            Assert.assertTrue(!cartPanel.isDisplayed() || cartPanel.getText().isEmpty(), "❌ Cart panel should be hidden!");
        }
    }

    public void assertErrorDisplayed() {
        WebElement error = driver.findElement(By.cssSelector("span.error-text[role='alert']"));
        wait.until(ExpectedConditions.visibilityOf(error));
        Assert.assertTrue(error.isDisplayed(), "❌ Expected error message not displayed!");
    }

    public int getCartItemCount() {
        scrollIntoView(cartPanel);
        return driver.findElements(By.cssSelector("[data-testid^='cart-item-']")).size();
    }
}
