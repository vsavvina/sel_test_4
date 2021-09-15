package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JUnitCode {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void findCodeJU () {
        String findVal = "selenide";
        String wikiFindSoftAssert ="SoftAssertions";
        String testClJU5 = "Using JUnit5 extend test class";
        String piceOfCode = "class Tests";

        open("https://github.com/");
        $("[data-test-selector=nav-search-input]").setValue(findVal).pressEnter();
        $("ul.repo-list li").$("a").click();
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue(wikiFindSoftAssert).pressEnter();
        $x("//*[@id=\"wiki-pages-box\"]/div/div[2]/ul").shouldHave(text(wikiFindSoftAssert));
        $(byText(wikiFindSoftAssert)).click();
        $(".markdown-body").shouldHave(text(testClJU5)).shouldHave(text(piceOfCode));
    }
}
