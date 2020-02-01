package PetclinicHomeworks.UItests;

import PetclinicHomeworks.Configurations.UIConfiguration;
import PetclinicHomeworks.UItests.PageObjects.NewVetPage;
import PetclinicHomeworks.UItests.PageObjects.VetsPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Petclinic UI Tests")
@Feature("Veterinarians")
public class AddNewVeterinarianTests extends UIConfiguration {

    @TmsLink("1011")
    @Issue("BUG-111")
    @Story("Open Veterinarians Page")
    @Test(description = "Open Veterinarians Page")
    public void vetPageIsOpenedTest() {
        goToVetsPage()
                .checkPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/vets");
    }


    @TmsLink("1012")
    @Issue("BUG-112")
    @Story("Returning to the Veterinarians page")
    @Test(description = "Returning to the Veterinarians page")
    public void backButtonTest() {
        goToVetsPage()
                .clickAddNewVetButton()
                .clickBackButton()
                .checkPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/vets");
    }


    @TmsLink("1013")
    @Issue("BUG-113")
    @Story("Returning to the home page")
    @Test(description = "Returning to the home page")
    public void homeButtonTest(){
        goToVetsPage()
                .clickHomeButton();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/welcome");
    }


    @TmsLink("1014")
    @Issue("BUG-114")
    @Story("Creating New Vet")
    @Test(description = "Creating New Vet")
    public void positiveAddVetTest(){
        VetsPage vetsPage = goToVetsPage();
        int before = vetsPage.rowInTable().size();
        NewVetPage newVetPage =  vetsPage.clickAddNewVetButton();

        newVetPage
                .setFirstName("Andrew")
                .setLastName("Malevich")
                .setTypeField(2)
                .clickSubmitVetCreation()
                .checkPage();
        int after = vetsPage.rowInTable().size();
        assertThat(after).isEqualTo(before + 1);
    }


    @TmsLink("1015")
    @Issue("BUG-115")
    @Story("Creating New Vet Without Type")
    @Test(description = "Creating New Vet Without Type")
    public void positiveAddVetWithoutTypeTest(){
        VetsPage vetsPage = goToVetsPage();
        int before = vetsPage.rowInTable().size();
        NewVetPage newVetPage =  vetsPage.clickAddNewVetButton();

        newVetPage
                .setFirstName("Andrew")
                .setLastName("Malevich")
                .clickSubmitVetCreation()
                .checkPage();
        int after = vetsPage.rowInTable().size();
        assertThat(after).isEqualTo(before + 1);
    }


    @TmsLink("1016")
    @Issue("BUG-116")
    @Story("One Symbol Validation of the First Name Field")
    @Test(description = "One Symbol Validation of the First Name Field")
    public void OneLetterInFirstNameFieldTest(){
        goToVetsPage().clickAddNewVetButton();
        NewVetPage newVetPage = new NewVetPage();

        newVetPage
                .setFirstName("A")
                .setLastName("Malevich")
                .setTypeField(2);

        errorTextCheck("First name must be at least 2 characters long");
    }



    @TmsLink("1017")
    @Issue("BUG-117")
    @Story("Validation of the Empty First Name Field")
    @Test(description = "Validation of the Empty First Name Field")
    public void emptyFirstNameFieldTest(){
        goToVetsPage().clickAddNewVetButton();
        NewVetPage newVetPage = new NewVetPage();
        newVetPage
                .setFirstName("A")
                .clearFirstNameField();

        errorTextCheck("First name is required");
    }



    @TmsLink("1018")
    @Issue("BUG-118")
    @Story("One Symbol Validation of the Last Name Field")
    @Test(description = "One Symbol Validation of the Last Name Field")
    public void OneLetterInLastNameFieldTest(){
        goToVetsPage().clickAddNewVetButton();
        NewVetPage newVetPage = new NewVetPage();

        newVetPage
                .setFirstName("Andrew")
                .setLastName("M")
                .setTypeField(2);

        errorTextCheck("Last name must be at least 2 characters long");
    }



    @TmsLink("1019")
    @Issue("BUG-119")
    @Story("Validation of the Empty Last Name Field")
    @Test(description = "Validation of the Empty Last Name Field" )
    public void emptyLastNameFieldTest(){
        goToVetsPage().clickAddNewVetButton();
        NewVetPage newVetPage = new NewVetPage();
        newVetPage
                .setLastName("M")
                .clearLastNameField();

        errorTextCheck("Last name is required");
    }
}
