package PageObjects;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;

    @FindBy(id = "login-email")
    WebElement emailField_id;

    @FindBy(id = "login-password")
    WebElement passwordField_id;

    @FindBy(id = "login-submit")
    WebElement loginButton_id;

    @FindBy(id = "logout-button")
    WebElement logoutButton_id;

    @FindBy(id = "nav-btn-contact")
    WebElement contactTab_id;

    @FindBy(id = "nav-btn-practice")
    WebElement LearnMoreButton_id;

    @FindBy(xpath = "//span[text()='Access Learning Materials']")
    WebElement loginPageText_xpath;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupButton() {

        signupButton_id.click();
    }

    public void enterEmail(String email) {

        emailField_id.sendKeys(email.trim());
    }

    public void enterPassword(String password) {

        passwordField_id.sendKeys(password.trim());
    }

    public void clickLoginButton() {
        loginButton_id.click();

    }

    public void verifyTabs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("practice-tabs")));

        WebElement tabs = driver.findElement(By.id("practice-tabs"));
        assertTrue(tabs.isDisplayed());

    }

    public void verifyToken() {
        // Check if token exists in localStorage


        new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                d -> ((JavascriptExecutor) d).executeScript("return window.localStorage.getItem('authToken')") != null
        );


        JavascriptExecutor js = (JavascriptExecutor) driver;
        String token = (String) js.executeScript("return window.localStorage.getItem('authToken');");
        assertNotNull("Token should exist in localStorage", token);

        System.out.println("Token after login: " + token);
    }


    public void clickLogoutButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutButton_id));

        logoutButton.click();
    }


    public void verifyAlertMessage(String expectedMessage) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String alertText = alert.getText();
            Assert.assertEquals(alertText, expectedMessage);


            alert.accept(); // or alert.dismiss();
        } catch (TimeoutException e) {
            Assert.fail("Expected alert was not present.");
        }
    }

    public void clickContactTab() {
        contactTab_id.click();
    }

    public void clickLearnMoreButton() {
        LearnMoreButton_id.click();
    }

    public void verifyLoginText() {
        loginPageText_xpath.isDisplayed();
    }


}
