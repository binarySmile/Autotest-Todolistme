package com.github.binarySmile.todolistmeautotest.core.pageobjects.panels;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class CategoryPanel implements Panel {

    @FindBy(xpath = "//div[@id='lists']//li")
    private ElementsCollection listCategory;

    @FindBy(xpath = "//*[@id=container_1]")
    private ElementsCollection myListCategory;

    public ElementsCollection getList() {
        return listCategory;
    }

    public SelenideElement getByName(String categoryName) {
        return listCategory.filter(text(categoryName)).shouldHaveSize(1).last();
    }

    @Step("Delete category: {name}")
    public void deleteCategory(String categoryName) {
        SelenideElement element = getByName(categoryName);
        deleteCategory(element.hover());
    }

    public void deleteCategory(SelenideElement element) {
        int initialCategorySize = listCategory.size();
        element.$(".delete").click();
        listCategory.shouldHave(CollectionCondition.size(initialCategorySize - 1));
    }

    public ElementsCollection getMyListCategory() {
        return myListCategory;
    }
}