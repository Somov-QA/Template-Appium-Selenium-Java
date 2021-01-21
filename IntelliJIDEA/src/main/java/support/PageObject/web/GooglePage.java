package support.PageObject.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    public static String inputSearchName = "q";
    public static String searchResultsClass = "g";

    public static WebElement getInputSearch(WebDriver driver) {
        By inputSearch = By.name(inputSearchName);
        WebElement element = driver.findElement(inputSearch);
        return element;
    }

    public static List<WebElement> getListResultsSearch(WebDriver driver) {
        By searchResult = By.className(searchResultsClass);
        List<WebElement> elements = driver.findElements(searchResult);
        return elements;
    }
}
