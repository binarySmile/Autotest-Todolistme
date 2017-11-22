package autotest.todo.list.tests;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.managerPanel.MyList;
import autotest.todo.list.panels.todoPanel.ListPanel;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

public class ManagerPanelTest extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test(description = "Create list")
    public void createNewList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        AssertJUnit.assertTrue(myList.getByName(getlistName()).isDisplayed());
    }

    @Test(description = "Create todo in new list")
    public void createNewTodoInMyList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        AssertJUnit.assertTrue(myList.getByName(getlistName()).isDisplayed());
        mainPage.createNewTodo(gettodoInMyList());
        ListPanel listPanel = page(ListPanel.class);
        AssertJUnit.assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        listPanel.completeTodo(gettodoInMyList());
        AssertJUnit.assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
    }
}
