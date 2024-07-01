package stellarburgers.site.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static stellarburgers.site.additions.EnvConfig.*;

public class ProfilePage extends AbstractPage {
    //Главный текст страницы Профиля
    private final By headerText = By.xpath(".//p[text() = " +
            "'В этом разделе вы можете изменить свои персональные данные']");
    //Кнопка "Конструктор"
    private final By constructorLink = By.xpath(".//p[text()='Конструктор']");
    //Кнопка логотипа
    private final By logoLink = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //Кнопка "Выход"
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Страница Личный кабинет - Проверка наличия на странице текста " +
            "\"В этом разделе вы можете изменить свои персональные данные\"")
    public ProfilePage checkHeaderTextIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(headerText));
        assert driver.findElement(headerText).isDisplayed();
        return this;
    }

    @Step("Страница Личны кабинет - Нажатие на ссылку \"Конструктор\"")
    public void clickConstructorButton() {
        driver.findElement(constructorLink).click();
    }

    @Step("Страница Личны кабинет - Нажатие на логотип")
    public void clickLogoLink() {
        driver.findElement(logoLink).click();
    }

    @Step("Страница Личны кабинет - Нажатие на кнопку \"Выход\"")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
