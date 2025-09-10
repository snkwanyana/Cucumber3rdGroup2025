package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssessmentPage {

    WebDriver driver;

    @FindBy(id = "practice-heading")
    WebElement practiceHeading_id;

    @FindBy(id = "tab-btn-web")
    WebElement WebAutomation_id;

    public AssessmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void confirmYouAreOnAssessmentPage() {
        practiceHeading_id.isDisplayed();
    }

    public void clickAutomationTab() {
        WebAutomation_id.click();
    }


}
