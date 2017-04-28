package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AutoQALogin;
import pages.AutoSending;

import java.util.concurrent.TimeUnit;

public class TestAutoQALogin {
    private WebDriver driver;
    private AutoSending objSending;
    private AutoQALogin objLogin;

    private String userName = "bkmz1951@mail.ru";
    private String pasword = "12345qwerty";

    private String recipientEmail = "ivshebanov@gmail.com";
    private String letterSubject = "Тема накатана";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test(priority = 0)
    public void test_Home_Page_Appear_Correct() throws InterruptedException {
        objLogin = new AutoQALogin(driver);
        objLogin.loginToAutoQA(userName, pasword);

        objSending = new AutoSending(driver);
        objSending.loginToAutoQA(recipientEmail, letterSubject);
    }
}
