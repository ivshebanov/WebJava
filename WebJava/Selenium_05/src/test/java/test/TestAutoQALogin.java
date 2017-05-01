package test;

import DAO.DaoMyClientServet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AutoQALogin;
import pages.AutoSending;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TestAutoQALogin {
    private WebDriver driver;
    private AutoSending objSending;
    private AutoQALogin objLogin;

    private ArrayList<String> email;
    private String userName = "bkmz1951@mail.ru";
    private String pasword = "12345qwerty";

    private String recipientEmail = "";
    private String letterSubject = "TT";

    private static ArrayList<String> initList(){
        DaoMyClientServet daoMyClientServet = new DaoMyClientServet();
        return (ArrayList<String>) daoMyClientServet.getUsersEmail();
    }

    @BeforeTest
    private void setupGecko() {
        new TestAutoQALogin();
        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");
        email=initList();
        System.out.println(email);
        System.out.println(email.size());
    }

    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        this.recipientEmail = email.get(0);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        email.remove(0);
    }

    @Test(invocationCount = 10)
    public void test_Home_Page_Appear_Correct() throws InterruptedException {
        objLogin = new AutoQALogin(driver);
        objLogin.loginToAutoQA(userName, pasword);

        objSending = new AutoSending(driver);
        objSending.loginToAutoQA(recipientEmail, letterSubject);
    }
}
