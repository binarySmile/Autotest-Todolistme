package com.github.binarySmile.todolistmeautotest.core.pageobjects.panels;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class MyList implements Panel {

    @FindBy(xpath = "//div[@id='lists']//li//li")
    private ElementsCollection listManager;

    @FindBy(xpath = "//*[@id=mylist_4]")
    private ElementsCollection myListInCategory;

    @FindBy(css = "#container_1")
    private SelenideElement myListCategory;

    public ElementsCollection getList() {
        return listManager;
    }

    public SelenideElement getByName(String listName) {
        return listManager.filter(text(listName)).shouldHaveSize(1).last();
    }

    @Step("Move core to category")
    public void moveTodo(String listName) {
        getByName(listName).dragAndDropTo(myListCategory);
    }
}

