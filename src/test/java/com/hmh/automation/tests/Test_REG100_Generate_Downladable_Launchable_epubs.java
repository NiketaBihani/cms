//** ALF- 1962 ** verify launchable and downloadable epubs generated ** Sprint 7.2.4**

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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG100_Generate_Downladable_Launchable_epubs.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG100_Generate_Downladable_Launchable_epubs extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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
	

	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel,
	pushToHabitatInput_Username,pushToHabitatInput_Password,pushToHabitatUserTemplate,SQmarket,SQcloObjDispTitle,ContentObjectsFolder;

	private boolean isAssetFound=true;
	int noOfLevels = 1; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	String objectName = "tc100"+ConstantsHMH.PREFIX_PRODUCTOBJECT_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc100"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc100"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	String visualtoc = "false";
	String role ="Teacher";
	//String assetName="ePub";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Habitat")
	@Title("Test_REG100_Generate_Downladable_Launchable_epubs")
	public void test_REG100_Generate_Downladable_Launchable_epubs() {


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
			hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName); //level 2 tree structure
			
			//** Referencing Program Support Folder for product set**
			
			shareHeaderSteps.siteFinderButtonClick();
			hmhSiteFinderSteps.searchForASite2(masterLibSite);
			hmhSiteFinderSteps.openTheSiteFound(masterLibSite);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(masterLibFolder);
			hmhDocumentLibrarySteps.navBarClick(masterLibFolder);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.clickProductSetRefSelect();
			shareHeaderSteps.customWait(5); 
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(sitesLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(habSiteNameReg);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductObjectsFolder);
			hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
			hmhEditPropertiesSteps.saveButtonClick();
			shareHeaderSteps.customWait(5);        
			hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
			hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		}

			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			
			// **Check and verify Downloadable Epub checkbox**
			
			hmhEditPropertiesSteps.checkCreateDownladableEpub();
			hmhEditPropertiesSteps.editUserRoleMetadataField(role);
			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
			hmhEditPropertiesSteps.saveButtonClick();
			
			//**Perform Push to Habitat functionality and verify**
				
			hmhDocumentDetailsSteps.pushToHabitatlink();
			hmhDocumentDetailsSteps.pushToHabitat_Username(pushToHabitatInput_Username);
			hmhDocumentDetailsSteps.pushToHabitat_Password(pushToHabitatInput_Password);
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
			shareHeaderSteps.customWait(5);

			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			siteHeaderSteps.customWait(10);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			siteHeaderSteps.customWait(3);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			siteHeaderSteps.customWait(3);
			hmhDocumentLibrarySteps.ePubDraftClcik(habitatShortName); 
			siteHeaderSteps.customWait(3);
	
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
			shareHeaderSteps.customWait(5);
			
			//** ALF- 1962 ** verify launchable epub generated ** Sprint 7.2.4**
			
			hmhDocumentLibrarySteps.assetFromListClickSubCO("ePub");
			hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase());
			shareHeaderSteps.customWait(5);
			hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase()+"_teacher.epub");
			//hmhDocumentLibrarySteps.assetFromListClickSubCO(habitatShortName.toLowerCase()+"_"+role+".epub");
			hmhDocumentLibrarySteps.goBackToPreviousPage();
			shareHeaderSteps.customWait(5);
			
			//** ALF- 1962 ** verify downloadable epub generated ** Sprint 7.2.4**
			
			hmhDocumentLibrarySteps.downloadableAssetFromListClickSubCO(habitatShortName.toLowerCase());
			shareHeaderSteps.customWait(5);
			siteHeaderSteps.clickOnDocumentLibraryButton();


	}

}
