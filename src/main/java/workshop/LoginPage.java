package workshop;

import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.Properties;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class LoginPage extends BasePage {

    Properties credentials;

    public LoginPage(AndroidDriver driver){
        super(driver, "login_page");
    }

    public void fill_credentials(String file){
        credentials = get_data("src\\main\\java\\workshop\\config\\" + file + "_credent.properties");
        fill_field(element("user"), credentials.getProperty("username"));
        fill_field(element("password"), credentials.getProperty("password"));
        press_button(element("add_url"));
        fill_field(element("url"), credentials.getProperty("url"));
        press_button(element("sign_in"));
    }

    public void is_correct_login(){
        PostPage post_page;
        post_page = new PostPage(driver);
        post_page.exists();
    }

    public void error_message() {
        wait_until(element("error"));
        assertEquals(element_text(element("error")), "We can't log you in");
    }

    public void exists() {
        wait_until(element("sign_in"));
        assertEquals(element_text(element("sign_in")), "Sign in");
    }
}
