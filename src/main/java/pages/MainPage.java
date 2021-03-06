package pages;

import core.WebDriverExtention;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends WebDriverExtention{

    @FindBy(xpath = ".//div[@id = 'meta-2']/ul/li[1]/a")
    public WebElement urlLogin;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void Open() {
        driver.navigate().to(appSettings.baseUrl);
    }

    public void Login(){
        WaitAndClick(urlLogin);
    }
}
