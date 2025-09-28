package Utils;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    public static WebDriver driver; // Make driver public static

    public LoginPage loginPage;
    public SignupPage signupPage;
    public LandingPage landingPage;
    public TakeScreenshots takeScreenshots;
    public OrderingPage orderingPage;
    public WelcomePage welcomePage;
    public PricingParnel pricingParnel;

    public void initializePages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        signupPage = PageFactory.initElements(driver, SignupPage.class);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        takeScreenshots = new TakeScreenshots();
        orderingPage = PageFactory.initElements(driver, OrderingPage.class);
        welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        pricingParnel = PageFactory.initElements(driver, PricingParnel.class);
    }
}
