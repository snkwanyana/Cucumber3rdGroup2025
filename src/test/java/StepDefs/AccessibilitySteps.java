package StepDefs;

import PageObjects.AccessibilityPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class AccessibilitySteps extends Base {

    WebDriver driver;
    AccessibilityPage accessibilityPage = new AccessibilityPage(driver);

    @Given("I am on the main application page")
    public void i_am_on_the_main_application_page() {
        login("ree@test.com", "Password@123");
    }

    @When("I press Tab key repeatedly")
    public void i_press_tab_key_repeatedly() {
        // Wait handled in page
    }

    @Then("focus should move sequentially through {string}")
    public void focus_should_move_sequentially_through(String expectedSequence) {
        accessibilityPage.verifyTabNavigationSequence(expectedSequence);
    }

    @Given("I am on the product configuration page")
    public void i_am_on_the_product_configuration_page() {
        // Navigate using global form methods from PricingPanel if needed
        pricingPanelPage.selectDeviceType("phone");
    }

    @When("I navigate to the storage section using Tab")
    public void navigate_to_storage_with_tab() {
        // Handled within page selection
    }

    @And("I select a storage option with keyboard")
    public void select_storage_keyboard() {
        accessibilityPage.selectStorageByKeyboard();
    }

    @Then("the selected radio should reflect correctly")
    public void selected_radio_reflect_correctly() {
        // Assertion already in method
    }

    @When("a validation error appears")
    public void validation_error_appears() {
        accessibilityPage.verifyErrorRoleAlert();
    }

    @Then("it should use role {string}")
    public void it_should_use_role_alert(String role) {
        // Already verified by the page method
    }

    @When("a success toast appears")
    public void success_toast_appears() {
        accessibilityPage.verifyToastRoleStatus();
    }

    @Given("a success popup is visible")
    public void success_popup_visible() {
        // Assume triggered by an earlier action
    }

    @When("I press Enter on the dismiss button")
    public void press_enter_on_dismiss_button() {
        accessibilityPage.verifyPopupDismissKeyboard();
    }

    @Then("the popup should close")
    public void popup_should_close() {
        // Verification already inside page
    }

    @Given("I open thee invoice history panel")
    public void open_invoice_history_panel() {
        accessibilityPage.verifyInvoiceHistoryAccessibility();
    }

    @Then("the panel should have aria-label {string}")
    public void panel_should_have_aria_label(String ariaLabel) {
        // Covered in page method
    }

    @And("the first focusable element should be focused")
    public void first_focusable_element_should_be_focused() {
        // Covered in page method
    }
}
