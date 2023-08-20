package com.github.mablinov.samokat;

import com.github.mablinov.samokat.pageobject.ImportantQuestionsPage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestImportantQuestion {
    private final String question;
    private final String answer;
    private final int order;

    public TestImportantQuestion(String question, String answer, int order) {
        this.question = question;
        this.answer = answer;
        this.order = order;
    }

    @Parameterized.Parameters
    public static Object[] getTestData() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
        };
    }

    @Rule
    public DriverFactory factory = new DriverFactory();

    @Test
    public void shouldCheckAnswers() {
        WebDriver driver = factory.getDriver();

        ImportantQuestionsPage questionsPage = new ImportantQuestionsPage(driver);

        questionsPage.openWindow();

        assertFalse("Answer already opened", questionsPage.isAnswerVisible(answer, order));

        questionsPage.clickQuestion(question);

        assertTrue("Answer incorrect", questionsPage.isAnswerVisible(answer, order));
    }

}
