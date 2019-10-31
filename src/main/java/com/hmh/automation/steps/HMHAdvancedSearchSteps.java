package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHAdvancedSearchPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHAdvancedSearchSteps extends AbstractSteps<HMHAdvancedSearchPage> {

    private static final long serialVersionUID = 2288209712204716852L;

    public HMHAdvancedSearchSteps(final Pages pages) {
        super(pages, HMHAdvancedSearchPage.class);
    }

    @Step("Select a hmh keyword in Advanced search")
    public void selectHMHKewordsInAdvancedSearch(String hmhKey) {
        currentPage().selectKeyword(hmhKey);
    }

    @Step("Select a grade in Advanced Search ")
    public void selectGradeInAdvancedSearch(String grade) {
        currentPage().selectGradeInAdvancedSearch(grade);
    }

    @Step("Select lifecycle in Advanced Search")
    public void selectLifeCycleInAdvancedSearch(String life) {
        currentPage().selectLifeCycleInAdvancedSearch(life);
    }

    @Step("Select Product type in Advanced search")
    public void selectProductTypeInAdvancedSearch(String type) {
        currentPage().selectProductTypeInAdvancedSearch(type);
    }

    @Step("Select year in Advanced Search")
    public void selectYearInAdvancedSearch(String year) {
        currentPage().selectYearInAdvacnedSearch(year);
    }

    @Step("Select all items in search results")
    public void selectAllItemsInSearchResults() {
        currentPage().selectAllItemsInSearchResults();
    }

    @Step("Select {0} action to perform it on selected results")
    public void performActionOnSelectedResults(String action) {
        currentPage().performActionOnSelectedResults(action);
    }
    @Step("Click on plus sign to expand metadata info")
    public void clickPlusToExpand() {
        currentPage().clickPlusToExpand();
    }
    @Step("Click on plus sign to expand metadata info")
    public void clickPlusToExpandK12() {
        currentPage().clickPlusToExpandK12();
    }
    
    @Step("Select Min ViewPort size in Advanced search")
    public void selectMinViewPortSizeAdvanceSearch(String minVeiwPortSizeSearch) {
        currentPage().selectMinViewPortSizeAdvanceSearch(minVeiwPortSizeSearch);
    }
    
    @Step("Select Prodcut category in Advanced search")
    public void selectProductCategoryAdvanceSearch(String productCategorySearch) {
        currentPage().selectProductCategoryAdvanceSearch(productCategorySearch);
    }
    
    @Step("Select a facet{0} to filter search results")
	public void selectFacet(String facet) {
	currentPage().selectFacet(facet);
	}
    
    @Step("Select HIP Object Fields in Advanced search")
    public void selectAdvanceSearchFieldDrop(String selAdvanceSearchSelFieldDrop) {
        currentPage().selectAdvanceSearchFieldDrop(selAdvanceSearchSelFieldDrop);
    }
    
    @Step("Select HIP Object Fields1 in Advanced search")
    public void selectAdvanceSearchFieldDrop1(String selAdvanceSearchSelFieldDrop1) {
        currentPage().selectAdvanceSearchFieldDrop1(selAdvanceSearchSelFieldDrop1);
    }
    
    @Step("Select HIP Object Operators in Advanced search")
	public void selectAdvanceSearchOperatorDrop(String selAdvanceSearchOperatorDrop) {
	currentPage().selectAdvanceSearchOperatorDrop(selAdvanceSearchOperatorDrop);
	}
    
    @Step("Select HIP Object Operators1 in Advanced search")
	public void selectAdvanceSearchOperatorDrop1(String selAdvanceSearchOperatorDrop1) {
	currentPage().selectAdvanceSearchOperatorDrop1(selAdvanceSearchOperatorDrop1);
	}
    
    @Step("Select HIP Object Condition in Advanced search")
	public void selectAdvanceSearchConditionDrop(String advanceSearchSelConditionDrop) {
	currentPage().selectAdvanceSearchConditionDrop(advanceSearchSelConditionDrop);
	}
    
    @Step("Select HIP Object Condition1 in Advanced search")
	public void selectAdvanceSearchConditionDrop1(String selAdvanceSearchConditionDrop1) {
	currentPage().selectAdvanceSearchConditionDrop1(selAdvanceSearchConditionDrop1);
	}
    
    @Step(" Click the Add New Row in HIP Object Advance Search")
    public void addNewRow(){
    	currentPage().addNewRow();
    }
    
    @Step(" Click the Delete New Row in HIP Object Advance Search")
    public void deleteNewRow(){
    	currentPage().deleteNewRow();
    }
        
    @Step(" Click the Search button in HIP Object Advance Search")
    public void btnSearchHIPObject(){
    	currentPage().btnSearchHIPObject();
    }
    
    @Step("Select Look for the Objects from Advanced Search")
    public void selectLookFor(String lookForOption){
    	currentPage().selectLookFor(lookForOption);
      }
    
    @Step(" Click the Search from Drop down in Asset Advanced text")
    public void SearchforAssetAdvancedText(){
    	currentPage().SearchforAssetAdvancedText();	
    }
    
    @Step("Select Asset Advanced Object Fields in Advanced search")
    public void selectAssetAdvanceSearchFieldDrop(String selAssetAdvanceSearchSelFieldDrop){
        currentPage().selectAssetAdvanceSearchFieldDrop(selAssetAdvanceSearchSelFieldDrop);        
    }

    
    @Step("Enter Asset Advanced Condition Input for Asset Advanced Search")
    public void enterassetAdvancedConditionInput(String input){
    	currentPage().enterassetAdvancedConditionInput(input);
    }
  
    @Step(" Click the Search button in Asset Advanced Search")
    public void btnSearchAssetAdvanced(){
    	currentPage().btnSearchAssetAdvanced();
    }
  //*****ALF -1627  - HIP Search: Persist Refined Search on Search Screen (Sprint 7.2.5)*****
    @Step(" Verify the fields on Asset Advanced Search for HIP site")
    public void verifyAssetAdvanceSearchFields(String AssetAdvanceSearchSelFieldDrop,String AssetAdvanceSearchSelFieldDrop1,String AssetAdvanceSearchSelConditionField){
    	currentPage().verifyAssetAdvanceSearchFields(AssetAdvanceSearchSelFieldDrop,AssetAdvanceSearchSelFieldDrop1,AssetAdvanceSearchSelConditionField);
    }
  //*****ALF -2007  - Asset Advanced Search: Persist Previous Search on Search Screen (Sprint 7.3.1)*****   
    @Step(" Verify the fields on Asset Advanced Search for K12 site")
    public void verifyAssetAdvanceSearch(String AssetAdvanceSearchSelFieldDrop,String AssetAdvanceSearchSelFieldDrop1,String AssetAdvanceSearchSelConditionField){
    	currentPage().verifyAssetAdvanceSearch(AssetAdvanceSearchSelFieldDrop,AssetAdvanceSearchSelFieldDrop1,AssetAdvanceSearchSelConditionField);
    }
  //*****ALF -2007  - Asset Advanced Search: Persist Previous Search on Search Screen (Sprint 7.3.1)*****   
    @Step(" Click the Search from Drop down in Asset Advanced")
    public void SearchforAssetAdvanced(){
    	currentPage().SearchforAssetAdvanced();	
    }

  // ** Fix provided for REG024 BVT script ** Sprint 7.3.4 ** 14th Sep **   
    @Step(" Click the Search from Drop down in Asset Advanced")
    public void clickSearchButton(){
    	currentPage().clickSearchButton();	
    }
  //** ALF -2007  - Asset Advanced Search: Persist Previous Search on Search Screen ** Sprint 7.3.4 ** 21th Sep **
    @Step("Enter Asset Advanced Condition Input for Asset Advanced Search")
    public void enterAssetAdvancedConditionInput(String input){
    	currentPage().enterAssetAdvancedConditionInput(input);
    }
    
  //** ALF -1627  - HIP Search: Persist Refined Search on Search Screen ** Sprint 7.3.4 ** 21th Sep **
    @Step("Enter Asset Advanced Condition Input for Asset Advanced Search")
    public void backToHipSiteButton(){
    	currentPage().backToHipSiteButton();
    }
    
  //** ALF -2262  - Advanced Search: Search by Habitat short name ** Sprint 7.3.4  ** 4th Oct **
    @Step("Before Habitat Push in Advanced search")
    public void beforeHabitatPushAdvanceSearch(String ShortName) {
        currentPage().beforeHabitatPushAdvanceSearch(ShortName);
    }
    
  //** ALF -2262  - Advanced Search: Search by Habitat short name ** Sprint 7.3.4 ** 4th Oct **
    @Step("After Habitat Push in Advanced search")
    public void afterHabitatPushAdvanceSearch(String HabitatShortName) {
        currentPage().afterHabitatPushAdvanceSearch(HabitatShortName);
    }
}
