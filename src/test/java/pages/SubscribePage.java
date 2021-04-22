package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class SubscribePage {

    By monthlyPlanSubs = By.xpath("(//a[contains(@class,'btn-type-2 mt-20-plus')])[1]");
    By monthlyPlanPrice = By.xpath("(//span[contains(@class,'price fz-14')])[1]");

    private WebDriver driver;
    private WebDriverWait wait;

    public SubscribePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public String getMonthlyPriceSubs(){

        //getting price
        WebElement monthlyPlanPriceElement = wait.until(ExpectedConditions.elementToBeClickable(monthlyPlanPrice));
        String monthlyPlanPriceStr = monthlyPlanPriceElement.getText();
        String[] parts = monthlyPlanPriceStr.split("\\$");
        Log4j.info("Subscribe page monthly price : " + parts[1]);
        return parts[1];

    }

    public void selectMonthlyPlan(){

        WebElement monthlyPlanSubsElement = wait.until(ExpectedConditions.elementToBeClickable(monthlyPlanSubs));
        monthlyPlanSubsElement.click();
        Log4j.info("Monthly plan selected");

    }



}
