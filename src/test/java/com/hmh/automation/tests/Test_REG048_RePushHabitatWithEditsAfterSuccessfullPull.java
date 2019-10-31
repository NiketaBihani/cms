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
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG048_RePushHabitatWithEditsAfterSuccessfullPull.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG048_RePushHabitatWithEditsAfterSuccessfullPull extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;  
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	

	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, currentURL, ccoLabel, sbLabel, level2, numbering2, donotNumber, noRestart, level6, numbering6,
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, versionThree, versionFour, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean pushTohabitatStatus = false;
	private boolean checklatestVersionIsTwo = false;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String objectName = ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test_REG048 - Pull and Edit the Productset Then RePush HABITAT and Verify Modified Habitat Data In Inkling Habitat Site using Pull And Version")
	public void test_REG048_RePushHabitatWithEditsAfterSuccessfullPull() {


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
			hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
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

		//*****  Habitat Push and verify Habitat status
		shareHeaderSteps.customWait(3);
		this.pushTohabitatStatus = hmhDocumentDetailsSteps.pushTohabitatStatus(habitatProperty, habitatStatus);
		if(pushTohabitatStatus==false) {
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
			hmhEditPropertiesSteps.saveButtonClick();
			hmhDocumentDetailsSteps.pushToHabitat();
			hmhDocumentDetailsSteps.pushToHabitatOK(); 
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(3);
			hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page
			hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		}
		this.checklatestVersionIsTwo= hmhDocumentDetailsSteps.returnLatestVersion(versionTwo);
		if(this.checklatestVersionIsTwo==false){
			String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
			hmhShareHeaderSteps.logoutButtonClick();
			inklingHabitatSiteSteps.launchHabitatAndLogin(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
			inklingHabitatSiteSteps.removeGetStartedPopup();
			inklingHabitatSiteSteps.searchAndOpenHabitat(objectName);
			inklingHabitatSiteSteps.clickOnConfigureProject();
			inklingHabitatSiteSteps.verifyHabitatTitle(objectName);
			inklingHabitatSiteSteps.editChapterTitle(sbName1D, sbNameND);
			inklingHabitatSiteSteps.clickSaveButton();
			shareHeaderSteps.customWait(2);
			inklingHabitatSiteSteps.logOutFromHabitat();
			hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
			loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.clickHabitatPull(); //***Habitat PULL
			hmhDocumentDetailsSteps.habitatPullPopUp();
			hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
			hmhDocumentLibrarySteps.refresh();
			hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo); //***Version Verification
		}
		hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
		shareHeaderSteps.customWait(5);        
	    documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
	    hmhEditPropertiesSteps.clearLevel1Label(); //level1 label and Numbering is not mandatory from R5S0
	    hmhEditPropertiesSteps.selectLvl1Number(donotNumber);
	    editPropertiesDocumentSteps.saveButtonClick();
	    shareHeaderSteps.customWait(3);
		//***Verify the CCO - XML file is generated after Pull
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName2D);
		hmhDocumentLibrarySteps.isAssetPresent(ccoName2D+".html");
		hmhDocumentLibrarySteps.navBarClick(ccoName2D);
	    shareHeaderSteps.customWait(3);       
	    documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); //Edit CCO Label before Repush
	    hmhEditPropertiesSteps.editCcoLabel(ccoLabel);
	    editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1D);
		hmhDocumentLibrarySteps.navBarClick(sbName1D);
	    shareHeaderSteps.customWait(3);       
	    documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); //Edit CCO Label before Repush
	    hmhEditPropertiesSteps.sequenceBundleLabelInput(sbLabel);
	    editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
    	siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
    	hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.pushToHabitat(); //Re-Push the habitat with changes
		hmhDocumentDetailsSteps.pushToHabitatOK(); 
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		String currentOneCMSURLV3 = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.logoutButtonClick();
		inklingHabitatSiteSteps.launchHabitatAndLogin(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		inklingHabitatSiteSteps.removeGetStartedPopup();
		inklingHabitatSiteSteps.searchAndOpenHabitat(objectName);
		inklingHabitatSiteSteps.clickOnConfigureProject();
		inklingHabitatSiteSteps.verifyHabitatTitle(objectName);
		inklingHabitatSiteSteps.verifyChapterTitle(sbName2D);
		inklingHabitatSiteSteps.verifyChapterLabel(sbNameND, sbLabel); //sblabel should be updated
		inklingHabitatSiteSteps.verifyChapterLabel(sbName2D, "");
		inklingHabitatSiteSteps.verifyPageLabel(ccoName2D, "");
		inklingHabitatSiteSteps.verifyPageNumber(ccoName1D, "");
		inklingHabitatSiteSteps.logOutFromHabitat();
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURLV3);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.clickHabitatPull(); //***Habitat PULL
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionThree); //***Version Verification
		hmhDocumentDetailsSteps.checkLatestVersion(versionThree);
		
		//deleting the references prior to delete the site
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1D);
		hmhDocumentLibrarySteps.navBarClick(sbName1D);   
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(ccoName1D);
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		hmhDocumentDetailsSteps.deleteReference(objectName);
		siteHeaderSteps.clickOnDocumentLibraryButton(); 
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName2D);
		hmhDocumentLibrarySteps.navBarClick(sbName2D);
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(ccoName2D);
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(objectName);

	}

}
