package stepdefs;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AlertElements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ScreenshotUtility;

import java.io.IOException;

public class CreateAlertStepDef {
    private AlertElements elements;
    private WebDriverWait wait;
    private AppUtilities apputils;
    private ConfigReader configReader;
    public String outboundDate;


    WebDriver driver = DriverFactory.getDriver();


    @Given("navigate to the application URL")
    public void navigate_to_the_application_url() throws Throwable {
        apputils = new AppUtilities(driver);
        configReader = new ConfigReader();
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
    }

    @Given("accept cookies")
    public void accept_cookies() {
    try{elements = new AlertElements(driver);
    elements.getAcceptCookies().click();}
    catch(WebDriverException e) {
        elements = new AlertElements(driver);
        elements.getAcceptCookies().click();
    }
    }
    @And("sign in with valid credentials")
    public void sign_in_with_valid_credentials() throws IOException {
        elements.getSignInLink().click();
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("email"));
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("pass"));
        elements.getSignInButton().click();
    }
    @When("search for a destination")
    public void search_for_a_destination() throws Throwable{
        apputils.waitForElement(elements.getWhereToField());

        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.click(elements.getWhereToField()).pause(1000).perform();
        action.pause(1000).sendKeys("nyc", Keys.ENTER).build().perform();
        elements.getSearchButton().click();
        try {
            apputils.waitForLoader();
        } catch (TimeoutException e) {

        }
    }
    @When("create a new alert with specified dates")
    public void create_a_new_alert_with_specified_dates() throws Throwable {
        elements.getCreateAlertButton().click();
        elements.getDepartStartDate().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getStartDate().click();
        elements.getEndDate().click();
        elements.getreturnStartDate().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getStartDate().click();
        elements.getEndDate().click();
        elements.getCreateAlertButtonPopup().click();
    }

    @Then("user should see the confirmation message")
    public void should_see_the_confirmation_message() {
        apputils.waitForElement(elements.getAlertmsg());
        String alertMsg = elements.getAlertmsg().getText();
        outboundDate = elements.getOutboundDate().getText();
        Assert.assertEquals(alertMsg,"Alert created!");
        elements.getCloseAlertPopup().click();
    }


    @When("navigate to the list of alerts")
    public void navigate_to_the_list_of_alerts() {
        elements.getAlertButton().click();
    }

    @When("edit an existing alert")
    public void edit_an_existing_alert() throws Throwable {
        elements.getEditAlertButton().click();
        Thread.sleep(2000);
        elements.getAddPassengersButton().click();
        elements.getSaveButton().click();

    }

    @When("delete an existing alert")
    public void delete_an_existing_alert() throws Throwable {
        elements.getEditAlertButton().click();
        elements.getDeleteButton().click();
        elements.getDeleteButton().click();

    }

    @Then("user should see the confirmation message for alert edited")
    public void should_see_the_confirmation_message_for_edit() {
        apputils.waitForElement(elements.getConfirmEditAlert());
        String alertMsg = elements.getConfirmEditAlert().getText();
        Assert.assertEquals(alertMsg,"Alerts updated successfully");

    }

    @Then("user should see the confirmation message for alert deleted")
    public void should_see_the_confirmation_message_for_alert_deleted() {
        apputils.waitForElement(elements.getAlertmsg());
        String alertMsg = elements.getAlertmsg().getText();
        Assert.assertEquals(alertMsg,"Alert has been deleted successfully");
    }

    @And("user should be able to logout successfully")
    public void should_be_able_to_logout_successfully() {
        apputils.waitForElement(elements.getAccountButton());
        elements.getAccountButton().click();
        elements.getLogoutButton().click();
    }

}

