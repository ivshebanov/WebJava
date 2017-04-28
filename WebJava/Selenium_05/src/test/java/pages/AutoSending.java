package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by iliashebanov on 28.04.17.
 */
public class AutoSending {
    private WebDriver driver;
    private WebDriverWait wait;
    private By writeALetter = By.cssSelector("span.b-toolbar__btn__text.b-toolbar__btn__text_pad");
    private By emailLetter = By.cssSelector("textarea.js-input.compose__labels__input");
    private By letterSubject = By.name("Subject");
    private By contentOfTheLetter = By.xpath("//tbody/tr/td[4]/a/span[1]/span");
    private By vibor = By.cssSelector("div.compose__decoration__slider__item__inner.compose__decoration__slider__item__inner_big");
    private By sendALetter = By.xpath("//div[@id='b-toolbar__right']/div[3]/div/div[2]/div/div/span");
    private By checkScanSentEmail = By.className("message-sent__info");

    public AutoSending(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    private void setWriteALetter() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(writeALetter));
        button.click();
        wait.until(ExpectedConditions.stalenessOf(button));
    }

    private void setEmailLetter(String strEmailLetter) {
        driver.findElement(emailLetter).clear();
        driver.findElement(emailLetter).sendKeys(strEmailLetter);
    }

    private void setLetterSubject(String strLetterSubject) {
        driver.findElement(letterSubject).clear();
        driver.findElement(letterSubject).sendKeys(strLetterSubject);
    }

    private void contentOfTheLetter() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(contentOfTheLetter)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(vibor)).click();
    }

    private void toSendALetter() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(sendALetter));
        button.click();
        wait.until(ExpectedConditions.stalenessOf(button));
    }

    private void isCheckScanSentEmail(String strEmailLetter) {
        String text = driver.findElement(checkScanSentEmail).getText();
        Assert.assertEquals(strEmailLetter, text);
    }

    public void loginToAutoQA(String strEmailLetter, String strLetterSubject) {
        this.setWriteALetter();
        this.contentOfTheLetter();
        this.setEmailLetter(strEmailLetter);
        this.setLetterSubject(strLetterSubject);
        this.toSendALetter();
        this.isCheckScanSentEmail(strEmailLetter);
    }
}
