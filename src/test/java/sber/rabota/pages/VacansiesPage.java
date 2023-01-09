package sber.rabota.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import sber.rabota.elements.Button;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class VacansiesPage {
    private ElementsCollection searchResults = $$(".styled__ListColumn-sc-76mli3-3 a"),
            errorMessages = $$(".styled__Error-sc-10rv8xs-0");
    private SelenideElement checkboxAgree = $x("//input[@id='agree']/parent::label"),
            lastName = $("input[placeholder='Фамилия']"),
            firstName = $("input[placeholder='Имя']"),
            email = $("input[placeholder='Email']"),
            phone = $("input[placeholder='Телефон']"),
            inpetFile = $("input[type='file']");
    private Button acceptCookieButton = new Button("Хорошо", $x("//button[.='Хорошо']"));
    private Button respondButton = new Button("Откликнуться", $x("//button[.='Откликнуться']"));

    @Step("клик подходящую вакансию")
    public VacansiesPage clickOnVacansy() {
        searchResults.first().click();
        switchTo().window(1);
        return this;
    }

    @Step("установить чекбокс согласия на обработку данных")
    public VacansiesPage clickOnСheckbox() {
        checkboxAgree.click();
        return this;
    }

    @Step("нажать на кнопку Откликнуться")
    public VacansiesPage clickOnTheRespondButton() {
        respondButton.click();
        return this;
    }

    @Step("проверить валидацию полей с пустыми значениями")
    public void checkErrorMessages(List<String> errorTexts) {
        errorMessages.filter(visible)
                .shouldHave(CollectionCondition.texts(errorTexts));
        //switchTo().window(getWebDriver().getWindowHandle()).close();
    }


    @Step("нажать на кнопку принять cookies")
    public VacansiesPage clickOnCookiesButton() {
        acceptCookieButton.click();
        return this;
    }

    @Step("заполнить поле Фамилия")
    public VacansiesPage fillLastNameField(String value) {
        lastName.setValue(value);
        return this;
    }

    @Step("заполнить поле Имя")
    public VacansiesPage fillFirstNameField(String value) {
        firstName.setValue(value);
        return this;
    }

    @Step("заполнить поле email")
    public VacansiesPage fillEmailField(String value) {
        email.setValue(value);
        return this;
    }

    @Step("заполнить поле телефон")
    public VacansiesPage fillPhoneField(String value) {
        phone.setValue(value);
        return this;
    }
    @Step("загрузить файл")
    public VacansiesPage uploadFile(String fileName) {
        inpetFile.uploadFromClasspath(fileName);
        return this;
    }
    @Step("проверить, что кнопка Откликнуться доступна для нажатия")
    public VacansiesPage checkThatTheRespondButtonEnabled() {
        respondButton.checkThatTheButtonEnabled();
        return this;
    }


}
