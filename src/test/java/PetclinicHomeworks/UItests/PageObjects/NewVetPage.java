package PetclinicHomeworks.UItests.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class NewVetPage {

    String firstNameLocator = "firstName";
    String lastNameLocator = "lastName";


    @Step("First Name is Set")
    public NewVetPage setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }


    @Step("Last Name is Set")
    public NewVetPage setLastName(String name) {
        $("#lastName").setValue(name);
        return this;
    }


    @Step("Type is Set")
    public NewVetPage setTypeField(int type) {
        $(By.xpath("//*[@id='specialties']")).click();
        $(By.xpath("//*[@value='"+type+": Object']")).click();
        return this;
    }


    @Step("First Name is clear")
    public void clearFirstNameField(){
        $(By.id(firstNameLocator)).sendKeys(Keys.BACK_SPACE);
    }


    @Step("Last Name is clear")
    public void clearLastNameField(){
        $(By.id(lastNameLocator)).sendKeys(Keys.BACK_SPACE);
    }


    @Step("Add button click")
    public VetsPage clickSubmitVetCreation() {
        $(By.xpath("//button[@type='submit']")).click();
        return new VetsPage();
    }

    @Step("Back button click")
    public VetsPage clickBackButton(){
        $(By.xpath("//button[@type='button']")).click();
        return new VetsPage();
    }
}
