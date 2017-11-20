package autotest.todo.list.panels.managerPanel;


import autotest.todo.list.panels.Panel;
import autotest.todo.list.panels.categoryPanel.MyCategory;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class MyList implements Panel {

    @FindBy(xpath = "//div[@id='lists']//li//li")
    private ElementsCollection listManager;

    @Override
    public ElementsCollection getList() {
        return listManager;
    }

    @Override
    public SelenideElement getByName(String listName) {
        return listManager.filter(text(listName)).shouldHaveSize(1).last();
    }

    public void moveTodo(String listName, String categoryName) {
        getByName(listName).dragAndDropTo(page(MyCategory.class).getByName(categoryName));
    }
}


