package autotest.todo.list.tests;


import autotest.todo.list.panels.tomorrowPanel.TomorrowPanel;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertFalse;

public class TomorrowPanelTest extends BaseTest{

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void showTomorrowItemsPanel(){
        TomorrowPanel tomorrowPanel = page(TomorrowPanel.class);
        tomorrowPanel.showTomorrowItems();
        assertFalse(tomorrowPanel.getTomorrowItemPanel().isDisplayed());

    }
}
