package test_mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {
    private WebDriver driver;
    private final String site = "http://www.mail.ru";
    private final String email = "@mail.ru";
    private final String password = "";

    private final RegistrationHelper rh = new RegistrationHelper(new RegistrationPage(), driver);

    @Test
    public void registrationPage() throws Exception {
//        RegistrationHelper rh = new RegistrationHelper(new RegistrationPage());
        driver.get(site);
//        rh.openSite(site);
        String titl = rh.getTitle();
        rh.setEmailWithValidAllFields(email, password);
        rh.clickEntrance();
        Assert.assertEquals(titl, rh.getTitle());
    }

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 15);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }
}
