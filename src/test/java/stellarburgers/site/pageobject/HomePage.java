package stellarburgers.site.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stellarburgers.site.enums.IngredientType;

import java.time.Duration;

import static stellarburgers.site.additions.EnvConfig.*;

public class HomePage extends AbstractPage {
    //Кнопка "Войти в аккаунт"
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Личный кабинет"
    private final By profileButton = By.xpath(".//p[contains(text(),'Личный Кабинет')]");
    //Кнопка "Оформить заказ"
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");
    //Название вкладки "Булки"
    private final By bunsTabName = By.xpath(".//div[span[text()='Булки']]");
    //Название вкладки "Соусы"
    private final By saucesTabName = By.xpath(".//div[span[text()='Соусы']]");
    //Название вкладки "Начинки"
    private final By fillingsTabName = By.xpath(".//div[span[text()='Начинки']]");
    //Локатор булок
    private final By bunsCurrentTab = By.xpath("//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    //Локатор соусов
    private final By saucesCurrentTab = By.xpath("//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    //Локатор начинки
    private final By fillingsCurrentTab = By.xpath("//div[contains(span/text(),'Начинки') and contains(@class,'current')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие главной страницы по прямой ссылке")
    public HomePage goToURL() {
        driver.get(STELLARBURGERS_BASE_URL);
        return this;
    }

    @Step("Главная страница - Нажатие на  кнопку \"Войти в аккаунт\"")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Step("Главная страница - Нажатие на  кнопку \"Личный кабинет\"")
    public void clickProfileButton() {
        driver.findElement(profileButton).click();
    }

    @Step("Главная страница - Авторизованный пользователь: Проверка наличия на странице кнопки \"Оформить заказ\"")
    public HomePage checkHomePageAuthorizesUserIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        assert driver.findElement(orderButton).isDisplayed();
        return this;
    }

    @Step("Главная страница - Нажатие на название вкладки ингредиентов")
    public HomePage clickTab(IngredientType ingredientType) {
        By element;
        if (ingredientType == IngredientType.BUN) {
            element = bunsTabName;
        } else if (ingredientType == IngredientType.SAUCE) {
            element = saucesTabName;
        } else if (ingredientType == IngredientType.MAIN) {
            element = fillingsTabName;
        } else {
            throw new RuntimeException("Unsupported ingredientType - " + ingredientType);
        }

        driver.findElement(element).click();
        return new HomePage(driver);
    }

    @Step("Главная страница - Проверка текущей вкладки")
    public HomePage checkCurrentTabIsDisplayed(IngredientType ingredientType){
        By currentTab;
        if (ingredientType == IngredientType.BUN) {
            currentTab = bunsCurrentTab;
        } else if (ingredientType == IngredientType.SAUCE) {
            currentTab = saucesCurrentTab;
        } else if (ingredientType == IngredientType.MAIN) {
            currentTab = fillingsCurrentTab;
        } else {
            throw new RuntimeException("Unsupported ingredientType - " + ingredientType);
        }
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(currentTab));
        assert driver.findElement(currentTab).isDisplayed();
        return new HomePage(driver);
    }
}
