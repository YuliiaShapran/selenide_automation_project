package Lectures;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OwnerTestLectures {
    static {
        Configuration.baseUrl = "http://139.59.149.247:8000/petclinic";
//        Configuration.timeout = 7000;
//        Configuration.browser = "firefox";
    }

    @Test
    public void addNewOwnerTest() {
        open("/owners/add");

        $("h2").shouldHave(Condition.text("New Owner"));
        $("[type='submit']").shouldBe(Condition.disabled);

        $("#firstName").setValue("Selendie");
        $("#lastName").setValue("cool");
        $("#address").setValue("street 34");
        $("#city").setValue("Dnipro");
        $(By.id("telephone")).setValue("1234567890");

        $("[type='submit']").shouldBe(Condition.enabled).click();

        $("h2").shouldHave(Condition.text("Owners"));

       // $("h2").waitUntil(Condition.appear,7000);

    }

    @Test
    public void addNewOwnerPageObjectTest() {
        open("/owners/add");
        NewOwnerPageLectures newOwnerPageLectures = new NewOwnerPageLectures();

        newOwnerPageLectures
                .setFirstName("Selendie")
                .setLastName("cool")
                .setAddress("street 34")
                .setCity("Dnipro")
                .setTelephone("1234567890")
                .clickAddNewOwnerBtn()
                .checkPage();

    }
}
