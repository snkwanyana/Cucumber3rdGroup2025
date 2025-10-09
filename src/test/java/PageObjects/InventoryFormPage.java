package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class InventoryFormPage {
    WebDriver driver;
    public InventoryFormPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath="//span[contains(@class, 'tab-label') and contains(text(), 'Web Automation Advance')]")
    WebElement webAutomationAdvanceTab_xpath;

    @FindBy(xpath="//input[contains(@type, 'radio') and contains(@value, 'standard') and contains(@name, 'shippingMethod')]")
    WebElement standardRadioButton_xpath;

    @FindBy(xpath="//input[contains(@type, 'radio') and contains(@value, 'express') and contains(@name, 'shippingMethod')]")
    WebElement expressRadioButton_xpath;

    @FindBy(xpath="//input[contains(@type, 'radio') and contains(@value, 'none') and contains(@name, 'warranty')]")
    WebElement warrantyNoneRadioButton_xpath;

    @FindBy(xpath="//input[contains(@type, 'radio') and contains(@value, '1yr') and contains(@name, 'warranty')]")
    WebElement warrantyOneYearRadioButton_xpath;

    @FindBy(xpath="//input[contains(@type, 'radio') and contains(@value, '2yr') and contains(@name, 'warranty')]")
    WebElement warrantyTwoYearsRadioButton_xpath;

    @FindBy(xpath = "//button[contains(@title, 'View Invoice History') and contains(text(), 'View Invoice')]")
    WebElement viewInvoiceButtonOnPopUp_xpath;

    @FindBy(xpath="//button[contains(text(), 'View') and contains(@style, 'linear-gradient')]")
    WebElement viewButtonInsidePopUp_xpath;

    @FindBy(xpath="//button[contains(text(), '✕') and contains(@style, 'font-size: 24px')]")
    WebElement closeModalButton_xpath;

    @FindBy(id = "deviceType")
    WebElement deviceTypeDdl_id;

    @FindBy(id="brand")
    WebElement brandDdl_id;

    @FindBy(id ="color")
    WebElement colorDdl_id;

    @FindBy(id ="storage-64GB")
    WebElement storage64GbRdn_id;

    @FindBy(id ="storage-128GB")
    WebElement storage128GbRdn_id;

    @FindBy(id ="storage-256GB")
    WebElement storage256GbRdn_id;

    @FindBy(id="quantity")
    WebElement quantityField_id;

    @FindBy(id = "address")
    WebElement addressField_id;


    @FindBy(id="inventory-next-btn")
    WebElement inventoryNextButton_id;

    @FindBy(id="discount-code")
    WebElement discountCodeField_id;

    @FindBy(id="apply-discount-btn")
    WebElement applyDiscountButton_id;

    @FindBy(id="review-cart-btn")
    WebElement reviewCartButton_id;

    @FindBy(id="purchase-device-btn")
    WebElement confirmPurchaseButton_id;

    @FindBy(id="logout-button")
    WebElement logoutButton_id;

    @FindBy(id="confirm-cart-btn")
    WebElement confirmCartButton_id;

    @FindBy(id="add-to-cart-btn")
    WebElement addToCartButton_id;

    @FindBy(id="discount-feedback")
    WebElement discountFeedbackText_id;


    public void clickToWebAutomationAdvance(){
        webAutomationAdvanceTab_xpath.click();
    }

    public void selectDeviceType(String deviceType){
        WebElement dropdown = driver.findElement(By.id("deviceType"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(deviceType);
    }

    public void selectDeviceBrand(String brand){
        WebElement dropdown = driver.findElement(By.id("brand"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(brand);
    }

    public void selectDeviceColor(String color){
        WebElement dropdown = driver.findElement(By.id("color"));
        Select select = new Select(dropdown);
        select.selectByVisibleText(color);
    }

    public void selectDeviceStorage(String storageSize) {
        switch (storageSize) {
            case "64GB":
                storage64GbRdn_id.click();
                break;
            case "128GB":
                storage128GbRdn_id.click();
                break;
            case "256GB":
                storage256GbRdn_id.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported storage size: " + storageSize);
        }
    }

    public void enterQuantity(String quantity){
        quantityField_id.clear();
        quantityField_id.sendKeys(quantity);

    }

    public void enterAddress(String address){
        addressField_id.sendKeys(address);
    }

    public void clickNextButton(){

        inventoryNextButton_id.click();
    }


    public void clickShippingMethod(String shipping){
        switch (shipping){
            case "Standard":
                standardRadioButton_xpath.click();
                break;
            case "Express (+25)":
                expressRadioButton_xpath.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported shipping method: " + shipping);
        }

    }

    public void clickWarranty(String warranty){
        switch (warranty){
            case "None":
                warrantyNoneRadioButton_xpath.click();
                break;
            case "1 Year":
                warrantyOneYearRadioButton_xpath.click();
                break;
            case "2 Year":
                warrantyTwoYearsRadioButton_xpath.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported warranty: " + warranty);
        }
    }

    public void enterDiscountCode(String code){
        discountCodeField_id.sendKeys(code);
    }

    public void clickApplyDiscountButton()  {
        applyDiscountButton_id.click();

        // Wait until any non-empty message appears
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> !discountFeedbackText_id.getText().trim().isEmpty());

        // Read the displayed error or message
        String feedbackMessage = discountFeedbackText_id.getText().trim();

        // Handle known messages using switch
        switch (feedbackMessage.toLowerCase()) {
            case "Invalid code":
                System.out.println("Invalid code entered. Retrying...");
                discountCodeField_id.clear();
                applyDiscountButton_id.click();

                //wait.until(ExpectedConditions.textToBePresentInElement(discountFeedbackText_id, "Code SAVE10 applied: -10%"));

                break;

            case "Code SAVE10 applied: -10%":
                System.out.println("Code SAVE10 applied: -10%");
                break;

            case "Code SAVE20 applied: -20%":
                System.out.println("Code SAVE10 applied: -20%");
                break;

            default:
                System.out.println("Unhandled message: \"" + feedbackMessage + "\"");
                break;
        }

    }

    public void clickConfirmPurchaseButton(){
        List<WebElement> spanElements = driver.findElements(By.xpath("//div[contains(@style, 'grid-template-columns')]/span"));

        double basePrice = 0.0;
        int quantity = 0;
        double warranty = 0.0;
        double shipping = 0.0;
        double discount = 0.0;
        double displayedTotal = 0.0;

        for (int i = 0; i < spanElements.size(); i++) {
            String label = spanElements.get(i).getText();

            switch (label) {
                case "Base Price (each)":
                    basePrice = Double.parseDouble(spanElements.get(i + 1).getText().replace("R", "").trim());
                    break;
                case "Quantity":
                    quantity = Integer.parseInt(spanElements.get(i + 1).getText().trim());
                    break;
                case "Warranty":
                    warranty = Double.parseDouble(spanElements.get(i + 1).getText().replace("R", "").trim());
                    break;
                case "Shipping":
                    shipping = Double.parseDouble(spanElements.get(i + 1).getText().replace("R", "").trim());
                    break;
                case "Discount (10%)":
                case "Discount":
                    String discountText = spanElements.get(i + 1).getText().replace("R", "").replace("-", "").trim();
                    discount = Double.parseDouble(discountText);
                    break;
                case "Total":
                    displayedTotal = Double.parseDouble(spanElements.get(i + 1).getText().replace("R", "").trim());
                    break;
            }
        }

        // Calculate expected total
        double subtotal = basePrice * quantity;
        double expectedTotal = subtotal + warranty + shipping - discount;

        // Assertion
        Assert.assertEquals(expectedTotal, displayedTotal, 0.01);


        System.out.println("Total is correct: R" + expectedTotal);



        confirmPurchaseButton_id.click();
    }

    public void clickViewInvoicePopUp(){
        viewInvoiceButtonOnPopUp_xpath.click();
    }

    public void clickViewButtonInsidePop(){
        viewButtonInsidePopUp_xpath.click();
    }

    public void closeInvoiceBrowser(){

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(windowHandles);

        // Switch to the tab you want to close (e.g., second tab)
        driver.switchTo().window(tabs.get(1));

        // Close the tab
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(tabs.get(0));

    }

    public void clickCloseModalPopUp(){
        closeModalButton_xpath.click();
    }

    public void clickLogoutButton(){
        logoutButton_id.click();
    }


    public boolean isLogoutButtonDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement logoutButton = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("logout-button"))
            );
            return logoutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void verifyCartItemCount(int expectedCount) {
        WebElement cartHeader = driver.findElement(By.id("cart-title"));
        String cartText = cartHeader.getText();

        // Extract the number from the text
        int actualCount = Integer.parseInt(cartText.replaceAll("[^0-9]", ""));

        Assert.assertEquals(expectedCount, actualCount);
    }


    public void verifyCartTotal(double expectedTotal) {
        // Locate the element that displays the total price
        WebElement totalElement = driver.findElement(By.id("cart-grand-total-value")); // Replace with actual locator

        // Extract the text and parse the number
        String totalText = totalElement.getText();
        double actualTotal = Double.parseDouble(totalText.replaceAll("[^\\d.]", ""));

        // Compare actual vs expected
        Assert.assertEquals( expectedTotal, actualTotal, 0.01);
    }



    public void clickAddToCartButton(){
        addToCartButton_id.click();
    }

    public void clickReviewCartButton(){
        reviewCartButton_id.click();
    }

    public void clickPlaceOrder(){
        confirmCartButton_id.click();
    }

    public void teardown(){
        driver.quit();
    }

}
