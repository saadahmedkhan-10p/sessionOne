package sessionTwo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSession {

    public static AppiumDriver initializerDriver(String platformName) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("appium:newCommandTimeout", 300);
        URL url = new URL("http://localhost:4723");

        switch (platformName) {
            case "Android":
                capabilities.setCapability("appium:deviceName", "emulator-5554");
                capabilities.setCapability("appium:automationName", "UiAutomator2");
                capabilities.setCapability("appium:app", System.getProperty("user.dir") + "/app/ApiDemos-debug.apk");
                capabilities.setCapability("appium:noReset", false);
                return new AndroidDriver(url, capabilities);

            case "IOS":
                System.out.println("Write Capabilities for IOS");
                return new IOSDriver(url, capabilities);

            default:
                throw new Exception("Invalid Platform");
        }
    }
}
