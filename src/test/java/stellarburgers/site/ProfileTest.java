package stellarburgers.site;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.site.pageobject.HomePage;
import stellarburgers.site.pageobject.ProfilePage;

public class ProfileTest extends AbstractTest {
    @Before
    public void init() {
        driver = DriverFactory.getDriver();
        UserHelper.openProfilePage();
    }
    @DisplayName("Переход со страницы личного кабинета по ссылке  \"Конструктор\"")
    @Description("Проверяем, что при переходе из ЛК по ссылке логотипа " +
            "открывается Главная страница и доступна кнопка \"Оформить заказ\" " +
            "так как пользователь авторизован")
    @Test
    public void clickOnLinkConstructorOnProfilePage() {
        new ProfilePage(driver)
                .clickConstructorButton();
        new HomePage(driver).checkHomePageAuthorizesUserIsDisplayed();
    }
    @DisplayName("Переход со страницы личного кабинета по ссылке логотипа")
    @Description("Проверяем, что при переходе из ЛК по ссылке логотипа " +
            "открывается Главная страница и доступна кнопка \"Оформить заказ\" " +
            "так как пользователь авторизован")
    @Test
    public void clickOnLogoOnProfilePage() {
        new ProfilePage(driver)
                .clickLogoLink();
        new HomePage(driver).checkHomePageAuthorizesUserIsDisplayed();
    }
}
