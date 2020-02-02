package PetclinicHomeworks.UItests;

import PetclinicHomeworks.Configurations.UIConfiguration;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class SpecialtyTestJenkins  extends UIConfiguration {

    @TmsLink("1027")
    @Issue("BUG-127")
    @Story("Open Specialties Page")
    @Test(description = "Open Specialties Page")
    public void specialtiesPageIsOpenedTest() {
        goToSpecialtiesPage();
        checkCurrentUrl("http://139.59.149.247:8000/petclinic/specialties");
    }
}
