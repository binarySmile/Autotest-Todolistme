package autotest.todo.tests;


import autotest.todo.core.pageObjects.panels.todoPanel.ListPanel;
import org.testng.annotations.Test;

import static autotest.todo.core.utils.Util.firstSort;
import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortTest extends BaseTest {

    @Test(description = "Sort todo core")
    public void sortTodosList() {
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(firstSort(listPanel.alphabeticalSortList()));
        assertFalse(listPanel.randomSortList().equals(listPanel.alphabeticalSortList()));
        assertFalse(listPanel.top3SortList().equals(listPanel.alphabeticalSortList()));
        assertFalse(listPanel.normalSortList().equals(listPanel.alphabeticalSortList()));
    }
}
