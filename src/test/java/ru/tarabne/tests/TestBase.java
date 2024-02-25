package ru.tarabne.tests;

import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.tarabne.config.BrowserConfig;
import ru.tarabne.helpers.Attach;

import java.util.Map;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        BrowserConfig browserConfig = ConfigFactory.create(BrowserConfig.class);

        Configuration.browser = browserConfig.browser();
        Configuration.browserSize = browserConfig.browserSize();
        Configuration.browserVersion = browserConfig.browserVersion();
        Configuration.remote = browserConfig.remoteUrl();

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("browserVersion", "100.0");
//        Configuration.remote = System.getProperty("remoteUrl");
//        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");



        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
