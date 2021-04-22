package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class BasketPage {

    By paymentMethod = By.id("select2-drpPaymentMethod-container");
    By selectCreditCard = By.xpath("/html/body/span/span/span[2]/ul/li[2]"); //select2 olduğu için full pathini kullandım.
    By chekTerms = By.xpath("//label[@for='checkTerms']");
    By payNowButton = By.xpath("//input[@name='pay-now']");
    By trialPriceBasket = By.id("lblTotalAmount");

    private WebDriver driver;
    private WebDriverWait wait;

    public BasketPage(WebDriver driver, WebDriverWait wait){

        this.driver = driver;
        this.wait = wait;
    }

    public void setPaymentCreditCard() {

        WebElement paymentMethodElement = wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        paymentMethodElement.click();
        Log4j.info("Payment method clicked");

        WebElement selectCreditCardElement = wait.until(ExpectedConditions.elementToBeClickable(selectCreditCard));
        selectCreditCardElement.click();
        Log4j.info("Credit card selected");

        waitTwoSeconds();

    }
        public void confirmPayment(){

        WebElement chekTermsElement = wait.until(ExpectedConditions.elementToBeClickable(chekTerms));
        chekTermsElement.click();
        Log4j.info("Check terms clicked");

        waitTwoSeconds();

        WebElement payNowButtonElement = wait.until(ExpectedConditions.elementToBeClickable(payNowButton));
        payNowButtonElement.click();
        Log4j.info("Pay now button clicked");

        }

    public String getMonthlyPriceBasket(){

        WebElement monthlyPlanPriceElement = wait.until(ExpectedConditions.elementToBeClickable(trialPriceBasket));
        String monthlyPlanPriceStr = monthlyPlanPriceElement.getText();
        String[] parts = monthlyPlanPriceStr.split("\\$");
        Log4j.info("Basket page monthly price : " + parts[1]);
        return parts[1];

    }

    public void waitTwoSeconds(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
