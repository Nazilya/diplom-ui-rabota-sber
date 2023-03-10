package sber.rabota.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;
import java.util.List;
import java.util.stream.Stream;
import static com.codeborne.selenide.Configuration.baseUrl;
import static sber.rabota.helpers.TestData.*;

@Owner("Nazilya")
@Tag("UITests")
public class MainPageTests extends BaseTest {
    @BeforeEach
    void openMainPage() {
        mainPage.openPage(baseUrl);
    }
    @Story("Главная страница")
    @DisplayName("Проверка наличия логотипов на главной странице")
    @Test
    void checkLogoTest() {
        mainPage
                .checkLogo(logoCount);
    }

    @Story("Меню")
    @DisplayName("Проверка меню на главной странице")
    @Test
    void checkNavMenuButtonsTest() {
        mainPage
                .checkNavMenuElementsCount(menuElementsCount)
                .checkNavMenuElements(TestData.menuElements);
    }
    @Story("открытие страницы")
    @DisplayName("Проверка открытия страницы 'Поиск вакансий' по клику на меню")
    @Test
    void openVacanciesPageTest() {
        mainPage.clickNavMenuElementByName(vacancies)
                .checkTitleOfThePage(vacanciesPageTitle, attributeTitle);
    }

    @Story("открытие страницы")
    @DisplayName("Проверка открытия страницы 'Карьерные медиа' по клику на меню")
    @Test
    void openCariersPageTest() {
        mainPage.clickNavMenuElementByName(carier)
                .checkTitleOfThePage(cariersPageTitle, attributeTitle);
    }

    @Story("открытие страницы")
    @DisplayName("Проверка открытия страницы 'Выпускникам и студентам' по клику на меню")
    @Test
    void openGraduatePageTest() {
        mainPage.clickNavMenuElementByName(graduate)
                .openGraduatesPage()
                .checkTitleOfThePage(graduatesPageTitle, attributeTitle);
    }

}
