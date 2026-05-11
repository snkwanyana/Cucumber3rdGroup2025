package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[.//span[text()='Login']]")
    WebElement loginButton_xpath;

    @FindBy(xpath = "//p[@class='hero-subtitle' and text()='The Future of Quality Engineering Starts Here']")
    WebElement subTitle_xpath;

    public void verifyLandingPageSubTitle() {
        subTitle_xpath.isDisplayed();
    }

    public void clickLoginButton() {
        loginButton_xpath.click();
    }


}
