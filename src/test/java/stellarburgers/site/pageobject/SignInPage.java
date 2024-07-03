package stellarburgers.site.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.user.model.User;

import java.time.Duration;

import static stellarburgers.site.additions.EnvConfig.DEFAULT_TIMEOUT;

public class SignInPage extends AbstractPage {
    //Заголовок формы - текст "Вход"
    private final By headerSignInPage = By.xpath(".//h2[text()='Вход']");
    //Поле "Email"
    private final By emailField = By.xpath("//label[contains(text(),'Email')]/../input");
    //Поле "Пароль"
    private final By passwordField = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Кнопка "Войти"
    private final By signInButton = By.xpath(".//button[text()='Войти']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Страница Авторизации - Проверка появления названия страницы - \"Вход\"")
    public SignInPage checkHeaderSignInPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(headerSignInPage));
        assert driver.findElement(headerSignInPage).isDisplayed();
        return this;
    }
    private void inputField(String fieldValue, By field) {
        driver.findElement(field).isEnabled();
        driver.findElement(field).clear();
        driver.findElement(field).sendKeys(fieldValue);
    }

    @Step("Ввод текста в поле \"Email\"")
    public SignInPage inputEmail(String fieldValue) {
        inputField(fieldValue, emailField);
        return this;
    }

    @Step("Ввод текста в поле \"Пароль\"")
    public SignInPage inputPassword(String fieldValue) {
        inputField(fieldValue, passwordField);
        return this;
    }

    @Step("Клик по кнопке \"Войти\"")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Страница Авторизации - Заполнение формы Входа")
    public void enter(User user) {
        checkHeaderSignInPageIsDisplayed();
        inputEmail(user.getEmail());
        inputPassword(user.getPassword());
        clickSignInButton();
    }
}
