package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppUtilities {
    public static WebDriver driver;

    public AppUtilities(WebDriver driver){
        this.driver=driver;
    }

    public void waitForLoader() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='full-page-loader-comp text-center']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='full-page-loader-comp text-center']")));
    }

    public void waitForElement(WebElement element)  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}
