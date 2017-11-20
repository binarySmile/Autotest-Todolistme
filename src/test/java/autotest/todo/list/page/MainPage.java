package autotest.todo.list.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(id ="printbutton")
    private SelenideElement printButton;

    @FindBy(id ="remotebutton")
    private SelenideElement remoteButton;

    @FindBy(id = "mytitle")
    private SelenideElement todoListTitle;

    @FindBy(id ="sortbutton")
    private SelenideElement sortButton;


    public void createNewTodo(String newTodoName) {

        todoInput.val(newTodoName).pressEnter();
    }

    public void createNewList(String listName) {
        addNewTodoListButton.click();
        newNameInput.val(listName).pressEnter();
    }

    public void createNewCategory(String categoryName) {
        addNewCategoryButton.click();
        newNameInput.shouldBe(visible).val(categoryName).pressEnter();
    }

    public void createPagePrint(){
        printButton.click();
    }

    public SelenideElement todoListTitleName() {

        return todoListTitle;
    }

    public SelenideElement getByName(String todoListTitleName) {
        return todoListTitle.shouldHave(text(todoListTitleName));
    }

    public void createListInRemoteWindow() {
        remoteButton.click();
    }

    public  SelenideElement sortButton(){
        return sortButton;
    }

    public SelenideElement printButton(){
        return printButton;
    }

    public SelenideElement addListButton(){
        return addNewTodoListButton;
    }

    public SelenideElement addCategoryButton(){
        return addNewCategoryButton;
    }
}
