package com.hmh.automation.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.pages.alfresco.SearchResultsPage;

public class HMHStandardsSearchPage extends AbstractPage {

    public HMHStandardsSearchPage(WebDriver driver) {
        super(driver);
    }
    
	private static final Logger LOG = LoggerFactory
			.getLogger(SearchResultsPage.class);

    @FindBy(id="HEADER_SEARCH_STANDARDS_LINK_text")
    WebElement standards;
    
    @FindBy(id="HEADER_SEARCH_STANDARDS_text")
    WebElement importStandards;
    
    @FindBy(id="HEADER_IMPORT_STANDARDS_text")
    WebElement searchStandards;
    
    @FindBy(css = "div>h1[id *= 'HEADER_TITLE']>a")
    private WebElement searchStdTitle;

    @FindBy(css = "div>img[src*='HMH']")
    private WebElement hmhLogo;
    
    @FindBy(xpath = ".//*[text()='Remove']")
    private WebElement remCorBtn;
    

    @FindBy(css = "div>span") //pending as of 04/19 its not working
    private List<WebElement> selectStandardCollection;
    
       
    @FindBy(id="dijit_MenuItem_0_text")
    private WebElement draftCollections; 
   
    @FindBy(xpath="//*[text()='Approved Collection']")
    private WebElement approvedCollections; 
    
    @FindBy(xpath="//div[@id='STANDARDS_MAIN_COLLECTION_HORIZONTAL']/div/div/span[contains(text(),'Please Select Standard Collection')]/parent::div/following-sibling::div//input[@class='dijitReset dijitInputField dijitArrowButtonInner']")
    private WebElement clickOnDraftCollection; 
    
    @FindBy(xpath = "//tr/td/div/span[contains(text(),'AB Standards Collection')]")
  	private WebElement abStandardsCollection;    
    
    //@FindBy(css = "div>span") //pending as of 04/19 its not working
    //private List<WebElement> selectCountry;
    
  //Country
    @FindBy(css = "table[id$='LEVEL_1_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input")
    private WebElement selectCountryArrow;
    
    @FindBy(css = "table[id$='LEVEL_1_CONTROL_menu'] tbody tr:nth-child(1) td:nth-child(2)")
    private List<WebElement> selectCountrylist;
        
    @FindBy(css="table[id$='LEVEL_1_CONTROL_menu'] tbody tr:nth-child(1) td:nth-child(2)")
	private WebElement selectCountrylistUS;
    
    //Authority (State, District...)    
    @FindBy(css = "table[id$='LEVEL_2_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input")
    private WebElement selectAuthorityArrow;
    
    @FindBy(css = "table[id$='LEVEL_2_CONTROL_menu'] tbody tr:nth-child(3) td:nth-child(2)")
    private List<WebElement> selectAuthoritylist;
        
    @FindBy(css="table[id$='LEVEL_2_CONTROL_menu'] tbody tr:nth-child(3) td:nth-child(2)")
	private WebElement selectAuthoritylistAlaska;
    

  //Document title
      @FindBy(css = "table[id$='LEVEL_3_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input")
      private WebElement selectDocumentArrow;
      
      @FindBy(css = "table[id$='LEVEL_3_CONTROL_menu'] tbody tr:nth-child(3) td:nth-child(2)")
      private List<WebElement> selectDocumentlist;
          
      @FindBy(css="table[id$='LEVEL_3_CONTROL_menu'] tbody tr:nth-child(3) td:nth-child(2)")
  	private WebElement selectDocumentlistEarlyLearningGuide;


  //Subject Year
      @FindBy(css = "table[id$='LEVEL_4_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input")
      private WebElement selectSubjectYearArrow;
      
      @FindBy(css = "table[id$='LEVEL_4_CONTROL_menu'] tbody tr:nth-child(4) td:nth-child(2)")
      private List<WebElement> selectSubjectYearlist;
          
      @FindBy(css="table[id$='LEVEL_4_CONTROL_menu'] tbody tr:nth-child(4) td:nth-child(2)")
  	private WebElement selectSubjectYearlistLearning2006;
    
      //@FindBy(css = "div>span") //pending as of 04/19 its not working
    //private List<WebElement> selectDocumentFile;
    
    //@FindBy(css = "div>span") //pending as of 04/19 its not working
    //private List<WebElement> selectSubject;
    
    
    //@FindBy(css = "div>span") //pending as of 04/19 its not working
    //private List<WebElement> fromGrade;
    
    @FindBy(xpath = ".//*[@id='From_Grade_CONTROL']/tbody/tr/td[1]/div[1]/span")
    private List<WebElement> fromGrade;
    
    //@FindBy(css = "div>span") //pending as of 04/19 its not working
    //private List<WebElement> toGrade;
    
    @FindBy(xpath = ".//*[@id='To_Grade_CONTROL']/tbody/tr/td[1]/div[1]/span")
    private List<WebElement> toGrade;
    
    @FindBy(id = "Modified_Date_From_CONTROL")
    private WebElement fromDateInput;
    
    @FindBy(id = "Modified_Date_To_CONTROL")
    private WebElement toDateInput;
    
    @FindBy(css = "input[name$='Keyword']")
    private WebElement keywordInput;
    
    @FindBy(css = "span[id*='label']")
    private WebElement searchButton;
    
    @FindBy(css="tbody[id$='ITEMS'] tr ")
    private List<WebElement> standardsSearchList;
    
    @FindBy(css="td:nth-child(2) span span span:nth-child(2) ")
    private List<WebElement> authorityStateColumn;
    
    @FindBy(css="td:nth-child(3) span span span:nth-child(2) ")
    private List<WebElement> subjectList;
    
    @FindBy(css="tbody[id$='STD_GRD_ITEMS'] td span")
    private List<WebElement> gradesList;
    
    @FindBy(id="uniqName_1_7_label")
    private WebElement saveStructure;
    
    @FindBy(css="table[id$='APPROVE_STD_CONTROL'] tbody tr td:nth-child(2) input")
    private WebElement statusListArrow;
    
    @FindBy(css="table[id='APPROVE_STD_CONTROL_menu'] tbody tr td:nth-child(2) ")
    private List<WebElement> statusList;    
    
    @FindBy(xpath=".//*[@id='CORRELATE_label']")
    private WebElement CorrelateBtn;    
    
    @FindBy(xpath="//*[contains(text(),'Save Correlations') and contains(@id,'alfresco_buttons_AlfButton')] ")
    private WebElement SaveCorrelationBtn; 
    
    @FindBy(xpath="//*[contains(text(),'Cancel') and contains(@id,'alfresco_buttons_AlfButton')] ")
    private WebElement CancelBtn; 
    
    @FindBy(xpath=".//*[@id='VIEW_CORRELATIONS_label']")
    private WebElement viewCorrelationBtn;
    
    @FindBy(xpath="//*[contains(text(),'Ok') and contains(@id,'alfresco_buttons_AlfButton')] ")
    private WebElement okBtn; 
    
    @FindBy(xpath=".//*[@id='REMOVE_CORRELATIONS_label']")
    private WebElement removeCorrelationBtn;
    
    @FindBy(xpath="//*[contains(text(),'Remove Correlations') and contains(@id,'alfresco_buttons_AlfButton')]")
    private WebElement RemoveCorrelations; 
    
    @FindBy(xpath=".//*[@id='uniqName_8_0_title']")
    private WebElement importStandardPopup;
    
    @FindBy(xpath=".//*[@id='uniqName_8_0']/div[1]/span[2]")
    private WebElement importStandardPopupClose;
    
    @FindBy(xpath=".//*[@title='Show Standard']")
    private WebElement selectShowStandard;
    
    @FindBy(xpath=".//*[@id='standardText']")
    private WebElement selectStandardText;
    
    @FindBy(xpath=".//*[@id='dateOfImport']")
    private WebElement selectDateOfImport;
    
    @FindBy(xpath=".//button[text()='Generate Report']")
    private WebElement generateStandardReport;
    
    @FindBy(xpath=".//span[text()='Add to Standards Cart']")
    private WebElement clickAddToStandardsCart;
    
    @FindBy(xpath=".//*[text()='Correlations']")
    private WebElement clickCorrelations;
    
    @FindBy(xpath=".//span[@id='ABGUID']")
    private WebElement storeABGUIDValue;
    
    
    String documentNameX = "//tbody/tr[*]//span[2][contains(text(),'docName')]";
    String gradeNameCss="span[class$='value']:nth-child(2)";
//    String expandGradeButtonXpath = "//tbody[@id='STD_GRD_ITEMS']//td//span[2]/span/span[contains(text(),'inputGrade')]/preceding::span[2]/img";
    String expandGradeButtonXpath = "//tbody[@id='STD_GRD_ITEMS']//td//span[contains(text(),'inputGrade')]/preceding::span/img";
    String viewCorrelationPopupObjectName = "//span[contains(text(),'InputCorrelatedObjectName')]";

//    @FindBy(css="td:nth-child(5) span span span:nth-child(2) ")
//    private List<WebElement> actionsList;
    
    String countryColumn = "td:nth-child(1) span span span:nth-child(2) ";
    String stateDocList ="td:nth-child(4) span span span:nth-child(2) ";
    String stateDocListX="//tbody/tr[*]//span[contains(text(),'textToReplace')]";
    String actionButtonX = "//tbody/tr[*]//span[contains(text(),'textToReplace')]/following::td[2]//span[1]/img";
    String approvedActionButtonX = "//tbody/tr[*]//span[contains(text(),'textToReplace')]/following::td//span[1]/img";
    String actionButtonCss = "span[class*='PublishAction']";
    
//    String stndrdTxt = "//*[text()='inputStandardText']";
    String stndrdTxt = ".//*[contains(text(),'inputStandardText')]";
    String correlatePlusorCrossbtn = "//tbody[contains(@id, 'alfresco_documentlibrary_views')]//td//span[contains(text(),'ObjectToCorrelate')]/ancestor::td/following-sibling::td/span/img";
    
    private final String siteTitleCssSelector = "#HEADER_TITLE > a";
    private final String abStandards ="//td//";
    

    public void clickOnStandards(){
    	waitForElementID("HEADER_SEARCH_STANDARDS_LINK_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(standards).waitUntilVisible();
    	standards.click();
    }
    
    public void clickOnImportStandards(){
    	waitForElement("HEADER_SEARCH_STANDARDS_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(importStandards).waitUntilVisible();
    	importStandards.click();
    }
    
    public void clickOnSearchStandards(){
    	waitForElement("HEADER_IMPORT_STANDARDS_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(searchStandards).waitUntilVisible();
    	searchStandards.click();
    	
    }
    
    public void selectStandardCollection(String collectionName){
    	
    	/*waitForElement("clickOnDraftCollection",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(clickOnDraftCollection).waitUntilVisible();*/
    	clickOnDraftCollection.click();
    /*	waitForElement("approvedCollections", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(approvedCollections).waitUntilVisible();*/
    	JavascriptExecutor jexecutor=(JavascriptExecutor)getDriver();
    	jexecutor.executeScript("arguments[0].scrollIntoView(true);", approvedCollections);
    	jexecutor.executeScript("arguments[0].click();", approvedCollections);
    	//approvedCollections.click();   	
    }
    
    public void keyWordSearch(String keyword){
    	waitForElement("input[name$='Keyword']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(keywordInput).waitUntilVisible();
    	keywordInput.sendKeys(keyword);
    	
    }
    
    public void clickOnSearch(){
    	waitForElement("span[id*='label']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	element(searchButton).waitUntilVisible();
    	searchButton.click();
    	
    }

 
    public void importStandardsToOneCMS(String docName){ 
  	  waitForElement("thead>th:nth-child(1)>span:nth-child(1)", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
  	  waitForAngularRequestsToFinish();
  	  System.out.println(docName);
       boolean found = isElementVisible(By.xpath(".//*/span/span[contains(text(),'"+docName+"')]"));
       System.out.println(found);
            if (found) {
          	  	getDriver().findElement(By.xpath("//*[contains(text(),'"+docName+"')]/following::td[2]//img")).click();
            }
            // ***Fix***
            waitABit(300);
            boolean found2 = isElementVisible(By.xpath(".//*[contains(text(),'Update Standard Document')]/../div[1]"));
            if (found2==true) {
          	  	getDriver().findElement(By.xpath(".//*[contains(text(),'Update Standard Document')]/../div[1]")).click();
          	  	if(isElementVisible(By.xpath(".//*[@class='dijitReset dijitInline dijitButtonText'][contains(text(),'Import')]")))
          	  	{
          	  	getDriver().findElement(By.xpath(".//*[@class='dijitReset dijitInline dijitButtonText'][contains(text(),'Import')]")).click();
          	  	
          	  	}
            }
            else
            {
            	System.out.println("Newly imported standard");
            }
        
        Assert.assertTrue("The standard set "+docName+ " is NOT found", found);
    }
    
    public void waitUntilStandardIsImported(String docName){
    	waitForElement("thead>th:nth-child(1)>span:nth-child(1)", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	waitForAngularRequestsToFinish();
    	  boolean found = isElementVisible(By.xpath(documentNameX.replace("docName", docName)));
          int counter =0;
          while((!found) && (counter <50)){
               if (isElementVisible(By.xpath(documentNameX.replace("docName", docName)))) {
             	  	found=true;
             	  	break;
               }
               waitABit(5000);
               counter++;
          }
 
		Assert.assertTrue("The Standard is not imported to OneCMS in 10 Minutes", found);
   }

    public void verifyStandardIsPresentInSearchList(String docName){
    	  boolean found = false;
    	  waitForElement("thead>th:nth-child(1)>span:nth-child(1)", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	  waitForAngularRequestsToFinish();
        final Actions action = new Actions(getDriver());
  	      if (isElementVisible(By.xpath(documentNameX.replace("docName", docName)))) {
  	          found = true;
  	        }
      
      Assert.assertTrue("The standard document "+docName+ " is NOT found", found);
      }

    public void clickOnActionsForDocument(String docName){
  	  boolean found = false;
  	  waitForElement("thead>th:nth-child(1)>span:nth-child(1)", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
  	  waitForAngularRequestsToFinish();
      final Actions action = new Actions(getDriver());
	      if (isElementVisible(By.xpath(documentNameX.replace("docName", docName)))) {
	   	  	  getDriver().findElement(By.xpath(approvedActionButtonX.replace("textToReplace", docName))).click();
	          found = true;
	        }
    
    Assert.assertTrue("The standard document "+docName+ " is NOT found", found);
    }
    
    public void expandGradeButton(String gradeNumber,String standardText,String importStdName,String subject){
  	  boolean found = false;   
  	  //*** Fix Code (commented below is old code)***
  	  waitABit(3000);
  	  WebElement scrollDown = getDriver().findElement(By.xpath(".//*[text()='"+importStdName+"']/../../span[1]")); 
  	  scrollDown.click();
  	  waitABit(3000);
  	  WebElement GradePlusButton = getDriver().findElement(By.xpath(".//*[text()='"+gradeNumber+"']/../../span[1]")); 
  	  GradePlusButton.click();
  	  waitABit(3000);
  	  WebElement clickSubject = getDriver().findElement(By.xpath(".//*[text()='"+subject+"']/../../span[1]")); 
  	  clickSubject.click();
  	//  waitForElementX("plusButton", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
  	  waitForAngularRequestsToFinish();
    //  final Actions action = new Actions(getDriver());
	     /* if (isElementVisible(By.xpath(".//*[text()='"+gradeNumber+"']/../../span[1]"))) {
	    	  GradePlusButton.click();
	          found = true;
	      }
	        */  
	      
	      System.out.println(gradeNumber+" is expanded");
	      
	    waitForAngularRequestsToFinish();
	    
	    //Assert.assertTrue("The '+' button is not found on "+gradeNumber , found);
	    
	    waitABit(3000);
	    WebElement standrdFolder =  getDriver().findElement(By.xpath(".//*[text()='Make sense of problems and persevere in solving them.']"));
	    element(standrdFolder).waitUntilVisible();
	    //waitForElementX(stndrdTxt.replace("inputStandardText", standardText), ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());   	  
	    standrdFolder.click();		
	    System.out.println(standardText+" is found");  	      
	    waitForAngularRequestsToFinish();
	   
		  }
		 
    
	
	public void CorrelateObjectToStandard(String fileName){    
		element(CorrelateBtn).waitUntilVisible();  
		waitForElementX(".//*[@id='CORRELATE_label']", 20, getDriver());   	      
		CorrelateBtn.click();  	 
		waitABit(5000);
		waitForAngularRequestsToFinish();  	       
		System.out.println(fileName+" is found");
		WebElement standrdCorrelationpopup = getDriver().findElement(By.xpath(".//*[text()='"+fileName+"']//following::img[1]"));//  
		element(standrdCorrelationpopup).waitUntilVisible();
		//waitForElementX(correlatePlusorCrossbtn.replace("ObjectToCorrelate", fileName), 50, getDriver()); 
		standrdCorrelationpopup.click();
		waitABit(8000);
	//	WebElement selectItems = (new WebDriverWait(getDriver(), 40)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Save Correlations')])[2]")));
		//selectItems.click();
		SaveCorrelationBtn.click();     
   
    }
	  

	public void viewCorrelations(String fileName) {
		waitABit(8000);
		viewCorrelationBtn.click();
		WebElement viewcorrelation = getDriver().findElement(By.xpath(viewCorrelationPopupObjectName.replace("InputCorrelatedObjectName", fileName)));
		element(viewcorrelation).waitUntilVisible();
		viewcorrelation.click();
		System.out.println("Correlated Object is clicked");
		
		String parentWinHandle = getDriver().getWindowHandle();
		
		 for(String childWinHandle : getDriver().getWindowHandles()){
			 getDriver().switchTo().window(childWinHandle);
	        }
		waitForPageToLoadCompletely(ConstantsHMH.DEFAULT_TIMEOUT_SECONDS);
		
		
		getDriver().close();
		getDriver().switchTo().window(parentWinHandle);
				
		
		okBtn.click();

		
	}
    
	public void removeCorrelations(String fileName) {
		removeCorrelationBtn.click();
		WebElement removeCorrelationpopup = getDriver().findElement(By.xpath(".//*[text()='"+fileName+"']/../../../../td/span/img"));
		element(removeCorrelationpopup).waitUntilVisible();
	//	waitForElementX(correlatePlusorCrossbtn.replace("ObjectToCorrelate", fileName), 20, getDriver());
		waitABit(5000);
		removeCorrelationpopup.click();
		waitABit(5000);
		RemoveCorrelations.click();
		//waitABit(300);
	//	WebElement btn=  getDriver().findElement(By.xpath(".//*[text()='Remove']"));

		
		// *** Fix *** dynamic CSS added
		if(isElementVisible(By.xpath(".//*[text()='Remove']")))
		{
			//element(remCorBtn).waitUntilVisible();
			LOG.info("found the element");
			remCorBtn.click();
			//btn.click();
		}
		else
		{
			LOG.info("Unable to find the element");
		}
		
		
	}
	
	public void verifyImportStandardPopupIsPresent(String labelImport) {
		waitABit(1000);
		 //boolean found = isElementVisible(By.xpath("//div[14]/div[1]/span[1][contains(text(),'"+labelImport+"')]"));
		boolean found = isElementVisible(By.xpath(".//*[@id='uniqName_8_0']/div[1]/span[1][contains(text(),'"+labelImport+"')]"));
         if (found==true) {
       	  	getDriver().findElement(By.xpath(".//*[@id='uniqName_8_0']/div[1]/span[2]")).click();
         }
		}
	
	public void clickImportStandardPopupCloseBtn() {
		waitABit(1000);
		importStandardPopupClose.click();
		}
	
	public void selectCountryInStandards(String selectCountryVal){
		boolean isMatched = false;
		waitForElement("table[id$='LEVEL_1_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(selectCountryArrow).waitUntilVisible();
		selectCountryArrow.click();
		for(WebElement currStatus:selectCountrylist){
			System.out.println(currStatus.getText());
			if(currStatus.getText().toLowerCase().contains(selectCountryVal.toLowerCase())){
				
				if (selectCountryVal.contains("United States")){
					selectCountrylistUS.click();	
					isMatched=true;
				}
							
					Assert.assertTrue("The current status of Country in Standard is INCORRECT ", isMatched);
			}
			}	
	}
	
	public void selectDocumentFileInStandards(String selectDocumentFileVal) {
		boolean isMatched = false;
		waitForElement("table[id$='LEVEL_3_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(selectDocumentArrow).waitUntilVisible();
		selectDocumentArrow.click();
		for(WebElement currStatus:selectDocumentlist){
			System.out.println(currStatus.getText());
			if(currStatus.getText().toLowerCase().contains(selectDocumentFileVal.toLowerCase())){
				
				if (selectDocumentFileVal.contains("Early Learning Guidelines")){
					selectDocumentlistEarlyLearningGuide.click();	
					isMatched=true;
				}
							
		Assert.assertTrue("The current status of Document in Standard is INCORRECT ", isMatched);
			}
			}	
	}
	
	public void selectSubjectYearInStandards(String selectSubYearVal) {
		boolean isMatched = false;
		waitForElement("table[id$='LEVEL_4_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(selectSubjectYearArrow).waitUntilVisible();
		selectSubjectYearArrow.click();
		for(WebElement currStatus:selectSubjectYearlist){
			System.out.println(currStatus.getText());
			if(currStatus.getText().toLowerCase().contains(selectSubYearVal.toLowerCase())){
				
				if (selectSubYearVal.contains("Approaches to Learning (2006)")){
					selectSubjectYearlistLearning2006.click();	
					isMatched=true;	
				}
							
		Assert.assertTrue("The current status of Subject Year in Standard is INCORRECT ", isMatched);
			}
			}	
	}
		
	

		public void selectFromGradeInSearchStandards(String selectFromGradeVal) {
		boolean fromGradeValueFound = false;
		for (WebElement type : fromGrade) {
			if (type.getText().toLowerCase().contains(selectFromGradeVal.toLowerCase())) {
				fromGradeValueFound = true;
				type.click();
				break;
			}
		}
		Assert.assertTrue("The Select From Grade was not found", fromGradeValueFound);
	}

	public void selectToGradeInSearchStandards(String selectToGradeVal) {
		boolean toGradeValueFound = false;
		for (WebElement type : toGrade) {
			if (type.getText().toLowerCase().contains(selectToGradeVal.toLowerCase())) {
				toGradeValueFound = true;
				type.click();
				break;
			}
		}
		Assert.assertTrue("The Select To Grade was not found", toGradeValueFound);
	}
	
	public void selectAuthorityInStandards(String selectAuthorityVal){
		boolean isMatched = false;
		waitForElement("table[id$='LEVEL_2_CONTROL'] tbody tr:nth-child(1) td:nth-child(2) input", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(selectAuthorityArrow).waitUntilVisible();
		selectAuthorityArrow.click();
		for(WebElement currStatus:selectAuthoritylist){
			System.out.println(currStatus.getText());
			if(currStatus.getText().toLowerCase().contains(selectAuthorityVal.toLowerCase())){
				
				if (selectAuthorityVal.contains("Alaska")){
					selectAuthoritylistAlaska.click();	
					isMatched=true;
															
				}
				/*else if (selectAuthorityVal.contains("Alabama")){
					selectAuthoritylistAlaska.click();
					isMatched=true;
					System.out.println("Not Alaska");
					
				} */
			
			
		Assert.assertTrue("The current status of Authority in Standard is INCORRECT ", isMatched);
			}
			}	
	}
	
    //** ALF-1581 ** Return to Search Results Screen from Standards Hierarchy ** Sprint 7.3.1 **
	public void selectShowStandard() {
		
		waitABit(1000);
		selectShowStandard.click();
		
		}
	
	 //** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 ** 
	public void clickOnExportStandards(String authorityName) {
		
		waitForElementX("(.//span[@class='value'][text()='"+authorityName+"'])[1]/following::td[3]/span[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement clickOnExportStandards = getDriver().findElement(By.xpath("(.//span[@class='value'][text()='"+authorityName+"'])[1]/following::td[3]/span[2]"));
		element(clickOnExportStandards).waitUntilVisible();
		clickOnExportStandards.click();
		System.out.println(authorityName);
		
	}
	
	//** ALF-1086 ** Select Metadata to Include in Standards Report ** Sprint 7.3.3 **
	public void selectMetadataOnExportStandards() {
		
		element(selectStandardText).waitUntilVisible();
		selectStandardText.click();
		
		element(selectDateOfImport).waitUntilVisible();
		selectDateOfImport.click();
		
	}
		
		
	//** ALF-1086 ** Select Metadata to Include in Standards Report ** Sprint 7.3.3 **
	public void generateStandardReport() {
		element(generateStandardReport).waitUntilVisible();
		generateStandardReport.click();
		
		
	}
	//** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
	public void clickAddToStandardsCartAction() {
		element(clickAddToStandardsCart).waitUntilVisible();
		clickAddToStandardsCart.click();
		
	}
 
	 //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
	 public void expandGradeButtonNextLevel(String gradeNumber,String standardText,String importStdName,String subject){
	  	  boolean found = false;   
	  	  waitABit(3000);
	  	  waitForElementX(".//*[text()='"+importStdName+"']/../../span[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	  	  WebElement scrollDown = getDriver().findElement(By.xpath(".//*[text()='"+importStdName+"']/../../span[1]"));
	  	  Actions action = new Actions(getDriver());
	  	  action.moveToElement(scrollDown).build().perform();
	  	  scrollDown.click();
	  	  waitABit(3000);
	  	  WebElement GradePlusButton = getDriver().findElement(By.xpath(".//*[text()='"+gradeNumber+"']/../../span[1]")); 
	  	  GradePlusButton.click();
	  	  waitABit(3000);
	  	  WebElement clickSubject = getDriver().findElement(By.xpath(".//*[text()='"+subject+"']/../../span[1]")); 
	  	  clickSubject.click();	      
		  System.out.println(gradeNumber+" is expanded");
		  waitABit(3000);
		  WebElement standardFolder =  getDriver().findElement(By.xpath(".//*[text()='Reason abstractly and quantitatively.']"));
		  element(standardFolder).waitUntilVisible();
		  waitABit(3000);
		  standardFolder.click();		
		  System.out.println(standardText+" is found");    
		    
			  }
	//** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
	public void expandGradeButtonNew(String gradeNumber, String standardText, String importStdName, String subject) {
		  boolean found = false;   
	  	  waitABit(3000);
	  	  waitForElementX(".//*[text()='"+importStdName+"']/../../span[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	  	  WebElement scrollDown = getDriver().findElement(By.xpath(".//*[text()='"+importStdName+"']/../../span[1]"));
	  	  Actions action = new Actions(getDriver());
	  	  action.moveToElement(scrollDown).build().perform();
	  	  scrollDown.click();
	  	  waitABit(3000);
	  	  WebElement GradePlusButton = getDriver().findElement(By.xpath(".//*[text()='"+gradeNumber+"']/../../span[1]")); 
	  	  GradePlusButton.click();
	  	  waitABit(3000);
	  	  WebElement clickSubject = getDriver().findElement(By.xpath(".//*[text()='"+subject+"']/../../span[1]")); 
	  	  clickSubject.click();	      
		  System.out.println(gradeNumber+" is expanded");
		  waitABit(3000);
		  WebElement standardFolder =  getDriver().findElement(By.xpath("//*[text()='Forces and Interactions: Pushes and Pulls']"));
		  element(standardFolder).waitUntilVisible();
		  waitABit(3000);
		  standardFolder.click();		
		  System.out.println(standardText+" is found");
		
	}

	//** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
	public void expandGradeButtonNewNextLevel(String gradeNumber, String standardText, String importStdName,
			String subject) {
		 boolean found = false;   
	  	  waitABit(3000);
	  	  waitForElementX(".//*[text()='"+importStdName+"']/../../span[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	  	  WebElement scrollDown = getDriver().findElement(By.xpath(".//*[text()='"+importStdName+"']/../../span[1]"));
	  	  Actions action = new Actions(getDriver());
	  	  action.moveToElement(scrollDown).build().perform();
	  	  scrollDown.click();
	  	  waitABit(3000);
	  	  WebElement GradePlusButton = getDriver().findElement(By.xpath(".//*[text()='"+gradeNumber+"']/../../span[1]")); 
	  	  GradePlusButton.click();
	  	  waitABit(3000);
	  	  WebElement clickSubject = getDriver().findElement(By.xpath(".//*[text()='"+subject+"']/../../span[1]")); 
	  	  clickSubject.click();	      
		  System.out.println(gradeNumber+" is expanded");
		  waitABit(3000);
		  WebElement standardFolder =  getDriver().findElement(By.xpath("//*[text()='Interdependent Relationships in Ecosystems: Animals, Plants, and Their Environment']"));
		  element(standardFolder).waitUntilVisible();
		  waitABit(3000);
		  standardFolder.click();		
		  System.out.println(standardText+" is found");
		
		
		
		
	}
	
	//** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
	public void clickCorrelations()
	{
		element(clickCorrelations).waitUntilVisible();
		clickCorrelations.click();
		
	}

	 //** ALF-1161 ** Sort Saved Correlations in Details view of any object ** Sprint 7.3.3 **
	public void verifyCorrelationInSortingOrderOnViewDetails() {
		
					
		ArrayList<String> compareList = new ArrayList<String>();
		waitABit(3000);
		//	waitForElementX(".//*[@id='template_x002e_comments_x002e_folder-details_x0023_relationships-list-myelement3']/div[1]", 
		//			ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		compareList.add(
				(getDriver().
						findElement(By.xpath(".//*[text()='NJ.K Forces and Interactions: Pushes and Pulls']")).getText()));
		compareList.add(
				(getDriver().
						findElement(By.xpath(".//*[text()='NJ.K Interdependent Relationships in Ecosystems: Animals, Plants, and Their Environment']"))
						.getText()));

		Collections.sort(compareList);
		WebElement firstSort = getDriver().findElement(By.xpath(".//*[@id='standardCorrelations-1-label']"));
		
		System.out.println("Sorting done successfully for:"+firstSort.getText());
		waitABit(1000);
		WebElement secondSort = getDriver().findElement(By.xpath(".//*[@id='standardCorrelations-2-label']"));
		secondSort.click();
		ArrayList<String> compareList1 = new ArrayList<String>();
		compareList1.add(
				(getDriver().
						findElement(By.xpath(".//*[text()='CC.CCSS.Math.Practice.MP1 Make sense of problems and persevere in solving them.']"))
						.getText()));
		compareList1.add(
				(getDriver().
						findElement(By.xpath(".//*[text()='CC.CCSS.Math.Practice.MP2 Reason abstractly and quantitatively.']"))
						.getText()));	                   
		Collections.sort(compareList1);
		System.out.println("Sorting done successfully for:"+secondSort.getText());
		waitABit(1000);
		ArrayList<String> compareYearList = new ArrayList<String>();
		
		String accordion1=
				(getDriver().
						findElement(By.xpath(".//*[@id='standardCorrelations-1-label']"))
						.getText());
		String[] compareYear = accordion1.split("\\(");
		String yr1= compareYear[1].substring(0, compareYear[1].length()-1);
		System.out.println(yr1);
		
		String accordion2=
				(getDriver().
						findElement(By.xpath(".//*[@id='standardCorrelations-2-label']"))
						.getText());
		String[] compareYear1 = accordion2.split("\\(");
		String yr2= compareYear1[1].substring(0, compareYear1[1].length()-1);
		System.out.println(yr2);	
		compareYearList.add(yr1);
		compareYearList.add(yr2);
		
		System.out.println(compareYearList);
		Collections.sort(compareYearList,Collections.reverseOrder());
		System.out.println("Latest year is on the Top");
		
	}
	
	//** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
	public  String storeABGUIDValue() {
	
		String val = element(storeABGUIDValue).getText();
		System.out.println("ABGUID value is :"+val);
		return val; 
			
	}
	
	//** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
	public void verifyStdTextForCorrelatedObject(String Standardtext) {
		
		waitABit(3000);
		WebElement stdText = getDriver().findElement(By.xpath(".//*[text()='"+Standardtext+"']")); 
		System.out.println("Correlated object Standard text displayed is:"+stdText.getText());
		
	}
	
   //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
	public void selectDropdownSearchContent(String value) {
		
		Select dropdownVal = new Select (getDriver().findElement(By.xpath(".//*[@id='srchContentBystd_cell_type']")));
		dropdownVal.selectByVisibleText(value);
		waitABit(3000);
	}
	
   //** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
	public void keywordSearch(String value) {
		
		waitABit(3000);
		WebElement keyword = getDriver().findElement(By.xpath(".//*[@id='inputStdProp']")); 
		keyword.sendKeys(value);
		System.out.println("");
		WebElement searchButton = getDriver().findElement(By.xpath(".//button[@id='searchBtn-button']"));
		searchButton.click();
		
	}
   
	//** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
	public void verifyDisplayNameOnSearchResults(String displayName) {
		
		boolean isMatch = false;
		waitABit(5000);
		WebElement dispName = getDriver().findElement(By.xpath(".//div[text()='"+displayName+"']")); 
	    
	    if(dispName.getText().contains(displayName))
	    {
	    	isMatch = true;
	    	System.out.println("Display Title is FOUND:"+dispName.getText());
	    	
	    }
		
	    Assert.assertTrue("The standard set "+displayName+ " is NOT found", isMatch);
		
	}
	
	
	
}
	 
	 
			 

