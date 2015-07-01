package workshop;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;


public class LoginSteps{
  private AndroidDriver driver;
  private LoginPage login_page;
/*
  @Before
  public void setUp() throws Exception {
    File classpathRoot = new File(System.getProperty("user.dir"));
    File appDir = new File(classpathRoot, "apps");
    File app = new File(appDir, "Workshop.apk");

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("deviceName","Genymotion");
    capabilities.setCapability("platformVersion", "4.4");
    capabilities.setCapability("app", app.getAbsolutePath());

    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  }*/
  public LoginSteps(SharedDriver driver){
    this.driver = driver;
  }


  @Given("^I am about to login$")
  public void i_am_about_to_login() throws Exception{
    login_page = new LoginPage(driver);
  }

  @When("^I enter valid credentials$")
  public void i_enter_valid_credentials(){
    login_page.fill_credentials();
  }

  @Then("^I can see posts for the site")
  public void i_can_see_posts_for_the_site() {
    login_page.correct_login();
  }
}
