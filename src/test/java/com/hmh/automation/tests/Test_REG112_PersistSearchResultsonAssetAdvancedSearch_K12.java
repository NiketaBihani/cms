//** ALF -2007  - Asset Advanced Search: Persist Previous Search on Search Screen ** Sprint 7.3.1 **
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG112_PersistSearchResultsonAssetAdvancedSearch_K12.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG112_PersistSearchResultsonAssetAdvancedSearch_K12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
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

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG112 - Persist Search Results on Asset Advanced Search in K12")
	public void test_REG112_PersistSearchResultsonAssetAdvancedSearch_K12() {

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

			// **** advance search for K12 Product type Content Object   	
			shareHeaderSteps.advancedSearchButtonClick();
			hmhAdvancedSearchSteps.SearchforAssetAdvanced();
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.selectAssetAdvanceSearchFieldDrop(refineFieldDrop);			
			/*hmhAdvancedSearchSteps.selectAdvanceSearchOperatorDrop(refineOperatorDrop);			
			shareHeaderSteps.customWait(3);	*/		
			hmhAdvancedSearchSteps.enterAssetAdvancedConditionInput(objectNameAsset);
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.btnSearchAssetAdvanced();
			hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameAsset, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.backSearchResultsButton();
			shareHeaderSteps.customWait(3);
			hmhAdvancedSearchSteps.verifyAssetAdvanceSearch(refineFieldDrop, refineOperatorDrop,objectNameAsset);
			shareHeaderSteps.customWait(3);
			System.out.println("Script completed");
		
		
		
		
	}}
		