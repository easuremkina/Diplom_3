package stellarburgers.site;

import io.qameta.allure.Step;
import stellarburgers.site.pageobject.HomePage;
import stellarburgers.site.pageobject.ProfilePage;
import stellarburgers.site.pageobject.SignInPage;
import stellarburgers.user.model.User;

public class UserHelper extends AbstractTest {
    @Step("Авторизация новым пользователем")
    public static User signInNewUser() {
        User user = UserApiHelper.createNewUser();
        new HomePage(driver).goToURL().clickSignInButton();
        new SignInPage(driver).enter(user);
    return user;
    }

    @Step("Открытие страницы личного кабинета авторизованного пользователя")
    //переход по прямой ссылке в личный кабинет не работает
    //поэтому переходим пока что в ЛК через кнопку Личного кабинета на Главной странице
    public static void openProfilePage() {
        signInNewUser();
        new HomePage(driver).clickProfileButton();
        new ProfilePage(driver).checkHeaderTextIsDisplayed();
    }
}
