package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage {
    WebDriver driver;

    @FindBy(id="practice-heading")
    WebElement welcomeHeading_id;

    @FindBy(id="tab-btn-web")
    WebElement webTabButton_id;

    public boolean isHeadingDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void verifyWelcomeHeadingIsDisplayed() {

        welcomeHeading_id.isDisplayed();
    }

    public void clickWebTabButton() {

        webTabButton_id.click();
    }




}
