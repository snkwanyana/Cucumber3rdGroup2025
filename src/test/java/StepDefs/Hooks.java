package StepDefs;

import Utils.ScenarioContext;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import PageObjects.LoginPage;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import ExtentReports.ExtentReportManager;
//import utils.ScenarioContext;

public class Hooks {

   public static ExtentReports extent = ExtentReportManager.extentSetup();
    public static ExtentTest test;

    @Before
    public void beforeScenario(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("❌ Scenario failed: " + scenario.getName());
        } else {
            test.pass("✅ Scenario passed: " + scenario.getName());
        }
        extent.flush(); // Write everything to the report
    }
}