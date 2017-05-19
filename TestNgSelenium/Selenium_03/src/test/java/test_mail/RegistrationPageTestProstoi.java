package test_mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 27.04.2017.
 */
public class RegistrationPageTestProstoi {
    @FindBy(id = "mailbox__login")
    private WebElement emailField;
    @FindBy(id = "mailbox__password")
    private WebElement passwordField;
    @FindBy(id = "mailbox__auth__button")
    private WebElement submitButton;

    private WebDriver driver;
    private WebDriverWait wait;
    private String site = "http://www.mail.ru";
    private String email = "";
    private String password = "";

    @Test
    public void registrationPage() throws Exception {
        driver.get(site);
        driver.findElement((By) emailField).clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(submitButton)).click();
        wait.until(ExpectedConditions.stalenessOf(submitButton));
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
