package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDmaSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.pages.alfresco.SearchResultsPage;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeSiteSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG123_AdvanceSearchonbeforeafterpush.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG123_AdvanceSearchbyHabitatShortName extends com.hmh.automation.tools.AbstractSampleTest {
	
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHDmaSteps hmhDmaSteps;
	@Steps
	private DashboardSteps dashboardSteps;
	@Steps
	private CustomizeDashboardSteps customizeDashboardSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private CustomizeSiteSteps customizeSiteSteps;
	@Steps
	private HMHDataListsSteps hmhDataListsSteps;
	@Steps
	private HMHSetupSteps hmhSetupSteps;
	@Steps
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private SearchResultsPage searchResultsPage;
	@Steps
	private SearchResultsSteps searchResultsSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	//
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;
    @Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;


    String  type,typePS, objectNameOld,level1, numbering1, sbObjName, year,title,siteTypeTest, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights,masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel,pushToHabitatUserTemplate;

	private boolean isAssetFound=true;
	int waitForSearchResultsSeconds=10;
	int noOfLevels = 1; //level 2 tree structure
	String habitatProperty ="Is Pushed To Habitat?"; 
	String habitatStatus = "Yes";
	//String zautoSiteNameReg = "zautomation_k12_search_doNotDelete";
	String habitatProperty1 ="Visual TOC:"; 
    String habitatStatus1 = "false";
    //Updated the script on 10/15/2018
    String zeroresultsinSearch ="0 - results found"; 
    
	String objectName ="d123"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
	String sbNameD="tc0123sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc0123cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
	String habUserName=ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword=ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String habitatShortName=objectName;
	String role = "Teacher";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	
	@Test
	@Title("Test_REG123 - Advance Search Functionality On Habitat Shortname Before & After push")
	public void test_REG123_AdvanceSearchonbeforeafterpush() {
		
		/*hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.K12_SITE_NAME, this.siteType);
		hmhSiteFinderSteps.searchUserSites(ConstantsHMH.K12_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.K12_SITE_NAME);
    	siteHeaderSteps.clickOnDocumentLibraryButton();	*/
    	
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
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(siteSearch);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductSetsFolder);
			shareHeaderSteps.customWait(5);    
			hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
			shareHeaderSteps.customWait(5);        
			hmhEditPropertiesSteps.saveButtonClick();
			shareHeaderSteps.customWait(5);        
			hmhSiteFinderSteps.searchUserSites(siteSearch);
			hmhSiteFinderSteps.openTheUserSiteFound(siteSearch);
		}

			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			
			hmhEditPropertiesSteps.editUserRoleMetadataField(role );
			hmhEditPropertiesSteps.enterShortNameForHabitat(habitatShortName);
			hmhEditPropertiesSteps.saveButtonClick();
			
			
			//Perform Advance search Before Habitat Push
			shareHeaderSteps.advancedSearchButtonClick();
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.selectLookFor(typePS);
			//advancedSearchSteps.selectLookForPage(typeCO);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.selectLookForPage("Product Set");
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.selectLookForPage(typePS);
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.beforeHabitatPushAdvanceSearch(habitatShortName);
			shareHeaderSteps.customWait(2);
			hmhAdvancedSearchSteps.clickSearchButton();
			//advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
		//	searchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.isElementPresentInSearchResult(objectName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typePS);
			
			//Verify Negative scenario on After push search(Object actually not pushed)
			hmhSearchResultsSteps.backSearchResultsButton();
			hmhAdvancedSearchSteps.selectLookFor(typePS);
			//advancedSearchSteps.selectLookForPage(typeCO);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.selectLookForPage("Product Set");
			shareHeaderSteps.customWait(5);			
			hmhAdvancedSearchSteps.afterHabitatPushAdvanceSearch(habitatShortName);
			shareHeaderSteps.customWait(2);
			hmhAdvancedSearchSteps.clickSearchButton();
			//advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			//Checking if objects is present, There should not be any search result present here
			hmhSearchResultsSteps.noElementPresentinSearchResults(zeroresultsinSearch);
			
			//Perform Push to Habitat functionality and verify
			hmhSiteFinderSteps.searchUserSites(siteSearch);
			hmhSiteFinderSteps.openTheUserSiteFound(siteSearch);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			hmhDocumentDetailsSteps.pushToHabitatlink();
			hmhDocumentDetailsSteps.pushToHabitat_Username(ConstantsHMH.HABITAT_TEST_USER_LOGIN);
			hmhDocumentDetailsSteps.pushToHabitat_Password(ConstantsHMH.HABITAT_TEST_PASS_LOGIN);
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
			shareHeaderSteps.customWait(5);
			hmhDocumentDetailsSteps.pushToHabitat_submitbtn();

			//hmhDocumentDetailsSteps.pushToHabitat();
			//hmhDocumentDetailsSteps.pushToHabitatOK();
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(3);
			hmhDocumentDetailsSteps.waitUntilPushToHabitatDone();

			//verify the Habitat value
			hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty, habitatStatus);
			hmhDocumentDetailsSteps.verifyPushTohabitatStatus(habitatProperty1, habitatStatus1);				

		    //Perform Advance search After Habitat Push
			shareHeaderSteps.advancedSearchButtonClick();
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.selectLookFor(typePS);
			//advancedSearchSteps.selectLookForPage(typeCO);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.selectLookForPage("Product Set");
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.selectLookForPage(typePS);
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.afterHabitatPushAdvanceSearch(habitatShortName);
			shareHeaderSteps.customWait(2);
			hmhAdvancedSearchSteps.clickSearchButton();
			//advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			//	searchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.isElementPresentInSearchResult(objectName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typePS);	
			shareHeaderSteps.customWait(5);
			
			//Verify Negative scenario on Before push search(Object actually pushed)
			hmhSearchResultsSteps.backSearchResultsButton();
			hmhAdvancedSearchSteps.selectLookFor(typePS);
			//advancedSearchSteps.selectLookForPage(typeCO);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.selectLookForPage("Product Set");
			shareHeaderSteps.customWait(5);		
			hmhAdvancedSearchSteps.beforeHabitatPushAdvanceSearch(habitatShortName);
			shareHeaderSteps.customWait(2);
			hmhAdvancedSearchSteps.clickSearchButton();
			//advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			//Updated the script on 10/15/2018
			//Checking if objects is present, There should not be any search result present here
			hmhSearchResultsSteps.noElementPresentinSearchResults(zeroresultsinSearch);
			System.out.println("Script completed");
	}

}
