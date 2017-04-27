package test_mail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    By usernameLocator = By.id("mailbox__login");
    By passwordLocator = By.id("mailbox__password");
    By loginButtonLocator = By.id("mailbox__auth__button");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        if (!"Mail.Ru: почта, поиск в интернете, новости, игры".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    private LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    private HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }


    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    private class HomePage {
        WebDriver driver;
        public HomePage(WebDriver driver){
            this.driver = driver;
        }
    }
}
