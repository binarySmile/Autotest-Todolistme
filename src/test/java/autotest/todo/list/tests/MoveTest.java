package autotest.todo.list.tests;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.categoryPanel.MyCategory;
import autotest.todo.list.panels.managerPanel.MyList;
import autotest.todo.list.panels.todoPanel.ListPanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class MoveTest extends BaseTest{

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
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
        MyCategory myCategory = page(MyCategory.class);
        assertTrue(myCategory.getByName(getcategoryName()).isDisplayed());
        myList.moveTodo(getlistName(), getcategoryName());
        assertEquals(myCategory.containerOfCategory(getlistName()), getcategoryName());    }
}
