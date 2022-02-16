package moon.ioo.ui.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;


public class UiTests extends TestBase {
    @DisplayName("Проверка наличия корректного промо-текста на главной странице")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("HomePage")
    @Owner("m.lavrushina")
    @Test
    void promoHeaderTest() {
        uiSteps.openMainPage();

        step("Проверяем, что на главной странице есть промо-текст 'Работа найдется для каждого'", () -> {
            mainPage.checkPromoHeader(promoHeader);
        });
    }

    @DisplayName("Проверка наличия результатов поиска по профессии: " + "'" + searchText + "'")
    @Owner("m.lavrushina")
    @Feature("HomePage")
    @Test
    void searchTest() {
        uiSteps.openMainPage();

        step("Вводим название профессии для поиска в поле ввода и нажимаем 'Найти работу'", () -> {
            mainPage.setSearchInput(searchText)
                    .clickSearchButton();
        });
        step("Проверяем, что по нашему запросу нашлись результаты", () -> {
            searchPage.checkSearchResultStandard();
        });
    }

    @DisplayName("Проверка наличия результатов расширенного поиска: " + "'" + searchText + "'"
            + " с уровнем дохода: " + compensationValue)
    @Owner("m.lavrushina")
    @Feature("HomePage")
    @Test
    void advancedSearchTest() {
        uiSteps.openMainPage();

        step("Нажимаем значок расширенного поиска", () -> {
            mainPage.clickAdvancedSearch();
        });
        step("В поле ввода ключевых слов вводим название профессии для поиска", () -> {
            advancedSearch.setKeywordsInput(searchText);

        });
        step("В поле ввода ожидаемого уровня дохода вводим ожидаемый доход и нажимаем 'Найти'", () -> {
            advancedSearch.setCompensationValue(compensationValue)
                    .clickSubmitButton();
        });

        step("Проверяем, что по нашему запросу нашлись результаты", () -> {
            searchPage.checkSearchResultStandard();
        });
    }


    @DisplayName("Проверка перехода на страницу для работодателей при нажатии кнопки в панели навигации")
    @Owner("m.lavrushina")
    @Feature("HomePage")
    @Test
    void changeStatusToEmployerInHeaderTest() {
        uiSteps.openMainPage();

        step("Нажимаем кнопку 'Работодателям'", () -> {
            mainPage.clickBecomeAnEmployerInHeader();
        });
        step("Проверяем, что произошел переход по нужному url", () -> {
            checkUrl(employerUrl);
        });
    }


    @DisplayName("Проверка перехода на страницу для работодателей при нажатии 'Я ищу сотрудника'")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("m.lavrushina")
    @Feature("HomePage")
    @Test
    void changeStatusToEmployerTest() {
        uiSteps.openMainPage();

        step("Нажимаем кнопку 'Я ищу сотрудника'", () -> {
            mainPage.clickBecomeAnEmployer();
        });
        step("Проверяем, что произошел переход по нужному url", () -> {
            checkUrl(employerUrl);
        });
    }

}