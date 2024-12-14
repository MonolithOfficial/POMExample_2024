package ge.tbc.testautomation.pages;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.testautomation.data.PricingConstants;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class PricingPage {
    public SelenideElement devCraftUIBundlePricingInfo = $(byCssSelector("tr.Pricings-info"))
            .$(byCssSelector("th.UI.is-active"));
    public SelenideElement devCraftCompleteBundlePricingInfo = $(byCssSelector("tr.Pricings-info"))
            .$(byCssSelector("th.Complete"));
    public SelenideElement devCraftUltimateBundlePricingInfo = $(byCssSelector("tr.Pricings-info"))
            .$(byCssSelector("th.Ultimate"));
    public SelenideElement devCraftUIBundlePricingSupport = $(byCssSelector("tr.Pricings-support"))
            .$(byCssSelector("th.UI.is-active"));
    public SelenideElement devCraftCompleteBundlePricingSupport = $(byCssSelector("tr.Pricings-support"))
            .$(byCssSelector("th.Complete"));
    public SelenideElement devCraftUltimateBundlePricingSupport = $(byCssSelector("tr.Pricings-support"))
            .$(byCssSelector("th.Ultimate"));
    public SelenideElement featureTable = $(byCssSelector("table.PricingTable"));
    public SelenideElement devCraftUILabel = $(byTagAndText("h5", PricingConstants.DEVCRAFT_UI));
    public SelenideElement devCraftCompleteLabel = $(byTagAndText("h5", PricingConstants.DEVCRAFT_COMPLETE));
    public SelenideElement devCraftUltimateLabel = $(byTagAndText("h5", PricingConstants.DEVCRAFT_ULTIMATE));
}
