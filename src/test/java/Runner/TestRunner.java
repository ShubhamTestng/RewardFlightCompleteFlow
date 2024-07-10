package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Listeners;


@CucumberOptions(features="src/test/resources/features",
                 glue={"stepdefs","utilities"},
                 plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                 monochrome = true)


public class TestRunner extends AbstractTestNGCucumberTests {

}
