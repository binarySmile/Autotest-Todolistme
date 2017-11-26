package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.pages.RemotePage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class ListInRemoteWindowTest extends BaseTest {

    @Test(description = "Open Remote core")
    public void openRemoteList() throws InterruptedException {
        RemotePage remotePage = page(RemotePage.class);
        remotePage.openRemotePage();
        assertTrue(remotePage.getListsMenu().isDisplayed());
    }
}