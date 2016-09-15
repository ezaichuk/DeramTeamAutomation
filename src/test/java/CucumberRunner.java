import core.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, features = "src/test/Features", format = { "pretty",
        "html:target/cucumber_reports" }, tags = { "~@ignore" })

public class CucumberRunner extends BaseTest{
    @AfterClass
    public static void tearDown (){
        driver.quit();
    }
}
