package com.github.mablinov.samokat.pageobject;

import com.github.mablinov.samokat.TestVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ImportantQuestionsPage {
    private final WebDriver driver;

    public ImportantQuestionsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWindow() {
        driver.get(TestVariables.URL);
    }

    public void clickQuestion(String question) {
        By element = By.xpath(".//div[text() = '" + question + "']");
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", webElement);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
    }

    public boolean isAnswerVisible(String answer, int answerOrder) {
        new WebDriverWait(driver, Duration.ofSeconds(1));
        By element = By.xpath(".//div[@id = 'accordion__panel-" + answerOrder + "']");
        boolean isVisible = driver.findElements(element)
                .stream()
                .filter(webElement -> webElement.getAttribute("hidden") == null)
                .count() == 1;
        if (isVisible) {
            By pElement = By.xpath(".//div[@id = 'accordion__panel-" + answerOrder + "']/p[text() = '" + answer + "']");
            return driver.findElements(pElement).size() == 1;
        } else {
            return false;
        }
    }

}
