package com.github.mablinov.samokat;

import com.github.mablinov.samokat.pageobject.OrderSamokatPage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestOrderSamokat {
    private final String name;
    private final String secondName;
    private final String address;
    private final String metroStation;
    private final String metroStationId;
    private final String telephoneNumber;
    private final String date;
    private final String comment;

    @Rule
    public DriverFactory factory = new DriverFactory();

    public TestOrderSamokat(String name, String secondName, String address, String metroStation, String metroStationId, String telephoneNumber, String date, String comment) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroStation = metroStation;
        this.metroStationId = metroStationId;
        this.telephoneNumber = telephoneNumber;
        this.date = date;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {"Иван", "Иванов", "Москва, пр. Мира, д.122", "Проспект Мира", "99", "+7132456798", "18.08.2023", "За час позвонить"},
                {"Петр", "Петров", "Москва, пр. Мира, д.122", "Сокольники", "4", "+7132456798", "19.08.2023", "-"}
        };
    }

    @Test
    public void shouldCreateOrderByHeaderButton() {
        WebDriver driver = factory.getDriver();

        OrderSamokatPage orderPage = new OrderSamokatPage(driver);

        orderPage.openWindow();
        orderPage.waitStartHeaderOrderButton();
        orderPage.clickStartHeaderOrderButton();

        // Заполняем форму клиента
        orderPage.clientFormInput(name, secondName, address, metroStation, metroStationId, telephoneNumber);

        orderPage.clickNextButton();

        //Заполняем форму атрибутов аренды
        orderPage.orderPropertiesInput(date, comment);

        // Нажать на кнопку "Заказать"
        orderPage.clickFinalOrderButton();

        // нажимаем на кнопку Да
        orderPage.clickYesButton();

        assertTrue("Заказ не создан", orderPage.statusButtonVisible());
    }

    @Test
    public void shouldCreateOrderByBottomButton() {
        WebDriver driver = factory.getDriver();

        OrderSamokatPage orderPage = new OrderSamokatPage(driver);

        orderPage.openWindow();
        orderPage.waitStartBottomOrderButton();
        orderPage.clickStartBottomOrderButton();

        // Заполняем форму клиента
        orderPage.clientFormInput(name, secondName, address, metroStation, metroStationId, telephoneNumber);

        orderPage.clickNextButton();

        //Заполняем форму атрибутов аренды
        orderPage.orderPropertiesInput(date, comment);

        // Нажать на кнопку "Заказать"
        orderPage.clickFinalOrderButton();

        // нажимаем на кнопку Да
        orderPage.clickYesButton();

        assertTrue("Заказ не создан", orderPage.statusButtonVisible());
    }

}
