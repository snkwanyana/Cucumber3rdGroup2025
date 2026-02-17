package PageObjects;

import Utils.TakeScreenshots;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SignupPage {

    //    TakeScreenshots takeScreenshots = new TakeScreenshots();
    WebDriver driver;

    @FindBy(id = "register-firstName")
    WebElement firstNameField_id;
    @FindBy(id = "register-lastName")
    WebElement LastNameField_id;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField_xpath;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField_xpath;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement confirmPasswordField_xpath;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createAccount_xpath;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        firstNameField_id.sendKeys(firstName);
//        takeScreenshots.takesSnapShot(driver, "FirstName");
    }

    public void enterLastName(String lastName) {
        LastNameField_id.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField_xpath.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_xpath.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField_xpath.sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        createAccount_xpath.click();
    }

    public void confirmIfErrorMessageIsDisplayed(String expectedMessage) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the alert is present
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Get alert text and assert it matches the expected message
        String alertText = alert.getText();
        Assert.assertEquals(alertText, expectedMessage);

        // Accept (close) the alert
        alert.accept();

    }

}
