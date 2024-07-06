package utilities;

import java.io.IOException;
import java.rmi.Remote;
import java.util.Properties;

import org.FlightFinder.pages.LoginPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    public ConfigReader configReader;


    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
    }

    @Before(order = 1)
    public void launchBrowser() throws IOException {
        String browserName = configReader.readFromPropertyFile("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);

    }

    @After(order = 0)
    public void quitBrowser(Scenario scenario) {
        //validate if scenario has failed
        if(scenario.isFailed()) {

        }
        driver.quit();
    }
}
