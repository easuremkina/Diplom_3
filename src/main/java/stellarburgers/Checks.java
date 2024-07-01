package stellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.CoreMatchers.equalTo;

public class Checks {
    @Step("Проверка - тело содержит поле success: true")
    public void bodyContainsSuccessTrue(ValidatableResponse response) {
        response
                .assertThat()
                .body("success", equalTo(true));
    }
}
