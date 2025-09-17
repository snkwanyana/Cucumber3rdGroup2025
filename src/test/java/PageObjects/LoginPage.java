package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

        loginButton_id.click();
    }


}
