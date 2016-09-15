package Steps;

import core.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class stepsMainPage extends BaseTest {
    @Given("^I open Main page$")
    public void I_open_Main_page() {
        mainPage.Open();
    }

    @When("^I click login$")
    public void I_click_login() {
        mainPage.Login();
    }
}
