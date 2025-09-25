package StepDefs;


import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;


public class StepDefinition extends Base {
    public WebDriver driver;

    public StepDefinition() {
        this.driver = super.driver;
    }
/// ///////////////////////////// Sign Up //////////////////////////////////////////
    @Given("User is on the signup page")
    public void user_is_on_the_signup_page() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
        loginPage.clickSignupButton();

    }

    @When("User enters name {}")
    public void user_enters_name(String name) {
        signupPage.enterFirstName(name);

    }

    @And("User enters last name {}")
    public void user_enters_last_name(String lastName) {
        signupPage.enterLastName(lastName);

    }

    @And("User enters email {}")
    public void user_enters_email(String email) {
        signupPage.enterEmail(email);

    }

    @And("User enters new password {}")
    public void user_enters_new_password(String password) {
        signupPage.enterPassword(password);

    }

    @And("User enters confirm password {}")
    public void user_enters_confirm_password(String comfirmPassword) {
        signupPage.enterConfirmPassword(comfirmPassword);
    }

    @And("User clicks on the create account button")
    public void user_clicks_on_the_create_account_button() {
        signupPage.clickCreateAccount();

    }

    @Then("User should see an error message {}")
    public void user_should_see_an_error_message(String errorMessage) {

        signupPage.confirmIfErrorMessageIsDisplayed(errorMessage);

    }

    /// ///////////////Log in Steps ///////////////////////
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        landingPage.clickLearnMoreButton();
    }

    @And("User enters Email {}")
    public void user_enters_Email(String emails) {
        loginPage.enterEmail(emails);
        takeScreenshots.takeScreenshot(driver, "LoginPage");
    }

    @And("User enters password {}")
    public void user_enters_password_plan_j(String Password) {
        loginPage.enterPassword(Password);
        takeScreenshots.takeScreenshot(driver, "LoginPage");
    }

    @Then("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }


    /// ///Practice Assessments Steps /////
    @Given("User is on the practice assessments page")
    public void user_is_on_the_practice_assessments_page() {
        loginPage.verifyPracticeAssessmentIsDisplayed();
    }

    @And("User clicks on the web automation link")
    public void user_clicks_on_the_web_automation_link() {
        loginPage.clickWebTab();
    }

    @And("User selects device type {}")
    public void user_selects_device_type(String deviceType) {
        practiceAssessmentsPage.selectDeviceType(deviceType);
        practiceAssessmentsPage.verifyPricingDetailsDisplayed();
    }

    @And("User selects brand {}")
    public void user_selects_brand(String brand) {
        practiceAssessmentsPage.selectBrand(brand);
    }

    @And("User selects storage {}")
    public void user_selects_storage(String storage) {
        if (storage.equals("64GB")) {
            practiceAssessmentsPage.selectStorage128(storage);
        } else if (storage.equals("128GB")) {
            practiceAssessmentsPage.selectStorage128(storage);
        } else if (storage.equals("256GB")) {
            practiceAssessmentsPage.selectStorage256(storage);
        } else {
            throw new IllegalArgumentException("Invalid storage option: " + storage);
        }
    }

    @And("User selects color {}")
    public void user_selects_color(String color) {
        practiceAssessmentsPage.selectColor(color);
    }

    @And("User enters quantity{}")
    public void user_enters_quantity(String quantity) {
        practiceAssessmentsPage.enterQuantity(quantity);
    }

    @And("User enters delivery address {}")
    public void user_enters_delivery_address(String Address) {
        practiceAssessmentsPage.enterAddress(Address);
    }

    @Then("User clicks on the next button")
    public void user_clicks_on_the_next_button() {
        practiceAssessmentsPage.clickNextButton();
    }

    /// /////////////////////////////////Extras  Steps ///////////////////////
    @And("User selects shipping method {}")
    public void user_selects_standard_shipping_option(String method) {
        if (method.equals("Standard")) {
            extras.selectStandardShipping(method);
        } else if (method.equals("Express (+R25)")) {
            extras.selectExpressShipping(method);
        }

    }

    @And("User selects warranty {}")
    public void select_warranty(String warranty) {
        if (warranty.equals("None (R0)")) {
            extras.selectNoWarranty(warranty);
        } else if (warranty.equals("1 Year (+R49)")) {
            extras.select1YearWarranty(warranty);
        } else if (warranty.equals("2 Year (+R89)")) {
            extras.select2YearWarranty(warranty);
        }

    }

    @And("User enters a discount code {}")
    public void user_enters_discount_code(String code) {
        extras.enterDiscountCode(code);
    }

    @And("User clicks on apply discount button")
    public void user_clicks_on_the_apply_discount_button() {
        extras.clickApplyDiscount();
    }

    @And("User clicks on the confirm purchase button")
    public void user_clicks_on_confirm_purchase_button() {
        extras.clickCorfirmPurchase();
    }



    @After
    public void quitBrowser() {
        driver.quit();
    }


}