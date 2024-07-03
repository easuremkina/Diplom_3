package stellarburgers.user;

import lombok.Data;
import stellarburgers.user.model.User;

@Data
public class Credentials {
    private String email;
    private String password;

    private Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Credentials fromUser(User user) {
        return new Credentials(user.getEmail(), user.getPassword());
    }
}
