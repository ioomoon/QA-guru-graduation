package moon.ioo.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class SearchPage {
    private final SelenideElement
            searchResultStandard = $(byXpath("//*[@data-qa='vacancy-serp__vacancy vacancy-serp__vacancy_standard']"));


    public void checkSearchResultStandard() {
        searchResultStandard.shouldBe(Condition.exist);
    }
}

