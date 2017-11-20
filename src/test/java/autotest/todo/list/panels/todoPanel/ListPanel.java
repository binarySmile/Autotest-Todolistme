package autotest.todo.list.panels.todoPanel;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.Panel;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;


public class ListPanel extends MainPage implements Panel {

    @FindBy(xpath = "//ul[@id='mytodos']//li")
    private ElementsCollection todosList;

    @Override
    public ElementsCollection getList() {
        return todosList;
    }

    @Override
    public SelenideElement getByName(String todoName) {
        return todosList.filter(text(todoName)).shouldHaveSize(1).last();
    }

    public void completeTodo(String todoName) {
        getByName(todoName).$("input").click();
    }

    @FindBy(xpath = "//a[@id='sort0']")
    private SelenideElement normal;

    @FindBy(xpath = "//a[@id='sort2']")
    private SelenideElement random;

    @FindBy(xpath = "//a[@id='sort1']")
    private SelenideElement alphabetical;

    @FindBy(xpath = "//a[@id='sort3']")
    private SelenideElement top3;

    public ElementsCollection normalSortList() {
        sortButton().hover();
        normal.click();
        return todosList;
    }

    public ElementsCollection alphabeticalSortList() {
        sortButton().hover();
        alphabetical.click();
        return todosList;
    }

    public ElementsCollection randomSortList() {
        sortButton().hover();
        random.click();
        return todosList;
    }

    public ElementsCollection top3SortList() {
        sortButton().click();
        top3.click();
        return  todosList;
    }
}
