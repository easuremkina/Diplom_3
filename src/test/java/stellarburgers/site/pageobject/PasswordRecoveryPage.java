package stellarburgers.site.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stellarburgers.site.additions.EnvConfig.DEFAULT_TIMEOUT;
import static stellarburgers.site.additions.EnvConfig.STELLARBURGERS_PASSWORD_RECOVERY_URL;

public class PasswordRecoveryPage extends AbstractPage {
    //Ссылка "Войти"
    private final By signInLink = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы восстановления пароля по прямой ссылке")
    public PasswordRecoveryPage goToURL() {
        driver.get(STELLARBURGERS_PASSWORD_RECOVERY_URL);
        return this;
    }

    @Step("Страница восстановления пароля - Нажатие на кнопку \"Войти\"")
    public void clickSignInLink() {
        checkSignInLinkButtonIsDisplayed();
        driver.findElement(signInLink).click();
    }

    @Step("Страница восстановления пароля - Проверка наличия на странице ссылки \"Войти\"")
    public void checkSignInLinkButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(signInLink));
        assert driver.findElement(signInLink).isDisplayed();
    }
}
