package autotest.todo.list.tests;


import autotest.todo.list.page.RemotePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ListInRemoteWindowTest extends BaseTest {

    @Test(description = "Open Remote list")
    public void openRemoteList() throws InterruptedException {
        RemotePage remotePage = page(RemotePage.class);
        remotePage.openRemotePage();
        assertTrue(remotePage.getListMenuContainer().isDisplayed());
    }
}