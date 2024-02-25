package ru.tarabne.config;

import org.aeonbits.owner.Config;
import org.junit.jupiter.api.DisplayName;

@Config.Sources("classpath:config/${env}.properties")
public interface RegistrationConfig extends Config {
    @Key("first_name")
    @DefaultValue("defaultFirstName")
    String firstName();
    @Key("last_name")
    @DisplayName("defaultLastName")
    String lastName();
}
