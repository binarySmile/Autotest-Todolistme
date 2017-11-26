package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.TomorrowPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertFalse;

public class TomorrowPanelTest extends BaseTest {

    @Test
    public void showTomorrowItemsPanel() {
        TomorrowPanel tomorrowPanel = page(TomorrowPanel.class);
        tomorrowPanel.showTomorrowItems();
        assertFalse(tomorrowPanel.getTomorrowItemPanel().isDisplayed());
    }
}
