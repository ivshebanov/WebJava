package test_mail;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class StepsinBook extends ScenarioSteps {
    public StepsinBook(Pages pages) {
        super(pages);
    }

    public BookPage getPageBook() {
        return getPages().currentPageAt(BookPage.class);
    }

    @Step
    public void getMain(String url) {
        getPageBook().getMainPage(url);
    }

    @Step
    public void AllBooks() {
        getPageBook().allBooks();
    }

    @Step
    public void search() {
        getPageBook().search("Книга");
    }

    @Step
    public void catalog() {
//        getPageBook().catalog();
    }
}