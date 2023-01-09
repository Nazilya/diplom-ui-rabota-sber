package sber.rabota.tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private static TestData testData = new TestData();

    @BeforeEach
    void openMainPage() {
        mainPage.openPage(baseUrl);
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка наличия логотипов на главной странице")
    void checkLogoTest() {
        mainPage
                .checkLogo(testData.logoCount);
    }

    static Stream<Arguments> checkNavMenuButtonsTest() {
        return Stream.of(
                Arguments.of(testData.menuElementsCount, TestData.menuElements)
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Проверка наличия кнопок {1} в меню и их общее кол-во {0}")
    @Tag("UITests")
    @DisplayName("Проверка меню на главной странице")
    void checkNavMenuButtonsTest(int count, List<String> menuElements) {
        mainPage
                .checkNavMenuElementsCount(count)
                .checkNavMenuElements(menuElements);
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка открытия страницы 'Поиск вакансий' по клику на меню")
    void openVacanciesPageTest() {
        mainPage.clickNavMenuElementByName(testData.vacancies);
        Assertions.assertEquals(testData.vacanciesTitle, $x("//title").getAttribute("textContent"));
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка открытия страницы 'Карьерные медиа' по клику на меню")
    void openCariersPageTest() {
        mainPage.clickNavMenuElementByName(testData.carier);
        Assertions.assertEquals(testData.cariersTitle, $x("//title").getAttribute("textContent"));
    }

    @Test
    @Tag("UITests")
    @DisplayName("Проверка открытия страницы 'Выпускникам и студентам' по клику на меню")
    void openGraduatePageTest() {
        mainPage.clickNavMenuElementByName(testData.graduate);
        switchTo().window(1);
        Assertions.assertEquals(testData.graduateTitle, $x("//title").getAttribute("textContent"));
    }

}
