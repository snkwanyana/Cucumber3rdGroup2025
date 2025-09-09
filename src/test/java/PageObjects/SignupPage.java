package PageObjects;

import Utils.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends Base {

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
    @FindBy(id = "login-toggle")
    WebElement signupButton_id;

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

    public void confirmIfSignupPageIsDisplayed() {
        signupButton_id.isDisplayed();
    }

}
