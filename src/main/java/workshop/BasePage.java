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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;


public class BasePage {

    protected AndroidDriver driver;
    private WebDriverWait driver_wait;

    private Properties properties;


    public BasePage(AndroidDriver driver, String file){
        this.driver = driver;
        driver_wait = new WebDriverWait(driver, 10);
        File archive;
        archive = new File("src\\main\\java\\workshop\\element\\" + file + ".json");

        properties = getJson(archive);
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

    public Properties getJson(File archive){

        String json = "";
        Gson gson = new Gson();

        FileReader fr = null;
        BufferedReader br;

        try {

            fr = new FileReader(archive);
            br = new BufferedReader(fr);

            String linea;

            while((linea=br.readLine())!=null) {
                json = json + linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return gson.fromJson(json, (Properties.class));
    }
}
