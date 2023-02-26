package runners;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.openqa.selenium.PageLoadStrategy.EAGER;
import static runners.TestRunner.CHROME_OPTIONS;
import static runners.TestRunner.CHROME_PREFS;

public class LocalRunProvider implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        return getChromeDriver(capabilities);
    }

    private WebDriver getChromeDriver(Capabilities capabilities) {
        chromedriver().setup();

        var chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(CHROME_OPTIONS).addArguments("--disable-features=VizDisplayCompositor").setPageLoadStrategy(EAGER).setExperimentalOption("prefs", CHROME_PREFS).merge(capabilities);

        return new ChromeDriver(chromeOptions);
    }
}