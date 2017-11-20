package autotest.todo.list.panels.categoryPanel;


import autotest.todo.list.panels.Panel;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class MyCategory implements Panel {

    @FindBy(xpath = "//div[@id='lists']//li")
    private ElementsCollection listCategory;

    @FindBy(xpath = "//*[@id=mycategories]")
    private ElementsCollection myListCategory;

    @Override
    public ElementsCollection getList() {
        return listCategory;
    }

    @Override
    public SelenideElement getByName(String categoryName) {
        return listCategory.filter(text(categoryName)).shouldHaveSize(1).last();
    }

    public void deleteCategory(String categoryName) {
        SelenideElement element = getByName(categoryName);
        deleteCategory(element.hover());
    }

    public void deleteCategory(SelenideElement element) {
        int initialCategorySize = listCategory.size();
        element.$(".delete").click();
        listCategory.shouldHave(CollectionCondition.size(initialCategorySize-1));
    }

    public ElementsCollection getMyListCategory(){
        return myListCategory;
    }

    public String containerOfCategory(String listName) {
        return getByName(listName).$x("//*[@id=container_1]/li").getText();
    }
}