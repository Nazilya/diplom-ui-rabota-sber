package sber.rabota.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sber.rabota.helpers.TestData;
import sber.rabota.pages.MainPage;

import java.util.List;
import java.util.stream.Stream;

public class MainPageTests extends BaseTest {
    private MainPage mainPage = new MainPage();
    private static TestData testData = new TestData();


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

}
