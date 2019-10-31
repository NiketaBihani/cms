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
import com.hmh.automation.steps.HMHSetupSteps;
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG045_VerifyModifiedHabitatDataInOneCMSusingPullAndVersion.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG045_VerifyModifiedHabitatDataInOneCMSusingPullAndVersion extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private LoginSteps loginSteps;
	@Steps
	private HMHSetupSteps hmhSetupSteps;
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

	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, currentURL,
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean pushTohabitatStatus = false;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String versionThree = "3";
	String objectName = "tc045"+ConstantsHMH.PREFIX_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc045sbv1"+ConstantsHMH.TODAY_DATE, sbName1D="tc045sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="tc045sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="tc045updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc045ccov1"+ConstantsHMH.TODAY_DATE, ccoName1D="tc045cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="tc045cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="tc045updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	String versionComment = "New Version";
	String pushToHabitatUserTemplate= "HMH Baseline Template v2";
	String role= "Teacher";
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test_REG045 - PSF and HABITAT Push and Pull Functionalities, Verify Modified Habitat Data In OneCMS using Pull And Version")
	public void test_REG045_VerifyModifiedHabitatDataInOneCMSusingPullAndVersion() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);

		if (this.isAssetFound == false){
		
		/*siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);*/
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbNameD, ccoNameD); //level 2 tree structure
		shareHeaderSteps.siteFinderButtonClick();
		//***PSF
		hmhSiteFinderSteps.searchForASite2(masterLibSite);
		hmhSiteFinderSteps.openTheSiteFound(masterLibSite);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(masterLibFolder);
		hmhDocumentLibrarySteps.navBarClick(masterLibFolder);
		shareHeaderSteps.customWait(5);
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
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		
		}
		
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);

		//*****Habitat Push and verify Habitat status
		shareHeaderSteps.customWait(3);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editUserRoleMetadataField(role);
		hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
		hmhEditPropertiesSteps.saveButtonClick();
		
		hmhDocumentDetailsSteps.pushToHabitat();
		hmhDocumentDetailsSteps.pushToHabitat_Username(ConstantsHMH.HABITAT_TEST_USER_LOGIN);
		hmhDocumentDetailsSteps.pushToHabitat_Password(ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
	
		//hmhDocumentDetailsSteps.pushToHabitatOK(); 
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(3);
		//hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();
		//hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();

		//***verify habitat in Inkling habitat core site
		inklingHabitatSiteSteps.launchHabitatAndLogin(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		inklingHabitatSiteSteps.removeGetStartedPopup();
		inklingHabitatSiteSteps.searchAndOpenHabitat(objectName);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.clickOnConfigureProject();
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyHabitatTitle(objectName);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyChapterTitle(sbName1D);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyChapterTitle(sbName2D);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyChapterLabel(sbName1D, level1);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyChapterNumber(sbName1D, "2");
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyPageTitle(ccoName1D);
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.verifyPageLabel(ccoName2D, "");
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.editChapterTitle(sbName1D, sbNameND);
		shareHeaderSteps.customWait(10);
		inklingHabitatSiteSteps.clickSaveButton();
		shareHeaderSteps.customWait(5);
		inklingHabitatSiteSteps.logOutFromHabitat();
		
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(5);
		// ** Fixed on 19th Sep 2018 in Sprint 7.3.4 **
		hmhDocumentDetailsSteps.clickHabitatPull();
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentDetailsSteps.habitatPullPopUp();
		siteHeaderSteps.refreshPage();
		shareHeaderSteps.customWait(5);
		// ** Fixed in Sprint 7.3.2
		String currentOneCMSNEWURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();
				
		//Login in oneCMS to Verify the CCO - HTML file is generated after Pull
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSNEWURL);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(3);		
/*		//Changed
        hmhDocumentDetailsSteps.clickonVersion(); //documentLibrarySteps.moreActionMenuClick(versionAction, name);
        
        //Version Pop up	
      	// **Verify Version pop up Cancel button
      	hmhDocumentDetailsSteps.clickonVersioncancel();
      	hmhDocumentDetailsSteps.clickonVersion();
      	// ** Enter Comment
      	hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
      	// **Verify Version pop up Save button
      	hmhDocumentDetailsSteps.clickonVersionsave();	
		//hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo); //***Version Verification
		hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);*/
		//***Verify the Asset is Updated as per Habitat changes
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1D);
		hmhDocumentLibrarySteps.navBarClick(sbName1D); 
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, sbNameND);
		
		//***Verify the CCO - XML file is generated after Pull
		//siteHeaderSteps.clickOnDocumentLibraryButton();
		//hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		//hmhDocumentLibrarySteps.assetFromListClick(ccoName2D);
		//hmhDocumentLibrarySteps.isAssetPresent(ccoName2D+".html");

		
	
	}

}