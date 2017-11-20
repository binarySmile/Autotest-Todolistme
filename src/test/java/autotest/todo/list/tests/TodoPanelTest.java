package autotest.todo.list.tests;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.todoPanel.DonePanel;
import autotest.todo.list.panels.todoPanel.ListPanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;


public class TodoPanelTest extends BaseTest{

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void createTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(gettodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoName()).isDisplayed());
    }

    @Test
    public void completeTodo() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewTodo(gettodoName());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoName()).isDisplayed());
        listPanel.completeTodo(gettodoName());
        DonePanel donePanel = page(DonePanel.class);
        assertTrue(donePanel.getByName(gettodoName()).isDisplayed());
    }

    @Test
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
