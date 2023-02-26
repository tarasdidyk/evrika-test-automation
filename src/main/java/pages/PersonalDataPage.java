package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalDataPage {

    public boolean isPersonalDataPageDisplayed(String userName) {
        try {
            return $x("//div[@class = 'cabinet']//div[@class = 'cabinet__greeting']")
                    .shouldBe(visible)
                    .isDisplayed();
        } catch (AssertionError error) {
            return false;
        }
    }
}