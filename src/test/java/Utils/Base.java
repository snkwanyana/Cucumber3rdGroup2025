package Utils;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.PracticeAssessmentsPage;
import PageObjects.SignupPage;
import org.openqa.selenium.WebDriver;

public class Base {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected LandingPage landingPage;
    protected PracticeAssessmentsPage practiceAssessmentsPage;

    public Base() throws InterruptedException {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = BrowserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/");

        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        landingPage = new LandingPage(driver);
        practiceAssessmentsPage = new PracticeAssessmentsPage(driver); // assign to class variable
    }
}
