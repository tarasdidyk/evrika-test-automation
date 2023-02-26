package modals;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LoginAndRegistrationHomeModal {

    @Step("Login and registration home modal: started registration")
    public RegistrationModal startRegistration() {
        $x("//button[contains(@x-data, 'users.register')]").click();

        return new RegistrationModal();
    }
}