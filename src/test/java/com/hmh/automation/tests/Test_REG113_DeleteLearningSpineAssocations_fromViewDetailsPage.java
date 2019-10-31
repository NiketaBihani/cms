//** ALF-2140 ** Deleting a Learning Spines correlation ** Sprint 7.3.3 **
package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHLoginSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

	@Story(HMHApplication.Program.class)
	@RunWith(SerenityParameterizedRunner.class)
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG113_DeleteLearningSpine_fromViewDetailsPage.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class Test_REG113_DeleteLearningSpineAssocations_fromViewDetailsPage  extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

		@Managed(uniqueSession = true) 
		
		@Steps
		private HMHShareHeaderSteps hmhShareHeaderSteps;
	    @Steps
	    private SiteHeaderSteps siteHeaderSteps;
	    @Steps
	    private DocumentLibrarySteps documentLibrarySteps;
	    @Steps
	    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
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
		private HMHSequenceViewSteps hmhSequenceViewSteps;
	    @Steps
		private HMHSiteFinderSteps hmhSiteFinderSteps;
	    @Steps
		private AdminToolsNavigationSteps adminToolsNavigationSteps;
	    @Steps
		private MyProfileSteps myProfileSteps;
	    @Steps
		private UserTrashcanSteps userTrashcanSteps;
	    @Steps
		private HMHLoginSteps hmhloginSteps;

	    String fetchTitle;
	    String  uploadlearningspine,fileName,siteTypeTest,lsTitle,learningspinereport;
	    String type,year, grade, markets, label1, numbering1, objectName, title, description="automation",sbName, ccoName,spine,label,
	    objectNameOld, psName,  level1, sbObjName, cloObjName, cloObjDispTitle,coName, assetName,cloPubRights, versionTwo, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;
	    
	    int noOfLevels=1;
	    private boolean isAssetFound=true;
	    
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }

	    @Test
	    @Title("Test_REG113 Delete Learning Spine from View Details Page")
	    public void test_REG113_DeleteLearningSpineCorrelations_fromViewDetailsPage() {

	    	
	     // Create product set structure
	        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
	        documentLibrarySteps.createNewContent(type);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering1, markets, title);
	        hmhDocumentLibrarySteps.refresh();
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);
	        hmhDocumentLibrarySteps.assetFromListClick(objectName);
	        hmhDocumentLibrarySteps.navBarClick(objectName);
	        shareHeaderSteps.customWait(5);
	        
	        hmhDocumentDetailsSteps.clickEditSequence();
			hmhSequenceViewSteps.checkIfOnSequenceViewPage();
			hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
			hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();	    	
			
	     // Upload learning spine sheet  
	    	hmhShareHeaderSteps.clickOnSharedFiles();
	    	shareHeaderSteps.customWait(5);
	    	hmhDocumentLibrarySteps.assetFromListClickSubCO(uploadlearningspine);
	    	documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
	    	hmhDocumentLibrarySteps.assetFromListClickSubCO(fileName);
	    	
	     // Validate Learning spine report
	    	hmhDocumentLibrarySteps.clickOnValidateLearningSpine();
	    	shareHeaderSteps.customWait(8);
	    	shareHeaderSteps.refreshPage();
	    	
	     // Upload the validated learning spine report
	    	hmhDocumentLibrarySteps.clickOnUploadLearningSpine();
	    	
	     // Navigate to Reports section and Learning spine reports 
	    	hmhShareHeaderSteps.clickOnReports();
	    	hmhShareHeaderSteps.clickOnReportsLearningSpine();
	    	
	     // Store the Learning spine title value 
	    	fetchTitle = hmhShareHeaderSteps.verifyLearningSpineTitle(lsTitle);
	    	
	     // Export the learning spine report	
	    	hmhShareHeaderSteps.clickOnExportToExcelLearningSpine(lsTitle);
	    	
	     // Verify the exported learning spine report in My files
	    	hmhShareHeaderSteps.clickOnMyFiles();
	    	shareHeaderSteps.customWait(5);
	    	hmhDocumentLibrarySteps.assetFromListClickSubCO(learningspinereport);
	    	hmhShareHeaderSteps.verifyExportedLearningSpineReport(fetchTitle);
	    	
	     // Navigate to respective site and associate new learning spine added through UI
	    	hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
	    	siteHeaderSteps.clickOnDocumentLibraryButton();
	    	shareHeaderSteps.customWait(3);
	    	hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
	    	hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);
	        hmhDocumentLibrarySteps.assetFromListClick(objectName);
	        hmhDocumentLibrarySteps.navBarClick(objectName);
	        shareHeaderSteps.customWait(5);
	    	
	    	
		 // Click and verify learning spine is associated with the PS 
			hmhDocumentDetailsSteps.clickOnAssociatelearningSpineAction(spine);
			
		 // Save the Learning spine 
			hmhDocumentDetailsSteps.saveAssociatelearningSpine();
			siteHeaderSteps.customWait(5);
			hmhDocumentLibrarySteps.refresh();
			
		 // Verify the Learning Spine details on View details page
			hmhDocumentDetailsSteps.viewAssociatelearningSpine(spine, label);
			
		 // Delete Learning Spine
			hmhDocumentDetailsSteps.deleteAssociatelearningSpine();
			
		// Navigate to Reports - Learning spine to delete the Spine steps added on 26th Sep 2018 (Sprint 7.3.4)
			hmhShareHeaderSteps.clickOnReports();
			hmhShareHeaderSteps.clickOnReportsLearningSpine();
			hmhShareHeaderSteps.clickOnDeleteLearningSpine(lsTitle);
			hmhShareHeaderSteps.clickOnOkButtonOnDeleteLS();
			
			siteHeaderSteps.customWait(5);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
	        System.out.println("Script completed..");
	           		    	
	    }
	    

}

