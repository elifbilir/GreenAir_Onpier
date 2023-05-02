package com.greenAir.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class FahrzeugscheinHochladen extends BasePage{
    @FindBy(xpath = "//input[@id='Fahrzeugschein Vorderseite']")
    private WebElement fahrzeugscheinVorderseite;

    @FindBy(xpath = "//input[@id='Fahrzeugschein Rückseite']")
    private WebElement fahrzeugscheinRuckseite;
}
