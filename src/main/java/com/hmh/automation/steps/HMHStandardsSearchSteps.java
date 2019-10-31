package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHStandardsSearchPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHStandardsSearchSteps extends AbstractSteps<HMHStandardsSearchPage> {

    private static final long serialVersionUID = -854611134541075184L;

    public HMHStandardsSearchSteps(Pages pages) {
        super(pages, HMHStandardsSearchPage.class);
    }

    @Step("Click on Standards in Header")
    public void clickOnStandards() {
        currentPage().clickOnStandards();
    }

    @Step("Enter keyword {0} to search Document/Standards")
    public void keyWordSearch(String inputKeyword) {
        currentPage().keyWordSearch(inputKeyword);
    }
    
    @Step("Click on search button")
    public void clickOnSearch() {
        currentPage().clickOnSearch();
    }
    
    @Step("Click On import button for the standard {0}")
    public void importStandardsToOneCMS(String docName) {
        currentPage().importStandardsToOneCMS(docName);
    }
    
    @Step("Wait until standard {0} is imported to OneCMS ")
    public void waitUntilStandardIsImported(String docName) {
        currentPage().waitUntilStandardIsImported(docName);
    }
    
    @Step("Click on actions button for document {0} in the search results list of standard documents ")
    public void clickOnActionsForDocument(String docName) {
        currentPage().clickOnActionsForDocument(docName);
    }
    
    @Step("Verify the document {0} is in the search results list ")
    public void verifyStandardIsPresentInSearchList(String docName) {
        currentPage().verifyStandardIsPresentInSearchList(docName);
    }
    
    
    @Step("Select Approved Collections  ")
    public void selectStandardCollection(String collectionName) {
        currentPage().selectStandardCollection(collectionName);
    }
    
    @Step("Expand Grade Level")
    public void expandGradeButton(String gradeNumber,String standardText,String importStdName,String subject) {
        currentPage().expandGradeButton(gradeNumber,standardText,importStdName,subject);
    }

    @Step("Correlate Object to Standard")
    public void CorrelateObjectToStandard(String fileName) {
        currentPage().CorrelateObjectToStandard(fileName);
    }
    
    @Step("View Correlations")
	public void viewCorrelations(String fileName) {
    	currentPage().viewCorrelations(fileName);
		
	}
    
    @Step("Remove Correlations")
	public void removeCorrelations(String fileName) {
    	currentPage().removeCorrelations(fileName);
		
	}

    @Step("Verify import Standard pop up displayed")
    public void verifyImportStandardPopupIsPresent(String labelImport){
        currentPage().verifyImportStandardPopupIsPresent(labelImport);        
    }
    
    @Step("Select Country from the import/Search Standard")
    public void selectCountryInStandards(String selectCountryVal){
        currentPage().selectCountryInStandards(selectCountryVal);
    }
    
    @Step("Select Authority from the import/Search Standard")
    public void selectAuthorityInStandards(String selectAuthorityVal){
        currentPage().selectAuthorityInStandards(selectAuthorityVal);
    }
    
    @Step("Select Document File from the import/Search Standard")
    public void selectDocumentFileInStandards(String selectDocumentFileVal){
        currentPage().selectDocumentFileInStandards(selectDocumentFileVal);
    }
    
    @Step("Select Subject Year from the import/Search Standard")
    public void selectSubjectYearInStandards(String selectSubYearVal) {
        currentPage().selectSubjectYearInStandards(selectSubYearVal);
    }
    
  //****ALF-1581 Return to Search Results Screen from Standards Hierarchy (Sprint 7.3.1)**** 
    @Step("Select Show Standard")
    public void selectShowStandard() {
        currentPage().selectShowStandard();
    }
    
  //** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 ** 
    @Step("Click on Export Standards action in the search results list ")
    public void clickOnExportStandards(String authorityName) {
        currentPage().clickOnExportStandards(authorityName);
    }
   
  //** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 ** 
    @Step("Click on Export Standards action in the search results list ")
    public void selectMetadataOnExportStandards() {
        currentPage().selectMetadataOnExportStandards();
    }
    
  //** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 ** 
    @Step("Click on Export Standards action in the search results list ")
    public void generateStandardReport() {
        currentPage().generateStandardReport();
    }
  //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 ** 
    @Step("Click on Add to Standards Cart ")
    public void clickAddToStandardsCartAction() {
        currentPage().clickAddToStandardsCartAction();
    } 
  //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
    @Step("Expand Grade Level")
    public void expandGradeButtonNextLevel(String gradeNumber,String standardText,String importStdName,String subject) {
        currentPage().expandGradeButtonNextLevel(gradeNumber,standardText,importStdName,subject);
    }
    
  //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
    @Step("Expand Grade Level")
    public void expandGradeButtonNew(String gradeNumber,String standardText,String importStdName,String subject) {
        currentPage().expandGradeButtonNew(gradeNumber,standardText,importStdName,subject);
    }
    
  //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
    @Step("Expand Grade Level")
    public void expandGradeButtonNewNextLevel(String gradeNumber,String standardText,String importStdName,String subject) {
        currentPage().expandGradeButtonNewNextLevel(gradeNumber,standardText,importStdName,subject);
    }
    
    //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
    @Step("Verify Correlations displayed in sorting order")
    public void verifyCorrelationInSortingOrderOnViewDetails() {
        currentPage().verifyCorrelationInSortingOrderOnViewDetails();
    }
    
    //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
    @Step("Click on Correlations")
    public void clickCorrelations() {
        currentPage().clickCorrelations();
    }
    
   //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
    @Step("Store the ABGUID value")
    public String storeABGUIDValue() {
        String val = currentPage().storeABGUIDValue();
        return val;
    }
    
   //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
    @Step("Verify the standard text of the correlated object on view details page")
    public void verifyStdTextForCorrelatedObject(String stdText) {
        currentPage().verifyStdTextForCorrelatedObject(stdText);
    }
    
    //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
    @Step("Select the Dropdown value in Search content")
    public void selectDropdownSearchContent(String value) {
        currentPage().selectDropdownSearchContent(value);
    }
    
    //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
    @Step("Enter the Keyword search")
    public void keywordSearch(String value) {
        currentPage().keywordSearch(value);
    }
    
  //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
    @Step("Enter the Keyword search")
    public void verifyDisplayNameOnSearchResults(String value) {
        currentPage().verifyDisplayNameOnSearchResults(value);
    }
    
}
