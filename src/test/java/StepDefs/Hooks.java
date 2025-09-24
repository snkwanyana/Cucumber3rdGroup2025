package StepDefs;

import Utils.ScenarioContext;
import io.cucumber.java.Before;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
//import utils.ScenarioContext;

public class Hooks {

    WebDriver driver; // Make sure this is initialized
    LoginPage loginPage;
    //loginPage = new LoginPage(BaseClass.getDriver());
    ScenarioContext ScenarioContext = new ScenarioContext();

    @Before("@AddExtras")
    public void loginBeforeExtras() {
        loginPage = new LoginPage(driver);
        loginPage.login(ScenarioContext.emailadd, ScenarioContext.password);
    }
}
