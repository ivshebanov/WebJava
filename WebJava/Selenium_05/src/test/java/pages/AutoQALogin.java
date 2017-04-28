package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoQALogin {
    WebDriver driver;
    By userName = By.id("mailbox__login");
    By password = By.id("mailbox__password");
    By login = By.id("mailbox__auth__button");

    public AutoQALogin(WebDriver driver) {
        this.driver = driver;
    }

    private void setUserName(String strUserName) {
        driver.findElement(userName).sendKeys(strUserName);
    }

    private void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    private void clickLogin() {
        driver.findElement(login).click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     *
     * @param strUserName
     * @param strPasword
     * @return
     */
    public void loginToAutoQA(String strUserName, String strPasword) {
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();
    }
}
