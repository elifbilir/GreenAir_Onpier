package com.greenAir.pages;

import com.greenAir.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static com.greenAir.utilities.BrowserUtils.*;
import static com.greenAir.utilities.Log.log;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickButton(String buttonName) {
        log("Clicking on  the button " + buttonName);

        String xPath1 = String.format("(//button[.='%s'])[1]", buttonName);
        String xPath2 = String.format("(//div[.='%s'])[1]", buttonName);

        if (isPresent(By.xpath(xPath1)))
            click(By.xpath(xPath1));
        else if (isPresent(By.xpath(xPath2)))
            click(By.xpath(xPath2));
        else
            throw new NoSuchElementException("This button could not be handled by the button name.. Please create a generic locator for it.");
    }

    public void fill(String labelName, String value) {
        log(String.format("Filling the %s field.", labelName));
        String xpath = String.format("//label[.='%s']/..//input", labelName);
        WebElement element = getElement(By.xpath(xpath));
        element.clear();
        sendKeys(element, value + Keys.TAB);
    }

    public void checkInfo(String labelName) {
        String xpath = String.format("//td[.='%s:']/following-sibling::td", labelName);
        isPresent(By.xpath(xpath));
    }


}
