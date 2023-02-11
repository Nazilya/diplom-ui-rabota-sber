package sber.rabota.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

    public class WebDriverProvider {

        private static WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

        public static void config() {
            Configuration.baseUrl = WebDriverProvider.config.getBaseUrl();
            Configuration.browserSize = WebDriverProvider.config.getBrowserSize();
            Configuration.browser = WebDriverProvider.config.getBrowserName();
            Configuration.browserVersion = WebDriverProvider.config.getBrowserVersion();
            String remoteUrl = WebDriverProvider.config.getRemoteUrl();
            if (remoteUrl != null) {
                Configuration.remote = remoteUrl;
            }

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
        }
    }
