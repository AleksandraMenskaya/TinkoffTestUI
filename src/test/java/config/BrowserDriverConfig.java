package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${env}.properties"})
public interface BrowserDriverConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String getBrowserName();
    @Key("version")
    @DefaultValue("122")
    String getBrowserVersion();
    @Key("size")
    @DefaultValue("1920x1280")
    String getBrowserSize();
    @Key("base_url")
    @DefaultValue("https://www.tinkoff.ru")
    String getBaseUrl();
    @Key("selenoid_url")
    String getRemoteWebDriver();
}