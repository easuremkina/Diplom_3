package stellarburgers.site.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stellarburgers.site.additions.EnvConfig.*;

public class SignUpPage extends AbstractPage {
    //Поле "Имя"
    private final By nameField = By.xpath("//label[contains(text(),'Имя')]/../input");
    //Поле "Email"
    private final By emailField = By.xpath("//label[contains(text(),'Email')]/../input");
    //Поле "Пароль"
    private final By passwordField = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Кнопка "Зарегистрироваться"
    private final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Кнопка "Вход"
    private final By signInLink = By.xpath("//a[text()='Войти']");
    //Блок информации о некорректном пароле
    private final By errorMessageIncorrectPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @Step("Переход по прямой ссылке на страницу \"Регистрация\"")
    public SignUpPage goToURL() {
        driver.get(STELLARBURGERS_REGISTER_URL);
        return this;
    }

    @Step("Проверка доступности, очистка поля, и заполнение")
    private void inputField(String fieldValue, By field) {
        driver.findElement(field).isEnabled();
        driver.findElement(field).clear();
        driver.findElement(field).sendKeys(fieldValue);
    }

    @Step("Ввод текста в поле \"Имя\"")
    public SignUpPage inputName(String fieldValue) {
        inputField(fieldValue, nameField);
        return this;
    }


    @Step("Ввод текста в поле \"Email\"")
    public SignUpPage inputEmail(String fieldValue) {
        inputField(fieldValue, emailField);
        return this;
    }

    @Step("Ввод текста в поле \"Пароль\"")
    public SignUpPage inputPassword(String fieldValue) {
        inputField(fieldValue, passwordField);
        return this;
    }

    @Step("Клик по кнопке \"Зарегистрироваться\"")
    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return this;
    }

    @Step("Клик по кнопке \"Войти\"")
    public SignUpPage clickSignInLink() {
        driver.findElement(signInLink).click();
        return this;
    }

    @Step("Страница Регистрации - Проверка сообщения об ошибке \"Некорректный пароль\" при коротком пароле")
    public void checkErrorMessageIncorrectPasswordIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(errorMessageIncorrectPassword));
        assert driver.findElement(errorMessageIncorrectPassword).isDisplayed();
    }
}
