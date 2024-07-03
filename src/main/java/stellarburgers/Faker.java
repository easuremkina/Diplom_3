package stellarburgers;

public class Faker {
    private static final com.github.javafaker.Faker faker = new com.github.javafaker.Faker();
    public static String getFakeEmail() {
        return faker.letterify("?????-???@????????.ru");
    }

    public static String getFakeName() {
        return faker.name().username();
    }

    public static String getFakePassword() {
        return faker.letterify("?????????");
    }

    public static String getFakeShortPassword() {
        return faker.letterify("?????");
    }
}
