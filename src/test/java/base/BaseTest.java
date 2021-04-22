package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;

    public void navigateUrl(String url) {

        driver.get(url);

    }


}