package StepDefs;

import PageObjects.ErrorVerificationPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class ErrorVerificationSteps extends Base {

    WebDriver driver;
    ErrorVerificationPage errorPage = new ErrorVerificationPage(driver);


    @When("I trigger validation for {string}")
    public void i_trigger_validation_for(String errorCase) {
        errorPage.triggerError(errorCase);
    }

    @Then("I should see the exact error message {string}")
    public void i_should_see_the_exact_error_message(String expectedMessage) {
        errorPage.verifyExactErrorMessage(expectedMessage);
    }
}
