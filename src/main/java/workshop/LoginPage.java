package workshop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class LoginPage extends BasePage {

    private WebDriverWait driver_wait;

    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        driver_wait = new WebDriverWait(driver, 10);
    }

    public void fill_credentials(){

        fill_field("org.wordpress.android:id/nux_username", "calabash");
        fill_field("org.wordpress.android:id/nux_password", "password");
        press_button("org.wordpress.android:id/nux_add_selfhosted_button");
        fill_field("org.wordpress.android:id/nux_url", "ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
        press_button("org.wordpress.android:id/nux_sign_in_button");
    }

    public void correct_login(){
        PostPage post_page;
        post_page = new PostPage(driver);
        post_page.exists();
    }

    public void invalid_url() {
        fill_field("org.wordpress.android:id/nux_username", "calabash");
        fill_field("org.wordpress.android:id/nux_password", "password");
        press_button("org.wordpress.android:id/nux_add_selfhosted_button");
        fill_field("org.wordpress.android:id/nux_url", "qqqqqqqqq");
        press_button("org.wordpress.android:id/nux_sign_in_button");
    }

    public void error_message() {
        driver_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("org.wordpress.android:id/nux_dialog_title")));
        assertEquals(driver.findElement(By.id("org.wordpress.android:id/nux_dialog_title")).getText(), "We can't log you in");
    }
}
