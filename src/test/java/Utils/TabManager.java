package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TabManager {


    WebDriver driver;

    public TabManager(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    public void switchBackToOriginalTab(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }
}
