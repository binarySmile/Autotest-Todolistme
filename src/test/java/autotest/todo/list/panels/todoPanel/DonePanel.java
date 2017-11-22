package autotest.todo.list.panels.todoPanel;


import autotest.todo.list.panels.Panel;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

public class DonePanel implements Panel {

    @FindBy(xpath = "//ul[@id='mydonetodos']/li")
    private ElementsCollection doneList;

    @Override
    public ElementsCollection getList() {
        return doneList;
    }

    @Override
    public SelenideElement getByName(String todoName) {
        return doneList.filter(text(todoName)).shouldHaveSize(1).first();
    }

    @Step("Delete todo: {name}")
    public void deleteTodo(String todoName) {
        getByName(todoName).hover();
        getByName(todoName).$("img").click();
    }
}

