package autotest.todo.list.page;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class RemotePage  {

    @FindBy(xpath = "/html/body")
    private SelenideElement remotePage;

    public SelenideElement getRemotePage(){
        return remotePage;
    }
}
