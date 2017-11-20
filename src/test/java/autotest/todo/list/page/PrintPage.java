package autotest.todo.list.page;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class PrintPage {

   @FindBy (xpath = "/html/body")
    private SelenideElement printPage;

   public SelenideElement getPrintPage(){
       return printPage;
   }
}
