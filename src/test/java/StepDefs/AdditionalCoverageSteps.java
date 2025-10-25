//package StepDefs;
//
//import PageObjects.AdditionalCoveragePage;
//
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//
//public class AdditionalCoverageSteps {
//
//    AdditionalCoveragePage page;
//
//    // ===== Device & Brand =====
//    @Given("I pick device {string} and brand {string}")
//    public void iPickDeviceAndBrand(String device, String brand) {
//        page.selectDevice(device);
//        page.selectBrand(brand);
//    }
//
//    @When("I switch to device {string}")
//    public void iSwitchToDevice(String newDevice) {
//        page.selectDevice(newDevice);
//    }
//
//    @Then("brand should reset and dropdown disabled")
//    public void brandShouldResetAndDropdownDisabled() {
//        Assert.assertFalse(page.isBrandEnabled(), "❌ Brand field not disabled!");
//    }
//
//    // ===== Preview Image =====
//    @Then("correct preview image should display for brand {string}")
//    public void correctPreviewImageForBrand(String brand) {
//        page.verifyDevicePreviewDisplayed();
//    }
//
//    // ===== Discount Handling =====
//    @Given("I apply discount {string}")
//    public void iApplyDiscount(String code) {
//        page.applyDiscount(code);
//    }
//
//    @When("I clear the discount field and apply")
//    public void iClearDiscountFieldAndApply() {
//        page.removeDiscount();
//    }
//
//    @Then("discount message disappears")
//    public void discountMessageDisappears() {
//        page.verifyDiscountRemoved();
//    }
//
//    // ===== Higher Discount =====
//    @Then("verify SAVE20 discount equals {double}")
//    public void verifySave20Discount(double expected) {
//        double subtotal = page.getSubtotal();
//        Assert.assertEquals(subtotal, expected, 0.01, "❌ SAVE20 discount mismatch!");
//    }
//
//    // ===== Color Persistence =====
//    @When("I change color to {string}")
//    public void iChangeColorTo(String color) {
//        page.selectColor(color);
//    }
//
//    @And("I add item to cart")
//    public void iAddItemToCart() {
//        page.confirmPurchase();
//    }
//
//    @Then("I change color to {string}")
//    public void iChangeColorBackTo(String expectedColor) {
//        page.verifyColorDefault(expectedColor);
//    }
//
//    // ===== Confirm Purchase =====
//    @When("I confirm purchase")
//    public void iConfirmPurchase() {
//        page.confirmPurchase();
//    }
//
//    @Then("toast should include {string}")
//    public void toastShouldInclude(String text) {
//        Assert.assertTrue(page.isSuccessToastVisible(), "❌ Success toast missing!");
//    }
//
//    // ===== Cart Quantity Editing =====
//    @When("I set quantity to {string}")
//    public void iSetQuantityTo(String qty) {
//        page.setQuantity(Integer.parseInt(qty));
//    }
//}
