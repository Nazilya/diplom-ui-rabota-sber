package sber.rabota.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("browserSize")
    String getBrowserSize();

    @Key("baseUrl")
    @DefaultValue("https://rabota.sber.ru/")
    String getBaseUrl();

    @Key("remoteUrl")
    String getRemoteUrl();
}
