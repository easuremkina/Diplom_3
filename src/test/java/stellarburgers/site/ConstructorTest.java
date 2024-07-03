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
    @DisplayName("Клик по кнопке Соусы открывает вкладку Соусы")
    public void openSaucesTab(){
        new HomePage(driver)
                .goToURL()
                .clickTab(IngredientType.SAUCE)
                .checkCurrentTabIsDisplayed(IngredientType.SAUCE);
    }
    @Test
    @DisplayName("Клик по кнопке Начинки открывает вкладку Начинки")
    public void openFillingsTab(){
        new HomePage(driver)
                .goToURL()
                .clickTab(IngredientType.MAIN)
                .checkCurrentTabIsDisplayed(IngredientType.MAIN);
    }

    @Test
    @DisplayName("Клик по кнопке Булки открывает вкладку Булки")
    public void openBunTab(){
        new HomePage(driver)
                .goToURL()
                //переходим сначала на вкладку Соусы, т к вкладка Булки изначально не кликабельна
                .clickTab(IngredientType.SAUCE)
                .checkCurrentTabIsDisplayed(IngredientType.SAUCE)
                //затем уже на вкладку Булки
                .clickTab(IngredientType.BUN)
                .checkCurrentTabIsDisplayed(IngredientType.BUN);
    }
}
