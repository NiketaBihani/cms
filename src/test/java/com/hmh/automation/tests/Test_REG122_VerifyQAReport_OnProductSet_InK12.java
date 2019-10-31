//** ALF-2224 ** Additional Columns in QA Report ** Sprint 7.3.3 **
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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.VersionControl.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG122_VerifyQAReport_OnProductSet_InK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG122_VerifyQAReport_OnProductSet_InK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
	@Steps
	private MyProfileSteps myProfileSteps;
	@Steps
	private UserTrashcanSteps userTrashcanSteps;
	@Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;

    String siteTypeTest, productSetType, name, year, grade, levle1, numbering0, market, title, fileName, versionAction, description, right;
    String resourceType = "Other";
    String firstVersion = "1.0";
    String versionTwo = "2.0";
    String versionComment = "New Version";
    String qaReport = "QA Reports";
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test REG122 Verify QA Report On Product Set In K12 Site")
    public void test_REG122_VerifyQAReport_OnProductSet_InK12() {
   
    	// Create product set structure
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        documentLibrarySteps.createNewContent(productSetType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(name, year, grade, levle1, numbering0, market, title);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick(name);
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);
        hmhDocumentDetailsSteps.clickonVersion();
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);

        siteHeaderSteps.clickOnDocumentLibraryButton();
        
        String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString(); 
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick(name);
        hmhDocumentDetailsSteps.clickonVersion();
        
        //Version Pop up		
      	// Verify Version pop up Cancel button
      	hmhDocumentDetailsSteps.clickonVersioncancel();
      	hmhDocumentDetailsSteps.clickonVersion();
      	
      	// Enter Comment
      	hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
      	
      	// Verify Version pop up Save button
      	hmhDocumentDetailsSteps.clickonVersionsave();      		
      	hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
        hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
        
        // Click on QA Report and download
        hmhDocumentDetailsSteps.clickQAReport();
        
        // Navigate to My files and Navigate to QA Reports 
        hmhShareHeaderSteps.clickOnMyFiles();
    	shareHeaderSteps.customWait(5);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(qaReport);
    	//hmhDocumentLibrarySteps.assetFromListClick(name);
    	//hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
    	 	
   
    }
}
