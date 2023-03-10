package sber.rabota.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;
import sber.rabota.pages.SearchPage;
import sber.rabota.pages.VacansiesPage;
import static com.codeborne.selenide.Selenide.*;
import static sber.rabota.helpers.TestData.errorTexts;
import static sber.rabota.helpers.TestData.vacanciesUrl;

@Owner("Nazilya")
@Tag("UITests")
public class VacansiesPageTests extends BaseTest {
    @BeforeEach
    void openVacanciesSearchPage() {
        open(vacanciesUrl);
    }
    @Story("Отклик на вакансию")
    @DisplayName("Проверка валидации полей при отклике на вакансию")
    @Test
    void checkFieldsValidationTest() {
        vacansiesPage.clickOnCookiesButton()
                .clickOnDataProcessingConsentСheckbox()
                .checkThatTheRespondButtonEnabled()
                .clickOnTheRespondButton()
                .checkValidationOfFieldsWithEmptyValues(errorTexts);

    }
    @Story("Отклик на вакансию")
//    @JiraIssues(@JiraIssue("AE-1"))
    @DisplayName("Проверка функции отклика на вакансию и отправки резюме")
    @Test
    void fillVacanciesFormTest() {
        vacansiesPage
                .fillLastNameField(testData.lastName)
                .fillFirstNameField(testData.firstName)
                .fillEmailField(testData.email)
                .fillPhoneField(testData.phone)
                .uploadFile(testData.fileName)
                .clickOnDataProcessingConsentСheckbox()
                .checkThatTheRespondButtonEnabled();
                //.clickOnTheRespondButton()
                //.checkTheResponseMessageOnTheSendedResume("Спасибо за отклик!");
    }
}
