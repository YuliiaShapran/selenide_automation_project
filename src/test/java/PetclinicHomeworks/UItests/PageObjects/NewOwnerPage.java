package PetclinicHomeworks.UItests.PageObjects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class NewOwnerPage {

    String phoneLocator = "telephone";
    String firstNameLocator = "firstName";
    String lastNameLocator = "lastName";
    String addressLocator = "address";
    String cityLocator = "city";


    @Step("First Name is Set")
    public NewOwnerPage setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }


    @Step("Last Name is Set")
    public NewOwnerPage setLastName(String name) {
        $("#lastName").setValue(name);
        return this;
    }


    @Step("Address is Set")
    public NewOwnerPage setAddress(String address) {
        $("#address").setValue(address);
        return this;
    }


    @Step("City is Set")
    public NewOwnerPage setCity(String city) {
        $("#city").setValue(city);
        return this;
    }


    @Step("Telephone is Set")
    public NewOwnerPage setTelephone(String telephone) {
        $(By.id("telephone")).setValue(telephone);
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


    @Step("Telephone is clear")
    public void clearTelephoneField(){
        $(By.id(phoneLocator)).sendKeys(Keys.BACK_SPACE);
    }


    @Step("Address is clear")
    public void clearAddressField(){
        $(By.id(addressLocator)).sendKeys(Keys.BACK_SPACE);
    }


    @Step("City is clear")
    public void clearCityField(){
        $(By.id(cityLocator)).sendKeys(Keys.BACK_SPACE);
    }


    @Step("Add button click")
    public OwnersPage clickSubmitOwnerCreation() {
        $(By.xpath("//*[text()='Add Owner']")).click();
        return new OwnersPage();
    }


    @Step("Back button click")
    public OwnersPage clickBackButton(){
        $(By.xpath("//*[text()='Back']")).shouldBe(Condition.enabled).click();
        return new OwnersPage();
    }


}
