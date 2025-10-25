package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class PasswordChangePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor – called when we create the page
    public PasswordChangePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // -------------------- Locators --------------------
    @FindBy(id = "old-password")
    WebElement oldPasswordInput;

    @FindBy(id = "new-password")
    WebElement newPasswordInput;

    @FindBy(id = "confirm-password")
    WebElement confirmPasswordInput;

    @FindBy(id = "update-password-btn")
    WebElement updatePasswordBtn;

    @FindBy(id = "password-message")
    WebElement passwordMessage;

    @FindBy(id = "toggle-old-password-visibility")
    WebElement oldEye;

    @FindBy(id = "toggle-new-password-visibility")
    WebElement newEye;

    @FindBy(id = "toggle-confirm-password-visibility")
    WebElement confirmEye;

    // -------------------- Methods --------------------

    /** Navigate to password change page directly (simple) */
    public void openPasswordChangePage(String baseUrl) {
        driver.get(baseUrl + "/account/password");  // adjust URL if needed
    }

    /** Fill all password fields (skip nulls or blanks safely) */
    public void enterPasswords(String oldPwd, String newPwd, String confirmPwd) {
        wait.until(ExpectedConditions.visibilityOf(oldPasswordInput));
        oldPasswordInput.clear();
        newPasswordInput.clear();
        confirmPasswordInput.clear();

        if (!oldPwd.isEmpty()) oldPasswordInput.sendKeys(oldPwd);
        if (!newPwd.isEmpty()) newPasswordInput.sendKeys(newPwd);
        if (!confirmPwd.isEmpty()) confirmPasswordInput.sendKeys(confirmPwd);
    }

    /** Click the update button */
    public void clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updatePasswordBtn)).click();
    }

    /** Check the message shown under the form */
    public void verifyMessage(String expectedMessage) {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordMessage));
            String actual = passwordMessage.getText().trim();
            Assert.assertEquals(actual, expectedMessage, "❌ Message mismatch!");
        } catch (Exception e) {
            Assert.fail("❌ Message not shown as expected: " + expectedMessage);
        }
    }

    /** Test if eye icons toggle visibility properly */
    public void testAllVisibilityToggles() {
        toggleVisibility(oldEye, oldPasswordInput);
        toggleVisibility(newEye, newPasswordInput);
        toggleVisibility(confirmEye, confirmPasswordInput);
    }

    private void toggleVisibility(WebElement eye, WebElement input) {
        wait.until(ExpectedConditions.elementToBeClickable(eye));
        String before = input.getAttribute("type");
        eye.click();
        String after = input.getAttribute("type");
        Assert.assertNotEquals(before, after, "❌ Visibility did not toggle!");
    }
}
