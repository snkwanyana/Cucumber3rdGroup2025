package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = {"src/test/resources/Features/login.feature",
            "src/test/resources/Features/signup.feature"},
            glue = {"StepDefs"},
            plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
            monochrome = true,
            tags = "@signup"
    )
    public class Runner extends AbstractTestNGCucumberTests {
    }

