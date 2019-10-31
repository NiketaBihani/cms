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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG024_AdvanceSearchForK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG024_AdvanceSearchForK12 extends com.hmh.automation.tools.AbstractSampleTest {
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
	productCategory, studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text";
	String refineFieldDrop,refineOperatorDrop;
	int waitForSearchResultsSeconds=10;
	private boolean isCONFound=true;
	private boolean isAssetFound=true;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG024 - LO& Asset - Advance Search Functionality in K12 site")
	public void test_REG024_AdvanceSearchForK12() {

		hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.K12_SITE_NAME, this.siteType);
		hmhSiteFinderSteps.searchUserSites(ConstantsHMH.K12_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.K12_SITE_NAME);
    	siteHeaderSteps.clickOnDocumentLibraryButton();		
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		this.isCONFound = hmhDocumentLibrarySteps.isAssetPresent(objectNameCO);  
		
		if (isCONFound == false){
			
			hmhDocumentDetailsSteps.createLOforK12();
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createLearningObjectK12Site(objectNameCO, grade, language, rights, market, title, lifecycle);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
			hmhDocumentLibrarySteps.assetFromListClickSub(objectNameCO);
			hmhEditPropertiesSteps.clickOnEditPropertiesDetails();  
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.productCategoryMultiSelect(productCategory);
			hmhEditPropertiesSteps.productTypeDropDown(productType);
			hmhEditPropertiesSteps.productTypeIDDropDown(productTypeID);
			hmhEditPropertiesSteps.productTypeSubIDTextBox(productTypeSubID);
			hmhEditPropertiesSteps.userRoleDropDown(userRole);
			hmhEditPropertiesSteps.activityTypeDropDown(activityType);
			hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
			hmhEditPropertiesSteps.saveButtonClick();
		}
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectNameAsset);
		
		if (isAssetFound == false){
			
			documentLibrarySteps.createNewContent(typeAsset);
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
			hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
			shareHeaderSteps.customWait(3);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.productTypeDropDown(productType);
			hmhEditPropertiesSteps.activityTypeDropDown(activityType);
			hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
			hmhEditPropertiesSteps.saveButtonClick();
		}

		// **** advance search for K12 Product type Content Object   	
		shareHeaderSteps.advancedSearchButtonClick();
		shareHeaderSteps.customWait(3);
		 /* ******** FIX ******* */
	   	 /*The old method commented below was not able to locate the drop down object 
	   	 so we used newly implemented code "hmhAdvancedSearchSteps.selectLookFor(typeCO)"
	   	 to fix the same*/
		hmhAdvancedSearchSteps.selectLookFor(typeCO);
		//advancedSearchSteps.selectLookForPage(typeCO);
		shareHeaderSteps.customWait(5);
		advancedSearchSteps.selectLookForPage("Content");
		shareHeaderSteps.customWait(5);
		advancedSearchSteps.selectLookForPage(typeCO);
		shareHeaderSteps.customWait(3);
		hmhAdvancedSearchSteps.clickPlusToExpandK12();
		shareHeaderSteps.customWait(2);
		hmhAdvancedSearchSteps.selectProductCategoryAdvanceSearch(productCategory);
		hmhEditPropertiesSteps.editProductTypeK12(productType);
		hmhEditPropertiesSteps.editProductTypeIDK12(productTypeID);
		shareHeaderSteps.customWait(2);
		 // ** Fix provided for REG024 BVT script ** Sprint 7.3.4 ** 14th Sep ** 
		hmhAdvancedSearchSteps.clickSearchButton();
		//advancedSearchSteps.clickSearchButton();
		shareHeaderSteps.customWait(5);
	//	searchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
		hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typeCO);

		//	**** advance search for K12 Product type Asset
		shareHeaderSteps.advancedSearchButtonClick();
		shareHeaderSteps.customWait(3);
		 /* ******** FIX ******* */
   	 /*The old method commented below was not able to locate the drop down object 
   	 so we used newly implemented code "hmhAdvancedSearchSteps.selectLookFor(typeAsset)"
   	 to fix the same*/
		hmhAdvancedSearchSteps.selectLookFor(typeAsset);
		//advancedSearchSteps.selectLookForPage(typeAsset);
		shareHeaderSteps.customWait(5);
		advancedSearchSteps.selectLookForPage("Content");
		shareHeaderSteps.customWait(5);
		advancedSearchSteps.selectLookForPage(typeAsset);
		shareHeaderSteps.customWait(3);
		hmhAdvancedSearchSteps.clickPlusToExpandK12();
		// ** Fix provided to search the activity type value criteria ** Sprint 7.3.4 ** 10th Sep **
		shareHeaderSteps.customWait(3);
		hmhEditPropertiesSteps.activityTypeDropDown(activityType);
		shareHeaderSteps.customWait(3);
		// ** Fix provided for REG024 BVT script ** Sprint 7.3.4 ** 14th Sep ** 
		hmhAdvancedSearchSteps.clickSearchButton();
		//advancedSearchSteps.clickSearchButton();
		shareHeaderSteps.customWait(5);
		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameAsset, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
		hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typeAsset);
		shareHeaderSteps.customWait(5);
	    System.out.println("Script completed");
		
	}
}
