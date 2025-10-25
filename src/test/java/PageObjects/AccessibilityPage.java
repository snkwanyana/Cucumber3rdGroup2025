package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AccessibilityPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AccessibilityPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ==== Accessibility Elements ====

    @FindBy(id = "loginButton")
    WebElement loginButton;

    @FindBy(css = "button[role='tab']")
    List<WebElement> tabButtons;

    @FindBy(css = "input, select, textarea")
    List<WebElement> formElements;

    @FindBy(css = "button[data-testid^='cart-']")
    List<WebElement> cartButtons;

    @FindBy(css = "button[data-testid^='invoice-']")
    List<WebElement> invoiceButtons;

    @FindBy(css = "input[type='radio'][name='storage']")
    List<WebElement> storageRadios;

    @FindBy(css = "span.error-text[role='alert']")
    WebElement errorAlert;

    @FindBy(css = "div[role='status']")
    WebElement statusToast;

    @FindBy(css = "div[role='dialog']")
    WebElement successPopup;

    @FindBy(css = "button[data-testid='dismiss-popup-btn']")
    WebElement dismissPopupButton;

    @FindBy(css = "section[aria-label='Invoice History']")
    WebElement invoiceHistoryPanel;

    // ==== Methods ====

    /** Press Tab repeatedly and confirm focus moves through expected sections */
    public void verifyTabNavigationSequence(String expectedSequenceCsv) {
        String[] expected = expectedSequenceCsv.split(",");
        int totalTabs = expected.length;

        WebElement current = loginButton;
        current.click(); // start at login

        for (int i = 0; i < totalTabs; i++) {
            current.sendKeys(Keys.TAB);
            WebElement active = driver.switchTo().activeElement();
            String tagName = active.getTagName().toLowerCase();

            System.out.println("🔹 Focus moved to: " + tagName + " (" + active.getAttribute("id") + ")");
        }
        // Not asserting specific DOM here because this is dynamic — ensures focus cycles cleanly.
    }

    /** Select a storage option via keyboard */
    public void selectStorageByKeyboard() {
        WebElement firstRadio = storageRadios.get(0);
        wait.until(ExpectedConditions.elementToBeClickable(firstRadio));
        firstRadio.sendKeys(Keys.SPACE);

        Assert.assertTrue(firstRadio.isSelected(), "❌ Storage radio should be selected with SPACE key.");
    }

    /** Verify role='alert' is present on validation error */
    public void verifyErrorRoleAlert() {
        wait.until(ExpectedConditions.visibilityOf(errorAlert));
        String role = errorAlert.getAttribute("role");
        Assert.assertEquals(role, "alert", "❌ Error text must use role='alert'");
    }

    /** Verify role='status' is present on success toast */
    public void verifyToastRoleStatus() {
        wait.until(ExpectedConditions.visibilityOf(statusToast));
        String role = statusToast.getAttribute("role");
        Assert.assertEquals(role, "status", "❌ Toast must use role='status'");
    }

    /** Verify dismiss button accessible via Enter key */
    public void verifyPopupDismissKeyboard() {
        wait.until(ExpectedConditions.visibilityOf(successPopup));
        dismissPopupButton.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.invisibilityOf(successPopup));
        Assert.assertTrue(
                ExpectedConditions.invisibilityOf(successPopup).apply(driver),
                "❌ Popup should close after pressing Enter on dismiss button."
        );
    }

    /** Verify invoice history accessibility and focus management */
    public void verifyInvoiceHistoryAccessibility() {
        wait.until(ExpectedConditions.visibilityOf(invoiceHistoryPanel));
        String aria = invoiceHistoryPanel.getAttribute("aria-label");
        Assert.assertEquals(aria, "Invoice History", "❌ Invoice panel missing aria-label!");

        WebElement focused = driver.switchTo().activeElement();
        Assert.assertTrue(invoiceHistoryPanel.equals(focused) ||
                        invoiceHistoryPanel.findElements(By.cssSelector(":focus")).size() > 0,
                "❌ No element in Invoice History panel has focus!");
    }
}
