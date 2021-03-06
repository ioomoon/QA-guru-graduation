package moon.ioo.api.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import moon.ioo.api.tests.lombok.Employer;
import moon.ioo.api.tests.lombok.Locale;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.assertj.core.api.Assertions.*;

public class ApiTests {
    private final int headHunterID = 1455;

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://api.hh.ru/";
    }


    @DisplayName("Проверка наличия результата поиска по работодателям на территории России")
    @Owner("m.lavrushina")
    @Feature("API")
    @Test
    void getEmployersInRussia() {
        int areaRussia = 113;
        given()
                .when()
                .get("employers?area=" + areaRussia)
                .then()
                .statusCode(200)
                .body("found", is(greaterThan(0)));
    }

    @DisplayName("Проверка корректного поиска компании по id")
    @Owner("m.lavrushina")
    @Feature("API")
    @Test
    void searchEmployerByID() {
        String headHunterName = "HeadHunter";
        String headHunterUrl = "https://api.hh.ru/employers/1455";
        Employer employer = given()
                .when()
                .get("employers/" + headHunterID)
                .then()
                .statusCode(200)
                .extract().as(Employer.class);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(employer.getId()).isEqualTo(headHunterID);
        softly.assertThat(employer.getName()).isEqualTo(headHunterName);

        softly.assertAll();
    }

    @DisplayName("Проверка на наличие открытых вакансий в HH.ru")
    @Severity(SeverityLevel.MINOR)
    @Owner("m.lavrushina")
    @Feature("API")
    @Test
    void checkOpenVacancies() {
        Employer employer = given()
                .when()
                .get("employers/" + headHunterID)
                .then()
                .statusCode(200)
                .extract().as(Employer.class);

        assertThat(employer.getOpen_vacancies()).isGreaterThan(0);
    }

    @DisplayName("Проверка доступных локалей для хоста hh.ru")
    @Owner("m.lavrushina")
    @Feature("API")
    @Test
    void checkLocalesInRU() {
        Locale[] locale = given()
                .when()
                .get("/locales?host=hh.ru")
                .then()
                .statusCode(200)
                .extract().as(Locale[].class);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(locale[0].getId()).isEqualTo("EN");
        softly.assertThat(locale[1].getId()).isEqualTo("RU");
        softly.assertThat(locale[1].getCurrent()).isEqualTo("true");

        softly.assertAll();
    }


    @DisplayName("Проверка доступных локалей для хоста hh.kz")
    @Owner("m.lavrushina")
    @Feature("API")
    @Test
    void checkLocalesInKZ() {
        Locale[] locale = given()
                .when()
                .get("/locales?host=hh.kz")
                .then()
                .statusCode(200)
                .extract().as(Locale[].class);

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(locale[0].getId()).isEqualTo("EN");
        softly.assertThat(locale[1].getId()).isEqualTo("KZ");
        softly.assertThat(locale[2].getId()).isEqualTo("RU");
        softly.assertThat(locale[2].getCurrent()).isEqualTo("true");

        softly.assertAll();
    }

    @DisplayName("Поиск работодателя 'QA-guru'")
    @Severity(SeverityLevel.MINOR)
    @Owner("m.lavrushina")
    @Feature("API")
    @Test
    void searchQAGuru() {
        given()
                .when()
                .get("/employers?text=QA-guru")
                .then()
                .statusCode(200)
                .body("found", is(greaterThan(0)));
    }
}
