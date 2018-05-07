package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.ListPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static com.github.binarySmile.todolistmeautotest.core.utils.Util.firstSort;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortTest extends BaseTest {

    @Test(description = "Sort todo")
    public void sortTodosList() {
        ListPanel listPanel = page(ListPanel.class);
        assertTrue(firstSort(listPanel.alphabeticalSortList()));
        assertFalse(listPanel.randomSortList().equals(listPanel.alphabeticalSortList()));
        assertFalse(listPanel.top3SortList().equals(listPanel.alphabeticalSortList()));
        assertFalse(listPanel.normalSortList().equals(listPanel.alphabeticalSortList()));
    }
}
