package autotest.todo.list.tests;


import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.managerPanel.MyList;
import autotest.todo.list.panels.todoPanel.ListPanel;
import autotest.todo.list.panels.tomorrowPanel.TomorrowPanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class TomorrowPanelTest extends BaseTest{

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void tomorrowPanel(){
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewList(getlistName());
        MyList myList = page(MyList.class);
        assertTrue(myList.getByName(getlistName()).isDisplayed());
        mainPage.createNewTodo(gettodoInMyList());
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        listPanel.completeTodo(gettodoInMyList());
        assertTrue(listPanel.getByName(gettodoInMyList()).isDisplayed());
        TomorrowPanel tomorrowPanel = page(TomorrowPanel.class);
        //tomorrowPanel.moveTodoToTomorrow());
        //assertTrue(tomorrowPanel.);!!!
    }

    @Test
    public void showTomorrowItemsPanel(){
        TomorrowPanel tomorrowPanel = page(TomorrowPanel.class);
        tomorrowPanel.showTomorrowItems();
        //assertTrue()!!!!

    }
}
