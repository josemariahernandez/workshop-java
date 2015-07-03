package workshop;

import com.google.gson.Gson;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class LoginPage extends BasePage {

    Properties credentials;

    public LoginPage(AndroidDriver driver){
        super(driver, "login_page");
    }

    public void fill_credentials(){
        fill_field(element("user"), "calabash");
        fill_field(element("password"), "password");
        press_button(element("add_url"));
        fill_field(element("url"), "ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
        press_button(element("sign_in"));
    }

    public void correct_login(){
        PostPage post_page;
        post_page = new PostPage(driver);
        post_page.exists();
    }

    public void invalid_url() {
        fill_field(element("user"), "calabash");
        fill_field(element("password"), "password");
        press_button(element("add_url"));
        fill_field(element("url"), "qqqqqqqqq");
        press_button(element("sign_in"));
    }

    public void error_message() {
        wait_until(element("error"));
        assertEquals(element_text(element("error")), "We can't log you in");
    }

    public void fill_incorrect_credentials() {
        fill_field(element("user"), "appium");
        fill_field(element("password"), "incorrecta");
        press_button(element("add_url"));
        fill_field(element("url"), "ec2-54-82-18-238.compute-1.amazonaws.com/wordpress");
        press_button(element("sign_in"));
    }

    public void exists() {
        wait_until(element("sign_in"));
        assertEquals(element_text(element("sign_in")), "Sign in");
    }
}
