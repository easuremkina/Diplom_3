package stellarburgers.user.model;

import lombok.Data;
import stellarburgers.Faker;

@Data
public class User {
    private String name;
    private String email;
    private String password;
    public User() { }
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static User createRandom() {
        return new User(Faker.getFakeName(),
                Faker.getFakeEmail(),
                Faker.getFakePassword());
    }
    public static User createRandomWithShortPassword() {
        return new User(Faker.getFakeName(),
                Faker.getFakeEmail(),
                Faker.getFakeShortPassword());
    }
}
