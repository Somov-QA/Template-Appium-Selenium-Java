package acceptance;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;

public class TestSampleMobileWeb {

    @Test
    public void testWeb() throws Exception {
        //URL serverURL = new URL("http://127.0.0.1:4723/wd/hub");
        URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_9_API_28");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

        System.out.println("Step 1. Create new driver");
        AppiumDriver appiumDriver = new AndroidDriver(serverURL, capabilities);
        WebDriverWait wait = new WebDriverWait(appiumDriver, 30);

        System.out.println("Step 2. Open website");
        appiumDriver.get("http://ek.ua/");

        System.out.println("Step 3. Enter search value");
        appiumDriver.findElement(By.name("search_")).sendKeys("GeForce");

        System.out.println("Step 4. Click search button");
        appiumDriver.findElement(By.name("search_but_")).click();

        Thread.sleep(5000);

        System.out.println("Step 5. Check result");
        String expect = "По запросу GeForce";
        String actual = appiumDriver.findElement(By.id("search_title")).getText();
        Boolean result = appiumDriver.findElement(By.id("search_title")).getText().contains(expect);

        System.out.println("Expect: " + expect);
        System.out.println("Actual: " + actual);
        System.out.println("Result: " + result);

        Assert.assertTrue(result);

        System.out.println("Step 6. Close driver");
        appiumDriver.quit();
    }

}
