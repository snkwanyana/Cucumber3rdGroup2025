package PageObjects;

import Utils.BrowserFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {
    static WebDriver driver;
    static LoginPage loginPage;

    @BeforeClass
    public static void setUp() {
        // Start browser and navigate to login page
        driver = BrowserFactory.startBrowser("chrome", "https://gray-island-0bd788c1e.2.azurestaticapps.net/#login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        String email = System.getenv("LOGIN_EMAIL");
        String password = System.getenv("LOGIN_PASSWORD");
        if (email == null) email = "";
        if (password == null) password = "";
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        // Optionally, add assertions here to verify login success
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
