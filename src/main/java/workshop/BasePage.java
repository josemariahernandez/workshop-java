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

    private File archive;
    private FileReader fr;
    private BufferedReader br;
    private Properties properties;



    public BasePage(AndroidDriver driver, String file){
        this.driver = driver;
        driver_wait = new WebDriverWait(driver, 10);
        String json;
        Gson gson = new Gson();

        try {
            archive = new File("src\\main\\java\\workshop\\element\\" + file + ".json");
            fr = new FileReader(archive);
            br = new BufferedReader(fr);
            json = "";

            String linea;

            while((linea=br.readLine())!=null) {
                json = json + linea;
            }

            properties = gson.fromJson(json, Properties.class);
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
    }

    public void press_button(String id){
        By.id(id).findElement(driver).click();
    }

    public void fill_field(String id, String content){
        By.id(id).findElement(driver).sendKeys(content);
    }

    public void wait_until(String string) {
        driver_wait.until(ExpectedConditions.presenceOfElementLocated(By.id(string)));
    }

    public String element_text(String string){
        return driver.findElement(By.id(string)).getText();
    }

    public String id(String id){
        return properties.getProperty(id);
    }
}
