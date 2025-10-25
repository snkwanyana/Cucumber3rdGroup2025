package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "signup-toggle")
    WebElement signupButton;

    @FindBy(id = "nav-btn-practice")
     WebElement learnMoreButtonId;

    @FindBy(id = "overview-hero")
     WebElement learnAutomationTheRightWayId;

    /** Waits for the hero section to be visible */
    public void waitForHeroSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));
        try {
            wait.until(ExpectedConditions.visibilityOf(learnAutomationTheRightWayId));
        } catch (Exception e) {
            throw new RuntimeException(
                    "Hero section not found! The landing page may not have loaded properly.", e);
        }
    }

    /** Click Learn More button after hero section is visible */
    public void clickLearnMoreButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(learnMoreButtonId));
        learnMoreButtonId.click();
    }

    /** Click Signup button */
    public void clickSignup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signupButton));
        signupButton.click();
    }

}
