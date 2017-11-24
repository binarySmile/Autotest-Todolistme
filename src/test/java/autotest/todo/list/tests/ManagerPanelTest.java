package autotest.todo.tests;


import autotest.todo.core.pageObjects.pages.MainPage;
import autotest.todo.core.pageObjects.panels.managerPanel.MyList;
import autotest.todo.core.pageObjects.panels.todoPanel.ListPanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ManagerPanelTest extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

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
