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
    public ExtrasPricingShipping extrasPricingShipping;
    public Cart cart;
    public InvoiceHistoryPanel invoiceHistoryPanel;
    public Invoice invoice;

    public void initializePages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        signupPage = PageFactory.initElements(driver, SignupPage.class);
        landingPage = PageFactory.initElements(driver, LandingPage.class);
        takeScreenshots = new TakeScreenshots();
        orderingPage = PageFactory.initElements(driver, OrderingPage.class);
        welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        pricingParnel = PageFactory.initElements(driver, PricingParnel.class);
        extrasPricingShipping = PageFactory.initElements(driver, ExtrasPricingShipping.class);
        cart = PageFactory.initElements(driver, Cart.class);
        invoiceHistoryPanel = PageFactory.initElements(driver, InvoiceHistoryPanel.class);
        invoice = PageFactory.initElements(driver, Invoice.class);
    }
}
