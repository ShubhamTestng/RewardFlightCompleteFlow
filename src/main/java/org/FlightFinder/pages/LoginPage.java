package org.FlightFinder.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    public static WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//button[text()='I agree']")
    WebElement acceptCookies;

    @FindBy(xpath="//button[text()='Sign In']")
    WebElement signInLink;

    @FindBy(xpath="//input[@name='email']")
    WebElement emailTextField;

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextField;

    @FindBy(xpath="//div[@class='column']/button[text()='Sign In']")
    WebElement signInButton;

    @FindBy(xpath="(//div[@role='listbox'])[2]")
    WebElement accountButton;

    @FindBy(xpath="//span[text()='Logout']")
    WebElement logoutButton;

    @FindBy(xpath="//span[@class='error-msg']")
    WebElement errorMsg;

    public WebElement getAcceptCookies() {
        return acceptCookies;
    }

    public WebElement getSignInLink() {

        return signInLink;
    }

    public WebElement getEmailTextField() {

        return emailTextField;
    }

    public WebElement getPasswordTextField() {

        return passwordTextField;
    }

    public WebElement getSignInButton() {

        return signInButton;
    }

    public WebElement getAccountButton() {

        return accountButton;
    }

    public WebElement getLogoutButton() {

        return logoutButton;
    }

    public WebElement getErrorMsg() {

        return errorMsg;
    }
}
