package sber.rabota.tests;

import org.junit.jupiter.api.*;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;
import sber.rabota.pages.SearchPage;
import sber.rabota.pages.VacansiesPage;

import static com.codeborne.selenide.Selenide.*;
import static sber.rabota.helpers.TestData.errorTexts;

public class VacansiesPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();
    private VacansiesPage vacansiesPage = new VacansiesPage();
    private TestData testData = new TestData();

    @BeforeEach
    void openVacanciesSearchPage() {
        open(testData.vacanciesUrl);
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка валидации полей при отклике на вакансию")
    void checkFieldsValidationTest() {
        vacansiesPage.clickOnCookiesButton()
                .clickOnСheckbox()
                .checkThatTheRespondButtonEnabled()
                .clickOnTheRespondButton()
                .checkErrorMessages(errorTexts);

    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка функции отклика на вакансию и отправки резюме")
    void fillVacanciesFormTest() {
        vacansiesPage
                .fillLastNameField(testData.lastName)
                .fillFirstNameField(testData.firstName)
                .fillEmailField(testData.email)
                .fillPhoneField(testData.phone)
                .uploadFile(testData.fileName)
                .clickOnСheckbox()
                .checkThatTheRespondButtonEnabled();
        //.clickOnTheRespondButton();
    }
}