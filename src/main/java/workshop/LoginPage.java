package workshop;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver){
        super(driver, "login_page");
    }

    public void fill_credentials(){

        fill_field(id("user"), "calabash");
        fill_field(id("password"), "password");
        press_button(id("add_url"));
        fill_field(id("url"), "ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
        press_button(id("sign_in"));
    }

    public void correct_login(){
        PostPage post_page;
        post_page = new PostPage(driver);
        post_page.exists();
    }

    public void invalid_url() {
        fill_field(id("user"), "calabash");
        fill_field(id("password"), "password");
        press_button(id("add_url"));
        fill_field(id("url"), "qqqqqqqqq");
        press_button(id("sign_in"));
    }

    public void error_message() {
        wait_until(id("error"));
        assertEquals(element_text(id("error")), "We can't log you in");
    }
}
