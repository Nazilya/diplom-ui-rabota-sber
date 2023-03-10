package sber.rabota.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import sber.rabota.helpers.Attach;
import sber.rabota.config.WebDriverProvider;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;
import sber.rabota.pages.SearchPage;
import sber.rabota.pages.VacansiesPage;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    protected MainPage mainPage = new MainPage();
    protected VacansiesPage vacansiesPage = new VacansiesPage();
    protected SearchPage searchPage = new SearchPage();
    protected static TestData testData = new TestData();
    @BeforeAll
    static void setUp() {
        WebDriverProvider.config();
    }
    @BeforeEach
    void addListener() {
        open(baseUrl);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
