package ru.tarabne.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${env}.properties")
public interface RegistrationConfig extends Config {
    @Key("first_name")
    String firstName();
    @Key("last_name")
    String lastName();
}
