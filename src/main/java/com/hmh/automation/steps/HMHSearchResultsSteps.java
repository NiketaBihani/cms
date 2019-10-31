package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHSearchResultsPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHSearchResultsSteps extends AbstractSteps<HMHSearchResultsPage> {

    private static final long serialVersionUID = -854611134541075184L;

    public HMHSearchResultsSteps(Pages pages) {
        super(pages, HMHSearchResultsPage.class);
    }

    @Step("Check HMH thumbnails in search results list")
    public void checkIfThumbnailIsDisplayed(String object) {
        currentPage().checkIfThumbnailIsDisplayed(object);
    }
    
    @Step("Verify if document {0} is present in the list")
	public void isElementPresentInSearchResult(String itemName, int waitForSearchResultsSeconds, int manualScrollSeconds, boolean shouldBePresent) {
    	 currentPage().checkIfDocumentIsPresentInResultsList(itemName, waitForSearchResultsSeconds, manualScrollSeconds, shouldBePresent);
	}
    
    @Step("Search within results page with input {0}")
    
    public void searchInResultsPage(String input){
    	currentPage().searchInResultsPage(input);
    }

    @Step(" Select the Refine Search checkbox {0}")
    
    public void refineSearchCheck(){
    	currentPage().refineSearchCheck();
    }

    @Step(" Select the Refine Search Field {0}")
 
 	public void selectrefineSearchFieldDrop(String refineFieldDrop){
 	currentPage().selectrefineSearchFieldDrop(refineFieldDrop);
    }
    
    @Step(" Select the Refine Search in next row Field  {0}")
    
 	public void selectrefineSearchFieldDrop1(String refineFieldDrop1){
 	currentPage().selectrefineSearchFieldDrop1(refineFieldDrop1);
    }
 
    @Step(" Select the Refine Search Operator {0}")
 
    public void selectrefineSearchOperatorDrop(String refineOperatorDrop){
     currentPage().selectrefineSearchOperatorDrop(refineOperatorDrop);
     }
 
    @Step(" Select the Refine Search Condition {0}")
 
    public void selectrefineSearchGenreConditionDrop(String refineGenreConditionDrop){
     currentPage().selectrefineSearchGenreConditionDrop(refineGenreConditionDrop);
     }
    
    @Step(" Select the Refine Search And OR Drop {0}")
    
    public void selectrefineSearchAndOrConditionDrop(String refineSearchAndConditionDrop){
     currentPage().selectrefineSearchAndOrConditionDrop(refineSearchAndConditionDrop);
     }
 
    @Step(" Select the Refine Search New Row Condition {0}")
 
    public void selectrefineSearchNewRowConditionDrop(String refineSearchRowConditionDrop){
     currentPage().selectrefineSearchNewRowConditionDrop(refineSearchRowConditionDrop);
     }
    
        
    @Step(" Select the Refine Search button {0}")
    public void buttonrefineSearch(){
    currentPage().buttonrefineSearch();
    }
    
    @Step(" Click the Refine Search Add New Row {0}")
    public void addNewRow(){
    	currentPage().addNewRow();
    }
    
    @Step(" Click the Delete New Row in Advance Search")
    public void deleteNewRow(){
    	currentPage().deleteNewRow();
    }
    
    @Step(" Click the All Sites from the Search Results")
    public void searchResultsAllSites(){
    	currentPage().searchResultsAllSites();
    }
    
    @Step(" Click the Repository from the Search Results")
    public void searchResultsRepository(){
    	currentPage().searchResultsRepository();
    }
    
    @Step(" Click the Search Results Drop Down")
    public void searchResultsDropdown(){
    	currentPage().searchResultsDropdown();
    }
  //** ALF -1627  - HIP Search: Persist Refined Search on Search Screen Sprint 7.2.5 **
    @Step(" Click the Back to Search Results button")
    public void backSearchResultsButton(){
    	currentPage().backSearchResults();
    }
  //** ALF-1581 Return to Search Results Screen from Standards Hierarchy Sprint 7.3.1 **
    @Step(" Click the Back to Search Results button")
    public void returnToSearchButton(){
    	currentPage().returnToSearchButton();
    }	
  //** ALF-1581 Return to Search Results Screen from Standards Hierarchy Sprint 7.3.1 **
    @Step("Verify if document {0} is present in the list")
    public void verifyElementPresentInSearchResults(String itemName, int waitForSearchResultsSeconds) {
    	currentPage().verifyIfDocumentIsPresentInList(itemName, waitForSearchResultsSeconds);
  
    }
    
  //** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **  
    @Step(" Select the Search checkbox {0}")
    public void SearchCheck(){
    	currentPage().SearchCheck();
    }
    
  //** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **
    @Step(" Select the Search checkbox {0}")
    public void checkSearchBox(){
    	currentPage().checkSearchBox();
    }
    
  //** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **  
    @Step(" Click on Edit Common Properties Action {0}")
    public void clickEditCommonPropertiesAction(){
    	currentPage().clickEditCommonPropertiesAction();
    }
    
  //** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **  
    @Step(" Click on Edit Common Properties Action {0}")
    public void selectAndCheckEditCommonProperties(String productTypeName, String description){
    	currentPage().selectAndCheckEditCommonProperties(productTypeName, description);
    }
    
  //** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **
    @Step(" Click To Move To Action")
    public void clickMoveToAction(){
    	currentPage().clickMoveToAction();
    }
  
  //** ALF -2262  - Advanced Search: Search by Habitat short name ** Sprint 7.3.4 ** 4th Oct **
    @Step("Verify when zero results {0} present in the search section")
   	public void noElementPresentinSearchResults(String itemName) {
       	 currentPage().noElementPresentinSearchResults(itemName);
   	}
    
  //** ALF-2333 **  Trade: Ability to generate a PDF without first creating a collection ** Sprint 7.3.5 **  
    @Step(" Click on Edit Common Properties Action {0}")
    public void clickGeneratePDFActionOnSearchPage() {
    	currentPage().clickGeneratePDFActionOnSearchPage();
    }
    
  //** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **  
    @Step(" Select the Search checkbox {0}")
    public void clickCheckBoxOnAssets(String fname,String fname1) {
    	currentPage().clickCheckBoxOnAssets(fname, fname1);
    }
    
    
}
