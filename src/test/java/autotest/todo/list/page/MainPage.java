package autotest.todo.list.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    @FindBy(id = "newtodo")
    private SelenideElement todoInput;

    @FindBy(id = "addlist")
    private SelenideElement addNewTodoListButton;

    @FindBy(css = "#updatebox")
    private SelenideElement newNameInput;

    @FindBy(id = "adddivider")
    private SelenideElement addNewCategoryButton;

    @FindBy(id = "mytitle")
    private SelenideElement todoListTitle;

    @FindBy(id = "sortbutton")
    private SelenideElement sortButton;


    @Step("Create todo: {name}")
    public void createNewTodo(String todoName) {
        todoInput.val(todoName).pressEnter();
    }

    @Step("Create list: {name}")
    public void createNewList(String listName) {
        addNewTodoListButton.click();
        newNameInput.val(listName).pressEnter();
    }

    @Step("Create category: {name}")
    public void createNewCategory(String categoryName) {
        addNewCategoryButton.click();
        newNameInput.shouldBe(visible).val(categoryName).pressEnter();
    }

    public SelenideElement todoInput(){
        return todoInput.should(exist);
    }

    public SelenideElement todoListTitleName() {

        return todoListTitle;
    }

    public SelenideElement getByName(String todoListTitleName) {
        return todoListTitle.shouldHave(text(todoListTitleName));
    }

    public SelenideElement sortButton() {
        return sortButton.should(exist);
    }

    public SelenideElement addListButton() {
        return addNewTodoListButton.should(exist);
    }

    public SelenideElement addCategoryButton() {
        return addNewCategoryButton.should(exist);
    }
}
