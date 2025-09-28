package StepDefs;
import Utils.Base;
import io.cucumber.java.en.*;


public class orderingStep1 extends Base {


    @Given("User is on the Form page")
    public void user_is_on_the_form_page() {
        landingPage.clickLearnMoreButton();
        loginPage.enterEmail("Amytest@gmail.com");
        loginPage.enterPassword("Password123");
        loginPage.clickLoginField();
        welcomePage.clickWebTabButton();

    }
    @When("User selects device type order1 {}")
    public void user_selects_device_type_order1(String type) {
        orderingPage.selectDeviceType(type);

    }
    @When("the user selects brand {}")
    public void the_user_selects_brand(String brand) {
        orderingPage.selectBrand(brand);

    }
    @When("the user selects storage {}")
    public void the_user_selects_storage(String storage) {
        orderingPage.selectStorage(storage);

    }
    @When("the user selects color {}")
    public void the_user_selects_color( String color) {
        orderingPage.selectColor(color);

    }
    @When("the user enters quantity {int}")
    public void the_user_enters_quantity(Integer quantity) {
        orderingPage.setQuantity(quantity);

    }
    @When("the user enters address {}")
    public void the_user_enters_address_main_st_cityville(String address) {
        orderingPage.setAddress(address);

    }
    @When("the user clicks the Next button")
    public void the_user_clicks_the_next_button() {
        orderingPage.clickNext();

    }
    @Then("Step {int} should be displayed")
    public void step_should_be_displayed(Integer int1) {

    }



}
