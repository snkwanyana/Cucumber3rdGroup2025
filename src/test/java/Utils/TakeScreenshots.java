package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;



public class TakeScreenshots {

    private static final String screenshotDir = System.getProperty("user.dir") + "/Screenshots";

   public void takeScreenshot(WebDriver driver,String screenshotName) {
       TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
       File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
       File dest = new File(screenshotDir ,screenshotName + System.currentTimeMillis() + ".png");
       try {
           FileUtils.copyFile(src, dest);
       }catch (Exception e) {
           e.printStackTrace();
       }
   }
}
