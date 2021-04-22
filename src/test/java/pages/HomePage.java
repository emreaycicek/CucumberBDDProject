package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class HomePage {

    By subscribeButton = By.xpath("//a[@name='Subscribe']");

    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void goSubscribePage(){

        WebElement subscribeButtonElement = wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        subscribeButtonElement.click();
        Log4j.info("Subscribe button clicked");

    }

}
