package support.StepsObject.web;

import support.PageObject.web.GooglePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSteps {
    public final WebDriver driver;

    public GoogleSteps(WebDriver webdriver) {
        this.driver = webdriver;
    }

    public void setValueInSearch(String value) {
        WebElement inputSearch = GooglePage.getInputSearch(driver);
        inputSearch.sendKeys(value);
        inputSearch.sendKeys(Keys.ENTER);
    }

    public int getCountResultSearch()
    {
        List<WebElement> resultElements = GooglePage.getListResultsSearch(driver);
        return resultElements.size();
    }
}
