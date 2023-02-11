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
@Disabled
@Tag("UITests")
public class MainPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private static TestData testData = new TestData();

    @BeforeEach
    void openMainPage() {
        mainPage.openPage(baseUrl);
    }
    @Test
    @Owner("Nazilya")
    @Story("Главная страница")
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
    @Owner("Nazilya")
    @Story("Меню")
    @DisplayName("Проверка меню на главной странице")
    void checkNavMenuButtonsTest(int count, List<String> menuElements) {
        mainPage
                .checkNavMenuElementsCount(count)
                .checkNavMenuElements(menuElements);
    }

    @Test
    @Owner("Nazilya")
    @Story("открытие страницы")
    @DisplayName("Проверка открытия страницы 'Поиск вакансий' по клику на меню")
    void openVacanciesPageTest() {
        mainPage.clickNavMenuElementByName(testData.vacancies)
                .checkTitleOfThePage(testData.vacanciesPageTitle, testData.attributeTitle);
    }

    @Test
    @Owner("Nazilya")
    @Story("открытие страницы")
    @DisplayName("Проверка открытия страницы 'Карьерные медиа' по клику на меню")
    void openCariersPageTest() {
        mainPage.clickNavMenuElementByName(testData.carier)
                .checkTitleOfThePage(testData.cariersPageTitle, testData.attributeTitle);
        //Assertions.assertEquals(testData.cariersPageTitle, $x("//title").getAttribute("textContent"));
    }

    @Test
    @Tag("Ui")
    @Owner("Nazilya")
    @Story("открытие страницы")
    @DisplayName("Проверка открытия страницы 'Выпускникам и студентам' по клику на меню")
    void openGraduatePageTest() {
        mainPage.clickNavMenuElementByName(testData.graduate)
                .openGraduatesPage()
                .checkTitleOfThePage(testData.graduatesPageTitle, testData.attributeTitle);

//        Assertions.assertEquals(testData.graduatesPageTitle, $x("//title").getAttribute("textContent"));
    }



}
