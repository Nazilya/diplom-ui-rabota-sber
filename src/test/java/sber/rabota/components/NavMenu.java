package sber.rabota.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NavMenu {
    private ElementsCollection menuElements =
            //$$(".styled__HeaderLinkWrapper-sc-s1lnm1-4 a"); //их 3 -  список элементов меню
            $$(".styled__TabsWrapper-sc-s1lnm1-2 a"); //их 3 -  список элементов меню

    private SelenideElement
            logo1 = $(".styled__LogoLinkWrapper-sc-119f04f-9"),
            menu = $(".styled__TabsWrapper-sc-s1lnm1-2");


    public void checkMenuElements(List<String> menuElement) {
        menuElements.filter(visible)
                .shouldHave(CollectionCondition.texts(menuElement));
    }

    public void checkCountMenuElements(int resultCount) {
        menuElements.should(CollectionCondition.size(resultCount));
    }

    public void clickMenuElement(String name) {
        menuElements.find(text(name)).click();
    }

}
