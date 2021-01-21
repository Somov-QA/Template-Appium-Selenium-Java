package support.PageObject.mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EkPage {

    public static String inputSearchName = "search_";
    public static String inputButtonSearchName = "search_but_";
    public static String searchTitleID = "search_title";

    public static WebElement getInputSearch(AppiumDriver driver) {
        By inputSearch = By.name(inputSearchName);
        WebElement element = driver.findElement(inputSearch);
        return element;
    }

    public static WebElement getButtonSearch(AppiumDriver driver) {
        By buttonSearch = By.name(inputButtonSearchName);
        WebElement element = driver.findElement(buttonSearch);
        return element;
    }
}
