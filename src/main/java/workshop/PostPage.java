package workshop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;


public class PostPage extends BasePage{

    public PostPage(AndroidDriver driver){
        super(driver, "post_page");
    }

    public void exists(){
        wait_until(id("title"));
        assertEquals(element_text(id("title")), "Posts");
    }
}