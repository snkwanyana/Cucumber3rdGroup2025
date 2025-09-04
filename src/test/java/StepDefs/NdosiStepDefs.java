package StepDefs;

import io.cucumber.java.Before;
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

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }


    @Given("The user is on the Ndosi login page")
    public void the_user_is_on_the_ndosi_login_page() {
        driver.get("https://gray-island-0bd788c1e.2.azurestaticapps.net/#overview");
        driver.manage().window().maximize();

    }

    @When("The user navigates to Learning Materials page")
    public void the_user_navigates_to_learning_materials_page() {
        driver.findElement(By.xpath("//button[contains(.,'Learning Materials')]")).click();

    }

    @And("The user clicks on Sign Up Here link")
    public void the_user_clicks_on_sign_up_here_link() {
        driver.findElement(By.xpath("//button[contains(.,'Sign Up Here')]")).click();

    }

    @Then("The user is redirected to the Sign Up page")
    public void the_user_should_be_redirected_to_the_sign_up_page() {
        String actualElement = driver.findElement(By.xpath("//button[contains(.,'Create Account')]")).getText();
        Assert.assertEquals(actualElement, "Create Account");

    }

    @When("The user enters the firstname {string} , lastname {string}, email {string} , password {string} and confirmPassword {string}")
    public void the_user_enters_the_firstname_lastname_email_password_and_confirmPassword(String firstname, String lastname, String email, String password, String confirmPassword) {
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys(confirmPassword);

    }

    @And("The user clicks on the create account button")
    public void the_user_clicks_on_the_create_account_button() {
        driver.findElement(By.xpath("//button[contains(.,'Create Account')]")).click();

    }

    @Then("The pop up message \"Account created successfully\" is displayed")
    public void the_pop_up_message_account_created_successfully_is_displayed() {
        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),'Registration successful')]")).getText();
        Assert.assertEquals(actualMessage, "Registration successful");
        driver.findElement(By.xpath("//input[@value='']")).click();

    }
}