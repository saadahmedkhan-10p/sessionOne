package sessionThree;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import sessionTwo.CreateDriverSession;

public class AndroidGestures {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializerDriver("Android");
        //longClickGestureByID(driver);
        //longClickByCoordinates(driver);
        //dragAndDrop(driver);
        pinchGesture(driver);
    }

    public static void longClickGestureByID(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        // Java
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", 1000
        ));
    }

    public static void longClickByCoordinates(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", 217,
                "y", 659,
                "duration", 1000
        ));
    }

    public static void dragAndDrop(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        // Java
        driver.executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 653,
                "endY", 566
        ));
    }

    public static void pinchGesture(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(9000);

        // Java
         driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 300,
                "top", 801,
                "width", 600,
                "height", 199,
                "percent", 0.75
        ));

    }
}
