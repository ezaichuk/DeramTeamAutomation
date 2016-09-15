package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverExtention {

    protected static WebDriver driver;
    protected static ApplicationSettings appSettings;

    public WebDriverExtention(WebDriver driver) {
        this.driver = driver;
        appSettings = new ApplicationSettings();
    }

    protected static boolean WaitAndClick (WebElement webElement){
        if (WaitTillClickable(webElement)) {
            webElement.click();
            return true;
        }
        return false;
    }

    protected static boolean WaitTillClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, appSettings.timeToTimeout, appSettings.timeToSleep);
        WebElement element;
        element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return (element != null);
    }

    protected static boolean WaitTillVisible (WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, appSettings.timeToTimeout, appSettings.timeToSleep);
        WebElement element;
        element = wait.until(ExpectedConditions.visibilityOf(webElement));

        return (element != null);
    }

    protected static void SwitchToFrame (int frame){
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, appSettings.timeToTimeout, appSettings.timeToSleep);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
    }

}