package PetclinicHomeworks.UItests.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;



public class SpecialtiesPage {


    @Step("Specialty Name is Set")
    public SpecialtiesPage setName(String name) {
        $("#name").setValue(name);
        return this;
    }

    @Step("Add button click")
    public SpecialtiesPage clickAddSpecialtyButton(){
        $(By.xpath("//*[normalize-space(text())='Add']")).click();
        return this;
    }

    @Step("Save button click")
    public SpecialtiesPage clickSaveSpecialtyButton(){
        $(By.xpath("//*[normalize-space(text())='Save']")).click();
        return this;
    }

    @Step("Specialty Field is Appeared")
    public void newSpecialtyFieldIsAppeared(){
        $(By.xpath("//h2[text()='New Specialty']")).shouldBe(Condition.appear);
    }

    @Step("Home page is opened")
    public void clickHomeButton(){
        $(By.xpath("//button[text()='Home']")).click();
    }

    @Step("Getting the list of Specialties")
    public ElementsCollection rowsInTable(){
        return $$(By.xpath("//tbody/tr"));
    }

    @Step("Edit button click")
    public SpecialtiesPage clickEditButton(){
        $(By.xpath("//tr[1]/td[2]/button[1]")).click();
        return this;
    }

    @Step("Edit Specialty Page is opened")
    public SpecialtiesPage editSpecialtyPageIsOpenedChecker(){
        $(By.xpath("//*[text()='Edit Specialty']")).shouldBe(Condition.appear);
        return this;
    }

    @Step("Cancel button click")
    public SpecialtiesPage clickCancelButton(){
        $(By.xpath("//*[text()='Cancel']")).click();
        return this;
    }

    @Step("Delete button click")
    public SpecialtiesPage clickDeleteButton(){
        $(By.xpath("//tbody/tr[last()]/td/button[text()='Delete']")).click();
        return this;
    }


    @Step("Checking of the Current Specialties Page by Title")
    public PetTypePage checkPage() {
        $("h2").shouldHave(Condition.exactText("Specialties"));
        return new PetTypePage();
    }
}
