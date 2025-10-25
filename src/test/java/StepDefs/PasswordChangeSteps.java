package StepDefs;

import PageObjects.PasswordChangePage;
import Utils.Base;
import io.cucumber.java.en.*;

public class PasswordChangeSteps extends Base {

    PasswordChangePage passwordChangePage;

    @Given("I am on the password change page")
    public void i_am_on_the_password_change_page() {
        passwordChangePage = new PasswordChangePage(driver);
        passwordChangePage.openPasswordChangePage("https://www.ndosiautomation.co.za");
    }

    @When("I enter old password {string}, new password {string}, and confirm password {string}")
    public void i_enter_old_new_and_confirm_passwords(String oldPwd, String newPwd, String confirmPwd) {
        passwordChangePage.enterPasswords(oldPwd, newPwd, confirmPwd);
    }

    @And("I click the update password button")
    public void i_click_the_update_password_button() {
        passwordChangePage.clickUpdateButton();
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        passwordChangePage.verifyMessage(expectedMessage);
    }

    @When("I toggle all password visibility icons")
    public void i_toggle_all_password_visibility_icons() {
        passwordChangePage.testAllVisibilityToggles();
    }

    @Then("all password fields should toggle visibility successfully")
    public void all_password_fields_should_toggle_visibility_successfully() {
        // Nothing else needed — assertions handled in Page Object
    }
}
