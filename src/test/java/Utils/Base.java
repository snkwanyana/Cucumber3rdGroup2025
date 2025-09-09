package Utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
    protected WebDriver driver;   // Accessible in test classes


    @BeforeMethod
    public void setUp() {
        // Example: pick browser & URL from system property or config file
        String browser = System.getProperty("browser", "chrome");
        String url = System.getProperty("url", "https://example.com");

        driver = BrowserFactory.startBrowser(browser, url);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Always close driver after test
        }
    }
}
