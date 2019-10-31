//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
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
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG104_LearningSpinePhase1UploadViaExcel.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class Test_REG104_LearningSpinePhase1UploadViaExcel  extends com.hmh.automation.tools.AbstractSampleTest {

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
	    //
	    @Steps
		private HMHSiteFinderSteps hmhSiteFinderSteps;
	    @Steps
		private AdminToolsNavigationSteps adminToolsNavigationSteps;
	    @Steps
		private MyProfileSteps myProfileSteps;
	    @Steps
		private UserTrashcanSteps userTrashcanSteps;

	    String fetchTitle;
	    String  uploadlearningspine,fileName,siteTypeTest,lsTitle,learningspinereport;
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }

	    @Test
	    @Title("Test_REG104_Learning Spine Phase 1 Upload Via Excel")
	    public void test_REG104_LearningSpinePhase1UploadViaExcel() {

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
	    	shareHeaderSteps.customWait(5);
	    	
	     // Navigate to Reports - Learning spine to delete the Spine steps added on 26th Sep 2018 (Sprint 7.3.4)
			hmhShareHeaderSteps.clickOnReports();
	    	hmhShareHeaderSteps.clickOnReportsLearningSpine();
	    	hmhShareHeaderSteps.clickOnDeleteLearningSpine(lsTitle);
	    	hmhShareHeaderSteps.clickOnOkButtonOnDeleteLS();
	    	
	     // Tear down steps added on 10th Sep 2018 (Sprint 7.3.4)
	    	hmhShareHeaderSteps.clickOnSharedFiles();
	    	shareHeaderSteps.customWait(5);
	    	hmhDocumentLibrarySteps.assetFromListClickSubCO(uploadlearningspine);
	    	hmhDocumentLibrarySteps.assetFromListClickSubCO(fileName);
	    	hmhDocumentLibrarySteps.deleteDocOnViewDetailsLS();
	    	
	    	/*shareHeaderSteps.adminToolsButtonClick();
			adminToolsNavigationSteps.navigateToASpecificTool("Sites Manager");
			shareHeaderSteps.customWait(10);
			hmhSiteFinderSteps.searchAndDeleteSiteFromSiteManager(this.siteName+ConstantsHMH.TODAY_DATE);
			shareHeaderSteps.customWait(5);
			
			//hmhSiteFinderSteps.verifySiteWasDeleted(this.siteName+ConstantsHMH.TODAY_DATE);	*/		
			
			this.shareHeaderSteps.myProfileButtonClick();
			this.myProfileSteps.trashcanMenuClick();
			this.userTrashcanSteps.emptyTrashcan();		
			this.shareHeaderSteps.homeButtonClick();
    
	    	System.out.println("Script completed..");
	    	
	    	
	    	
	    }
	    

}

