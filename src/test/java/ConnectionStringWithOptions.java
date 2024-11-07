import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ConnectionStringWithOptions {

    AppiumDriver driver;

    @BeforeTest
    public void intializer() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setApp(System.getProperty("user.dir") + "/app/ApiDemos-debug.apk")
                .setNoReset(false)
                .setAvdLaunchTimeout(Duration.ofSeconds(300000))
                .setAvd("Pixel_4_API_35");
        URL url = new URL("http://localhost:4723");
        driver = new AndroidDriver(url, options);
        System.out.println("Opening Appium Server using Option Class");
    }

    @Test
    public void sampleTest(){
        System.out.println("Sample Test");
    }

//

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
