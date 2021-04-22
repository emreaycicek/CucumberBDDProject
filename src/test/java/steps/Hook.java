package steps;

import base.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class Hook extends BaseTest {

    private BaseTest base;

    public Hook(BaseTest base) {
        this.base = base;
    }

    @Before
    public void setUp() {

        //setProperty();
        Log4j.startLog("Test  is Starting");
        base.driver = new ChromeDriver();
        base.wait = new WebDriverWait(base.driver, 15);
        base.driver.manage().window().maximize();
    }

    @After
    public void tearDown() {

        Log4j.endLog("Test is Ending");
        base.driver.quit();
    }

    /*
    public static void setProperty() {
    }*/

}