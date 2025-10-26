package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.List;

import static Utils.Base.driver;

public class PricingParnel {


    @FindBy(id = "add-to-cart-btn")
    WebElement addToCartButton;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue;


    public String getUnitPrice() {
        return unitPriceValue.getText();
    }
    public String getSubtotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(subtotalValue));
        return subtotalValue.getText();
    }


    //method to click add to cart button
    public void clickAddToCart() {
        addToCartButton.click();
    }


}
