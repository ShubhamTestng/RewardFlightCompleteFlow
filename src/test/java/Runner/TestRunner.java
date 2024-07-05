package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(features="src/test/resources/features",
                 glue={"stepdefs","utilities"},
                 monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
