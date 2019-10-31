//** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **
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
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.pages.alfresco.SearchResultsPage;
//
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
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.Search.AdvancedSearch.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG127_InvokeMoveToActionOnMultipleSearchResults.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG127_InvokeMoveToAction_OnMultipleSearchResults_InK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
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
	//
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;


	String typeCO, objectNameCO, typeAsset, objectNameAsset, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, description, resourceType, siteTypeTest,
	productCategory, studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text",refineFieldDrop,refineOperatorDrop;
	int waitForSearchResultsSeconds=10;
	private boolean isAssetFound=true;
	String newAsset = "TC127_Asset1";
	String asset = "TC127";
	String allSites="All Sites";
	                 
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test REG127 Invoke Move To Action On Multiple Search Results In K12")
	public void test_REG127_InvokeMoveToAction_OnMultipleSearchResults_InK12() {

		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectNameAsset);
		
		if (isAssetFound == false){
			
			documentLibrarySteps.createNewContent(typeAsset);
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
			hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
			hmhEditPropertiesSteps.editPropClick();
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.productTypeDropDown(productType);
			hmhEditPropertiesSteps.activityTypeDropDown(activityType);
			hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
			hmhEditPropertiesSteps.saveButtonClick();
		}
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(newAsset);
		
		
		if (isAssetFound == false){

			documentLibrarySteps.createNewContent(typeAsset);
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createComponentK12Site(newAsset, title, rights, grade, lifecycle);
			hmhDocumentLibrarySteps.assetFromListClickSub(newAsset);
			hmhEditPropertiesSteps.editPropClick();
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.productTypeDropDown(productType);
			hmhEditPropertiesSteps.activityTypeDropDown(activityType);
			hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
			hmhEditPropertiesSteps.saveButtonClick();
		}

			//  Quick search for K12 Product type Content Object
			documentLibrarySteps.enterTextInSearchBox(asset);
			hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameAsset, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.isElementPresentInSearchResult(newAsset, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			
			// Performs Move To action on the objects and moves to the different site
			hmhSearchResultsSteps.checkSearchBox();
			shareHeaderSteps.customWait(3);
			hmhSearchResultsSteps.clickMoveToAction();	
			shareHeaderSteps.customWait(5);
			hmhEditPropertiesSteps.navigateInMoveFilesreferencesDialogBox(allSites);
			shareHeaderSteps.customWait(5);
			hmhEditPropertiesSteps.navigateInMoveFilesreferencesDialogBox(ConstantsHMH.K12_SITE_NAME);
			shareHeaderSteps.customWait(3);
			hmhEditPropertiesSteps.navigateInAssetsFolderandMoveAction();
			
			// Search for the objects in the assets folder in the site moved
			hmhSiteFinderSteps.searchUserSites(ConstantsHMH.K12_SITE_NAME);
	    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.K12_SITE_NAME);
	    	siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
			//hmhDocumentLibrarySteps.assetFromListClick(objectNameAsset);
			/*hmhDocumentLibrarySteps.clickDeleteObject();
			hmhDocumentLibrarySteps.confirmDelete();
			    	
			hmhDocumentLibrarySteps.goBackToPreviousPage();			
			hmhDocumentLibrarySteps.assetFromListClick(newAsset);
			hmhDocumentLibrarySteps.clickDeleteObject();
			hmhDocumentLibrarySteps.confirmDelete();*/
			    							
			System.out.println("Script completed");
		
		
		
		
	}}
		