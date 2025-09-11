package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    PracticeAssessmentsPage practiceAssessmentsPage;

    @FindBy(id = "signup-toggle")
    WebElement signupButton;

    @FindBy(id = "login-email")
    WebElement emailField;

    @FindBy(id = "login-password")
    WebElement passwordField;

    @FindBy(id = "login-submit")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void confirmIfMessageIsDisplayed(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            if (!expectedMessage.equals("Logout")) {
                // Wait for alert to be present
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                String actualMessage = alert.getText();
                Assert.assertEquals(actualMessage, expectedMessage,
                        "Alert message mismatch!");
                alert.accept();
            } else {
                // Successful login: wait until logout button is visible
                if (practiceAssessmentsPage == null) {
                    practiceAssessmentsPage = new PracticeAssessmentsPage(driver);
                }
                practiceAssessmentsPage.waitUntilLogoutButtonIsVisible();
            }
        } catch (NoAlertPresentException e) {
            Assert.fail("Expected alert not found for message: " + expectedMessage);
        }
    }
}
