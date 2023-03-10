package sber.rabota.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;
import sber.rabota.pages.SearchPage;
import sber.rabota.pages.VacansiesPage;

import static sber.rabota.helpers.TestData.*;
@Owner("Nazilya")
@Tag("UITests")
public class SearchPageTests extends BaseTest {
    @BeforeEach
    void openSearchPage() {
        mainPage.clickNavMenuElementByName(menuElement);
    }

    @Story("Поиск вакансии")
    @DisplayName("Проверка функции поиска вакансий по регионам")
    @Test
    void checkVacanciesSearchResultsByRegionsTest() {
        searchPage.clickClearButton()
                .fillFieldRegion(regionForSearch)
                .selectRegion()
                .checkRegion(attribute, region);
    }

    @Story("Поиск вакансии")
    @DisplayName("Проверка функции поиска и наличия вакансий для людей с инвалидностью")
    @Test
    void checkVacanciesSearchResultsForHandicappedTest() {
        searchPage.clickClearButton()
                .clickAccessibleForHandicappedFlag()
                .checkAvailabilityOfVacanciesForHandicapped()
                .checkThatTheSignsForHandicappedInVacanciesArePresent();
    }

    @Story("Поиск вакансии")
    @CsvFileSource(resources = "/files/searchResult.csv")
    @DisplayName("Проверка функции поиска вакансий и результатов поиска")
    @ParameterizedTest(name = "{1} при поиске вакансии {0}")
    void checkVacansySearchResultsTest(String vacansy, String searchesResult) {
        searchPage.clickClearButton()
                .fillSearchField(vacansy)
                .checkResultOfSearch(searchesResult);
    }
}
