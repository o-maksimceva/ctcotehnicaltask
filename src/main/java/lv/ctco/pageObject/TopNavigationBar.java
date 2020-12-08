package lv.ctco.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class TopNavigationBar {
    private final Markup.CareersTab careersTab = new Markup.CareersTab();

    public void selectCareersTab() {
        Markup.careersTab().hover();
        careersTab.vacancies().waitUntil(Condition.visible, 100);
    }

    public void clickOnCareers() {
        careersTab.vacancies().click();
    }

    private static class Markup {
        private static SelenideElement careersTab() {
            return $(By.id("menu-item-127"));
        }
        static class CareersTab{
            private SelenideElement vacancies(){
                return $(By.id("menu-item-131"));            }

        }
    }
}
