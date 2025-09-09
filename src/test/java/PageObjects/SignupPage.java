package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignupPage {

    WebDriver driver;

    @FindBy(id = "register-firstName")
    WebElement firstNameField_id;
    @FindBy(id="register-lastName")
    WebElement LastNameField_id;
    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement emailField_xpath;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField_xpath;
    @FindBy(xpath = "//input[@placeholder='Confirm Password']")
    WebElement confirmPasswordField_xpath;

    @FindBy(xpath = "//button[contains(text(),'Create Account')]")
    WebElement createCreate_xpath;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        firstNameField_id.sendKeys(firstName);
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
        createCreate_xpath.click();
    }

    public void confirmIfErrorMessageIsDisplayed(String errorMessage) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, errorMessage);
        alert.accept();
    }

}
