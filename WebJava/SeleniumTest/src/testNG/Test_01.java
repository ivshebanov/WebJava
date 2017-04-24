package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test_01 {
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void main() throws InterruptedException {
        String userlogin = "klacuk070@mail.ru";
        String usrePassword = "Sxsblpwiwnbbhlyucrk3";
        try {
            driver.get("http://www.mail.ru");
        } catch (TimeoutException ignore) {
            System.out.println("1");
        }
        driver.findElement(By.id("mailbox__login")).clear();
        driver.findElement(By.id("mailbox__login")).sendKeys(userlogin);
        driver.findElement(By.id("mailbox__password")).clear();
        driver.findElement(By.id("mailbox__password")).sendKeys(usrePassword);
        Thread.sleep(3000);
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox__auth__button")));
        try {
            button.click();
        } catch (TimeoutException ignore) {
        }
//        wait.until(ExpectedConditions.stalenessOf(button));
//        String checkIn = wait
//                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]/div/div/div/span/i[3]"))).getText();
//        try {
//            Assert.assertEquals(checkIn, userlogin);
//            System.out.println(checkIn);
//        } catch (TimeoutException ignore) {
//            System.out.println("2");
//        }

    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
