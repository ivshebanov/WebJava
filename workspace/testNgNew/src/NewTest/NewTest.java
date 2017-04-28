//package NewTest;
//
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class NewTest {
//	private WebDriver driver;
//
//	@Test
//	public void main() throws InterruptedException {
//		driver.get("http://yandex.ru");
//		Thread.sleep(4000);
//	}
//
//	@BeforeMethod
//	public void beforeMethod() {
//		System.setProperty("webdriver.gecko.driver", "/Users/iliashebanov/Dropbox/JAVA/drivers/geckodriver");
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//		driver.quit();
//	}
//
//}
package NewTest;

import java.util.concurrent.TimeUnit;

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

public class NewTest {
	private WebDriver driver;
	private WebDriverWait wait;

	@Test
	public void main() throws InterruptedException {
		String userlogin = "@mail.ru";
		String usrePassword = "";
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
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox__auth__button")));
		try {
			button.click();// кликаем
		} catch (TimeoutException ignore) {
		}
		wait.until(ExpectedConditions.stalenessOf(button));// ждём исчезновения
															// кнопки, то есть
															// "выгрузки"
															// страницы
		// driver.findElement(By.id("mailbox__auth__button")).click();

		WebElement button1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]/div/div/div/span/i[3]")));
		try {
			String checkIn = button1.getText();
			Assert.assertEquals(checkIn, userlogin);
			System.out.println(checkIn);
		} catch (TimeoutException ignore) {
			System.out.println("Ошибка загрузки почты");
		}

	}

	@BeforeMethod
	public void beforeMethod() {
		// System.setProperty("webdriver.gecko.driver",
		// "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");
		System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.0/bin/geckodriver");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 15);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
