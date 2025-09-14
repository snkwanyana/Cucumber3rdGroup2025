package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LearningMaterialsPage {

    WebDriver driver;

    @FindBy(id="logout-button")
    WebElement logoutButton_id;

    public LearningMaterialsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogoutButton() {
        logoutButton_id.click();
    }
}
