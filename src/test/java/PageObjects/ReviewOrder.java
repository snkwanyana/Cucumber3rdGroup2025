package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewOrder {

    WebDriver driver;

    public ReviewOrder(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "cart-title")
    WebElement carttitle_id;

    @FindBy(xpath = "/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/button")
    WebElement remove_item;

    public void verify_cart_items_and_pricing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Samsung Tablet
        WebElement samsungItem = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[1]"));
        WebElement samsungQty = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[2]"));
        WebElement samsungWarranty = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[3]"));
        WebElement samsungShipping = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[4]"));
        WebElement samsungDiscount = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[1]/span[4]"));
        WebElement samsungPrice = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]"));

        // MacBook Pro
        WebElement macbookItem = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[2]/div[1]/span[1]"));
        WebElement macbookQty = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[2]/input"));
        WebElement macbookWarranty = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[2]/div[1]/span[2]"));
        WebElement macbookShipping = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[2]/div[1]/span[3]"));
        WebElement macbookPrice = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]"));

        // Assertions
        org.junit.Assert.assertTrue("❌ Samsung tablet not displayed", samsungItem.isDisplayed());
        org.junit.Assert.assertTrue("❌ Samsung quantity mismatch", samsungQty.isDisplayed());
        org.junit.Assert.assertTrue("❌ Samsung warranty missing", samsungWarranty.isDisplayed());
        org.junit.Assert.assertTrue("❌ Samsung shipping missing", samsungShipping.isDisplayed());
        org.junit.Assert.assertTrue("❌ Samsung discount missing", samsungDiscount.isDisplayed());
        org.junit.Assert.assertTrue("❌ Samsung price mismatch", samsungPrice.isDisplayed());

        org.junit.Assert.assertTrue("❌ MacBook not displayed", macbookItem.isDisplayed());
        org.junit.Assert.assertTrue("❌ MacBook quantity mismatch", macbookQty.isDisplayed());
        org.junit.Assert.assertTrue("❌ MacBook warranty missing", macbookWarranty.isDisplayed());
        org.junit.Assert.assertTrue("❌ MacBook shipping missing", macbookShipping.isDisplayed());
        org.junit.Assert.assertTrue("❌ MacBook price mismatch", macbookPrice.isDisplayed());

        System.out.println("✅ Cart items and pricing are correctly displayed");
        System.out.println("****Here is the First Order Breakdown***********");
        System.out.println(samsungItem.getText());
        System.out.println(samsungQty.getText());
        System.out.println(samsungWarranty.getText());
        System.out.println(samsungDiscount.getText());
        System.out.println("Total Price" + samsungPrice.getText());
        System.out.println("*****Second Order Info*********");
        System.out.println(macbookItem.getText());
        System.out.println(macbookQty.getText());
        System.out.println(macbookWarranty.getText());
        System.out.println(macbookShipping.getText());
        System.out.println("Total Price:" + macbookPrice.getText());

    }

    public void clickremove_item_from_cart() {
        remove_item.click();
        System.out.println("Item removed from cart");
    }


    public void reconfirms_total_price() {
        WebElement totalPrice1 = null;
        WebElement totalPrice2 = null;

        try {
            totalPrice1 = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[1]/div[2]/div[1]"));
            totalPrice2 = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div[2]/div[2]/div[1]"));

            if (totalPrice1.isDisplayed()) {
                System.out.println("✅ First total price: " + totalPrice1.getText());
            }

            if (totalPrice2.isDisplayed()) {
                System.out.println("✅ Second total price: " + totalPrice2.getText());
            }

        } catch (NoSuchElementException e) {
            System.out.println("❌Item is not found or is being removed.");
            if (totalPrice1 != null) {
                System.out.println("✅Remaining Total After removing other order: " + totalPrice1.getText());
            }
            if (totalPrice2 != null) {
                System.out.println("✅ Remaining Total After removing other order: " + totalPrice2.getText());
            }
        }
    }

public  void click_Remove_remaining_item_from_the_cart() {
        try {
            WebElement remove_item = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div/button"));
            if (remove_item.isDisplayed()) {
                remove_item.click();
                System.out.println("✅ Remaining item removed from cart");
            }
        } catch (NoSuchElementException e) {
            System.out.println("❌ No remaining item to remove.");
        }
    }

}











