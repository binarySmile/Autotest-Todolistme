package autotest.todo.list.tests;


import autotest.todo.list.page.MainPage;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;

public class OpenPageTest extends BaseTest {
    String titleName = "Today's Tasks";

    @Test
    public void checkOpenPage(){
        MainPage mainPage = page(MainPage.class);
        mainPage.todoListTitleName();
        assertTrue(mainPage.getByName(titleName).isDisplayed());
    }

    @Test
    public void availabilityOfSortButton(){
        MainPage mainPage = page(MainPage.class);
        mainPage.sortButton();
        assertTrue(mainPage.sortButton().isDisplayed());
    }

    @Test
    public void availabilityOfPrintButton(){
        MainPage mainPage = page(MainPage.class);
        mainPage.printButton();
        assertTrue(mainPage.printButton().isDisplayed());
    }

    @Test
    public void availabilityOfAddListButton() {
        MainPage mainPage = page(MainPage.class);
        mainPage.addListButton();
        assertTrue(mainPage.addListButton().isDisplayed());
    }

    @Test
    public void availabilityOfAddCategoryButton() {
        MainPage mainPage = page(MainPage.class);
        mainPage.addCategoryButton();
        assertTrue(mainPage.addCategoryButton().isDisplayed());
    }
}
