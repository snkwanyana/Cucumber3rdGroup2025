package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectDevicePage {


    @FindBy(id = "tab-btn-web")
    WebElement practiceTab_id;

    public static WebDriver driver;
    //WebDriver driver;

    @FindBy(id = "deviceType")
    WebElement devicetype_id;

    @FindBy(id = "brand")
    WebElement brand_id;

    @FindBy(xpath = "//*[@id='storage-128GB']")

    WebElement storage_128GB_id;

    @FindBy(id ="address")
    WebElement addressField_id;

    public SelectDevicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickWebAutomationAdvance() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(practiceTab_id));
        practiceTab_id.click();
    }


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


    public void clickStorage() {
           WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement storageOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='storage-128GB']")));
            storageOption.click();

        }

        public void selectColor(String color) {
            WebElement colorElement = driver.findElement(By.id("color"));
            Select colorDropdown = new Select(colorElement);
            colorDropdown.selectByVisibleText(color);
        }

//        public void inputquality(String quality) {
//
//        }

    public  void enterDeliveryemailadd(String emailadd) {
        addressField_id.clear();
        addressField_id.sendKeys(emailadd.trim());


    }

    public  void clickNextButton() {
        WebElement nextButton = driver.findElement(By.id("inventory-next-btn"));
        nextButton.click();

    }
    }
