package Lectures;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NewOwnerPageLectures {

    public NewOwnerPageLectures setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public NewOwnerPageLectures setLastName(String name) {
        $("#lastName").setValue(name);
        return this;
    }

    public NewOwnerPageLectures setAddress(String address) {
        $("#address").setValue(address);
        return this;
    }

    public NewOwnerPageLectures setCity(String city) {
        $("#city").setValue(city);
        return this;
    }

    public NewOwnerPageLectures setTelephone(String telephone) {
        $(By.id("telephone")).setValue(telephone);
        return this;
    }

    public OwnersPageLectures clickAddNewOwnerBtn() {
        $("[type='submit']").shouldBe(Condition.enabled).click();
        return new OwnersPageLectures();
    }
}
