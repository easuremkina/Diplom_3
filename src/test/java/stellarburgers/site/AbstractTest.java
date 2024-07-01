package stellarburgers.site;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import stellarburgers.Checks;
import stellarburgers.user.UserClientImpl;
import stellarburgers.user.model.User;

import java.util.ArrayList;

import static stellarburgers.site.UserApiHelper.getAccessToken;

public abstract class AbstractTest {
    protected static final UserClientImpl client = new UserClientImpl();
    protected static final Checks check = new Checks();
    protected static final ArrayList<User> user_list_for_disposal = new ArrayList<>();
    protected static WebDriver driver;

    @After
    public void after() {
        driver.quit();
    }

    @AfterClass
    public static void deleteUser() {
        for (User user : user_list_for_disposal) {
            String accessToken = getAccessToken(user);
            client.deleteUserRequest(accessToken);
        }
    }
}
