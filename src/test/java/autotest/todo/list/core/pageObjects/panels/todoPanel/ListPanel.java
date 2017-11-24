package autotest.todo.core.pageObjects.panels.todoPanel;

import autotest.todo.core.pageObjects.pages.MainPage;
import autotest.todo.core.pageObjects.panels.Panel;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;


public class ListPanel extends MainPage implements Panel {

    @FindBy(xpath = "//ul[@id='mytodos']//li")
    private ElementsCollection todosList;

    @FindBy(xpath = "//a[@id='sort0']")
    private SelenideElement normal;

    @FindBy(xpath = "//a[@id='sort2']")
    private SelenideElement random;

    @FindBy(xpath = "//a[@id='sort1']")
    private SelenideElement alphabetical;

    @FindBy(xpath = "//a[@id='sort3']")
    private SelenideElement top3;

    @Override
    public ElementsCollection getList() {
        return todosList;
    }

    @Override
    public SelenideElement getByName(String todoName) {
        return todosList.filter(text(todoName)).shouldHaveSize(1).last();
    }

    @Step("Complete todo: {name}")
    public void completeTodo(String todoName) {
        getByName(todoName).$("input").click();
    }


    public ArrayList<String> normalSortList() {
        sortButton().hover();
        normal.click();
        return new ArrayList <String>(todosList.texts());
    }

    public ArrayList<String> alphabeticalSortList() {
        sortButton().hover();
        alphabetical.click();
        return new ArrayList <String>(todosList.texts());
    }

    public ArrayList<String> randomSortList() {
        sortButton().hover();
        random.click();
        return new ArrayList <String>(todosList.texts());
    }

    public ArrayList<String> top3SortList() {
        sortButton().click();
        top3.click();
        return new ArrayList <String>(todosList.texts());
    }
}
