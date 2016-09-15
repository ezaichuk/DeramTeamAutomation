package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    public MainPage mainPage;

    public BaseTest() {
        try {
            mainPage = PageFactory.initElements(getCurrentDriver(), MainPage.class);
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }


    protected static WebDriver getCurrentDriver() throws MalformedURLException {
        if (driver == null) {
            ApplicationSettings appSettings = new ApplicationSettings();
            DesiredCapabilities capability = null;
            switch (appSettings.browserType) {
                case "ff" :
                    capability = DesiredCapabilities.firefox();
                    break;
                case "ie" :
                    capability = DesiredCapabilities.internetExplorer();
                    capability.setCapability(InternetExplorerDriver.BROWSER_ATTACH_TIMEOUT, 5000);
                    capability.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, false);
                    capability.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                    capability.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
                    capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
                    break;
                case "chrome" :
                    capability = DesiredCapabilities.chrome();
                    break;
            }

            driver = new RemoteWebDriver(new URL(appSettings.seleniumServer), capability);
            driver.manage().timeouts().implicitlyWait(appSettings.timeToWait, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(appSettings.timeToTimeout, TimeUnit.SECONDS);
            driver.manage().window().setSize(ApplicationSettings.res1920x1080);
        }
        return driver;
    }
}
