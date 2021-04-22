package pages;

import collections.OrderPageCollection;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class OrderPage {

    By trialPrice = By.xpath("//small[normalize-space()='1.00 AUD']");
    By cardName = By.id("Ecom_Payment_Card_Name");
    By cardNumber = By.id("Ecom_Payment_Card_Number");
    By selectMonth = By.id("Ecom_Payment_Card_ExpDate_Month");
    By selectYear = By.id("Ecom_Payment_Card_ExpDate_Year");
    By verifyCode = By.id("Ecom_Payment_Card_Verification");
    By confirmButton = By.id("submit3");

    private WebDriver driver;
    private WebDriverWait wait;

    public OrderPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void assertTrialPrice(){

        WebElement trialPriceElement = wait.until(ExpectedConditions.elementToBeClickable(trialPrice));
        String trialPriceStr = trialPriceElement.getText();

        String[] parts = trialPriceStr.split(" ");
        Log4j.info("Trial price : " + parts[0]);
        Assert.assertEquals(OrderPageCollection.trialPrice,parts[0]);
        if(!OrderPageCollection.trialPrice.equals(parts[0])){
            Log4j.error("Mismatch trial price");
        }
        Log4j.info("Check trial price");
        Log4j.info("Expected trial price: "+ OrderPageCollection.trialPrice + " Actual trial price: "+ parts[0]);
    }

    public void insertCardData(){

        WebElement cardNameElement = wait.until(ExpectedConditions.elementToBeClickable(cardName));
        cardNameElement.sendKeys(OrderPageCollection.cardName);
        Log4j.info("Credit card name field : " + OrderPageCollection.cardName);

        WebElement cardNumberElement = wait.until(ExpectedConditions.elementToBeClickable(cardNumber));
        cardNumberElement.sendKeys(OrderPageCollection.cardNumber);
        Log4j.info("Credit card number field : " + OrderPageCollection.cardNumber);

        WebElement selectMonthElement = wait.until(ExpectedConditions.elementToBeClickable(selectMonth));
        Select monthSelect = new Select(selectMonthElement);
        monthSelect.selectByIndex(1);
        Log4j.info("Credit card month : " + monthSelect.getFirstSelectedOption().getText());

        WebElement selectYearElement = wait.until(ExpectedConditions.elementToBeClickable(selectYear));
        Select yearSelect = new Select(selectYearElement);
        yearSelect.selectByIndex(1);
        Log4j.info("Credit card year : " + yearSelect.getFirstSelectedOption().getText());

        WebElement verifyCodeElement = wait.until(ExpectedConditions.elementToBeClickable(verifyCode));
        verifyCodeElement.sendKeys(OrderPageCollection.verifyCode);
        Log4j.info("Verify code field : " + OrderPageCollection.verifyCode);

        WebElement confirmButtonElement = wait.until(ExpectedConditions.elementToBeClickable(confirmButton));
        confirmButtonElement.click();
        Log4j.info("Confirm button clicked");

    }

    public void assertAlertMessage(){

        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(OrderPageCollection.alertMessage,alertMessage);
        if(!OrderPageCollection.alertMessage.equals(alertMessage)){
            Log4j.error("Mismatch alert messages");
        }
        Log4j.info("Check alert messages");
        Log4j.info("Expected alert message: "+ OrderPageCollection.alertMessage + " Actual alert message: "+ alertMessage);
    }

}
