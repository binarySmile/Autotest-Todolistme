package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.pages.MainPage;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.ListPanel;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.MyList;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ManagerPanelTest extends BaseTest {

    @Test(description = "Create core")
    public void createNewList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        assertTrue(myList.getByName(getlistName()).isDisplayed());
    }

    @Test(description = "Create todo in new core")
    public void createNewTodoInMyList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        assertTrue(myList.getByName(getlistName()).isDisplayed());
        mainPage.createNewTodo(gettodoInMyList());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        listPanel.completeTodo(gettodoInMyList());
        assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
    }
}
