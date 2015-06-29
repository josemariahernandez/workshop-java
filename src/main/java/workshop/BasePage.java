package workshop;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BasePage {

    protected AndroidDriver driver;

    public void press_button(String id){
        By.id(id).findElement(driver).click();
    }

    public void fill_field(String id, String content){
        By.id(id).findElement(driver).sendKeys(content);
    }
}
