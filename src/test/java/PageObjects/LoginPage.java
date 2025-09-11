package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;
    @FindBy(id ="nav-btn-practice")
    WebElement learningmaterial_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;
    @FindBy(id = "login-password")
    WebElement passwordField_id;
    @FindBy(id = "login-submit")
    WebElement loginButton_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupButton() {
        signupButton_id.click();
    }

    public void verifyLearnAutomationtheRightWayisDisplayed() {

    }

    public  void clicklearningmaterialButton(){
        learningmaterial_id.click();
    }

    public  void enterEmailAddress(String emailadd) {
        emailField_id.sendKeys(emailadd);
    }


    public  void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }

    public void clickloginButton() {
        loginButton_id.click();

    }
}

