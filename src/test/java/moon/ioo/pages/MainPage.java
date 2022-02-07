package moon.ioo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.assertj.core.api.Assertions.assertThat;

public class MainPage {
    private SelenideElement
            searchButton = $(byXpath("//*[@data-qa='search-button']")),
            searchInput = $(byXpath("//*[@data-qa='search-input']")),
            advancedSearch = $(byXpath("//*[@data-qa='advanced-search']")),
            promoHeader = $(".bloko-header-promo-3"),
            becomeAnEmployer = $(byText("Я ищу сотрудника")),
            becomeAnEmployerInHeader = $(byXpath("//*[@data-qa='mainmenu_employer']"));


    public MainPage clickSearchButton() {
        searchButton.click();

        return this;
    }

    public MainPage setSearchInput(String value) {
        searchInput.setValue(value);

        return this;
    }

    public MainPage clickAdvancedSearch() {
        advancedSearch.click();

        return this;
    }

    public MainPage checkPromoHeader(String value) {
        assertThat(promoHeader.getText()).isEqualTo(value);

        return this;
    }

    public MainPage clickBecomeAnEmployer() {
        becomeAnEmployer.click();

        return this;
    }

    public MainPage clickBecomeAnEmployerInHeader() {
        becomeAnEmployerInHeader.click();

        return this;
    }
}
