package com.github.binarySmile.todolistmeautotest.core;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected static final String URL = "http://todolistme.net/";
    protected static Properties DATA;
    public String titleName = "Today's Tasks";

    protected BaseTest() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
    }

    @BeforeTest
    public void initialize() throws Throwable {
        DATA = new Properties();
        FileInputStream fn = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/DATA.properties");
        DATA.load(fn);
    }

    @BeforeMethod(description = "Chrome go to todolistme.net")
    public void init() {
        open(URL);
    }

    @AfterMethod(description = "Chrome close window")
    public void dispose() {
        close();
    }

    protected String gettodoName() {
        return DATA.getProperty("TODO_NAME");
    }

    protected String getlistName() {
        return DATA.getProperty("LIST_NAME");
    }

    protected String gettodoInMyList() {
        return DATA.getProperty("TODO_NAME_IN_MY_LIST");
    }

    protected String getcategoryName() {
        return DATA.getProperty("CATEGORY_NAME");
    }
}
