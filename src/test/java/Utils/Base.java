package Utils;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class Base {
    public static WebDriver driver;

    // Page objects
    public SignupPage signupPage;
    public LandingPage landingPage;
    public PracticeAssessmentsPage practiceAssessmentsPage;
    public PricingPanelPage pricingPanelPage;
    public ExtrasPricingPage extrasPricingPage;
    public LoginPage loginPage;
    public CartPage cartPage;

    public Base() {
        // Always start a new driver instance for each scenario
        driver = BrowserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");
        initializePageObjects();
    }

    private void initializePageObjects() {
        signupPage = new SignupPage(driver);
        landingPage = new LandingPage(driver);
        practiceAssessmentsPage = new PracticeAssessmentsPage(driver);
        pricingPanelPage = new PricingPanelPage(driver);
        extrasPricingPage = new ExtrasPricingPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }
    public void login(String username, String password) {
        landingPage.waitForHeroSection();
        landingPage.clickLearnMoreButton();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin(); }

    public static WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
