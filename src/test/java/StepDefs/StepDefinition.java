package StepDefs;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefinition {

    WebDriver driver;

    @Given("The user is already on the login page")
    public void the_user_is_already_on_the_login_page() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

    }

    @When("The user enters the username {}")
    public void the_user_enters_the_username(String username) {
        driver.findElement(By.id("user-name")).sendKeys(username);
    }

    @And("The user enters the password {}")
    public void the_user_enters_the_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("The user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        String actualElement =  driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals(actualElement, "Products");

    }

}