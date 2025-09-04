package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/SauceDemo.feature",
        glue = "StepDefs",
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class RunnerSauceDemo {
    // No code needed here — Cucumber handles everything
}