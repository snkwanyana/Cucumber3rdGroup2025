package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class DiscountPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public DiscountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "discount-code")
    WebElement discountInput;

    @FindBy(id = "apply-discount-btn")
    WebElement applyBtn;

    @FindBy(css = "#discount-feedback")
    WebElement discountFeedback;

    /** ✅ Enter discount code safely */
    public void enterDiscountCode(String code) {
        wait.until(ExpectedConditions.visibilityOf(discountInput));
        discountInput.click();
        discountInput.clear();
        discountInput.sendKeys(code);
    }

    /** ✅ Click Apply with wait */
    public void clickApply() {
        wait.until(ExpectedConditions.elementToBeClickable(applyBtn)).click();
    }

    /** ✅ Clear input safely and ensure it’s empty */
    public void clearDiscountInput() {
        wait.until(ExpectedConditions.visibilityOf(discountInput));
        discountInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        discountInput.sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.attributeToBe(discountInput, "value", ""));
    }

    /** ✅ Returns the discount feedback message (or empty if none) */
    public String getDiscountMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(discountFeedback));
            return discountFeedback.getText().trim();
        } catch (TimeoutException e) {
            return "";
        }
    }

    /** ✅ Assertion method for discount feedback */
    public void assertDiscountMessage(String expectedMessage) {
        if (expectedMessage == null || expectedMessage.isEmpty()) {
            try {
                wait.until(ExpectedConditions.invisibilityOf(discountFeedback));
            } catch (TimeoutException e) {
                throw new AssertionError("❌ Expected no discount message, but found: " + getDiscountMessage());
            }
            return;
        }

        String actual = getDiscountMessage();
        if (actual.isEmpty())
            throw new AssertionError("❌ Expected message '" + expectedMessage + "' but none appeared.");

        if (!actual.equals(expectedMessage))
            throw new AssertionError("❌ Discount message mismatch! Expected: '" +
                    expectedMessage + "', but got: '" + actual + "'");
    }
}
