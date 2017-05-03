package testi_Sele_testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testi_Sele_testNG {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@Test
	public void main() throws InterruptedException {
		String userlogin = "@mail.ru";
		String usrePassword = "";
		driver.get("http://www.mail.ru");
		driver.findElement(By.id("mailbox__login")).clear();
		driver.findElement(By.id("mailbox__login")).sendKeys(userlogin);
		driver.findElement(By.id("mailbox__password")).clear();
		driver.findElement(By.id("mailbox__password")).sendKeys(usrePassword);
		// ждём появления кнопки на "недозагруженной" странице
		WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mailbox__auth__button")));
		button.click();// кликаем
		wait.until(ExpectedConditions.stalenessOf(button));// ждём исчезновения
															// кнопки, то есть
															// "выгрузки"
															// страницы
		WebElement button1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[1]/div/div/div/span/i[3]")));		
		String checkIn = button1.getText();
		Assert.assertEquals(checkIn, userlogin);
		String napisPis = "html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[6]/div[1]/div/div[1]/div/div/div/div[2]/div/a/span";
		WebElement button2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(napisPis)));
		button2.click();
		driver.findElement(By.cssSelector("textarea.js-input.compose__labels__input")).clear();
	    driver.findElement(By.cssSelector("textarea.js-input.compose__labels__input")).sendKeys("ivshebanov@gmail.com");
	    driver.findElement(By.cssSelector("div.js-multi-attach.compose-attachments__item > div.compose-label.compose-label_btn > span.compose-label__text")).click();
	    driver.findElement(By.cssSelector("i.file-icon.file-icon_type_folder")).click();
	    driver.findElement(By.cssSelector("div.b-thumb__image")).click();
	    driver.findElement(By.cssSelector("div.b-layer__controls > button.btn.btn_main")).click();
	    driver.findElement(By.xpath("//html/body/div[2]/div/div[5]/div/div/div/div/div/div/div/div/div/div/div/div/div/div[6]/div[1]/div/div[2]/div/div[3]/div/div[2]/div[1]/div/span")).click();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/chromedriver/2.29/bin/chromedriver");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
