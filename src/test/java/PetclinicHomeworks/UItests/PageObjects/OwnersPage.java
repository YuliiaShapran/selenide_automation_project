package PetclinicHomeworks.UItests.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class OwnersPage {

    @Step("Checking of the Current Owners Page by Title")
    public OwnersPage checkPage() {
        $("h2").shouldHave(Condition.exactText("Owners"));
        return this;
    }

    @Step("Getting the list of Owners")
    public ElementsCollection rowInTable(){
        ElementsCollection list = $$(By.xpath("//*[@class='table-responsive']//tbody/tr"));
        return list;
    }

    @Step("Add Owner button click")
    public NewOwnerPage clickAddNewOwnerButton() {
        $(By.xpath("//*[text()='Add Owner']")).click();
        return new NewOwnerPage();
    }
}

