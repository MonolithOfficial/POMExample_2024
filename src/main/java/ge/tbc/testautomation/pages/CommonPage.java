package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CommonPage {
    public SelenideElement pricingLink = $(byXpath("//a[text()='Pricing' and not(contains(@class,'Footer'))]"));
}
