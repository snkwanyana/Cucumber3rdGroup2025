package PageObjects;

import Utils.Base;
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

    @FindBy(id="nav-btn-contact")
    WebElement contactTabButton_id;

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

    public boolean isAuthTokenPresent() {
        String script = "return window.localStorage.getItem('authToken');";
        Object token = ((org.openqa.selenium.JavascriptExecutor) Base.driver).executeScript(script);
        return token != null && !token.toString().isEmpty();
    }

    public String getAuthToken() {
        String script = "return window.localStorage.getItem('authToken');";
        Object token = ((org.openqa.selenium.JavascriptExecutor) Base.driver).executeScript(script);
        return token != null ? token.toString() : null;
    }

    // Extract token from network response body (JSON)
    public String extractTokenFromResponse(String responseBody) {
        try {
            com.google.gson.JsonObject json = com.google.gson.JsonParser.parseString(responseBody).getAsJsonObject();
            if (json.has("authToken")) {
                return json.get("authToken").getAsString();
            }
        } catch (Exception e) {
            System.out.println("Failed to parse token from network response: " + e.getMessage());
        }
        return null;
    }
    public void clickContactTabButton() {

        contactTabButton_id.click();
    }




}
