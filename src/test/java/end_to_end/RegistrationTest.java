package end_to_end;

import org.testng.annotations.Test;
import pages.EvrikaHomePage;
import runners.LocalRunProvider;

import static models.PersonType.PHYSICAL;
import static models.UserData.getRandomUserData;
import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends LocalRunProvider {

    @Test
    public void verifyUserRegistration() {
        var userData = getRandomUserData();
        var password = userData.getPassword();
        var firstname = userData.getFirstname();
        var isPersonalPageDisplayed = new EvrikaHomePage()
                .openEvrikaHomePage()
                .openLoginAndRegistrationModal()
                .startRegistration()
                .selectPersonType(PHYSICAL)
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
}