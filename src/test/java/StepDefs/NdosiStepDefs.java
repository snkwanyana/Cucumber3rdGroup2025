package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NdosiStepDefs {

    WebDriver driver;

    @Given("The user is on the Ndosi login page")
    public void the_user_is_on_the_ndosi_login_page() {
        // Initialize WebDriver and navigate to Ndosi login page
        driver = new ChromeDriver();
        driver.get("https://gray-island-0bd788c1e.2.azurestaticapps.net/#overview ");
        driver.manage().window().maximize();
    }

    @When("The user navigates to Learning Materials page")
    public void the_user_navigates_to_learning_materials_page() {
        // Code to navigate to Learning Materials page
        driver.findElement(By.xpath("//button[contains(.,'Learning Materials')]")).click();
        //xpath=//button[contains(.,'Learning Materials')]
    }

    @And("The user clicks on Sign Up Here link")
    public void the_user_clicks_on_sign_up_here_link() {
        // Code to click on Sign Up Here link
        driver.findElement(By.xpath("//button[contains(.,'Sign Up Here')]")).click();
        //xpath=//button[contains(.,'Sign Up Here')]
    }

    @Then("The user is redirected to the Sign Up page")
    public void the_user_should_be_redirected_to_the_sign_up_page() {
        // Code to verify redirection to Sign Up page
        String actualElement = driver.findElement(By.xpath("//button[contains(.,'Create Account')]")).getText();
        //xpath=//button[contains(.,'Create Account')]
        Assert.assertEquals(actualElement, "Create Account");
    }

    @When("The user enters the firstname \"{string}\" , lastname \"{string}\", email \"{string}\" , password \"{string}\" and confirmPassword \"{string}\"")
    public void the_user_enters_the_firstname_lastname_email_password_and_confirmPassword(String firstname, String lastname, String email, String password, String confirmPassword) {
        // Code to enter user details
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
        //xpath=//input[@value='Lebo']
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(confirmPassword);
    }
    }