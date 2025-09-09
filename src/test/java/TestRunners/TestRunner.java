package TestRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = "StepDev", // not StepDefinition

        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
        //dryRun = false
)
public class TestRunner {
}
