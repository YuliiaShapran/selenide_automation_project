package PetclinicHomeworks.Configurations;

import PetclinicHomeworks.UItests.PageObjects.OwnersPage;
import PetclinicHomeworks.UItests.PageObjects.PetTypePage;
import PetclinicHomeworks.UItests.PageObjects.SpecialtiesPage;
import PetclinicHomeworks.UItests.PageObjects.VetsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;

public class UIConfiguration {
     static {
        Configuration.baseUrl = "http://139.59.149.247:8000/petclinic";
//         SelenideLogger
    }

    protected OwnersPage goToOwnersPage(){
        open("/owners");
        return new OwnersPage();
    }

    protected VetsPage goToVetsPage() {
        open("/vets");
        return new VetsPage();
    }

    protected PetTypePage goToPetTypesPage() {
        open("/pettypes");
        return new PetTypePage();
    }

    protected SpecialtiesPage goToSpecialtiesPage() {
        open("/specialties");
        return new SpecialtiesPage();
    }

    public void checkCurrentUrl(String expectedUrl){
        assertEquals(url(), expectedUrl);
    }

    @Step
    public void errorTextCheck(String errorName){
        $(".help-block").shouldHave(Condition.exactText(errorName));
    }


}
