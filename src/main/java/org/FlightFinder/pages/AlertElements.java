package org.FlightFinder.pages;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

    public class AlertElements {

        public static WebDriver driver;


        public AlertElements(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

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

        public WebElement getWhereToField() {

            return whereToField;
        }


        public WebElement getSearchButton() {

            return searchButton;
        }

        public WebElement getCreateAlertButton() {

            return createAlertButton;
        }

        public WebElement getDepartStartDate() {

            return departStartDate;
        }

        public WebElement getNextMonth() {

            return nextMonth;
        }

        public WebElement getStartDate() {

            return startDate;
        }

        public WebElement getEndDate() {

            return endDate;
        }

        public WebElement getreturnStartDate() {

            return returnStartDate;
        }

        public WebElement getCreateAlertButtonPopup() {

            return createAlertButtonPopup;
        }

        public WebElement getAlertmsg() {

            return alertmsg;
        }

        public WebElement getAccountButton() {

            return accountButton;
        }

        public WebElement getLogoutButton() {

            return logoutButton;
        }

        public WebElement getCloseAlertPopup() {

            return closeAlertPopup;
        }

        public WebElement getInvalidCredentials() {

            return invalidCredentials;
        }

        public WebElement getSearchField(){

            return searchField;
        }

        @FindBy(xpath="//span[text()='Invalid email or password.']")
        WebElement invalidCredentials;

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

        @FindBy(xpath="//div[text()='Where to?']")
        WebElement whereToField;

        @FindBy(xpath="//button[text()='Search Now']")
        WebElement searchButton;

        @FindBy(xpath="//div[@id='destination-dropdown']//div[@class=' css-1wa3eu0-placeholder']")
        WebElement searchField;

        @FindBy(xpath="//button/span[text()='Create Alert']")
        WebElement createAlertButton;

        @FindBy(xpath="//input[@name='departStartDate']")
        WebElement departStartDate;

        @FindBy(xpath="//div[@aria-label='Move forward to switch to the next month.']")
        WebElement nextMonth;

        @FindBy(xpath="(//div[text()='15' and @class='CalendarDay__Date'])[2]")
        WebElement startDate;

        @FindBy(xpath="(//div[text()='22' and @class='CalendarDay__Date'])[2]")
        WebElement endDate;

        @FindBy(xpath="//div[@class='popup-footer']/button[text()='Create Alert']")
        WebElement createAlertButtonPopup;

        @FindBy(xpath="//div[@class='Toastify__toast-body']")
        WebElement alertmsg;

        @FindBy(xpath="//input[@name='returnStartDate']")
        WebElement returnStartDate;

        @FindBy(xpath="//*[local-name()='svg'][@class='cst-popup__close']")
        WebElement closeAlertPopup;

        @FindBy(xpath="(//div[@role='listbox'])[2]")
        WebElement accountButton;

        @FindBy(xpath="//span[text()='Logout']")
        WebElement logoutButton;

        @FindBy(xpath="/html/body/div[2]/div[1]/div/div/nav/div[2]/div[2]/div[1]/div/div[2]/h5")
        WebElement userName;

        public WebElement getUserName() {

            return userName;
        }

        @FindBy(xpath="//button[text()='No']")
        WebElement bronzeUpgradePopup;

        public WebElement getBronzeUpgradePopup() {
            return bronzeUpgradePopup;
        }

        @FindBy(xpath="//*[@class='cst-popup__close']")
        WebElement closeButton;

        public WebElement getCloseButton() {

            return closeButton;
        }

        @FindBy(xpath="//*[@class='cst-popup__close ']")
        WebElement closeButton2;

        public WebElement getCloseButton2() {

            return closeButton2;
        }


        @FindBy(xpath="//*[@class='cst-popup__text']")
        WebElement bronzeUpgradePopup2;

        public WebElement getBronzeUpgradePopup2() {

            return bronzeUpgradePopup2;
        }



        @FindBy(xpath="//button[text()='Upgrade Now']")
        WebElement upgradeButton;

        public WebElement getUpgradeButton() {

            return upgradeButton;
        }

        @FindBy(xpath="(//div[text()='01' and @class='CalendarDay__Date'])[2]")
        WebElement startDateBronze;

        @FindBy(xpath="(//div[text()='21' and @class='CalendarDay__Date'])[2]")
        WebElement endDateBronze;

        public WebElement getStartDateBronze() {

            return startDateBronze;
        }

        public WebElement getEndDateBronze() {

            return endDateBronze;
        }

        @FindBy(xpath="(//div[text()='01' and @class='CalendarDay__Date'])[2]")
        WebElement startDateSilver;

        @FindBy(xpath="(//div[text()='16' and @class='CalendarDay__Date'])[2]")
        WebElement endDateSilver;

        public WebElement getStartDateSilver() {

            return startDateSilver;
        }

        public WebElement getEndDateSilver() {

            return endDateSilver;
        }


        @FindBy(xpath="//p[@class='activeAlertText']")
        WebElement activeAlertText;

        public WebElement getActiveAlertText() {

            return activeAlertText;
        }


        @FindBy(xpath="//button[@aria-label='addPas']")
        WebElement addPassengersButton;


        public WebElement getAddPassengersButton() {

            return addPassengersButton;
        }

        @FindBy(xpath="//button[@class='ui button btn btn--medium-blue' and text()='Save']")
        WebElement saveButton;

        public WebElement getSaveButton() {

            return saveButton;
        }

        @FindBy(xpath="//div[@class='Toastify__toast-body']")
        WebElement confirmEditAlert;

        public WebElement getConfirmEditAlert() {

            return confirmEditAlert;
        }

        @FindBy(xpath="//div[@data-for='alerts']")
        WebElement alertButton;


        public WebElement getAlertButton() {

            return alertButton;
        }

        public WebElement getEditAlertButton() {
            WebElement editAlertButton = driver.findElement(By.xpath("//span[text()='15.08.2024 - 22.08.2024'][1]/ancestor::div[@class='alert-box droppable']//p[text()='Edit Alert']"));
            return editAlertButton;
        }

        @FindBy(xpath="//button[text()='Delete Alert']")
        WebElement deleteButton;


        public WebElement getDeleteButton() {
        return deleteButton;
        }
        @FindBy(xpath="(//div[@class='column text-left create-alert-modal-column column-dates'])[1]")
        WebElement outboundDate;

        public WebElement getOutboundDate() {
        return outboundDate;
        }

        @FindBy(xpath="//div[@class='1w9j89e-menu']")
        WebElement cityNames;

        public WebElement getCityNames(){
            return cityNames;
        }

        @FindBy(xpath="//div[@class='number_ui animated pulse']")
        WebElement passengerCount;

        public WebElement getPassengerCount(){
            return passengerCount;
        }
    }




