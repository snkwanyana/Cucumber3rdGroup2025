package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignupPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "register-firstName")
    WebElement firstNameField;

    @FindBy(id = "register-lastName")
    WebElement lastNameField;

    @FindBy(id= "register-email")
    WebElement emailField;

    @FindBy(id= "register-password")
    WebElement passwordField;

    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordField;

    @FindBy(id = "register-submit")
    WebElement createAccountBtn;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String name) {
        firstNameField.clear();
        firstNameField.sendKeys(name.trim());
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName.trim());
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email.trim());
    }

    public void enterPassword(String password) {

        passwordField.sendKeys(password.trim());
    }

    public void enterConfirmPassword(String confirmPassword) {

        confirmPasswordField.sendKeys(confirmPassword.trim());
    }

    public void clickCreateAccount() {
        createAccountBtn.click();
    }

    public void confirmIfErrorMessageIsDisplayed(String errorMessage) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            Assert.assertEquals(alertText, errorMessage);
            alert.accept();
        } catch (Exception e) {
            Assert.fail("Expected alert not displayed: " + errorMessage);
        }
    }
}
