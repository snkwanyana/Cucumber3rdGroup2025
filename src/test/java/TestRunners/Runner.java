package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/Features",
            glue = {"StepDefs"},
            plugin = {"pretty", "html:target/cucumber-reports.html"},
            monochrome = true,
            tags = "@signup"
    )
    public class Runner extends AbstractTestNGCucumberTests {
    }

