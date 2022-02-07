package moon.ioo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AdvancedSearchPage {
    private SelenideElement
            keywordsInput = $(byXpath("//*[@data-qa='vacancysearch__keywords-input']")),
            compensationInput = $(byXpath("//*[@data-qa='vacancysearch__compensation-input']")),
            submitButton = $(byXpath("//*[@data-qa='vacancysearch__submit']"));


    public AdvancedSearchPage setKeywordsInput(String value) {
        keywordsInput.setValue(value);

        return this;
    }

    public AdvancedSearchPage setCompensationValue(String value) {
        compensationInput.setValue(value);

        return this;
    }

    public AdvancedSearchPage clickSubmitButton() {
        submitButton.click();

        return this;
    }
}
