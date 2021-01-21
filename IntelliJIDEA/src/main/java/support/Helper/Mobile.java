package support.Helper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class Mobile {

    public static AppiumDriver driver;

    public static void initDriverForWeb(String platformName, String platformVersion, String deviceName, String BrowserName) throws MalformedURLException {
        URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserName);
        driver = new AndroidDriver(serverURL, capabilities);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        System.out.println("Appium: init driver for web");
    }

    public static void quitDriver() {
        try {
            System.out.println("Appium: please wait...");
            driver.close();
            driver.quit();
            System.out.println("Appium: stop driver");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
            System.exit(0);
        }
    }
}
