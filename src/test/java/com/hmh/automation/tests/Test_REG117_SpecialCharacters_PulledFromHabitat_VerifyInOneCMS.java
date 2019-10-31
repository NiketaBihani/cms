// ** ALF 1042 ** - Support special characters pulled from Habitat ** Sprint 7.3.3. **
package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.pages.HMHSiteFinderPage;
import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.steps.InklingHabitatSiteSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG117_SpecialCharacters_PulledFromHabitat_VerifyInOneCMS.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG117_SpecialCharacters_PulledFromHabitat_VerifyInOneCMS extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private LoginSteps loginSteps;
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

	String  type, versionTwo, objectNameOld,pushToHabitatUserTemplate, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, currentURL, addedPage="%@#habitatAdded*&",
			cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed,  sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean pushTohabitatStatus = false;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String versionThree = "3.0";
	String objectName = "tc117"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc117sb"+ConstantsHMH.TODAY_DATE, sbName1D="tc117sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="tc117sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="tc117updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc117cco"+ConstantsHMH.TODAY_DATE, ccoName1D="tc117cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="#$%tc117cco*)+"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="tc117updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String updatedTitle= "#$^&*tc117ccoUpdated",ccoNamelevel1 = ccoName1D+".html", ccoNamelevel2= ccoName1D+".html";
	String habitatShortName=objectName;
	String role= "Teacher";
	
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test REG117 - Special Characters Pulled From Habitat Verify In OneCMS")
	public void test_REG117_SpecialCharacters_PulledFromHabitat_VerifyInOneCMS() {


		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);

		if (this.isAssetFound == false){
			documentLibrarySteps.createNewContent(type);
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
			hmhDocumentLibrarySteps.refresh();
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			hmhDocumentDetailsSteps.clickEditSequence();
			hmhSequenceViewSteps.checkIfOnSequenceViewPage();
			hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
			hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbNameD, ccoNameD); //level 2 tree structure
			hmhSiteFinderSteps.siteFinderButtonClick();
			hmhSiteFinderSteps.searchForASite2(masterLibSite);
			hmhSiteFinderSteps.openTheSiteFound(masterLibSite);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(masterLibFolder);
			shareHeaderSteps.customWait(3);
			hmhDocumentLibrarySteps.navBarClick(masterLibFolder);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.clickProductSetRefSelect();
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(sitesLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(habSiteNameReg);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductSetsFolder);
			hmhEditPropertiesSteps.addPStoMasterReference(objectName);
			hmhEditPropertiesSteps.saveButtonClick();
			shareHeaderSteps.customWait(5);        
			hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
			hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			
		}
		
		// Edit the Display title to verify in Habitat Site
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoNameD);
		hmhDocumentLibrarySteps.navBarClick(ccoNameD);
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.editTitle(updatedTitle);
		hmhEditPropertiesSteps.saveButtonClick();
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		
		//Verify Push to Habitat status
		shareHeaderSteps.customWait(3);
		this.pushTohabitatStatus = hmhDocumentDetailsSteps.pushTohabitatStatus(habitatProperty, habitatStatus);
		if (pushTohabitatStatus==false) {
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.editUserRoleMetadataField(role);
			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
			hmhEditPropertiesSteps.saveButtonClick();
			hmhDocumentDetailsSteps.pushToHabitat(); 
			hmhDocumentDetailsSteps.pushToHabitat_Username("cms.engineering@hmhco.com");
			hmhDocumentDetailsSteps.pushToHabitat_Password("habitatToken");
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			shareHeaderSteps.customWait(5);

			hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(3);
			
		}
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();

		// Verify habitat in Inkling habitat core site
		inklingHabitatSiteSteps.launchHabitatAndLogin(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		inklingHabitatSiteSteps.removeGetStartedPopup();
		inklingHabitatSiteSteps.searchAndOpenHabitat(habitatShortName);
		shareHeaderSteps.customWait(10);
		inklingHabitatSiteSteps.clickOnConfigureProject();
		shareHeaderSteps.customWait(10);
		inklingHabitatSiteSteps.verifyHabitatTitle(objectName);
		shareHeaderSteps.customWait(10);
		inklingHabitatSiteSteps.verifyChapterTitle(sbName1D);
		shareHeaderSteps.customWait(10);
		inklingHabitatSiteSteps.editChapterTitle(sbName1D, sbNameND);
		shareHeaderSteps.customWait(10);
		inklingHabitatSiteSteps.clickSaveButton();
		shareHeaderSteps.customWait(10);

		// Advanced UI interactions -DragAndDrop
		inklingHabitatSiteSteps.addPageInsideFirstSB(ccoName2D, sbNameND);
		shareHeaderSteps.customWait(8);
		inklingHabitatSiteSteps.clickSaveButton();
		shareHeaderSteps.customWait(8);
		inklingHabitatSiteSteps.giveANameToAddedpage(addedPage);
		shareHeaderSteps.customWait(8);
		inklingHabitatSiteSteps.clickSaveButton();
		shareHeaderSteps.customWait(5);		
		inklingHabitatSiteSteps.logOutFromHabitat();

		// Login to oneCMS to pull from habitat and verify
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.clickHabitatPull();
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentDetailsSteps.habitatPullPopUp();
		siteHeaderSteps.refreshPage();
		shareHeaderSteps.customWait(5);
		
		String currentOneCMSNEWURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();
		
		
		//Login in oneCMS to Verify the CCO - HTML file is generated after Pull
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSNEWURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(5);		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoNameD);
		hmhDocumentLibrarySteps.verifyIfAssetIsPresent(ccoNamelevel2, updatedTitle);

		
			
	}

}
