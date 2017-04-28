package testMailPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Администратор on 28.04.2017.
 */
public class Test_01 {
    By usernameLocator = By.id("mailbox__login");
    By passwordLocator = By.id("mailbox__password");
    By loginButtonLocator = By.id("mailbox__auth__button");

    private final WebDriver driver;

    public Test_01(WebDriver driver) {
        this.driver = driver;

        if (!"Mail.Ru: почта, поиск в интернете, новости, игры".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    private Test_01 typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private Test_01 typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    private HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }

    public Test_01 submitLoginExpectingFailure() {
        driver.findElement(loginButtonLocator).submit();
        return new Test_01(driver);
    }

    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    private class HomePage {
        private final WebDriver driver;

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }
    }
}
