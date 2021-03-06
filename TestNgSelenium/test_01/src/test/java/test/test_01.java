package test;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class test_01 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void gotoSeleniumWikiPage() throws InterruptedException {
        String userlogin = "klacuk070@mail.ru";
        String usrePassword = "Sxsblpwiwnbbhlyucrk3";
        try {
            driver.get("http://www.mail.ru");
        } catch (TimeoutException ignore) {
            System.out.println("Ошибка загрузки страницы");
        }

        driver.findElement(By.id("mailbox__login")).clear();
        driver.findElement(By.id("mailbox__login")).sendKeys(userlogin);
        driver.findElement(By.id("mailbox__password")).clear();
        driver.findElement(By.id("mailbox__password")).sendKeys(usrePassword);
        // ждём появления кнопки на "недозагруженной" странице
        driver.findElement(By.id("mailbox__auth__button")).click();


//        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox__auth__button")));
//        try {
//            button.click();// кликаем
//        } catch (TimeoutException ignore) {
//        }
//        wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.id("mailbox__auth__button"))));// ждём исчезновения
//        // кнопки, то есть
//        // "выгрузки"
//        // страницы
        WebElement button1 = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]/div/div/div/span/i[3]")));
        try {
            String checkIn = button1.getText();
            Assert.assertEquals(checkIn, userlogin);
            System.out.println(checkIn);
        } catch (TimeoutException ignore) {
            System.out.println("Ошибка загрузки почты");
        }
        Thread.sleep(7000);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}