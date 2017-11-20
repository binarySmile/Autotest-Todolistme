package autotest.todo.list.tests;

import autotest.todo.list.page.MainPage;
import autotest.todo.list.panels.categoryPanel.MyCategory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.AssertJUnit.assertTrue;


public class CategoryPanelTest extends BaseTest {

    @BeforeTest
    public void beforeTest() throws Throwable {
        initialize();
    }

    @Test
    public void createCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewCategory(getcategoryName());
        MyCategory myCategory = page(MyCategory.class);
        assertTrue(myCategory.getByName(getcategoryName()).isDisplayed());
    }

    @Test
    public void deleteCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewCategory(getcategoryName());
        MyCategory myCategory = page(MyCategory.class);
        assertTrue(myCategory.getByName(getcategoryName()).isDisplayed());
        myCategory.deleteCategory(getcategoryName());
        assertTrue(myCategory.getMyListCategory().isEmpty());
    }
}
