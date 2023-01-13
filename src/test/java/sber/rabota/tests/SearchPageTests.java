package sber.rabota.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;
import sber.rabota.pages.SearchPage;
import sber.rabota.pages.VacansiesPage;

public class SearchPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();
    private VacansiesPage vacansiesPage = new VacansiesPage();
    private TestData testData = new TestData();

    @BeforeEach
    void openSearchPage() {
        mainPage.clickNavMenuElementByName(testData.menuElement);
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка функции поиска вакансий по регионам")
    void checkVacanciesSearchResultsByRegionsTest() {
        searchPage.clickClearButton()
                .fillFieldRegion(testData.regionForSearch)
                .selectRegion()
                .checkRegion(testData.attribute, testData.region);
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка функции поиска и наличия вакансий для людей с инвалидностью")
    void checkVacanciesSearchResultsForHandicappedTest() {
        searchPage.clickClearButton()
                .clickAccessibleForHandicappedFlag()
                .checkAvailabilityOfVacanciesForHandicapped()
                .checkThatTheSignsForHandicappedInVacanciesArePresent();
    }

    @CsvFileSource(resources = "/files/searchResult.csv")
    @ParameterizedTest(name = "{1} при поиске вакансии {0}")
    @Tag("UITests")
    @DisplayName("Проверка функции поиска вакансий и результатов поиска")
    void checkVacansySearchResultsTest(String vacansy, String searchesResult) {
        searchPage.clickClearButton()
                .fillSearchField(vacansy)
                .checkResultOfSearch(searchesResult);
    }
}
