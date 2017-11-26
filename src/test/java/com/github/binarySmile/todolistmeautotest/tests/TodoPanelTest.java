package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.pages.MainPage;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.DonePanel;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.ListPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class TodoPanelTest extends BaseTest {

    @Test(description = "Create todo")
    public void createTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(gettodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoName()).isDisplayed());
    }

    @Test(description = "Complete todo")
    public void completeTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(gettodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoName()).isDisplayed());
        listPanel.completeTodo(gettodoName());
        DonePanel donePanel = page(DonePanel.class);
        assertTrue(donePanel.getByName(gettodoName()).isDisplayed());
    }

    @Test(description = "Delete todo")
    public void deleteTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(gettodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoName()).isDisplayed());
        listPanel.completeTodo(gettodoName());
        DonePanel donePanel = page(DonePanel.class);
        assertTrue(donePanel.getByName(gettodoName()).isDisplayed());
        donePanel.deleteTodo(gettodoName());
        assertTrue(donePanel.getList().isEmpty());
    }
}

