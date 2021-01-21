package acceptance;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import support.Helper.Web;
import support.StepsObject.web.GoogleSteps;

public class TestSampleWebTestNG {
    @BeforeTest
    public static void setup() {
        Web.initWebDriver();
        Web.browserFullScreen();
    }

    @Test
    public void testSearch() {
        GoogleSteps tester = new GoogleSteps(Web.driver);
        tester.driver.get("https://www.google.com/");
        tester.setValueInSearch("GeForce 1650");
        int result = tester.getCountResultSearch();
        Assert.assertNotEquals(0, result);
        System.out.println("Tests finished: SUCCESS");
    }

    @AfterTest
    public static void tearDown() {
        Web.quitWebDriver();
    }
}
