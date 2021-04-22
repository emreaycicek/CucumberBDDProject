package steps;

import base.BaseTest;
import collections.OrderPageCollection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import collections.HomePageCollection;
import org.junit.Assert;
import pages.*;
import utilities.Log4j;

public class Steps extends BaseTest {

    private BaseTest base;

    public Steps(BaseTest base) {
        this.base = base;
    }

    String subsMonthlyPrice;
    String basketMonthlyPrice;


    @Given("^I navigate to https://connect-au.beinsports.com/en$")
    public void iNavigateToHttpsConnectAuBeinsportsComEn() {

        base.navigateUrl(HomePageCollection.url);
        Log4j.info("Opening Page : " + HomePageCollection.url);
    }

    @When("^I click Subscribe button$")
    public void iClickSubscribeButton() {

        new HomePage(base.driver, base.wait).goSubscribePage();
        Log4j.info("Subscribe page opened");
    }

    @And("^I register to One Month\\(Monthly Plan with Two Week Free Trial\\) package$")
    public void iRegisterToOneMonthMonthlyPlanWithTwoWeekFreeTrialPackage() {

        subsMonthlyPrice = new SubscribePage(base.driver, base.wait).getMonthlyPriceSubs();
        new SubscribePage(base.driver, base.wait).selectMonthlyPlan();
    }

    @And("^I fill Create Account form with a random email$")
    public void iFillCreateAccountFormWithARandomEmail() {

        new RegisterPage(base.driver, base.wait).fillRegisterForm();
        Log4j.info("Register form filled");

    }

    @Then("^I validate package price$")
    public void iValidatePackagePrice() {

        basketMonthlyPrice = new BasketPage(base.driver, base.wait).getMonthlyPriceBasket();
        Assert.assertEquals(subsMonthlyPrice,basketMonthlyPrice);
        if(!subsMonthlyPrice.equals(basketMonthlyPrice)){
            Log4j.error("Mismatch monthly prices");
        }
        Log4j.info("Check monthly prices");
        Log4j.info("Expected monthly price: "+ subsMonthlyPrice + " Actual monthly price: "+ basketMonthlyPrice);
    }

    @When("^I make Payment with Credit Card$")
    public void iMakePaymentWithCreditCard() {

        new BasketPage(base.driver, base.wait).setPaymentCreditCard();
        new BasketPage(base.driver, base.wait).confirmPayment();
        Log4j.info("Confirmed payment credit card");

    }

    @Then("^I expect for a total charge of 1.00 since this is a free trial package$")
    public void iExpectForATotalChargeOfSinceThisIsAFreeTrialPackage() {

        new OrderPage(base.driver, base.wait).assertTrialPrice();
        Log4j.info("Monthly trial prices checked");

    }

    @When("^I provide a test card data and confirm payment\\(Do not enter a real card data\\)$")
    public void iProvideATestCardDataAndConfirmPaymentDoNotEnterARealCardData() {

        new OrderPage(base.driver, base.wait).insertCardData();
        Log4j.info("Credit card information entered ");

    }

    @Then("^I expect for a error text and finish test with success$")
    public void iExpectForAErrorTextAndFinishTestWithSuccess() {

        new OrderPage(base.driver, base.wait).assertAlertMessage();
        Log4j.info("Alert message checked");

    }


}
