package sber.rabota.pages.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import java.util.List;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class NavMenu {
    private ElementsCollection menuElementsNames = $$(".styled__TabsWrapper-sc-s1lnm1-2 a"),
    menuElements = $$(".styled__HeaderLinkWrapper-sc-s1lnm1-4");


    public void checkMenuElements(List<String> menuElement) {
        menuElementsNames.filter(visible)
                .shouldHave(CollectionCondition.texts(menuElement));
    }
    public void checkCountMenuElements(int resultCount) {
        menuElements.should(CollectionCondition.size(resultCount));
    }
}
