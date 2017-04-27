package test_mail;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {

    @FindBy(id = "mailbox__login")
    private WebElement emailField;
    @FindBy(id = "mailbox__password")
    private WebElement passwordField;
    @FindBy(id = "mailbox__auth__button")
    private WebElement submitButton;
    @FindBy(id = "error_block")
    private WebElement errorText;

    public RegistrationPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public RegistrationPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
