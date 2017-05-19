package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AutoQALogin {
    private WebDriver driver;
    private WebDriverWait wait;
    private By userName = By.id("mailbox__login");
    private By password = By.id("mailbox__password");
    private By buttonlogin = By.id("mailbox__auth__button");
    private By checkLogin = By.id("PH_user-email");

    public AutoQALogin(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    private void setUserName(String strUserName) {
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(strUserName);
    }

    private void setPassword(String strPassword) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(strPassword);
    }

    private void clickLogin() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonlogin));
        button.click();
        wait.until(ExpectedConditions.stalenessOf(button));
    }

    private void isCheckLogin(String userName) {
        String text = driver.findElement(checkLogin).getText();
        Assert.assertEquals(userName, text);
    }

    public void loginToAutoQA(String strUserName, String strPasword) {
        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();
        this.isCheckLogin(strUserName);
    }
}
