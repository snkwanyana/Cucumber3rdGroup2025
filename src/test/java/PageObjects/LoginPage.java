package PageObjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

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
    @FindBy(id = "logout-button")
    WebElement logoutbutton_id;


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
    }

    public void confirmIfErrorMessageIsDisplayed(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, errorMessage);
        alert.accept();
    }
    public  void switchToNewTab() {
        // After successful login
        String originalWindow = driver.getWindowHandle();

// Open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open();");

// Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

// Perform actions in the new tab (e.g., verify login status)
// ...

// Switch back to the original tab
        driver.switchTo().window(originalWindow);

// Force user to login again (e.g., log out or clear cookies)
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
// Now user must log in again
    }

    public void clickLogoutButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", logoutbutton_id);
        logoutbutton_id.click();
    }
}



