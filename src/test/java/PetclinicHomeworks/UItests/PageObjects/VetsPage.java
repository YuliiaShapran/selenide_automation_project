package PetclinicHomeworks.UItests.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VetsPage {

    @Step("Checking of the Current Vets Page by Title")
    public VetsPage checkPage() {
        $("h2").shouldHave(Condition.exactText("Veterinarians"));
        return this;
    }

    @Step("Home page is opened")
    public void clickHomeButton(){
        $(By.xpath("//button[text()='Home']")).click();
    }


    @Step("Getting the list of Vets")
    public ElementsCollection rowInTable(){
        ElementsCollection list = $$(By.xpath("//*[@id='vets']/tbody/tr"));
        return list;
    }


    @Step("Add button click")
    public NewVetPage clickAddNewVetButton() {
        $(By.xpath("//*[text()='Add Vet']")).click();
        return new NewVetPage();
    }
}
