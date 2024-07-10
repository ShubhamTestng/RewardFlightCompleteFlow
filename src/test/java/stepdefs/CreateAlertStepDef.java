package stepdefs;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AlertElements;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ScreenshotUtility;

import java.io.IOException;
import java.time.Duration;

public class CreateAlertStepDef {
    private AlertElements elements;
    private AppUtilities apputils;
    private ConfigReader configReader;
    public String outboundDate;


    WebDriver driver = DriverFactory.getDriver();
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

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

    @Given("sign in with Bronze user credentials")
    public void sign_in_with_bronze_user_credentials() throws IOException {
        elements.getSignInLink().click();
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("prodbronzeemail"));
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("prodbronzepass"));
        elements.getSignInButton().click();
    }

    @Given("sign in with Silver user credentials")
    public void sign_in_with_silver_user_credentials() throws IOException {
        elements.getSignInLink().click();
        elements.getEmailTextField().sendKeys(configReader.readFromPropertyFile("prodsilveremail"));
        elements.getPasswordTextField().sendKeys(configReader.readFromPropertyFile("prodsilverpass"));
        elements.getSignInButton().click();
    }

    @When("search for a destination")
    public void search_for_a_destination() throws Throwable{

        apputils.waitForElement(elements.getWhereToField());

        for(;;) {
               try {
                   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
                   if (elements.getSearchField().isDisplayed()) {
                       Actions action = new Actions(driver);
                       action.click(elements.getWhereToField()).pause(1000).perform();
                       action.pause(1000).sendKeys("nyc", Keys.ENTER).build().perform();
                       elements.getSearchButton().click();
                       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
                   }

               }
               catch(Exception e) {

                    break;
            }
            }

        try {
            apputils.waitForLoader();
        } catch (Exception e) {}

    }

    @When("clicks on No button on upgrade membership popup")
    public void clicks_on_no_button_on_upgrade_membership_popup() {
        try {
            elements.getBronzeUpgradePopup().click(); }
        catch (NoSuchElementException e) { }
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

    @When("create a new alert with more than twenty days range")
    public void create_a_new_alert_with_more_than_20_days_range() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,0)");
        elements.getCreateAlertButton().click();
        elements.getDepartStartDate().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getStartDateBronze().click();
        elements.getEndDateBronze().click();
        elements.getreturnStartDate().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getStartDateBronze().click();
        elements.getEndDateBronze().click();
    }

    @When("create a new alert with more than Forty five days range")
    public void create_a_new_alert_with_more_than_45_days_range() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollTo(0,0)");
        elements.getCreateAlertButton().click();
        elements.getDepartStartDate().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getStartDateSilver().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getEndDateSilver().click();
        elements.getreturnStartDate().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getStartDateSilver().click();
        elements.getNextMonth().click();
        Thread.sleep(500);
        elements.getEndDateSilver().click();
    }

    @Then("user should see the confirmation message")
    public void should_see_the_confirmation_message() {
        apputils.waitForElement(elements.getAlertmsg());
        String alertMsg = elements.getAlertmsg().getText();
        outboundDate = elements.getOutboundDate().getText();
        Assert.assertEquals(alertMsg,"Alert created!");
        elements.getCloseAlertPopup().click();
    }

    @Then("user should see the error message for 20 days maximum date range")
    public void user_should_see_the_error_message_for_20_days_maximum_date_range() {
        String errorText = "Maximum date range allowed is 20 days per leg for Bronze members";
        Assert.assertTrue(elements.getActiveAlertText().getText().contains(errorText));
        WebElement createAlertButton = driver.findElement(By.xpath("//div[@class='popup-footer']/button[text()='Create Alert']"));
        Assert.assertEquals(createAlertButton.isEnabled(),false);
        elements.getCloseButton2().click();
    }

    @Then("user should see the error message for 45 days maximum date range")
    public void user_should_see_the_error_message_for_45_days_maximum_date_range() {
        String errorText = "Maximum date range allowed is 45 days per leg for Silver members.";
        Assert.assertTrue(elements.getActiveAlertText().getText().contains(errorText));
        WebElement createAlertButton = driver.findElement(By.xpath("//div[@class='popup-footer']/button[text()='Create Alert']"));
        Assert.assertEquals(createAlertButton.isEnabled(),false);
        elements.getCloseButton2().click();
    }

    @When("navigate to the list of alerts")
    public void navigate_to_the_list_of_alerts() {
        for (int i = 0; i < 3; i++) {
            try {
                apputils.waitForElement(elements.getAlertButton());
                elements.getAlertButton().click();
                break;
            }
            catch (Exception e) {}
        }
    }

    @When("edit an existing alert")
    public void edit_an_existing_alert() throws Throwable {
        elements.getEditAlertButton().click();
        Thread.sleep(2000);

        for(;;) {
            String passengerCount = elements.getPassengerCount().getText();
            System.out.println(passengerCount);
            if (passengerCount.equals("1")) {
                elements.getAddPassengersButton().click();
            }
            else{break;}
        }

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
        try {
            apputils.waitForLoader();
        } catch (Exception e) {}
    }

    @And("user should be able to logout successfully")
    public void should_be_able_to_logout_successfully() {
        apputils.waitForElement(elements.getAccountButton());
        elements.getAccountButton().click();
        elements.getLogoutButton().click();
    }

}

