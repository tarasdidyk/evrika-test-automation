package end_to_end;

import models.UserType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EvrikaHomePage;
import runners.TestRunner;

import static models.UserType.LEGAL;
import static models.UserType.PHYSICAL;
import static models.UserData.getRandomUserData;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends TestRunner {

    @Test(dataProvider = "getUserTypes")
    public void verifyUserRegistration(UserType userType) {
        var userData = getRandomUserData();
        var password = userData.getPassword();
        var firstname = userData.getFirstname();

        var isPersonalPageDisplayed = new EvrikaHomePage()
                .openEvrikaHomePage()
                .openLoginAndRegistrationModal()
                .startRegistration()
                .selectUserType(userType)
                .setFirstName(userData.getFirstname())
                .setSurname(userData.getSurname())
                .setPhone(userData.getPhone())
                .setEmail(userData.getEmail())
                .setPassword(password)
                .confirmPassword(password)
                .acceptPrivatePolicy()
                .submitRegistrationForm()
                .isPersonalDataPageDisplayed(firstname);

        assertThat(isPersonalPageDisplayed)
                .as("The personal data page should be displayed after registration")
                .isTrue();
    }

    @DataProvider(parallel = true)
    private Object[] getUserTypes() {
        return new Object[]{
                PHYSICAL,
                LEGAL
        };
    }
}