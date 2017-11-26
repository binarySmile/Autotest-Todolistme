package com.github.binarySmile.todolistmeautotest.core.pageobjects.panels;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exist;

public class TomorrowPanel {

    @FindBy(css = "#tomorrowarrow")
    private SelenideElement showTomorrowItemsPanelButton;

    @FindBy(xpath = "//*[@id=tomorrowitemspanel]")
    private SelenideElement tomorrowItemPanel;

    @Step("Click button show tomorrow items")
    public void showTomorrowItems() {
        showTomorrowItemsPanelButton.should(exist);
        showTomorrowItemsPanelButton.click();
    }

    public SelenideElement getTomorrowItemPanel() {
        return tomorrowItemPanel;
    }
}

