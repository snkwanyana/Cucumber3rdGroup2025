package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/Features",
            glue = {"StepDefs"},
            plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
            monochrome = true
    )
    public class Runner extends AbstractTestNGCucumberTests {
    }

