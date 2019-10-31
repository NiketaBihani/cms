package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.pages.alfresco.SearchResultsPage;

public class HMHSearchResultsPage extends AbstractPage {

	public HMHSearchResultsPage(WebDriver driver) {
		super(driver);
	}
	private static final Logger LOG = LoggerFactory
			.getLogger(SearchResultsPage.class);

	@FindBy(css = "img[src*='generic-learning-bundle']")
	private WebElement learningBundleThumbnail;

	@FindBy(css = "img[src*='generic-program']")
	private WebElement programThumbnail;

	@FindBy(css = "img[src*='generic-product-set']")
	private WebElement productSetThumbnail;

	@FindBy(css = "img[src*='content']")
	private WebElement contentThumbnail;

	@FindBy(css = "img[src*='generic-sequence-bundle']")
	private WebElement sequenceBundleTumbnail;


	@FindBy(css = "#FCTSRCH_RESULTS_COUNT_LABEL")
	private WebElement numberOfResults;

	@FindBy(css = "footer")
	private WebElement footer;

	@FindBy(css = "#FCTSRCH_SEARCH_RESULTS_LIST table")
	private WebElement searchResultsTable;

	@FindBy(css = ".nameAndTitleCell span span a span[class*='value']")
	private List<WebElement> allResultsTitle;
	
	@FindBy (css="div[class*='InputField']>input[class*='InputInner']")
	WebElement inputSearchterminResultsPage;
	
	@FindBy(css="span[role$='button']")
	WebElement searchButton;
	
	// HIP object - Quick Search (Refine Search) objects
	
		@FindBy(name = "refineSearch")
		private WebElement refineSearchCheck;
		
		@FindBy(css = "select[id = 'propDropDown_0'] option")
		private List<WebElement> refineSearchFieldDrop;
		
		@FindBy(css = "select[id = 'propDropDown_1'] option")
		private List<WebElement> refineSearchFieldDrop1;
		
		@FindBy(css = "select[id = 'cell_query_0'] option")
		private List<WebElement> refineSearchOperatorDrop;
		
		//@FindBy(css = "select[id* = 'Genre'] option")
		//private List<WebElement> refineSearchGenreConditionDrop;
		
		@FindBy(css = "select[id = 'Genre (K-12)'] option")
		private List<WebElement> refineSearchGenreConditionDrop;
		
		@FindBy(css = "select[id = 'undefined'] option")
		private List<WebElement> refineSearchNewRowConditionDrop;
		
		@FindBy(css = "span[id ='uniqName_1_9_label']")
		private WebElement refineSearchButton;
		
		@FindBy(css = "img[src ='/share/res/components/images/plus-16.png']")
		private WebElement addNewRow;
		
		@FindBy(css = "img[src ='/share/res/components/images/minus-16.png']")
		private WebElement deleteNewRow;
		
		@FindBy(css = "select[id = 'cell_logical_1'] option")
		private List<WebElement> refineSearchAndOrConditionDrop;
		
		@FindBy(css = "td[id = 'FCTSRCH_SET_ALL_SITES_SCOPE_text']")
		private WebElement searchResultsAllSites;
		
		@FindBy(css = "td[id = 'FCTSRCH_SET_REPO_SCOPE_text']")
		private WebElement searchResultsRepository;
		
		@FindBy(xpath = "//div[5]/div[3]/div/div[1]/div[2]/div/div/div/span[2]")
		private WebElement searchResultsDropdown;	
		
		@FindBy(xpath = ".//*[@id='BUTTON_GOBACK_label']")
		private WebElement backSearchResultsButton;
		
		@FindBy(xpath = ".//*[@id='RETURN_TO_SRCH_label']")
		private WebElement returnToSearchButton;
		
		@FindBy(xpath = ".//*[@id='SEARCH_RESULT']")
		private WebElement numbrOfResults;
		
		@FindBy(xpath = ".//*[@class='alfresco-documentlibrary-views-layouts-Cell']/span[1]")
		private WebElement checkSearch;
		
		@FindBy(xpath = "(.//*[@class='alfresco-renderers-Selector unchecked'])[1]")
		private WebElement checkSearchRes;
		
		@FindBy(xpath = ".//*[@id='onActionMoveTo_text']")
		private WebElement moveToAction;
		
		@FindBy(css = "#FCTSRCH_RESULTS_COUNT_LABEL")
		private WebElement noResultsInSearch;
							
		@FindBy(xpath = ".//*[@id='onActionEditCommon_text']")
		private WebElement editCommonProperties;
		
		@FindBy(xpath = ".//*[@id='onActionGeneratePDF_text']")
		private WebElement clickOnGeneratePDFActionOnSearchPage;
		
		@FindBy(xpath = ".//*[@id='hmh-cms_productType_CONTROL']/tbody/tr/td[2]/input")
		private WebElement selectProductType;
		
		@FindBy(xpath = ".//input[@name='chk_hmh-cms_productType']")
		private WebElement productTypeCheckbox;
		
		@FindBy(xpath = ".//*[@name='prop_cm_description']")
		private WebElement selectDescription;
		
		@FindBy(xpath = ".//*[@name='chk_cm_description']")
		private WebElement descriptionCheckbox;
		
		@FindBy(xpath = ".//*[text()='Update']")
		private WebElement updateButton;
				

	public void checkIfThumbnailIsDisplayed(String object) {
		switch (object) {
		case "Learning Bundle":
			Assert.assertTrue("The thumbnail for learning bundle is not displayed", learningBundleThumbnail.isDisplayed());
			break;

		case "Program":
			Assert.assertTrue("The thumbnail for program is not displayed", programThumbnail.isDisplayed());
			break;

		case "Product Set":
			Assert.assertTrue("The thumbnail for product set is not displayed", productSetThumbnail.isDisplayed());
			break;

		case "Sequence Bundle":
			Assert.assertTrue("The thumbnail for sequence bundle is not displayed", sequenceBundleTumbnail.isDisplayed());
			break;

		case "Content Object":
			Assert.assertTrue("The thumbnail for Learning Object is not displayed", contentThumbnail.isDisplayed());
			break;

		case "Asset":
			Assert.assertTrue("The thumbnail for Asset is not displayed", contentThumbnail.isDisplayed());
			break;

		case "Product Object":
			Assert.assertTrue("The thumbnail for Product Object is not displayed", contentThumbnail.isDisplayed());
			break;
		}
	}


	    public void checkIfDocumentIsPresentInResultsList(String itemName,
				int waitForSearchResultsSeconds, int manualScrollSeconds,
				boolean shouldBePresent) {
	    	waitForAngularRequestsToFinish();
	    	
			int results = 0;
			int counter = 0;
			boolean found = false;
			System.out.println("Waiting for search results list to load for max " + waitForSearchResultsSeconds + " seconds");
			while ((results == 0) && (counter < waitForSearchResultsSeconds)) {
				waitForPageToLoadCompletely(500);
				boolean listPresent = isElementVisible(By.cssSelector("span[id*='RESULTS_COUNT_LABEL']"));//FCTSRCH_RESULTS_COUNT_LABEL
			//	 for (final WebElement element : allResultsTitle) {
					if (listPresent == true) {
					
						String numberOfElements = this.numberOfResults.getText();
						System.out.println("numberOfElements present are: "+numberOfElements);
						numberOfElements.trim();
						String[] splited = numberOfElements.split(" - ");
						System.out.println("results found:"+splited[0]);
						results = Integer.parseInt(splited[0]);
						System.out.println(results);
					} 
				++counter;
				waitABit(500);
				refreshPage();
				waitForPageToLoadCompletely(500);
			}
			System.out.println("the number of results present are " +results);
			
			if ((results == 0) && (shouldBePresent)) {
				waitForAngularRequestsToFinish();
				Assert.assertTrue("There were no results found in 5 minutes",
						results > 0);
			} else {
				if (results >= 0)
				/*	
				LOG.info("Manual scroll for " + manualScrollSeconds + " seconds");
				Actions action = new Actions(getDriver());
				for (int i = 0; i < manualScrollSeconds; ++i) {
					action.moveToElement(this.footer).build().perform();
	
					waitABit(1000L);
				}*/
				LOG.info("Manual scroll done");
				waitABit(1000L);
				List<WebElement> items = this.searchResultsTable.findElements(By
						.cssSelector(".nameAndTitleCell > span > span > a"));
				for (WebElement resultItem : items) {
					if (resultItem.getText().toLowerCase()
							.contentEquals(itemName.toLowerCase())) {
						found = true;
						break;
					}
				}
				if (found) {
					LOG.info("Document  found in the search results!");
					Assert.assertTrue("Document  found in the search results!", found);
				} else {
					Assert.assertFalse("Document not found", found);
				}
			}
	
	  }

	public void checkIfDocumentIsPresentInResultsListX(String itemName, int waitForSearchResultsSeconds, int manualScrollSeconds, boolean shouldBePresent)
	{
		int results = 0;
		int counter = 0;
		boolean found = false;
		LOG.info("Waiting for search results list to load for max " + waitForSearchResultsSeconds + " seconds");
		while ((results == 0) && (counter < waitForSearchResultsSeconds))
		{
			try
			{
				boolean listPresent = isElementVisible(By.cssSelector("span[id*='RESULTS_COUNT_LABEL']"));//FCTSRCH_RESULTS_COUNT_LABEL
	
				if (listPresent == true) {
					String numberOfEleemnts = this.numberOfResults.getText();
					String[] splited = numberOfEleemnts.split("\\s+");
					results = Integer.parseInt(splited[0]);
				}
			}
			catch (Exception e) {}
			counter++;
			waitABit(1000L);
			refreshPage();
		}
		if ((results == 0) && (shouldBePresent))
		{
			Assert.assertTrue("There were no results found in 2 minutes", results > 0);
		}
		else if (results > 0)
		{
			LOG.info("Manual scroll for " + manualScrollSeconds + " seconds");
			Actions action = new Actions(getDriver());
			for (int i = 0; i < manualScrollSeconds; i++)
			{
				action.moveToElement(this.footer).build().perform();
				waitABit(1000L);
			}
			LOG.info("Manual scroll done");
			List<WebElement> items = this.searchResultsTable.findElements(By.cssSelector(".nameAndTitleCell > span > span > a"));
			for (WebElement resultItem : items) {
				if (resultItem.getText().toLowerCase().contentEquals(itemName.toLowerCase()))
				{
					found = true;
					break;
				}
			}
			if (shouldBePresent) {
				Assert.assertTrue("Document was not found in the search results!", found);
			} else {
				Assert.assertFalse("Document was found but should not have been found", found);
			}
		}
	}

	
	
	public void searchInResultsPage(String name){
		System.out.println(name);

		element(inputSearchterminResultsPage).waitUntilVisible();
		inputSearchterminResultsPage.clear();
		inputSearchterminResultsPage.sendKeys(name);
		searchButton.click();
		waitABit(500);
	}
	
	public void refineSearchCheck(){
		element(refineSearchCheck).waitUntilVisible();
		refineSearchCheck.click();
		waitABit(500);
	}
	
	/*
	public void enterCaptionConsitionRefineSearch(String captionRefineValue){	
		waitForElement("input[id*='prop_hmh-cms_caption']",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(captionInput).waitUntilVisible();
		captionInput.clear();
		captionInput.sendKeys(captionValue);		
	}	

*/
	public void selectrefineSearchFieldDrop(String refineFieldDrop){
		boolean isFound = false;
		for(final WebElement selectField: refineSearchFieldDrop){
			if(selectField.getText().toLowerCase().contains(refineFieldDrop.toLowerCase())){
				isFound=true;
				selectField.click();
				break;
			}
		}
		Assert.assertTrue("The given field is not found", isFound);
	}
	
	public void selectrefineSearchFieldDrop1(String refineFieldDrop1){
		boolean isFound = false;
		for(final WebElement selectField1: refineSearchFieldDrop1){
			if(selectField1.getText().toLowerCase().contains(refineFieldDrop1.toLowerCase())){
				isFound=true;
				selectField1.click();
				break;
			}
		}
		Assert.assertTrue("The given field1 is not found", isFound);
	}
	
	public void selectrefineSearchOperatorDrop(String refineOperatorDrop){
		boolean isFound = false;
		for(final WebElement selectOperator: refineSearchOperatorDrop){
			if(selectOperator.getText().toLowerCase().contains(refineOperatorDrop.toLowerCase())){
				isFound=true;
				selectOperator.click();
				break;
			}
		}
		Assert.assertTrue("The given Operator is not found", isFound);
	}
	
	public void selectrefineSearchGenreConditionDrop(String refineGenreConditionDrop){
		boolean isFound = false;
		for(final WebElement selectGenreCondition: refineSearchGenreConditionDrop){
			if(selectGenreCondition.getText().toLowerCase().contains(refineGenreConditionDrop.toLowerCase())){
				isFound=true;
				selectGenreCondition.click();
				break;
			}
		}
		Assert.assertTrue("The given Genre Condition is not found", isFound);
	}
	
	public void buttonrefineSearch(){
		element(refineSearchButton).waitUntilVisible();
		refineSearchButton.click();
		waitABit(500);
	}
	
	public void addNewRow(){
		element(addNewRow).waitUntilVisible();
		addNewRow.click();
		waitABit(500);
	}
	
	public void deleteNewRow(){
		element(deleteNewRow).waitUntilVisible();
		deleteNewRow.click();
		waitABit(500);
	}	
	
	public void selectrefineSearchAndOrConditionDrop(String refineSearchAndConditionDrop){
		boolean isFound = false;
		for(final WebElement selectAndOrCondition: refineSearchAndOrConditionDrop){
			if(selectAndOrCondition.getText().toLowerCase().contains(refineSearchAndConditionDrop.toLowerCase())){
				isFound=true;
				selectAndOrCondition.click();
				break;
			}
		}
		Assert.assertTrue("The given And/Or Drop is not found", isFound);
	}
	
	public void selectrefineSearchNewRowConditionDrop(String refineSearchRowConditionDrop){
		boolean isFound = false;
		for(final WebElement selectNewRowCondition: refineSearchNewRowConditionDrop){
			if(selectNewRowCondition.getText().toLowerCase().contains(refineSearchRowConditionDrop.toLowerCase())){
				isFound=true;
				selectNewRowCondition.click();
				break;
			}
		}
		Assert.assertTrue("The given New row Condition is not found", isFound);
	}
	
	public void searchResultsAllSites(){
		element(searchResultsAllSites).waitUntilVisible();
		searchResultsAllSites.click();
		waitABit(500);
	}
	
	public void searchResultsRepository(){
		element(searchResultsRepository).waitUntilVisible();
		searchResultsRepository.click();
		waitABit(500);
	}
	
	public void searchResultsDropdown(){
		element(searchResultsDropdown).waitUntilVisible();
		searchResultsDropdown.click();
		waitABit(500);
	}

	//*****ALF -1627  - HIP Search: Persist Refined Search on Search Screen (Sprint 7.2.5)*****
	public void backSearchResults() {
		element(backSearchResultsButton).waitUntilVisible();
		backSearchResultsButton.click();
		waitABit(500);
		
	}
	
	//****ALF-1581 Return to Search Results Screen from Standards Hierarchy (Sprint 7.3.1)*****
	public void returnToSearchButton() {
		element(returnToSearchButton).waitUntilVisible();
		returnToSearchButton.click();
		waitABit(500);
		
	}

	//****ALF-1581 Return to Search Results Screen from Standards Hierarchy (Sprint 7.3.1)*****
	public void verifyIfDocumentIsPresentInList(String itemName, int waitForSearchResultsSeconds) {
    	
		int results = 0;
		int counter = 0;
		boolean found = false;

		waitForPageToLoadCompletely(500);
		boolean listPresent = isElementVisible(By.xpath(".//*[@id='SEARCH_RESULT']"));// Search results on search standard page
		if (listPresent == true) {
			found=true;
			System.out.println("Document found in the search results!");
			Assert.assertTrue("Document found in the search results!", found);
		} else {
			Assert.assertFalse("Document not found", found);
		}
		while ((results == 0) && (counter < waitForSearchResultsSeconds)) {
		if (listPresent == true) {
				
				String numberOfElements = this.numbrOfResults.getText();
				System.out.println("numberOfElements present are: "+numberOfElements);
				numberOfElements.trim();
				String[] splited = numberOfElements.split(" - ");
				System.out.println("results found:"+splited[0]);
				results = Integer.parseInt(splited[0]);
				System.out.println(results);}
				} 
			++counter;
			waitABit(500);
			refreshPage();
			waitForPageToLoadCompletely(500);
		}

	 //** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
	public void SearchCheck() {
		
		waitForElementX(".//*[@id='FCTSRCH_SEARCH_RESULTS_LIST']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement searchResult = getDriver().findElement(By.xpath(".//*[@id='FCTSRCH_SEARCH_RESULTS_LIST']"));
		element(searchResult).waitUntilVisible();
		System.out.println(searchResult.isDisplayed());
		
		element(checkSearch).waitUntilVisible();
		checkSearch.click();
		System.out.println(checkSearch.isSelected());
		waitABit(500);
		
	}

	//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
	public void clickEditCommonPropertiesAction() {
		
		WebElement selectItem = getDriver().findElement(By.xpath(".//*[@id='DOCLIB_SELECTED_ITEMS_MENU']/span[2]"));
		selectItem.click();
		element(editCommonProperties).waitUntilVisible();
		editCommonProperties.click();
		
	}
	
	//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
	public void selectAndCheckEditCommonProperties(String productTypeName, String description) {
		
		waitABit(800);
		element(selectProductType).waitUntilVisible();
		selectProductType.click();
		selectProductType.sendKeys(productTypeName);		
		
		waitABit(1000);
		//waitForElementX(".//input[@name='chk_hmh-cms_productType']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(productTypeCheckbox).waitUntilClickable();
		productTypeCheckbox.click();
		System.out.println("PT checkbox checked"+productTypeCheckbox.isSelected());
			
		// Getting Webdriver exception so Adding Wait here ** Sprint 7.3.4 ** Fixed on 17th Sep 2018 
		waitABit(2000);
		element(selectDescription).waitUntilVisible();
		selectDescription.click();
		selectDescription.sendKeys(description);
				
		waitABit(1000);
		element(descriptionCheckbox).waitUntilClickable();
		descriptionCheckbox.click();
		System.out.println(descriptionCheckbox.isSelected());

		waitABit(500);
		element(updateButton).waitUntilVisible();
		updateButton.click();
		waitABit(500);
		
		
	}
	//** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **	
     public void checkSearchBox() {
		
		//waitForElementX(".//*[@id='FCTSRCH_SEARCH_RESULTS_LIST']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement searchResult = getDriver().findElement(By.xpath(".//*[@id='FCTSRCH_SEARCH_RESULTS_LIST']"));
		element(searchResult).waitUntilVisible();
		System.out.println(searchResult.isDisplayed());
		
		//element(checkSearchRes).waitUntilVisible();
		checkSearchRes.click();		
		waitABit(500);
		
		//element(checkSearchRes1).waitUntilVisible();
		checkSearchRes.click();
		//waitABit(500);
		
	}
     
   //** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **
     public void clickMoveToAction() {
 		
 		WebElement selectItem = getDriver().findElement(By.xpath(".//*[@id='DOCLIB_SELECTED_ITEMS_MENU']/span[2]"));
 		selectItem.click();
 		element(moveToAction).waitUntilVisible();
 		moveToAction.click();
	
     }

  //** ALF -2262  - Advanced Search: Search by Habitat short name ** Sprint 7.3.4 ** 4th Oct **
	public void noElementPresentinSearchResults(String itemName) {
		
		boolean NotFound = false;
        String noresultsinsearch = this.noResultsInSearch.getText();
		  noresultsinsearch.trim();
		  if(itemName.equalsIgnoreCase(noresultsinsearch)){
			  System.out.println("There are:"+noresultsinsearch+" in search");
			  Assert.assertTrue("There were no results found in search before/after habitat", true);  
		  }else{
			  Assert.assertFalse("This negative scenario on habitat shortname gives us the results, fails", NotFound);
		  }
	  }
	
    //** ALF-2333 **  Trade: Ability to generate a PDF without first creating a collection ** Sprint 7.3.5 ** 
    public void clickGeneratePDFActionOnSearchPage() {
		
    	WebElement selectItem = getDriver().findElement(By.xpath(".//*[@id='DOCLIB_SELECTED_ITEMS_MENU']/span[2]"));
		selectItem.click();
		element(clickOnGeneratePDFActionOnSearchPage).waitUntilVisible();
		clickOnGeneratePDFActionOnSearchPage.click();
		
	}

    //** ALF-2333 **  Trade: Ability to generate a PDF without first creating a collection ** Sprint 7.3.5 ** 
	public void clickCheckBoxOnAssets(String fileName,String fileName1) {
	
		//waitForElementX(".//a[contains(text(),'fileName')]//..//..//..//..//..//input",
		//		  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement checkBoxFileName = getDriver().findElement(By.xpath(".//a[contains(text(),'"+fileName+"')]//..//..//..//..//..//input"));
		checkBoxFileName.click();
		
		//waitForElementX(".//a[contains(text(),'fileName1')]//..//..//..//..//..//input",
		//		  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement checkBoxFileName1 = getDriver().findElement(By.xpath(".//a[contains(text(),'"+fileName1+"')]//..//..//..//..//..//input"));
		System.out.println("Check the boxes for both the images to generate PDF");
		checkBoxFileName1.click();
		
	}
    
    
    
	}
     
		
	

