package stellarburgers.site;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.site.pageobject.SignInPage;
import stellarburgers.site.pageobject.SignUpPage;
import stellarburgers.user.model.User;

public class SignUpTest extends AbstractTest {
    @Before
    public void init() {
        driver = DriverFactory.getDriver();
    }

    @DisplayName("Успешная регистрация пользователя")
    @Test
    public void register() {
        User user = User.createRandom();
        user_list_for_disposal.add(user);
        new SignUpPage(driver)
                .goToURL()
                .inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickSignUpButton();

        //при регистрации нет никакого уведомления пользователя об успехе.
        //лучше доработать приложение и затем проверку в автотесте
        //пока проверяем что после Регистрации  открывается форма Авторизации
        new SignInPage(driver).checkHeaderSignInPageIsDisplayed();
    }

    @DisplayName("При регистрация с коротким паролем выдается ошибка")
    @Test
    public void registerIncorrectPasswordLength() {
        User user = User.createRandomWithShortPassword();

        new SignUpPage(driver)
                .goToURL()
                .inputName(user.getName())
                .inputEmail(user.getEmail())
                .inputPassword(user.getPassword())
                .clickSignUpButton()
                .checkErrorMessageIncorrectPasswordIsDisplayed();

        //при регистрации нет никакого уведомления пользователя об успехе.
        //лучше доработать приложение и проверку в автотесте
        //пока проверяем что просто отображается форма Авторизации
    }
}
