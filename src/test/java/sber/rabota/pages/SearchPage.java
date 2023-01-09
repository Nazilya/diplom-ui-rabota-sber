package sber.rabota.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import sber.rabota.elements.Button;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    private SelenideElement
            searchResultMessage = $(".styled__ListColumn-sc-76mli3-3").$("div"),
            regionInput = $x("//input[@placeholder='Город/регион']"),
            checkboxForHandicapped =
                    $("#vacancy-search-filter-accept-handicapped-flag").parent(),
            acceptHandicappedSign = $(".styled__IconWrapper-sc-19xh0mp-3"),
            regionInVacansi = $(".styled__ListColumn-sc-76mli3-3  div.styled__Content-sc-19xh0mp-1").$("div"),
            inputField = $("input");
    private ElementsCollection regions = $$(".styled__ResultContainer-sc-7q6vjc-2 div"),
            vacanciesForHandicappedCount = $$(".styled__IconWrapper-sc-19xh0mp-3");

    private Button clearButton = new Button("Сбросить", $x("//button[.='Сбросить']"));


    @Step("ввести значение в поле для поиска вакансии")
    public SearchPage fillSearchField(String text) {
        inputField.setValue(text).pressEnter();
        return this;
    }

    @Step("проверить результат выполнения поиска")
    public SearchPage checkResultOfSearch(String result) {
        searchResultMessage.shouldHave(text(result));
        return this;
    }

    @Step("ввести регион для поиска вакансии в регионе")
    public SearchPage fillFieldRegion(String region) {
        regionInput.setValue(region);
        return this;
    }

    @Step("выбран первый найденный регион для поиска вакансии")
    public SearchPage selectRegion() {
        regions.first().click();
        return this;
    }

    @Step("Нажать на чекбокс для поиска вакансии для людей с инвалидностью")
    public SearchPage clickAccessibleForHandicappedFlag() {
        checkboxForHandicapped.click();
        return this;
    }

    @Step("проверить регион в найденных вакансиях")
    public SearchPage checkRegion(String attribute, String text) {
        regionInVacansi.shouldHave(attribute(attribute, text));
        return this;
    }

    @Step("проверить наличие вакансий для людей с инвалидностью по всем регионам")
    public SearchPage checkAvailabilityOfVacanciesForHandicapped() {
        vacanciesForHandicappedCount.shouldHave(sizeGreaterThanOrEqual(1));
        return this;
    }

    @Step("проверить в найденных вакансиях знаки доступности (пиктограммы) для людей с инвалидностью")
    public SearchPage checkThatTheSignsForHandicappedInVacanciesArePresent() {
        acceptHandicappedSign.shouldBe(visible);
        return this;
    }

    @Step("очистить результаты поиска")
    public SearchPage clickClearButton() {
        clearButton.click();
        return this;
    }

}
