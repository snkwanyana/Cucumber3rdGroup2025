package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;
    @FindBy(id = "nav-btn-practice")
    WebElement learningmaterial_id;
    @FindBy(id = "login-email")
    WebElement emailField_id;
    @FindBy(id = "login-password")
    WebElement passwordField_id;
    @FindBy(id = "login-submit")
    WebElement loginButton_id;
    @FindBy(id = "nav-btn-about")
    WebElement nav_btn_about_id;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupButton() {
        signupButton_id.click();
    }

    public void verifyLearnAutomationtheRightWayisDisplayed() {

    }

    public void clicklearningmaterialButton() {
        learningmaterial_id.click();
    }

    public  void enterEmailAddress(String emailadd) {
        emailField_id.clear();
        emailField_id.sendKeys(emailadd.trim());
    }


    public  void enterPassword(String password) {
        passwordField_id.clear();
        passwordField_id.sendKeys(password.trim());
    }

    public void clickloginButton() {
        loginButton_id.click();

    }

    public void clickAboutUSbutton() {
        nav_btn_about_id.click();
    }

    public void verifyAboutNkosiCeleisDisplayed() {

    }

    public void clickslearningmaterialButton() {
        learningmaterial_id.click();
    }

    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(emailField_id));
        enterEmailAddress(email);
        enterPassword(password);
        clickloginButton();
    }


}

