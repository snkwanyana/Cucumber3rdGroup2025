package Utils;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
   protected final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/" +
            " " );

    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    public SignupPage signupPage = PageFactory.initElements(driver, SignupPage.class);

    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);

    public PracticeAssessmentsPage practiceAssessmentsPage = PageFactory.initElements(driver, PracticeAssessmentsPage.class);

    public Extras extras = PageFactory.initElements(driver, Extras.class);

    public TakeScreenshots takeScreenshots = new TakeScreenshots();


}
