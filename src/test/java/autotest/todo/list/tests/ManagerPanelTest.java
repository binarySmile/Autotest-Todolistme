package autotest.todo.list.tests;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.managerPanel.MyList;
import autotest.todo.list.panels.todoPanel.ListPanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;


public class ManagerPanelTest extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void createNewList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        assertTrue(myList.getByName(getlistName()).isDisplayed());
    }

    @Test
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
