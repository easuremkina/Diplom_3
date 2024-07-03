package stellarburgers.site;

import io.restassured.response.ValidatableResponse;
import stellarburgers.user.Credentials;
import stellarburgers.user.checks.LoginChecks;
import stellarburgers.user.model.User;
import io.qameta.allure.Step;

public class UserApiHelper extends AbstractTest {
    @Step("Создание нового пользователя через API")
    public static User createNewUser() {
        User user = User.createRandom();
        ValidatableResponse response = client.createUserRequest(user);
        user_list_for_disposal.add(user);
        check.bodyContainsSuccessTrue(response);
        return user;
    }

    @Step("Получение токена пользователя через API")
    public static String getAccessToken(User user) {
        Credentials creds = Credentials.fromUser(user);
        ValidatableResponse responseLogin = client.loginRequest(creds);
        return LoginChecks.bodyLoggedContainsAccessToken(responseLogin);
    }
}
