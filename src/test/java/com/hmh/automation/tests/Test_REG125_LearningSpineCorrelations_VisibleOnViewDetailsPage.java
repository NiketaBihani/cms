//** ALF-2128 ** Learning Spine Correlations are Visible on the View Details Page ** Sprint 7.3.4 **
//** ALF-2140 **  Deleting a Learning Spine Correlations ** Sprint 7.3.4 **

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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
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
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.ProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG125_LearningSpineCorrelations_VisibleOnViewDetailsPage.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG125_LearningSpineCorrelations_VisibleOnViewDetailsPage extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Managed(uniqueSession = true) 

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
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private LoginSteps loginSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHSetupSteps hmhSetupSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
	@Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
	@Steps
	private MyProfileSteps myProfileSteps;
	@Steps
	private UserTrashcanSteps userTrashcanSteps;

	private boolean isAssetFound=true;
    String type,year, grade, markets, label1, numbering1, objectName, title, siteTypeTest, description="automation",sbName, ccoName,spine,label,
    objectNameOld, psName,  level1, sbObjName, cloObjName, cloObjDispTitle,coName, assetName,cloPubRights, versionTwo, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;
    String uploadlearningspinecorrelation = "Upload Learning Skill Correlations";
    String fileName = "Automation-testing_Content-Objects_CorrelationsReport_DoNotDelete.xlsx";
    String correlationsreport= "Correlations Report";
    String CorrelationsReport = "automationk12site";
    String ContentobjectName ="tc112_COObject";
    int noOfLevels=1;
    private boolean isFileFound=true;
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG125_LearningSpineCorrelations_VisibleOnViewDetailsPage")
    public void test_REG125_LearningSpineCorrelations_VisibleOnViewDetailsPage() {

    	hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
    	this.isFileFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);
    	
    	if (isFileFound == false){
    		   	
    	// Create product set structure
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
    	}
    	
    	siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(20);		
		// Click on Generate Correlations Report on Product Set       
        hmhEditPropertiesSteps.clickGenerateCorrelationActionOnPS();
		
		// View and Download Correlations Report in My Files
		/*hmhShareHeaderSteps.clickOnMyFiles();
    	shareHeaderSteps.customWait(5);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(correlationsreport);
    	hmhDocumentLibrarySteps.assetFromListClick(CorrelationsReport);
    	hmhDocumentDetailsSteps.clickDownloadAction();  	
    	shareHeaderSteps.customWait(5);*/
				
		// Upload learning spine correlations sheet
    	hmhShareHeaderSteps.clickOnSharedFiles();
    	shareHeaderSteps.customWait(5);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(uploadlearningspinecorrelation);
    	documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(fileName);
    	
    	// Correlate Standards for Learning spine
    	hmhEditPropertiesSteps.clickCorrelateStandards();
    	//shareHeaderSteps.customWait(5);
    	shareHeaderSteps.refreshPage();
    	hmhShareHeaderSteps.logoutButtonClick();
    	
    	loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.K12_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.K12_SITE_NAME);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ContentobjectName);
		hmhDocumentLibrarySteps.navBarClick(ContentobjectName);
		hmhShareHeaderSteps.logoutButtonClick();
		//hmhDocumentDetailsSteps.viewCorrelatelearningSkill(spine, label);
		
		//Delete Learning Spine Correlations on View details page
		//hmhDocumentDetailsSteps.deleteCorrelatelearningSkill();
		
		//siteHeaderSteps.customWait(5);
		// Tear down steps added on 10th Oct 2018 (Sprint 7.3.5)
  /*  	hmhShareHeaderSteps.clickOnSharedFiles();
    	shareHeaderSteps.customWait(5);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(correlationsreport);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(fileName);
    	hmhDocumentLibrarySteps.deleteDocOnViewDetailsLS();*/
		
        System.out.println("Script completed..");
        
        
    }}