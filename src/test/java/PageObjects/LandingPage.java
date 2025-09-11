package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // ✅ required for @FindBy
    }

    @FindBy(id = "nav-btn-practice")
   WebElement learnMoreButtonId;

    @FindBy(id = "overview-hero")
    WebElement learnAutomationTheRightWayId;

    public void verifyLearnAutomationTheRightWayIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(learnAutomationTheRightWayId));
        if (!learnAutomationTheRightWayId.isDisplayed()) {
            throw new AssertionError("Element 'LearnAutomationTheRightWay' is NOT displayed!");
        }
    }

    public void clickLearnMoreButton() {
        learnMoreButtonId.click();
    }
}
