package Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;
    public static Base base;
    private TakeScreenshots takeScreenshots = new TakeScreenshots();

    @Before
    public void setUp() {
        driver = BrowserFactory.startBrowser("chrome", "https://ndosiautomation.co.za/");
        base = new Base(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take screenshot if scenario fails
        if (scenario.isFailed()) {
            takeScreenshots.takesSnapShot(driver, scenario.getName());
        }
        // Quit browser after each scenario
        if (driver != null) {
            driver.quit();
        }
    }
}
