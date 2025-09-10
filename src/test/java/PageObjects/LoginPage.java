package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;

    @FindBy(id = "login-email")
    WebElement loginEmailTxt_id;

    @FindBy(id = "login-password")
    WebElement loginPasswordTxt_id;

    @FindBy(id = "login-submit")
    WebElement loginButton_id;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupButton() {
        signupButton_id.click();
    }

    public void enterEmail(String email) {
        loginEmailTxt_id.sendKeys(email);
    }

    public void enterPassword(String password) {
        loginPasswordTxt_id.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton_id.click();
    }


}
