package stellarburgers.user;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import stellarburgers.Client;
import stellarburgers.user.model.User;

public class UserClientImpl extends Client implements UserClient {
    private static final String CREATE_USER_ENDPOINT = "/auth/register";
    private static final String LOGIN_ENDPOINT = "/auth/login";
    private static final String USER_ENDPOINT  = "/auth/user";

    @Step("Отправка запроса на создание пользователя")
    @Override
    public ValidatableResponse createUserRequest(User user) {
        return requestSpecification()
                .body(user)
                .when()
                .post(CREATE_USER_ENDPOINT)
                .then().log().all();
    }

    @Step("Отправка запроса  на авторизацию")
    @Override
    public ValidatableResponse loginRequest(Credentials credentials) {
        System.out.println("Credentials" + credentials);
        return requestSpecification()
                .body(credentials)
                .when()
                .post(LOGIN_ENDPOINT)
                .then().log().all();
    }

    @Step("Отправка запроса на удаление пользователя")
    @Override
    public void deleteUserRequest(String accessToken) {
        requestSpecification()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_ENDPOINT)
                .then().log().all();
    }
}
