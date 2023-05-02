package com.greenAir.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Getter
public class LandingPage extends BasePage {

    @FindBy(xpath = "(//label[@class='h-auto md:w-full'])[1]")
    private WebElement klasseM1;

    @FindBy(xpath = "(//label[@class='h-auto md:w-full'])[2]")
    private WebElement fahrzeugshein;

    @FindBy(xpath = "(//label[@class='h-auto md:w-full'])[3]")
    private WebElement klasseN1;

    @FindBy(xpath = "(//span[.=' Prämie beantragen '])[1]")
    private WebElement flexPramieBentragen;

    @FindBy(xpath = "(//span[.=' Prämie beantragen '])[2]")
    private WebElement sofortPramieBentragen;

    @FindBy(xpath = "(//div[@class='flex justify-center items-center'])[1]")
    private WebElement weiterButton;

}

