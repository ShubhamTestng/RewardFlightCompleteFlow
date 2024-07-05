package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.FlightFinder.pages.MapPage;
import org.FlightFinder.pages.SignupPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.AppUtilities;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.IOException;


public class SignupStepDef {
    private SignupPage elements;
    private WebDriverWait wait;
    private AppUtilities apputils;
    private ConfigReader configReader;

    WebDriver driver = DriverFactory.getDriver();

    @Given("user navigates to the bronze signup URL and accepts cookies")
    public void user_navigates_to_the_bronze_sign_up_url_and_accepts_cookies() throws IOException {
        configReader = new ConfigReader();
        elements = new SignupPage(driver);
        try {driver.get(configReader.readFromPropertyFile("bronzeurl"));}
        catch(WebDriverException e) {}
        elements.getAcceptCookies().click();
        Assert.assertEquals(true,false);
    }

    @When("user enters a unique email address and clicks continue button")
    public void the_user_enters_a_unique_email_address_and_clicks_continue_button() {
        String email = "TestBronzeProd"+String.valueOf((int) (Math.random() * 9000) + 1000)+"@ymail.com";
        elements.getEmailTextField().sendKeys(email);
        elements.getContinueButton().click();

    }

    @When("user enters the password and then clicks set password button")
    public void the_user_enters_the_password_and_then_clicks_set_password_button() {
        elements.getPasswordTextField().sendKeys("Test@123");
        elements.getConfirmPasswordTextField().sendKeys("Test@123");
        elements.getSetPassword().click();

    }

    @When("user enters the first name and last name")
    public void the_user_enters_the_first_name_and_last_name() {
        elements.getFirstNameTextField().sendKeys("Prod");
        elements.getLastNameTextField().sendKeys("Bronze");

    }

    @When("user clicks the sign-up button")
    public void the_user_clicks_the_sign_up_button() {
        elements.getSignUpButton2().click();

    }

    @Then("successfull signup message should be displayed")
    public void the_successfull_signup_message_should_be_displayed() {
        System.out.println(elements.getConfirmSignUp().getText());
        String confirmationMessage = elements.getConfirmSignUp().getText();
        Assert.assertTrue(confirmationMessage.contains("Thank you for signing up and becoming a part of Reward Flight Finder.\n" +
                "Soon you will find your dream reward flights!"));

    }


}
