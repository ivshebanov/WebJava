package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AutoQALogin;

import java.util.concurrent.TimeUnit;

public class TestAutoQALogin {
    WebDriver driver;
    AutoQALogin objLogin;
    private String strUserName = "";
    private String strPasword = "";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.instagram.com/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    /**
     * This test case will login in http://autoqa.pp.ua/wp-login.php
     * Login to application
     * Verify the home page using Dashboard message
     */
    @Test(priority = 0)
    public void test_Home_Page_Appear_Correct() throws InterruptedException {
//        objLogin = new AutoQALogin(driver);
//        objLogin.loginToAutoQA(strUserName, strPasword);
    }
}
