package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

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
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
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

@Story(HMHApplication.Search.QuickSearch.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG026_QuickSearch.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG026_QuickSearch extends com.hmh.automation.tools.AbstractBaseSiteTestNew{

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
	private SearchResultsPage searchResultsPage;
	@Steps
	private SearchResultsSteps searchResultsSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	@Steps
	private CategoryManagerSteps categoryManagerSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
	//
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;

	String objectName, type, rights, year, markets, label1, numbering1, grade, language, actionName, standardFolder, standard, dashlet, title,
	lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, dataList, siteTypeTest, 
	level1, description, right, searchTerm, name1, name2, fileName, objectNameK12;

	int waitForSearchResultsSeconds;

	private boolean isPSFound=true;
	private boolean isFileFound=true;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG026 - Quick search Functionality - Consumer")
	public void test_REG026_QuickSearch() {

	/*	hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
	   	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
    	siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		this.isFileFound = hmhDocumentLibrarySteps.isAssetPresent(fileName);  	
		if (isFileFound == false){*/ 
			hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
			documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
			hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
			shareHeaderSteps.customWait(3);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.editTitle(title);
			hmhEditPropertiesSteps.editRight(right);
			hmhEditPropertiesSteps.editResourceType(resourceType);
			hmhEditPropertiesSteps.saveButtonClick();
		//}   
		//   ***Quick Search a Content text file
		documentLibrarySteps.enterTextInSearchBox(fileName);
		hmhSearchResultsSteps.isElementPresentInSearchResult(fileName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		//   ***Prerequisite Structural Object  (Product Set) should present
		/*hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		this.isPSFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);    	
		if (isPSFound == false){
			documentLibrarySteps.createNewContent(type);
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering1, markets, title);
			hmhDocumentLibrarySteps.refresh();
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			shareHeaderSteps.customWait(5);        
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.saveButtonClick();
		}    
		//  ***Quick Search a Structural Object (Product Set)
		documentLibrarySteps.enterTextInSearchBox(searchTerm);
		hmhSearchResultsSteps.isElementPresentInSearchResult(objectName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
		// ***Quick Search a object which should NOT be present (Product Set "PS_K" from K-12 Site)
		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameK12, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);
				*/
	}
}
