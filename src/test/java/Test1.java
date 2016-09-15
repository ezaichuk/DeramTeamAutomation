import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.net.MalformedURLException;


public class Test1 extends BaseTest{

    protected static WebDriver driver;
    @Test
    public void OpenLoginPageTest() throws InterruptedException {

        LoginPage loginPage = null;

        try {
            loginPage = PageFactory.initElements(getCurrentDriver(), LoginPage.class);
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

        loginPage.Open();

        Assert.assertTrue(true);

    }

}
