package support.Helper;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.*;

public class Web {

    public static WebDriver driver;

    public static String getDriverPath() {
        String path = System.getProperty("user.dir") + "\\webdriver\\chromedriver.exe";
        System.out.println("WebDriver: path ["+path+"]");
        return path;
    }

    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", getDriverPath());
        driver = new ChromeDriver();
        System.out.println("WebDriver: init");
    }

    public static void browserFullScreen() {
        driver.manage().window().maximize();
        System.out.println("Browser: full screen");
    }

    public static void quitWebDriver() {
        try {
            System.out.println("WebDriver: please wait...");
            driver.close();
            driver.quit();
               System.out.println("WebDriver: stop");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.toString());
            System.exit(0);
        }
    }

    public static void showTitle(String testname) {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("| BEGIN TESTING ------------------------------");
        System.out.println("| " + testname);
        System.out.println("|---------------------------------------------");
    }

    public static void showError(Exception e, String message) throws Exception {
        System.out.println("| ERROR --------------------------------------");
        System.out.println(message);
         System.out.println(e.toString());
        System.out.println("|---------------------------------------------");
        System.out.println(" ");
        quitWebDriver();
        Assert.assertEquals("CORRECT", "ERROR");
    }

    /* Показать сообщение о том что тест провален */
    public static void showFail(String failMessage) throws Exception {
        System.out.println("FAILED ---------------------------------------");
        System.out.println("| " + failMessage);
        System.out.println("|---------------------------------------------");
        System.out.println(" ");
        quitWebDriver();
        Assert.assertEquals("PASSED", "FAILED");
    }

}
