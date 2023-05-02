package com.greenAir.pages;

import static com.greenAir.utilities.BrowserUtils.*;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class FormPage extends BasePage {
    @FindBy(id = "mat-select-value-1")
    private WebElement selectAnrede;

    @FindBy(xpath = "//input[@placeholder='Max']")
    private WebElement inputVorname;

    @FindBy(xpath = "//input[@placeholder='Mustermann']")
    private WebElement inputNachname;

    @FindBy(xpath = "//input[@placeholder='max.mustermann@muster.de']")
    private WebElement inputEMailAdresse;

    @FindBy(xpath = "//input[@placeholder='Max Mustermann']")
    private WebElement inputKontoinhaber;

    @FindBy(xpath = "//input[@placeholder='z.B. DE45 7890 8965 5643 3454 00']")
    private WebElement inputIBAN;

    @FindBy(xpath = "(//div[.='Weiter '])[2]")
    private WebElement weiterButton;

    @FindBy(xpath = "(//div/button[.=' Zurück '])[2]")
    private WebElement zurückButton;

    public void selectTitle(String title) {
        click(selectAnrede);
        String xpath = String.format("//*[.='%s']", title);
        click(By.xpath(xpath));
    }

    public String getValidationMessageByFieldName(String fieldName) {
        By by = By.xpath(String.format("//label[.='%s']/../..//p", fieldName));
        if (isPresent(by))
            return getElement(by).getText();
        else
            return "none";
    }




}
