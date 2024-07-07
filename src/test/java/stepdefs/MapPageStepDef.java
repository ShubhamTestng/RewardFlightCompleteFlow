package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.AlertElements;
import org.FlightFinder.pages.MapPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.AppUtilities;
import utilities.ConfigReader;
import utilities.DriverFactory;
import java.io.IOException;



public class MapPageStepDef {
    private MapPage elements;
    private WebDriverWait wait;
    private AppUtilities apputils;
    private ConfigReader configReader;

    WebDriver driver = DriverFactory.getDriver();

    @When("the user clicks the world map button")
    public void the_user_clicks_the_world_map_button() {
        apputils = new AppUtilities(driver);
        elements = new MapPage(driver);
        apputils.waitForElement(elements.getWorldMapButton());
        for (int i = 0; i < 3; i++) {
            try {elements.getWorldMapButton().click();
                break;}
            catch (Exception e) {}}

        try {
            apputils.waitForLoader();
        } catch (TimeoutException e) {

        }
    }
    @When("enters {string} in the where from field")
    public void enters_in_the_where_from_field(String string) throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(1000);
        action.click(elements.getWhereFromField()).pause(1000).sendKeys(string).pause(1000).sendKeys(Keys.ENTER).build().perform();

    }
    @When("the user selects the date range and click on search button")
    public void the_user_selects_the_date_range_and_click_on_search_button() {
        elements.getDateField().click();
        elements.getNextMonth().click();
        elements.getStartDate().click();
        elements.getEndDate().click();
        elements.getStartDate().click();
        elements.getEndDate().click();
        elements.getSetDatesButton().click();
        elements.getSearchButton().click();

    }

    @Then("the user should get popup for membership upgrade with membership button")
    public void the_user_should_get_popup_for_membership_upgrade_with_membership_button() {
        Assert.assertEquals(elements.getUpgradeMembershipPopup().getText(),"You need to be a Silver or Gold member to use the world map search");
        Assert.assertEquals(elements.getMembershipsButton().isDisplayed(),true);
    }

    @Then("on clicking membership button, user redirects to pricing page")
    public void on_clicking_membership_button_user_redirects_to_pricing_page() {
        elements.getMembershipsButton().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://rewardflightfinder.com/pricing");
    }

    @When("the user selects a random destination from the results")
    public void the_user_selects_a_random_destination_from_the_results() throws InterruptedException {

        int destinationNumber = java.util.concurrent.ThreadLocalRandom.current().nextInt(1, 101);
        elements.getSelectDestination(destinationNumber).click();
        Thread.sleep(5000);
    }
    @Then("the map should zoom in to the selected destination")
    public void the_map_should_zoom_in_to_the_selected_destination() {

    }

}
