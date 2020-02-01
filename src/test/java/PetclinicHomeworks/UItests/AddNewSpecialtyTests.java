package PetclinicHomeworks.UItests;

import PetclinicHomeworks.Configurations.UIConfiguration;
import PetclinicHomeworks.UItests.PageObjects.SpecialtiesPage;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


@Epic("Petclinic UI Tests")
@Feature("Specialties")
public class AddNewSpecialtyTests extends UIConfiguration {

    @TmsLink("1027")
    @Issue("BUG-127")
    @Story("Open Specialties Page")
    @Test(description = "Open Specialties Page")
    public void specialtiesPageIsOpenedTest() {
        goToSpecialtiesPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/specialties");
    }



    @TmsLink("1028")
    @Issue("BUG-128")
    @Story("New Specialty Field is Appear")
    @Test(description = "New Specialty Field is Appear")
    public void newSpecialtyFieldIsAppearedTest(){
        goToSpecialtiesPage().clickAddSpecialtyButton();
        SpecialtiesPage specialtiesPage = new SpecialtiesPage();
        specialtiesPage.newSpecialtyFieldIsAppeared();
    }


    @TmsLink("1029")
    @Issue("BUG-129")
    @Story("Returning to the home page")
    @Test(description = "Returning to the home page")
    public void homeButtonTest(){
        goToSpecialtiesPage().clickHomeButton();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/welcome");
    }


    @TmsLink("1030")
    @Issue("BUG-130")
    @Story("Creating New Specialty")
    @Test(description = "Creating New Specialty")
    public void positiveAddNewSpecialtyTest(){
        SpecialtiesPage specialtiesPage = goToSpecialtiesPage();
        ElementsCollection before = specialtiesPage.rowsInTable();
        specialtiesPage
                .clickAddSpecialtyButton()
                .setName("Toxicology")
                .clickSaveSpecialtyButton()
                .checkPage();
        ElementsCollection after = specialtiesPage.rowsInTable();
        assertThat(after.size()).isEqualTo(before.size()+1);
    }



    @TmsLink("1031")
    @Issue("BUG-131")
    @Story("Creating New Specialty With Empty Type")
    @Test(description = "Creating New Specialty With Empty Type")
    public void addNewSpecialtyWithEmptyTypeTest(){
        SpecialtiesPage specialtiesPage = goToSpecialtiesPage();
        ElementsCollection before = specialtiesPage.rowsInTable();
        specialtiesPage
                .clickAddSpecialtyButton()
                .setName("")
                .clickSaveSpecialtyButton()
                .checkPage();
        ElementsCollection after = specialtiesPage.rowsInTable();
        assertThat(after.size()).isEqualTo(before.size()+1);
    }



    @TmsLink("1032")
    @Issue("BUG-132")
    @Story("Returning to the Specialties page")
    @Test(description = "Returning to the Specialties page")
    public void cancelButtonTest(){
        SpecialtiesPage specialtiesPage = goToSpecialtiesPage();
        specialtiesPage
                .clickEditButton()
                .editSpecialtyPageIsOpenedChecker()
                .clickCancelButton()
                .checkPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/specialties");
    }



    @TmsLink("1033")
    @Issue("BUG-133")
    @Story("Specialty is Deleted")
    @Test(description = "Specialty is Deleted")
    public void deleteButtonTest(){
        SpecialtiesPage specialtiesPage = goToSpecialtiesPage();
        ElementsCollection before = specialtiesPage.rowsInTable();
        specialtiesPage
                .clickDeleteButton()
                .checkPage();
        ElementsCollection after = specialtiesPage.rowsInTable();
        assertThat(after.size()).isEqualTo(before.size()-1);
    }

}
