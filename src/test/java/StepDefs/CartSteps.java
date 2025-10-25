package StepDefs;

import PageObjects.CartPage;
import Utils.Base;
import io.cucumber.java.en.*;

public class CartSteps extends Base {

    CartPage cartPage = new CartPage(driver);

    @Given("I add a {string} {string} {string} to the cart")
    public void i_add_device(String deviceType, String brand, String storage) {
        cartPage.addDevice(deviceType, brand, storage);
    }

    @Then("the cart should show {string}")
    public void cart_should_show(String expectedTitle) {
        cartPage.AddToCart();
        cartPage.assertCartTitle(expectedTitle);
    }

    @Given("I have added a {string} {string} {string} to the cart")
    public void i_have_added_first_device(String deviceType, String brand, String storage) {
        cartPage.addDevice(deviceType, brand, storage);
    }

    @Then("only the first item should show a discount line")
    public void only_first_has_discount() {
        cartPage.assertDiscountOnlyFirstItem();
    }

    @When("I remove the item at index {int}")
    public void remove_item(int index) {
        cartPage.removeItemAtIndex(index);
    }

    @Then("the cart grand total should be {string}")
    public void check_grand_total(String total) {
        cartPage.assertGrandTotal(total);
    }

    @Then("the cart panel should be {string}")
    public void check_cart_panel(String visibility) {
        cartPage.assertCartPanelVisible(visibility.equalsIgnoreCase("visible"));
    }

    @When("I try to add {string} {string} with missing storage")
    public void try_add_missing_storage(String deviceType, String brand) {
        cartPage.addDevice(deviceType, brand, null);
    }

    @Then("the cart should not increment and an error should be shown")
    public void cart_should_not_increment_with_error() {
        int beforeCount = cartPage.getCartItemCount();
        cartPage.assertErrorDisplayed();
        int afterCount = cartPage.getCartItemCount();
        assert beforeCount == afterCount : "❌ Cart count should remain unchanged!";
    }

    @When("I select device type {string}, brand {string}, storage {string}, quantity {string}, and enter delivery address {string}")
    public void iSelectDeviceTypeBrandStorageQuantityAndEnterDeliveryAddress(String device, String brand, String storage, String qty, String address) {
        pricingPanelPage.selectDeviceType(device);
        pricingPanelPage.selectBrand(brand);
        pricingPanelPage.selectStorage(storage);
        pricingPanelPage.setQuantity(Integer.parseInt(qty));
        pricingPanelPage.enterAddress(address);
    }

    @And("click add to Cart")
    public void clickAddToCart() {
        cartPage.AddToCart();
    }

    @And("I add it to the cart")
    public void iAddItToTheCart() {
        cartPage.AddToCart();
    }
}
