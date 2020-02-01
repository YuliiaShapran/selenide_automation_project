package PetclinicHomeworks.UItests;

import PetclinicHomeworks.Configurations.UIConfiguration;
import PetclinicHomeworks.UItests.PageObjects.PetTypePage;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


@Epic("Petclinic UI Tests")
@Feature("Pet Types")
public class AddNewPetTypeTests extends UIConfiguration {


    @TmsLink("1020")
    @Issue("BUG-120")
    @Story("Open Pet Types Page")
    @Test(description = "Open Pet Types Page")
    public void petTypesPageIsOpenedTest() {
        goToPetTypesPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/pettypes");
    }


    @TmsLink("1021")
    @Issue("BUG-121")
    @Story("New Pet Types Field is Appear")
    @Test(description = "New Pet Types Field is Appear")
    public void petTypesFieldIsAppearedTest(){
        goToPetTypesPage().clickAddPetButton();
        PetTypePage petTypePage = new PetTypePage();
        petTypePage.petTypesFieldIsAppeared();
    }



    @TmsLink("1022")
    @Issue("BUG-122")
    @Story("Returning to the home page")
    @Test(description = "Returning to the home page")
    public void homeButtonTest(){
        goToPetTypesPage().clickHomeButton();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/welcome");
    }



    @TmsLink("1023")
    @Issue("BUG-123")
    @Story("Creating New Pet Type")
    @Test(description = "Creating New Pet Type")
    public void positiveAddPetTypesTest(){
        PetTypePage petTypePage = goToPetTypesPage();
        ElementsCollection before = petTypePage.rowsInTable();
        petTypePage
                .clickAddPetButton()
                .setName("Cow")
                .clickSavePetTypesButton()
                .checkPage();
        ElementsCollection after = petTypePage.rowsInTable();
        assertThat(after.size()).isEqualTo(before.size()+1);
    }


    @TmsLink("1024")
    @Issue("BUG-124")
    @Story("Creating New Pet Type With Empty Type")
    @Test(description = "Creating New Pet Type With Empty Type")
    public void addPetTypeWithEmptyTypeTest(){
        PetTypePage petTypePage = goToPetTypesPage();
        ElementsCollection before = petTypePage.rowsInTable();
        petTypePage
                .clickAddPetButton()
                .setName("")
                .clickSavePetTypesButton()
                .checkPage();
        ElementsCollection after = petTypePage.rowsInTable();
        assertThat(after.size()).isEqualTo(before.size());
    }


    @TmsLink("1025")
    @Issue("BUG-125")
    @Story("Returning to the Pet Types page")
    @Test(description = "Returning to the Pet Types page")
    public void cancelButtonTest(){
        PetTypePage petTypePage  = goToPetTypesPage();
        petTypePage
                .clickEditButton()
                .editPetTypePageIsOpenedChecker()
                .clickCancelButton()
                .checkPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/pettypes");
    }


    @TmsLink("1026")
    @Issue("BUG-126")
    @Story("Pet Type is Deleted")
    @Test(description = "Pet Type is Deleted")
    public void deleteButtonTest(){
        PetTypePage petTypePage  = goToPetTypesPage();
        ElementsCollection before = petTypePage.rowsInTable();
        petTypePage
                .clickDeleteButton()
                .checkPage();
        ElementsCollection after = petTypePage.rowsInTable();
        assertThat(after.size()).isEqualTo(before.size()-1);
    }
}
