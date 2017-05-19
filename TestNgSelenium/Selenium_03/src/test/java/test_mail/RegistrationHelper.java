package test_mail;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class RegistrationHelper {
    private WebDriver driver;
//    private WebDriverWait wait;
    private RegistrationPage registrationPage;

    public RegistrationHelper(RegistrationPage registrationPage, WebDriver driver){
        this.registrationPage = registrationPage;
        this.driver = driver;
    }

//    @BeforeMethod
//    public void setUp() throws Exception {
//        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        wait = new WebDriverWait(driver, 15);
//    }
//
//    @AfterMethod
//    public void tearDown() throws Exception {
//        driver.quit();
//    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void setEmailWithValidAllFields(String email, String password) {
        registrationPage.setEmail(email).setPassword(password);
    }

    public void clickEntrance() {
        registrationPage.clickSubmitButton();
    }

    public void openSite(String site) {
        driver.get(site);
    }
}
