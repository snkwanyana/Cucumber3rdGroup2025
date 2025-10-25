package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    private WebDriverWait wait;

    PracticeAssessmentsPage practiceAssessmentsPage;

    @FindBy(id = "login-email")
    WebElement usernameInput;

    @FindBy(id = "signup-toggle")
    WebElement signupButton;

    @FindBy(id = "login-password")
    WebElement passwordInput;

    @FindBy(id = "login-submit")
    WebElement loginBtn;

    @FindBy(id = "logout-button")
    WebElement logoutButton;

    @FindBy(css = ".tab-container")
    WebElement tabsContainer;

    @FindBy(id = "nav-btn-setup")
    WebElement enrolTab;

    @FindBy(id = "enrol-heading")
    WebElement enrolTabHeading;



    @FindBy(id = "nav-btn-practice")
    WebElement learnMoreButtonId;

    @FindBy(id = "overview-hero")
    WebElement learnAutomationTheRightWayId;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ explicit waits
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username.trim());
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.clear();
        passwordInput.sendKeys(password.trim());
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public boolean areTabsVisible() {
        wait.until(ExpectedConditions.visibilityOf(tabsContainer));
        return tabsContainer.isDisplayed();
    }

    public boolean isTokenPresent() {
        return (Boolean) ((JavascriptExecutor) driver)
                .executeScript("return localStorage.getItem('authToken') !== null;");
    }

    public void removeToken() {
        ((JavascriptExecutor) driver).executeScript("localStorage.removeItem('authToken');");
    }

    public void clickSignup() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }

     public void clickEnrolTab() {
         wait.until(ExpectedConditions.elementToBeClickable(enrolTab)).click();
     }

    public boolean isEnrolTabHeadingVisible() {
        wait.until(ExpectedConditions.visibilityOf(enrolTabHeading));
        return enrolTabHeading.isDisplayed();
    }

    public void assertSignUpButtonIsVisible() {
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button is NOT displayed!");
    }




    public void confirmIfMessageIsDisplayed(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            if (expectedMessage.equalsIgnoreCase("logout")) {
                // 🔹 Successful login → wait until logout button is visible
                wait.until(ExpectedConditions.visibilityOf(logoutButton));
                Assert.assertTrue(
                        logoutButton.isDisplayed(),
                        "Expected Logout button to be visible, but it was not."
                );
            } else {
                // 🔹 Error or info → expect an alert
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                String actualMessage = alert.getText().trim();

                Assert.assertEquals(
                        actualMessage,
                        expectedMessage,
                        "Alert message mismatch!"
                );

                alert.accept(); // ✅ Close the alert
            }
        } catch (NoAlertPresentException e) {
            Assert.fail("Expected alert not found for message: " + expectedMessage);
        }



    }

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





