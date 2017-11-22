package autotest.todo.list.tests;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.categoryPanel.MyCategory;
import autotest.todo.list.panels.managerPanel.MyList;
import autotest.todo.list.panels.todoPanel.ListPanel;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;
import static org.testng.Assert.assertTrue;

public class MoveTest extends BaseTest {


    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test(description = "Move list to category")
    public void moveTodoListToCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        AssertJUnit.assertTrue(myList.getByName(getlistName()).isDisplayed());
        mainPage.createNewTodo(gettodoInMyList());
        ListPanel listPanel = page(ListPanel.class);
        AssertJUnit.assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        listPanel.completeTodo(gettodoInMyList());
        AssertJUnit.assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        sleep(3000);
        mainPage.createNewCategory(getcategoryName());
        MyCategory myCategory = page(MyCategory.class);
        AssertJUnit.assertTrue(myCategory.getByName(getcategoryName()).isDisplayed());
        myList.moveTodo(getlistName());
        assertTrue(myList.getByName(getlistName()).isDisplayed());
    }
}
