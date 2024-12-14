package ge.tbc.testautomation.tests.pricing;

import com.codeborne.selenide.Configuration;
import ge.tbc.testautomation.pages.CommonPage;
import ge.tbc.testautomation.pages.PricingPage;
import ge.tbc.testautomation.steps.CommonSteps;
import ge.tbc.testautomation.steps.PricingSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.testautomation.data.PricingConstants.*;

public class BundleOfferTests {
    CommonPage commonPage;
    CommonSteps commonSteps;
    PricingPage pricingPage;
    PricingSteps pricingSteps;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        commonPage = new CommonPage();
        commonSteps = new CommonSteps();
        pricingPage = new PricingPage();
        pricingSteps = new PricingSteps();
    }

    @BeforeMethod
    public void openBrowser(){
        open("https://www.telerik.com/support/demos");
    }

    @Test(description = "Validate availability configuration of various features in bundle offers")
    public void validateBundleOffers() {
        commonSteps.click(commonPage.pricingLink);
        pricingSteps.
                validateNotSupported(pricingPage.devCraftUIBundlePricingInfo, MOCKING_SOLUTION_FEATURE)
                .validateNotSupported(pricingPage.devCraftUIBundlePricingSupport, ISSUE_ESCALATION)
                .validateNotSupported(pricingPage.devCraftCompleteBundlePricingSupport, ISSUE_ESCALATION)
                .validateSupported(pricingPage.devCraftUltimateBundlePricingSupport, ISSUE_ESCALATION)
                .validateNotSupported(pricingPage.devCraftUIBundlePricingInfo, REPORT_MANAGEMENT_SOLUTION)
                .validateNotSupported(pricingPage.devCraftCompleteBundlePricingInfo, REPORT_MANAGEMENT_SOLUTION)
                .validateSupported(pricingPage.devCraftUltimateBundlePricingInfo, REPORT_MANAGEMENT_SOLUTION)
                .validateNotAvailableWithDot(TEST_STUDIO, DEVCRAFT_UI)
                .validateNotAvailableWithDot(TEST_STUDIO, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(TEST_STUDIO, DEVCRAFT_ULTIMATE)
                .validateAvailableWithDot(JQUERY, DEVCRAFT_UI)
                .validateAvailableWithDot(JQUERY, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(JQUERY, DEVCRAFT_ULTIMATE)
                .validateInstancesAndUsers(REPORT_SERVER, DEVCRAFT_ULTIMATE, REPORT_SERVER_INSTANCES, REPORT_SERVER_USERS)
                .validateNotAvailableWithDot(REPORTING, DEVCRAFT_UI)
                .validateAvailableWithDot(REPORTING, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(REPORTING, DEVCRAFT_ULTIMATE)
                .validateAvailableWithDot(ON_DEMAND_VIDEOS, DEVCRAFT_UI)
                .validateAvailableWithDot(ON_DEMAND_VIDEOS, DEVCRAFT_COMPLETE)
                .validateAvailableWithDot(ON_DEMAND_VIDEOS, DEVCRAFT_ULTIMATE)
                .checkStickyOfferNameBehavior(
                        pricingPage.devCraftUILabel,
                        pricingPage.devCraftCompleteLabel,
                        pricingPage.devCraftUltimateLabel);
    }
}
