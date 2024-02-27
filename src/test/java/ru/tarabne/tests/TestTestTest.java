package ru.tarabne.tests;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.tarabne.config.DriverConfig;

public class TestTestTest {

    @Test
    @Tag("propprop")
    void systemPropTest() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        String browser = driverConfig.browserName();
        String browserVersion = driverConfig.browserVersion();
        String browserSize = driverConfig.browserSize();
        String browserRemote = driverConfig.remoteUrl();

        String browserConf = String.format("Browser: %s,\nversion: %s,\nsize: %s,\nremote: %s",
                browser, browserVersion, browserSize, browserRemote);

        System.out.println(browserConf);
    }


}
