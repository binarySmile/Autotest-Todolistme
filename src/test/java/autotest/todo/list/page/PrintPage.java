package autotest.todo.list.page;


import autotest.todo.list.tests.BaseTest;
import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

import static com.codeborne.selenide.Condition.exist;
import static com.sun.corba.se.impl.logging.OMGSystemException.get;

public class PrintPage extends BaseTest  {

    @FindBy(id = "printbutton")
    private SelenideElement printButton;

    @FindBy(id="blankcontrol")
    private SelenideElement blackcontrol;

    @FindBy(css ="#blankcontrol > a:nth-child(1)")
    private SelenideElement addLine;

    @FindBy(css = "#blankcontrol > a:nth-child(2)")
    private SelenideElement deleteLine;

    @FindBy(xpath="//ul[@id='mytodos']//li")
    private ElementsCollection todoContainer;

    @FindBy(css ="#mytodos > li.blanktodo > span")
    private SelenideElement newLine;

    public SelenideElement printButton() {
        return printButton.should(exist);
    }

    public SelenideElement getBlanckcontrol() {
        return blackcontrol;
    }

    public ElementsCollection getList() {
        return todoContainer;
    }

    public SelenideElement getNewLine(){
        return newLine;
    }

    @Step("Add new line in print page")
    public void addNewLine() {
        int initialLineContatinerSize = todoContainer.size();
        addLine.click();
        todoContainer.shouldHave(CollectionCondition.size(initialLineContatinerSize + 1));
    }

    @Step("Delete line in print page")
    public void deleteNewLine(){
        int initialLineContatinerSize = todoContainer.size();
        deleteLine.click();
        todoContainer.shouldHave(CollectionCondition.size(initialLineContatinerSize - 1));

    }

    @Step("Go from mainpage to printpage")
    public void openPrintPage() throws InterruptedException {
        WebDriver driver = WebDriverRunner.getWebDriver();
        get(URL);
        String parent = driver.getWindowHandle();
        printButton.click();
        Set <String> windows = driver.getWindowHandles();
        for (String child : windows) {
            if (!parent.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                Thread.sleep(3000);
            }
        }
    }
}
