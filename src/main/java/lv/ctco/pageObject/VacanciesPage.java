package lv.ctco.pageObject;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class VacanciesPage {

    private final Markup markup = new Markup();

    public void clickOnVacancy(String title) {
        Selenide.$(Selectors.byText(title)).click();
        markup.vacanciesContent().waitUntil(visible, 1000).shouldHave(text(title));
    }

    public String getValueRelativeToTitle(String key) {
        HashMap<String, String> hmap = new HashMap<String, String>();
        hmap.put("Professional skills and qualification", "Experience in web application testing;");
        hmap.put("As an advantage", "Knowledge of and experience in non-functional testing;");
        return hmap.get(key);
    }

    public SelenideElement getAllItemsFromList(String key) {
        return $$("ul").findBy(text(getValueRelativeToTitle(key)));

    }

    public int contItemsInList(String key) {
        return getAllItemsFromList(key).findElements(By.cssSelector("li")).size();
    }

    private static class Markup {
        private SelenideElement vacanciesContent() {
            return $(By.className("vacancies-second-content-wrap"));
        }

    }
}
