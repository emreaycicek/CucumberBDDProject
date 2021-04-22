package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Log4j;

public class RegisterPage {

    By firstName = By.name("FirstName");
    By lastName = By.name("LastName");
    By email = By.name("EmailOrPhone");
    By password = By.id("password");
    By createAccButton = By.xpath("//input[@value='CREATE ACCOUNT']");

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void fillRegisterForm(){

        Log4j.info("Starting register a user");

        Faker faker = new Faker();
        WebElement firstNameElement = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        String firstNameStr = faker.name().firstName();
        firstNameElement.sendKeys(firstNameStr);
        Log4j.info("First name : " + firstNameStr);

        WebElement lastNameElement = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        String lastNameStr = faker.name().firstName();
        lastNameElement.sendKeys(lastNameStr);
        Log4j.info("Last name : " + lastNameStr);

        WebElement emailElment = wait.until(ExpectedConditions.elementToBeClickable(email));
        emailElment.sendKeys(faker.internet().emailAddress());
        String emailStr = faker.internet().emailAddress();
        lastNameElement.sendKeys(emailStr);
        Log4j.info("Email : " + emailStr);

        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(password));
        String passwordStr = faker.internet().password(10,14,true);
        passwordElement.sendKeys(passwordStr);
        Log4j.info("Password : " + passwordStr);

        WebElement createAccButtonElement = wait.until(ExpectedConditions.elementToBeClickable(createAccButton));
        createAccButtonElement.click();
        Log4j.info("Create account button clicked");

    }



}
