package test_mail;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends PageObject {
    @FindBy(linkText = "Все книги")
    WebElement allbooksButton;

    @FindBy(linkText = "Поиск")
    WebElement searchButton;

    @FindBy(name = "query")
    WebElement searchField;

    @FindBy(css = "button")
    WebElement searchBegin;

    public BookPage(WebDriver driver) {
        super(driver);
    }

    public void getMainPage(String url) {
        getDriver().get(url);

    }

    public void allBooks() {
        allbooksButton.click();
    }

    public void search(String searchWord) {
        searchButton.click();
        searchField.sendKeys(searchWord);
        searchBegin.click();

    }

}