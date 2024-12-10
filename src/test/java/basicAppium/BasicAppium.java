
package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasicAppium {


    AppiumDriver android;

    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","Pixel XL API 28");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.android.calculator2");
        capabilities.setCapability("appium:appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        android = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void testSomeThing() throws InterruptedException {
        Thread.sleep(5000);
    }

    @AfterEach
    public void closeApp() {
        android.quit();
    }


}
