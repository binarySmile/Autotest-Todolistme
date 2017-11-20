package autotest.todo.list.tests;


import autotest.todo.list.page.MainPage;
import autotest.todo.list.page.PrintPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class PrintTest extends BaseTest {

    @Test
    public void printTodoList() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createPagePrint();
        PrintPage printPage = page(PrintPage.class);
        assertTrue(printPage.getPrintPage().isDisplayed());
    }
}