package com.hmh.automation.tests;

	import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

	@Story(HMHApplication.Habitat.class)
	@RunWith(SerenityParameterizedRunner.class)
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG029a_PullFromHabitatNlevelforPO.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class Test_REG029a_PullFromHabitatNlevelforPO extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {
		
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
		    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
		    @Steps
		    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
		    @Steps
		    private ShareHeaderSteps shareHeaderSteps;
		    @Steps
		    private HMHDataListsSteps hmhDataListsSteps;
		    @Steps
			private SiteDashboardSteps siteDashboardSteps;
		    @Steps
			private SiteFinderSteps siteFinderSteps;
			@Steps
			private HMHSiteFinderSteps hmhSiteFinderSteps;


		    String  type, objectNameOld, psName, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
		    cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel,
		    pushToHabitatInput_Username,pushToHabitatInput_Password,pushToHabitatUserTemplate;
		   
		    private boolean isAssetFound=true;
		    private boolean isPushedToHabitat=true;
		    int noOfLevels = 2; //level 2 tree structure
		    String habitatProperty ="Is Pushed To Habitat?"; 
		    String habitatStatus = "Yes";
		    String objectName = "ProdObje"+ConstantsHMH.PREFIX_PRODUCTOBJECT_NAME+ConstantsHMH.TODAY_DATE;							// HABITAT_TEST_USER_LOGIN = "cms.engineering@hmhco.com"; HABITAT_TEST_PASS_LOGIN = "habitatToken";
		    String sbNameD="sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
			String ccoNameD="cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
			String habitatShortName=objectName;
			String visualtoc="false";
		    @Override
		    public void setSiteType() {
		        siteType = siteTypeTest;
		    }

		    @Test
		   
		    @Title("Test_REG029 - Push and Pull From Habitat functionality level one")
		    public void test_REG029_PullFromHabitatNlevel() {
		    	
		    	hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		    	this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);
		    	
		    	if (this.isAssetFound == false){
		    		
		    		documentLibrarySteps.createNewContent(type);
		            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		            hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		            hmhDocumentLibrarySteps.assetFromListClick(objectName);
		            hmhDocumentLibrarySteps.navBarClick(objectName);
		            hmhDocumentDetailsSteps.clickEditSequence();
		            hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		            hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		            hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbNameD, ccoNameD); //level 2 tree structure
		            // Referencing Program Support Folder for product set
			    	shareHeaderSteps.siteFinderButtonClick();
					hmhSiteFinderSteps.searchForASite2(masterLibSite);
					hmhSiteFinderSteps.openTheSiteFound(masterLibSite);
					siteHeaderSteps.clickOnDocumentLibraryButton();
					hmhDocumentLibrarySteps.assetFromListClick(masterLibFolder);
					hmhDocumentLibrarySteps.navBarClick(masterLibFolder);
					documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
					hmhEditPropertiesSteps.clickProductSetRefSelect();
					hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(sitesLevel);
					hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(habSiteNameReg);
					hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
					hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductObjectsFolder);
					hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
					hmhEditPropertiesSteps.saveButtonClick();
					//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
					shareHeaderSteps.customWait(5);        
					hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
					hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);

			    }
		    	
				siteHeaderSteps.clickOnDocumentLibraryButton();
				hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		    	hmhDocumentLibrarySteps.assetFromListClick(objectName);
		    	hmhDocumentLibrarySteps.navBarClick(objectName);
		    	this.isPushedToHabitat = hmhDocumentDetailsSteps.isPushedToHabitat(habitatProperty, habitatStatus);
		    	
		    	if (isPushedToHabitat == false) {
		    		
		    			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		    			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
		    			hmhEditPropertiesSteps.saveButtonClick();
		    			
		    			hmhDocumentDetailsSteps.pushToHabitatlink();
		    			hmhDocumentDetailsSteps.pushToHabitat_Username(pushToHabitatInput_Username);
		    			hmhDocumentDetailsSteps.pushToHabitat_Password(pushToHabitatInput_Password);
		    			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		    			hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
		    			shareHeaderSteps.customWait(5);
		    			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		    			siteHeaderSteps.clickOnDocumentLibraryButton();
		    			hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		    			hmhDocumentLibrarySteps.assetFromListClick(objectName);
		    			hmhDocumentLibrarySteps.navBarClick(objectName);
		    			
		    			//hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();
		    			
		    			 //verify the Habitat value
		    			shareHeaderSteps.customWait(10);
		    		
		    				hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		    				//hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.IS_PUSHEDTO_HABITAT,habitatStatus);
		    				System.out.println("verified");
		    				documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		    				//hmhDocumentDetailsSteps.checkboxselection();
		    				hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.VISUAL_TOC,visualtoc);
		    			//hmhDocumentDetailsSteps.pushToHabitat();
		    			
				        /*hmhDocumentDetailsSteps.pushToHabitatOK();
				        siteHeaderSteps.clickOnDocumentLibraryButton();
				        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
				        hmhDocumentLibrarySteps.assetFromListClick(objectName);
				        hmhDocumentLibrarySteps.navBarClick(objectName);
				        shareHeaderSteps.customWait(5);
				        hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page
				        hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);*/
		    	}	

		       hmhDocumentDetailsSteps.clickHabitatPull();
		       hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		       hmhDocumentLibrarySteps.refresh();
		       hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		       hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
		       
		    }

}