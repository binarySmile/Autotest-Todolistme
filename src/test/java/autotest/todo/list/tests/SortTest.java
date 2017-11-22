package autotest.todo.list.tests;


import autotest.todo.list.panels.todoPanel.ListPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class SortTest extends BaseTest {

    @Test(description = "Sort todo list")
    public void sortTodosList() {
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(listPanel.getList().equals(listPanel.normalSortList()));
        assertTrue(listPanel.getList().equals(listPanel.alphabeticalSortList()));
        assertTrue(listPanel.getList().equals(listPanel.randomSortList()));
        assertTrue(listPanel.getList().equals(listPanel.top3SortList()));
    }
}
