package moon.ioo.tests;

import com.codeborne.selenide.WebDriverRunner;
import moon.ioo.config.Project;
import moon.ioo.helpers.AllureAttachments;
import moon.ioo.helpers.DriverSettings;
import moon.ioo.helpers.DriverUtils;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import moon.ioo.pages.AdvancedSearchPage;
import moon.ioo.pages.MainPage;
import moon.ioo.pages.SearchPage;
import moon.ioo.steps.UiSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    AdvancedSearchPage advancedSearch = new AdvancedSearchPage();
    UiSteps uiSteps = new UiSteps();

    static final String searchText = "Qa engineer";
    static final String compensationValue = "80000";
    static final String promoHeader = "Работа найдется для каждого";
    static final String employerUrl = "https://hh.ru/employer";

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }

    public void checkUrl(String expectedUrl) {
        WebDriverRunner driver = new WebDriverRunner();
        String actualUrl = driver.url();
        assertThat(actualUrl).isEqualTo(expectedUrl);
    }
}
