package test_mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest_01 {
    private WebDriver driver;
//    private HtmlUnitDriver driver;
    private String site = "http://www.mail.ru";
    private String username = "klacuk070@mail.ru";
    private String password = "Sxsblpwiwnbbhlyucrk3";

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
//        driver = new HtmlUnitDriver();
//        driver.setJavascriptEnabled(true);
        driver.get(site);
    }

    @Test
    public void testDoubleClick() throws Exception {
        LoginPage lp = new LoginPage(driver);
        lp.loginAs(username, password);
        Thread.sleep(10000);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
