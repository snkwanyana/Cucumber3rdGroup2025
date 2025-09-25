package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddExtrasPage {

    WebDriver driver;
    public AddExtrasPage(WebDriver driver) {this.driver = driver;}


//    @FindBy(id = "inventory-title")
//    WebElement extrasTitle_id;

    @FindBy(id = "shipping-option-express")
    WebElement expressShipping_id;

    @FindBy(id = "warranty-option-2yr")
    WebElement warranty2Years_id;

    @FindBy(id ="discount-code")
    WebElement discountCode_id;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscount_id;

//
//    public void verifyinventorytitleIsDisplayed() {
//
//        extrasTitle_id.isDisplayed();
//    }


    public void selectExpressShipping() {
        expressShipping_id.click();
    }


    public void  select2YearWarranty() {
        warranty2Years_id.click();
    }

    public void enterDiscountCode(String discountcode) {
        discountCode_id.clear();
        discountCode_id.sendKeys(discountcode.trim());
    }

    public void reenterDiscountCode(String discountscode) {
        discountCode_id.clear();
        discountCode_id.sendKeys(discountscode.trim());
    }


    public  void clickApplyButton() {
        applyDiscount_id.click();
    }

    public  void Verifiesdiscount() {
               // Extract values from the page
         double basePrice = Double.parseDouble(driver.findElement(By.id("base-price-value")).getText().replace("R", "").replace(",", ""));
         int quantity = Integer.parseInt(driver.findElement(By.id("breakdown-quantity-value")).getText().replace("Qty:", "").trim());
         double subtotalDisplayed = Double.parseDouble(driver.findElement(By.id("breakdown-subtotal-value")).getText().replace("R", "").replace(",", ""));
         double warranty = Double.parseDouble(driver.findElement(By.id("breakdown-warranty-value")).getText().replace("R", "").replace(",", ""));
         double shipping = Double.parseDouble(driver.findElement(By.id("breakdown-shipping-value")).getText().replace("R", "").replace(",", ""));
         double discount = Double.parseDouble(driver.findElement(By.id("breakdown-discount-value")).getText().replace("R", "").replace(",", "").replace("-", ""));
         double totalDisplayed = Double.parseDouble(driver.findElement(By.id("breakdown-total-value")).getText().replace("R", "").replace(",", ""));

         // Calculate expected values
         double expectedSubtotal = basePrice * quantity;
         double expectedTotal = expectedSubtotal + warranty + shipping - discount;

         // Round to 2 decimal places
         expectedSubtotal = Math.round(expectedSubtotal * 100.0) / 100.0;
         expectedTotal = Math.round(expectedTotal * 100.0) / 100.0;

         // Print values for debugging
         System.out.println("Base Price: R" + basePrice);
         System.out.println("Quantity: " + quantity);
         System.out.println("Expected Subtotal: R" + expectedSubtotal);
         System.out.println("Displayed Subtotal: R" + subtotalDisplayed);
         System.out.println("Warranty: R" + warranty);
         System.out.println("Shipping: R" + shipping);
         System.out.println("Discount: R" + discount);
         System.out.println("Expected Total: R" + expectedTotal);
         System.out.println("Displayed Total: R" + totalDisplayed);

         // Assertions
         org.junit.Assert.assertEquals("❌ Subtotal mismatch!", expectedSubtotal, subtotalDisplayed, 0.01);
         org.junit.Assert.assertEquals("❌ Total mismatch!", expectedTotal, totalDisplayed, 0.01);
         System.out.println("✅ Pricing breakdown is correct");
     }


    }







