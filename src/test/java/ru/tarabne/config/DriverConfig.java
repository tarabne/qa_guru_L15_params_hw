package ru.tarabne.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/driver.properties")
public interface DriverConfig extends Config {
    @Key("browser_name")
    String browserName();

    @Key("browser_size")
    String browserSize();

    @Key("browser_version")
    String browserVersion();

    @Key("remote_browser")
    String remoteUrl();
}
