package workshop;

import com.google.gson.Gson;
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

import java.io.*;
import java.util.Properties;


public class BasePage {

    protected AndroidDriver driver;
    private WebDriverWait driver_wait;

    private Properties properties;


    public BasePage(AndroidDriver driver, String file){
        this.driver = driver;
        driver_wait = new WebDriverWait(driver, 10);

        properties = get_data("src\\main\\java\\workshop\\element\\" + file + ".properties");

    }

    public void press_button(String element){
        By.id(element).findElement(driver).click();
    }

    public void fill_field(String element, String content){
        By.id(element).findElement(driver).sendKeys(content);
    }

    public void wait_until(String element) {
        driver_wait.until(ExpectedConditions.presenceOfElementLocated(By.id(element)));
    }

    public String element_text(String string){
        return driver.findElement(By.id(string)).getText();
    }

    public String element(String element){
        return properties.getProperty(element);
    }

    public Properties get_data(String file){
        Properties temp = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            temp.load(input);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally{
            if(input != null){
                try {
                    input.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        return temp;
    }
}
