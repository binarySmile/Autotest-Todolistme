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

    @Test(description = "Move core to category")
    public void moveTodoListToCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        assertTrue(myList.getByName(getlistName()).isDisplayed());
        mainPage.createNewTodo(gettodoInMyList());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        listPanel.completeTodo(gettodoInMyList());
        assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        mainPage.createNewCategory(getcategoryName());
        CategoryPanel myCategory = page(CategoryPanel.class);
        assertTrue(myCategory.getByName(getcategoryName()).isDisplayed());
        myList.moveTodo(getlistName());
        assertTrue(myList.getByName(getlistName()).isDisplayed());
    }
}
