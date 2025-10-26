package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart {
    private WebDriver driver;

    // Cart summary and buttons
    @FindBy(id = "review-cart-btn")
    WebElement reviewCartBtn;

    @FindBy(id = "confirm-cart-btn")
    WebElement placeOrderBtn;

    @FindBy(id = "cancel-cart-btn")
    WebElement cancelCartBtn;

    // Info box and cart summary
    @FindBy(id = "cart-confirm-panel")
    WebElement cartConfirmPanel;

    @FindBy(id = "cart-grand-total-value")
    WebElement cartGrandTotalValue;

    // Success toast and popup
    @FindBy(id = "purchase-success-toast")
    WebElement purchaseSuccessToast;

    @FindBy(css = "#purchase-success-toast button[title='Dismiss notification']")
    WebElement purchaseSuccessDismissBtn;

    @FindBy(id = "view-history-btn")
    WebElement viewHistoryBtn;

    // Personalized message (e.g., Amy, your order was purchased successfully!)
    @FindBy(css = "#purchase-success-toast p[style*='font-weight: 700']")
    WebElement purchaseSuccessMessage;

    // Order details (e.g., Cart (1 items): ...)
    @FindBy(css = "#purchase-success-toast div > p strong")
    WebElement orderDetailsLabel;

    @FindBy(xpath = "//*[@id='purchase-success-toast']//p[contains(.,'Order Details:')]")
    WebElement orderDetailsText;

    // Total (e.g., Total: R400.00)
    @FindBy(css = "#purchase-success-toast p[style*='font-size: 0.8rem']")
    WebElement purchaseSuccessTotal;

    // Methods for cart actions
    public void clickReviewCart() {
        reviewCartBtn.click();
    }

    public void clickPlaceOrder() {
        placeOrderBtn.click();
    }

    public void clickCancelCart() {
        cancelCartBtn.click();
    }

    public boolean isCartConfirmPanelVisible() {
        return cartConfirmPanel.isDisplayed();
    }

    public boolean isPlaceOrderBtnVisible() {
        return placeOrderBtn.isDisplayed();
    }

    public boolean isCancelCartBtnVisible() {
        return cancelCartBtn.isDisplayed();
    }

    public boolean isReviewCartBtnVisible() {
        return reviewCartBtn.isDisplayed();
    }

    public boolean isSuccessToastVisible() {
        return purchaseSuccessToast.isDisplayed();
    }

    public String getSuccessMessage() {
        return purchaseSuccessMessage.getText();
    }

    public String getOrderDetails() {
        // Wait for the order details to be present (max 5 seconds)
        try {
            new WebDriverWait(driver, java.time.Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(orderDetailsText));
            return orderDetailsText.getText();
        } catch (Exception e) {
            // Print all <p> elements under the toast for debugging
            try {
                WebElement toast = driver.findElement(By.id("purchase-success-toast"));
                java.util.List<WebElement> ps = toast.findElements(By.tagName("p"));
                System.out.println("[DEBUG] All <p> in Toast:");
                for (WebElement p : ps) {
                    System.out.println("[DEBUG] <p>: " + p.getText());
                }
                System.out.println("[DEBUG] Toast HTML: " + toast.getAttribute("outerHTML"));
            } catch (Exception ignored) {}
            return "";
        }
    }

    public String getSuccessTotal() {
        return purchaseSuccessTotal.getText();
    }

    public void dismissSuccessToast() {
        purchaseSuccessDismissBtn.click();
    }

    public void clickViewHistory() {
        viewHistoryBtn.click();
    }

    public boolean isViewHistoryBtnVisible() {
        return viewHistoryBtn.isDisplayed();
    }

    // Extract user name from the personalized message (e.g., "Amy, your order was purchased successfully!")
    public String getSuccessUserName() {
        String msg = getSuccessMessage();
        int commaIdx = msg.indexOf(",");
        if (commaIdx > 0) {
            return msg.substring(0, commaIdx).trim();
        }
        return "";
    }

    // Extract items from the order details (e.g., "Cart (1 items): 1x samsung phone 64GB")
    public String getSuccessItems() {
        String details = getOrderDetails();
        int colonIdx = details.indexOf(":");
        if (colonIdx >= 0 && colonIdx + 1 < details.length()) {
            return details.substring(colonIdx + 1).trim();
        }
        return details.trim();
    }

    public void waitForPlaceOrderBtnVisible(org.openqa.selenium.WebDriver driver, int timeoutSeconds) {
        new WebDriverWait(driver, java.time.Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.visibilityOf(placeOrderBtn));
    }

    public String getSuccessTimestamp() {
        try {
            WebElement timestamp = driver.findElement(By.xpath("//p[@style='font-size: 0.65rem; opacity: 0.75; margin: 0px;']"));
            return timestamp.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public Cart(WebDriver driver) {
        this.driver = driver;
        // Optionally initialize page factory if you use it
        // PageFactory.initElements(driver, this);
    }
}
