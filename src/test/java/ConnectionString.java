import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ConnectionString {

    AppiumDriver driver;

    @BeforeTest
    public void initializer() throws MalformedURLException, URISyntaxException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
        System.out.println("Opening Appium Server");
    }

    @Test
    public void sampleTest(){
        System.out.println("Sample test");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
