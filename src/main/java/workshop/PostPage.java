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

    //private AndroidDriver driver;
    private WebDriverWait driver_wait;

    public PostPage(AndroidDriver driver){
        this.driver = driver;
        driver_wait = new WebDriverWait(driver, 20);
    }

    public void exists(){
        driver_wait.until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/action_bar_title")));
        assertEquals(driver.findElement(By.id("android:id/action_bar_title")).getText(), "Posts");
    }
}