package ge.tbc.testautomation.steps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.pages.PricingPage;
import ge.tbc.testautomation.util.TableHandler;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PricingSteps extends CommonSteps {
    PricingPage pricingPage = new PricingPage();

    public PricingSteps validateNotSupported(SelenideElement bundle, String feature){
        bundle.shouldNotHave(text(feature));

        return this;
    }

    public PricingSteps validateSupported(SelenideElement bundle, String feature){
        bundle.shouldHave(text(feature));

        return this;
    }

    public PricingSteps validateAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText("●"));
        return this;
    }

    public PricingSteps validateNotAvailableWithDot(String forFeature, String inBundle){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldNotHave(innerText("●"));
        return this;
    }

    public PricingSteps validateInstancesAndUsers(String forFeature, String inBundle, int instances, int users){
        SelenideElement dotCell = TableHandler.findCellByLabels(
                forFeature,
                inBundle,
                pricingPage.featureTable);
        dotCell.scrollTo().shouldHave(innerText(String.format("%d instance with %d users", instances, users)));
        return this;
    }

    public PricingSteps checkStickyOfferNameBehavior(SelenideElement... elements){
        executeJavaScript("window.scrollTo(0, 0);");
        for (SelenideElement element :
                elements) {
            element.shouldBe(visible);
        }
        executeJavaScript("window.scrollBy(0, 2000);");
        for (SelenideElement element :
                elements) {
            element.shouldBe(visible);
        }
        return this;
    }
}
