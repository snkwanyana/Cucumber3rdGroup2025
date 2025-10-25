package StepDefs;

import PageObjects.PricingPanelPage;
import PageObjects.LandingPage;
import Utils.Base;
import io.cucumber.java.en.*;

import java.awt.*;

import static com.ndosi.utils.BrowserFactory.getDriver;

public class PricingPanelSteps extends Base {

    PricingPanelPage pricingPanelPage;

    public PricingPanelSteps() {}

    @Given("user logs in with the valid credentials")
    public void userLogsInWithTheValidCredentials() {
        login("ree@test.com", "Password@123"); // Base login method
        pricingPanelPage = new PricingPanelPage(getDriver());
    }

    @Given("navigate to the Practice Assessments")
    public void navigateToPracticeAssessments() {
        practiceAssessmentsPage.clickWebAutomation();
    }

    @When("the user selects the device type {string}")
    public void theUserSelectsDeviceType(String deviceType) {
        pricingPanelPage.selectDeviceType(deviceType);
    }

    @When("the user selects the storage {string}")
    public void theUserSelectsStorage(String storage) {
        pricingPanelPage.selectStorage(storage);
    }

    @When("the user sets the quantity {string}")
    public void theUserSetsQuantity(String quantity) {
        if (quantity != null && !quantity.isEmpty()) {
            pricingPanelPage.setQuantity(Integer.parseInt(quantity));
        }
    }


    @When("the user clears the device selection")
    public void theUserClearsDeviceSelection() {
        pricingPanelPage.clearDeviceSelection();
    }


    @Then("the pricing panel should show Unit {string} and Subtotal {string}")
    public void thePricingPanelShouldShowUnitAndSubtotal(String unitPrice, String subtotal) throws InterruptedException, AWTException {
        pricingPanelPage.assertPricing(unitPrice, subtotal);
    }
}
