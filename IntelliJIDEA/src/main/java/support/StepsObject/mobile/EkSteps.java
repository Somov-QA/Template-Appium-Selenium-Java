package support.StepsObject.mobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import support.Helper.Mobile;
import support.PageObject.mobile.EkPage;

public class EkSteps {

    public final AppiumDriver driver;

    public EkSteps(AppiumDriver driver) {
        this.driver = driver;
    }

    public String getActual(){
        String actual = this.driver.findElement(By.id(EkPage.searchTitleID)).getText();
        return actual;
    }

    public Boolean getResult(String expect){
        Boolean result = this.driver.findElement(By.id(EkPage.searchTitleID)).getText().contains(expect);
        return result;
    }
}
