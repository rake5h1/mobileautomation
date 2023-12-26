package Pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidElement;
import java.util.concurrent.TimeUnit;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

public class BaseTest {
    AndroidDriver driver;
    String apk_path = "app.apk";
    String app_path = System.getProperty("user.dir") + "\\" + apk_path;

    @Test
    public void Setup() {

        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        options.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        options.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        options.setCapability(MobileCapabilityType.APP,
                app_path);
        options.setCapability("autoGrantPermissions", true);

        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"),
                    options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();

    }

}
