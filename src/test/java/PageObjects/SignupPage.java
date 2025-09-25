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

    @FindBy(id = "register-email")
    WebElement emailField_id;

    @FindBy(id = "register-password")
    WebElement passwordField_id;

    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordField_id;

    @FindBy(id = "register-submit")
    WebElement createCreate_id;

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
        emailField_id.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField_id.sendKeys(confirmPassword);
    }

    public void clickCreateAccount() {
        createCreate_id.click();
    }

    public void confirmIfErrorMessageIsDisplayed(String errorMessage) {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, errorMessage);
        alert.accept();
    }

}
