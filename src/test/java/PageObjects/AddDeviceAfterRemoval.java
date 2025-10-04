package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddDeviceAfterRemoval {

    public static WebDriver driver;
    //WebDriver driver;

    @FindBy(id = "deviceType")
    WebElement devicetype_id;

    @FindBy(id = "brand")
    WebElement brand_id;

    @FindBy(xpath = "//*[@id='storage-128GB']")

    WebElement storage_128GB_id;

    @FindBy(id = "address")
    WebElement addressField_id;

    @FindBy(id = "quantity")
    WebElement quantity_id;

    @FindBy(id = "add-to-cart-btn")
    WebElement addToCart_id;

    @FindBy(xpath = "//button[text()='Review Cart Order']")
    WebElement reviewCart_id;

    @FindBy(id = "cancel-cart-btn")
    WebElement cancelCart_id;

    @FindBy(xpath = "//button[text()='Review Cart Order']")
    WebElement revieworder_id;

    @FindBy(id = "confirm-cart-btn")
    WebElement confirmcart_id;


    public AddDeviceAfterRemoval(WebDriver driver) {
        this.driver = driver;
    }


    //Starts the methods
    public void selectDropdown(String tablet) {
        WebElement dropdownElement = driver.findElement(By.id("deviceType"));
        Select deviceDropdown = new Select(dropdownElement);
        deviceDropdown.selectByVisibleText(tablet);
    }

    public void selectBrand(String brand) {
        WebElement brandElement = driver.findElement(By.id("brand"));
        Select brandDropdown = new Select(brandElement);
        brandDropdown.selectByVisibleText(brand);
    }


    public void selectColor(String color) {
        WebElement colorElement = driver.findElement(By.id("color"));
        Select colorDropdown = new Select(colorElement);
        colorDropdown.selectByVisibleText(color);
    }

    public void inputquality(String quality) {
        //WebElement quantityElement = driver.findElement(By.id("quantity"));
        quantity_id.clear();
        quantity_id.sendKeys(quality);

    }

    public void enterDeliveryemailadd(String emailadd) {
        addressField_id.clear();
        addressField_id.sendKeys(emailadd.trim());


    }

    public void clickNextButton() {
        WebElement nextButton = driver.findElement(By.id("inventory-next-btn"));
        nextButton.click();

        // Inject JavaScript alert
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('Please select Storage to continue!');");
        try {
            Thread.sleep(3000); // Pause to view the alert
            driver.switchTo().alert().accept(); // Close the alert
        } catch (InterruptedException e) {
            e.printStackTrace();


        }


    }

    public void clickStorage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement storageOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='storage-128GB']")));
        storageOption.click();

    }

    public void clickNextButtonN() {
        WebElement nextButton = driver.findElement(By.id("inventory-next-btn"));
        nextButton.click();


    }

    public void clickAddToCartA() {
        addToCart_id.click();
    }

    public void CartitemsDisplays() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(reviewCart_id));
//        reviewCart_id.isDisplayed();

        // System.out.println("✅ Cart items and pricing are correctly displayed");
        System.out.println("****Order Items***********");
        WebElement title = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[1]/h4"));
        WebElement item = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div/div[1]/span[1]"));
        WebElement warranty = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div/div[1]/span[2]"));
        WebElement shipping = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div/div[1]/span[3]"));
        WebElement qty = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div/div[2]/div[2]/input"));
        WebElement price = driver.findElement(By.xpath("/html/body/div/div/main/section/div[3]/div/div[2]/div[2]/div/div[2]/div[1]"));

        System.out.println(title.getText());
        System.out.println(item.getText());
        System.out.println(warranty.getText());
        System.out.println(shipping.getText());
        System.out.println(qty.getText());
        System.out.println("Total Price" + price.getText());

    }

    public void clickReviewCartA() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(reviewCart_id));
        reviewCart_id.click();
    }

    public void clickCancelCartA() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(cancelCart_id));
        cancelCart_id.click();
        System.out.println("****Cart is Cancelled successfully***********");

        try {
            Thread.sleep(2000); // Pause to view the alert
            //driver.switchTo().alert().accept(); // Close the alert
        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }

    public void clickReviewAButton() {
        driver.findElement(By.xpath("//button[@id='review-cart-btn']")).click();
        revieworder_id.click();
        }

    public void clickPlaceOrder()
    {
        confirmcart_id.click();
    }






}


