package StepDefs;

import PageObjects.LoginPage;
import PageObjects.PracticeAssessmentsPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class WizardStep1Steps extends Base {

    WebDriver driver;
    LoginPage loginPage;
    PracticeAssessmentsPage practiceAssessmentsPage;

    public WizardStep1Steps() throws InterruptedException {
        super();
        driver = getDriver();
        loginPage = new LoginPage(driver);
        practiceAssessmentsPage = new PracticeAssessmentsPage(driver);
    }

    @Given("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        login("ree@test.com", "Password@123");
        loginPage.isTokenPresent();
    }

    @When("navigate to Practice Assessments")
    public void navigate_to_practice_assessments() {
        practiceAssessmentsPage.clickWebAutomation();
    }

    @And("the user selects device type {string}")
    public void the_user_selects_device_type(String deviceType) {
        if (deviceType != null && !deviceType.isEmpty()) {
            practiceAssessmentsPage.selectDeviceType(deviceType);
        }
    }

    @And("the user selects brand {string}")
    public void the_user_selects_brand(String brand) {
        if (brand != null && !brand.isEmpty()) {
            practiceAssessmentsPage.selectBrand(brand);
        }
    }

    @And("the user selects storage {string}")
    public void the_user_selects_storage(String storage) {
        if (storage != null && !storage.isEmpty()) {
            practiceAssessmentsPage.selectStorage(storage);
        }
    }

    @And("the user sets quantity {string}")
    public void the_user_sets_quantity(String quantity) {
        if (quantity != null && !quantity.isEmpty()) {
            practiceAssessmentsPage.setQuantity(Integer.parseInt(quantity));
        }
    }

    @And("the user enters delivery address {string}")
    public void the_user_enters_delivery_address(String address) {
        if (address != null && !address.isEmpty()) {
            practiceAssessmentsPage.enterDeliveryAddress(address);
        }
    }

    @And("the user clicks Purchase Device {string}")
    public void theUserClicksPurchaseDevice(String expectedResult) {
        practiceAssessmentsPage.clickPurchaseDevice(expectedResult);
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedResult) {
        practiceAssessmentsPage.confirmErrorMessage(expectedResult);
    }

    @And("the form should reset to default values")
    public void the_form_should_reset_to_default_values() {
        practiceAssessmentsPage.assertFormReset();
    }

    @And("the user clicks Logout")
    public void the_user_clicks_logout() {
        loginPage.clickLogout();
    }
}
