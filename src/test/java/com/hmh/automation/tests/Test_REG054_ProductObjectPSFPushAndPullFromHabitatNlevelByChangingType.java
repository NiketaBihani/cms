package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
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
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG054_ProductObjectPSFPushAndPullFromHabitatNlevelByChangingType.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG054_ProductObjectPSFPushAndPullFromHabitatNlevelByChangingType extends com.hmh.automation.tools.AbstractBaseSiteTestHabitatBVT {

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
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;

	String  type, newType, psName, title, label1, description, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, 
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, versionThree, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;

	private boolean isAssetFound=true;
	private boolean isPushedToHabitat=true;
	int noOfLevels = 2; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String objectName = ConstantsHMH.PREFIX_PRODUCTOBJECT_NAME+RandomStringUtils.randomAlphanumeric(5);							// HABITAT_TEST_USER_LOGIN = "cms.engineering@hmhco.com"; HABITAT_TEST_PASS_LOGIN = "habitatToken";
	String sbNameD="posb"+ConstantsHMH.TODAY_DATE, sbName1D="posb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="posb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedPOSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="pocco"+ConstantsHMH.TODAY_DATE, ccoName1D="pocco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="pocco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedPOCCO"+ConstantsHMH.TODAY_DATE;
	String habitatShortName=objectName;
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG054 - Product Object: PSF, Push, change the type to PS and Pull From Habitat, Repush and agian change to PO for habitat pull and verify version ")
	public void test_REG054_ProductObjectPSFPushAndPullFromHabitatNlevelByChangingType() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);	    		
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductObject(objectName, year, title);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbNameD, ccoNameD);
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
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductObjectsFolder);
		hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
		hmhEditPropertiesSteps.saveButtonClick();
		//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
		shareHeaderSteps.customWait(5);        
		hmhSiteFinderSteps.searchUserSites(habSiteName);
		hmhSiteFinderSteps.openTheUserSiteFound(habSiteName);   	
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
		hmhEditPropertiesSteps.saveButtonClick();
		hmhDocumentDetailsSteps.pushToHabitat();    //PUSH as PO
		hmhDocumentDetailsSteps.pushToHabitatOK();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(2);
		hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();  // wait until Habitat meta data displayed on page

		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		documentDetailsSteps.changeTypeButtonDocumentActionsClick();
		documentDetailsSteps.changeType(newType);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.clickHabitatPull();  //Pull as PS
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editDescription(description);
		hmhEditPropertiesSteps.editGrade(grade);
		hmhEditPropertiesSteps.editMarkets(markets);
		hmhEditPropertiesSteps.editLevel1Label(label1);
		hmhEditPropertiesSteps.selectLvl1Number(numbering1);
		editPropertiesDocumentSteps.saveButtonClick();
		shareHeaderSteps.customWait(5);

		hmhDocumentDetailsSteps.pushToHabitat(); ////RePUSH as PS
		hmhDocumentDetailsSteps.pushToHabitatOK();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();
		hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
		documentDetailsSteps.changeTypeButtonDocumentActionsClick();
		documentDetailsSteps.changeType(type);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.clickHabitatPull(); ////PULL as PO
		hmhDocumentDetailsSteps.habitatPullPopUp();
		hmhDocumentDetailsSteps.habitatLoginForPull(ConstantsHMH.HABITAT_TEST_USER_LOGIN, ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionThree);
		hmhDocumentDetailsSteps.checkLatestVersion(versionThree);

		//deleting the references
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
