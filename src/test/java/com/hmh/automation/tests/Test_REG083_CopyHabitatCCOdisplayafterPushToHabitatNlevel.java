package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.steps.InklingHabitatSiteSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG028_PushToHabitatNlevel.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG083_CopyHabitatCCOdisplayafterPushToHabitatNlevel extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHDataListsSteps hmhDataListsSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
	@Steps
	private InklingHabitatSiteSteps inklingHabitatSiteSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private LoginSteps loginSteps;

	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel,pushToHabitatUserTemplate;

	private boolean isAssetFound=true;
	int noOfLevels = 1; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String habitatProperty1 ="Visual TOC:"; 
    String habitatStatus1 = "false";
    
	String objectName = "tc083"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc083sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc083cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	String role="Teacher";
	String copyHabitatCCO ="zautomation_k12_search_doNotDelete";
	String ContentobjectName ="Copy of tc083cco100818ISTCMS1";
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test_REG083 - Copy Habitat CCO display after Push To Habitat N level functionality")
	public void test_REG083_CopyHabitatCCOdisplayafterPushToHabitatNlevel() {


		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
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
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductSetsFolder);
			shareHeaderSteps.customWait(3);    
			hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
			shareHeaderSteps.customWait(5);        
			hmhEditPropertiesSteps.saveButtonClick();
			shareHeaderSteps.customWait(5);        
			hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
			hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		}

		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editUserRoleMetadataField(role);
		hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
		hmhEditPropertiesSteps.saveButtonClick();
		
		//Perform Push to Habitat functionality and verify
		hmhDocumentDetailsSteps.pushToHabitatlink();
		hmhDocumentDetailsSteps.pushToHabitat_Username(ConstantsHMH.HABITAT_TEST_USER_LOGIN);
		hmhDocumentDetailsSteps.pushToHabitat_Password(ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		shareHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
		shareHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(2);
		hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page

		//verify the Habitat value
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty1, habitatStatus1);
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoNameD);
		hmhDocumentLibrarySteps.navBarClick(ccoNameD);
		shareHeaderSteps.customWait(1);
		
		//Verify Copy HabitatCCO display
		hmhDocumentDetailsSteps.copyHabitatCCOlink();
		shareHeaderSteps.customWait(1);
		//hmhDocumentDetailsSteps.pushToHabitat_cancelbtn();
		// ** Copy Habitat CCO BVT fix provided - REG083 ** 8th Oct ** 
		hmhDocumentDetailsSteps.selectCopyHabitatCCO(copyHabitatCCO);
			
		// ** Copy Habitat CCO BVT fix provided - REG083 ** 8th Oct **
		// Verify the Copy Habitat CCO object in different site under CO folder
    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.K12_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.K12_SITE_NAME);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		/*hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ContentobjectName);
		hmhDocumentLibrarySteps.navBarClick(ContentobjectName);*/
		System.out.println("Script Completed");
		
	}

}
