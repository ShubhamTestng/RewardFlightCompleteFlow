package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AlertElements;
import org.FlightFinder.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ApplicationHooks;
import utilities.ConfigReader;
import utilities.DriverFactory;
import java.io.IOException;
import java.time.Duration;

public class LoginStepDef {
    public LoginPage elements;
    public ConfigReader configReader;
    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2));


    @Given("user is on login page")
    public void user_is_on_login_page() throws Throwable {
        elements = new LoginPage(driver);
        configReader = new ConfigReader();
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
        try{
            elements.getAcceptCookies().click();}
        catch(WebDriverException e) {
            elements.getAcceptCookies().click();
        }
        elements.getSignInLink().click();
    }

    @When("user enters username")
    public void user_enters_username() throws IOException {
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("email"));
    }
    @And("user enters password")
    public void user_enters_password() throws IOException {
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("pass"));
    }

    @When("user enters invalid password")
    public void user_enters_invalid_password() {
        elements.getPasswordTextField().sendKeys("Password123");
    }

    @Then("user should get an error message")
    public void user_should_get_an_error() {
        String errorMsg = elements.getErrorMsg().getText();
        org.testng.Assert.assertEquals(errorMsg, "Invalid email or password.");
    }

    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        elements.getSignInButton().click();

    }

    @Then("verify the page title")
    public void page_title_should_be() {

        String title = "Easily Find Reward Flight Availability: Redeem British Airways Avios Points";
        wait.until(ExpectedConditions.titleIs(title));
        Assert.assertEquals(title,driver.getTitle());
    }

    @And("user clicks on account button")
    public void user_clicks_on_account_button() {
        elements.getAccountButton().click();
    }

    @Then("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        elements.getLogoutButton().click();
    }

}
