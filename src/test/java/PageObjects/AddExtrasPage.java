package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddExtrasPage {

    WebDriver driver;
    public AddExtrasPage(WebDriver driver) {this.driver = driver;}

    @FindBy(id = "shipping-option-express")
    WebElement expressShipping_id;

    @FindBy(id = "warranty-option-2yr")
    WebElement warranty2Years_id;

    @FindBy(id ="discount-code")
    WebElement discountCode_id;









}



