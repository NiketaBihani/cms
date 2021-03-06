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

@Story(HMHApplication.Search.QuickSearch.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG063_QuickSearchTextFieldsWithinResults.csv", separator = ConstantsHMH.CSV_SEPARATOR)

	public class Test_REG063_QuickSearchTextFieldsWithinResultsforHIP extends com.hmh.automation.tools.AbstractBaseSiteTestHIP{

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
	
	String objectName, type, type1,grade, title,siteTypeTest,
	description, searchTerm, name3,fileName, caption1, 
	genreSelectdrop, refineFieldDrop,refineOperatorDrop,refineFieldDrop1,fileName1,assetSubtypeSelectdrop,refineSearchRowConditionDrop,refineSearchAndConditionDrop;

	int waitForSearchResultsSeconds;

	private boolean isPSFound=true;
	private boolean isFileFound=true;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG063 - Quick search Functionality HIP- TextFieldsWithinResults")
	public void test_REG063_QuickSearch() {

		hmhSiteFinderSteps.searchUserSites(ConstantsHMH.HIP_SITE_NAME);
		
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.HIP_SITE_NAME);
    	System.out.println("Document library");
    	siteHeaderSteps.clickOnDocumentLibraryButton();
    	shareHeaderSteps.customWait(5);
    
    	this.isFileFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);
    	
    	if (isFileFound == false){
    		hmhDocumentLibrarySteps.createNewContent(type1);
        	hmhDocumentLibrarySteps.createHipObject(name3, title, grade);
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
   //   ***Quick Search a Content text file
   		documentLibrarySteps.enterTextInSearchBox(searchTerm);

   		hmhSearchResultsSteps.refineSearchCheck();
   		hmhSearchResultsSteps.selectrefineSearchFieldDrop(refineFieldDrop);
   		hmhSearchResultsSteps.selectrefineSearchOperatorDrop(refineOperatorDrop);
   		shareHeaderSteps.customWait(3);
   		hmhSearchResultsSteps.selectrefineSearchGenreConditionDrop(genreSelectdrop);
   		
   		//To add new row in Refine Search
   		
   		hmhSearchResultsSteps.addNewRow();  
   		
   		//hmhSearchResultsSteps.deleteNewRow();
   		
   		//hmhSearchResultsSteps.addNewRow();  
   		
   		hmhSearchResultsSteps.selectrefineSearchAndOrConditionDrop(refineSearchAndConditionDrop);
   		
   		hmhSearchResultsSteps.selectrefineSearchFieldDrop1(refineFieldDrop1);
   		hmhSearchResultsSteps.selectrefineSearchOperatorDrop(refineOperatorDrop);
   		shareHeaderSteps.customWait(3);
   		hmhSearchResultsSteps.selectrefineSearchNewRowConditionDrop(refineSearchRowConditionDrop);
   		
   		hmhSearchResultsSteps.buttonrefineSearch();
    	shareHeaderSteps.customWait(5);
    	
   	//Verify if document is present in the list
   		hmhSearchResultsSteps.isElementPresentInSearchResult(fileName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);   		  		  		
   	
   	// ***Quick Search a object which should NOT be present (Product Set "PS_K" from K-12 Site)
//   		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameK12, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);   				
//   		hmhSearchResultsSteps.isElementPresentInSearchResult(fileName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);   				
    	
//   		**** advance search for consumer Asset 
   		/*
   		System.out.println("Advance Search -------------------");
   		shareHeaderSteps.advancedSearchButtonClick();
   		shareHeaderSteps.customWait(3);
   		hmhAdvancedSearchSteps.selectAdvanceSearchFieldDrop(refineFieldDrop);
 		
   		hmhAdvancedSearchSteps.selectAdvanceSearchOperatorDrop(refineOperatorDrop);
   		
   		hmhAdvancedSearchSteps.selectAdvanceSearchConditionDrop(genreSelectdrop);

   		hmhAdvancedSearchSteps.addNewRow();
   		
   		shareHeaderSteps.customWait(1);   		  		
   		hmhAdvancedSearchSteps.selectAdvanceSearchFieldDrop1(refineFieldDrop1);
   		shareHeaderSteps.customWait(3);
   		hmhAdvancedSearchSteps.selectAdvanceSearchConditionDrop1(refineSearchRowConditionDrop);
   		
   		hmhAdvancedSearchSteps.btnSearchHIPObject();

   	   	//Verify if document is present in the list
   		hmhSearchResultsSteps.isElementPresentInSearchResult(fileName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);   		  		  		
        shareHeaderSteps.customWait(5);
        */
        System.out.println("Script completed");
	}
}
