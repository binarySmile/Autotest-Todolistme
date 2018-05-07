package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.pages.MainPage;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.CategoryPanel;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.ListPanel;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.MyList;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class MoveTest extends BaseTest {

    @Test(description = "Move list to category")
    public void moveTodoListToCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getListName());
        MyList myList = page(MyList.class);
        assertTrue(myList.getByName(getListName()).isDisplayed());
        mainPage.createNewTodo(getTodoInMyList());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(getTodoInMyList()).isDisplayed());
        listPanel.completeTodo(getTodoInMyList());
        assertTrue(listPanel.getByName(getTodoInMyList()).isDisplayed());
        mainPage.createNewCategory(getCategoryName());
        CategoryPanel myCategory = page(CategoryPanel.class);
        assertTrue(myCategory.getByName(getCategoryName()).isDisplayed());
        myList.moveTodo(getListName());
        assertTrue(myList.getByName(getListName()).isDisplayed());
    }
}
