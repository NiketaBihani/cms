package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.CustomizeDashboard.Dashlets.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG036_SavedSearchDashlet.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG036_SavedSearchDashlet extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private CustomizeDashboardSteps customizeDashboardSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    
    
String fileName, siteTypeTest;
String dashlet = "Saved Search";

@Override
public void setSiteType() {
    siteType = siteTypeTest;
}    
    
    @Test
    @Title("Test_REG036 - Saved Search Dashlet, create a dashlet (drag and drop Actions)")
    public void test_REG036_SavedSearchDashlet() {

        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        shareHeaderSteps.homeButtonClick();
        dashboardSteps.customizeDashboardButtonClick();
        customizeDashboardSteps.clickAddDashletsButton();
        customizeDashboardSteps.dragAndDropToColumn1Dashlet(dashlet);
        customizeDashboardSteps.finalizeAddingNewDashlet();
        customizeDashboardSteps.editSavedSearchDashlet(fileName);
        shareHeaderSteps.customWait(5);
        dashboardSteps.customizeDashboardButtonClick();
        customizeDashboardSteps.deleteDashlet(dashlet);
        customizeDashboardSteps.finalizeAddingNewDashlet();
        shareHeaderSteps.customWait(5);
        

    }

}
    
    
