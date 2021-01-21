package acceptance;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import support.Helper.Mobile;
import support.Helper.Web;
import support.PageObject.mobile.EkPage;
import support.StepsObject.mobile.EkSteps;
import support.StepsObject.web.GoogleSteps;

import java.net.MalformedURLException;


public class TestSampleMobileWebTestNG {

    @BeforeTest
    public static void setup() throws MalformedURLException {
        Mobile.initDriverForWeb("Android", "9", "Nexus_9_API_28", "Chrome");
    }

    @Test
    public void testSearch() throws InterruptedException {
        EkSteps tester = new EkSteps(Mobile.driver);

        System.out.println("Step 1. Open website");
        tester.driver.get("http://ek.ua/");

        System.out.println("Step 3. Enter search value");
        EkPage.getInputSearch(tester.driver).sendKeys("GeForce");

        System.out.println("Step 4. Click search button");
        EkPage.getButtonSearch(tester.driver).click();

        Thread.sleep(5000);

        System.out.println("Step 5. Check result");
        String actual = tester.getActual();
        String expect = "По запросу GeForce";
        Boolean result = tester.getResult(expect);

        System.out.println("Expect: " + expect);
        System.out.println("Actual: " + actual);
        System.out.println("Result: " + result);

        Assert.assertTrue(result);

        System.out.println("Step 6. Close driver");
        System.out.println("Tests finished: SUCCESS");
    }

    @AfterTest
    public static void tearDown() {
        Mobile.quitDriver();
    }

}
