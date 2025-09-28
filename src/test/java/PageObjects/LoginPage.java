package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;


    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;

    @FindBy(id="login-email")
    WebElement emailField_id;

    @FindBy(id="login-password")
    WebElement passwordField_id;

    @FindBy(id="login-submit")
    WebElement loginButton_id;

    @FindBy(id="login-heading")
    WebElement loginHeading_id;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickSignupButton() {

        signupButton_id.click();
    }

    public void verifyLoginHeadingIsDisplayed() {
        loginHeading_id.isDisplayed();
    }

    public void enterEmail(String email) {
        emailField_id.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }
    public void clickLoginField()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton_id));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton_id));
        loginButton_id.click();

    }


    public boolean isAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void validateMessagepopup(String errorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert text is: " + alertText);
        Assert.assertEquals(alertText, errorMessage);
        alert.accept();
    }

}
