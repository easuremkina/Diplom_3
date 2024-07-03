package stellarburgers.site;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.site.pageobject.ProfilePage;
import stellarburgers.site.pageobject.SignInPage;

public class LogoutTest extends AbstractTest {
    @Before
    public void init() {
        driver = DriverFactory.getDriver();
        UserHelper.openProfilePage();
    }

    @DisplayName("Выход авторизованным пользователем со страницы профиля по клику на логотип")
    @Description("Проверяем переход на форму авторизации после выхода из учетной записи")
    @Test
    public void logoutFromProfilePage() {
        new ProfilePage(driver)
                .clickLogoutButton();
        new SignInPage(driver).checkHeaderSignInPageIsDisplayed();
    }
}
