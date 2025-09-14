package PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "login-email")
    WebElement usernameField_id;
    @FindBy(id = "login-password")
    WebElement passwordField_id;
    @FindBy(id = "login-submit")
    WebElement loginButton_id;
    @FindBy(xpath = "//h2[text()='Practice Assessments']")
    WebElement productsLabel_xpath;

    @FindBy(id = "signup-toggle")
    WebElement signupButton_id;
    @FindBy(xpath = "//h2[text()='Learn Automation the Right Way']")
    WebElement homePageLabel_xpath;
    @FindBy(id = "nav-btn-practice")
    WebElement learningMaterialsButton_id;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmIfHomePageIsDisplayed() {
        homePageLabel_xpath.isDisplayed();
    }
    public void clickLearningMaterialsButton() {
        learningMaterialsButton_id.click();
    }
    public void confirmIfLoginPageIsDisplayed() {
        signupButton_id.isDisplayed();
    }

    public void enterUsername(String username) {
        usernameField_id.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.id("login-submit")).click();
    }

    public void vilidateLoginIfPassedOrFailed(String message) {
        if (message.isEmpty()){
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(productsLabel_xpath));
            productsLabel_xpath.isDisplayed();
        }else {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(alertText, message);
            alert.accept();
        }
    }

    public void clickSignupButton() {
        signupButton_id.click();
    }


}
