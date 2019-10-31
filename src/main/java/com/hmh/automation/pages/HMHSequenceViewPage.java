package com.hmh.automation.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jline.internal.Log;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;

public class HMHSequenceViewPage extends AbstractPage {

    public HMHSequenceViewPage(final WebDriver driver) {
        super(driver);
    }

    private static final Logger LOG = LoggerFactory
			.getLogger(HMHSequenceViewPage.class);
    
    private DocumentLibrarySteps documentLibrarySteps;
    
    @FindBy(css = "button[id*='collapse-all-button-button']")
    private WebElement colapseAllButton;

    @FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement confirmDeleteButton;

    
    @FindBy(css = "button[id*='go-back-button-button']")
    private WebElement goBackButton;
    
    @FindBy(css = "span[class ^='onActionDelete']")
   	private WebElement deleteItemsButtonInSelectedItems;

    @FindBy(css = "div[id='assembly-view-tree-container'] ul li[id^='workspace'] span[class*='dynatree-exp'] a")
    private List<WebElement> sequenceItems;
    
    @FindBy(css = "div[id*='assembly-view-tree'] ul li span a[class$='dynatree-title'] div[class$='td']")
    private List<WebElement> galleryViewItems;
   
    @FindBy(css = "button[id*='default-folderview-button']")
    private WebElement folderView;

    @FindBy(css = "button[id*='view-details-panel-metadata-button-button']")
    private WebElement metadataSequenceViewButton;
    
    @FindBy (css= "button[id*='expand-all-button-button']")
    private WebElement expandAllButton;
    
    @FindBy (css= "button[id*='template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-selectedItems-button-button']")
    private WebElement selectedItems;
    
    @FindBy (css= "button[id*='collapse-all-button-button']")
    private WebElement collapseAllButton;

    @FindBy(css = "button[id*='createContent-button-button']")
   	private WebElement createButton;
       @FindBy(css = "div.create-content div.bd ul li a")
   	private List<WebElement> contentToCreateList;
       
    @FindBy(css = ".//button[text()='Save']")
    private WebElement saveBtn;
    
    @FindBy(css = "input[class='invalid']")
    private WebElement invalidInput;
    
    @FindBy(css = "input[id*='createObject_prop_cm_name']")
    private WebElement nameInput;
    
    @FindBy(css = "textarea[id$='prop_cm_title']")
    private WebElement displayTitle;
    
    @FindBy(css = "select[id*='createObject_prop_hmh-cms_grade-entry'] option")
    private List<WebElement> gradesList;
    
    @FindBy(css = "select[id$='cms_markets-entry'] option")
    private List<WebElement> marketsList;
    
    @FindBy(css = "select[id$='lifecycle'] option")
    private List<WebElement> lifecycleList;
    
    @FindBy(css = "select[id$='learningStyles-entry'] option")
    private List<WebElement> learningStylesList;
    
    @FindBy(css = "select[id$='interactivityLevel'] option")
    private List<WebElement> interactivityLevelList;
    
    @FindBy(css = "select[id$='language'] option")
    private List<WebElement> laguagesList;
    
    @FindBy(css = "select[id$='publicationRights-entry'] option")
    private List<WebElement> rightsList;
    
    @FindBy (xpath= "html/body/div[6]/div[1]/div[2]/div[2]/div[1]/div/div[4]/div/div/div/div[1]/div[1]/div/div/div[1]/div/div[1]/ul/li[3]/a/span")
    private WebElement seqBuninSq;
    
    @FindBy (xpath= "html/body/div[6]/div[1]/div[2]/div[2]/div[1]/div/div[4]/div/div/div/div[1]/div[1]/div/div/div[1]/div/div[1]/ul/li[5]/a/span")
    private WebElement cloInSq;
    
    @FindBy (xpath= "html/body/div[4]/div[1]/form/div[1]/div/div[1]/input")
    private WebElement seqBunNameSq;
    
    @FindBy (xpath= "html/body/div[4]/div[1]/form/div[1]/div/div[2]/textarea ")
    private WebElement seqBundispSq;
    
    @FindBy (xpath= "html/body/div[4]/div[1]/form/div[1]/div[1]/div[1]/input ")
    private WebElement cloNameSq;
    
    @FindBy (xpath= "html/body/div[4]/div[1]/form/div[1]/div[1]/div[2]/textarea ")
    private WebElement cloDispSq;
    
    @FindBy (xpath= "")
    private WebElement savebtn;
    
    @FindBy (css= "div[class$='form-field'] select option[value$='Public Domain']")
    private WebElement cloPrSq;
    
    @FindBy (css= "span[class*='dynatree-ico-cf']")
    private WebElement clickOnJustCreatedObj;
    
    @FindBy(xpath="html/body/div[6]/div[1]/div[2]/div[2]/div[1]/div/div[4]/div/div/div/div[1]/div[1]/div/div/div[1]/span/span/button")
    private WebElement createinSq;
    
    @FindBy (css= "button[id*='createObject-form-submit-button']")
    private WebElement savebuttonsq;
    //.//*/button[text()='Save']
    
  //This is for Test_Reg087
    @FindBy (css= "button[id $= 'fileUpload-button-button']")
    private WebElement uploadbuttonsq;
    
    @FindBy (css= "span[class $='overlay-wrapper']")
    private WebElement uploadFilebuttonsq;
    
    
    @FindBy (xpath= ".//*[@id='template_x002e_dnd-upload_x002e_documentlibrary_x0023_default-cancelOk-button-button']")
    private WebElement uploadCancel;
    
    
    public void folderViewButtonClick() {
        element(folderView).waitUntilVisible();
        folderView.click();
    }
    
    

    public void metadataSequenceViewButtonClick() {
        element(metadataSequenceViewButton).waitUntilVisible();
        metadataSequenceViewButton.click();
    }

    public void checkIfOnSequenceViewPage() {
    	waitForPageToLoadCompletely(60);
        boolean found = false;
        element(colapseAllButton).waitUntilVisible();
        if (colapseAllButton.isDisplayed()) {
            found = true;
        }
        Assert.assertTrue("You are not on Sequence View Page", found);
    }

    public void goBackClick() {
        goBackButton.click();
    }

    public void checkSequenceTreeStructure(String firstElement, String secondElement, String thirdElement) {
        waitABit(1000);
        boolean orderCorrect = false;
        getDriver().navigate().refresh();
        List<String> myList = new ArrayList<String>();
        for (WebElement item : sequenceItems) {

            myList.add(item.getText());
        }
        if (myList.get(0).contains(firstElement)) {
            if (myList.get(1).contains(secondElement)) {
                if (myList.get(2).contains(thirdElement)) {
                    orderCorrect = true;
                }
            }
        }
        Assert.assertTrue("The order is not correct", orderCorrect);
    }

    public void changeSequenceTreeStructure(String elementToMove, String destination) {
        boolean elementFound = false;
        boolean destinationFound = false;
        Actions newAction = new Actions(getDriver());

        for (WebElement item : sequenceItems) {
            for (WebElement dest : sequenceItems) {
                if (item.getText().toLowerCase().contains(elementToMove.toLowerCase())
                        && dest.getText().toLowerCase().contains(destination.toLowerCase())) {
                    elementFound = true;
                    destinationFound = true;
                    newAction.dragAndDrop(item, dest).perform();
                    System.out.println("MOVE DONE");
                    break;
                }
            }
        }
        Assert.assertTrue("The element to move was not found", elementFound);
        Assert.assertTrue("The destination element was not found", destinationFound);
        System.out.println("MOVE DONE 2");
    }

    public void clickOnAnElementInTheSequenceView(String element) {
        boolean elementFound = false;
        waitForElementX("//a[@class='dynatree-title']//div[contains(text(),'"+element+"')][1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
        for (WebElement item : sequenceItems) {
            if (item.getText().toLowerCase().contains(element.toLowerCase())) {
                elementFound = true;
                //  waitUntilElementExists(item, 90);
                item.click();
                waitABit(1000);
                //waitForElementX("//div[@class='detailed-list-view-header']//div/span[contains(text(),'"+element+"')]", 300, getDriver());
                break;
            }
        }
        Assert.assertTrue("The item on which you want to click was not found", elementFound);
    }

    public void checkIfElementIsDisplayedInSequenceViewGallery(String elementName) {
        boolean elementFound = false;
        waitForElementX("//a[@class='dynatree-title']//div[contains(text(),'"+elementName+"')][1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
        for (WebElement item : galleryViewItems) {
            if (item.getText().toLowerCase().contains(elementName.toLowerCase())) {
                elementFound = true;
                break;
            }
        }

        Assert.assertTrue("The item on which you want to click was not found", elementFound);
    }

    public void expandTreeInSequenceView() {

        element(expandAllButton).waitUntilVisible();
        expandAllButton.click();
        waitABit(1000);

    }
    
    
    
    public String todaydate() {
		DateFormat dateFormat = new SimpleDateFormat("MMddyy"); //Wed Dec 16 12:21:19 IST 2015  ****("MMddyyyyz")
		Date date = new Date();
		String todayDate= dateFormat.format(date); //12/16/2015
		return todayDate;
	}
    
 

    
    public void createObjInEditSequence(int noOfLevels, String psObjName, String sbName, String ccoName){

    	for(int i = 1;i<=noOfLevels;i++){
				
				Actions action = new Actions(getDriver());				
				waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
				waitABit(3000);
		    	clickOnAnElementInTheSequenceView(psObjName);
		    	expandAllButton.click();
		    	waitABit(3000);
		    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+sbName+i+"')][1]"));
		    	System.out.println(isFound);
		    	if(isFound==false){
			        createNewContent("Sequence Bundle");
			        waitABit(3000);
			    	//createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			    	waitABit(3000);
			    	nameInput.sendKeys(sbName+i);
			    	waitABit(3000);
			    	displayTitle.sendKeys(sbName+i);
			    	waitABit(3000);
			    	savebuttonsq.click();
			    	waitABit(3000);
	    		}
		    	waitForAngularRequestsToFinish();
		    	waitABit(2000);
		    	refreshPage();
		    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		    	expandAllButton.click();
		    	waitForAngularRequestsToFinish();
		    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
		    	clickOnAnElementInTheSequenceView(sbName+i);
		    	expandAllButton.click();
		    	waitABit(1000);
		    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+ccoName+i+"')][1]"));
		    	System.out.println(isFound);
		    	if(isFound==false){
			    	createNewContent("Composite Content Object");
					//createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			    	waitABit(3000);
			    	nameInput.sendKeys(ccoName+i);
			    	waitABit(3000);
			    	displayTitle.sendKeys(ccoName+i);
			    	waitABit(3000);
			    	element(cloPrSq).click();
			    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
			    	savebuttonsq.click();
		    	}
		    	
		    	waitForAngularRequestsToFinish();
		    	waitABit(2000);
		    	refreshPage();
		    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		    	expandAllButton.click();
		    	waitForAngularRequestsToFinish();
		    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
		    	checkIfElementIsDisplayedInSequenceViewGallery(ccoName+i);
		    	LOG.info("level" +i+": Done");
		}
		
		collapseAllButton.click();
	
	}
    
    //Created for Publish to Manifest 
    public void createObjInEditSequenceForManifest(int noOfLevels, String psObjName, String sbName, String ccoName, String coName, String assetName){


    	for(int i = 1;i<=noOfLevels;i++){
			
			Actions action = new Actions(getDriver());				
			waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
			waitABit(2000);
	    	clickOnAnElementInTheSequenceView(psObjName);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+sbName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		        createNewContent("Sequence Bundle");
		    	//createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		        waitABit(3000);
		    	nameInput.sendKeys(sbName+i);
		    	displayTitle.sendKeys(sbName+i);
		    	savebuttonsq.click();
    		}
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(sbName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+ccoName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		    	createNewContent("Composite Content Object");
				//createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	 waitABit(3000);
		    	nameInput.sendKeys(ccoName+i);
		    	displayTitle.sendKeys(ccoName+i);
		    	element(cloPrSq).click();
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(ccoName+i);
	    	LOG.info("level" +i+": Done");
	    	/// for CO
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(ccoName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[text()='"+coName+i+"'][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		    	createNewContent("Content Object");
				//createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	 waitABit(3000);
		    	nameInput.sendKeys(coName+i);
		    	displayTitle.sendKeys(coName+i);
		    	element(cloPrSq).click();
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(coName+i);
	    	LOG.info("level" +i+": Done");
	    	WebElement clickCO= getDriver().findElement(By.xpath("//a[@class='dynatree-title']//div[text()='"+coName+i+"'][1]"));
	    	/*clickCO.click();
	    	//To upload into CO
	    	if(isElementVisible(By.cssSelector("button[id $= 'fileUpload-button-button']"))) {
				System.out.println("found");
				uploadbuttonsq.click();
			}
			else
			{
				System.out.println("not found");
				
			}
			
			
			//waitABit(2000);
			
			if(isElementVisible(By.cssSelector("span[class $='overlay-wrapper']")))
			{
				
				System.out.println("found file");
				//uploadCancel.click();
				System.out.println(jpeg);
				uploadFilebuttonsq.sendKeys("D:\\Sep30_oneCMS\\src\\test\\resources\\filesToUpload\\Penguins.jpeg");
			}
			else
			{
				System.out.println("file not found");
				
			}
	    	*/
	    	
	    	//for Asset
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	
	    	if(isElementVisible(By.xpath("//a[@class='dynatree-title']//div[text()='"+coName+i+"'][1]"))) {
	    	
	    	waitABit(1000);
	    	clickCO.click(); 
	    	}
	    	else {
	    		Log.info("Object not identified");
	    	}
	    	//clickOnAnElementInTheSequenceView(coName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[text()='"+assetName+i+"'][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		    	createNewContent("Asset");
			//	createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	 waitABit(3000);
		    	nameInput.sendKeys(assetName+i);
		    	displayTitle.sendKeys(assetName+i);
		    	element(cloPrSq).click();
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(assetName+i);
	    	LOG.info("level" +i+": Done");
	    	
	}
	
	collapseAllButton.click();

}
    
    public void createValidManifestStructureEditSequenceforNlevels(int noOfLevels, String psObjName, String sbName, String ccoName, String assetName){

    	for(int i = 1;i<=noOfLevels;i++){
			
			Actions action = new Actions(getDriver());				
			waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
			waitABit(2000);
	    	clickOnAnElementInTheSequenceView(psObjName);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+sbName+i+"')][1]"));
	    	if(isFound==false){
		        createNewContent("Sequence Bundle");
		    	createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(sbName+i);
		    	displayTitle.sendKeys(sbName+i);
		    	savebuttonsq.click();
    		}
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(sbName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+ccoName+i+"')][1]"));
	    	if(isFound==false){
		    	createNewContent("Composite Content Object");
				createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(ccoName+i);
		    	displayTitle.sendKeys(ccoName+i);
		    	element(cloPrSq).click();
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(ccoName+i);
	    	clickOnAnElementInTheSequenceView(ccoName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+assetName+i+"')][1]"));
	    	if(isFound==false){
		    	createNewContent("Asset");
				createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(assetName+i);
		    	displayTitle.sendKeys(assetName+i);
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(assetName+i);
	    	LOG.info("level" +i+": Done");
	}
	
	collapseAllButton.click();

}
    
    public void createNewContent(final String option) {
		element(createButton).waitUntilVisible();
		createButton.click();
		boolean foundOption = false;
		for (final WebElement optionType : contentToCreateList) {
			if (optionType.getText().toLowerCase()
					.contentEquals(option.toLowerCase())) {
				foundOption = true;
				optionType.sendKeys("");
				waitUntilElementExists(optionType, 15);
				optionType.click();
				break;
			}
		}
		Assert.assertTrue("The " + option + " type was not found!", foundOption);
	}

    public void createObjectWhenNotAllMandatoryMetadataFieldsAreFilled() {
        boolean worksWell = false;
        waitForElement("button[id*='createObject-form-submit-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());   
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript("arguments[0].click();", saveBtn);
       // saveBtn.click();
        waitABit(200);
        if (invalidInput.isDisplayed()) {
            worksWell = true;
        }
        Assert.assertTrue("The Invalid input message was not displayed", worksWell);

    }


	
    public void createSequenceBundle(final String name, final String market, final String title) {
        boolean marketsFound = false;
        manualScrollForInputField(1);
        element(nameInput).waitUntilVisible();
        nameInput.sendKeys(name);
        displayTitle.sendKeys(title);
        for (final WebElement marketItem : marketsList) {
            if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                marketsFound = true;
                marketItem.click();
                break;
            }
        }
        Assert.assertTrue("The market was not found", marketsFound);
        manualScrollForSaveButton(1);
        saveBtn.click();
    }

    
    public void createLearningObjectK12Site(final String name, final String grade, final String language,
            final String rights, final String market, final String title, final String lifecycle) {

    	 boolean gradeFound = false;
         boolean languageFound = false;
         boolean rightsFound = false;
         boolean marketsFound = false;
         boolean activityTypeFound = false;
         boolean productCategoryFound = false;
         boolean productTypeFound = false;
         boolean lifeCycleFound = false;
         element(nameInput).waitUntilVisible();
         nameInput.sendKeys(name);
         displayTitle.sendKeys(title);

         for (final WebElement rightsElement : rightsList) {
             if (rightsElement.getText().toLowerCase().contentEquals(rights.toLowerCase())) {
                 rightsFound = true;
                 rightsElement.click();
                 break;
             }
         }
         Assert.assertTrue("The right was not found", rightsFound);

         for (final WebElement gradeElement : gradesList) {
             if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
                 gradeFound = true;
                 gradeElement.click();
                 break;
             }
         }
         Assert.assertTrue("The grade was not found", gradeFound);

         for (final WebElement languageElement : laguagesList) {
             if (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase())) {
                 languageFound = true;
                 languageElement.click();
                 break;
             }
         }
         Assert.assertTrue("The language was not found", languageFound);

         for (final WebElement marketItem : marketsList) {
             if (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
                 marketsFound = true;
                 marketItem.click();
                 break;
             }
         }
         Assert.assertTrue("The market was not found", marketsFound);

//         for (final WebElement category : productCategoryList) {
//             if (category.getText().toLowerCase().contains(productCategory.toLowerCase())) {
//                 productCategoryFound = true;
//                 category.click();
//                 break;
//             }
//         }
//         Assert.assertTrue("The product category was not found", productCategoryFound);

         for (final WebElement cycle : lifecycleList) {
             if (cycle.getText().toLowerCase().contains(lifecycle.toLowerCase())) {
                 lifeCycleFound = true;
                 cycle.click();
                 break;
             }
         }
         Assert.assertTrue("The lifeCycle was not found", lifeCycleFound);
        
        saveBtn.click();
    }

    
  public void manualScrollForSaveButton (int manualScrollSeconds) {
    	
    	LOG.info("Manual scroll for " + manualScrollSeconds + " seconds");
		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(this.saveBtn).build().perform();

			waitABit(1000L);
		}
		LOG.info("Manual scroll done");
    }
    
    public void manualScrollForInputField (int manualScrollSeconds) {
    	
    	LOG.info("Manual scroll for " + manualScrollSeconds + " seconds");
		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(this.nameInput).build().perform();

			waitABit(1000L);
		}
		LOG.info("Manual scroll done");
    }
    
    //PO Sequence Steps
    public void createObjInEditSequencePSPO(int noOfLevels, String psObjName, String poName, String sbName){

    	for(int i = 1;i<=noOfLevels;i++){
			
			Actions action = new Actions(getDriver());				
			waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
			waitABit(2000);
	    	clickOnAnElementInTheSequenceView(psObjName);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+poName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		        createNewContent("Product Object");
		        waitABit(2000);
		    //	createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(poName+i);
		    	displayTitle.sendKeys(poName+i);
		    	savebuttonsq.click();
    		}
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(poName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+sbName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		    	createNewContent("Sequence Bundle");
				//createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
				waitABit(2000);
		    	nameInput.sendKeys(sbName+i);
		    	displayTitle.sendKeys(sbName+i);
		    	//element(cloPrSq).click();
		    	//action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(sbName+i);
	    	LOG.info("level" +i+": Done");
	}
	
	collapseAllButton.click();

}
    
//
    public void createObjInEditSequenceCOInSB(int noOfLevels, String psObjName, String sbName, String coName){

    	for(int i = 1;i<=noOfLevels;i++){
			
			Actions action = new Actions(getDriver());				
			waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
			waitABit(2000);
	    	clickOnAnElementInTheSequenceView(psObjName);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+sbName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		        createNewContent("Sequence Bundle");
		    	createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(sbName+i);
		    	displayTitle.sendKeys(sbName+i);
		    	savebuttonsq.click();
    		}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(sbName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+coName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		    	createNewContent("Content Object");
				createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(coName+i);
		    	displayTitle.sendKeys(coName+i);
		    	element(cloPrSq).click();
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(coName+i);
	    	LOG.info("level" +i+": Done");
	}
	
	collapseAllButton.click();

}
//
    
    //
    public void createObjInEditSequenceAssetInSB(int noOfLevels, String psObjName, String sbName, String assetName){

    	for(int i = 1;i<=noOfLevels;i++){
			
			Actions action = new Actions(getDriver());				
			waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
			waitABit(2000);
	    	clickOnAnElementInTheSequenceView(psObjName);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+sbName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		        createNewContent("Sequence Bundle");
		    	createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(sbName+i);
		    	displayTitle.sendKeys(sbName+i);
		    	savebuttonsq.click();
    		}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(sbName+i);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	isFound=isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+assetName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		    	createNewContent("Asset");
				createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	nameInput.sendKeys(assetName+i);
		    	displayTitle.sendKeys(assetName+i);
		    	element(cloPrSq).click();
		    	action.moveToElement(saveBtn); //button[id*='createObject-form-submit-button']
		    	savebuttonsq.click();
	    	}
	    	
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	checkIfElementIsDisplayedInSequenceViewGallery(assetName+i);
	    	LOG.info("level" +i+": Done");
	}
	
	collapseAllButton.click();
	

	

}
    
    public void checkSelectedItemsEnabledAndDelete() {

    	waitABit(3000);
    	if(element(selectedItems).isEnabled()){
     	   
			this.element(this.selectedItems).waitUntilVisible();
			this.selectedItems.click();
			waitABit(2000);
			this.element(this.deleteItemsButtonInSelectedItems).waitUntilVisible();
			this.deleteItemsButtonInSelectedItems.click();
			this.element(this.confirmDeleteButton).waitUntilVisible();
			this.confirmDeleteButton.click();
        
    	}
    }


	//This is for Test_Reg087
    
	public void ulpoadContent(String jpeg)
	{
		if(isElementVisible(By.cssSelector("button[id $= 'fileUpload-button-button']"))) {
			System.out.println("found");
			uploadbuttonsq.click();
		}
		else
		{
			System.out.println("not found");
			
		}
		
		
		waitABit(2000);
		
		if(isElementVisible(By.cssSelector("span[class $='overlay-wrapper']")))
		{
			
			System.out.println("found file");
			//uploadCancel.click();
			uploadFilebuttonsq.sendKeys(jpeg);
		}
		else
		{
			System.out.println("file not found");
			
		}
				
	}

	public void verifyObjInEditSequenceforEnhanceDeepCopy(String psObjName, String sbName, String ccoName,String coName, String assetName){
	
		String i = "EDC";
		Actions action = new Actions(getDriver());				
		waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
		waitABit(2000);
    	clickOnAnElementInTheSequenceView(psObjName);
    	expandAllButton.click();
    	waitABit(1000);
    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	
    	waitForElementX("//a[@class='dynatree-title']//div[contains(text(),'"+i+sbName+"1"+"')][1]",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	if(isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+i+sbName+"1"+"')][1]"))){
    		Log.info("Enhanced Deep Copy for SB Successful");
    			
    	}
    	else{
    		Log.info("Enhanced Deep Copy for SB not Successful");
    	}
    		
    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	expandAllButton.click();
    	waitForAngularRequestsToFinish();
    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
    	clickOnAnElementInTheSequenceView(i+sbName+"1");
    	expandAllButton.click();
    	waitABit(1000);
    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	
    	waitForElementX("//a[@class='dynatree-title']//div[contains(text(),'"+i+ccoName+"1"+"')][1]",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	if(isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+i+ccoName+"1"+"')][1]"))){
    		
    		Log.info("Enhanced Deep Copy for CCO Successful");
			
    	}
    	else{
    		Log.info("Enhanced Deep Copy for CCO not Successful");
    		
    	}
    	
    	
    	/// for CO
    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
    	clickOnAnElementInTheSequenceView(i+ccoName+"1");
    	expandAllButton.click();
    	waitABit(1000);
    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	waitForElementX("//a[@class='dynatree-title']//div[text()='"+i+coName+"1"+"'][1]",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	
    	if(isElementVisible(By.xpath("//a[@class='dynatree-title']//div[text()='"+i+coName+"1"+"'][1]"))){
    		
    		Log.info("Enhanced Deep Copy for CO Successful");
			
    	}
    	else{
    		Log.info("Enhanced Deep Copy for CO not Successful");
    		
    	}
    	WebElement clickCO= getDriver().findElement(By.xpath("//a[@class='dynatree-title']//div[text()='"+i+coName+"1"+"'][1]"));
    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
    	if(isElementVisible(By.xpath("//a[@class='dynatree-title']//div[text()='"+i+coName+"1"+"'][1]"))) {
	    	
	    	waitABit(1000);
	    	clickCO.click(); 
	    	}
	    	else {
	    		Log.info("Object not identified");
	    	}
	    
    	expandAllButton.click();
    	waitABit(1000);
    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	waitForElementX("//a[@class='dynatree-title']//div[text()='"+i+assetName+"1"+"'][1]",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
    	if(isElementVisible(By.xpath("//a[@class='dynatree-title']//div[text()='"+i+assetName+"1"+"'][1]"))){
    		
    		Log.info("Enhanced Deep Copy for Asset Successful");
			
    	}
    	else{
    		
    		Log.info("Enhanced Deep Copy for Asset not Successful");
    		
    		
    	}
    	

	}
	
    public void createPOinPS(int noOfLevels, String psObjName,String poName){

    	for(int i = 1;i<=noOfLevels;i++){
			
			Actions action = new Actions(getDriver());				
			waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
			waitABit(2000);
	    	clickOnAnElementInTheSequenceView(psObjName);
	    	expandAllButton.click();
	    	waitABit(1000);
	    	waitForElement("button[id*='default-createContent-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	boolean isFound = isElementVisible(By.xpath("//a[@class='dynatree-title']//div[contains(text(),'"+poName+i+"')][1]"));
	    	System.out.println(isFound);
	    	if(isFound==false){
		        createNewContent("Product Object");
		    //	createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		    	waitABit(3000);
		    	nameInput.sendKeys(poName+i);
		    	displayTitle.sendKeys(poName+i);
		    	savebuttonsq.click();
    		}
	    	waitForAngularRequestsToFinish();
	    	waitABit(2000);
	    	refreshPage();
	    	waitForElement("button[id*='expand-all-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	    	expandAllButton.click();
	    	waitForAngularRequestsToFinish();
	    	waitForListToLoad(this.galleryViewItems, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, true);
	    	clickOnAnElementInTheSequenceView(poName+i);
	    	expandAllButton.click();
    	}
    	

    }
    public void saveButtonClick()
	{
    	this.element(this.savebtn).waitUntilVisible();
		/*WebElement save= getDriver().findElement(By.xpath(".//button[text()='Save']"));
		
		waitForElementX(".//button[text()='Save']",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());*/
		savebtn.click();
		
	}
    
}
