package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LearningMaterial {

    @FindBy(id = "tab-btn-web")
    WebElement webAutomation_id;
    @FindBy(id = "deviceType")
    WebElement deviceTypeSelect_id;

    public  void clickWebAutomationButton() {
        webAutomation_id.click();
    }
    public void selectDeviceTypeByVisibleText(String visibleText) {
        wait.until(ExpectedConditions.elementToBeClickable(deviceTypeSelect_id));
        new Select(deviceTypeSelect_id).selectByVisibleText(visibleText);
    }
}

