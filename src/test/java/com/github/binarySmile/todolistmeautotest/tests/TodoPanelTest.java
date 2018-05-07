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
        mainPage.createNewTodo(getTodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(getTodoName()).isDisplayed());
    }

    @Test(description = "Complete todo")
    public void completeTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(getTodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(getTodoName()).isDisplayed());
        listPanel.completeTodo(getTodoName());
        DonePanel donePanel = page(DonePanel.class);
        assertTrue(donePanel.getByName(getTodoName()).isDisplayed());
    }

    @Test(description = "Delete todo")
    public void deleteTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(getTodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(getTodoName()).isDisplayed());
        listPanel.completeTodo(getTodoName());
        DonePanel donePanel = page(DonePanel.class);
        assertTrue(donePanel.getByName(getTodoName()).isDisplayed());
        donePanel.deleteTodo(getTodoName());
        assertTrue(donePanel.getList().isEmpty());
    }
}

