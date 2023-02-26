package pages;

import io.qameta.allure.Step;
import modals.LoginAndRegistrationHomeModal;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static utils.SystemPropertyHelper.getHomePageUrl;

public class EvrikaHomePage {

    @Step("Opened Evrika home page")
    public EvrikaHomePage openEvrikaHomePage() {
        open(getHomePageUrl());

        return this;
    }

    @Step("Evrika home page: opened login and registration modal")
    public LoginAndRegistrationHomeModal openLoginAndRegistrationModal() {
        $x("//div[contains(@x-data, 'login')]/span[contains(@class, 'button-icon')]").click();

        return new LoginAndRegistrationHomeModal();
    }
}
