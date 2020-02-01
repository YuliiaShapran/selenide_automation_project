package Lectures;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class OwnersPageLectures {
    public OwnersPageLectures checkPage() {
        $("h2").shouldHave(Condition.text("Owners"));
        return this;
    }
}
