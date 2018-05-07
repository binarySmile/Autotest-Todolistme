package com.github.binarySmile.todolistmeautotest.core.pageobjects.panels;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class DonePanel implements Panel {

    @FindBy(xpath = "//ul[@id='mydonetodos']/li")
    private ElementsCollection doneList;

    public ElementsCollection getList() {
        return doneList.shouldHaveSize(0);
    }

    public SelenideElement getByName(String todoName) {
        return doneList.filter(text(todoName)).shouldHaveSize(1).first();
    }

    @Step("Delete todo: {name}")
    public void deleteTodo(String todoName) {
        getByName(todoName).hover();
        getByName(todoName).click();
        getByName(todoName).$x("//span").should(visible);
        getByName(todoName).findElement(By.cssSelector(".delete")).click();
    }
}

