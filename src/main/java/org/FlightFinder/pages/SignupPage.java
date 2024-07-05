package org.FlightFinder.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    public static WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[text()='I agree']")
    WebElement acceptCookies;

    public WebElement getAcceptCookies() {

        return acceptCookies;
    }


    @FindBy(xpath="//button[text()='Sign Up']")
    WebElement signUpButton;


    public WebElement getSignUpButton() {

        return signUpButton;
    }

    @FindBy(xpath="//button[@class='ui button btn btn-gray bronze']")
    WebElement bronzeSubscribeButton;


    public WebElement getBronzeSubscribeButton() {

        return bronzeSubscribeButton;
    }

    @FindBy(xpath="//button[contains(@class,'ui button btn btn-blue silver')]")
    WebElement silverSubscribeButton;

    public WebElement getSilverSubscribeButton() {

        return silverSubscribeButton;
    }

    @FindBy(xpath="//button[contains(@class,'ui button btn btn-orange gold')]")
    WebElement goldSubscribeButton;

    public WebElement getGoldSubscribeButton() {

        return goldSubscribeButton;
    }

    @FindBy(xpath="//input[@name='email']")
    WebElement emailTextField;


    public WebElement getEmailTextField() {

        return emailTextField;
    }

    @FindBy(xpath="//button[text()='Continue']")
    WebElement continueButton;


    public WebElement getContinueButton() {

        return continueButton;
    }

    @FindBy(xpath="//input[@name='password']")
    WebElement passwordTextField;


    public WebElement getPasswordTextField() {

        return passwordTextField;
    }

    @FindBy(xpath="//input[@name='confirmPassword']")
    WebElement confirmPasswordTextField;

    public WebElement getConfirmPasswordTextField() {

        return confirmPasswordTextField;
    }

    @FindBy(xpath="//button[text()='Set Password']")
    WebElement setPassword;


    public WebElement getSetPassword() {

        return setPassword;
    }

    @FindBy(xpath="//input[@name='firstName']")
    WebElement firstNameTextField;

    public WebElement getFirstNameTextField() {

        return firstNameTextField;
    }

    @FindBy(xpath="//input[@name='lastName']")
    WebElement lastNameTextField;

    public WebElement getLastNameTextField() {

        return lastNameTextField;
    }

    @FindBy(xpath="//button[text()='Sign up']")
    WebElement signUpButton2;

    public WebElement getSignUpButton2() {

        return signUpButton2;
    }

    @FindBy(xpath="//p[@class='thankyou-page__text']")
    WebElement confirmSignUp;


    public WebElement getConfirmSignUp() {

        return confirmSignUp;
    }

    @FindBy(xpath="//button[text()='Continue']")
    WebElement continueAfterSignUpButton;


    public WebElement getContinueAfterSignUpButton() {

        return continueAfterSignUpButton;
    }

    @FindBy(xpath="//*[@id=\"cb-body\"]/div/div[2]/div[2]/button")
    WebElement proceedToCheckoutButton;

    public WebElement getProceedToCheckoutButton() {

        return proceedToCheckoutButton;
    }

    @FindBy(xpath="//input[@id='first_name']")
    WebElement billingName;

    public WebElement getBillingName() {

        return billingName;
    }

    @FindBy(xpath="//input[@id='last_name']")
    WebElement billingLastName;

    public WebElement getBillingLastName() {

        return billingLastName;
    }

    @FindBy(xpath="//input[@id='zip']")
    WebElement zipCode;

    public WebElement getZipCode() {

        return zipCode;
    }

    @FindBy(xpath="//span[contains(text(),'Next')]")
    WebElement nextButton;

    public WebElement getNextButton() {

        return nextButton;
    }

    @FindBy(xpath="//input[@name='cc-number']")
    WebElement cardNumberTextField;

    public WebElement getCardNumberTextField() {

        return cardNumberTextField;
    }

    @FindBy(xpath="//iframe[@title='Checkout Page']")
    WebElement frameElement;

    public WebElement getFrameElement() {

        return frameElement;
    }

    @FindBy(xpath="//input[@id='exp_month']")
    WebElement expiryTextField;

    public WebElement getExpiryTextField() {

        return expiryTextField;
    }

    @FindBy(xpath="//input[@id='cvv']")
    WebElement cvvTextField;

    public WebElement getCvvTextField() {

        return cvvTextField;
    }

    @FindBy(xpath="//button[@class='cb-button cb-button__primary']")
    WebElement nextButton2;

    public WebElement getNextButton2() {

        return nextButton2;
    }

    @FindBy(xpath="//button[@class='cb-button cb-button__primary']")
    WebElement subscribeButton;

    public WebElement getSubscribeButton() {

        return subscribeButton;
    }

    @FindBy(xpath="//p[@class='thankyou-page__text mb-0']")
    WebElement confirmSilverSignup;


    public WebElement getConfirmSilverSignup() {

        return confirmSilverSignup;
    }

    @FindBy(xpath="//button[text()='Continue']")
    WebElement continueSilverSignupButton;


    public WebElement getContinueSilverSignupButton() {

        return continueSilverSignupButton;
    }
}
