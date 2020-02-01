package PetclinicHomeworks.UItests;

import PetclinicHomeworks.Configurations.UIConfiguration;
import PetclinicHomeworks.UItests.PageObjects.NewOwnerPage;
import PetclinicHomeworks.UItests.PageObjects.OwnersPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Petclinic UI Tests")
@Feature("Owners")
public class AddNewOwnerTests extends UIConfiguration {


    @TmsLink("1000")
    @Issue("BUG-100")
    @Story("Open Owners Page")
    @Test(description = "Open Owners List Page")
    public void ownersPageIsOpenedTest() {
        goToOwnersPage()
                .checkPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/owners");
    }


    @TmsLink("1001")
    @Issue("BUG-101")
    @Story("Returning to the Owners page")
    @Test(description = "Returning to the Owners page")
    public void backButtonTest() {
        goToOwnersPage()
                .clickAddNewOwnerButton()
                .clickBackButton()
                .checkPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/owners");
    }


    @TmsLink("1002")
    @Issue("BUG-102")
    @Story("Creating New Owner")
    @Test(description = "Creating New Owner")
    public void positiveAddNewOwnerPageTest() {
        OwnersPage ownersPage = goToOwnersPage();
        int before = ownersPage.rowInTable().size();
        NewOwnerPage newOwnerPage = ownersPage.clickAddNewOwnerButton();

        newOwnerPage
                .setFirstName("Andrew")
                .setLastName("Malevich")
                .setAddress("Naberehnaya street, 3434 house")
                .setCity("Dnipro")
                .setTelephone("1234567890")
                .clickSubmitOwnerCreation()
                .checkPage();
        int after = ownersPage.rowInTable().size();
        assertThat(after).isEqualTo(before + 1);
    }


    @TmsLink("1003")
    @Issue("BUG-103")
    @Story("Letter Validation of the Telephone Field")
    @Test(description = "Letter Validation of the Telephone Field")
    public void letterInPhoneFieldTest() {
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage
                .setFirstName("Andrew")
                .setLastName("Malevich")
                .setAddress("Naberehnaya street, 3434 house")
                .setCity("Dnipro")
                .setTelephone("telephone");

        errorTextCheck("Phone number only accept digits");
    }


    @TmsLink("1004")
    @Issue("BUG-104")
    @Story("Validation of the Empty Telephone Field")
    @Test(description = "Validation of the Empty Telephone Field")
    public void emptyTelephoneFieldTest(){
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setTelephone("2")
                .clearTelephoneField();

        errorTextCheck("Phone number is required");
    }


    @TmsLink("1005")
    @Issue("BUG-105")
    @Story("One Symbol Validation of the First Name Field")
    @Test(description = "One Symbol Validation of the First Name Field")
    public void OneLetterInFirstNameFieldTest(){
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage
                .setFirstName("A")
                .setLastName("Malevich")
                .setAddress("Naberehnaya street, 3434 house")
                .setCity("Dnipro")
                .setTelephone("1234567890");

        errorTextCheck("First name must be at least 2 characters long");
    }



    @TmsLink("1006")
    @Issue("BUG-106")
    @Story("Validation of the Empty First Name Field")
    @Test(description = "Validation of the Empty First Name Field")
    public void emptyFirstNameFieldTest(){
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setFirstName("A")
                .clearFirstNameField();

        errorTextCheck("First name is required");
    }


    @TmsLink("1007")
    @Issue("BUG-107")
    @Story("One Symbol Validation of the Last Name Field")
    @Test(description = "One Symbol Validation of the Last Name Field")
    public void OneLetterInLastNameFieldTest(){
        open("/owners/add");
        NewOwnerPage newOwnerPage = new NewOwnerPage();

        newOwnerPage
                .setFirstName("Andrew")
                .setLastName("M")
                .setAddress("Naberehnaya street, 3434 house")
                .setCity("Dnipro")
                .setTelephone("1234567890");

        errorTextCheck("Last name must be at least 2 characters long");

    }


    @TmsLink("1008")
    @Issue("BUG-108")
    @Story("Validation of the Empty Last Name Field")
    @Test(description = "Validation of the Empty Last Name Field")
    public void emptyLastNameFieldTest(){
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setLastName("M")
                .clearLastNameField();

        errorTextCheck("Last name is required");
    }


    @TmsLink("1009")
    @Issue("BUG-109")
    @Story("Validation of the Empty Address Field")
    @Test(description = "Validation of the Empty Address Field")
    public void emptyAddressFieldTest(){
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setAddress("N")
                .clearAddressField();

        errorTextCheck("Address is required");
    }


    @TmsLink("1010")
    @Issue("BUG-110")
    @Story("Validation of the Empty City Field")
    @Test(description = "Validation of the Empty City Field" )
    public void emptyCityFieldTest(){
        goToOwnersPage().clickAddNewOwnerButton();
        NewOwnerPage newOwnerPage = new NewOwnerPage();
        newOwnerPage
                .setCity("D")
                .clearCityField();

        errorTextCheck("City is required");
    }
}
