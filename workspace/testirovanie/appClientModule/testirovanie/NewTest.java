package testirovanie;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	public WebDriver driver;

	@Test
	public void main() throws InterruptedException {
		driver.get("https://www.computeruniverse.ru");
		Thread.sleep(4000);
		// driver.get("http://newtours.demoaut.com");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "/Users/iliashebanov/Dropbox/JAVA/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
