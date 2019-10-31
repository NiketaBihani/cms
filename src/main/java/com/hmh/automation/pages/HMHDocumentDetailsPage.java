package com.hmh.automation.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.fluentlenium.core.Alert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.hmh.automation.tools.AbstractBaseSiteTest;
import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.alfresco.DocumentDetailsPage;

public class HMHDocumentDetailsPage extends DocumentDetailsPage {
	public HMHDocumentDetailsPage(final WebDriver driver) {
		super(driver);
	}
	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTest.class);

	
	
	@FindBy(xpath = "*//input[@value='StructureAndPages']")
	private WebElement StructureAndPages;
	
	@FindBy(xpath = "*//input[@value='Assets']")
	private WebElement Assets;

	
	
	@FindBy (xpath= "//button[contains(text(),'OK')]")
	private WebElement habitatBeforePullOK;
	
	@FindBy(css = "div.create-reference-from a span")
	private WebElement manageReferencesActionLink;

	@FindBy(css = "button[id *='references-cntrl-ok-button']")
	private WebElement applyReferenceButton;

	@FindBy(css = "div[id*='cntrl-picker-right'] tbody[class$='message'] div")
	private WebElement emptyReferences;
	
	@FindBy(css = "div.create-content div.bd ul li a")
	private List<WebElement> contentToCreateList;

	@FindBy(css = "div[id $= 'references-cntrl-picker-right'] tr[class *= 'dt-rec']")
	private List<WebElement> selectedReferencesList;

	@FindBy(xpath = "//div[contains(text(),'Derived From ')]")
	private WebElement derivedFromLabel;

	@FindBy (css= "div[class*='current-version'] a[class*='publish-manifest']")
    public WebElement publishManifest;

	@FindBy(css = "div[id*='formContainer_assoc_cm_original'] span a")
	private WebElement originalObject;

	@FindBy(css = "a[title *='Delete Object'] span")
	private WebElement deleteObjectLink;

	@FindBy(css = "div[id='message'] > div.bd > span[class='message']")
	private WebElement deleteObjectNotPossibleMessage;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement deleteObjectConfirm;

	@FindBy(css = "div[id *='references-cntrl-picker-selectedItems'] table")
	private WebElement targetReferencesEmpty;

	@FindBy(css = "div.create-reference-to a span")
	private WebElement outgoingReferences;

	@FindBy(css = "h2[id*='relationships']")
	private WebElement relationsDropButton;

	@FindBy(xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a")
	private List<WebElement> referenceList;

	@FindBy(xpath =".//*[@id='onActionManageAspects']/a/span")					// css = "div.document-manage-aspects > a span" xpath =".//*[@id='onActionManageAspects']/a/span")
	private WebElement manageAspectsButtonDocumentActions;

	@FindBy(xpath =" .//*[@class='action-set']/div/a/span[contains(text(),'Aspects')]")					// css = "div.document-manage-aspects > a span" xpath =".//*[@id='onActionManageAspects']/a/span")
	private WebElement actionsonDocumentDetails;

	@FindBy(css = "//h3[@id='relationships_element_title_2']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a")
	private List<WebElement> correlations;

	@FindBy (xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a")
	private WebElement referencesListXpath;

	@FindBy(xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a")
	private WebElement correlationsList;

	@FindBy(css = "div[id*='default-formContainer'] span.viewmode-label") ////div[@id='default-formContainer']//span[@class='viewmode-label']
	private List<WebElement> propertiesLabelList;

	@FindBy(css = "div[id*='default-formContainer'] span.viewmode-value")
	private List<WebElement> propertiesValuesList;

	@FindBy(css = "div[id*='folder-details'] div[id$='olderVersions'] span.document-version")
	private WebElement oldVersion;
	
	@FindBy(css = "div[id*='folder-details'] div[id$='latestVersion'] span.document-version")
	private WebElement latestVersion;

	@FindBy(css = "div[id*='document-details'] div[id$='latestVersion'] span.document-version")
	private WebElement latestVersionDocument;

	@FindBy(css = "div[id$='default-formContainer'] span.viewmode-value")
	private List<WebElement> propertiesValueList;

	@FindBy(css = "button[id*='createContent-button-button']")
	private WebElement createButton;

	@FindBy(css = "div.create-content div.bd ul li a span.hmh-learning-object-file")
	private WebElement createLearningObject;

	@FindBy (css = "div[class$='version'] a span")
	private WebElement versionButton;

	@FindBy (css = "div[class$='doclist'] a[title*='Snapshot'] span")
	private WebElement generateSnapshot;

	//Habitat Elements

	@FindBy (css = "div[id*=onActionPushToHabitat]")  //div.publish-to-habitat a span || div[id*='habitat'] a[title *='Push to Habitat'] span  || div[class$='Push To Habitat'] a span
	private WebElement pushToHabitat;

	@FindBy (css= "div span[id*='yui-gen23'] span button[id*='yui-gen23-button']")  
	private WebElement habitatpushOK;

	@FindBy(css = "div.set-bordered-panel-body span.viewmode-label") // div.set-bordered-panel-body span ||
	private List<WebElement> habitatMetaDataProperty;

	@FindBy(css = "div.set-bordered-panel-body span.viewmode-value") // div.set-bordered-panel-body span ||
	private List<WebElement> habitatMetaDataValue;

	@FindBy (xpath = ".//*[@id='template_x002e_folder-metadata_x002e_folder-details_x0023_default-formContainer-form-fields']/div[10]/div/div[1]")
	private WebElement habitatMetaDataText;

	@FindBy (css = "div.pull-habitat a")  //div.pull-habitat a span
	private WebElement habitatPull;

	@FindBy (css = "div.bd div.set legend")  //div.set legend  div.bd div.set legend
	private WebElement habitatPullLoginLegend;

	@FindBy (css= "div.form-fields label")   //
	private WebElement habitatLoginTitles;

	@FindBy (xpath= "*//input[@name='pullUserName']")   //
	private WebElement habitatUSERInput;

	@FindBy (xpath= "*//input[@name='pullPassword']")   //
	private WebElement habitatPWDInput;

	@FindBy (xpath= "//button[contains(text(),'OK')]")
	private WebElement habitatPullOK;

	@FindBy (css= "div[id*='form-buttons']>span>span>button[id*='submit-button']")
	private WebElement habitatPullSubmit;

	@FindBy(css = "div[id*='folder-details'] div[id$='latestVersion'] span.document-version")
	private WebElement isPublishedtoHabitat;
		
	@FindBy(css="span[id*='form-submit']>span.first-child>button[id*='submit']")
	WebElement repeatPushOK;

	@FindBy(css="span[id*='form-cancel']>span.first-child>button[id*='cancel']")
	WebElement repeatPushCancel;

	//Publish
	@FindBy (css= "div[class*='current-version']")
	public WebElement currentVersionSection;

	@FindBy (css= "div[class*='current-version'] span.actions a")
	public List<WebElement>  publishActions;

	@FindBy (css= "div[class*='current-version'] a[class*='publish-draft']") //div[class*='current-version'] span.actions a[class*='publish-draft']
	public WebElement publishDraft;
	
	@FindBy (css= "div[class*='current-version'] a[class*='publish-qa']")
	public WebElement publishQA;
	
	@FindBy (css= "div[class*='current-version'] a[class*='publish-content']")
	public WebElement publishContent;

	@FindBy (css= "div[class*='current-version'] a[class*='publish-prod']")
	public WebElement publishProd;

	@FindBy(css = "div[class *= 'version-list']")
	public List<WebElement> versionHistoryContainerList;

	@FindBy(css="span button[id*='cancel']")
	public WebElement cancelReferenceDailog;

	@FindBy(xpath = ".//*[@class='current-version version-list']/div[2]/span/a[1]")
	public WebElement publishDraftXpath;
	String versionUserCssSelector = "div.version-details-right > a";

	@FindBy(linkText = "Edit Properties" )
	private WebElement editPropertiesDetails;
	
	@FindBy(xpath = ".//*[@id='yui-gen260-button']")
	public WebElement pushToHabSubmit;

	@FindBy(linkText = "Edit Sequence")
	private WebElement editsequence;

	@FindBy(css = "div[id$='onActionEditSequence'] a span")
	private WebElement editSequence;

	@FindBy(css = "div[id$='onActionLinkToPSF']>a>span")
	private WebElement showPSF;

	@FindBy (css="div.node-path span:nth-child(3) a")
	WebElement nodePathSecondLvl;

	@FindBy(name = "username")
	private WebElement userInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(css = "button[id*='submit-button']")
	private WebElement loginButton;

	@FindBy(xpath="//div[contains(@class,'form-field')]//span[contains(.,'Manifest URL')]/following-sibling::span")
	WebElement manifestValue;
	
	@FindBy (css="div[id$='onActionAddContentToCart']>a>span")
	WebElement addToStandardsCartButtonDocumentActionsClick;
	
	@FindBy(partialLinkText = "Standards Correlation Cart")
	WebElement StandardsCorrelationCart;
	
	//Version Pop Up
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement saveVersionPopup;
	
	@FindBy(css="textarea[id$='comment']")
	public WebElement commentVersionPopup;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement cancelVersionPopup;

	//Delivery Location
	
	@FindBy (xpath= ".//*/a[contains(text(),'/Sequence Bundles/SB')]")
	public WebElement deliveryLocation;
	
	//Generate Metadata Report
	@FindBy (xpath= "//span[contains(text(),'Generate Metadata Report')]")
	public WebElement generateMetadataReport;
	
	//Download Metadata Report
	@FindBy (xpath= "//*[@id='onActionEventAudit']/a/span")
	public WebElement downloadMetadataReport;
	
	@FindBy(xpath =".//*[@id='onActionEventAudit']/a/span")					// css = "div.document-manage-aspects > a span" xpath =".//*[@id='onActionManageAspects']/a/span")
	private WebElement downloadButton;
	
	//push habitat
    @FindBy (css= " div[id='onActionPushToHabitat']")
    public WebElement pushToHabitat_link;
    
    @FindBy(css = "div[id*=onActionCreateCCOFrom]")
	private WebElement copyHabitatCCOlink;
    
    @FindBy (css= " input[id='userName']")
    public WebElement pushToHabitat_Username;
    
    @FindBy (css= "  input[id='password']")
    public WebElement pushToHabitat_Password;
    
    @FindBy (css= "div span[class*='push-button default']")
    public WebElement pushToHabitat_submitbtn;
    
    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    private WebElement pushToHabitat_cancelbtn;
    
    // Warning message on Push to Habitat POP Up
    @FindBy(xpath = ".//*[@id='prompt']/div[2]/div[1]")
    private WebElement verifyWarningMsg;
    
    @FindBy(xpath = ".//*[@value='StructureAndAssets']")
    private WebElement selectRadiobuttonOnPopUp;
    
    @FindBy(xpath = ".//*[text()='OK']")
    private WebElement clickOkbuttonOnPopUp;
    
    @FindBy(xpath = "(.//*/a[@target='_parent'])[2]")
    private WebElement clickOutRef;
       
    @FindBy(xpath = "(.//*[@name='.onRevertVersionClick'])[2]")
    private WebElement revertButton;
    
    @FindBy(xpath = ".//*[@id='alfresco-revertVersion-instance-contentMetadata-radioButton']")
    private WebElement revertContentAndMetadataRadio;
    
    @FindBy(xpath = ".//*[@id='alfresco-revertVersion-instance-contentOnly-radioButton']")
    private WebElement revertContentRadio;
    
    @FindBy(xpath = ".//*[@id='alfresco-revertVersion-instance-minorVersion-radioButton']")
    private WebElement uploadNewMinorVersionDocDetails;
    
    @FindBy(xpath = ".//*[@name='majorVersion']")
    private WebElement uploadNewMajorVersionDocDetails;
    
    @FindBy(xpath = ".//*[@id='alfresco-revertVersion-instance-description-textarea']")
    private WebElement addCommentSectionDocDetails;
    
    @FindBy(xpath = ".//*[@id='alfresco-revertVersion-instance-ok-button-button']")
    private WebElement uploadOkButtonDocDetails;
    
    @FindBy(xpath = ".//*[@id='onActionAssociateLearningspine']/a/span")
    private WebElement associateLearningSpine;
    
    @FindBy(xpath = ".//*[@id='saveBtn-button']")
    private WebElement saveAssociatedLearningSpine;
    
    @FindBy(xpath = ".//*[@id='skillcorrelationcontent']//td[1]//ul//li")
    private WebElement viewAssociatedLearningSpine;
    
    @FindBy(xpath = ".//*[@id='associationContent']//table/tbody/tr[1]/td/ul/li")
    private WebElement viewAssociateLearningSpine;
    
    
    @FindBy(xpath = ".//*[@id='labelAccordion-1-label']")
    private WebElement labelLearningSpine;
    
    @FindBy(xpath = "(.//*[text()='Learning Skill Correlations'])[1]")
    private WebElement labelLearningCorrelation;
    
    @FindBy(xpath = ".//*[@id='labelAccordion-2-label']//span")
    private WebElement expandLearningCorrelation;
      
    @FindBy(xpath = ".//*[@id='associationContent']//td[2]/a/img")
    private WebElement deleteAssociatelearningSpine;
    
    @FindBy(xpath = ".//button[text()='Ok']")
    private WebElement deleteOkAssociatelearningSpineButton;
    
    @FindBy(xpath = ".//*[@id='copyLabel']")
    private WebElement selectCopyHabitatCCO;
    
    @FindBy(xpath = ".//button[text()='Copy']")
    private WebElement copyHabitatCCOButton;
       
    @FindBy(xpath = ".//*[@id='copyLabel']/option")
    private WebElement selectCopyHabitatCCOOption;
      
    @FindBy(xpath = ".//*[text()='Audit History']")
    private WebElement auditHistory;
    
    @FindBy(xpath = ".//*[@id='saveBtn-button']")
    private WebElement okButtonAuditHistory;
    
    @FindBy(xpath = ".//div[@class='yui-panel-container yui-dialog shadow']//button[contains(@id,'saveBtn-button')]")
    private WebElement okButton; 
    
    @FindBy(xpath = "(.//div[@class='yui-panel-container yui-dialog yui-simple-dialog shadow']//button)[2]")
    private WebElement okButtonOnPopUp;
    
    @FindBy(xpath = ".//*[@id='onActionAddAssetsSingle']/a/span")
    private WebElement addCollectionAction;
    
    @FindBy(xpath = ".//*[@id='r1'][@value='CNC']")
    private WebElement addNewCollectionradioButtonClick;
    
    @FindBy(xpath = ".//*[@id='r2'][@value='ATEC']")
    private WebElement addExistingCollectionradioButtonClick;
    
    @FindBy(xpath = ".//*[@id='template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-editDetails-alf-id13_prefix']")
    private WebElement addCollectionNameTextBox;
    
    @FindBy(xpath = "(.//*[@class='button-group']/span//button)[1]")
    private WebElement addToCollectionButton;
    
    @FindBy(xpath = ".//a[text()='My Collections']")
    private WebElement myCollection;
    
    @FindBy(xpath = ".//a[text()='PDF Reports']")
    private WebElement pdfReportFolderClick;
   
    @FindBy(xpath = ".//*[@id='onActionGeneratePDFReport']/a/span")
    private WebElement clickOnGeneratePDFAction;
      
    @FindBy(xpath = ".//span[@class='onActionGeneratePDF']")
    private WebElement clickOnGeneratePDFActionOnAsset;
    
    @FindBy(xpath = ".//*[@id='template_x002e_web-preview_x002e_document-details_x0023_default-viewer-pageContainer-1']/div[2]/div[1]")
    private WebElement verifyAsset1OnGeneratedPDF;
    
    @FindBy(xpath = ".//*[@id='template_x002e_web-preview_x002e_document-details_x0023_default-viewer-pageContainer-2']/div[2]/div")
    private WebElement verifyAsset2OnGeneratedPDF;
    
    @FindBy(xpath = ".//*[@id='template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-editDetails-alf-id13_copyPath']")
    private WebElement selectCollection;
    
    @FindBy(xpath = ".//span[text()='Manage Aspects']")
    private WebElement clickManageAspectAction;
    
    @FindBy(xpath = ".//h3[text()='Time Stamped Folder YYYY-MM-dd']/following::td[1]")
    private WebElement selectTimestampAspect;
    
    @FindBy(xpath = ".//button[text()='Apply changes']")
    private WebElement applyChangesButtonOnManageAspect;
    
    @FindBy(xpath = ".//a[@name='.onGenerateReportClick']")
    private WebElement clickQAReport;
    
   
    
	private String referencesListXpathSelector = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a";
	private String referencesNamesCssSelector = " h3 a";
	private String referenceAvailableListCssSelector = "div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec']";
	private String folderReferenceAvailableListCssSelector = "div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec'] h3>a";

	private String correlationListXpathSelector = "//h3[@id='relationships_element_title_2']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a";
	private String corrleatedItemsListXpathSelector = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'Correlation')]/div[@class='divCell']//a";
	private String relationTwisterCssSelector = "div[class='document-details-panel'] h2[class*='thin dark alfresco-twister alfresco-twiste']";


	public void outgoingReferencesClick() {
		waitForAngularRequestsToFinish();
		waitForElement("div.create-reference-to a span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(outgoingReferences).waitUntilVisible();
		outgoingReferences.click();
		waitForElement("button[id *='references-cntrl-ok-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
	}

	
	public void outgoingReferencesLinkClick() {
		waitForAngularRequestsToFinish();
		waitForElementX("(.//*/a[@target='_parent'])[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(clickOutRef).waitUntilVisible();
		clickOutRef.click();
	}
	
	public void checkCorrelationIsVisible(final String correlationName) {
		Boolean found = false;
		if (correlationsList.getText().contains(correlationName)) {
			found = true;
			correlationsList.click();
		}
		Assert.assertTrue("The correlation was not found", found);
	}

	public void clickOnReference(final String referenceName) {
		boolean found = false;
		waitForPageToLoadCompletely(300);
		String status = "";
		WebElement relationTwister = getDriver().findElement(
				By.cssSelector(relationTwisterCssSelector));
		status = relationTwister.getAttribute("class");
		if (status.contains("closed")) {
			relationsDropButton.click();
		}

		waitForAngularRequestsToFinish();
		waitABit(5000);
		waitForRenderedElementsToBePresent(By.xpath(referencesListXpathSelector));
		Serenity.takeScreenshot();

		for (WebElement reference : referenceList) {
			//        for (WebElement reference : getDriver().findElements(By.xpath(referencesListXpathSelector))) {
			System.out.println("References List: " + reference.getText());
			if (reference.getText().toLowerCase().contains(referenceName.toLowerCase())) {
				reference.click();
				found = true;
				break;
			}
		}
		Assert.assertTrue("The reference was not found", found);
	}

	public void checkIfStandardWasCorrelatedToItemAndClickOnIt(String itemName) {
		boolean found = false;
		relationsDropButton.click();
		//        relationsDropButton.click();
		relationsDropButton.click();
		waitForAngularRequestsToFinish();
		waitABit(5000);
		waitForRenderedElementsToBePresent(By.xpath(corrleatedItemsListXpathSelector));
		Serenity.takeScreenshot();

		for (WebElement item : getDriver().findElements(By.xpath(corrleatedItemsListXpathSelector))) {
			//        for (WebElement reference : getDriver().findElements(By.xpath(referencesListXpathSelector))) {
			System.out.println("Correlated Items  List: " + item.getText());
			if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
				item.click();
				found = true;
				break;
			}
		}
		Assert.assertTrue("The reference was not found", found);
	}

	//    correlationListXpathSelector

	@FindBy (xpath="//*[@id='template_x002e_web-preview_x002e_document-details_x0023_relationships-list-myelement2']//div/div[2]/a")
	private WebElement fCorrelationListXpathSelector;

	@FindBy (css ="div.relationships-outgoing > relationships-element > div.relationships-element-type-table > div.divCell > a") //div.relationships-outgoing > relationships-element > div.relationships-element-type-table > div.divCell:nth-child(3) > a:nth-child(2)
	private WebElement fCorrelationListCSSSelector;

	public void clickOnCorrelation(final String correlationName) {
		boolean found = false;
		waitForPageToLoadCompletely(600);
		String status = "";

		WebElement relationTwister = getDriver().findElement(
				By.cssSelector(relationTwisterCssSelector));

		status = relationTwister.getAttribute("class");

		System.out.println("Status check: " + status);

		if (status.contains("closed")) {
			relationsDropButton.click();
		}

		//        relationsDropButton.click();
		waitForAngularRequestsToFinish();
		waitABit(5000);
		//     waitForRenderedElementsToBePresent(By.xpath(correlationListXpathSelector));

		for (WebElement correlation : getDriver().findElements(By.xpath(correlationListXpathSelector))) { //*Removed webList
			//        for (WebElement reference : getDriver().findElements(By.xpath(referencesListXpathSelector))) {

			if (correlation.getText().toLowerCase().trim().contains(correlationName.toLowerCase().trim())) {
				System.out.println("  Correlation List: " + correlation.getText());
				found = true;
				correlation.click();
			}
		}
		Assert.assertTrue("The correlation was not found", found);

	}

	public void checkObjectCanNotBeDeleted(final String message) {
		//boolean found = false;
		//WebElement name = getDriver().findElement(By.xpath("//span[contains(text(), '"+message+"')]")); 
		waitForElementX("//span[contains(text(), '"+message+"')]", 30, getDriver());
		/*String actualText=name.getText().toLowerCase();
		System.out.println(actualText);
		if (actualText.contains(message.toLowerCase())) {
			found = true;
		}

		if(found==false){
			deleteObject();
			found=true;
		}
*/
//		Assert.assertTrue("The object with the reference was deleted!!", found);
	}

	public void deleteObject() {
		waitForElement("a[title*='Delete Object'] span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(deleteObjectLink).waitUntilVisible();
		deleteObjectLink.click();
		element(deleteObjectConfirm).waitUntilVisible();
		deleteObjectConfirm.click();
		System.out.println("Delete the Object Action");
	}
	public void selectReferenceFolder(final String folderName ) {
		boolean found = false;
		waitForAngularRequestsToFinish();
		waitABit(5000);
		waitForRenderedElementsToBePresent(By.cssSelector(folderReferenceAvailableListCssSelector));
		Serenity.takeScreenshot();

		for (WebElement folderaspect : getDriver().findElements(By.cssSelector(folderReferenceAvailableListCssSelector))) {
			System.out.println(folderaspect.getText());
			element(folderaspect).waitUntilVisible();

			if (folderaspect.getText().toLowerCase().contains(folderName.toLowerCase())) {
				WebElement clickFolder = folderaspect.findElement(By.cssSelector("div[id $= 'references-cntrl-picker-left'] tr[class *= 'dt-rec'] h3>a"));
				found = true;
				clickFolder.click();
				Serenity.takeScreenshot();
				break;
			}
		}
		Assert.assertTrue("The reference folder was not found", found);
		//  applyReferenceButton.click();
	}
	public void clickItemInReferencesPane(final String itemName) {
		boolean found = true;
		waitForAngularRequestsToFinish();
		waitABit(5000);
		waitForRenderedElementsToBePresent(By.cssSelector(referenceAvailableListCssSelector));
		Serenity.takeScreenshot();
		for (WebElement aspect : getDriver().findElements(By.cssSelector(referenceAvailableListCssSelector))) {
			System.out.println(aspect.getText());
			element(aspect).waitUntilVisible();
			if (aspect.getText().toLowerCase().contains(itemName.toLowerCase())) {
				WebElement navigate = aspect.findElement(By.cssSelector(referencesNamesCssSelector));
				found = true;
				navigate.click();
				Serenity.takeScreenshot();
				break;
			}
		}
		Assert.assertTrue("The reference was not found", found);

	}

	public void selectReference(final String referenceName) {
		boolean found = false;
		waitForAngularRequestsToFinish();
		waitABit(5000);
		waitForRenderedElementsToBePresent(By.cssSelector(referenceAvailableListCssSelector));
		Serenity.takeScreenshot();

		for (WebElement aspect : getDriver().findElements(By.cssSelector(referenceAvailableListCssSelector))) {
			System.out.println(aspect.getText());
			element(aspect).waitUntilVisible();
			if (aspect.getText().toLowerCase().contains(referenceName.toLowerCase())) {
				WebElement addB = aspect.findElement(By.cssSelector("td > div > a > span.addIcon"));
				found = true;
				addB.click();
				waitABit(2000);
				Serenity.takeScreenshot();
				break;
			}
		}
		Assert.assertTrue("The reference was not found", found);
		waitABit(1000);
		applyReferenceButton.click();
	}


	public void clickOnManageReferenceLink() {
		waitForAngularRequestsToFinish();
		waitForElement("div.create-reference-from a span", 300, getDriver());
		element(manageReferencesActionLink).waitUntilVisible();
		manageReferencesActionLink.click();
		waitForElement("button[id *='references-cntrl-ok-button']", 300, getDriver());
	}

	public void checkIfReferenceWasAdded(final String itemName) {
		boolean found = false;
		waitForAngularRequestsToFinish();
		waitABit(3000);

		List<WebElement> listOfReferences = getDriver().findElements(By.cssSelector("div[id $= 'references-cntrl-picker-right'] tr[class *= 'dt-rec'] td[class*='col-name'] div h3"));

		for (WebElement ref : listOfReferences) {
			element(ref).waitUntilVisible();
			if (ref.getText().toLowerCase().trim().contains(itemName.toLowerCase().trim())) {
				found = true;
				LOG.info(itemName+"Reference found");
				break;

			}
		}
		Assert.assertTrue("The asset was not found", found);

	}

	public void cancelReferenceDailog() {

		cancelReferenceDailog.click();
	}

	public void deleteReference(final String itemName) {
		boolean found = false;
		waitForAngularRequestsToFinish();
		waitABit(3000);
		waitForListToLoad(this.selectedReferencesList, 15, true);
		for (WebElement aspect : selectedReferencesList) {
			element(aspect).waitUntilVisible();
			WebElement remove = aspect.findElement(By.cssSelector("td > div > a > span.removeIcon"));
			if (aspect.getText().toLowerCase().contains(itemName.toLowerCase())) {
				found = true;
				remove.click();
				break;
			}
		}
		Assert.assertTrue("The asset was not found", found);
		applyReferenceButton.click();
	}

	public void checkIfTheReferencesAreRemoved() {
		boolean empty = false;
		waitForAngularRequestsToFinish();
		element(emptyReferences).waitUntilVisible();
		if (emptyReferences.getText().contains("No items selected")) {
			empty = true;
		}
		Assert.assertTrue("the refenreces list is not empty", empty);
	}

	public void checkDerivedFrom(final String object) {
		boolean found = true;
		element(derivedFromLabel).waitUntilVisible();
		if (originalObject.getText().toLowerCase().contains(object.toLowerCase())) {
			found = true;
		}
		Assert.assertTrue("The derived from object is not displayed", found);
	}

	public void checkIfIncomingReferenceWasAddedOld(String referencedItem) {
		boolean found = false;
		waitForPageToLoadCompletely(300);
		waitABit(5000);
		String status = "";
		WebElement relationTwister = getDriver().findElement(
				By.cssSelector(relationTwisterCssSelector));
		status = relationTwister.getAttribute("class");
		LOG.info("here it comes");

		if (status.contains("closed")) {
			relationsDropButton.click();
			waitABit(5000);
		}

		Serenity.takeScreenshot();
		for (WebElement reference : referenceList) {
			System.out.println("References List: " + reference.getText());
			if (reference.getText().trim().toLowerCase().contains(referencedItem.trim().toLowerCase())) {
				found = true;
				break;
			}
		}
		Assert.assertTrue("The reference was not found", found);
	}


	@FindBy(xpath = "//h3[@id='relationships_element_title_1']/following-sibling::div[contains(.,'References')]/div[@class='divCell']//a")
	private WebElement referenceSingle;

	public void checkIfIncomingReferenceWasAdded(String referencedItem) {
		boolean found = false;
		waitForPageToLoadCompletely(600);
		waitForAngularRequestsToFinish();
		waitABit(5000);
		String status = "";
		WebElement relationTwister = getDriver().findElement(
				By.cssSelector(relationTwisterCssSelector));
		status = relationTwister.getAttribute("class");
		LOG.info("here it comes");

		if (status.contains("closed")) {
			relationsDropButton.click();
			waitABit(5000);
		}

		Serenity.takeScreenshot();

		if (referenceSingle.getText().trim().toLowerCase().contains(referencedItem.trim().toLowerCase())) {
			found = true;
		}

		Assert.assertTrue("The reference was not found", found);
	}

	public void checkIfOutgoingReferenceWasAdded(String referencedItem) {
		boolean found = false;
		waitForAngularRequestsToFinish();
		String status = "";
		WebElement relationTwister = getDriver().findElement(
				By.cssSelector(relationTwisterCssSelector));
		status = relationTwister.getAttribute("class");
		if (status.contains("closed")) {
			relationsDropButton.click();
		}
		waitForAngularRequestsToFinish();
		waitABit(5000);
		waitForRenderedElementsToBePresent(By.xpath(referencesListXpathSelector));
		Serenity.takeScreenshot();

		for (WebElement reference : referenceList) {
			System.out.println("References List: " + reference.getText());
			if (reference.getText().toLowerCase().contains(referencedItem.toLowerCase())) {
				found = true;
				break;
			}
		}
		Assert.assertTrue("The reference was not found", found);
	}
	public void verifyHMHPropertyValue(final String propertyName,
			final String propertyValue) {
		boolean match = false;
		for (int i = 0; i < propertiesLabelList.size(); i++) {
			if (propertiesLabelList.get(i).getText().contains(propertyName)) {
				if (propertiesValuesList.get(i).getText().contains(propertyValue)) {
					match = true;
					break;
				}
			}
		}

		Assert.assertTrue(String.format(
				"The value of document '%s' property is '%s'!", propertyName,
				propertyValue), match);
	}

	public void checkLatestVersion(String version) {
		boolean latestVersionCorrect = false;
		waitForElement("div[id*='folder-details'] div[id$='latestVersion'] span.document-version", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(latestVersion).waitUntilVisible();
		if (latestVersion.getText().contains(version)) { //if (latestVersion.getText().equalsIgnoreCase(version)) {
			latestVersionCorrect = true;
			System.out.println("The latest version has been found as:"+latestVersion.getText());
		}
		Assert.assertTrue("The latest version is not correct", latestVersionCorrect);
	}

	public boolean returnLatestVersion(String version) {
		boolean latestVersionCorrect = false;
		waitForElement("div[id*='folder-details'] div[id$='latestVersion'] span.document-version", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(latestVersion).waitUntilVisible();
		if (latestVersion.getText().contains(version)) { //if (latestVersion.getText().equalsIgnoreCase(version)) {
			latestVersionCorrect = true;
		}
		return latestVersionCorrect;
	}
	@FindBy(id="document-version")
	private WebElement documentVersion;
	
	
	@FindBy(xpath="(.//*/a[@class='theme-color-1'][1])[2]/..")
	private WebElement versionText;
	
	
	
	
	public void checkLatestVersionDoc(String version) {
		boolean latestVersionDocCorrect = false;
		waitForElementID("document-version", 500, getDriver());
		element(documentVersion).waitUntilVisible();
		if (documentVersion.getText().contains(version)) { //if (latestVersion.getText().equalsIgnoreCase(version)) {
			latestVersionDocCorrect = true;
		}
		Assert.assertTrue("The latest version is not correct", latestVersionDocCorrect);
	}

	public void waitUntilLatestVersionUpdated(String version) {
		waitForElement("div[id*='folder-details'] div[id$='latestVersion'] span.document-version", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(latestVersion).waitUntilVisible();
		waitABit(5000);
		String lat=latestVersion.getText();
		boolean notFound=false;
		
		//********* Fixed on 13/7/2018 (Sprint 7.3.1)********
		
		System.out.println("Latest version is:"+lat);	
		if(lat.contains(version))
		{
			LOG.info("Latest version has been found : 2.0");
		}
		else
			Assert.assertTrue("The Latest Version not updated in 5 Minutes/ latest version is incorrect", notFound);}
				/* **** FIX **** */
				
				/*String oldversion= oldVersion.getText();
				double oldversionConvert=Double.parseDouble(oldversion);
				oldversionConvert++;
				String currentVersion=""+oldversionConvert;
				int counter =0;
		
				while( (!done) && (counter <30)){
					waitForElement("div[id*='folder-details'] div[id$='latestVersion'] span.document-version", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
					//getDriver().navigate().refresh();
					
					if(latestVersion.getText().contains(currentVersion)){
					LOG.info("Latest version is " +currentVersion);
						done=true;
						break;
					}
		
					waitABit(3000);
					counter++;
					refreshPage();
				}*/
			
	
	public void checkLatestVersionText(String version) {
		boolean latestVersionDocCorrect = false;
		waitForElementX("(.//*/a[@class='theme-color-1'][1])[2]/..", 500, getDriver());
		//element(documentVersion).waitUntilVisible();
		System.out.println(versionText.getText());
		if (versionText.getText().contains(version)) { //if (latestVersion.getText().equalsIgnoreCase(version)) {
			latestVersionDocCorrect = true;
		}
		Assert.assertTrue("New Version not displayed", latestVersionDocCorrect);
	}
	
	
	
	public void waitUntilLatestVersionDocUpdated(String version) {
		waitForElementID("document-version", 500, getDriver());
		element(documentVersion).waitUntilVisible();
		boolean done = false;
		int counter =0;
		while( (!done) && (counter <120)){
			if(documentVersion.getText().contains(version)){
				System.out.println("Latest version is " +version);
				done=true;
				break;
			}

			waitABit(5000);
			counter++;
			refreshPage();
		}
		Assert.assertTrue("The Latest Version not updated in 15 Minutes/ latest version of document is incorrect  ", done);
	}    

	public void verifyPropertyValueX(final String propertyName,
			final String propertyValue) {
		waitForPageToLoadCompletely(300);
		boolean match = false;
		for (int i = 0; i < propertiesLabelList.size(); i++) {
			if (propertiesLabelList.get(i).getText().contains(propertyName)) {
				System.out.println(propertiesLabelList.get(i).getText().contains(propertyName));
				if (propertiesValueList.get(i).getText().toLowerCase().trim()
						.contains(propertyValue.toLowerCase().trim())) {
					System.out.println(propertiesValueList.get(i).getText().toLowerCase().contains(propertyValue.toLowerCase()));
					match = true;
					break;
				}
			}
		}
		Assert.assertTrue(String.format("The value of '%s' property is '%s'!", propertyName,
				propertyValue), match);
	}


	String properties ="//div[contains(@class,'form-field')]//span[contains(.,'label')]/following::span[contains(.,'value')]";

	public void verifyPropertyValue(final String propertyName, final String propertyValue)
	{
		waitForElementX("//div[contains(@class,'form-field')]//span[contains(.,'"+propertyName+"')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		By verifyproperty=By.xpath(properties.replace("label", propertyName).replace("value", propertyValue));
		System.out.println(propertyName.toLowerCase());
		System.out.println(propertyValue.toLowerCase());
		Assert.assertTrue(String.format("The value of '%s' property is '%s'!  NOT Matched", propertyName,
				propertyValue), find(verifyproperty).getText().toLowerCase().contains(propertyValue.toLowerCase()));
	}
	
	public void createLOfork12() {
		waitForElement("button[id*='createContent-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(createButton).waitUntilVisible();
		createButton.click();
		createLearningObject.click();
		System.out.println("clicked on Learning Object Button");
	}

	public void clickonVersion() {
		//  element(versionButton).waitUntilVisible();
		waitABit(2000);
		element(versionButton).waitUntilClickable();
		versionButton.click();
		System.out.println("Version");
		waitABit(2000);
	}

	public boolean manageAspectsButtonDocumentActionsClick(By by) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 3) {
			try {
				WebElement assertSelenium = getDriver().findElement(By.cssSelector("div.document-manage-aspects > a span"));
				assertSelenium.click();
				Serenity.takeScreenshot();
				result = true;
				break;
			} 
			catch(StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;

	}

	//	public void manageAspectsButtonDocumentActionsClick() {
	//		
	//		boolean found = false;
	//		for(int i = 1; i<5; i++) {
	//			String locator = String.format("div.document-manage-aspects > a span", i);
	//			WebElement assertSelenium = getDriver().findElement(By.cssSelector(locator));
	//			element(assertSelenium).waitUntilClickable();
	//		//	System.out.println(assertSelenium.getText());
	//			assertSelenium.click();
	//			}
	//		  Assert.assertTrue("The Element Manage Aspects is not found or Stale after 4 Attempts", found);
	//	}

	public void manageAspectsButtonDocumentActionsClick() {
		waitForPageToLoadCompletely(300);
		waitForElementX(".//*[@id='onActionManageAspects']/a/span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(manageAspectsButtonDocumentActions).waitUntilVisible();
		manageAspectsButtonDocumentActions.click();
		waitABit(2000);
		//		waitForPageToLoadCompletely(15);
		//		this.actionsonDocumentDetails.click();
	}

	String manageAspectsButtonDocumentActionsStr = "div.document-manage-aspects > a span";
	public void manageAspectsButtonDocumentActionsClick(String id) {
		boolean result = false;
		int attempts = 0;
		while(attempts < 4 ) {
			try {
				WebElement assertClick = getDriver().findElement(By.cssSelector(id));
				assertClick.click();
				Serenity.takeScreenshot();
				result = true;
				break;
			} 
			catch(StaleElementReferenceException e) {
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				attempts = attempts+1;
			}
		}  
	}

	//pushToHabitat

	public void pushToHabitat() {
		waitForElement("div[id*=onActionPushToHabitat]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(pushToHabitat).waitUntilClickable();
		pushToHabitat.click();
		System.out.println("clicked on PUSH to habitat");
	}
	public void pushToHabitatOK() {
		waitForElement("div span[id*='yui-gen23'] span button[id*='yui-gen23-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		habitatpushOK.click();
		System.out.println("OK: PUSH to habitat");
	}

	//  waitForPush Habitat status

	public void waitUntilPushToHabitatDone() {
		String habitatMetaData ="Yes";
		waitForElement("div[id*='folder-details'] div[id$='latestVersion'] span.document-version", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(latestVersion).waitUntilVisible();
		boolean done = false;
		int counter =0;

		while( (!done) && (counter <30)){
			//getDriver().navigate().refresh();
			for (final WebElement element : habitatMetaDataValue) {
				if(element.getText().contains(habitatMetaData)){
					System.out.println("habitatMetaData Found" +habitatMetaData);
					done=true;
				}
			}
			waitABit(3000);
			counter++;
			refreshPage();
		}
		Assert.assertTrue("The Product Set Failed to Push To Habitat or Habitat metadata not updated in 5 minutes", done);
	}    


	//verifyPushTohabitatStatus

	public void verifyPushTohabitatStatus(final String propertyName,
			final String propertyValue) {
		boolean match = false;
		for (int i = 0; i < habitatMetaDataProperty.size(); i++) {
			if (habitatMetaDataProperty.get(i).getText().contains(propertyName)) {
				if (habitatMetaDataValue.get(i).getText().toLowerCase()
						.contentEquals(propertyValue.toLowerCase())) {
					match = true;
					break;
				}
			}
		}
		Assert.assertTrue(String.format("Result:", propertyName, propertyValue), match);
	}


	public boolean pushTohabitatStatus(final String propertyName,
			final String propertyValue) {
		boolean match = false;
		for (int i = 0; i < habitatMetaDataProperty.size(); i++) {
			if (habitatMetaDataProperty.get(i).getText().contains(propertyName)) {
				if (habitatMetaDataValue.get(i).getText().toLowerCase()
						.contentEquals(propertyValue.toLowerCase())) {
					match = true;
					break;
				}
			}
		}
		System.out.println("pushTohabitatStatus" +match);
		return match;
	}

	public boolean isPushedToHabitat(final String propertyName, final String propertyValue) {
		boolean match = false;
		for (int i = 0; i < habitatMetaDataProperty.size(); i++) {
			if (habitatMetaDataProperty.get(i).getText().contains(propertyName)) {
				if (habitatMetaDataValue.get(i).getText().toLowerCase()
						.contentEquals(propertyValue.toLowerCase())) {
					match = true;
					break;
				}
			}	
		}
		return match;
	}

	public void verifyHabitatIsDisabled(String user) {
		waitForAngularRequestsToFinish();
		waitForPageToLoadCompletely(300);
		Assert.assertFalse("The Habitat options are NOT disabled for "+user, isElementVisible(By.cssSelector("div.publish-to-habitat a")));

	}


	public void clickHabitatPull() {
		waitABit(1000);
		waitForElement("div.pull-habitat a", 300, getDriver() );
		element(habitatPull).waitUntilClickable();
		habitatPull.click();

	}

	public void checkHabitatLoginPopup() {
		boolean legend = false;
		element(habitatPullLoginLegend).waitUntilVisible();
		if (habitatPullLoginLegend.getText().contains("Habitat Login")) {
			legend = true;
		}
		Assert.assertTrue("Habitat Login popup for Pull", legend);
	}

	public void createObjectWhenLoginDetailsAreNotFilled() {
		boolean worksWell = false;
		element(habitatPullOK).waitUntilVisible();
		habitatPullOK.click();
		waitABit(200);
		if (habitatPullOK.isDisplayed()) { //need change
			worksWell = true;
		}
		Assert.assertTrue("The Invalid input message was not displayed", worksWell);

	}
	
	public void habitatPullPopUp() {
		waitABit(1000);
		StructureAndPages.click();
		Assets.click();
		habitatBeforePullOK.click();
		
	}
	
	
	public void habitatLoginForPull(final String habitatUserName, final String habitatPassword ) {
		waitABit(1000);
		//waitForElement("*//input[@name='pullUserName']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		//boolean usernameFound = false;
		//boolean passwordFound = false;

		habitatUSERInput.clear();
		habitatUSERInput.sendKeys(habitatUserName);
		habitatPWDInput.clear();
		habitatPWDInput.sendKeys(habitatPassword);
		boolean submitX=isElementVisible(By.xpath("//button[contains(text(),'OK')]"));
		if(submitX == true){
			habitatPullOK.click();
		}

		//boolean submitCSS = isElementVisible(By.cssSelector("div[id*='form-buttons']>span>span>button[id*='submit-button']"));
		/*if(submitCSS == true){
			habitatPullSubmit.click();
		}
*/
		System.out.println("Successfully Pulled From Habitat");
	}

	//Publish
	public void publishTo(final String option) {         //Draft, QA, Production
		boolean found = false;
		waitABit(3000);
		for (WebElement action : publishActions) {
			element(action).waitUntilVisible();
			if (action.getText().toLowerCase().contains(option.toLowerCase())) {
				found = true;
				action.click();
				break;
			}
		}
		Assert.assertTrue("The Publish to option was not found", found);
	}

	public void publishToDraft() {
		waitForElement("div[class*='current-version'] a[class*='publish-draft']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(publishDraft).waitUntilVisible();
		publishDraft.click();

		if(isElementVisible(By.xpath("//button[contains(text(),'OK')]")))
			getDriver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		waitABit(2000);

	}

	public void publishToContent() {
		waitForElement("div[class*='current-version'] a[class*='publish-content']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(publishContent).waitUntilClickable();
		publishContent.click();
		if(isElementVisible(By.xpath("//button[contains(text(),'OK')]")))
			getDriver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		waitABit(2000);
	}
	
	
	
	public void publishToManifest() {
        waitForElement("div[class*='current-version'] a[class*='publish-content']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
        element(publishManifest).waitUntilClickable();
        publishManifest.click();
        if(isElementVisible(By.xpath("//button[contains(text(),'OK')]")))
               getDriver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();

        waitABit(2000);
 }


	@FindBy(css="span.button-group>span>span>button")
	WebElement notFoundOK;

	public void publishToContentDisabled(String user) {
		waitForAngularRequestsToFinish();
		waitForPageToLoadCompletely(300);
		waitABit(300);
		boolean isPublishEnabled = isElementVisible(By.cssSelector("div[class*='current-version'] a[class*='publish-content']")); //div[class*='current-version'] a[class*='publish-draft']
		if(isPublishEnabled==false){
			clickonVersion();
			for(int i=0; i<10; ++i){
				if((latestVersion.getText().contains("2.0"))){
					break;
				}
				++i;
				refreshPage();
			}
			clickgenerateSnapshot();
			waitABit(5000);
			refreshPage();
		}
		element(publishContent).waitUntilVisible();
		publishContent.click();
		waitABit(200);
		boolean isMessageAppeared=isElementVisible(By.xpath("//span[contains(text(),'Insufficient privileges')]"));
		boolean isContentpublishDisbaled = isElementVisible(By.cssSelector("span.button-group>span>span>button"));
		if (isContentpublishDisbaled == true){
			notFoundOK.click();
		}

		Assert.assertTrue("The Publish to Content is NOT disabled for "+user, isMessageAppeared||isContentpublishDisbaled);

	}
	
	//
	public void publishToQA() {
		waitForElement("div[class*='current-version'] a[class*='publish-qa']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(publishQA).waitUntilClickable();
		publishQA.click();
		if(isElementVisible(By.xpath("//button[contains(text(),'OK')]")))
			getDriver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		waitABit(2000);
	}

	//@FindBy(css="span.button-group>span>span>button")
	//WebElement notFoundOK;

	public void publishToQADisabled(String user) {
		waitForAngularRequestsToFinish();
		waitForPageToLoadCompletely(300);
		waitABit(300);
		boolean isPublishEnabled = isElementVisible(By.cssSelector("div[class*='current-version'] a[class*='publish-qa']")); //div[class*='current-version'] a[class*='publish-draft']
		if(isPublishEnabled==false){
			clickonVersion();
			for(int i=0; i<10; ++i){
				if((latestVersion.getText().contains("2.0"))){
					break;
				}
				++i;
				refreshPage();
			}
			clickgenerateSnapshot();
			waitABit(5000);
			refreshPage();
		}
		element(publishQA).waitUntilVisible();
		publishQA.click();
		waitABit(200);
		boolean isMessageAppeared=isElementVisible(By.xpath("//span[contains(text(),'Insufficient privileges')]"));
		boolean isQApublishDisbaled = isElementVisible(By.cssSelector("span.button-group>span>span>button"));
		if (isQApublishDisbaled == true){
			notFoundOK.click();
		}

		Assert.assertTrue("The Publish to QA is NOT disabled for "+user, isMessageAppeared||isQApublishDisbaled);

	}
	//
	

	public void publishToDraftDisabled(String user) {
		waitForAngularRequestsToFinish();
		waitForPageToLoadCompletely(300);
		waitABit(300);
		boolean isPublishEnabled = isElementVisible(By.cssSelector("div[class*='current-version'] a[class*='publish-content']")); //div[class*='current-version'] a[class*='publish-draft']
		if(isPublishEnabled==false){
			clickonVersion();
			for(int i=0; i<10; ++i){
				if((latestVersion.getText().contains("2.0"))){
					break;
				}
				++i;
				refreshPage();
			}
			clickgenerateSnapshot();
			waitABit(5000);
			refreshPage();
		}
		element(publishDraft).waitUntilVisible();
		waitABit(200);
		publishDraft.click();
		if(isElementVisible(By.xpath("//button[contains(text(),'OK')]")))
			getDriver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		waitABit(200);
		boolean isDraftpublishDisbaled = isElementVisible(By.cssSelector("span.button-group>span>span>button"));

		if (isDraftpublishDisbaled == true){
			notFoundOK.click();
		}

		Assert.assertTrue("The Publish to Draft is NOT disabled for "+user, isDraftpublishDisbaled);

	}

	public void publishToQAEnabled(String user) {
		waitForAngularRequestsToFinish();
		waitForPageToLoadCompletely(300);
		waitABit(300);
		boolean isPublishEnabled = isElementVisible(By.cssSelector("div[class*='current-version'] a[class*='publish-qa']")); //div[class*='current-version'] a[class*='publish-draft']
		if(isPublishEnabled==false){
			clickonVersion();
			for(int i=0; i<10; ++i){
				if(!(latestVersion.getText().contains("1.0"))){ //latest version contains more than 1.0
					break;
				}
				++i;
				refreshPage();
			}
			clickgenerateSnapshot();
			waitABit(5000);
			refreshPage();
		}
		element(publishQA).waitUntilVisible();

	}
	
	//
	public void publishToContentEnabled(String user) {
		waitForAngularRequestsToFinish();
		waitForPageToLoadCompletely(300);
		waitABit(300);
		boolean isPublishEnabled = isElementVisible(By.cssSelector("div[class*='current-version'] a[class*='publish-content']")); //div[class*='current-version'] a[class*='publish-draft']
		if(isPublishEnabled==false){
			clickonVersion();
			for(int i=0; i<10; ++i){
				if(!(latestVersion.getText().contains("1.0"))){ //latest version contains more than 1.0
					break;
				}
				++i;
				refreshPage();
			}
			clickgenerateSnapshot();
			waitABit(5000);
			refreshPage();
		}
		element(publishContent).waitUntilVisible();

	}
	//
	

	public void clickgenerateSnapshot() {

		waitABit(1000);
		element(generateSnapshot).waitUntilClickable();
		generateSnapshot.click();
		System.out.println("Done: SnapShot");
		waitABit(2000);

	}



	public void verifyUsernameForLastVersion(final String username) {
		waitABit(1000);
		element(versionUserCssSelector).waitUntilVisible();
		final WebElement versionUsername = versionHistoryContainerList.get(0)
				.findElement(By.cssSelector(versionUserCssSelector));
		versionUsername.getText().trim().contains(username.trim());
		Assert.assertTrue("Version username is incorrect!", versionUsername
				.getText().contains(username));
	}

	public int getResponseCode(String url) {
		url = getDriver().getCurrentUrl();
		try {
			WebClient client = new WebClient();
			//     client.setThrowExceptionOnFailingStatusCode(false);
			int statusCode = client.getPage(url).getWebResponse().getStatusCode();
			System.out.println(statusCode);	
			return statusCode;
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}   
	}
	public void publishToQAwithResponse() {

		waitABit(1000);
		element(publishQA).waitUntilClickable();
		publishQA.click();
		waitABit(2000);
		String url = getDriver().getCurrentUrl();
		try {
			WebClient client = new WebClient();
			//     client.setThrowExceptionOnFailingStatusCode(false);
			int statusCode = client.getPage(url).getWebResponse().getStatusCode();
			System.out.println(statusCode);	
			//     return statusCode;
		} catch (IOException ioe) {

			throw new RuntimeException(ioe);
		}   

	}
	
	//
	public void publishToContentwithResponse() {

		waitABit(1000);
		element(publishContent).waitUntilClickable();
		publishContent.click();
		waitABit(2000);
		String url = getDriver().getCurrentUrl();
		try {
			WebClient client = new WebClient();
			//     client.setThrowExceptionOnFailingStatusCode(false);
			int statusCode = client.getPage(url).getWebResponse().getStatusCode();
			System.out.println(statusCode);	
			//     return statusCode;
		} catch (IOException ioe) {

			throw new RuntimeException(ioe);
		}   

	}
	//
	public void windowPopup() {

		if (this.outgoingReferences.isDisplayed()) {

			System.out.println("No poupup Found");

		}

		else {
			Alert al = (Alert) getDriver().switchTo().alert();
			al.dismiss();
			System.out.println(((WebElement) al).getText());
		}
	}

	public void clickOnEditPropertiesDetails() {
		waitForPageToLoadCompletely(500);
		element(editPropertiesDetails).waitUntilClickable();
		editPropertiesDetails.click();

	}

	public void clickeditsequence(){
		waitABit(2000);
		waitForElement("div[id$='onActionEditSequence'] a span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(editSequence).waitUntilVisible();
		editSequence.click();
	}


	public void clickOnProgramSupportFolderLink() {
		waitForElement("div[id$='onActionLinkToPSF']>a>span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(showPSF).waitUntilVisible();
		showPSF.click();

	}

	public void checkIfOnProgramSupportFolderDetailsPage(String masterLibFolder) {

		waitForPageToLoadCompletely(300);
		nodePathSecondLvl.getText().contains(masterLibFolder);	 
	}

	public void getCurrentUrl(String oneCMSURLbeforeHabitat) {
		oneCMSURLbeforeHabitat=getDriver().getCurrentUrl();
	}



	public void waitForXpathElementForAjax(final String loactor,int timeout,WebDriver driver){
		waitForAngularRequestsToFinish();
		//	getDriver().manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		new WebDriverWait(driver, timeout){  }.until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {

				return isElementPresentAndDisplay(driver, By.xpath(loactor));
			}

		});

	}

	private static boolean isElementPresentAndDisplay(WebDriver driver, By by) {

		try {               
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public String getManifestURL(){
		String manifest=manifestValue.getText();
		//   **** FIX ****
		String arr[]=manifest.split(",");		
		String manifestQA= arr[0].replace("qa.cms.app.hmhco.com", "10.34.36.46");
		System.out.println(manifestQA);
		return manifestQA;
	}

	public void waitUntilManifestURLisUpdated() {
		waitForElement("div[id*='folder-details'] div[id$='latestVersion'] span.document-version", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean done = false;
		int counter =0;

		while( (!done) && (counter <30)){
			if(isElementVisible(By.xpath("//div[contains(@class,'form-field')]//span[contains(.,'Manifest URL')]/following-sibling::span"))){
				done=true;
				break;
			}

			waitABit(1000);
			counter++;
			refreshPage();
		}
		Assert.assertTrue("The manifest URL is not updated in 5 Minutes", done);
	}

	public void saveTheManifestFile(){
		String savedQAURL=getManifestURL();
		getDriver().navigate().to(savedQAURL);
	}


	//*****id generation in OneCMS
	//	  <!-- Prefix the (CMSID) attribute value with "l_" to make it valid for CC schema -->
	//    <xsl:value-of select="concat('I_',substring-after(string(./@workspaceURI),'workspace://SpacesStore/'))"/>

	private boolean getChildNode(NodeList nodeList, String nodeName, String expValue) {
		boolean isNodeFound = false;
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().trim().equals(nodeName)) {
				isNodeFound=true;
				Assert.assertTrue("The Node- "+nodeName+ " value is incorrectly diplaying as: "+tempNode.getTextContent(), tempNode.getTextContent().contains(expValue));
				break;
			}
			if (tempNode.hasChildNodes() && isNodeFound==false) {
				getChildNode(tempNode.getChildNodes(), nodeName, expValue);
			}

		}
		return isNodeFound;

	}

	public void verifyNodeNameAndValue(String loc, String nodeName, String expValue){

		String actualPath= System.getProperty("user.dir");
		System.out.println(actualPath);
		loc=actualPath+loc+"commonCartridgeManifest";
		System.out.println(loc);
		boolean isFound=false;
		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));			
			if (doc.hasChildNodes()) {
				getChildNode(doc.getChildNodes(), nodeName, expValue);
				isFound=true;
			}

			Assert.assertTrue("The node "+nodeName+" is not found in Manifest", isFound);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void verifyAttributeValue(){
		
	}

	private boolean getChildNodeAtt(NodeList nodeList, String nodeName, String attribute, String expValue) {
		boolean isNodeFound = false;
		boolean isAttFound=false;
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().trim().equals(nodeName)) {
				if(tempNode.hasAttributes()){
					int countAtt = tempNode.getAttributes().getLength();
					System.out.println("Attributes= "+countAtt);
					Element e = (Element)tempNode;
		//			for(int i=1; i<countAtt+1; i++){
						if(e.getAttribute(attribute).contains(expValue)){
							System.out.println(e.getAttribute(attribute));
							isAttFound=true;
							Assert.assertTrue("The attribute is not found for selected node or attribute value is incorrect", isAttFound);
						}
		//			}
				}
				isNodeFound=true;
				break;
			}
			if (tempNode.hasChildNodes() && isNodeFound==false && isAttFound==false) {
				getChildNodeAtt(tempNode.getChildNodes(), nodeName, attribute, expValue);
			}

		}
		return isAttFound;

	}

	public void verifyNodeNameAttributeAndValue(String loc, String nodeName, String attribute, String expValue){

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		boolean isFound=false;
		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));			
			if (doc.hasChildNodes()) {
				getChildNodeAtt(doc.getChildNodes(), nodeName, attribute, expValue);
				isFound=true;
			}

			Assert.assertTrue("The node "+nodeName+" is not found in Manifest or The attribute is not found for selected node or attribute value is incorrect", isFound);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private boolean getChildNodeAttF(NodeList nodeList, String nodeName, String attribute, String expValue) {
		boolean isNodeFound = false;
		boolean isAttFound=false;
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().trim().equals(nodeName)) {
				if(tempNode.hasAttributes()){
					int countAtt = tempNode.getAttributes().getLength();
					System.out.println("Attributes= "+countAtt);
					Element e = (Element)tempNode;
		//			for(int i=1; i<countAtt+1; i++){
						if(e.getAttribute(attribute).contains(expValue)){
							System.out.println(e.getAttribute(attribute));
							isAttFound=true;
							Assert.assertFalse("The attribute value contains "+expValue+ " which shoul not present", true);
						}
		//			}
				}
				isNodeFound=true;
				break;
			}
			if (tempNode.hasChildNodes() && isNodeFound==false && isAttFound==false) {
				getChildNodeAtt(tempNode.getChildNodes(), nodeName, attribute, expValue);
			}

		}
		return isAttFound;

	}


	public void verifyNodeNameAttributeShouldNotHaveValue(String loc, String nodeName, String attribute, String expValue){

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		boolean isFound=false;
		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));			
			if (doc.hasChildNodes()) {
				getChildNodeAttF(doc.getChildNodes(), nodeName, attribute, expValue);
				isFound=true;
			}

			Assert.assertTrue("The node "+nodeName+" is not found in Manifest", isFound);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void parseXMLForTest(String loc){

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";

		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}


	private boolean getChildNodeCCO(NodeList nodeList, String nodeName, String ccoName) {
		boolean isNodeFound = false;
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName().trim().equals(nodeName)) {
				isNodeFound=true;
				Assert.assertFalse("The Node contains CCO name "+ccoName+ " which should NOT present in XML", tempNode.getTextContent().contains(ccoName));
				break;
			}
			if (tempNode.hasChildNodes() && isNodeFound==false) {
				getChildNodeCCO(tempNode.getChildNodes(), nodeName, ccoName);
			}

		}
		return isNodeFound;

	}

	public void verifyNodeShouldNotContainValue(String loc, String nodeName, String ccoName){

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		boolean isFound=false;
		try {

			File fXmlFile = new File(loc);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			Assert.assertTrue("Root element is NOT correct: " + doc.getDocumentElement().getNodeName(),  doc.getDocumentElement().getNodeName().contains("manifest"));			
			if (doc.hasChildNodes()) {
				getChildNodeCCO(doc.getChildNodes(), nodeName, ccoName);
				isFound=true;
			}

			Assert.assertTrue("The node "+nodeName+" is not found in Manifest", isFound);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	


	public void loopingNodes(String loc) {

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";

		try {
			File file = new File(loc);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) {
				getChildNodes(doc.getChildNodes());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void getChildNodes(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());
				if (tempNode.hasAttributes()) {
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {
					getChildNodes(tempNode.getChildNodes());
				}
				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
			}

		}

	}

	public void validateManifestXMLAgnstXSD(String loc) throws SAXException, IOException, ParserConfigurationException{

		String actualPath= System.getProperty("user.dir");
		loc=actualPath+loc+"commonCartridgeManifest";
		System.out.println("xml located at "+loc);

		File schemaFile = new File(ConstantsHMH.MANIFEST_XSD);
		final String schemaFile1 = schemaFile.getAbsolutePath();
		File schemaFile2 = new File(schemaFile1);
		System.out.println("xsd located at "+schemaFile1);
		Source xmlFile = new StreamSource(new File(loc));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile2);
		Validator validator = schema.newValidator();
		try {
			validator.validate(xmlFile);
			System.out.println(xmlFile.getSystemId() + " is valid");
		} catch (SAXException e) {
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
			System.out.println("Reason: " + e.getLocalizedMessage());
		}
	}      

	public void addToStandardsCartButtonDocumentActionsClick() {
		waitForPageToLoadCompletely(300);
		waitForElement("div[id$='onActionAddContentToCart']>a>span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(addToStandardsCartButtonDocumentActionsClick).waitUntilVisible();
		addToStandardsCartButtonDocumentActionsClick.click();
	}
	
	public void clickOnStandardCorrelationCart(String fileName){
		
		//waitForPageToLoadCompletely(300);		
		element(StandardsCorrelationCart).waitUntilVisible();
		StandardsCorrelationCart.click();	
		//waitForElement(fileName, Constants.DEFAULT_TIMEOUT_SECONDS, getDriver());
		//WebElement correlatedobj =getDriver().findElement(By.xpath(".//a[contains(text(),'"+"/Assets/"+fileName+"')]"));
		System.out.println(fileName);
		waitABit(2000);
		//waitForElementX(".//*[@id='divContainer'][4]/a[contains(text(),'"+fileName+"')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		getDriver().findElement(By.xpath(".//*[@id='divContainer']/a[contains(text(),'"+fileName+"')]")).click();
		
			
		
	}
	
	//Version Pop up

	public void cancelVersionPopup() {
		waitABit(1000);
		element(cancelVersionPopup).waitUntilClickable();
		cancelVersionPopup.click();
	}

	public void saveVersionPopup() {
		waitABit(1000);
		element(saveVersionPopup).waitUntilClickable();
		saveVersionPopup.click();
		
	}
	
	public void commentVersionPopup(String versionComment){
		waitABit(1000);
		commentVersionPopup.sendKeys(versionComment);
		
	}
	
	public void verifyDeliveryStructureValue(String delivery){
		Assert.assertTrue("Delivery Location value is not found: " + deliveryLocation.getText(),  deliveryLocation.getText().contains(delivery));		

	}
	
	public void generateMetadataReport() {
		waitABit(1000);
		element(generateMetadataReport).waitUntilClickable();
		generateMetadataReport.click();
	}
	
	public void downloadMetadataReport() {
		waitABit(1000);
		element(downloadMetadataReport).waitUntilClickable();
		downloadMetadataReport.click();
	}
	
	public void clickOnDownload(){
		waitForPageToLoadCompletely(300);		
		element(downloadButton).waitUntilVisible();
		downloadButton.click();
	}
	
	//Habitat Push New Changes
	
		public void pushToHabitatlink(){
	        waitABit(2000);
	        pushToHabitat_link.click();	
	 }

	public void pushToHabitat_Username(String pushToHabitatInput_Username){
	      waitABit(2000);
	      pushToHabitat_Username.clear();
	      pushToHabitat_Username.sendKeys(pushToHabitatInput_Username);
	 }

	public void pushToHabitat_Password(String pushToHabitatInput_Password){
	      waitABit(2000);
	      pushToHabitat_Password.clear();
	      pushToHabitat_Password.sendKeys(pushToHabitatInput_Password);
	}

	public void pushToHabitat_submitbtn(){
	      waitABit(2000);
	      pushToHabitat_submitbtn.click();
	System.out.println("habitakokpassed");
	      
	}

	public void pushToHabitatUserTemplateRadiobtn(final String pushToHabitatUserTemplate){
	             waitABit(2000);
	            //*** fiX **** created dynamic xpath 
	             WebElement radioBtn=getDriver().findElement(By.xpath(".//*[contains(text(),'"+pushToHabitatUserTemplate+"')]/../../td[1]/div/input"));
	             radioBtn.click();
	           //  getDriver().findElement(By.id(pushToHabitatUserTemplate)).findElement(By.tagName("input")).click();
	             //getDriver().findElement(By.id(radiobtn)).findElement(By.tagName("input")).click();
      }

	public void verifyTitleInEditProperties(String title) {
		boolean isFound=false;
	//	waitForElementX(".//*/span[text()='Display Title:']/following::span[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		String titleNew=getDriver().findElement(By.xpath(".//*/span[text()='Display Title:']/following::span[1]")).getText();
		if(titleNew.toLowerCase().contains(title.toLowerCase()))
		{
			isFound=true;
			LOG.info("Verified title Successfully");
		}
		Assert.assertTrue("Title is not visible", isFound);
		
	}
	 public void pushToHabitat_cancelbtn(){
	        waitABit(2000);
	        pushToHabitat_cancelbtn.click();
	        System.out.println("habitatcancelpassed");
	 }
	 
	 public void copyHabitatCCOlink(){
		    waitForElement("div[id*=onActionCreateCCOFrom]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			element(copyHabitatCCOlink).waitUntilClickable();
			copyHabitatCCOlink.click();      
	}

	 public void createNewContentNew(String option) {
			this.waitForElement("button[id*=\'createContent-button-button\']", 500, this.getDriver());
			this.element(this.createButton).waitUntilVisible();
			this.createButton.click();
			boolean foundOption = false;
			Iterator arg2 = this.contentToCreateList.iterator();

			while (arg2.hasNext()) {
				WebElement optionType = (WebElement) arg2.next();
				if (optionType.getText().toLowerCase().contentEquals(option.toLowerCase())) {
					foundOption = true;
					optionType.sendKeys(new CharSequence[]{""});
					optionType.click();
					break;
				}
			}

			Assert.assertTrue("The " + option + " type was not found!", foundOption);
		}

	public void pushToHabitat_submitbutton() {
		waitABit(2000);
		
		element(pushToHabSubmit).waitUntilVisible();
		pushToHabSubmit.click();
		System.out.println("Clicked submit");
		
	}

	//**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
	public void verifyWarningMessageOnPopup() {
		waitABit(2000);
		boolean isFound=false;
		element(verifyWarningMsg).waitUntilVisible();
		String message ="Warning! There may be changes in Habitat that are not pulled into Alfresco.";
		String warningMessage=getDriver().findElement(By.xpath(".//*[@id='prompt']/div[2]/div[1]")).getText();
		if(warningMessage.toLowerCase().contains(message.toLowerCase()))
		{
			isFound=true;
			LOG.info("Verified Warning Message Successfully");
		}
		Assert.assertTrue("Warning Message is not visible", isFound);
	}

	//**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
	public void selectRadiobuttonOnPopUp() {
		waitABit(2000);
		element(selectRadiobuttonOnPopUp).waitUntilVisible();
		selectRadiobuttonOnPopUp.click();
		System.out.println("Clicked on Radio Button - Structures and Assets");
		
	}

	
	//**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
		public void clickOkbuttonOnPopUp() {
			waitABit(2000);
			element(clickOkbuttonOnPopUp).waitUntilVisible();
			clickOkbuttonOnPopUp.click();
			System.out.println("Clicked on OK button to Re-push again to Habitat");
	}
		
	//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
		public void revertbutton() {
			waitABit(1000);
			waitForElementX("(.//*[@name='.onRevertVersionClick'])[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, this.getDriver());
			element(revertButton).waitUntilVisible();
			revertButton.click();
			System.out.println("Clicked on Revert Button");
	}

	//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
		public void revertContentAndMetadataRadio() {
			waitABit(2000);
			element(revertContentAndMetadataRadio).waitUntilVisible();
			revertContentAndMetadataRadio.click();
			System.out.println("Clicked on Revert Content & Metadata Radio Button");
			
		}

	//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
		public void revertContentRadio() {
			waitABit(2000);	
			element(revertContentRadio).waitUntilVisible();
			revertContentRadio.click();
			System.out.println("Clicked on Revert Content Radio Button");
			
		}	
		
		public void selectTheVersionAndAddCommentOnRevertWindow(String versionType, String comment) {
			if (this.uploadNewMinorVersionDocDetails.getText().toLowerCase().contains(versionType.toLowerCase())) {
				this.uploadNewMinorVersionDocDetails.click();
			} else {
				this.element(this.uploadNewMajorVersionDocDetails).waitUntilVisible();
				this.uploadNewMajorVersionDocDetails.click();
			}

			this.element(this.addCommentSectionDocDetails).waitUntilVisible();
			this.addCommentSectionDocDetails.sendKeys(new CharSequence[]{comment});
			this.element(this.uploadOkButtonDocDetails).waitUntilVisible();
			this.uploadOkButtonDocDetails.click();
		}

		//**** ALF-2088** Associate a Product Set or Product Object with One or More Learning Spines** Sprint 7.3.3** 
		@SuppressWarnings("unchecked")
		public void clickOnAssociatelearningSpineAction(String spine) {
			
			waitABit(2000);
			element(associateLearningSpine).waitUntilVisible();
			associateLearningSpine.click();
			
			waitForElementX(".//tr[td='"+spine+"']/td/following-sibling::td[2]/span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			WebElement clickLearningSpine=getDriver().findElement(By.xpath(".//tr[td='"+spine+"']/td/following-sibling::td[2]/span"));
			clickLearningSpine.click();
			System.out.println("Learning spine clicked: "+spine.toLowerCase());
			
			waitForElementX("(.//*[text()='"+spine+"'])[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			WebElement verifyLearningSpineDisplayedinWindow=getDriver().findElement(By.xpath("(.//*[text()='"+spine+"'])[2]"));
			element(verifyLearningSpineDisplayedinWindow).waitUntilVisible();
			System.out.println("Learning Spine verified and displayed on right side in Associate Learning Spine window");
			
			
			//Assert.assertTrue("The value of '%s' Spine is '%s'!  NOT Matched",
					// find((List<By>) clickLearningSpine).getText().toLowerCase().contains(spine.toLowerCase()));
			
		}
		
		 //**** ALF-2110** Make Changes to Learning Spine User Interface ** Sprint 7.3.3**  
		public void checkOrderOnAssociatelearningSpine() {
		List<WebElement> li=new LinkedList<>(getDriver().findElements(By.xpath(".//*[@class='yui-dt25-col-title yui-dt-col-title']")));    
        LinkedList<String> pn=new LinkedList<String>();    
        for(int i=0;i<li.size();i++)    
        {    
            //just displaying the product names    
           // System.out.println(li.get(i).getText());    
            pn.add(li.get(i).getText());    
        }    
        boolean result = comp_order(pn);
        boolean compareList=checkOrderCompareOnAssociatelearningSpine(pn);
        System.out.println(result);
        /*System.out.println("List in ascending order: "+compareList);*/
        
       
        
        }

		private boolean comp_order(LinkedList<String> pn) {
			return false;
		}

		 //**** ALF-2110** Make Changes to Learning Spine User Interface ** Sprint 7.3.3**  
		//alphabetical order checking for Learning Spine window  
        private static boolean checkOrderCompareOnAssociatelearningSpine(LinkedList<String> pn)    
        {           
        String prev=""; // empty string    
        for (final String cur: pn)    
        {    
            if (cur.compareTo(prev) < 0)    
            {      
                return false;
            }    
            prev=cur;    
        }    
        return true;    
        }    
       
      //**** ALF-2088** Associate a Product Set or Product Object with One or More Learning Spines** Sprint 7.3.3**
      // Performs save operation Learning Spine window 
        public void saveAssociatelearningSpine() {
        	
        	waitForElementX(".//*[@id='saveBtn-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
     		element(saveAssociatedLearningSpine).waitUntilVisible();
     		saveAssociatedLearningSpine.click();
        }

      //** ALF-2128** Learning Spines correlation are visible on View details page ** Sprint 7.3.3 **
		public void viewAssociatelearningSpine(String spine,String label) {
			boolean isFound= false;
			// ** Fix provided as per the changes ALF -1161 ** Sprint 7.3.4 ** Sep 24th
			waitForElementX(".//*[@id='labelAccordion-1-label']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
     		WebElement ele = element(labelLearningSpine).waitUntilVisible();
     		if(ele.getText().contains(label)) 
     		{
     		System.out.println("Learning spine Label is:"+" "+labelLearningSpine.getText());
     		}else
     			Assert.assertTrue("Learning Spine label is not displayed on View details Page", isFound);
     		
     		
			waitForElementX(".//*[@id='associationContent']//td[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
     		WebElement e = element(viewAssociateLearningSpine).waitUntilVisible();
     		if(e.getText().contains(spine)) 
     		{
     		System.out.println("Associated learning spine displayed is:"+" "+viewAssociateLearningSpine.getText());
     		}else
     			Assert.assertTrue("Associated Learning Spine is not displayed", isFound);
		}

	 //** ALF-2140 ** Deleting a Learning Spines correlation ** Sprint 7.3.3 ** 
		public void deleteAssociatelearningSpine() {
			waitABit(2000);
			element(deleteAssociatelearningSpine).waitUntilVisible();
			deleteAssociatelearningSpine.click();
			System.out.println("Clicked on delete Learning spine Button");
			
			element(deleteOkAssociatelearningSpineButton).waitUntilVisible();
			deleteOkAssociatelearningSpineButton.click();
			System.out.println("Delete Learning spine success");
			
		}

	//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		public void auditHistoryAction() 
		{
			waitABit(1000);
			element(auditHistory).waitUntilVisible();
			auditHistory.click();
			System.out.println("Audit History");
			
		}

	//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		
		public void noAuditHistoryFound() {
			
			waitForElementX(".//*[@id='noAuditData']/h4", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			System.out.println("No Audit Data Found");
			element(okButtonAuditHistory).waitUntilVisible();
			okButtonAuditHistory.click();
			
		}

	//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		public void clickViewDetailsOnAuditHistory(String userName) {

			waitForElementX("(.//div[text()='"+userName+"']/../..//img)[1]",
					  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			WebElement viewDetailsOnAuditHistory = getDriver().findElement(By.xpath("(.//div[text()='"+userName+"']/../..//img)[1]"));
			System.out.println("View Details Action on Audit History");
			element(viewDetailsOnAuditHistory).waitUntilVisible();
			viewDetailsOnAuditHistory.click();
		
		}
		
	//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		public void verifyPropertyOnViewDetailsAuditHistory(final String propertyName, final String propertyValue) {

			String properties = ".//*[@id='auditData']/table/tbody/tr['label']/td[contains(.,'value')]";
			waitForElementX(".//*[@id='auditData']/table/tbody/tr['"+propertyName+"']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			By verifyproperty=By.xpath(properties.replace("label", propertyName).replace("value", propertyValue));
			System.out.println(propertyName.toLowerCase() + " : " + propertyValue.toLowerCase());
			Assert.assertTrue(String.format("The value of '%s' property is '%s'!  NOT Matched", propertyName,
					propertyValue), find(verifyproperty).getText().toLowerCase().contains(propertyValue.toLowerCase()));			 		
		}
			
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		public void clickOkButtonOnAuditHistoryViewDetailsPopUp() {
						
					element(okButtonOnPopUp).waitUntilVisible();					
					element(okButtonOnPopUp).click();
					
				}	
								
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		public void clickOkButtonOnAuditHistory() {
			
			element(okButton).waitUntilVisible();					
			element(okButton).click();
			
		}

		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		public void clickOnAddNewCollectionAction(String CollectionName) {
			
			element(addCollectionAction).waitUntilVisible();					
			element(addCollectionAction).click();
			
			element(addNewCollectionradioButtonClick).waitUntilVisible();					
			element(addNewCollectionradioButtonClick).click();
			
			element(addCollectionNameTextBox).waitUntilVisible();					
			element(addCollectionNameTextBox).clear();
			element(addCollectionNameTextBox).sendKeys(CollectionName);
			
			element(addToCollectionButton).waitUntilVisible();					
			element(addToCollectionButton).click();
			
				
		}

		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		public void clickOnAddExistingCollectionAction(String collectionName) {
			
			boolean isFound= false;
			
			element(addCollectionAction).waitUntilVisible();					
			element(addCollectionAction).click();
			
			element(addExistingCollectionradioButtonClick).waitUntilVisible();					
			element(addExistingCollectionradioButtonClick).click();
						
			Select collect = new Select(selectCollection);
			collect.selectByValue(collectionName);
			System.out.println("Collecion selected");
					
			element(addToCollectionButton).waitUntilVisible();					
			element(addToCollectionButton).click();
			
		}

		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		public void clickOnMyCollection() {
			
			element(myCollection).waitUntilVisible();					
			element(myCollection).click();
			
					
			
		}

		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		public void clickOnGeneratePDF() {
			
			element(clickOnGeneratePDFAction).waitUntilVisible();					
			element(clickOnGeneratePDFAction).click();
						
		}

		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		public void clickOnPDFReportsFolder() {
			
			element(pdfReportFolderClick).waitUntilVisible();
			waitForElementX(".//a[text()='PDF Reports']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			element(pdfReportFolderClick).click();
			
		}

		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		public void verifyGeneratedPDFReport(String asset1,String asset2) {
			
			boolean isFound = false;
			//element(verifyAsset1OnGeneratedPDF).waitUntilVisible();
			//element(verifyAsset2OnGeneratedPDF).waitUntilVisible();
			
			if(verifyAsset1OnGeneratedPDF.getText().toLowerCase().contains(asset1.toLowerCase()))
			{
			isFound = true;
			System.out.println(verifyAsset1OnGeneratedPDF.getText() + " "+ asset1);
			}
			
			//waitABit(5000);
			
		/*	if(verifyAsset2OnGeneratedPDF.getText().toLowerCase().contains(asset2.toLowerCase()))
			{
			isFound = true;
			System.out.println(verifyAsset2OnGeneratedPDF.getText() + " "+ asset2);
			}
			
			//Assert.assertTrue("Assets not found in the generated PDF", isFound);
*/			
		}

		//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		public void clickManageAspectAction() {
			
			element(clickManageAspectAction).waitUntilVisible();
			element(clickManageAspectAction).click();
			
		
		}

		//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		public void selectTimestampAspectOnManageAspect() {
			
			element(selectTimestampAspect).waitUntilVisible();
			element(selectTimestampAspect).click();
			
			element(applyChangesButtonOnManageAspect).waitUntilVisible();
			element(applyChangesButtonOnManageAspect).click();
			
			
		}

		//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		@SuppressWarnings("unused")
		public String[] verifyAspectOnAssetFolder() {
			
			String pattern = "yyyy-M-d";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			String date = simpleDateFormat.format(new Date());
			System.out.println(date);
			
			String splitDate = date;
			String [] arrSplitDate = splitDate.split("-");
			String part1 = arrSplitDate[0]; 
			String part2 = arrSplitDate[1];
			String part3 = arrSplitDate[2];
			return arrSplitDate;
						
		}

		//** ALF-2224 ** Additional Columns in QA Report ** Sprint 7.3.3 **
		public void clickQAReport() {
			
			element(clickQAReport).waitUntilVisible();
			element(clickQAReport).click();
				
			
		}


		public void clickDownloadAction() {
			waitABit(1000);
			waitForElementX(".//span[text()='Download']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			WebElement download = getDriver().findElement(By.xpath(".//span[text()='Download']"));
			element(download).waitUntilVisible();
			download.click();
			System.out.println(download.getText());
			//waitABit(1000);
			//String sourceLocation = download.getAttribute("href");
			String sourceLocation = (String) ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].innerHTML;", download);
	        String wget_command = "cmd /c D:\\LatestCode01June\\Wget\\wget.exe -P D:\\LatestCode01June\\downloads --no-check-certificate " + sourceLocation;
	        //String wgetDownloadFile = "wget +sourceLocation+ -O D:\\LatestCode01June\\downloads";
	        System.out.println(wget_command);
	        try { 
	        Process exec = Runtime.getRuntime().exec(wget_command);
	        int exitVal = exec.waitFor();
	        System.out.println("Exit value: " + exitVal);
	        System.out.println("Download completed");
	        } catch (InterruptedException | IOException ex) {
	        System.out.println(ex.toString());
	        System.out.println("Download failed");
	        }
			
		}


		public void viewCorrelatelearningSkill(String spine, String label) {
			boolean isFound= false;
			
			waitABit(2000);
			//waitForElementX(".//*[@id='labelAccordion-2-label']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			
     		/*WebElement ele = element(labelLearningCorrelation).waitUntilVisible();
     		if(ele.getText().contains(label)) 
     		{
     		System.out.println("Learning Correlations Label is:"+" "+labelLearningCorrelation.getText());
     		}else
     			Assert.assertTrue("Learning Correlations label is not displayed on View details Page", isFound);
     		
     		waitABit(2000);*/
     		WebElement expandButton =element(labelLearningCorrelation).waitUntilVisible();	
			expandButton.click();
			//waitForElementX(".//*[@id='skillcorrelationcontent']//td[1]//ul//li", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
     		WebElement e = element(viewAssociatedLearningSpine).waitUntilVisible();
     		if(e.getText().contains(spine)) 
     		{
     		System.out.println("Associated learning Correlations displayed is:"+" "+viewAssociatedLearningSpine.getText());
     		}else
     			Assert.assertTrue("Associated Learning Correlations is not displayed", isFound);
			
		}


		public void deleteCorrelatelearningSkill() {
			waitABit(2000);
			element(deleteAssociatelearningSpine).waitUntilVisible();
			deleteAssociatelearningSpine.click();
			
			element(deleteOkAssociatelearningSpineButton).waitUntilVisible();
			deleteOkAssociatelearningSpineButton.click();
			System.out.println("Delete Learning spine success");
			
		}

		// ** Added As part of BVT script REG083 ** 8th Oct
		public void selectCopyHabitatCCO(String copyHabitatCCO) {
			
			/*element(selectCopyHabitatCCO).waitUntilVisible();					
			element(selectCopyHabitatCCO).click();*/
						
			Select collect = new Select(selectCopyHabitatCCO);
			collect.selectByVisibleText(copyHabitatCCO);
							
			element(copyHabitatCCOButton).click();
			System.out.println("Copy Habitat CCO Done");
			
			
		}

		//** ALF-2333 **  Trade: Ability to generate a PDF without first creating a collection ** Sprint 7.3.5 **
		public void clickOnGeneratePDFOnAssets() {
			
			WebElement selectItem = getDriver().findElement(By.xpath(".//button[@id='template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-selectedItems-button-button']"));
			selectItem.click();
			element(clickOnGeneratePDFActionOnAsset).waitUntilVisible();					
			element(clickOnGeneratePDFActionOnAsset).click();
			
		}	
					
		}
        






