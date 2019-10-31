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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG043_VerifyHabitatDataInInklingHabitatCoreSiteAfterPush.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG043_VerifyHabitatDataInInklingHabitatCoreSiteAfterPush extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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

	String  type, objectNameOld,pushToHabitatInput_Username, pushToHabitatInput_Password, pushToHabitatUserTemplate, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, currentURL,
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean pushTohabitatStatus = false;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String versionThree = "3";
	String objectName = "tcs043"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc043sb"+ConstantsHMH.TODAY_DATE, sbName1D="tc043sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="tc043sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="tc043updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc043cco"+ConstantsHMH.TODAY_DATE, ccoName1D="tc043cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="tc043cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="tc043updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	String role="Teacher";
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test_REG043 - Verify Habitat Data In Inkling Habitat CoreSiteAfter Successfull Push")
	public void test_REG043_VerifyHabitatDataInInklingHabitatCoreSite() {


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
	        hmhEditPropertiesSteps.addPStoMasterReference(objectName);
	        hmhEditPropertiesSteps.saveButtonClick();
            //hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
	        shareHeaderSteps.customWait(5);        
	        hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
	        hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		}

		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);

		//Verify Push to Habitat status
		shareHeaderSteps.customWait(3);
		this.pushTohabitatStatus = hmhDocumentDetailsSteps.pushTohabitatStatus(habitatProperty, habitatStatus);
		if ( pushTohabitatStatus == false) {
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.editUserRoleMetadataField(role);
			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
			hmhEditPropertiesSteps.saveButtonClick();
			hmhDocumentDetailsSteps.pushToHabitat();
			//  *** Added Missing Scripts *** 
			hmhDocumentDetailsSteps.pushToHabitat_Username("cms.engineering@hmhco.com");
			hmhDocumentDetailsSteps.pushToHabitat_Password("habitatToken");
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			shareHeaderSteps.customWait(5);
			
			hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
			shareHeaderSteps.customWait(5);
		
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			
			// *****
		//	hmhDocumentDetailsSteps.pushToHabitatOK();
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(3);
		//	hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page
		//	hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		}
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();

		//verify habitat in Inkling habitat core site

		inklingHabitatSiteSteps.launchHabitatAndLogin(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		// *** Fix (Move to Page for enhancements) ***
		inklingHabitatSiteSteps.removeGetStartedPopup();
		// *** Fix (Move to Page for enhancements) ***
		inklingHabitatSiteSteps.searchAndOpenHabitat(habitatShortName);
		inklingHabitatSiteSteps.clickOnConfigureProject();
		inklingHabitatSiteSteps.verifyHabitatTitle(objectName);
		inklingHabitatSiteSteps.verifyChapterTitle(sbName1D);
		inklingHabitatSiteSteps.verifyChapterTitle(sbName2D);
		inklingHabitatSiteSteps.verifyChapterLabel(sbName1D, level1);
		inklingHabitatSiteSteps.verifyChapterNumber(sbName1D, "1");
		inklingHabitatSiteSteps.verifyPageLabel(ccoName1D, "");
		inklingHabitatSiteSteps.verifyPageNumber(ccoName2D, "");
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		System.out.println("Script completed");
	}

}
