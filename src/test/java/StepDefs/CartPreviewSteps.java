package StepDefs;

import PageObjects.CartPreviewPage;
import Utils.Base;
import io.cucumber.java.en.*;

public class CartPreviewSteps extends Base {

    CartPreviewPage cartPreviewPage;

    public CartPreviewSteps() {
        this.cartPreviewPage = new CartPreviewPage(driver);
    }

    @Then("the cart preview should be visible")
    public void preview_should_be_visible() {
        cartPreviewPage.waitForPreviewVisible();
    }

    @Then("the cart preview should show {string}")
    public void preview_should_show_title(String expectedTitle) {
        cartPreviewPage.assertPreviewTitle(expectedTitle);
    }

    @When("I remove the preview item")
    public void remove_preview_item() {
        cartPreviewPage.removeFirstItem();
    }

    @Then("the cart preview should be hidden")
    public void preview_should_be_hidden() {
        cartPreviewPage.waitForPreviewHidden();
    }
}
