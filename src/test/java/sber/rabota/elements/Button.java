package sber.rabota.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;

public class Button {
    private final String name;
    private final SelenideElement selector;

    public Button(String name, SelenideElement selector) {
        this.name = name;
        this.selector = selector;
    }
   // @Step("Нажать кнопку {this.name}")
    public void click() {
        selector.click();
    }

    public void checkButtonsName(String text) {
        selector.shouldHave(Condition.text(text));
    }

    public void checkThatTheButtonEnabled() {
        selector.shouldBe(enabled);
    }
}
