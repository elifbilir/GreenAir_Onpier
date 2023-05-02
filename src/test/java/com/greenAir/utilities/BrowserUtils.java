package com.greenAir.utilities;

import org.openqa.selenium.*;

import java.util.List;

public class BrowserUtils {

    public static boolean isPresent(By by) {
        return getElements(by).size() > 0;
    }

    public static WebElement getElement(By by) {
        try {
            return Driver.getDriver().findElement(by);
        } catch (NoSuchElementException | StaleElementReferenceException n) {
            Driver.getDriver().navigate().refresh();
            waitFor(30);
            return Driver.getDriver().findElement(by);
        }
    }

    public static List<WebElement> getElements(By by) {
        return Driver.getDriver().findElements(by);
    }

    public static void click(By by) {
        click(getElement(by));
    }

    public static void click(WebElement elemet) {
        try {
            elemet.click();
        } catch (ElementNotInteractableException e) {
            clickWithJS(elemet);
        }
    }

    public static void sendKeys(WebElement elemet, String value) {
        try {
            elemet.sendKeys(value);
        } catch (WebDriverException e) {
            sendKeysWithJS(elemet, value);
        }
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void sendKeysWithJS(WebElement element, String value) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute('value', '" + element + "')", value);
    }

    public static void waitFor(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getTitle() {
        return Driver.getDriver().getTitle();
    }

    public static boolean isDisplayed(By by) {
        if (isPresent(by))
            return getElement(by).isDisplayed();
        else
            throw new java.util.NoSuchElementException("Element couln't be found while checing is displayed.");
    }
}
