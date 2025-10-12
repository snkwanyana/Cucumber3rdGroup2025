package Utils;

import PageObjects.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
    protected final WebDriver driver;

    public LoginPage loginPage;
    public SignupPage signupPage;
    public LandingPage landingPage;
    public InventoryFormPage inventoryFormPage;
    public InvoicePage invoicePage;
    public TakeScreenshots takeScreenshots = new TakeScreenshots();

    public Base(WebDriver driver) {
        this.driver = driver;
        this.loginPage = PageFactory.initElements(driver, LoginPage.class);
        this.signupPage = PageFactory.initElements(driver, SignupPage.class);
        this.landingPage = PageFactory.initElements(driver, LandingPage.class);
        this.inventoryFormPage = PageFactory.initElements(driver, InventoryFormPage.class);
        this.invoicePage = PageFactory.initElements(driver, InvoicePage.class);
    }
}
