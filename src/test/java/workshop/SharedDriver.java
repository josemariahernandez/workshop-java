package workshop;

import cucumber.api.java.After;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class SharedDriver extends AndroidDriver {

    private static URL url;
    private static DesiredCapabilities capabilities;

    static{
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "Workshop.apk");

        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Genymotion");
        capabilities.setCapability("platformVersion", "4.4");
        capabilities.setCapability("app", app.getAbsolutePath());

        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public SharedDriver() {
        super(url, capabilities);
    }

    @After
    public void tearDown(){
        quit();
    }
}
