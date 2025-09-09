package Utils;
import PageObjects.SignupPage;
import Utils.BrowserFactory; // Adjust the package if needed
import org.openqa.selenium.WebDriver;

import static Utils.BrowserFactory.driver;

public class Base {



    public static void setUp(String browser, String url) {
        driver = BrowserFactory.startBrowser(browser, url);
        final WebDriver driver = BrowserFactory.startBrowser(browser, "https://gray-island-0bd788c1e.2.azurestaticapps.net/#practice");
        //signupPage = new SignupPage(driver);
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

