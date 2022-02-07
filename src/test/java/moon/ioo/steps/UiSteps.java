package moon.ioo.steps;

import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

public class UiSteps {

    @DisplayName("Открываем главную страницу hh.ru")
    public UiSteps openMainPage() {
        open("https://hh.ru/");
        return this;
    }
}
