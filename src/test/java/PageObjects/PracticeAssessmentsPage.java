package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PracticeAssessmentsPage {
    @FindBy(xpath = "//h2[contains(text(),'Practice Assessments')]")
    public static WebElement practiceAssessment_xpath;

    public static void verifyPracticeAssessmentIsDisplayed() {
        String ActualElement = (practiceAssessment_xpath.getText());
        Assert.assertEquals(ActualElement, "Practice Assessments");
        System.out.println(ActualElement);
    }
}
