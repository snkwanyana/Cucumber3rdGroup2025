package Utils;

import PageObjects.*;
import StepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/" +
            " " );

    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public SignupPage signupPage = PageFactory.initElements(driver, SignupPage.class);
    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);
    public SelectDevicePage selectDevicePage = PageFactory.initElements(driver, SelectDevicePage.class);
    public AddExtrasPage addExtrasPage = PageFactory.initElements(driver, AddExtrasPage.class);
    public AddSecondDevice addSecondDevice = PageFactory.initElements(driver, AddSecondDevice.class);
    public ReviewOrder reviewOrder = PageFactory.initElements(driver, ReviewOrder.class);

//    public ScenarioContext scenarioContext = new ScenarioContext();
//    public Hooks hooks = new Hooks();
    //public PaymentPage paymentPage = PageFactory.initElements(driver, PaymentPage.class);


}
