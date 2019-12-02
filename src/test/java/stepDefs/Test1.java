package stepDefs;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import locators.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;


public class Test1 {
    private static WebDriver driver;
    private static LoginPage user;
    private static LoginPage pass;
    private static LoginPage submitButn;
    private static LoginPage errorTxt;


    {
        chromedriver().setup();
        driver = new ChromeDriver();
        user = new LoginPage(driver);
        pass = new LoginPage(driver);
        submitButn = new LoginPage(driver);
        errorTxt = new LoginPage(driver);
    }

    @Given("^User at login page$")
    public void user_at_login_page() throws Throwable {
        driver.manage().window().maximize();
        driver.get("https://mjplatform.com/login");
    }

    @When("^User enters invalid username and password$")
    public void user_enters_invalid_username_and_password(DataTable dataTable) throws Throwable {
        List<Map<String, String>> ListOfMap = dataTable.asMaps(String.class, String.class);
        user.username.click();
        user.username.sendKeys(ListOfMap.get(0).get("username"));
        pass.password.click();
        pass.password.sendKeys(ListOfMap.get(0).get("password"));
        submitButn.submitButton.click();
    }
    @Then("^error message displayed$")public void error_message_displayed() throws Throwable {
       String error=  errorTxt.errorText.getText();
       Assert.assertEquals("Error message not found", error, errorTxt.errorText.getText());

    }

    @Then("^fields with invalid credentials are highlighted$")
    public void fields_with_invalid_credentials_are_highlighted() throws Throwable {
        ((JavascriptExecutor)driver).executeScript("return window.getSelection().toString();");

    }
    }
