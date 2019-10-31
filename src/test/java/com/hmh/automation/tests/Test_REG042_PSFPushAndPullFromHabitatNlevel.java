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
import com.hmh.automation.steps.HMHShareHeaderSteps;
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG042_PSFPushAndPullFromHabitatNlevel.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG042_PSFPushAndPullFromHabitatNlevel extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat  {

	//com.hmh.automation.tools.AbstractBaseSiteTestHabitatBVT
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
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private HMHDataListsSteps hmhDataListsSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;

	
	public String habSiteName=ConstantsHMH.REG_HABITAT_SITE_NAME+ConstantsHMH.TODAY_DATE;

	String  type, objectNameOld, psName, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean isPushedToHabitat=true;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String objectName = "tcs42"+ConstantsHMH.PREFIX_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;// HABITAT_TEST_USER_LOGIN = "cms.engineering@hmhco.com"; HABITAT_TEST_PASS_LOGIN = "habitatToken";
	String sbNameD="tc042sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc042cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habitatShortName=objectName;
	String pushToHabitatUserTemplate= "HMH Baseline Template v2";
	String role="Teacher";
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG042 - PSF, Push and Pull From Habitat functionality - BVT only Test")
	public void test_REG042_PSFPushAndPullFromHabitatNlevel() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);	    		
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
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
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(habSiteName);
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductSetsFolder);
		hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
		hmhEditPropertiesSteps.saveButtonClick();
		//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editUserRoleMetadataField(role);
		hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
		hmhEditPropertiesSteps.saveButtonClick();
		hmhDocumentDetailsSteps.pushToHabitatlink();
		hmhDocumentDetailsSteps.pushToHabitat_Username(ConstantsHMH.HABITAT_TEST_USER_LOGIN);
		hmhDocumentDetailsSteps.pushToHabitat_Password(ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page

		
		
		/*hmhDocumentDetailsSteps.pushToHabitat();
		hmhDocumentDetailsSteps.pushToHabitatOK();
		hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
		hmhDocumentLibrarySteps.refresh();*/
		
		//verify the Habitat value
		shareHeaderSteps.customWait(10);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		hmhDocumentDetailsSteps.clickHabitatPull();
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		// ** Fix provided on 10th Sep 2018
		hmhDocumentDetailsSteps.habitatPullPopUp();
		hmhDocumentLibrarySteps.refresh();
		shareHeaderSteps.customWait(5);
		//hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		//hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);

		//deleting the references
		/*siteHeaderSteps.clickOnDocumentLibraryButton();
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
		hmhDocumentDetailsSteps.deleteReference(objectName);*/

	}

}
