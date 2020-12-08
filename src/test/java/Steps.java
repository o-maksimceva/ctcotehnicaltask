import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lv.ctco.pageObject.TopNavigationBar;
import lv.ctco.pageObject.VacanciesPage;
import org.junit.Assert;

public class Steps {
    private static final String BASE_URL = "https://ctco.lv/";
    private final TopNavigationBar topNavigationBar = new TopNavigationBar();
    private final VacanciesPage vacanciesPage = new VacanciesPage();

    @And("Open base url in browser")
    public void openBaseUrl() {
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverRunner.getAndCheckWebDriver().manage().window().maximize();
        Selenide.open(BASE_URL);
    }

    @And("^Open vacancy with title \"([^\"]*)\"$")
    public void openVacancyWithTitle(String title) {
        topNavigationBar.selectCareersTab();
        topNavigationBar.clickOnCareers();
        vacanciesPage.clickOnVacancy(title);
    }

    @Then("{string} paragraph has {int} items in list")
    public void paragraphHasItemsInList(String paragraphTitle, int expectedQuantity) {
        int actualQuantity = vacanciesPage.contItemsInList(paragraphTitle);
        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
}
