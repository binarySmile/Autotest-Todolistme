package com.github.binarySmile.todolistmeautotest.core.pageobjects.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @FindBy(id = "mytitle")
    private SelenideElement todoListTitle;

    @FindBy(id = "sortbutton")
    private SelenideElement sortButton;

    @Step("Create todo: {name}")
    public void createNewTodo(String newTodoName) {
        todoInput.val(newTodoName).pressEnter();
    }

    @Step("Create core: {name}")
    public void createNewList(String listName) {
        addNewTodoListButton.click();
        newNameInput.val(listName).pressEnter();
    }

    @Step("Create category: {name}")
    public void createNewCategory(String categoryName) {
        addNewCategoryButton.click();
        newNameInput.shouldBe(visible).val(categoryName).pressEnter();
    }

    public SelenideElement todoListTitleName() {
        return todoListTitle;
    }

    public SelenideElement getByName(String todoListTitleName) {
        return todoListTitle.shouldHave(text(todoListTitleName));
    }

    public SelenideElement sortButton() {
        return sortButton;
    }

    public SelenideElement addListButton() {
        return addNewTodoListButton;
    }

    public SelenideElement addCategoryButton() {
        return addNewCategoryButton;
    }
}

