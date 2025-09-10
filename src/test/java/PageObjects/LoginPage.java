package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;

    @FindBy(xpath = "//*[@id=\"root\"]/div/section/div/div[3]/span")
    WebElement verifyLoginPage_xpath;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/div[1]/input[1]")
    WebElement the_email_field;

    @FindBy(xpath = "//input[@placeholder='Password")
    WebElement the_password_field;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement the_login_button;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    public void the_user_is_redirected_to_the_login_page() {
        Assert.assertEquals(verifyLoginPage_xpath, "Don't have an account?");
    }

    public void the_user_enters_the_email(String email){
        the_email_field.sendKeys(email);
    }
    public void the_user_enters_password(String password) {
        the_password_field.sendKeys(password);
    }
    public void the_user_clicks_on_login_button() {
        the_login_button.click();
    }



    public void clickSignupButton() {

        signupButton_id.click();
    }


}
