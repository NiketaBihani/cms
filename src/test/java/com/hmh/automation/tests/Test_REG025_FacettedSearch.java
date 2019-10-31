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


@Story(HMHApplication.Search.FacettedSearch.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG025_FacettedSearch.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG025_FacettedSearch extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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

	String typeCO, objectNameCO, objectNameAsset, typeAsset, viewportSizes, rights, grade, language, title, description, characters, interests, events, activityType,
	lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, market, learningStyle, siteTypeTest, 
	minVeiwPortSizeSearch, facet, facet2, cwOriginalcontent, cwOriginalcontent2;

	private boolean isAssetFound=true;
	int waitForSearchResultsSeconds;

	private boolean isCONFound=true;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG025 - Facetted Search Functionality")
	public void test_REG025_FacettedSearch() {

		//hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
    	siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		this.isCONFound = hmhDocumentLibrarySteps.isAssetPresent(objectNameCO);    	
		if (isCONFound == false){
			hmhDocumentDetailsSteps.createLOforConsumer();
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createLearningObjectConsumerSite(objectNameCO, grade, rights, market, title);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
			hmhDocumentLibrarySteps.assetFromListClickSub(objectNameCO);
			shareHeaderSteps.customWait(4);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.editCwOriginalContent(cwOriginalcontent);
			hmhEditPropertiesSteps.editLearningStyles(learningStyle);
			hmhEditPropertiesSteps.editCharacterList(characters);
			hmhEditPropertiesSteps.editMinViewportSizeList(viewportSizes);
			hmhEditPropertiesSteps.editInterestWithMultipleSelect(interests); 
			hmhEditPropertiesSteps.editEvents(events);
			hmhEditPropertiesSteps.editResourceType(resourceType);
			hmhEditPropertiesSteps.saveButtonClick();
		}

		//      ***** facetted search for CW Content Object***
		shareHeaderSteps.advancedSearchButtonClick();	
		shareHeaderSteps.customWait(10);
		 /* ******** FIX ******* */
	   	 /*The old method commented below was not able to locate the drop down object 
	   	 so we used newly implemented code "hmhAdvancedSearchSteps.selectLookFor(typeCO)"
	   	 to fix the same*/
		hmhAdvancedSearchSteps.selectLookFor(typeCO);
		//advancedSearchSteps.selectLookForPage(typeCO);
		shareHeaderSteps.customWait(10);
		hmhAdvancedSearchSteps.clickPlusToExpand();
		hmhAdvancedSearchSteps.selectMinViewPortSizeAdvanceSearch(viewportSizes);
		advancedSearchSteps.clickSearchButton();
		shareHeaderSteps.customWait(5);
		hmhAdvancedSearchSteps.selectFacet(facet2);
		shareHeaderSteps.customWait(5);
		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameAsset, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
		hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typeCO);

	}

}
