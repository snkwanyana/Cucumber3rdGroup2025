package TestRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/Features",
            glue = {"StepDefs"},
            plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
            monochrome = true,
            tags = "@signup or @login or @devicePurchase"
    )
    public class Runner extends AbstractTestNGCucumberTests {
    }

