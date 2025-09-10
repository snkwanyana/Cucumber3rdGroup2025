package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "nav-btn-practice")
    WebElement LearnMoreButton_id;

    @FindBy(id = "overview-hero")
    WebElement LearnAutomationTheRightWay_id;

    public void verifyLearnAutomationTheRightWayIsDisplayed() {

        LearnAutomationTheRightWay_id.isDisplayed();
    }

    public void clickLearnMoreButton() {
        LearnMoreButton_id.click();
    }


}
