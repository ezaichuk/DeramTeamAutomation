package Steps;

import core.BaseTest;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class stepsMainPage extends BaseTest {
    @Given("^I open Main page$")
    public void I_open_Main_page() {
        // Express the Regexp above with the code you wish you had
        mainPage.Open();
    }
}
