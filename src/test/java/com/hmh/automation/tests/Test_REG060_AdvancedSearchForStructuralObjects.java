package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Search.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG060_AdvancedSearchForStructuralObjects.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG060_AdvancedSearchForStructuralObjects extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	@Steps
	private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private SearchResultsSteps searchResultsSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;

	String type, year, grade, markets, label1, numbering1, numbering2, name, aspectName, title, siteTypeTest, description, learningStyle, featured, viewportSizes, characters, interests, events, collection="//ul//li//span//span[contains(text(),'Collection')]";

	int waitForSearchResultsSeconds;
	private boolean isAssetFound=true;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG060 - Advanced Search For a Structural Objects")
	public void test_REG060_AdvancedSearchForStructuralObjects() {
		siteHeaderSteps.clickOnDocumentLibraryButton();
		switch (type) {

		case "Product Set":
			hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
	    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
	    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(name);
			if(isAssetFound==false){
				documentLibrarySteps.createNewContent(type);
				hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
				hmhDocumentLibrarySteps.createProductSet(name, year, grade, label1, numbering1, markets, title);
				hmhDocumentLibrarySteps.refresh();
				hmhDocumentLibrarySteps.assetFromListClick(name);
				hmhDocumentLibrarySteps.navBarClick(name);
				shareHeaderSteps.customWait(5);        
				documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
				hmhEditPropertiesSteps.editDescription(description);
				hmhEditPropertiesSteps.saveButtonClick();
				shareHeaderSteps.customWait(5);
			}
			siteHeaderSteps.clickOnDocumentLibraryButton();
			shareHeaderSteps.advancedSearchButtonClick();
			// *** Fix  ***
			hmhAdvancedSearchSteps.selectLookFor(type);
			//advancedSearchSteps.selectLookForPage(type);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.inputSearchName(name);
			advancedSearchSteps.inputSearchName(name);
			hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
		//	hmhAdvancedSearchSteps.selectYearInAdvancedSearch(year);
			advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
			break;

		case "Learning Bundle":
			hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
	    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
	    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
	    	siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(LearningBundlesFolder);
			this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(name);
			if(isAssetFound==false){
				documentLibrarySteps.createNewContent(type);
				hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
				hmhDocumentLibrarySteps.createLearningBundleConsumerSite(name, grade, markets, title);
				hmhDocumentLibrarySteps.refresh();
				hmhDocumentLibrarySteps.assetFromListClick(name);
				hmhDocumentLibrarySteps.navBarClick(name);
				shareHeaderSteps.customWait(3);
				documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
				hmhEditPropertiesSteps.editDescription(description);
				hmhEditPropertiesSteps.editFeaturedList(featured);
				hmhEditPropertiesSteps.editLearningStyles(learningStyle);
				hmhEditPropertiesSteps.editCharacterList(characters);
				hmhEditPropertiesSteps.editMinViewportSizeList(viewportSizes);
				hmhEditPropertiesSteps.editInterestWithMultipleSelect(interests); 
				hmhEditPropertiesSteps.editEvents(events);
				hmhEditPropertiesSteps.saveButtonClick();
				shareHeaderSteps.customWait(3);
			}
			shareHeaderSteps.advancedSearchButtonClick();
			// *** FIX ***
			hmhAdvancedSearchSteps.selectLookFor(type);
			//advancedSearchSteps.selectLookForPage(type);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.inputSearchName(name);
			advancedSearchSteps.inputSearchName(name);
			shareHeaderSteps.customWait(3);
			//     hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
			advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(8);
			//            searchResultsSteps.searchInSite(siteName);
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);

			/*hmhSearchResultsSteps.searchInResultsPage(name);
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);*/
			hmhShareHeaderSteps.waitForElementX(collection, 60);
//			searchResultsSteps.selectFacet(featured);
//			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			break;

		case "Sequence Bundle":
			hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
	    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
	    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
	    	siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
			this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(name);
			if(isAssetFound==false){
				documentLibrarySteps.createNewContent(type);
				hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
				hmhDocumentLibrarySteps.createSequenceBundle(name, markets, title);
				hmhDocumentLibrarySteps.refresh();
				hmhDocumentLibrarySteps.assetFromListClick(name);
				hmhDocumentLibrarySteps.navBarClick(name);
				shareHeaderSteps.customWait(3);
				documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
				hmhEditPropertiesSteps.editDescription(description);
				hmhEditPropertiesSteps.saveButtonClick();
				shareHeaderSteps.customWait(3);
			}
			shareHeaderSteps.advancedSearchButtonClick();
			// *** Fix ***
			hmhAdvancedSearchSteps.selectLookFor(type);	
			//advancedSearchSteps.selectLookForPage(type);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.inputSearchName(name);
			advancedSearchSteps.inputSearchName(name);
			shareHeaderSteps.customWait(3);
			advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(8);
			//            searchResultsSteps.searchInSite(siteName);
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
			break;

		case "Program":
			hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
	    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
	    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
	    	siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
			this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(name);
			if(isAssetFound==false){
				documentLibrarySteps.createNewContent(type);
				hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
				hmhDocumentLibrarySteps.createProgram(name, title, markets);
				hmhDocumentLibrarySteps.refresh();  
			}
			shareHeaderSteps.advancedSearchButtonClick();
			// *** Fix ***
			hmhAdvancedSearchSteps.selectLookFor(type);
		//	advancedSearchSteps.selectLookForPage(type);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.inputSearchName(name);
			//            hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
			advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
			break;

		case "Product Object":
			hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
	    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
	    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
	    	siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
			this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(this.name);
			if(isAssetFound==false){
				documentLibrarySteps.createNewContent(type);
				hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
				hmhDocumentLibrarySteps.createProductObject(name, year, title);
				hmhDocumentLibrarySteps.refresh();
			}
			siteHeaderSteps.clickOnDocumentLibraryButton();
			shareHeaderSteps.advancedSearchButtonClick();
			// *** Fix ***
			hmhAdvancedSearchSteps.selectLookFor(type);
			//advancedSearchSteps.selectLookForPage(type);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.inputSearchName(name);
			advancedSearchSteps.inputSearchName(name);
			advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
			shareHeaderSteps.advancedSearchButtonClick();
			// *** Fix ***
			hmhAdvancedSearchSteps.selectLookFor(type);
			//advancedSearchSteps.selectLookForPage(type);
			shareHeaderSteps.customWait(5);
			advancedSearchSteps.inputSearchName(name);
		//	advancedSearchSteps.inputSearchName(name);
			hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
			advancedSearchSteps.clickSearchButton();
			shareHeaderSteps.customWait(5);
			//should not present in search results since PO doesn't have grade
			searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);
			break;
		}
		shareHeaderSteps.customWait(3);
	}
}