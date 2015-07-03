package workshop;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;


public class InvalidLoginSteps {

    private AndroidDriver driver;
    private LoginPage login_page;

    public InvalidLoginSteps(SharedDriver driver){
        this.driver = driver;
        login_page = new LoginPage(driver);
    }

    @When("^I enter invalid url$")
    public void i_enter_invalid_url(){
        login_page.fill_credentials("url_invalid");
    }

    @Then("^I can see error message$")
    public void i_can_see_error_message(){
        login_page.error_message();
    }
}
