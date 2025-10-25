package StepDefs;

import PageObjects.MultiDeviceCartPage;
import Utils.Base;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class MultiDeviceCartSteps extends Base {

    WebDriver driver;
    MultiDeviceCartPage cartPage;

    public MultiDeviceCartSteps() {
        driver = getDriver(); // Assuming Base has getDriver()
        cartPage = new MultiDeviceCartPage(driver);
    }

    @When("I add a {string} {string} {string} with {string} qty, {string} shipping, {string} warranty, {string} discount")
    public void add_device(String type, String brand, String storage, String qty, String ship, String warranty, String discount) {
        cartPage.configureDevice(type, brand, storage, Integer.parseInt(qty), ship, warranty, discount);
        cartPage.clickAddToCart();
    }

    @Then("both device types should appear in the cart")
    public void both_device_types_should_appear_in_cart(io.cucumber.datatable.DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String first = rows.get(0).get("firstDeviceType");
        String second = rows.get(0).get("secondDeviceType");
        cartPage.assertBothDeviceTypesPresent(first, second);
    }

    @Then("only {string} should show discount line")
    public void only_one_device_has_discount(String discountedDevice) {
        cartPage.assertOnlyDeviceShowsDiscount(discountedDevice);
    }

    @Then("the grand total should equal sum of both items")
    public void grand_total_matches_sum() {
        cartPage.assertGrandTotalEqualsSum();
    }

    @Given("I have added both {string} and {string} to the cart")
    public void added_both_devices(String first, String second) {
        cartPage.assertBothDeviceTypesPresent(first, second);
    }

    @When("I remove {string}")
    public void remove_device(String deviceType) {
        cartPage.removeDevice(deviceType);
    }

    @Then("the remaining total should reflect only the other device")
    public void remaining_total_reflects_other_device(io.cucumber.datatable.DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String remaining = rows.get(0).get("firstDeviceType").equals(rows.get(0).get("removedDevice"))
                ? rows.get(0).get("secondDeviceType")
                : rows.get(0).get("firstDeviceType");
        cartPage.assertRemainingTotals(remaining);
    }

    @Then("the discount lines should match the remaining device")
    public void discount_lines_match_remaining_device(io.cucumber.datatable.DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String remaining = rows.get(0).get("firstDeviceType").equals(rows.get(0).get("removedDevice"))
                ? rows.get(0).get("secondDeviceType")
                : rows.get(0).get("firstDeviceType");
        cartPage.assertOnlyDeviceShowsDiscount(remaining);
    }

    @When("I quickly add {string} {string} {string}")
    public void quickly_add_first(String type, String brand, String storage) {
        cartPage.configureDevice(type, brand, storage, 1, "standard", "none", "none");
        cartPage.clickAddToCart();
    }

    @And("I immediately add {string} {string} {string}")
    public void quickly_add_second(String type, String brand, String storage) {
        cartPage.configureDevice(type, brand, storage, 1, "express", "1yr", "SAVE10");
        cartPage.clickAddToCart();
    }

    @Then("the cart should retain distinct selections for both devices")
    public void distinct_selections_remain(io.cucumber.datatable.DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        String firstStorage = rows.get(0).get("firstStorage");
        String secondStorage = rows.get(0).get("secondStorage");
        cartPage.assertSelectionsUnchanged(firstStorage, secondStorage);
    }
}
