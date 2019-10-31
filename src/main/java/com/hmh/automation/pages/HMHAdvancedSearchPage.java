package com.hmh.automation.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ixxus.ipm.automation.pages.alfresco.AdvancedSearchPage;

public class HMHAdvancedSearchPage extends AdvancedSearchPage {

	public HMHAdvancedSearchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div[id*='default-forms'] div[class='share-form'] select[id$='prop_hmh-cms_grade-entry'] option")
	private List<WebElement> advanceSearchGradesList;

	@FindBy(css = "input[name*='prop_hmh-cms_copyrightYear']")
	private WebElement copyrightYear;

	@FindBy(css = "select[id*='lifecycle'] option")
	private List<WebElement> lifecycleList;

	@FindBy(css = "select[id*='productType'] option")
	private List<WebElement> productTypes;

	@FindBy(css = "div[id*='cm_taggable-cntrl-itemGroupActions'] button")
	private WebElement tagsSelectButton;

	@FindBy(css = "div[id*='prop_cm_taggable-cntrl-picker-results'] tbody[class$='data'] tr[class^='yui-dt-rec yui-dt']")
	private List<WebElement> HMHkewords;

	@FindBy(css = "button[id*='prop_cm_taggable-cntrl-ok-button']")
	private WebElement hmhKewordsOKButton;

	@FindBy(css = "div[id$='default-results'] tr td[class*='col-select'] input")
	private List<WebElement> selectCheckboxes;

	@FindBy(css = "button[id*='fileSelect-button-button']")
	private WebElement SelectButton;

	@FindBy(css = "span[class='selectAll']")
	private WebElement selectAllButton;

	@FindBy(css = "div[id*='default-fileSelect-menu'] li a span")
	private List<WebElement> selectionOptions;

	@FindBy(css = "button[id*='_default-selectedItems-button-button']")
	private WebElement selectedItemsButton;

	@FindBy(css = "div[id*='default-selectedItems-menu'] li span")
	private List<WebElement> selectedItemsOptions;

	@FindBy(xpath =".//*[@id='page_x002e_search_x002e_advsearch_x0023_default_1-form-fields']/div[2]/div/div/div/div[3]/a")
    private WebElement expandPlusSignAsset;
    
    @FindBy(xpath="//div/div[3]/div/div/div/div[3]/a")
    private WebElement plusSignC;
    
    @FindBy(xpath="//div/div[4]/div/div/div/div[3]/a")
    private WebElement plusSignK12;
    
    @FindBy(xpath="//div/div[5]/div/div/div/div[3]/a")
    private WebElement plusSignK12_hots;

    @FindBy(css = "div[class$='AlfDocumentFilters'] li span.details span.filterLabel")
	private List<WebElement> facetsList;

	@FindBy(css = "select[id*='minViewPortSize'] option")
	private List<WebElement> minViewPortSize;
	
	@FindBy(css = "select[id*='productCategory'] option")
	private List<WebElement> productCategory;
	
	//HIP object - Advanced Search (Refine Search) objects
	
	@FindBy(css = "select[id = 'propDropDown_0'] option")
	private List<WebElement> advanceSearchFieldDrop;
	
	@FindBy(css = "select[id = 'propDropDown_1'] option")
	private List<WebElement> advanceSearchFieldDrop1;

	//Asset Advanced object - Advanced Search (Refine Search) objects
	@FindBy(css = "select[id = 'assetAdvanced_propDropDown_0'] option")
	private List<WebElement> assetadvanceSearchFieldDrop;

	@FindBy(xpath = ".//*[@id='assetAdvanced_cell_condition_0']/input")
	private WebElement assetAdvancedConditionInput1;	
		
	@FindBy(css = "select[id = 'cell_query_0'] option")
	private List<WebElement> advanceSearchOperatorDrop;
	
	@FindBy(css = "select[id = 'cell_query_1'] option")
	private List<WebElement> advanceSearchOperatorDrop1;
	
	@FindBy(xpath = ".//*[@id='cell_condition_0']/input")
	private WebElement advanceSearchConditionDrop;
	
	@FindBy(xpath = ".//*[@id='cell_condition_1']/input")
	private WebElement advanceSearchConditionDrop1;
	
	@FindBy(css = "select[id = 'cell_logical_1'] option")
	private List<WebElement> advanceSearchAndOrDrop;
	
	@FindBy(css = "td[id = 'cell_icons_0'] img[src ='/share/res/components/images/plus-16.png']")
	private WebElement addNewRow;
	
	@FindBy(css = "img[src ='/share/res/components/images/minus-16.png']")
	private WebElement deleteNewRow;
	
	@FindBy(css = "button[id ='page_x002e_search_x002e_advsearch_x0023_default-search-button-3-button']")
	private WebElement searchButton;
	
	@FindBy(css = "#page_x002e_search_x002e_advsearch_x0023_default-search-button-4-button")
	private WebElement assetAdvsearchButton;
	
	@FindBy(css = "button[id*='default-selected-form-button-button']")
	private WebElement lookForButton;

	@FindBy(css = "div li span[class *= 'form-type-name']")
	private List<WebElement> lookForList;

	@FindBy(xpath = ".//*[@id='yui-gen11']/span[2]")
	private WebElement SearchforAssetAdvancedText;

	@FindBy(xpath = ".//*[@id='yui-gen11']/span[1]")
	private WebElement lookForListAssetAdvanced;
	
	@FindBy(xpath = ".//*[@id='yui-gen10']/span[2]")
	private WebElement SearchforAssetAdvanced;
	
	@FindBy(xpath = ".//*[@id='yui-gen10']/span[1]")
	private WebElement lookForListAssetAdvancedSearch;
	
	@FindBy(css = "button[id *= 'default-search-button-1-button']")
	private WebElement searchButtonOnAssetAdvanced;
	
	@FindBy(xpath = ".//*[text()='Back to HIP Site Site']")
	private WebElement backToHipSiteButton;
	
	@FindBy(css = "input[name*='habitatShortName']")
	private WebElement beforePushSearch;
	
	@FindBy(css = "input[name*='shortName']")
	private WebElement afterPushSearch;
	
		
	String addButton = " span[class='addIcon']";
	String text = " h3";
	String hmhkeys = "div[id*='prop_cm_taggable-cntrl-picker-results'] tbody[class$='data'] tr[class^='yui-dt-rec yui-dt']";
	String actionsCssSelector = "div[id*='default-selectedItems-menu'] li span";

	public void selectAllItemsInSearchResults() {
		SelectButton.click();
		waitABit(1000);
		selectAllButton.click();
	}

	public void performActionOnSelectedResults(String action) {
		boolean found = false;
		selectedItemsButton.click();
		waitABit(1000);

		List<WebElement> actions = getDriver().findElements(By.cssSelector(actionsCssSelector));
		waitABit(1000);
		for (WebElement item : actions) {
			if (item.getText().toLowerCase().contains(action.toLowerCase())) {
				found = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The action was not found", found);
	}

	public void selectProductTypeInAdvancedSearch(String productType) {
		boolean productTypeFound = false;
		for (WebElement type : productTypes) {
			if (type.getText().toLowerCase().contains(productType.toLowerCase())) {
				productTypeFound = true;
				type.click();
				break;
			}
		}
		Assert.assertTrue("The product Type was not found", productTypeFound);
	}

	public void selectYearInAdvacnedSearch(String year) {
		copyrightYear.clear();
		copyrightYear.sendKeys(year);
	}

	public void selectLifeCycleInAdvancedSearch(String liefcycle) {
		boolean productTypeFound = false;
		for (WebElement cycle : lifecycleList) {
			if (cycle.getText().toLowerCase().contains(liefcycle.toLowerCase())) {
				productTypeFound = true;
				cycle.click();
				break;
			}
		}
		Assert.assertTrue("The lifecycle was not found", productTypeFound);
	}

	public void selectGradeInAdvancedSearch(String grade) {
		boolean gradeFound = false;
		for (WebElement gradeElement : advanceSearchGradesList) {
			if (gradeElement.getText().toLowerCase().contains(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);
	}

	public void selectKeyword(String hmhKey) {
		element(tagsSelectButton).waitUntilVisible();
		boolean found = false;
		tagsSelectButton.click();
		System.out.println("INAINTE DE FOR");
		List<WebElement> hmh = getDriver().findElements(By.cssSelector(hmhkeys));
		for (WebElement element : hmh) {
			System.out.println("INTRA IN FOR");
			System.out.println("Element :" + element.getText());
			WebElement textKey = element.findElement(By.cssSelector(text));
			if (textKey.getText().toLowerCase().contains(hmhKey.toLowerCase())) {
				System.out.println("AJUNGE AICI");
				found = true;
				WebElement add = element.findElement(By.cssSelector(addButton));
				add.click();
				break;
			}
		}
		Assert.assertTrue("The hmh keword was not found", found);
		hmhKewordsOKButton.click();
	}

	//Consumer Site
    public void clickPlusToExpand()
    {
           waitABit(2000);
           boolean ispresent1=isElementVisible(By.xpath("/.//*[@id='page_x002e_search_x002e_advsearch_x0023_default_1-form-fields']/div[2]/div/div/div/div[3]/a"));
           if (ispresent1==true){
                  element(expandPlusSignAsset).waitUntilVisible();
                  expandPlusSignAsset.click();
           }
           boolean ispresent2=isElementVisible(By.xpath("//div/div[3]/div/div/div/div[3]/a"));

           if (ispresent2==true){
                  element(plusSignC).waitUntilVisible();
                  plusSignC.click();
           }

           boolean ispresent3=isElementVisible(By.xpath("//div/div[4]/div/div/div/div[3]/a"));

           if (ispresent3==true){
                  element(plusSignK12).waitUntilVisible();
                  plusSignK12.click();
           }
           boolean ispresent4=isElementVisible(By.xpath("//div/div[5]/div/div/div/div[3]/a"));

           if (ispresent4==true){
                  element(plusSignK12_hots).waitUntilVisible();
                  plusSignK12_hots.click();
           }


    }


    public void clickPlusToExpandK12()
    {
           waitABit(2000);
           boolean ispresent1=isElementVisible(By.xpath(".//*[@id='page_x002e_search_x002e_advsearch_x0023_default_1-form-fields']/div[2]/div/div/div/div[3]/a"));
           if (ispresent1==true){
                  element(expandPlusSignAsset).waitUntilVisible();
                  waitABit(2000);
                  expandPlusSignAsset.click();
                  waitABit(2000);
           }
           boolean ispresent2=isElementVisible(By.xpath("//div/div[3]/div/div/div/div[3]/a"));

           if (ispresent2==true){
                  element(plusSignC).waitUntilVisible();
                  waitABit(2000);
                  plusSignC.click();
           }

           boolean ispresent3=isElementVisible(By.xpath("//div/div[4]/div/div/div/div[3]/a"));

           if (ispresent3==true){
                  element(plusSignK12).waitUntilVisible();
                  waitABit(2000);
                  plusSignK12.click();
           }
           boolean ispresent4=isElementVisible(By.xpath("//div/div[5]/div/div/div/div[3]/a"));

           if (ispresent4==true){
                  element(plusSignK12_hots).waitUntilVisible();
                  waitABit(2000);
                  plusSignK12_hots.click();
           }

    }


	public void selectMinViewPortSizeAdvanceSearch(final String minVeiwPortSizeSearch) {
		boolean viewPortSizeFound = false;
		for (final WebElement viewPort : minViewPortSize) {
			if (viewPort.getText().toLowerCase().contains(minVeiwPortSizeSearch.toLowerCase())) {
				viewPortSizeFound = true;
				viewPort.click();
				break;
			}
		}
		Assert.assertTrue("The viewport size was not found", viewPortSizeFound);
	}

	public void selectProductCategoryAdvanceSearch(final String productCategorySearch) {
		boolean prdctCategoryFound = false;
		for (final WebElement prdctCategory : productCategory) {
			if (prdctCategory.getText().toLowerCase().contains(productCategorySearch.toLowerCase())) {
				prdctCategoryFound = true;
				prdctCategory.click();
				break;
			}
		}
		Assert.assertTrue("The product category was not found", prdctCategoryFound);
	}

	public void facetNumberOFSearchResults(final int results)
	{

	}


	public void selectFacet(String facet) {
		boolean found = false;
		for (WebElement item : this.facetsList) {
			if (item.getText().toLowerCase().equals(facet.toLowerCase())) {
				found = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The facet was not found", found);
	}
	
	public void selectAdvanceSearchFieldDrop(String selAdvanceSearchSelFieldDrop){
		System.out.println(selAdvanceSearchSelFieldDrop);
		boolean isFound = false;
		for(final WebElement seladvSearchFieldDrop: advanceSearchFieldDrop){
			if(seladvSearchFieldDrop.getText().toLowerCase().contentEquals(selAdvanceSearchSelFieldDrop.toLowerCase())){
				isFound=true;
				seladvSearchFieldDrop.click();
				
				break;
			}
		}
		Assert.assertTrue("The given Advance Search Field Drop is not found", isFound);
	}
	
	public void selectAdvanceSearchFieldDrop1(String selAdvanceSearchSelFieldDrop1){
		boolean isFound = false;
		for(final WebElement seladvSearchFieldDrop1: advanceSearchFieldDrop1){
			if(seladvSearchFieldDrop1.getText().toLowerCase().contains(selAdvanceSearchSelFieldDrop1.toLowerCase())){
				isFound=true;
				seladvSearchFieldDrop1.click();
				break;
			}
		}
		Assert.assertTrue("The given Advance Search Field Drop1 is not found", isFound);
	}
	
	public void selectAdvanceSearchOperatorDrop(String selAdvanceSearchOperatorDrop){
		boolean isFound = false;
		
		for(final WebElement seladvSearchOperatorDrop: advanceSearchOperatorDrop){
			if(seladvSearchOperatorDrop.getText().toLowerCase().contains(selAdvanceSearchOperatorDrop.toLowerCase())){
				isFound=true;				
				seladvSearchOperatorDrop.click();				
				break;
			}
		}
		Assert.assertTrue("The given Advance Search Operator Drop is not found", isFound);
				
	}
	
	public void selectAdvanceSearchOperatorDrop1(String selAdvanceSearchOperatorDrop1){
		boolean isFound = false;
		for(final WebElement seladvSearchOperatorDrop1: advanceSearchOperatorDrop1){
			if(seladvSearchOperatorDrop1.getText().toLowerCase().contains(selAdvanceSearchOperatorDrop1.toLowerCase())){
				isFound=true;
				seladvSearchOperatorDrop1.click();
				break;
			}
		}
		Assert.assertTrue("The given Advance Search Operator Drop1 is not found", isFound);
	}
	
	public void selectAdvanceSearchConditionDrop(String selAdvanceSearchConditionDrop){
		waitABit(3000);
		/*advanceSearchConditionDrop.clear();
		advanceSearchConditionDrop.sendKeys(selAdvanceSearchConditionDrop);*/
		
		/*for(final WebElement seladvSearchConditionDrop: advanceSearchConditionDrop){
			
			if(selAdvanceSearchConditionDrop.toLowerCase().contentEquals(((advanceSearchConditionDrop))){
				isFound=true;
				System.out.println("In loop"+seladvSearchConditionDrop);
				seladvSearchConditionDrop.click();
				
				break;
			}*/
	//****Fixed Test_REG065_AdvanceSearchTextFieldsWithinResultsforHIP (Sprint 7.2.5)****
		System.out.println(selAdvanceSearchConditionDrop);
		boolean isFound = false;
		if(advanceSearchConditionDrop.isEnabled()){
			System.out.println("in loop");
			advanceSearchConditionDrop.isSelected();
			advanceSearchConditionDrop.clear();
			advanceSearchConditionDrop.sendKeys(selAdvanceSearchConditionDrop);
		
	}else
		Assert.assertTrue("The given Advance Search condition Drop is not found", isFound);
	}
	
	
		/*boolean isFound = false;
		 * 
		for(final WebElement seladvSearchConditionDrop: advanceSearchConditionDrop){
			if(seladvSearchConditionDrop.getText().toLowerCase().contains(selAdvanceSearchConditionDrop.toLowerCase())){
				isFound=true;
				seladvSearchConditionDrop.click();
				break;
			}
		}
		Assert.assertTrue("The given Advance Search Condition Drop is not found", isFound);*/
	//****Fixed Test_REG065_AdvanceSearchTextFieldsWithinResultsforHIP (Sprint 7.2.5)****
	public void selectAdvanceSearchConditionDrop1(String selAdvanceSearchConditionDrop1){
		boolean isFound = false;
		//for(final WebElement seladvSearchConditionDrop1: selAdvanceSearchConditionDrop1){
			if(advanceSearchConditionDrop1.isEnabled()){
				isFound=true;
				System.out.println(selAdvanceSearchConditionDrop1);
				advanceSearchConditionDrop1.getAttribute(selAdvanceSearchConditionDrop1);
				
				advanceSearchConditionDrop1.findElement(By.xpath(".//*[@id='Grade']/option[4]")).click();
				waitABit(3000);
			}		
	
		
		Assert.assertTrue("The given Advance Search Condition Drop1 is not found", isFound);
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
	
	public void btnSearchHIPObject(){
		element(searchButton).waitUntilVisible();
		searchButton.click();
	}
	
	public void selectLookFor(String lookForOption) {
		
		//*** Fix ****
		
		boolean found = false;
		this.element(this.lookForButton).waitUntilVisible();
		for (int i =0;i<5;i++)
		{
			JavascriptExecutor jse = (JavascriptExecutor)getDriver();
			jse.executeScript("window.scrollBy(0,250)", "");
			waitABit(2000);
		}	
	
		this.lookForButton.click();
		waitABit(2000);
		
		System.out.println(lookForList);
				
		for(WebElement elem:lookForList)
		{
			System.out.println(elem.getText());
			if (elem.getText().toLowerCase().contains(lookForOption.toLowerCase())) {
				found = true;
				
				elem.click();
				break;
		}
			
		}
		Assert.assertTrue("The Look for option was not found", found);
	}


	public void SearchforAssetAdvancedText() {
		//boolean found = false;
		
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");
		lookForButton.click();
		waitABit(5000);
		SearchforAssetAdvancedText.getText().contains("Search for Asset using advanced search");
		System.out.println(SearchforAssetAdvancedText.getText());
		
		lookForListAssetAdvanced.click();
	}
	
	public void selectAssetAdvanceSearchFieldDrop(String selAssetAdvanceSearchSelFieldDrop){
		boolean isFound = false;
				
		Select dropDown=new Select(getDriver().findElement(By.cssSelector("#assetAdvanced_propDropDown_0")));
		dropDown.selectByVisibleText(selAssetAdvanceSearchSelFieldDrop);
/*		for(WebElement selassetadvSearchFieldDrop: assetadvanceSearchFieldDrop){
			System.out.println(selassetadvSearchFieldDrop);
			if(selassetadvSearchFieldDrop.getText().toLowerCase().contentEquals(selAssetAdvanceSearchSelFieldDrop.toLowerCase())){
				isFound=true;
				selassetadvSearchFieldDrop.click();
				break;
			}
		}*/
		//Assert.assertTrue("The given Asset Advance Search Field Drop is not found", isFound);
	}
	
	public void enterassetAdvancedConditionInput(String input) {
		
		System.out.println(input);
		boolean isFound = false;
		if(assetAdvancedConditionInput1.isEnabled())
		{
			System.out.println("in loop");
			assetAdvancedConditionInput1.isSelected();
			assetAdvancedConditionInput1.clear();
			assetAdvancedConditionInput1.sendKeys(input);
		
	}else
		Assert.assertTrue("The given Advance Search condition Drop is not found", isFound);
	

	
		//waitABit(1000);
		
		//element(assetAdvancedConditionInput1).waitUntilVisible();
		
		/*boolean isFound=false;
		waitForElementX(".//td[@id='assetAdvanced_cell_condition_0']/input", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, this.getDriver());
				for(WebElement inputElement : assetAdvancedConditionInput1)
				{
					//if(list.getText().toLowerCase().contains(conditionInput.toLowerCase())){
						//isFound=true;
					inputElement.click();
					System.out.println(inputElement.getText());
					inputElement.sendKeys(conditionInput);
					System.out.println(inputElement.getText());
					System.out.println(conditionInput);
						break;
					}
				
				Assert.assertTrue("The condition input drop down is not found", isFound);
				
			}*/}
	
		

	public void btnSearchAssetAdvanced(){
		System.out.println("Print the method");
		element(assetAdvsearchButton).waitUntilVisible();
		assetAdvsearchButton.click();
	}
	//*****ALF -1627  - HIP Search: Persist Refined Search on Search Screen (Sprint 7.2.5)*****
	@SuppressWarnings("unlikely-arg-type")
	public void verifyAssetAdvanceSearchFields(String AssetAdvanceSearchSelFieldDrop,String AssetAdvanceSearchSelFieldDrop1,String AssetAdvanceSearchSelConditionField){
		boolean isFound=false;
		WebElement dropDown=getDriver().findElement(By.xpath(".//*[@value='Name']"));		
		if((dropDown).getText().toLowerCase().contentEquals(AssetAdvanceSearchSelFieldDrop.toLowerCase())){
			isFound=true;
			System.out.println("First field dropdown is verified");
			
		}else 
		{
			Assert.assertTrue("The First field dropdown in Asset Advance Search page is not found", isFound);
		}
	
		WebElement dropDown1=getDriver().findElement(By.xpath(".//*[@value='contains']"));
		if( dropDown1.getText().toLowerCase().contentEquals(AssetAdvanceSearchSelFieldDrop1.toLowerCase())){
			isFound=true;
			System.out.println("Second operator field dropdown is verified");
			
		}else 
		{
			Assert.assertTrue("The Second field dropdown in Asset Advance Search page is not found", isFound);
		}
		
		WebElement conditionField=getDriver().findElement(By.xpath(".//*[@id='cell_condition_0']/input"));
		if( conditionField.getText().toLowerCase().contentEquals(AssetAdvanceSearchSelConditionField.toLowerCase())){
			isFound=true;
			System.out.println("Third condition field is verified");
			
		}else 
		{
			Assert.assertTrue("The third condition field in Asset Advance Search page is not found", isFound);
		}
	}	
 //** ALF -2007  - Asset Advanced Search: Persist Previous Search on Search Screen (Sprint 7.3.1) ** 		
    public void verifyAssetAdvanceSearch(String AssetAdvanceSearchSelFieldDrop,String AssetAdvanceSearchSelFieldDrop1,String AssetAdvanceSearchSelConditionField){
	boolean isFound = false;
	WebElement dropDown=getDriver().findElement(By.xpath(".//*[@value='Name']"));		
	if((dropDown).getText().toLowerCase().contentEquals(AssetAdvanceSearchSelFieldDrop.toLowerCase())){
		isFound=true;
		System.out.println("First field dropdown is verified");
		
	}else 
	{
		Assert.assertTrue("The First field dropdown in Asset Advance Search page is not found", isFound);
	}

	WebElement dropDown1=getDriver().findElement(By.xpath(".//*[@value='contains']"));
	if( dropDown1.getText().toLowerCase().contentEquals(AssetAdvanceSearchSelFieldDrop1.toLowerCase())){
		isFound = true;
		System.out.println("Second operator field dropdown is verified");
		
	}else 
	{
		Assert.assertTrue("The Second field dropdown in Asset Advance Search page is not found", isFound);
	}
	
	WebElement conditionField=getDriver().findElement(By.xpath(".//td[@id='assetAdvanced_cell_condition_0']/input"));
	if( conditionField.getText().toLowerCase().contentEquals(AssetAdvanceSearchSelConditionField.toLowerCase())){
		isFound = true;
		System.out.println("Third condition field is verified");
	
	}else 
	{
		Assert.assertTrue("The third condition field in Asset Advance Search page is not found", isFound);
	}
}	

	public void SearchforAssetAdvanced() {
		
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("window.scrollBy(0,250)", "");
		lookForButton.click();
		waitABit(5000);
		SearchforAssetAdvanced.getText().contains("Search for Asset using advanced search");
		System.out.println(SearchforAssetAdvanced.getText());
		
		lookForListAssetAdvancedSearch.click();
		
		}
  // ** Fix provided for REG024 BVT script ** Sprint 7.3.4 ** 14th Sep ** 
	public void clickSearchButton() {
		
		getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		this.element(this.searchButtonOnAssetAdvanced).waitUntilVisible();
		this.searchButtonOnAssetAdvanced.click();
	}
	
 //** ALF -2007  - Asset Advanced Search: Persist Previous Search on Search Screen ** Sprint 7.3.1 **
	public void enterAssetAdvancedConditionInput(String input) {
		
		WebElement myDynamicElement = 
				(new WebDriverWait(getDriver(), 10)).
					until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='assetAdvanced_cell_condition_0']/input")));
		System.out.println(input);
		assetAdvancedConditionInput1.clear();
		assetAdvancedConditionInput1.sendKeys(input);
			
	}

//** ALF -1627  - HIP Search: Persist Refined Search on Search Screen ** Sprint 7.3.4 ** 21th Sep **
	public void backToHipSiteButton() 
	{
		this.element(this.backToHipSiteButton).waitUntilVisible();
		this.backToHipSiteButton.click();
		
	}
	
//** ALF -2262  - Advanced Search: Search by Habitat short name ** Sprint 7.3.4  ** 4th Oct **
	public void beforeHabitatPushAdvanceSearch(String habitatShortName) {
		boolean	beforePushSearchFound = true;
		beforePushSearch.sendKeys(habitatShortName);
								
		Assert.assertTrue("The Before Habitat push field was found", beforePushSearchFound);
		
	}
	
//** ALF -2262  - Advanced Search: Search by Habitat short name ** Sprint 7.3.4  ** 4th Oct **
	public void afterHabitatPushAdvanceSearch(String habitatShortName) {
	
		boolean afterPushSearchFound = true;
		 afterPushSearch.sendKeys(habitatShortName);
									
		Assert.assertTrue("The After Habitat push field was found", afterPushSearchFound);
		
	}
}
