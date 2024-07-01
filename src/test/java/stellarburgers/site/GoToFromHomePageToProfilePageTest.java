package stellarburgers.site;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import stellarburgers.site.pageobject.HomePage;
import stellarburgers.site.pageobject.ProfilePage;
import stellarburgers.user.model.User;

public class GoToFromHomePageToProfilePageTest extends AbstractTest {
    User user;
    @Before
    public void init() {
        driver = DriverFactory.getDriver();
        user = UserHelper.signInNewUser();
    }

    @DisplayName("Переход в личный кабинет авторизованным пользователем")
    @Test
    public void clickOnProfileButtonOnHomePage() {
        new HomePage(driver)
                .checkHomePageAuthorizesUserIsDisplayed()
                .clickProfileButton();
        new ProfilePage(driver)
                .checkHeaderTextIsDisplayed();
    }
}
