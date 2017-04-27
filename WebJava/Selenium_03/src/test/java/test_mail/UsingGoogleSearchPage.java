package test_mail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class UsingGoogleSearchPage {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "D:\\Hotj\\WebJava\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com/");
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);
        page.searchFor("Cheese");
    }
}