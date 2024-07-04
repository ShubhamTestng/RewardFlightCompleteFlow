package stepdefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.FlightFinder.pages.AlertElements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.IOException;

public class MembershipRestrictionStepDef {
    private AlertElements elements;
    private WebDriverWait wait;
    private AppUtilities apputils;
    private ConfigReader configReader;
    public String outboundDate;


    WebDriver driver = DriverFactory.getDriver();

    @Given("user navigates to the application URL")
    public void navigate_to_the_application_url() throws Throwable {
        apputils = new AppUtilities(driver);
        configReader = new ConfigReader();
        try{driver.get(configReader.readFromPropertyFile("url"));}
        catch (WebDriverException e) {}
    }

    @Given("accepts the cookies")
    public void accept_cookies() {

        try{elements = new AlertElements(driver);
            elements.getAcceptCookies().click();}
        catch(WebDriverException e) {
            elements = new AlertElements(driver);
            elements.getAcceptCookies().click();
        }
    }

    @Then("sign in with bronze user credentials")
    public void sign_in_with_bronze_user_credentials() throws InterruptedException, IOException {
        elements.getSignInLink().click();
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("prodbronzeemail"));
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("prodbronzepass"));
        elements.getSignInButton().click();
    }
    @Then("search for flights from nyc")
    public void search_for_flights_from_nyc() throws InterruptedException {
        apputils.waitForElement(elements.getWhereToField());
        elements.getWhereToField().click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        action.click(elements.getWhereToField()).pause(1000).perform();
        action.pause(500).sendKeys("nyc", Keys.ENTER).build().perform();
        elements.getSearchButton().click();
        apputils.waitForLoader();
    }
    @Then("click create alert button")
    public void click_create_alert_button() {
        elements.getCreateAlertButton().click();
    }
    @Then("select a date range exceeding {int} days per leg")
    public void select_a_date_range_exceeding_days_per_leg(Integer int1) {
        elements.getDepartStartDate().click();
        elements.getNextMonth().click();
        elements.getStartDateBronze().click();
        elements.getEndDateBronze().click();
        elements.getreturnStartDate().click();
        elements.getNextMonth().click();
        elements.getStartDateBronze().click();
        elements.getEndDateBronze().click();
    }
    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        String errorText = "Maximum date range allowed is 20 days per leg for Bronze members";
        Assert.assertTrue(elements.getActiveAlertText().getText().contains(errorText));

    }
    @Then("the create alert button should be disabled")
    public void the_create_alert_button_should_be_disabled() {
        WebElement createAlertButton = driver.findElement(By.xpath("//div[@class='popup-footer']/button[text()='Create Alert']"));
        Assert.assertEquals(createAlertButton.isEnabled(),false);
    }
    @Then("close the alert popup")
    public void close_the_alert_popup() {
        elements.getCloseButton2().click();

    }
    @Then("logout from the account")
    public void logout_from_the_account() {
        elements.getAccountButton().click();
        elements.getLogoutButton().click();
    }


}
