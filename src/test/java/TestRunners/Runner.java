package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/Features",
            tags = "@Regression",
            glue = {"StepDefs"},
            plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            monochrome = true
//            tags = "@Login"
    )
    public class Runner extends AbstractTestNGCucumberTests {
    }

