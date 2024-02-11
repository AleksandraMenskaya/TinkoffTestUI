package test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BrowserDriverConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Map;
import static com.codeborne.selenide.Selenide.closeWebDriver;


public class TestBaseTinkoff {
    @BeforeAll
    public static void setUp() {
        BrowserDriverConfig config = ConfigFactory.create(BrowserDriverConfig.class, System.getProperties());

        Configuration.baseUrl = "https://www.tinkoff.ru";
        RestAssured.baseURI = "https://www.tinkoff.ru";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.pageLoadStrategy = "eager";

        if (!config.getRemoteWebDriver().isEmpty()) {
            Configuration.remote = config.getRemoteWebDriver();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        Attach.screenshotAs("LastScreenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}