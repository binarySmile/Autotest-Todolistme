package com.github.binarySmile.todolistmeautotest.tests;

import com.github.binarySmile.todolistmeautotest.core.BaseTest;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.pages.MainPage;
import com.github.binarySmile.todolistmeautotest.core.pageobjects.panels.CategoryPanel;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertTrue;

public class CategoryPanelTest extends BaseTest {

    @Test(description = "Create category")
    public void createCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewCategory(getCategoryName());
        CategoryPanel myCategory = page(CategoryPanel.class);
        assertTrue(myCategory.getByName(getCategoryName()).isDisplayed());
    }

    @Test(description = "Delete category")
    public void deleteCategory() {
        MainPage mainPage = page(MainPage.class);
        mainPage.createNewCategory(getCategoryName());
        CategoryPanel myCategory = page(CategoryPanel.class);
        assertTrue(myCategory.getByName(getCategoryName()).isDisplayed());
        myCategory.deleteCategory(getCategoryName());
        assertTrue(myCategory.getMyListCategory().isEmpty());
    }
}


