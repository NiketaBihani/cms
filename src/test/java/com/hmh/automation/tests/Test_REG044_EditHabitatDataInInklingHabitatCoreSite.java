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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG044_EditHabitatDataInInklingHabitatCoreSite.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG044_EditHabitatDataInInklingHabitatCoreSite extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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

	String  type, versionTwo, objectNameOld,pushToHabitatUserTemplate, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, currentURL, addedPage="habitatAdded",
			cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed,  sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean pushTohabitatStatus = false;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String versionThree = "3.0";
	String objectName = "hy044"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc044sb"+ConstantsHMH.TODAY_DATE, sbName1D="tc044sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="tc044sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="tc044updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc044cco"+ConstantsHMH.TODAY_DATE, ccoName1D="tc044cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="tc044cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="tc044updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	String role= "Teacher";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test_REG044 - Edit Habitat Data In Inkling Habitat Core Site After Successfull Push")
	public void test_REG044_EditHabitatDataInInklingHabitatCoreSite() {


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
			//****Fixed on 2/7/2018 (Sprint 7.2.5)****
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
		if (pushTohabitatStatus==false) {
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

			//hmhDocumentDetailsSteps.pushToHabitatOK();
			//shareHeaderSteps.customWait(5);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(3);
			//hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page
			//hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		}
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();

		//verify habitat in Inkling habitat core site
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

		//Advanced UI interactions -DragAndDrop
		inklingHabitatSiteSteps.addPageInsideFirstSB(ccoName2D, sbNameND);
		shareHeaderSteps.customWait(8);
		inklingHabitatSiteSteps.clickSaveButton();
		shareHeaderSteps.customWait(8);
		inklingHabitatSiteSteps.giveANameToAddedpage(addedPage);
		shareHeaderSteps.customWait(8);
		inklingHabitatSiteSteps.clickSaveButton();
		shareHeaderSteps.customWait(5);		
		/*inklingHabitatSiteSteps.clickOnEditContent();
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.clickOnSBinEditContent(sbName2D);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.clickOnPageinEditContent(addedPage);
		shareHeaderSteps.customWait(5);*/
		//****Fixed on 2/7/2018 (Sprint 7.2.5)****
		//inklingHabitatSiteSteps.addImageFromLibrary(); //**Kids related program support template does not support images**
		//inklingHabitatSiteSteps.clickSaveButton();
		//shareHeaderSteps.customWait(3);

		inklingHabitatSiteSteps.logOutFromHabitat();

		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.clickHabitatPull(); //***Habitat PULL
		hmhDocumentDetailsSteps.habitatPullPopUp();
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentLibrarySteps.refresh();

		String currentOneCMSNEWURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();
				
		//Login in oneCMS to Verify the CCO - HTML file is generated after Pull
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSNEWURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(3);		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoNameD);
		hmhDocumentLibrarySteps.verifyCCOIsPresent(ccoNameD+".html");
		//hmhDocumentLibrarySteps.verifyHabitatAddedPageIsPresent(addedPage);
	/*	//****Fixed on 2/7/2018 (Sprint 7.2.5)****
		//hmhDocumentLibrarySteps.refresh();
		//hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo); //***Version Verification

		//hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
		//shareHeaderSteps.customWait(2);
		//***Verify the Asset is Updated as per Habitat changes
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1D);
		hmhDocumentLibrarySteps.navBarClick(sbName1D); 
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, sbNameND);*/
		
		

	}

}
