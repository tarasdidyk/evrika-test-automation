package runners;

import com.codeborne.selenide.Configuration;
import com.google.common.collect.ImmutableMap;
import org.testng.annotations.Listeners;
import utils.UiTestListener;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static java.time.Duration.ofSeconds;
import static java.util.List.of;

@Listeners(UiTestListener.class)
public class TestRunner {

    public static List<String> CHROME_OPTIONS = of(
            "no-sandbox",
            "disable-site-isolation-trials",
            "ignore-certificate-errors",
            "disable-popup-blocking",
            "disable-notifications",
            "disable-browser-side-navigation",
            "disable-gpu",
            "dns-prefetch-disable",
            "disable-impl-side-painting",
            "disable-infobars",
            "disable-dev-shm-usage"
    );

    public static ImmutableMap<String, Object> CHROME_PREFS = ImmutableMap.of(
            "plugins.always_open_pdf_externally", true,
            "intl.accept_languages", "en-us");

    protected void setUpBrowser() {
        Configuration.timeout = ofSeconds(90).toMillis();
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
        Configuration.pageLoadTimeout = ofSeconds(300).toMillis();

        setProperty("webdriver.chrome.silentOutput", "true");

        var blankPageUrl = "about:blank";
        Configuration.browser = LocalRunProvider.class.getName();
        open(blankPageUrl);

        getWebDriver()
                .manage()
                .timeouts()
                .scriptTimeout(ofSeconds(120));
    }
}