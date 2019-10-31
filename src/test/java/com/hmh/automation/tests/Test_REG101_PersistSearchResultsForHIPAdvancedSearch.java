//*****ALF -1627  - HIP Search: Persist Refined Search on Search Screen (Sprint 7.2.5)*****

package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
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
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG065_AdvanceSearchTextFieldsWithinResultsforHIP.csv", separator = ConstantsHMH.CSV_SEPARATOR)

	public class Test_REG101_PersistSearchResultsForHIPAdvancedSearch extends com.hmh.automation.tools.AbstractBaseSiteTestHIP{

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
	
	//Added Advance Search
	@Steps
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	    
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
	@Steps
	private MyProfileSteps myProfileSteps;
	@Steps
	private UserTrashcanSteps userTrashcanSteps;
	
	String  type,grade, title,siteTypeTest,
	description, searchTerm, name3,fileName, caption1, 
	genreSelectdrop, refineFieldDrop,refineOperatorDrop,refineFieldDrop1,fileName1,assetSubtypeSelectdrop,refineSearchRowConditionDrop,refineSearchAndConditionDrop;
	String random=RandomStringUtils.randomAlphanumeric(5);
	String objectName="Tc101"+ConstantsHMH.TODAY_DATE;
	
	int waitForSearchResultsSeconds=10;

	private boolean isPSFound=true;
	private boolean isFileFound=true;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG101_Persist Search Results For HIP Advanced Search")
	public void Test_REG101_PersistSearchResultsForHIPAdvancedSearch() {

		hmhSiteFinderSteps.searchUserSites(ConstantsHMH.HIP_SITE_NAME);
		
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.HIP_SITE_NAME);
    	System.out.println("Document library");
    	siteHeaderSteps.clickOnDocumentLibraryButton();
    	shareHeaderSteps.customWait(5);
    
    	this.isFileFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);
    	
    	if (isFileFound == false){
    		hmhDocumentLibrarySteps.createNewContent(type);
        	hmhDocumentLibrarySteps.createHipObject(objectName, title, grade);
            hmhDocumentLibrarySteps.refresh();
            
            hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);
            hmhDocumentLibrarySteps.hipobjectFromListClick(objectName);
            documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
            hmhEditPropertiesSteps.editDescription(description);
            
            hmhEditPropertiesSteps.enterCaptionForHipObject(caption1);
            hmhEditPropertiesSteps.selectGenreForHipObject(genreSelectdrop);
            hmhEditPropertiesSteps.selectAssetSubtypeForHipObject(assetSubtypeSelectdrop);
            hmhEditPropertiesSteps.saveButtonClick();
            shareHeaderSteps.customWait(5);
            
    	}
    	shareHeaderSteps.customWait(5);
   		System.out.println("Advance Search -------------------");
   		shareHeaderSteps.advancedSearchButtonClick();
   		shareHeaderSteps.customWait(3);
   		hmhAdvancedSearchSteps.selectAdvanceSearchFieldDrop(refineFieldDrop);
   		hmhAdvancedSearchSteps.selectAdvanceSearchOperatorDrop(refineOperatorDrop);
   		hmhAdvancedSearchSteps.selectAdvanceSearchConditionDrop(objectName);
     	hmhAdvancedSearchSteps.btnSearchHIPObject();

   	   	//Verify if document is present in the search results list
   		hmhSearchResultsSteps.isElementPresentInSearchResult(objectName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);   		  		  		
        shareHeaderSteps.customWait(5);
        
        hmhSearchResultsSteps.searchResultsDropdown();
        shareHeaderSteps.customWait(2);
        hmhSearchResultsSteps.searchResultsAllSites();
        shareHeaderSteps.customWait(2);
        hmhSearchResultsSteps.isElementPresentInSearchResult(objectName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        shareHeaderSteps.customWait(5);
        
        hmhSearchResultsSteps.searchResultsDropdown();
        shareHeaderSteps.customWait(2);
        hmhSearchResultsSteps.searchResultsRepository();
        shareHeaderSteps.customWait(2);
        //Verify if element present in the search  
        hmhSearchResultsSteps.isElementPresentInSearchResult(objectName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        shareHeaderSteps.customWait(5);
        //Move back to HIP search page to verify the search criteria persists
        hmhSearchResultsSteps.backSearchResultsButton();
        shareHeaderSteps.customWait(5);
        hmhAdvancedSearchSteps.verifyAssetAdvanceSearchFields(refineFieldDrop, refineOperatorDrop,objectName);
        shareHeaderSteps.customWait(3);
        
        // Tear down steps added on  24th Sep 2018 (Sprint 7.3.4)
        hmhAdvancedSearchSteps.backToHipSiteButton();
        siteHeaderSteps.clickOnDocumentLibraryButton();
    	shareHeaderSteps.customWait(5);
    	hmhDocumentLibrarySteps.hipobjectFromListClick(objectName);
    	hmhDocumentLibrarySteps.deleteDocOnViewDetailsLS();
    	
        this.shareHeaderSteps.myProfileButtonClick();
		this.myProfileSteps.trashcanMenuClick();
		this.userTrashcanSteps.emptyTrashcan();		
		this.shareHeaderSteps.homeButtonClick();

    	       
        System.out.println("Script completed");
	}
}
