package StepDefs;

import PageObjects.LearningMaterialPage;
import Utils.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;

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

        loginPage.confirmIfErrorMessageIsDisplayed(errorMessage);

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
    public void userShouldBeSuccessfullyLoggedInAndSeePracticePage() throws InterruptedException {
        learningMaterialPage.VerifyPracticeTextAppeared();


    }
    @And("User to switch browser tabs and login again{string},{string}")
    public void userToSwitchBrowserTabsAndLoginAgainUserNamePasswords(String uname, String pwrd) throws InterruptedException {
        loginPage.switchToNewTab();
        loginPage.EnterEmail(uname);
        loginPage.EnterPassword(pwrd);
        loginPage.clickLoginButton();
        learningMaterialPage.VerifyPracticeTextAppeared();
    }
//    @Then("User should be successfully logged in and see practice page{string},{string}")
//    public void userShouldBeSuccessfullyLoggedInAndSeePracticePageUsernamePword(String uname, String pwrd) throws InterruptedException {
//
//    }

    
    @Then("user to logout of the application")
    public void userToLogoutOfTheApplication() {
        loginPage.clickLogoutButton();
    }


    @Given("user is on learning materials")
    public void userIsOnLearningMaterials() {
        landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
        landingPage.clickLearnMoreButton();

    }


    @When("user selects a product to purchase {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressdiscount(String username, String password, String deviceType, String brand, String storage, String color, String quantity, String deliveryAddress, String discount) throws InterruptedException {
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.isDeviceTypeSelected(deviceType);
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.isBrandSelected(brand);
        learningMaterialPage.SelectBrand(brand);
        learningMaterialPage.SelectStorage(storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.ClickConfirmPurchaseButton();
        learningMaterialPage.verifysuccespurchase();

    }

    @When("user selects a product to purchase and Discount {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseAndDiscountUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscount(String Username, String password, String deviceType, String brand, String storage, String color, String quantity, String deliveryAddress, String discount) throws InterruptedException {
        loginPage.EnterEmail(Username);
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
        learningMaterialPage.enterDiscountCode(discount);
        learningMaterialPage.ClickApplyDiscountButton();
        learningMaterialPage.ClickConfirmPurchaseButton();
        learningMaterialPage.verifysuccespurchase();
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
//===========================================================================================================================


    @When("user selects a product to purchase and Discount {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseAndDiscountUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscountQuantityErrorMsg(String Username, String password, String deviceType, String brand, String storage, String color, String quantity, String deliveryAddress, String discount, String quantityErrorMsg) throws InterruptedException {
        loginPage.EnterEmail(Username);
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
        learningMaterialPage.quantityErrorMsg(quantityErrorMsg);
//        learningMaterialPage.enterDiscountCode(discount);
//        learningMaterialPage.ClickApplyDiscountButton();
//        learningMaterialPage.ClickConfirmPurchaseButton();
//        learningMaterialPage.verifysuccespurchase();
    }


    @When("login  and do not select device and Storage {string},{string}")
    public void loginAndDoNotSelectDeviceAndStorageUsernamePassword(String Username, String password) throws InterruptedException {

        loginPage.EnterEmail(Username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();


    }

    @Then("user to confirm price details is desh")
    public void userToConfirmPriceDetailsIsDesh() {
        learningMaterialPage.UnitPriceVerification();
        learningMaterialPage.SubVerification();
    }


    @When("user selects device type and storage {string},{string},{string},{string},{string}")
    public void userSelectsDeviceTypeAndStorageUsernamePasswordDeviceTypeStorageQuantity(String Username, String password, String deviceType, String Storage, String Quantity) throws InterruptedException {
        loginPage.EnterEmail(Username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.SelectStorage(Storage);
        learningMaterialPage.EnterQuantity(Quantity);
    }

    @Then("user should be able to confirm price details is R400")
    public void userShouldBeAbleToConfirmPriceDetailsIsR400() {
        learningMaterialPage.UnitPriceVerification();
        learningMaterialPage.SubVerification();
    }

    @Then("user should be able to confirm shipping price details{string}")
    public void userShouldBeAbleToConfirmShippingPriceDetailsShippingPrice(String sipmentOption) throws InterruptedException {
        //learningMaterialPage.selectShippingOption(sipmentOption);
    }

    @When("user selects a product to purchase {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscountDiscountfeedback(String Username, String password, String deviceType,String Brand, String Storage,String Color, String Quantity,String discount, String deliveryAddress, String feedback) throws InterruptedException {
        loginPage.EnterEmail(Username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.SelectBrand(Brand);
        learningMaterialPage.SelectStorage(Storage);
        learningMaterialPage.SelectColor(Color);
        learningMaterialPage.EnterQuantity(Quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.enterDiscountCode(discount);
        learningMaterialPage.ClickApplyDiscountButton();
        learningMaterialPage.DiscountFeedback(feedback);



    }
    @Given("user is on the inventory form step two")
    public void userIsOnTheInventoryFormStepTwo() throws InterruptedException {
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
    }
    @When("user selects a products to purchase  {string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductsToPurchaseUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscount(String Username,String password,String deviceType,String Brand,String Storage,String color,String Quantity,String deliveryAddress,String discount) throws InterruptedException {
        loginPage.EnterEmail(Username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.SelectBrand(Brand);
        learningMaterialPage.SelectStorage(Storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(Quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.enterDiscountCode(discount);
        learningMaterialPage.ClickApplyDiscountButton();
        learningMaterialPage.ClickAddToCartButton();
    }
    @Then("user should be able to add multiple items to the cart {string},{string},{string},{string},{string},{string}")
    public void userShouldBeAbleToAddMultipleItemsToTheCartDeviceTypeBrandStorageColorQuantityDeliveryAddress(String deviceType,String Brand,String Storage,String color,String Quantity,String deliveryAddress) {
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.SelectBrand(Brand);
        learningMaterialPage.SelectStorage(Storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(Quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.ClickAddToCartButton();
        learningMaterialPage.ClickRemoveItemButton();
        learningMaterialPage.verifyGrandTotalUpdateAfterRemoval();
//        learningMaterialPage.ClickReviewCartButton();
//        learningMaterialPage.ClickPlaceOrderButton();


    }
    @When("user selects a product to purchase and verify shiping price {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseAndVerifyShipingPriceUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscountShippingPrice(String Username,String Pword,String deviceType,String Brand,String Storage,String color,String Quantity,String deliveryAddress,String discount,String shippingPrice) throws InterruptedException {
        loginPage.EnterEmail(Username);
        loginPage.EnterPassword(Pword);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.SelectBrand(Brand);
        learningMaterialPage.SelectStorage(Storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(Quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.enterDiscountCode(discount);
        learningMaterialPage.ClickApplyDiscountButton();
        learningMaterialPage.SelectShipmentmethod(shippingPrice);
    }

    @Then("user should be able to select shipping information prices")
    public void userShouldBeAbleToSelectShippingInformationPrices() {



    }





    @When("user selects a product to purchase and review cart {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsAProductToPurchaseAndReviewCartUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscountsuccessmessage(String username, String password, String deviceType, String brand, String storage, String color, String quantity, String deliveryAddress, String discount,String successmessage) throws InterruptedException {
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.isDeviceTypeSelected(deviceType);
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.isBrandSelected(brand);
        learningMaterialPage.SelectBrand(brand);
        learningMaterialPage.SelectStorage(storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.ClickAddToCart();
        learningMaterialPage.ClickReviewCartButton();
        learningMaterialPage.verifyplaceorderisvisible();
        learningMaterialPage.VerifyCancelcardisvisible();
        learningMaterialPage.ClickCancelCartButton();
        learningMaterialPage.verifyreviewcartisvisible();
        learningMaterialPage.ClickReviewCartButton();
        learningMaterialPage.ClickPlaceOrderButton();
        learningMaterialPage.verifyOrderSuccessMessage(successmessage);
        learningMaterialPage.verifyorderdetailsisvisible();
        learningMaterialPage.verifytotalonsuccessorderisvisible();
        learningMaterialPage.ClickTclosebtnonsuccess();
        learningMaterialPage.ClickViewInvoicesbtn();
        // learningMaterialPage.ClickConfirmPurchaseButton();
        //learningMaterialPage.verifysuccespurchase();

    }
    @When("user selects a single product to purchase and confirm purchase  {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void userSelectsASingleProductToPurchaseAndConfirmPurchaseUsernamePasswordDeviceTypeBrandStorageColorQuantityDeliveryAddressDiscountsuccessmessage(String username, String password, String deviceType, String brand, String storage, String color, String quantity, String deliveryAddress, String discount,String successmessage) throws InterruptedException {
        loginPage.EnterEmail(username);
        loginPage.EnterPassword(password);
        loginPage.clickLoginButton();
        learningMaterialPage.ClickWebAutomation();
        learningMaterialPage.isDeviceTypeSelected(deviceType);
        learningMaterialPage.SelectDeviceType(deviceType);
        learningMaterialPage.isBrandSelected(brand);
        learningMaterialPage.SelectBrand(brand);
        learningMaterialPage.SelectStorage(storage);
        learningMaterialPage.SelectColor(color);
        learningMaterialPage.EnterQuantity(quantity);
        learningMaterialPage.EnterDeleveryAddress(deliveryAddress);
        learningMaterialPage.ClickInventoryNextButton();
        learningMaterialPage.ClickConfirmPurchaseButton();
        learningMaterialPage.verifysuccespurchase();
        learningMaterialPage.verifyOrderSuccessMessage(successmessage);
        learningMaterialPage.verifyorderdetailsisvisible();
        learningMaterialPage.verifytotalonsuccessorderisvisible();
        learningMaterialPage.verifyTimestampOnSuccessisvisible();
        learningMaterialPage.ClickViewinvoiceOnHistory();
        learningMaterialPage.ClickCloseinvoiceHistorybtn();
    }

    @After
    public void quitBrowser() {

        driver.close();
    }



}




