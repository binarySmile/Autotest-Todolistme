package autotest.todo.list.page;


import autotest.todo.list.tests.BaseTest;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

import static com.sun.corba.se.impl.logging.OMGSystemException.get;

public class RemotePage extends BaseTest {

    @FindBy(id = "remotebutton")
    private SelenideElement remoteButton;

    @FindBy(id="listmenucontainer")
    public SelenideElement listMenuContainer;

    @Step("Go from mainpage to remotepage")
    public void openRemotePage() throws InterruptedException {
        WebDriver driver = WebDriverRunner.getWebDriver();
        get(URL);
        String mainPage = driver.getWindowHandle();
        remoteButton.click();
        Set<String> windows = driver.getWindowHandles();
        for (String child : windows) {
            if (!mainPage.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                Thread.sleep(3000);
            }
        }
    }

    public SelenideElement getListMenuContainer(){
        return listMenuContainer;
    }
}


