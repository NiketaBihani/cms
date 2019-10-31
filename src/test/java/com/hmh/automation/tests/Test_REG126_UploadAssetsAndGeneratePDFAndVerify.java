//** ALF-2333 **  Trade: Ability to generate a PDF without first creating a collection ** Sprint 7.3.5 **

package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.Constants;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement;

@Story(HMHApplication.Asset.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG126_UploadAssetsAndGeneratePDFAndVerify.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG126_UploadAssetsAndGeneratePDFAndVerify  extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHSetupSteps hmhSetupSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    

    
    private String  Assets,siteTypeTest, fileName,assetsstatus,fileName1;
    String pdfReports ="PDF_Report";
    int waitForSearchResultsSeconds = 10;
    
    
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test - REG126 Upload Assets And Generate PDF And Verify")
    public void test_REG126_UploadAssetsAndGeneratePDFAndVerify() {
    	
    	//Create Asset
    	 hmhDocumentLibrarySteps.assetFromListClick(Assets);
    	 documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);  	
         shareHeaderSteps.customWait(3);
       
         // Create another asset
         documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
         shareHeaderSteps.customWait(3);
         
         // Generate PDF by selecting both the assets
         hmhSearchResultsSteps.clickCheckBoxOnAssets(fileName, fileName1);
	     hmhDocumentDetailsSteps.clickOnGeneratePDFOnAssets();
	     shareHeaderSteps.customWait(5);
	     hmhShareHeaderSteps.clickOnMyFiles();
	     shareHeaderSteps.customWait(10);
	     
	     // Verify the PDF generated file
	     hmhDocumentDetailsSteps.clickOnPDFReportsFolder();
	     shareHeaderSteps.customWait(5);
	     hmhDocumentLibrarySteps.assetFromListClickSub(pdfReports);
	     shareHeaderSteps.customWait(5);
	     hmhDocumentDetailsSteps.verifyGeneratedPDFReport(fileName, fileName1);
	     
	     // Go to Quick Search and select assets and generate PDF
	     hmhSiteFinderSteps.searchUserSites(this.K12siteSearch);
	     hmhSiteFinderSteps.openTheUserSiteFound(this.K12siteSearch);
	     siteHeaderSteps.clickOnDocumentLibraryButton();
	     documentLibrarySteps.enterTextInSearchBox(fileName);
	     shareHeaderSteps.customWait(10);
	     hmhSearchResultsSteps.isElementPresentInSearchResult(fileName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
	     hmhSearchResultsSteps.SearchCheck();
	     hmhSearchResultsSteps.clickGeneratePDFActionOnSearchPage();
	     shareHeaderSteps.customWait(3);
	     
	     // Verify the PDF generated file
	     hmhShareHeaderSteps.clickOnMyFiles();
	     shareHeaderSteps.customWait(10);
	     hmhDocumentDetailsSteps.clickOnPDFReportsFolder();
	     shareHeaderSteps.customWait(5);
	     hmhDocumentLibrarySteps.assetFromListClickSub(pdfReports);
	     shareHeaderSteps.customWait(5);
	     hmhDocumentDetailsSteps.verifyGeneratedPDFReport(fileName, fileName1);
	       
	     System.out.println("Script Completed..");

    }
}



	


