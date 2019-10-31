//**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG105_RegenerateEpubsAndVerify_UserRolevalueChanged.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG105_RegenerateEpubsAndVerify_UserRolevalueChanged extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {
		
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
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean isPushedToHabitat=true;
	int noOfLevels = 1; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?:"; 
	String habitatStatus = "Yes";
	String habitatProperty1 ="Visual TOC:"; 
	String habitatStatus1 = "false";

	String objectName = "po105"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;						
	String sbNameD="tc0105sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc0105cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habitatShortName=objectName;
	String pushToHabitatUserTemplate= "HMH Baseline Template v2";
	String role,userrole;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test

	@Title("Test_REG105_Regenerate Epubs And Verify When User Role value is changed")
	public void test_REG105_RegenerateEpubsAndVerify_UserRolevalueChanged() {

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
			hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
			hmhEditPropertiesSteps.saveButtonClick();
			shareHeaderSteps.customWait(5);        
			hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
			hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);

		}

			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			this.isPushedToHabitat = hmhDocumentDetailsSteps.isPushedToHabitat(habitatProperty, habitatStatus);

	if (isPushedToHabitat == false) {

			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.editUserRoleMetadataField(role);
			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
			hmhEditPropertiesSteps.saveButtonClick();
	
			//Perform Push to Habitat functionality and verify
	
			hmhDocumentDetailsSteps.pushToHabitatlink();
			hmhDocumentDetailsSteps.pushToHabitat_Username(ConstantsHMH.HABITAT_TEST_USER_LOGIN);
			hmhDocumentDetailsSteps.pushToHabitat_Password(ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(5);
			//hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();
			hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
			hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty1, habitatStatus1);
		}	
			hmhDocumentDetailsSteps.clickHabitatPull();			
			hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
			hmhDocumentDetailsSteps.habitatPullPopUp();
			hmhDocumentLibrarySteps.refresh();
			shareHeaderSteps.customWait(5);
			//hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.changeUserRoleMetadataField(userrole);
			hmhEditPropertiesSteps.saveButtonClick();
			hmhDocumentDetailsSteps.pushToHabitatlink();
			hmhDocumentDetailsSteps.verifyWarningMessageOnPopup();
			hmhDocumentDetailsSteps.selectRadiobuttonOnPopUp();
			hmhEditPropertiesSteps.selectRegenerateEpub();
			hmhDocumentDetailsSteps.clickOkbuttonOnPopUp();
			shareHeaderSteps.customWait(15);
			hmhDocumentLibrarySteps.refresh();
			hmhDocumentLibrarySteps.ePubDraftClcik(habitatShortName);
			siteHeaderSteps.customWait(3);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
			shareHeaderSteps.customWait(5);
			hmhDocumentLibrarySteps.assetFromListClickSubCO("ePub");
			hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase());
			shareHeaderSteps.customWait(5);
			hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase()+"_teacher.epub");
			hmhDocumentLibrarySteps.goBackToPreviousPage();
			//hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase()+"_student.epub");
			// ** Habitat functionality changed due to IN:20452 in sprint 7.3.1 **
			hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase()+"_teacher.epub");
			shareHeaderSteps.customWait(5);
			System.out.println("Script Completed");

	
	}

}

