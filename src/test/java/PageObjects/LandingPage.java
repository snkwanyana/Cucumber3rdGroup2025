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

    @FindBy(xpath = "//img[@alt='NTA Logo' and contains(@src,'Nta Logo')]")
    WebElement logo_xpath;

    public void verifyPageLogo() {
        logo_xpath.isDisplayed();
    }

    public void clickLoginButton() {
        loginButton_xpath.click();
    }


}
