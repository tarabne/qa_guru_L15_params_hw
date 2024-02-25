package ru.tarabne.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browser.properties")
public interface BrowserConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browser_size")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("browser_version")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("remote_browser")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();


}
