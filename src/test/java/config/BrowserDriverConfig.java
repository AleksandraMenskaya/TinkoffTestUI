package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/${env}.properties"})
public interface BrowserDriverConfig extends Config {
    @Key("browser")
    String getBrowserName();
    @Key("version")
    String getBrowserVersion();
    @Key("size")
    String getBrowserSize();
    @Key("base_url")
    String getBaseUrl();
    @Key("selenoid_url")
    String getRemoteWebDriver();
}