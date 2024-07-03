package stellarburgers.site;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverFactory {
    private  static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            InputStream resourceAsStream = DriverFactory.class
                    .getClassLoader().getResourceAsStream("config.properties");
            Properties properties = new Properties();
            try {
                properties.load(resourceAsStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String browser = properties.getProperty("browser");
            switch (browser) {
                case "yandex":
                    System.setProperty("webdriver.chrome.driver","src/test/resources/yandexdriver.exe");
                    return new ChromeDriver();
                case "chrome":
                    return WebDriverManager.chromedriver().create();
                default:
                    throw  new RuntimeException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }
}
