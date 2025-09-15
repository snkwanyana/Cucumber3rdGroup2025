package Utils;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import PageObjects.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://gray-island-0bd788c1e.2.azurestaticapps.net/" +
            " " );

    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public SignupPage signupPage = PageFactory.initElements(driver, SignupPage.class);
    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);


}
