package stellarburgers.site;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.site.pageobject.*;
import stellarburgers.user.model.User;

public class SignInTest extends AbstractTest {
    User user;

    @Before
    public void init() {
        driver = DriverFactory.getDriver();
        user = UserApiHelper.createNewUser();
    }

    @DisplayName("Вход по кнопке \"Войти в аккаунт\" на Главной")
    @Test
    public void loginFromSignInButton() {
        new HomePage(driver).goToURL().clickSignInButton();
        new SignInPage(driver).enter(user);
        check();
    }

    @DisplayName("Вход по кнопке \"Личный кабинет\" на Главной")
    @Test
    public void loginFromProfileButton() {
        new HomePage(driver).goToURL().clickProfileButton();
        new SignInPage(driver).enter(user);
        check();
    }

    @DisplayName("Вход через ссылку в форме Регистрации")
    @Test
    public void loginFromLinkOnSignUpPage() {
        new SignUpPage(driver).goToURL().clickSignInLink();
        new SignInPage(driver).enter(user);
        check();
    }

    @DisplayName("Вход через ссылку в форме Восстановления пароля")
    @Test
    public void loginFromLinkOnPasswordRecoveryPage() {
        new PasswordRecoveryPage(driver).goToURL().clickSignInLink();
        new SignInPage(driver).enter(user);
        check();
    }

    @Step("Проверка наличия кнопки \"Оформить заказ\"")
    @Description("Проверяем, что при переходе из ЛК по ссылке логотипа " +
            "открывается Главная страница и доступна кнопка \"Оформить заказ\" " +
            "так как пользователь авторизован")
    //В данном случае сделала проверку - что после авторизации
    // появляется кнопка Оформления заказа.
    public void check() {
        new HomePage(driver).checkHomePageAuthorizesUserIsDisplayed();
    }

    //Кажется что проситься параметризация,
    //с другой стороны кажется что в таком случае
    //еще придется увеличить код (построить типа модели с точками входа на страницу авторизации)
}
