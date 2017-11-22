package autotest.todo.list.tests;


import autotest.todo.list.page.PrintPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PrintTest extends BaseTest {

    @Test(description = "Open print page")
    public void printTodoList() throws InterruptedException {
        PrintPage printPage = page(PrintPage.class);
        printPage.openPrintPage();
        assertTrue(printPage.getBlanckcontrol().isDisplayed());
    }

    @Test(description = "Add new line in print page")
    public void addNewLineInPrintPage() throws InterruptedException {
        PrintPage printPage = page(PrintPage.class);
        printPage.openPrintPage();
        assertTrue(printPage.getBlanckcontrol().isDisplayed());
        printPage.addNewLine();
        assertTrue(printPage.getNewLine().isEnabled());
    }

    @Test(description = "Delete a line from print page")
    public void deleteNewLineFromPrintPage() throws InterruptedException {
        PrintPage printPage = page(PrintPage.class);
        printPage.openPrintPage();
        assertTrue(printPage.getBlanckcontrol().isDisplayed());
        printPage.addNewLine();
        assertTrue(printPage.getNewLine().isEnabled());
        printPage.deleteNewLine();
        assertFalse(printPage.getNewLine().exists());
    }
}