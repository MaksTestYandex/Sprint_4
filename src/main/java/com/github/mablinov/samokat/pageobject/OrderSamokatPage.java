package com.github.mablinov.samokat.pageobject;

import com.github.mablinov.samokat.TestVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderSamokatPage {
    private final WebDriver driver;

    // локатор кнопки "Заказать"

    //Верхняя кнопка
    private final By headerStartOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //Средняя кнопка
    private final By bottomStartOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

// Форма клиента

    // Локатор поля Имя
    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']");

    // Локатор поля Фамилия
    private final By secondNameField = By.xpath(".//input[@placeholder = '* Фамилия']");

    //Локатор поля Адрес
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");

    //Локатор  поля Станиция метро
    private final By metroStationField = By.xpath(".//input[@placeholder = '* Станция метро']");

    //Локатор подтвреждения значения Проспект Мира
    //   private By confirmMetroStation = By.xpath(".//button[@value = '99']");

    //Локатор поля Телефон
    private final By telephoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");

    //Локатор  кнопки Далее
    private final By nextButton = By.xpath(".//button[text() = 'Далее']");

//Заполняем форму атрибутов аренды

    //Дата
    private final By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");

    //Срок
    //Кнопка открытия списка меню
    private final By openPeriodButton = By.xpath(".//span[@class = 'Dropdown-arrow']");

    //Кнопка выбора пункта меню
    private final By selectPeriod = By.xpath(".//div[@class='Dropdown-menu']/div[1]");

    // Выбрать цвет самоката
    private final By ColourCheckbox = By.xpath(".//input[@class='Checkbox_Input__14A2w']");

    // Поле Коментарий
    private final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");

    // Кнопка "Заказать"
    private final By finalOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Кнопка ДА
    private final By confirmYesButton = By.xpath(".//button[text() = 'Да']");

    //Кнопка Статус
    private final By statusButton = By.xpath(".//button[text() = 'Посмотреть статус']");

    // конструктор класса
    public OrderSamokatPage(WebDriver driver) {
        this.driver = driver;
    }

    // Нажимаем кнопку "Заказать"
    public void clickStartHeaderOrderButton() {
        driver.findElement(headerStartOrderButton).click();
    }

    public void waitStartHeaderOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(headerStartOrderButton));
    }

    public void clickStartBottomOrderButton() {
        driver.findElement(bottomStartOrderButton).click();
    }

    public void waitStartBottomOrderButton() {
        WebElement webElement = driver.findElement(bottomStartOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(bottomStartOrderButton));
    }

// Заполняем форму клиента

    // Поле Имя
    public void inputName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    // Поле Фамилия
    public void inputSecondName(String secondName) {
        driver.findElement(secondNameField).sendKeys(secondName);
    }

    // Поле Адрес
    public void inputAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // Поле Станиция метро
    // Нажимаем поле Метро
    public void clickMetroStationField() {
        driver.findElement(metroStationField).click();
    }

    // В поиск вводим значение Проспект Мира
    public void inputMetroStation(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation);
    }

    // Подтверждаем станцию Проспект Мира
    public void clickConfirmMetroStation(String metroStationId) {
        By element = By.xpath(".//button[@value = '" + metroStationId + "']");
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    // Поле Телефон
    // Ввводим номер телефона
    public void inputTelephone(String telephoneNumber) {
        driver.findElement(telephoneField).sendKeys(telephoneNumber);
    }

    // Кнопка Далее
    public void clickNextButton() {

        driver.findElement(nextButton).click();
    }

// Заполняем форму атрибутов аренды

    //Дата
    public void clickDateField() {
        driver.findElement(dateField).click();
    }

    public void inputDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    // Срок
    // нажимаем кнопку открытия списка меню
    public void clickPeriodButton() {
        driver.findElement(openPeriodButton).click();
    }

    // Выбираем период [1]
    public void clickPeriodOption() {
        driver.findElement(selectPeriod).click();
    }

    // Выбрать цвет самоката
    public void clickColourCheckbox() {
        driver.findElement(ColourCheckbox).click();
    }

    // Коментарий
    // Нажимаем на поле Комментарий
    public void clickCommentField() {
        driver.findElement(commentField).click();
    }

    // Вносим Комментарий
    public void inputComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // Нажимаем кнопку "Заказать"
    public void clickFinalOrderButton() {
        driver.findElement(finalOrderButton).click();
    }

    // В сплывающем окне нажать ДА
    public void clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.elementToBeClickable(confirmYesButton));
        driver.findElement(confirmYesButton).click();
    }

    // Метод для открытия страницы
    public void openWindow() {
        driver.get(TestVariables.URL);
    }

    // Метод проверки появления доступности кнопки "Статус заказа"
    public boolean statusButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3));
        List<WebElement> elements = driver.findElements(statusButton);
        return !elements.isEmpty();
    }

    // Объеденил в один шаг заполнение формы клиента
    public void clientFormInput(String name, String secondName, String address, String metroStation, String metroStationId, String telephone) {
        inputName(name);
        inputSecondName(secondName);
        inputAddress(address);
        clickMetroStationField();
        inputMetroStation(metroStation);
        clickConfirmMetroStation(metroStationId);
        inputTelephone(telephone);
    }

    // Объеденил в один шаг заполнение формы параметров заказа
    public void orderPropertiesInput(String date, String comment) {
        clickDateField();
        inputDate(date);
        clickPeriodButton();
        clickPeriodOption();
        clickColourCheckbox();
        clickCommentField();
        inputComment(comment);
    }
}
