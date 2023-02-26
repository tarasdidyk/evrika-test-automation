package modals;

import io.qameta.allure.Step;
import models.PersonType;
import pages.PersonalDataPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static java.lang.String.format;
import static utils.AllureLogger.attachScreenshot;
import static utils.SlowInput.slowInput;

public class RegistrationModal {

    private final String BLOCK_LOCATOR = "//div[@class = 'popup-content']";
    private final String FIELD_TEMPLATE_LOCATOR = BLOCK_LOCATOR + "//input[@name = '%s']";
    private final long delayBetweenInputs = 300;

    @Step("Registration modal: Selected {personType} person type")
    public RegistrationModal selectPersonType(PersonType personType) {
        var radioBoxLocator = format("//span[text() = '%s']", personType.getName());
        var radioBoxSelectElement = $x(radioBoxLocator + "/preceding-sibling::input");
        if (!radioBoxSelectElement.isSelected()) {
            $x(radioBoxLocator).click();

            radioBoxSelectElement.shouldBe(selected);
        }

        return this;
    }

    @Step("Registration Modal: set first name to {firstName}")
    public RegistrationModal setFirstName(String firstName) {
        $x(format(FIELD_TEMPLATE_LOCATOR, "name"))
                .execute(slowInput(firstName, delayBetweenInputs))
                .shouldHave(value(firstName));

        return this;
    }

    @Step("Registration Modal: set surname to {surname}")
    public RegistrationModal setSurname(String surname) {
        $x(format(FIELD_TEMPLATE_LOCATOR, "surname"))
                .execute(slowInput(surname, delayBetweenInputs))
                .shouldHave(value(surname));

        return this;
    }

    @Step("Registration Modal: set phone to {phone}")
    public RegistrationModal setPhone(String phone) {
        $x(format(FIELD_TEMPLATE_LOCATOR, "phone"))
                .setValue(phone)
                .shouldNotBe(empty);

        return this;
    }

    @Step("Registration Modal: set email to {email}")
    public RegistrationModal setEmail(String email) {
        $x(format(FIELD_TEMPLATE_LOCATOR, "email"))
                .execute(slowInput(email, delayBetweenInputs))
                .shouldHave(value(email));

        return this;
    }

    @Step("Registration Modal: set password to {password}")
    public RegistrationModal setPassword(String password) {
        $x(format(FIELD_TEMPLATE_LOCATOR, "password"))
                .execute(slowInput(password, delayBetweenInputs))
                .shouldHave(value(password));

        return this;
    }

    @Step("Registration Modal: confirmed {password} password")
    public RegistrationModal confirmPassword(String password) {
        $x(BLOCK_LOCATOR + "//input[@type = 'password' and not(@name)]")
                .execute(slowInput(password, delayBetweenInputs))
                .shouldHave(value(password));

        return this;
    }

    @Step("Registration Modal: accepted private policy")
    public RegistrationModal acceptPrivatePolicy() {
        var checkBoxLocator = BLOCK_LOCATOR + "//label[@class = 'input-choice']/span";
        var checkBoxSelectElement = $x(checkBoxLocator + "/preceding-sibling::input");
        if (!checkBoxSelectElement.isSelected()) {
            var checkBoxLocation = $x(checkBoxLocator + "/span").getLocation();
            actions()
                    .moveByOffset(checkBoxLocation.getX(), checkBoxLocation.getY())
                    .click()
                    .perform();

            checkBoxSelectElement.shouldBe(selected);
        }

        return this;
    }

    @Step("Registration Modal: submitted registration form")
    public PersonalDataPage submitRegistrationForm() {
        attachScreenshot();

        $x(BLOCK_LOCATOR + "//button[@type = 'submit']").click();

        return new PersonalDataPage();
    }
}