package pages;

import core.WebDriverExtention;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends WebDriverExtention{

    @FindBy(xpath = ".//div[@id = 'meta-2']/ul/li[1]/a")
    public WebElement urlLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void Open (){
        driver.navigate().to(appSettings.baseUrl);
    }
}
