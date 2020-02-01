package PetclinicHomeworks.UItests.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PetTypePage {


    @Step("Pet Type Name is Set")
    public PetTypePage setName(String name) {
        $(By.id("#name")).setValue(name);
        return this;
    }

    @Step("Add button click")
    public PetTypePage clickAddPetButton(){
        $(By.xpath("//*[normalize-space(text())='Add']")).click();
        return this;
    }

    @Step("Pet Type Field is Appeared")
    public void petTypesFieldIsAppeared(){
        $(By.xpath("//h2[text()='New Pet Type']")).shouldBe(Condition.appear);
    }


    @Step("Home page is opened")
    public void clickHomeButton(){
        $(By.xpath("//button[text()='Home']")).click();
    }


    @Step("Getting the list of Pet Types")
    public ElementsCollection rowsInTable(){
        return $$(By.xpath("//tbody/tr"));
    }


    @Step("Save button click")
    public PetTypePage clickSavePetTypesButton(){
        $(By.xpath("//*[@class='btn btn-default'][text()='Save']")).click();
        return this;
    }


    @Step("Edit button click")
    public PetTypePage clickEditButton(){
        $(By.xpath("//tr[1]/td[2]/button[1]")).click();
        return this;
    }


    @Step("Edit Pet Type Page is opened")
    public PetTypePage editPetTypePageIsOpenedChecker(){
        $(By.xpath("//*[text()='Edit Pet Type']")).shouldBe(Condition.appear);
        return this;
    }

    @Step("Cancel button click")
    public PetTypePage clickCancelButton(){
        $(By.xpath("//*[text()='Cancel']")).click();
        return this;
    }

    @Step("Delete button click")
    public PetTypePage clickDeleteButton(){
        $(By.xpath("//tbody/tr[last()]/td/button[text()='Delete']")).click();
        return this;
    }


    @Step("Checking of the Current Pet Types Page by Title")
    public PetTypePage checkPage() {
        $("h2").shouldHave(Condition.exactText("Pet Types"));
        return this;
    }
}
