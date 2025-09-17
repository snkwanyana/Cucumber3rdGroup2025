package StepDefs;

import PageObjects.LearningMaterialPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;

public class StepDefinition extends Base {

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
    public void user_should_see_an_error_message(String errorMessage) throws InterruptedException {

        signupPage.confirmIfErrorMessageIsDisplayed(errorMessage);

    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();
    }

    @And("User enters password {}")
    public void userEntersPassword(String password) {
        loginPage.EnterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }


    @Then("User should be successfully logged in and see practice page")
    public void userShouldBeSuccessfullyLoggedInAndSeePracticePage() {
        //learningMaterialPage.logoutbtn_idDisplayed();

    }


    @Given("user is on learning materials")
    public void userIsOnLearningMaterials() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();

    }


    @When("user selects a product to purchase {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressdiscount(String username, String password, String deviceType, String brand, String storage, String color, String quantity, String deliveryAddress,String discount) throws InterruptedException {
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.SelectBrand(brand);
        learningMaterialPage.SelectStorage(storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
//        learningMaterialPage.enterDiscountCode(discount);
//        learningMaterialPage.ClickApplyDiscountButton();
    }

    @Then("user should be able to confirm product details")
    public void userShouldBeAbleToConfirmProductDetails() {
        
    }

    @And("clicks Next button to proceed to checkout")
    public void clicksNextButtonToProceedToCheckout() {
        
    }

    @And("user should be able to complete the purchase")
    public void userShouldBeAbleToCompleteThePurchase() {
    }
//    public  void waitForElementToBeVisible(WebDriverWait driver, String element, int timeoutInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
//        wait.until(driver1 -> getDriver().findElement(org.openqa.selenium.By.xpath(element)).isDisplayed());
//    }

}
