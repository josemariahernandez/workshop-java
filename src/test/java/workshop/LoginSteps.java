package workshop;

import java.io.File;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.*;
import cucumber.api.java.en.*;



public class LoginSteps{
  private AndroidDriver driver;
  private LoginPage login_page;

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
  }

  @Given("^I am about to login$")
  public void i_am_about_to_login(){
    login_page = new LoginPage(driver);
  }

  @When("^I enter valid credentials$")
  public void i_enter_valid_credentials(){
    login_page.fill_credentials();
  }

  @Then("^I can see posts for the site")
  public void i_can_see_posts_for_the_site(){
    login_page.correct_login();
  }

  @When("^I enter invalid url$")
  public void i_enter_invalid_url(){
    login_page.invalid_url();
  }

  @Then("^I can see error message$")
  public void i_can_see_error_message(){
    login_page.error_message();
  }
}
