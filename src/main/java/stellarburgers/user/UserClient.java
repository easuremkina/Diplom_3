package stellarburgers.user;

import io.restassured.response.ValidatableResponse;
import stellarburgers.user.model.User;

public interface UserClient {
    ValidatableResponse createUserRequest(User user);
    ValidatableResponse loginRequest(Credentials credentials);
    void deleteUserRequest(String accessToken);
}
