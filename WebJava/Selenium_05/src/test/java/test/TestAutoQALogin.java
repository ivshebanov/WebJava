package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AutoQALogin;
import pages.AutoSending;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class TestAutoQALogin {
    private WebDriver driver;
    private AutoSending objSending;
    private AutoQALogin objLogin;

    private static LinkedList<String> email;
    private String userName = "bkmz1951@mail.ru";
    private String pasword = "12345qwerty";

    private String recipientEmail = "";
    private String letterSubject = "TT";


    @BeforeTest
    private static void initList() {
        email = new LinkedList<String>();
        email.addFirst("ivshebanov@gmail.com");
        email.addFirst("1111ivshebanov1@gmail.com");
        email.addFirst("2222ivshebanov2@gmail.com");
        email.addFirst("3333ivshebanov3@gmail.com");
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        this.recipientEmail = email.getLast();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        email.removeLast();
    }

    @Test(invocationCount = 4, timeOut = 50000)
    public void test_Home_Page_Appear_Correct() throws InterruptedException {
        objLogin = new AutoQALogin(driver);
        objLogin.loginToAutoQA(userName, pasword);

        objSending = new AutoSending(driver);
        objSending.loginToAutoQA(recipientEmail, letterSubject);
    }
}
