package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;
    @FindBy(id = "login-submit")
    WebElement loginButton_id;

    @FindBy(id = "login-email")
    WebElement emai_id;

    @FindBy(id = "login-password")
    WebElement Password_id;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupButton() {
        signupButton_id.click();
    }

    public void EnterEmail(String email) {
        emai_id.sendKeys(email);
    }

    public void EnterPassword(String password) {
        Password_id.sendKeys(password);
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(loginButton_id));
        loginButton_id.click();

        // Get the current window handle
        String originalWindow = driver.getWindowHandle();

        // Loop through all open windows
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }


        }
    }
}
