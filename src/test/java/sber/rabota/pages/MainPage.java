package sber.rabota.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import sber.rabota.components.NavMenu;
import java.util.List;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private NavMenu menu = new NavMenu();
    private ElementsCollection menuElements = $$(".styled__HeaderLinkWrapper-sc-s1lnm1-4"), //их 3 -  список элементов меню
            logo = $$(".styled__LogoLinkWrapper-sc-119f04f-9");
    private SelenideElement
            logotype = $("styled__HeaderWrapper-sc-s1lnm1-1 "),
            lastNameInput = $("#lastName");

    @Step("открыть страницу")
    public void openPage(String url) {
        open(url);
    }

    @Step("проверить наличие логотипов на странице на главной странице")
    public MainPage checkLogo(int logoCount) {
        logo.shouldHave(sizeGreaterThanOrEqual(logoCount));
        return this;
    }

    @Step("проверить количество элементов меню")
    public MainPage checkNavMenuElementsCount(int resultCount) {
        menu.checkCountMenuElements(resultCount);
        return this;
    }

    @Step("проверить названия элементов меню")
    public MainPage checkNavMenuElements(List<String> menuElement) {
        menu.checkMenuElements(menuElement);
        return this;
    }

    @Step("кликнуть на элемент  меню ")
    public MainPage clickNavMenuElementByName(String name) {
        menuElements.find(text(name)).click();
        return this;
    }
}
