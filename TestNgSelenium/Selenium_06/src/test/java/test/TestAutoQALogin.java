package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AutoQALogin;

import java.util.concurrent.TimeUnit;

/**
 * Created by Администратор on 28.04.2017.
 */
public class TestAutoQALogin {
    WebDriver driver;
    AutoQALogin objLogin;
    private String strUserName = "@mail.ru";
    private String strPasword = "";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
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
        objLogin = new AutoQALogin(driver);
        objLogin.loginToAutoQA(strUserName, strPasword);
        String element = driver.findElement(By.id("PH_user-email")).getText();
        Assert.assertEquals(element, "klacuk070@mail.ru");
    }
}
