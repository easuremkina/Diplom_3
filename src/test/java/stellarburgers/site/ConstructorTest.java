package stellarburgers.site;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.site.enums.IngredientType;
import stellarburgers.site.pageobject.HomePage;

public class ConstructorTest extends AbstractTest {
    @Before
    public void init() {
        driver = DriverFactory.getDriver();
    }
    @Test
    @DisplayName("По умолчанию на главной странице открыта вкладка ингредиентов - Булки")
    public void currentTabIsBuns() {
        new HomePage(driver)
                .goToURL()
                .checkCurrentTabIsDisplayed(IngredientType.BUN);
    }
    @Test
    @DisplayName("Клик по кнопке Соусы открывает вкладку Соусы")
    public void openSaucesTab() {
        new HomePage(driver)
                .goToURL()
                .clickTab(IngredientType.SAUCE)
                .checkCurrentTabIsDisplayed(IngredientType.SAUCE);
    }
    @Test
    @DisplayName("Клик по кнопке Начинки открывает вкладку Начинки")
    public void openFillingsTab() {
        new HomePage(driver)
                .goToURL()
                .clickTab(IngredientType.MAIN)
                .checkCurrentTabIsDisplayed(IngredientType.MAIN);
    }
}
