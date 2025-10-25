package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CartPreviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPreviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Preview panel elements
    @FindBy(id = "cart-summary")
    WebElement cartPreviewPanel;

    @FindBy(id = "cart-title")
    WebElement cartPreviewTitle;

    @FindBy(css = "[data-testid^='cart-item-']")
    List<WebElement> cartPreviewItems;

    @FindBy(css = "button[aria-label='Remove item']")
    List<WebElement> removeItemButtons;

    // --- Actions / Assertions ---
    public void waitForPreviewVisible() {
        wait.until(ExpectedConditions.visibilityOf(cartPreviewPanel));
        Assert.assertTrue(cartPreviewPanel.isDisplayed(), "❌ Cart preview panel not visible!");
    }

    public void waitForPreviewHidden() {
        wait.until(ExpectedConditions.invisibilityOf(cartPreviewPanel));
    }

    public void assertPreviewTitle(String expectedTitle) {
        waitForPreviewVisible();
        String actual = cartPreviewTitle.getText().trim();
        Assert.assertEquals(actual, expectedTitle, "❌ Preview cart title mismatch!");
    }

    public void removeFirstItem() {
        waitForPreviewVisible();
        if (removeItemButtons.isEmpty()) {
            throw new NoSuchElementException("No remove button found in cart preview!");
        }

        WebElement firstRemoveBtn = removeItemButtons.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstRemoveBtn)).click();

        // Wait for the cart to refresh
        wait.until(ExpectedConditions.stalenessOf(cartPreviewItems.get(0)));
    }

    public boolean isPreviewVisible() {
        try {
            return cartPreviewPanel.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}
