package pages;

import core.WebDriverExtention;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends WebDriverExtention{

    /*@FindBy(id = "userloginValue")
    public WebElement usernameTextbox;

    @FindBy(id = "userpassword")
    public WebElement passwordTextbox;

    @FindBy(xpath = ".//input[@class = 'btn-primary loginButton']")
    public WebElement signInButton;*/


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void Open() {
        driver.navigate().to(appSettings.baseUrl);
    }
}
