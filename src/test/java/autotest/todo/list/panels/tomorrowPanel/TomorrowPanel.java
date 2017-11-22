package autotest.todo.list.panels.tomorrowPanel;


import autotest.todo.list.panels.todoPanel.ListPanel;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class TomorrowPanel extends ListPanel{

    @FindBy(id = "tomorrowtitle")
    private SelenideElement tomorrowField;

    @FindBy(id = "latertitle")
    private SelenideElement laterField;

    @FindBy(id = "tomorrowarrow")
    private SelenideElement showTomorrowItemsPanelButton;

    @FindBy(xpath = "//div[@id='tomorrowitemspanel']/ul/li/span")
    private ElementsCollection todoTomorrowList;

    public void moveTodoToTomorrow(String todoName){
       ListPanel listPanel = page(ListPanel.class);
       listPanel.getByName(todoName).dragAndDropTo(tomorrowField);
    }

    public void showTomorrowItems() {
        showTomorrowItemsPanelButton.click();
    }

    public SelenideElement getByName(String name) {
        return todoTomorrowList.filter(text(name)).shouldHaveSize(1).first();
    }
}
