package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;

public class CommonSteps {

    public CommonSteps click(SelenideElement element){
        element.click();

        return this;
    }
}
