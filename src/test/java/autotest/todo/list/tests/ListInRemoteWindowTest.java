package autotest.todo.list.tests;


import autotest.todo.list.page.MainPage;
import autotest.todo.list.page.RemotePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ListInRemoteWindowTest extends BaseTest {

    @Test
    public void openList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createListInRemoteWindow();
        RemotePage remotePage = page(RemotePage.class);
        assertTrue(remotePage.getRemotePage().isDisplayed());
    }
}
