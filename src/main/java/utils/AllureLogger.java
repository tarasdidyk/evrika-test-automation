package utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;
import static org.openqa.selenium.OutputType.BYTES;

@UtilityClass
public class AllureLogger {

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        if (hasWebDriverStarted()) {
            return screenshot(BYTES);
        }

        return null;
    }
}