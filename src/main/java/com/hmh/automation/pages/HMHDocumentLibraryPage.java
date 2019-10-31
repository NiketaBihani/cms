package com.hmh.automation.pages;

import java.util.Arrays;
import java.util.List;

import jline.internal.Log;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

public class HMHDocumentLibraryPage extends AbstractPage {
	public HMHDocumentLibraryPage(final WebDriver driver) {
		super(driver);
	}

	
	private static final Logger LOG = LoggerFactory
			.getLogger(HMHDocumentLibraryPage.class);

	@FindBy(xpath = ".//*[@id='onActionDeepCopyEnhanced']/a/span")
	private WebElement deepCopyTo;
	

	@FindBy(xpath = ".//*[text()='Upload Learning Spine']")
	private WebElement uploadLS;
	
	@FindBy(xpath = ".//*[text()='Download']")
	private WebElement downloadButton;

	@FindBy(xpath = ".//*[@class='document-version']")
	private WebElement renditionVersion;
	
	@FindBy(xpath = ".//*[@id='checkbox-yui-rec74']")
	private WebElement documentCheckBox;

	
	@FindBy(xpath = ".//*[@id='structural']//input[1]")
	private WebElement checkPS;

	@FindBy(xpath = ".//a[contains(text(),'Content Objects')]")
	private WebElement draftePub;
	
	@FindBy(xpath = ".//*[@id='structural']//input[3]")
	private WebElement checkSB;
	
	@FindBy(xpath = ".//*[@id='content']//input[2]")
	private WebElement checkCCO;
	
	@FindBy(xpath = ".//*[@id='content']//input[3]")
	private WebElement checkAsset;

	@FindBy(xpath = ".//*[@id='preId']")
	private WebElement preFix;
	
	@FindBy(xpath = ".//*[@id='replId']")
	private WebElement replace;
	
	@FindBy(xpath = ".//*[@id='replwithId']")
	private WebElement replaceWith;
	
	@FindBy(xpath = ".//*[@id='destLabel']")
	private WebElement destination;
	
	@FindBy(xpath = ".//*/button[text()='Copy']")
	private WebElement enDeepCopy;
	
	@FindBy(css = "td[headers*='nodeRef'] > div > input")
	private List<WebElement> docCheckboxIdentifier;
	
	
	@FindBy(css = "#template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-selectedItems-button-button")
	private WebElement selectedItems;
	
	@FindBy(xpath = "//span[contains(text(),'Copy to...')]")
	private WebElement copyTo;
	
	
	@FindBy(css = "div[id $= 'documents'] > table > tbody[class $= 'data'] > tr")
	private List<WebElement> documentsList;
	
	@FindBy(xpath = ".//*[@headers='yui-dt44-th-nodeRef ']")
	private List<WebElement> checkBoxList;
	
	@FindBy(xpath = ".//*[contains(text(),'Delivery location')]/following::span[1]")
	private WebElement deliveryLoc;
	
	@FindBy(xpath = ".//*[@id='onActionSetDeliveryLocation']/a/span")
	private WebElement targetDeliveryLoc;
	
	@FindBy(xpath = "(.//*/a[contains(text(),'.epub')])[1]")
	private WebElement ePubDraft;
	
	@FindBy(xpath = ".//*[@id='onActionSimpleRepoAction']/a/span")
	private WebElement generateJsonFile;
	
	@FindBy(xpath = ".//*/span[contains(text(),'Target Delivery Location')]/following::span[1]")
	private WebElement setTargetDeliveryLoc;
	
	@FindBy(css = "input[id*='createObject_prop_cm_name']")
	private WebElement nameInput;

	@FindBy(css = "input[id$='copyrightYear']")
	private WebElement copyrightYearInput;

	@FindBy(css = "select[id*='createObject_prop_hmh-cms_grade-entry'] option")
	private List<WebElement> gradesList;

	@FindBy(css = "input[id$='level1Label']")
	private WebElement level1LabelInput;

	@FindBy(css = "select[id$='level1Restart'] option")
	private List<WebElement> level1RestartList;

	@FindBy(css = "div[id $= 'aspects-right'] tr[class *='dt-rec']")
	private List<WebElement> aspectsCurrentlySelectedList;

	@FindBy(css = "[id $= 'aspects-cancel-button']")
	private WebElement cancelManageAspectsButton;

	@FindBy(css = "div.form-buttons span button[id*='createObject-form-submit-button']")
	private WebElement saveBtn;

	@FindBy(css = "select[id$='activityType'] option")
	private List<WebElement> activitTypelist;

	@FindBy(css = "select[id$='language'] option")
	private List<WebElement> laguagesList;

	@FindBy(xpath = ".//*[text()='Validate Learning Spine']")
	private WebElement learningSpine;
	
	@FindBy(xpath = ".//*[text()='Delete Document']")
	private WebElement deleteLS;	
	
	@FindBy(xpath = ".//button[text()='Delete']")
	private WebElement deleteButtonLS;
	
	@FindBy(xpath = ".//button[text()='Create...']")
	private WebElement createButtonOnPSF;
	
	@FindBy(xpath = "(.//*[text()='Program Support Folder'])[1]")
	private WebElement createPSF;
	
	@FindBy(xpath = ".//*[@id='template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createObject_prop_cm_name']")
	private WebElement createPSFName;
	
	@FindBy(xpath = ".//*[@id='template_x002e_documentlist_v2_x002e_documentlibrary_x0023_default-createObject-form-submit-button']")
	private WebElement saveButton;
	
	@FindBy(css = "select[id$='publicationRights-entry'] option")
	private List<WebElement> rightsList;

	@FindBy(css = "input[class='invalid']")
	private WebElement invalidInput;

	@FindBy(css = "span[class$='message']")
	private WebElement duplicateNameMessage;

	@FindBy(css = "div[id $= 'documents']")
	private WebElement defaultDocuments;

	@FindBy(css = "button[id*='form-cancel-button']")
	private WebElement cancelButton;

	@FindBy(css = "div[id*='default-selectedItems-menu'] div.bd ul")
	private WebElement selectedItemsOptionsPanel;

	@FindBy(css = "input[id*='prop_hmh-cms_scmUrl']")
	private WebElement codeRepositoryURl;

	@FindBy(css = "div[id*='correlation-cntrl-picker-results'] tbody[class$='data'] tr")
	private List<WebElement> standards;

	@FindBy(css = "div[id*='hmh-cms_correlation-cntrl-picker-selectedItems'] tbody[class$='data'] tr")
	private List<WebElement> selectedStandards;

	@FindBy(css = "div[id*='prop_hmh-cms_correlation-cntrl-picker-selectedItems'] tbody[class$='message'] div")
	private WebElement emptyStandardList;

	@FindBy(css = "button[id*='correlation-cntrl-ok-button']")
	private WebElement confirmCorrelateButton;

	@FindBy(css = "div[id*='correlation-cntrl-picker-results'] tbody[class*='message']")
	private WebElement loadingMessage;

	@FindBy(css = "div[id*='default-documents'] tbody[class*='data'] tr h3 a")
	private List<WebElement> assetList;

	@FindBy(xpath = "//ul[contains(@id, 'tags')]//li//span")
	private List<WebElement> tagsList;

	@FindBy(css = "input[id ^='form-field']")
	private WebElement enterNewTagDocLibView;

	@FindBy(xpath = "//form[contains(@class, 'insitu-edit')]//a[contains(text(),'Save')]")
	private WebElement saveButtonEditTagsDocViewSection;

	@FindBy(css = "div[class ='inlineTagEdit']")
	private WebElement editTagsContainer;

	@FindBy(css = "div[id*='dnd-upload'] div[id$='default-filelist-table'] tbody[class$='data'] td[class*='name'] span[class*='fileupload-filesize-span']")
	private WebElement noSpreadSheetInZipMessage;

	@FindBy(css = "span[class*='current']")
	private WebElement numberOfElementsOnPage;

	@FindBy(css = "select[id$='cms_markets-entry'] option")
	private List<WebElement> marketsList;

	@FindBy(css = "select[id$='lifecycle'] option")
	private List<WebElement> lifecycleList;

	@FindBy(css = "select[id$='learningStyles-entry'] option")
	private List<WebElement> learningStylesList;

	@FindBy(css = "select[id$='interactivityLevel'] option")
	private List<WebElement> interactivityLevelList;

	@FindBy(css = "select[id$='socialInteraction'] option")
	private List<WebElement> socialInteractionList;

	@FindBy(css = "textarea[id$='prop_cm_title']")
	private WebElement displayTitle;

	@FindBy(css = "select[id$='productCategory'] option")
	private List<WebElement> productCategoryList;

	@FindBy(css = "select[id$='productType-entry'] option")
	private List<WebElement> productTypeList;

	@FindBy(css = "select[id$='resourceType'] option")
	private List<WebElement> resourceTypeList;

	@FindBy(css = "select[id$='cms_activityType'] option")
	private List<WebElement> activityTypeList;

	@FindBy(css = "div.bd span[class='message']")
	private WebElement publishMessage;

	@FindBy(css = "[id $= 'selectedItems-button-button']")
	private WebElement selectedItemsButton;

	@FindBy(css = "div[id $= 'selectedItems-menu'] > div > ul > li > a > span")
	private List<WebElement> selectedItemsItemsList;

	@FindBy(css = "#yui-gen147-button")
	private WebElement clickOkPopup;

	@FindBy(css = "#yui-gen97")
	private WebElement clickOnFolderName;

	@FindBy(css = "tbody[class $= 'data'] > tr h3 > span a")
	private List<WebElement> documentLibraryAssetName;

	@FindBy(xpath = ".//*[@id='onActionDeleteObject']/a/span")
	private WebElement deleteObjectButton;

	@FindBy(css = "a[title='Delete Folder'] > span")
	private WebElement deleteFolderButton;

	@FindBy(xpath = "//Button[contains(text(),'Delete')]")
	private WebElement confirmDelete;
	
	@FindBy (xpath=".//*[contains(text(),'Mimetype')]/following::span[1]")
	private WebElement astmimetype;

	@FindBy(css = "a[title='Move to...'] span")
	private WebElement moveToselect;

	@FindBy(css = "a[title='Extract and Update Version'] > span")
	private WebElement extractButton;

	@FindBy(css = "span[class$='label']>a")
	private WebElement navBarViewDetails;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement clickDelete;
	
	@FindBy(css = "[id $= 'fileSelect-button-button']")
	private WebElement selectButton;
	
	@FindBy(className = "selectAll")
	private WebElement allLink;
	
	@FindBy(css = "[id $= 'selectedItems-button-button']")
	private WebElement selectedItemsButtontwo;

	@FindBy(css = "div.header-bar > div.left > div.hideable.DocListTree button")
	private WebElement docListTree;

	@FindBy(css = "a[title='Correlations'] span")
	private WebElement correlations;

	@FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec'] td > div > a > span.addIcon")
	private List<WebElement> addAspectButtonList;

	@FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec'] > td > div > h3")
	private List<WebElement> aspectsAvailableForFoldersList;

	@FindBy(css = "span[class$='message'] span")
	WebElement waitMessageInDoclib;

	@FindBy(css = "div[class='categoryview filter'] > h2")
	private WebElement categoriesMainButton;

	@FindBy(xpath = "//span[contains(text(), 'Category Root')]")
	private WebElement categoryRootButton;

	@FindBy(css = "div[class='categoryview filter'] div[id*='categories'] > div > div > div > div tr td span")
	private List<WebElement> categoryFilters;

	@FindBy(css = "div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a")
	private List<WebElement> documentTitlesList;

	@FindBy(xpath = "//h3[@class='filename']/span/a")
	private List<WebElement> assetListAll;

	@FindBy(css = "tbody.yui-dt-message tr td div.yui-dt-liner")
	WebElement loadingLibraryLiner;

	@FindBy(xpath = "//*[@class='detail']/span[contains(text(), 'Created')]")
	private List<WebElement> assetUserTime;

	@FindBy(css = "button[id*='createContent-button-button']")
	private WebElement createButton;

	@FindBy(css = "div.create-content div.bd ul li a")
	private List<WebElement> contentToCreateList;

	@FindBy(css = "input[name='prop_cm_name']")
	private WebElement folderNameField;

	@FindBy(css = "textarea[id $= 'prop_cm_description']")
	private WebElement newFolderDescriptionInput;

	@FindBy(css = "button[id $= 'createFolder-form-submit-button']")
	private WebElement saveFolderButton;

	@FindBy(css = "div[id='HEADER_SITE_DOCUMENTLIBRARY'] a")
	private WebElement documentLibraryButton;

	@FindBy(css = "button[id $= 'aspects-ok-button']")
	private WebElement applyChangesButton;

    @FindBy(xpath =".//*[@id='onActionManageAspects']/a/span")					// css = "div.document-manage-aspects > a span" xpath =".//*[@id='onActionManageAspects']/a/span")
	private WebElement manageAspectsButtonDocumentActions;
    
    @FindBy (xpath=".//*[@id='template_x002e_node-header_x002e_document-details_x0023_default']/div/div[1]/h1")
	private WebElement asttitle;
    
    //Metadata Report
    @FindBy(partialLinkText = "PO_K_TC75_metadata_Report")				
	private WebElement metadataReport;
    
    //ImportZipFile as CCO
    @FindBy(css = "a[title='Extract as CCO'] span")
	private WebElement extractCCOButton;
    
    
    @FindBy(xpath = ".//span[text()='Validate COM Structure']")
	private WebElement validateComStruc;

    
    @FindBy(css = "a[title='Import COM Structure'] span")
   	private WebElement importComStruc;
    
    @FindBy(xpath = ".//*[@id='template_x002e_dnd-upload_x002e_document-details_x0023_default-file-selection-button-overlay-button']//following::input[1]")
   	private WebElement uploadNewVersionDocument;
    
    @FindBy(xpath = ".//*[@id='onActionUploadNewVersion']")
	private WebElement uploadNewVersionButton;
    
    @FindBy(xpath = ".//*[text()='Upload']")
 	private WebElement uploadButton;
    
    
    String xpathDownloadAsZip="//span[contains(text(),'Download as Zip')]";
    
    By DownloadAsZip=By.xpath(xpathDownloadAsZip);

    
	String stadardNames = "h3 a";
	String addStandardButton = " a span[class='addIcon']";
	String removeStandardButton = "a span[class='removeIcon']";
	String documentsName = "h3.filename span a";
	String editPropertiesButtonString = "a[title='Edit Properties'] > span";
	String titleListSelector = " h3 span a";
	String standardList = "div[id$='correlation-cntrl-picker-results'] tbody[class$='data'] tr a";
	String noHMHKeywordsXpathSelector = "//span[contains(text(), 'No HMH Keywords')]";
	String editTagsButtonDocLib = "div[class='detail'] span[title ='Tag']";
	String assetTagsSpan = "span.item>span.tag";
	String assetTagContainer = "span.inlineTagEditTag";
	String deleteTagButton = "span.inlineTagEditTag img:nth-child(2)";
	String titleListXpathSelector = "//h3[@class='filename']/span/a[contains(text(),'textToReplace')]";
	String titleXpathSelector = "//h3[@class='filename']/span[contains(text(),'textToReplace')]";
	String hiddenContainerIdentifier = "div[class $= 'dt-liner'] > div";
	String itemMovePopup = "span.button-group>span>span>button";
	String assetCreatedTimeCssSelector = "div[class$='yui-dt-liner'] div[class$='detail'] span span";
	String assetCreatedTimeXpath = "//*[@class='detail']/span[1]/span";
	String assetUserCssSelector = "div[class$='yui-dt-liner'] div[class$='detail'] span a";
	String assetUserXpath = "//*[@class='detail']/span/a[contains(text(),'textToReplace')]";
	String xpathSelectorDocLib = "//h3[@class='filename']/span/a[contains(text(),'textToReplace')]";
	private final String viewDetails = "a[title='View Details'] > span";
	private final String moreButtonIdentifier = "div#onActionShowMore a.show-more > span";
	private final String moreActionsCSSSelector = "div.more-actions > div a span";
	public final String documentLibraryAssetNameCSS = "tbody[class $= 'data'] > tr h3 > span a";
	String selectFileToUpload = "input.dnd-file-selection-button";
	By documentLibraryAssetNameOld = By
			.cssSelector(documentLibraryAssetNameCSS);

	public void selectItem(final String itemName) {
		final List<WebElement> itemsList = getDriver()
				.findElements(
						By.cssSelector("div[id $= 'default-documents'] > table > tbody.yui-dt-data > tr"));
		for (final WebElement elem : itemsList) {
			if (elem.getText().contains(itemName)) {
				elem.findElement(By.cssSelector("div.yui-dt-liner > input"))
						.click();
				waitABit(2000);
				break;
			}
		}
	}

	
	public void verifyDownloadAsZipIsDisplayed() throws NoSuchElementException {
        
	       try{   boolean isDisplayed=find(DownloadAsZip).isDisplayed();
	              System.out.println("Presecnce of Download as Zip :"+isDisplayed);
	              // Assert.assertTrue("Download as Zip is present", (isDisplayed==false));
	              }
	                       
	       catch(Exception e){
	              
	              System.out.println("Download as Zip is not present");  
	              
	       }
	       }
	       
	       public void verifyCopyToIsDisplayed() throws NoSuchElementException {
	       boolean present;
	       try {
	          find(By.xpath("//span[contains(text(),'Copy to...')]"));
	          present = true;
	       } catch (NoSuchElementException e) {
	          present = false;
	          System.out.println("presence of Copy To:"+present);
	          }
	       }

	       public boolean verifyFolderIsDisplayed(String foldername) throws NoSuchElementException {
		       boolean present;
		       try {
		          find(By.xpath("//h3[@class=\'filename\']/span/a[contains(text(),\'" + foldername + "\')]"));
		          present = true;
		       } catch (NoSuchElementException e) {
		          present = false;
		          System.out.println("Folder not displayed"+present);
		          }
		       return present;
	       }
	       
	
	
	
	public void choseOptionFromSelectedItems(final String optionToSelect) {
		boolean found = false;
		waitABit(20000);
		final List<WebElement> selectedItemsOptions = selectedItemsOptionsPanel
				.findElements(By.cssSelector("li a span"));
		for (int i = 0; i < selectedItemsOptions.size(); i++) {
			System.out
					.println("i=" + i + selectedItemsOptions.get(i).getText());
			if (selectedItemsOptions.get(i).getText().toLowerCase()
					.contains(optionToSelect.toLowerCase())) {
				found = true;
				selectedItemsOptions.get(i).click();
				break;
			}
		}
		Assert.assertTrue("The Selected Items option was not found!", found);
	}

	public void verifyAspectIsSet(final String aspect) {
		boolean b = false;
		for (final WebElement elem : aspectsCurrentlySelectedList) {
			if (elem.getText().contains(aspect)) {
				b = true;
				break;
			}
		}
		Assert.assertTrue("aspect is not set", b);
	}

	public void cancelManageAspectButtonClick() {
		element(cancelManageAspectsButton).waitUntilVisible();
		cancelManageAspectsButton.click();
	}

	public void createNewContent(final String option) {
		waitForElement("button[id*='createContent-button-button']",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(createButton).waitUntilVisible();
		element(createButton).waitUntilClickable();
		createButton.click();
		customWait(2);
		boolean foundOption = false;
		for (final WebElement optionType : contentToCreateList) {
			if (optionType.getText().toLowerCase()
					.contains(option.toLowerCase())) {
				foundOption = true;
				optionType.sendKeys("");
				optionType.click();
				break;
			}
		}
		Assert.assertTrue("The " + option + " type was not found!", foundOption);
	}

	public void insertFolderNameDescriptionAndSave(String folderName,
			String description) {
		element(this.folderNameField).waitUntilVisible();
		this.folderNameField.sendKeys(new CharSequence[] { folderName });
		element(this.newFolderDescriptionInput).waitUntilVisible();
		this.newFolderDescriptionInput
				.sendKeys(new CharSequence[] { description });
		element(this.saveFolderButton).waitUntilVisible();
		this.saveFolderButton.click();
		waitABit(2000L);
	}

	public void clickOnDocumentLibraryButton() {
		waitForElement("div[id='HEADER_SITE_DOCUMENTLIBRARY'] a",
				Constants.DEFAULT_TIMEOUT_SECONDS, getDriver());
		waitForAngularRequestsToFinish();
		this.documentLibraryButton.click();
	}

	public void createObjectWhenNotAllMandatoryMetadataFieldsAreFilled() {
		boolean worksWell = false;
		waitForElement(
				"div.form-buttons span button[id*='createObject-form-submit-button']",
				Constants.DEFAULT_TIMEOUT_SECONDS, getDriver());
		manualScrollForSaveButton(1);
		element(saveBtn).waitUntilVisible();
		saveBtn.click();
		waitABit(1000);
		manualScrollForInputField(1);
		if (invalidInput.isDisplayed()) {
			worksWell = true;
		}
		Assert.assertTrue("The Invalid input message was not displayed",
				worksWell);

	}

	public void manualScrollForSaveButton(int manualScrollSeconds) {

		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(this.saveBtn).build().perform();

			waitABit(1000);
		}
	}

	public void manualScrollForInputField(int manualScrollSeconds) {

		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(this.nameInput).build().perform();

			waitABit(1000L);
		}
	}

	String duplicateMesg = "//span[contains(text(),'Could not create')]";

	public void duplicataNameMessageShow(String assetName) {

		refresh();
		waitForElementX("//table/tbody//div/h3/span/a[contains(text(),'"
				+ assetName + "')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				getDriver());
		String dupAsset = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ assetName + "-1')]";
		boolean isPresent = isElementVisible(By.xpath(dupAsset));
		Assert.assertFalse(
				"The Duplicate asset is created " + assetName + "-1", isPresent);

	}

	public void clickOKifPopupAppears() {
		waitABit(2000);
		boolean isPopupVis = isElementVisible(By.cssSelector(itemMovePopup));
		if (isPopupVis == true) {
			getDriver().findElement(By.cssSelector(itemMovePopup)).click();
		}

	}

	public void createProgram(final String name, final String title,
			String market) {
		boolean marketsFound = false;
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);

		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void createProductSet(final String name, final String year,
			final String grade, final String levle1,
			final String level1Restart, final String market, final String title) {
		element(nameInput).waitUntilVisible();
		manualScrollForInputField(1);
		nameInput.sendKeys(name);
		copyrightYearInput.sendKeys(year);
		displayTitle.sendKeys(title);
		boolean gradeFound = false;
		boolean level1RestartFound = false;
		boolean marketsFound = false;

		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);

		level1LabelInput.sendKeys(levle1);

		for (final WebElement lvl : level1RestartList) {
			if (lvl.getText().toLowerCase()
					.contentEquals(level1Restart.toLowerCase())) {
				level1RestartFound = true;
				lvl.click();
				break;
			}
		}
		Assert.assertTrue("The level 1 Restart was not found",
				level1RestartFound);

		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);
		manualScrollForSaveButton(1);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void createProductObject(final String name, final String year,
			final String title) {
		element(nameInput).waitUntilVisible();
		manualScrollForInputField(1);
		nameInput.sendKeys(name);
		copyrightYearInput.sendKeys(year);
		displayTitle.sendKeys(title);
		manualScrollForSaveButton(1);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void createProductSet(final String name, final String levle1,
			final String title) {
		// element(nameInput).waitUntilVisible();
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);
		level1LabelInput.sendKeys(levle1);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void createSequenceBundle(final String name, final String market,
			final String title) {
		boolean marketsFound = false;
		manualScrollForInputField(1);
		element(nameInput).waitUntilVisible();
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);
		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);
		manualScrollForSaveButton(1);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	// public void createLearningBundleConsumerSite(final String name, final
	// String grade, final String market, final String lifecycle,
	// final String learningStyle, final String interactivityLevel, final String
	// socialInteraction, final String title) {
	public void createLearningBundleConsumerSite(final String name,
			final String grade, final String market, final String title) {
		boolean gradeFound = false;
		boolean lifecycleFound = false;
		boolean marketsFound = false;
		boolean learningStylesFound = false;
		boolean interactivityLevelFound = false;
		boolean socialInteractionFound = false;

		element(nameInput).waitUntilVisible();
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);
		waitABit(4000);
		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);
		// for (final WebElement lifeCycle : lifecycleList) {
		// if
		// (lifeCycle.getText().toLowerCase().contentEquals(lifecycle.toLowerCase()))
		// {
		// lifecycleFound = true;
		// lifeCycle.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The lifecycle was not found", lifecycleFound);
		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);
		// for (final WebElement learnStyle : learningStylesList) {
		// if
		// (learnStyle.getText().toLowerCase().contains(learningStyle.toLowerCase()))
		// {
		// learningStylesFound = true;
		// learnStyle.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The learning Style was not found",
		// learningStylesFound);
		// for (final WebElement interLevel : interactivityLevelList) {
		// if
		// (interLevel.getText().toLowerCase().contains(interactivityLevel.toLowerCase()))
		// {
		// interactivityLevelFound = true;
		// interLevel.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The interactivity level was not found",
		// interactivityLevelFound);
		// for (final WebElement interaction : socialInteractionList) {
		// if
		// (interaction.getText().toLowerCase().contains(socialInteraction.toLowerCase()))
		// {
		// socialInteractionFound = true;
		// interaction.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The social interaction was not found",
		// socialInteractionFound);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void createLearningBundleK12Site(final String name,
			final String title, final String lifecycle, final String market,
			final String grade) {
		boolean gradeFound = false;
		boolean lifecycleFound = false;
		boolean marketsFound = false;
		LOG.info("level1: here it comes");
		System.out.println("level1: here it comes in Chrome");
		manualScrollForInputField(1);
		element(nameInput).waitUntilVisible();
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);
		waitABit(2000);
		LOG.info("level2: here it comes");

		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);

		for (final WebElement lifeCycle : lifecycleList) {
			if (lifeCycle.getText().toLowerCase()
					.contentEquals(lifecycle.toLowerCase())) {
				lifecycleFound = true;
				lifeCycle.click();
				break;
			}
		}
		Assert.assertTrue("The lifecycle was not found", lifecycleFound);

		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);
		manualScrollForSaveButton(1);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void createLearningObjectConsumerSite(final String name,
			final String grade, final String rights, final String market,
			final String title) {

		boolean gradeFound = false;

		boolean languageFound = false;
		boolean rightsFound = false;
		boolean marketsFound = false;
		boolean learningStylesFound = false;
		boolean interactivityLevelFound = false;
		boolean socialInteractionFound = false;
		boolean resourceTypeFound = false;

		element(nameInput).waitUntilVisible();

		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);

		for (final WebElement rightsElement : rightsList) {
			if (rightsElement.getText().toLowerCase()
					.contentEquals(rights.toLowerCase())) {
				rightsFound = true;
				rightsElement.click();
				break;
			}
		}
		Assert.assertTrue("The right was not found", rightsFound);

		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);

		// for (final WebElement languageElement : laguagesList) {
		// if
		// (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase()))
		// {
		// languageFound = true;
		// languageElement.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The language was not found", languageFound);

		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);

		// for (final WebElement learnStyle : learningStylesList) {
		// if
		// (learnStyle.getText().toLowerCase().contains(learningStyle.toLowerCase()))
		// {
		// learningStylesFound = true;
		// learnStyle.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The learning Style was not found",
		// learningStylesFound);

		// interactivity Level
		// for (final WebElement interLevel : interactivityLevelList) {
		// if
		// (interLevel.getText().toLowerCase().contains(interactivityLevel.toLowerCase()))
		// {
		// interactivityLevelFound = true;
		// interLevel.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The interactivity level was not found",
		// interactivityLevelFound);
		//
		// //social interaction
		// for (final WebElement interaction : socialInteractionList) {
		// if
		// (interaction.getText().toLowerCase().contains(socialInteraction.toLowerCase()))
		// {
		// socialInteractionFound = true;
		// interaction.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The social interaction was not found",
		// socialInteractionFound);
		//
		// //resource Type
		// for (final WebElement resource : resourceTypeList) {
		// if
		// (resource.getText().toLowerCase().contains(resourceType.toLowerCase()))
		// {
		// resourceTypeFound = true;
		// resource.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The resource type was not found",
		// resourceTypeFound);

		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	// create Learning object in k-12 site

	/*
	 * public void createLearningObjectK12Site(final String name, final String
	 * activityType, final String grade, final String language, final String
	 * rights, final String market, final String title, final String
	 * productCategory, final String productType, final String lifecycle) {
	 * 
	 * boolean gradeFound = false; boolean languageFound = false; boolean
	 * rightsFound = false; boolean marketsFound = false; boolean
	 * activityTypeFound = false; boolean productCategoryFound = false; boolean
	 * productTypeFound = false; boolean lifeCycleFound = false;
	 * element(nameInput).waitUntilVisible(); nameInput.sendKeys(name);
	 * displayTitle.sendKeys(title);
	 * 
	 * for (final WebElement rightsElement : rightsList) { if
	 * (rightsElement.getText
	 * ().toLowerCase().contentEquals(rights.toLowerCase())) { rightsFound =
	 * true; rightsElement.click(); break; } }
	 * Assert.assertTrue("The right was not found", rightsFound);
	 * 
	 * for (final WebElement activity : activitTypelist) { if
	 * (activity.getText()
	 * .toLowerCase().contentEquals(activityType.toLowerCase())) {
	 * activityTypeFound = true; activity.click(); break; } }
	 * Assert.assertTrue("The acitivty was not found", activityTypeFound);
	 * 
	 * for (final WebElement gradeElement : gradesList) { if
	 * (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase()))
	 * { gradeFound = true; gradeElement.click(); break; } }
	 * Assert.assertTrue("The grade was not found", gradeFound);
	 * 
	 * for (final WebElement languageElement : laguagesList) { if
	 * (languageElement
	 * .getText().toLowerCase().contentEquals(language.toLowerCase())) {
	 * languageFound = true; languageElement.click(); break; } }
	 * Assert.assertTrue("The language was not found", languageFound);
	 * 
	 * for (final WebElement marketItem : marketsList) { if
	 * (marketItem.getText().toLowerCase().contains(market.toLowerCase())) {
	 * marketsFound = true; marketItem.click(); break; } }
	 * Assert.assertTrue("The market was not found", marketsFound);
	 * 
	 * for (final WebElement category : productCategoryList) { if
	 * (category.getText
	 * ().toLowerCase().contains(productCategory.toLowerCase())) {
	 * productCategoryFound = true; category.click(); break; } }
	 * Assert.assertTrue("The product category was not found",
	 * productCategoryFound);
	 * 
	 * for (final WebElement type : productTypeList) { if
	 * (type.getText().toLowerCase().contains(productType.toLowerCase())) {
	 * productTypeFound = true; type.click(); break; } }
	 * Assert.assertTrue("The product type was not found", productTypeFound);
	 * 
	 * for (final WebElement cycle : lifecycleList) { if
	 * (cycle.getText().toLowerCase().contains(lifecycle.toLowerCase())) {
	 * lifeCycleFound = true; cycle.click(); break; } }
	 * Assert.assertTrue("The lifeCycle was not found", lifeCycleFound);
	 */

	public void createLearningObjectK12Site(final String name,
			final String grade, final String language, final String rights,
			final String market, final String title, final String lifecycle) {

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
			if (rightsElement.getText().toLowerCase()
					.contentEquals(rights.toLowerCase())) {
				rightsFound = true;
				rightsElement.click();
				break;
			}
		}
		Assert.assertTrue("The right was not found", rightsFound);

		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);

		for (final WebElement languageElement : laguagesList) {
			if (languageElement.getText().toLowerCase()
					.contentEquals(language.toLowerCase())) {
				languageFound = true;
				languageElement.click();
				break;
			}
		}
		Assert.assertTrue("The language was not found", languageFound);

		for (final WebElement marketItem : marketsList) {
			if (marketItem.getText().toLowerCase()
					.contains(market.toLowerCase())) {
				marketsFound = true;
				marketItem.click();
				break;
			}
		}
		Assert.assertTrue("The market was not found", marketsFound);

		// for (final WebElement category : productCategoryList) {
		// if
		// (category.getText().toLowerCase().contains(productCategory.toLowerCase()))
		// {
		// productCategoryFound = true;
		// category.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The product category was not found",
		// productCategoryFound);

		for (final WebElement cycle : lifecycleList) {
			if (cycle.getText().toLowerCase().contentEquals(lifecycle.toLowerCase())) {
				lifeCycleFound = true;
				cycle.click();
				break;
			}
		}
		Assert.assertTrue("The lifeCycle was not found", lifeCycleFound);

		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	// public void createComponentConsumerSite(final String name, final String
	// title, final String rights,
	// final String grade, final String language, final String lifecycle,
	// final String learningSyles, final String interactivityLevel,
	// final String socialInteraction, final String resourceType) {
	public void createComponentConsumerSite(final String name,
			final String title, final String rights, final String grade,
			final String lifecycle, final String resourceType) {

		boolean rightsFound = false;
		boolean languageFound = false;
		boolean gradeFound = false;
		boolean lifecycleFound = false;
		boolean learningStylesFound = false;
		boolean interactivityLevelFound = false;
		boolean socialInteractionFound = false;
		boolean resourceTypeFound = false;
		manualScrollForInputField(1);
		element(nameInput).waitUntilVisible();
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);

		for (final WebElement rightsElement : rightsList) {
			if (rightsElement.getText().toLowerCase()
					.contentEquals(rights.toLowerCase())) {
				rightsFound = true;
				rightsElement.click();
				break;
			}
		}
		Assert.assertTrue("The right was not found", rightsFound);
		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);
		// for (final WebElement languageElement : laguagesList) {
		// if
		// (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase()))
		// {
		// languageFound = true;
		// languageElement.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The language was not found", languageFound);
		System.out.println(lifecycle);
		for (final WebElement lifeCycle : lifecycleList) {
			if (lifeCycle.getText().toLowerCase()
					.contentEquals(lifecycle.toLowerCase())) {
				lifecycleFound = true;
				lifeCycle.click();
				break;
			}
		}
		Assert.assertTrue("The lifecycle was not found", lifecycleFound);
		// for (final WebElement learnStyle : learningStylesList) {
		// if
		// (learnStyle.getText().toLowerCase().contains(learningSyles.toLowerCase()))
		// {
		// learningStylesFound = true;
		// learnStyle.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The learning Style was not found",
		// learningStylesFound);
		//
		// for (final WebElement interaction : socialInteractionList) {
		// if
		// (interaction.getText().toLowerCase().contains(socialInteraction.toLowerCase()))
		// {
		// socialInteractionFound = true;
		// interaction.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The social interaction was not found",
		// socialInteractionFound);
		// for (final WebElement interLevel : interactivityLevelList) {
		// if
		// (interLevel.getText().toLowerCase().contains(interactivityLevel.toLowerCase()))
		// {
		// interactivityLevelFound = true;
		// interLevel.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The interactivity level was not found",
		// interactivityLevelFound);
		for (final WebElement resource : resourceTypeList) {
			if (resource.getText().toLowerCase()
					.contains(resourceType.toLowerCase())) {
				resourceTypeFound = true;
				resource.click();
				break;
			}
		}
		Assert.assertTrue("The resource type was not found", resourceTypeFound);

		manualScrollForSaveButton(1);
		saveBtn.click();
		waitABit(1000);
		clickOKifPopupAppears();
		refreshPage();
	}

	// ///////////////////////////////////////////////////////////////
	public void createComponentK12Site(final String name, final String title,
			final String rights, final String grade, final String lifeCycle) {
		boolean gradeFound = false;
		boolean languageFound = false;
		boolean rightsFound = false;
		boolean activityTypeFound = false;
		boolean lifeCycleFound = false;
		waitABit(1000);
		element(nameInput).waitUntilVisible();
		nameInput.sendKeys(name);
		displayTitle.sendKeys(title);

		for (final WebElement rightsElement : rightsList) {
			if (rightsElement.getText().toLowerCase()
					.contentEquals(rights.toLowerCase())) {
				rightsFound = true;
				rightsElement.click();
				break;
			}
		}
		Assert.assertTrue("The right was not found", rightsFound);

		for (final WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase()
					.contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				gradeElement.click();
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);

		// for (final WebElement languageElement : laguagesList) {
		// if
		// (languageElement.getText().toLowerCase().contentEquals(language.toLowerCase()))
		// {
		// languageFound = true;
		// languageElement.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The grade was not found", languageFound);

		for (final WebElement cycle : lifecycleList) {
			if (cycle.getText().toLowerCase()
					.contentEquals(lifeCycle.toLowerCase())) {
				lifeCycleFound = true;
				cycle.click();
				break;
			}
		}
		Assert.assertTrue("The lifecycle was not found", lifeCycleFound);

		// for (final WebElement activity : activitTypelist) {
		// if
		// (activity.getText().toLowerCase().contentEquals(activityType.toLowerCase()))
		// {
		// activityTypeFound = true;
		// activity.click();
		// break;
		// }
		// }
		// Assert.assertTrue("The acitivty was not found", activityTypeFound);
		//manualScrollForSaveButton(1);
		saveBtn.click();
		clickOKifPopupAppears();
		refreshPage();
	}

	public void hmhEditPropertiesClick(final String asset) {
		boolean found = false;
		final Actions action = new Actions(getDriver());
		for (final WebElement elem : documentsList) {
			if (elem.getText().toLowerCase().contains(asset.toLowerCase())) {
				final WebElement hiddenContainer = elem.findElement(By
						.cssSelector(documentsName));
				mouseOver(hiddenContainer);
				action.moveToElement(hiddenContainer).build().perform();
				final WebElement editPropertiesButton = elem.findElement(By
						.cssSelector(editPropertiesButtonString));
				editPropertiesButton.click();
				found = true;
			}
		}
		Assert.assertTrue("The item " + asset + " was not found", found);
		System.out.println("Iese din metoda");
	}

	public int getNumberOfItemsOnPage() {
		String itemNumbersFoter = numberOfElementsOnPage.getText();
		String[] parts = itemNumbersFoter.split(" -");
		String part1 = parts[0];
		int nrOfItems = Integer.parseInt(part1);
		return nrOfItems;
	}

	public void waitForZipToFinishExtract(final String zipAsset) {
		int nr = getNumberOfItemsOnPage();
		int ni = documentLibraryAssetName.size();
		System.out.println(ni);
		boolean gone = false;
		int counter = 0;
		waitABit(1000);
		while ((gone == false) && (counter < 25) && (nr > 0)) {
			for (final WebElement element : assetList) {
				System.out.println(element.getText().toLowerCase());
				if (element.getText().toLowerCase()
						.contains(zipAsset.toLowerCase())) {
					System.out.println(element.getText());
					gone = true;
					break;
				}
			}
			waitABit(6000);
			refreshPage();
			counter++;
			ni = documentLibraryAssetName.size();
			System.out.println(ni);
		}
		Assert.assertTrue("The asset file isn't appeard in 10 minutes",
				counter < 30);
	}

	public void clickItemInCorrelationsPane(final String standardName) {
		boolean found = true;
		waitABit(1000);
		waitForElementX("//tbody//tr//td//div//h3//a[contains(text(),'"
				+ standardName + "')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				getDriver()); // first correlation element FOlder level
		waitForRenderedElementsToBePresent(By.cssSelector(standardList));
		Serenity.takeScreenshot();
		for (final WebElement standard : getDriver().findElements(
				By.cssSelector(standardList))) {
			System.out.println(standard.getText());
			element(standard).waitUntilVisible();
			if (standard.getText().toLowerCase()
					.contains(standardName.toLowerCase())) {
				// WebElement navigate =
				// aspect.findElement(By.cssSelector(referencesNamesCssSelector));
				found = true;
				standard.click();
				Serenity.takeScreenshot();
				break;
			}
		}
		Assert.assertTrue("The standard set was not found", found);

	}

	public void selectStandardToCorrelate(final String standard) {
		boolean standardFound = false;
		waitForAngularRequestsToFinish();
		waitForElementX("//tbody//tr//td//div//h3[contains(., '" + standard
				+ "')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		for (final WebElement item : standards) {
			System.out.println("Standard is " + item.getText());
			if (item.getText().toLowerCase().contains(standard.toLowerCase())) {
				System.out.println("2 Standard is " + item.getText());
				standardFound = true;
				final WebElement add = item.findElement(By
						.cssSelector(addStandardButton));
				add.click();
				waitABit(2000);
				break;
			}
		}
		Assert.assertTrue("The searched standard was not found", standardFound);
		confirmCorrelateButton.click();
		waitABit(1000);
	}

	public void checkIfStandardWasAdded(final String standard) {
		boolean found = false;
		for (final WebElement item : selectedStandards) {
			if (item.getText().toLowerCase().contains(standard.toLowerCase())) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(
				"The standard was not found in selected standards list", found);
	}

	public void removeACorrelation(final String standard) {
		boolean found = false;
		element(confirmCorrelateButton).waitUntilVisible();
		for (final WebElement item : selectedStandards) {
			if (item.getText().toLowerCase().contains(standard.toLowerCase())) {
				found = true;
				final WebElement removeBtn = item.findElement(By
						.cssSelector(removeStandardButton));
				removeBtn.click();
				break;
			}
		}
		Assert.assertTrue(
				"The standard was not found in selected standards list", found);
		confirmCorrelateButton.click();
	}

	public void checkIfThereAreNoCorrelations() {
		boolean noCorrelations = false;
		element(emptyStandardList).waitUntilVisible();
		// if (emptyStandardList.isDisplayed()) {
		if (emptyStandardList.getText().contains("No items selected")) {
			noCorrelations = true;
		}
		Assert.assertTrue("The correlations list is not empty", noCorrelations);
	}

	public void deleteTagFromDocLibView(final String assetName,
			final String tagName) {
		final int counterBefore = getTagNumericValue(tagName);
		editTagButtonClickHMH(assetName);
		element(enterNewTagDocLibView).waitUntilVisible();
		for (final WebElement asset : documentsList) {
			if (asset.getText().toLowerCase().contains(assetName.toLowerCase())) {
				final List<WebElement> tagList = asset.findElements(By
						.cssSelector(assetTagContainer));
				for (final WebElement tagN : tagList) {
					if (tagN.getText().contains(tagName)) {
						final WebElement delTagButton = tagN.findElement(By
								.cssSelector(deleteTagButton));
						delTagButton.click();
					}
				}
			}
		}
		element(saveButtonEditTagsDocViewSection).waitUntilVisible();
		saveButtonEditTagsDocViewSection.click();
		element(editTagsContainer).waitUntilNotVisible();
		getDriver().navigate().refresh();

		final int counterAfter = getTagNumericValue(tagName);
		Assert.assertTrue("Counter for tag is incorrect!",
				counterBefore == (counterAfter + 1));
	}

	public void editTagButtonClickHMH(final String assetName) {
		final Actions actions = new Actions(getDriver());
		boolean found = false;
		// waitForListToLoad(documentsList, 5);
		System.out.println("Initiated edit  FOR");
		for (final WebElement container : documentsList) {
			final WebElement name = container.findElement(By
					.cssSelector(titleListSelector));
			if (name.getText().equalsIgnoreCase(assetName)) {
				System.out.println("In First IF");
				if (verifyElementPresent(
						By.cssSelector(noHMHKeywordsXpathSelector), 5)) {
					System.out.println("In al doilea IF");

					final WebElement findTags = container.findElement(By
							.cssSelector(noHMHKeywordsXpathSelector));

					actions.moveToElement(findTags);
					actions.click().build().perform();
					waitABit(2000);
					final WebElement editTagsButton = container.findElement(By
							.cssSelector(editTagsButtonDocLib));
					element(editTagsButton).waitUntilVisible();
					actions.moveToElement(editTagsButton);
					actions.click().build().perform();

					System.out.println("Se termina al doilea IF");
					found = true;
					break;
				} else {
					final WebElement findTags = container.findElement(By
							.cssSelector(assetTagsSpan));
					actions.moveToElement(findTags);
					actions.build().perform();
					waitABit(2000);
					final WebElement editTagsButton = container.findElement(By
							.cssSelector(editTagsButtonDocLib));
					element(editTagsButton).waitUntilVisible();
					actions.moveToElement(editTagsButton);
					actions.click().build().perform();
					found = true;
					break;
				}
			}
		}
		Assert.assertTrue("The asset is not in the list!", found);
	}

	public int getTagNumericValue(final String tagName) {
		String tagText = null;
		int tagNumber = 0;
		waitABit(2000);
		for (final WebElement tag : tagsList) {
			if (tag.getText().contains(tagName.toLowerCase())) {
				tagText = tag.getText();
				tagNumber = Integer.parseInt(tagText.split("[\\(\\)]")[1]);
			}
		}
		return tagNumber;
	}

	public void checkExtractErrorMessage(final String message) {
		boolean found = false;
		if (noSpreadSheetInZipMessage.getText().contains(message)) {
			found = true;
		}
		Assert.assertTrue("The message is not correct or not found", found);
	}

	public void refresh() {
		refreshPage();
	}

	public void checkPublishMessage() {
		String message = "Successfully queued for publishing";
		boolean found = false;
		element(publishMessage).waitUntilVisible();
		if (publishMessage.getText().contains(message)) {
			found = true;
		}
		Assert.assertTrue("The message for publishing was not displayed", found);
	}



	public void selectAnItemFromSelectedItemsDropDown(final String actionName) {
		boolean isFound = false;
		// element(selectedItemsButton).waitUntilVisible();
		element(selectedItemsButton).waitUntilClickable();
		selectedItemsButton.click();
		waitABit(1200);
		List<WebElement> itemsList = getDriver()
				.findElements(
						By.cssSelector("div[id $= 'selectedItems-menu'] > div > ul > li > a > span"));
		waitForListToLoad(itemsList, 1, true);
		for (final WebElement action : itemsList) {
			if (action.getText().toLowerCase()
					.contains(actionName.toLowerCase())) {
				action.click();
				isFound = true;
				break;
			}
		}

		Assert.assertTrue(" " + actionName + " was not found", isFound);

//		waitForElementX("//button[contains(text(),'Delete')]",
//				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
//		clickDelete.click();
	}


	public void refreshToExitPopup() {
		getDriver().navigate().refresh();

	}

	public void clickOnFolder() {
		element(clickOnFolderName).waitUntilVisible();
		clickOnFolderName.click();
		waitABit(2000);
	}

	public void viewDetailsClick(final String assetName) {
		boolean found = false;
		final Actions action = new Actions(getDriver());
		for (final WebElement elem : documentsList) {
			if (elem.getText().toLowerCase().contains(assetName.toLowerCase())) {
				final WebElement hiddenContainer = elem.findElement(By
						.cssSelector(hiddenContainerIdentifier));
				action.moveToElement(hiddenContainer).build().perform();
				final WebElement viewD = elem.findElement(By
						.cssSelector(viewDetails));
				viewD.click();
				found = true;
				waitABit(800);
				break;
			}
		}
		Assert.assertTrue("The View Details dialog popup was not found", found);
	}

	public void moreActionMenuClick(final String menuAction,
			final String itemName) {
		// waitForPageToLoadCompletely(30);
		boolean found = false;
		final Actions action = new Actions(getDriver());
		waitForListToLoad(documentsList, 10, false);
		for (final WebElement elem : documentsList) {
			final WebElement name = elem.findElement(By
					.cssSelector(titleListSelector));

			if (name.getText().toLowerCase().contains(itemName.toLowerCase())) {
				action.moveToElement(elem).build().perform();
				element(moreButtonIdentifier).waitUntilVisible();
				final WebElement moreButton = elem.findElement(By
						.cssSelector(moreButtonIdentifier));
				// action.moveToElement(moreButton).build().perform();
				moreButton.click();
				action.moveToElement(moreButton).build().perform();
				final List<WebElement> moreActionsList = elem.findElements(By
						.cssSelector(moreActionsCSSSelector));
				waitForListToLoad(moreActionsList, 10, false);
				// element (moreActionsCSSSelector).waitUntilVisible();
				for (final WebElement act : moreActionsList) {
					if (act.getText().toLowerCase()
							.contains(menuAction.toLowerCase())) {

						// action.moveToElement(act).build().perform();
						act.click();
						found = true;
						break;

						// if
						// (name.getText().toLowerCase().contains(itemName.toLowerCase()))
						// {
						// final WebElement hiddenContainer =
						// elem.findElement(By
						// .cssSelector(hiddenContainerIdentifier));
						// action.moveToElement(hiddenContainer).build().perform();
						// final WebElement moreButton = elem.findElement(By
						// .linkText(moreButtonIdentifier));
						// moreButton.click();
						// final List<WebElement> moreActionsList =
						// elem.findElements(By
						// .cssSelector(moreActionsCSSSelector));
						// waitForListToLoad(moreActionsList, 10, false);
						// for (final WebElement act : moreActionsList) {
						// if (act.getText().toLowerCase()
						// .contains(menuAction.toLowerCase())) {
						// act.click();
						// found = true;
						// break;
					}
				}
			}
			if (found) {
				break;
			}
		}
		Assert.assertTrue("The item " + itemName + " was not extracted", found);
	}

	public void waitForLoadingMsgDisappear() {

		waitABit(500);
		for (int i = 0; i <= 400; ++i) {
			// element(waitMessageInDoclib).waitUntilNotVisible();
			boolean isLoadingLibraryMsg = isElementVisible(By
					.cssSelector("tbody.yui-dt-message tr td div.yui-dt-liner")); // span[class$='message']>span
			if (isLoadingLibraryMsg == false) {
				break;
			}
			waitABit(200);
			++i;
		}

		for (int i = 0; i <= 400; ++i) {
			// element(waitMessageInDoclib).waitUntilNotVisible();
			boolean isMessagePresent = isElementVisible(By
					.cssSelector(".message")); // span[class$='message']>span
			if (isMessagePresent == false) {
				break;
			}
			waitABit(200);
			++i;
		}
	}

	public void assetFromListClickX(final String assetName) {
		waitForAngularRequestsToFinish();
		waitForLoadingMsgDisappear();
		boolean isAssetInList = false;
		waitForListToLoad(this.documentLibraryAssetName, 30, true);
		System.out.println(documentLibraryAssetName.size());
		for (final WebElement asset : documentLibraryAssetName) {
			if (asset.getText().toLowerCase().trim()
					.contains(assetName.toLowerCase().trim())) {
				isAssetInList = true;
				asset.click();
				break;
			}
		}
		Assert.assertTrue("Asset is not in the list!", isAssetInList);
	}

	public void assetFromListClick(final String assetName) {
		waitABit(5000);
		System.out.println(assetName);
		boolean isAssetPresent = false;
		String assetX = "//table/tbody//div/h3/span/a[contains(text(),'"+assetName+"')]";
		waitForElementX(assetX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				getDriver());
		isAssetPresent = isElementVisible(By.xpath(assetX));
		
		if (isAssetPresent == true) {
			waitABit(3000);
			getDriver().findElement(By.xpath(assetX)).click();
			waitABit(500);

		}
		
		Assert.assertTrue(
				"Asset is not in the list! or not loaded in 5 Minutes",
				isAssetPresent);
	}
	

	//** Verification of the asset present in the list **
	public void assetFromListClickCO(final String assetName) {
		waitABit(500);
		System.out.println(assetName);
		boolean isAssetPresent = false;
		String assetX = "//table/tbody//div/h3/span/a[text()='"
				+ assetName + "']";
		//waitForElementX(assetX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				//getDriver());
		isAssetPresent = isElementVisible(By.xpath(assetX));
		waitABit(500);
		if (isAssetPresent == true) {
			
			getDriver().findElement(By.xpath(assetX)).click();
			waitABit(500);
			
		}
		else
		{
			LOG.info("Element not found");
		Assert.assertTrue(
				"Asset is not in the list! or not loaded in 5 Minutes",
				isAssetPresent);
		}
	}
	
	//**Fix done on 11/06/2018  **
	//**ALF- 1962 ** verification of the generated downloadable epub file in Epub folder in CO ** Sprint 7.1.1**
	public void downloadableAssetFromListClickSubCO(final String assetName) {
		
		waitABit(500);
		String s = new StringBuilder("dl_").append(assetName).append("_teacher.epub").toString();
		System.out.println(" Downloadable ePub is"+" "+s);
		boolean isAssetPresent = false;
		String assetY = "//a[text()='"+ s + "']";
		isAssetPresent = isElementVisible(By.xpath(assetY));
		
		if (isAssetPresent == true) {
			getDriver().findElement(By.xpath(assetY)).click();
			waitABit(500);
			
		}
		else
		{
			LOG.info("Element not found");
		Assert.assertTrue(
				"Asset is not in the list! or not loaded in 5 Minutes",
				isAssetPresent);
		}
	}
	
	
	
	String navBarXpath = "//span[@class='label']/a[contains(text(),'textToReplace')]";

	public void navBarClick(String asset) {
		// waitForLoadingMsgDisappear();
		waitForElementX("//span[@class='label']/a[contains(text(),'" + asset
				+ "')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());// waitForElementX
		WebElement navBarCurrent = getDriver().findElement(
				By.xpath(navBarXpath.replace("textToReplace", asset)));
		navBarCurrent.click();
	}
	

	public void verifyRenditionsVersion(String version) {
	
		boolean flag=false;
		element(renditionVersion).waitUntilVisible();
		if (renditionVersion.getText().contains(version)) { //if (latestVersion.getText().equalsIgnoreCase(version)) {
			flag = true;
		}
		Assert.assertTrue("The latest version is not correct", flag);
	}
	
	public void manageAspectsButtonDocumentActionsClick() {
		waitForElementX(".//*[@id='onActionManageAspects']/a/span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(manageAspectsButtonDocumentActions).waitUntilVisible();
		manageAspectsButtonDocumentActions.click();
		waitABit(2000);
//		waitForPageToLoadCompletely(15);
//		this.actionsonDocumentDetails.click();
	}

	public void checkIfAssetIsPresent(final String docPath) {
		String assetX = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ docPath + "')]";
		waitForElementX(assetX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				getDriver());
		final WebElement name = getDriver().findElement(By.xpath(assetX));
		Assert.assertTrue("The document is not present!", name.getText()
				.toLowerCase().contains(docPath.toLowerCase()));
	}

	public void assetFromListClickSub(final String assetName) {
		boolean isAssetPresent = false;
		String assetX = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ assetName + "')]";
		waitForElementX(assetX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				getDriver());
		isAssetPresent = isElementVisible(By.xpath(assetX));
		if (isAssetPresent == true) {
			getDriver().findElement(By.xpath(assetX)).click();
			waitABit(500);

		}
		Assert.assertTrue(
				"Asset is not in the list! or not loaded in 5 Minutes",
				isAssetPresent);
	}

	// public void checkIfAssetIsPresent(final String docPath) {
	// waitForListToLoad(documentTitlesList, 60, true);
	// boolean found = false;
	// if (assetListAll.getText()
	// .toLowerCase().contains(docPath)) {
	// found = true;
	// System.out.println("Asset found");
	// }
	// Assert.assertTrue("The document is not present!", found);
	//
	// }

	public void clickDeleteObject() {
		waitForElement("a[title='Delete Object'] > span",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(deleteObjectButton).waitUntilVisible();
		deleteObjectButton.click();
	}

	public void clickDeleteFolder() {
		waitForElement("a[title='Delete Folder'] > span",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(deleteFolderButton).waitUntilVisible();
		waitABit(1000);
		deleteFolderButton.click();
	}

	public void confirmDelete() {
		element(confirmDelete).waitUntilVisible();
		confirmDelete.click();
	}

	public void filterByCategory(String categoryName) {
		boolean found = false;
		// categoriesMainButton.click();
		// waitABit(1000);
		waitForElementX("//span[contains(text(), 'Category Root')]",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		categoryRootButton.click();
		waitABit(2000);
		for (WebElement filter : categoryFilters) {
			if (filter.getText().toLowerCase().trim()
					.contentEquals(categoryName.toLowerCase().trim())) {
				found = true;
				filter.click();
				break;
			}
		}
		Assert.assertTrue("The filter was not found in Category list", found);
	}

	public void clickMoveto() {
		waitForElement("a[title='Move to...'] span",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(moveToselect).waitUntilVisible();
		moveToselect.click();
	}

	public void clickExtract() {
		waitForElement("a[title='Extract and Update Version'] > span",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		disableFlash();
		waitABit(1000);
		element(extractButton).waitUntilVisible();
		extractButton.click();
		waitABit(1000);	
	}

	public void navBarClick() {
		waitForLoadingMsgDisappear();
		waitForElement("span[class$='label']>a",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(navBarViewDetails).waitUntilVisible();
		System.out.println(navBarViewDetails.getText());
		navBarViewDetails.click();
	}

	public void selectAllItems() {
		element(selectButton).waitUntilVisible();
		selectButton.click();
		element(allLink).waitUntilVisible();
		allLink.click();
	}

	public void clickCorrelations() {
		// waitForPageToLoadCompletely(10);
		waitForElement("a[title='Correlations'] span",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(correlations).waitUntilVisible();
		correlations.click();
	}

	public void selectAspectForAFolderX(final String aspectName) {
		boolean found = false;
		waitABit(1000);
		for (int i = 0; i < addAspectButtonList.size(); i++) {
			for (int j = 0; j < aspectsAvailableForFoldersList.size(); j++) {
				if (aspectsAvailableForFoldersList.get(j).getText()
						.toLowerCase().contentEquals(aspectName.toLowerCase())) {
					found = true;
					waitABit(2000);
					element(addAspectButtonList.get(i)).waitUntilVisible();
					addAspectButtonList.get(i).click();
					break;
				}
				i++;
			}
			if (found = true) {
				break;
			}
		}
		Assert.assertTrue("The aspect was not found", found);
	}

	public void selectAspectForAFolder(final String aspectName) {
		waitABit(1000);
		waitForElement(
				"tbody>tr:nth-child(1)>td:nth-child(2)>div>h3:nth-child(1)",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean isAspectPresent = isElementVisible(By
				.xpath("//tr/td/div/h3[text()='" + aspectName
						+ "']/following::td[1]/div/a/span"));
		WebElement aspectNameX = getDriver().findElement(
				By.xpath("//tr/td/div/h3[text()='" + aspectName
						+ "']/following::td[1]/div/a/span"));
		Actions action = new Actions(getDriver());
		action.moveToElement(aspectNameX).build().perform();
		aspectNameX.click();
		Assert.assertTrue("The aspect was not found", isAspectPresent);
	}

	public void aspectsChangesApplyClick() {
		element(this.applyChangesButton).waitUntilVisible();
		this.applyChangesButton.click();
		waitForRenderedElementsToBePresent(By.cssSelector("div#message"));
	}

	public void verifyUsernameAndTimeForAsset(final String username,
			final String time) {
		final String regex = "[0-9]+";
		boolean isPresent = isElementVisible(By.cssSelector(".message"));
		if (isPresent == true) {
			waitForLoadingMsgDisappear();
		}
		final WebElement assetUser = assetUserTime.get(0).findElement(
				By.xpath(assetUserXpath.replace("textToReplace", username)));
		Assert.assertTrue("Asset username is incorrect!", assetUser.getText()
				.contains(username));
		final WebElement assetTime = assetUserTime.get(0).findElement(
				By.xpath(assetCreatedTimeXpath));
		String assetTimeText = assetTime.getText();
		Assert.assertTrue(
				"Version time is incorrect!",
				assetTimeText.matches(regex + " " + time)
						|| assetTimeText.toLowerCase().contains(
								Constants.UPLOAD_VERSION_TIME_TEXT1)
						|| assetTimeText.toLowerCase().contains(
								Constants.UPLOAD_VERSION_TIME_TEXT2)
						|| assetTimeText.toLowerCase().contains(
										"2 minutes ago")
						|| assetTimeText.toLowerCase().contains(
										"3 minutes ago")
						|| assetTimeText.toLowerCase().contains(
										"4 minutes ago"));

	}

	public boolean checkIfFolderIsPresent(final String folderName) {
		waitForElement("div[class*='documentDroppableHighlights']>span.label",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println(listPresent);
		boolean found = false;
		if (listPresent == true) {
			waitForListToLoad(documentTitlesList, 60, true);
			for (WebElement asset : assetListAll) {
				if (asset.getText().toLowerCase()
						.contains(folderName.toLowerCase())) {
					found = true;
					System.out.println("Folder is found");
					break;
				}
			}

		}
		return found;
	}

	public boolean isListPresent() {

		waitForPageToLoadCompletely(ConstantsHMH.DEFAULT_TIMEOUT_SECONDS);
		waitForAngularRequestsToFinish();
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		return listPresent;
	}

	public boolean checkIfFolderIsPresentCh(final String folderName) {
		// boolean listPresent1 =
		// getDriver().findElement(By.xpath("//h3[@class='filename']/span/a")).isDisplayed();
		// waitForElement("div[class*='documentDroppableHighlights']", 120,
		// getDriver());
		Serenity.takeScreenshot();
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println(listPresent);
		boolean found = false;
		if (listPresent == true) {
			// int noOfAssets = documentTitlesList.size();
			// if (noOfAssets > 0){
			waitForListToLoad(documentTitlesList, 10, true);

			for (WebElement asset : assetListAll) {
				if (asset.getText().toLowerCase()
						.contains(folderName.toLowerCase())) {
					found = true;
					System.out.println("Folder is found");
				}
			}

		}
		return found;
	}

	public boolean isAssetPresent(final String objName) {
		waitABit(1000);
		waitForAngularRequestsToFinish();
		waitForLoadingMsgDisappear();
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println(listPresent);
		boolean found = false;
		if (listPresent == true) {
			boolean isAssetPresent = isElementVisible(By
					.xpath("//table/tbody//div/h3/span/a[contains(text(),'"
							+ objName + "')]"));
			System.out.println(isAssetPresent);
			if (isAssetPresent == true) {
				found = true;
				System.out.println("Asset/Object is found:  " + objName);
			}

		}
		System.out.println(found);
		return found;

	}
	
	public void verifyIfFolderIsPresent(String objName){
		
		waitForElement("div[class*='documentDroppableHighlights']>span.label",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println(listPresent);
		boolean found = false;
		if (listPresent == true) {
			waitForListToLoad(documentTitlesList, 100, true);
			Assert.assertTrue("Assest folder is not created", isElementVisible(By.xpath((this.titleListXpathSelector.replace("textToReplace", objName)))));
		}
	}

	// ** ALF 1042 ** - Support special characters pulled from Habitat ** Sprint 7.3.3. **
	public void verifyIfAssetIsPresent(final String objName, String title) {
		//waitABit(500);
		//waitForAngularRequestsToFinish();
		boolean found = false;
		String asset = "//table/tbody/tr/td[5]/div/h3/span[2]/a";
		//waitForLoadingMsgDisappear();
		waitForElementX(asset, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
				getDriver());
		
		WebElement listPresent = getDriver().findElement(By.xpath(asset));
			
		if (listPresent.isDisplayed()) {
			waitABit(500);
			getDriver().findElement(By.xpath(asset)).click();			
			System.out.println("Asset/Object is found:  " + objName);
			
		}
		
		WebElement assetPresent = getDriver().findElement(By.xpath(".//*[@id='template_x002e_node-header_x002e_document-details_x0023_default']/div/div[1]/h1"));
		// split string delimited with special characters
		String line =  assetPresent.getText();
		String[] numbers = line.split(" ");
		//System.out.println(Arrays.toString(numbers));		
		String[] number2 = numbers[1].split("\\(\\)");
		//System.out.println("String split:"+ Arrays.toString(number2));
		String splittedString = Arrays.toString(number2).substring(2,22);
		
		if (splittedString.toLowerCase().equals(title.toLowerCase()))
		{
			waitABit(500);
			System.out.println(splittedString);
			System.out.println("Display Title is verified :"+title);
			
		}
		
		/*Assert.assertTrue("The Asset not found in Document Library" + objName,
				found);*/

	}

	public void verifyHabitatAddedPageIsPresent(final String objName) {
		waitABit(1000);
		waitForAngularRequestsToFinish();
		boolean found = false;
		waitForLoadingMsgDisappear();
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println(listPresent);

		if (listPresent == true) {
			waitForLoadingMsgDisappear();
			boolean isAssetPresent = isElementVisible(By
					.xpath(this.titleXpathSelector.replace("textToReplace",
							objName)));
			if (isAssetPresent == true) {
				found = true;
				System.out.println("Asset/Object is found:  " + objName);
			}
		}

		System.out.println(found);
		Assert.assertTrue("The added page is not found in Document Library"
				+ objName, found);

	}

	private WebElement getDocumentElement(String[] docPath) {
		boolean foundDoc = false;
		for (int i = 0; i < docPath.length; ++i) {
			String pathElement = docPath[i];
			waitForAllStringsToAppear(this.defaultDocuments, 30,
					new String[] { pathElement });

			for (WebElement document : this.documentTitlesList) {
				if (document.getText().toLowerCase()
						.contains(pathElement.toLowerCase())) {
					foundDoc = true;
					if (i < docPath.length - 1) {
						document.click();
						break;
					}
					return document;
				}
			}

			Assert.assertTrue("The node named '" + docPath[i]
					+ "' was not found!", foundDoc);
		}

		return null;
	}

	public void checkIfAssetIsNotPresent(final String[] docPath) {

		Assert.assertFalse("The document should not be present!",
				getDocumentElement(docPath).isDisplayed());

	}

	public void checkIfObjectIsNotPresent(final String name) {
		waitForLoadingMsgDisappear();
		boolean isPresent = isElementVisible(By.xpath(xpathSelectorDocLib
				.replace("textToReplace", name)));
		System.out.println(isPresent);
		Assert.assertFalse("The Object named '" + name + "' is still exist",
				isPresent);
	}

	public void waitForLoadingLibraryToDisppear(final String asset) {
		waitABit(2000);
		waitForElementX("//span[@class='label']/a[contains(text(),'" + asset
				+ "')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());// waitForElementX

	}

	public boolean checkIfAutoCreatedFoldersArePresent() {

		String[] autoFolderName = { "Assets", "Content Objects",
				"Learning Bundles", "Sequence Bundles", "Product Objects",
				"Product Sets", "Programs" }; // 7

		String assetsFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[0] + "')]";
		String contentObjectsFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[1] + "')]";
		String learningBundlesFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[2] + "')]";
		String sequenceBundlesFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[3] + "')]";
		String productObjectsFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[4] + "')]";
		String productSetsFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[5] + "')]";
		String programsFolder = "//table/tbody//div/h3/span/a[contains(text(),'"
				+ autoFolderName[6] + "')]";

		waitForElement("div[class*='documentDroppableHighlights']>span.label",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println("Is list prsesnt: "+listPresent);
		boolean found = false;
		if (listPresent == true) {
			found = true;
			waitForListToLoad(documentTitlesList, 60, true);
			Assert.assertTrue("Assest folder is not created",
					isElementVisible(By.xpath(assetsFolder)));
			Assert.assertTrue("Content Objects folder is not created",
					isElementVisible(By.xpath(contentObjectsFolder)));
			Assert.assertTrue("Learning Bundles folder is not created",
					isElementVisible(By.xpath(learningBundlesFolder)));
			Assert.assertTrue("Sequence BundlesFolder folder is not created",
					isElementVisible(By.xpath(sequenceBundlesFolder)));
			Assert.assertTrue("Product ObjectsFolder folder is not created",
					isElementVisible(By.xpath(productObjectsFolder)));
			Assert.assertTrue("Product SetsFolder folder is not created",
					isElementVisible(By.xpath(productSetsFolder)));
			Assert.assertTrue("Programs folder is not created",
					isElementVisible(By.xpath(programsFolder)));
		}
		// Assert.assertTrue("Auto Folders are not created/ Document List is not loaded in 5 minutes",
		// found);
		System.out.println(found);
		return found;
	}

	public void createFoldersLikeAutoCreatedFolders() {

		String[] autoFolderName = { "Assets", "Content Objects",
				"Learning Bundles", "Sequence Bundles", "Product Objects",
				"Product Sets", "Programs" }; // 7
		int foldersCount = autoFolderName.length;
		String folderName;
		String[] aspectName = { "Asset Bucket", "Content Object Bucket",
				"Learning Bundle Bucket", "Sequence Bundle Bucket",
				"Product Object Bucket", "Product Set Bucket", "Program Bucket" }; // 7

		waitForElement("div[class*='documentDroppableHighlights']>span.label",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean listPresent = isElementVisible(By
				.cssSelector("div[id $= 'documents'] > table > tbody[class $= 'data'] > tr h3 span > a"));
		System.out.println(listPresent);
		boolean found = false;
		if (listPresent == true) {
			waitForListToLoad(documentTitlesList, 60, true);
			selectAllItems();
			selectAnItemFromSelectedItemsDropDown("Delete");
		}

		switch (1) {

		case 1:
			folderName = autoFolderName[0];
			System.out.println(folderName);
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName, "AssetsFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[0]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();

		case 2:
			folderName = autoFolderName[1];
			System.out.println(folderName);
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName,
					"ContentObjectsFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[1]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();
		case 3:
			folderName = autoFolderName[2];
			System.out.println(folderName);
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName,
					"LearningBundlesFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[2]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();
		case 4:
			folderName = autoFolderName[3];
			System.out.println(folderName);
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName,
					"SequenceBundlesFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[3]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();
		case 5:
			folderName = autoFolderName[4];
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName,
					"ProductObjectsFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[4]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();
		case 6:
			folderName = autoFolderName[5];
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName, "ProductSetsFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[5]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();
		case 7:
			folderName = autoFolderName[6];
			createNewContent("Folder");
			insertFolderNameDescriptionAndSave(folderName, "ProgramsFolder");
			clickOnDocumentLibraryButton();
			assetFromListClick(folderName);
			navBarClick(folderName);
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName[6]);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();

		}

		/*
		 * for (String folderName : autoFolderName) { if
		 * (folderName.contains("Assets")) { System.out.println(folderName);
		 * createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName, "AssetsFolder");
		 * clickOnDocumentLibraryButton(); assetFromListClick(folderName);
		 * navBarClick(folderName); selectAspectForAFolder(aspectName[0]);
		 * aspectsChangesApplyClick(); clickOnDocumentLibraryButton(); }
		 * 
		 * if (folderName.contains("ContentObjects")) {
		 * System.out.println(folderName); createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName,
		 * "ContentObjectsFolder"); clickOnDocumentLibraryButton();
		 * assetFromListClick(folderName); navBarClick(folderName);
		 * selectAspectForAFolder(aspectName[1]); aspectsChangesApplyClick();
		 * clickOnDocumentLibraryButton(); }
		 * 
		 * if (folderName.contains("LearningBundles")) {
		 * System.out.println(folderName); createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName,
		 * "LearningBundlesFolder"); clickOnDocumentLibraryButton();
		 * assetFromListClick(folderName); navBarClick(folderName);
		 * selectAspectForAFolder(aspectName[2]); aspectsChangesApplyClick();
		 * clickOnDocumentLibraryButton(); }
		 * 
		 * if (folderName.contains("SequenceBundles")) {
		 * System.out.println(folderName); createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName,
		 * "SequenceBundlesFolder"); clickOnDocumentLibraryButton();
		 * assetFromListClick(folderName); navBarClick(folderName);
		 * selectAspectForAFolder(aspectName[3]); aspectsChangesApplyClick();
		 * clickOnDocumentLibraryButton(); }
		 * 
		 * if (folderName.contains("ProductObjects")) {
		 * System.out.println(folderName); createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName,
		 * "ProductObjectsFolder"); clickOnDocumentLibraryButton();
		 * assetFromListClick(folderName); navBarClick(folderName);
		 * selectAspectForAFolder(aspectName[4]); aspectsChangesApplyClick();
		 * clickOnDocumentLibraryButton(); } if
		 * (folderName.contains("ProductSets")) {
		 * System.out.println(folderName); createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName, "ProductSetsFolder");
		 * clickOnDocumentLibraryButton(); assetFromListClick(folderName);
		 * navBarClick(folderName); selectAspectForAFolder(aspectName[5]);
		 * aspectsChangesApplyClick(); clickOnDocumentLibraryButton(); } if
		 * (folderName.contains("Programs")) { System.out.println(folderName);
		 * createNewContent("Folder");
		 * insertFolderNameDescriptionAndSave(folderName, "ProgramsFolder");
		 * clickOnDocumentLibraryButton(); assetFromListClick(folderName);
		 * navBarClick(folderName); selectAspectForAFolder(aspectName[6]);
		 * aspectsChangesApplyClick(); clickOnDocumentLibraryButton(); }
		 * 
		 * }
		 */
		}
	public void clickonMetadataReport() {
		waitABit(1000);
		element(metadataReport).waitUntilClickable();
		metadataReport.click();
	}
	
	//added by Salai - Nov10th 2016 (Incident 8797)
			public void createHipObject(final String name, final String title, final String grade) {
				element(nameInput).waitUntilVisible();
				manualScrollForInputField(1);
				nameInput.sendKeys(name);
				displayTitle.sendKeys(title);
				
				boolean gradeFound = false;
				
				for (final WebElement gradeElement : gradesList) {
					if (gradeElement.getText().toLowerCase()
							.contentEquals(grade.toLowerCase())) {
						gradeFound = true;
						gradeElement.click();
						break;
					}
				}
				Assert.assertTrue("The grade was not found", gradeFound);
				
				manualScrollForSaveButton(1);
				saveBtn.click();
				clickOKifPopupAppears();
				refreshPage();		
			
		}
			
			//Added by Salai - CognizantQA
			public void hipobjectFromListClick(final String hipObjectName) {
				waitABit(500);
				boolean ishipobjectPresent = false;
				String hipX = "//table/tbody//div/h3/span/a[contains(text(),'"
						+ hipObjectName + "')]";
				waitForElementX(hipX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
						getDriver());
				ishipobjectPresent = isElementVisible(By.xpath(hipX));
				if (ishipobjectPresent == true) {
					getDriver().findElement(By.xpath(hipX)).click();
					waitABit(500);

				}
				Assert.assertTrue(
						"Hip object is not in the list! or not loaded in 5 Minutes",
						ishipobjectPresent);
			}
			//Added for Import File as CCO
			public void clickExtractCCO() {
				waitForElement("a[title='Extract as CCO'] span",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				disableFlash();
				waitABit(1000);
				element(extractCCOButton).waitUntilVisible();
				extractCCOButton.click();
				waitABit(1000);
			}
			//Added for browser back navigation
			public void goBackToPreviousPage()
			{
				getDriver().navigate().back();
			}
			
			//Added for verify Auto file upload extention
			
			public void verifymimetype(String fileNameExt) {
				if(asttitle.getText().contains(fileNameExt)) {
					LOG.info("Uploaded file extenstion matched");
					String[] ext = 	fileNameExt.split("\\.");
					System.out.println(ext[1]);
					System.out.println(astmimetype.getText());
					if(astmimetype.getText().contains(ext[1])){
						LOG.info("Uploaded file Mimetype matched");
					}
					else
					{
						LOG.info("Uploaded file Mimetype haven't matched");
					}
				}
				else
				{
					LOG.info("Uploaded file extenstion not matched");
				}
				
						
			}
			
			public void verifyDeliveryLoc() {
				
				if(isElementVisible(By.xpath(".//*[contains(text(),'Target Delivery location')]/following::span[1]")))
				{
					String str = deliveryLoc.getText();
					LOG.info("Delivery Location details "+str);
				}
				else
				{
					LOG.info("Delivery Location details not found ");
				}
				
			}
			
			public void verifyTargetDeliveryLoc() {
				
				if(isElementVisible(By.xpath(".//*/span[contains(text(),'Target Delivery Location')]/following::span[1]")))
				{
					String str = setTargetDeliveryLoc.getText();
					LOG.info("Target Delivery Location details "+str);
				}
				else
				{
					LOG.info("Target Delivery Location details not found ");
				}
				
			}
			
			
			public void afterSetverifyTargetDeliveryLoc() {
				
				waitForElementX(".//*/span[contains(text(),'Target Delivery Location')]/following::span[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
						getDriver());
				if(isElementVisible(By.xpath(".//*/span[contains(text(),'Target Delivery Location')]/following::span[1]")))
				{
					String str = setTargetDeliveryLoc.getText();
					LOG.info("Target Delivery Location details "+str);
				}
				
			}
			public void verifySetDeliveryLoc() {
				
				if(isElementVisible(By.xpath(".//*[@id='onActionSetDeliveryLocation']/a/span")))
				{
					
					targetDeliveryLoc.click();
				}
				else
				{
					LOG.info("Set Target Delivery Location is not available");
				}
				
			}

			public void clickCopyTo() {
				waitForElementX(".//*[contains(text(),'Copy to...')]",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				copyTo.click();
				
			}
			
			
			public void ePubDraftClick(String shortname) {
				System.out.println(shortname);
				waitForElementX("(.//*/a[contains(text(),'.epub')])[1]",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				ePubDraft.click();
				waitABit(8000);
				Log.info("ePub draft generated successfully");
				
			}
			
			
			public void deepCopyTo(String site) {
			
				waitForElementX(".//*[contains(text(),'Enhanced Deep Copy to..')]",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			
				deepCopyTo.click();
				waitABit(3000);
				checkPS.click();
				checkSB.click();
				checkCCO.click();
				checkAsset.click();
				preFix.clear();
				preFix.sendKeys("EDC");
				Select dest = new Select(destination);
				dest.selectByVisibleText(site);
				waitABit(3000);
				enDeepCopy.click();
			}
			
			
			public void enhDeepCopySearchReplace(String site) {
				
				waitForElementX(".//*[contains(text(),'Enhanced Deep Copy to..')]",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			
				deepCopyTo.click();
				waitABit(3000);
				replace.clear();
				replace.sendKeys("EDC");
				replaceWith.clear();
				replaceWith.sendKeys("Replace");
				Select dest = new Select(destination);
				dest.selectByVisibleText(site);
				waitABit(3000);
				enDeepCopy.click();
			}
			
			/*public void selectedItemsClick() {
				
				selectedItems.click();
				WebElement copy = WebElement(By.cssSelector(".onActionCopyTo")).Click();
			
				
			}*/
			
			
			
			
			String documentCheckboxIdentifier = "td[headers*=\'nodeRef\'] > div > input"; 

			public void documentCheckboxClick() {
				docCheckboxIdentifier.get(0).click();
				}

			
			public void generateJsonFile() {
				
				if(isElementVisible(By.xpath(".//*[@id='onActionSimpleRepoAction']/a/span")))
				{
					
					generateJsonFile.click();
				}
				else
				{
					LOG.info("Generate details.json File option is not available");
				}
				
			}

			public void json(String objectName) {
				
				waitForElementX(".//*/a[contains(text(),'"+"/Assets/details_"+objectName.toLowerCase()+".json"+"')]",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				
				Log.info("Successfully generated details.json file");
				
				
			}
			
			public void validComStruc() {
				//waitForElementX(".//span[text()='Validate COM Structure']",
				//	ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				//disableFlash();
				waitABit(2000);
				element(validateComStruc).waitUntilVisible();
				validateComStruc.click();
				//waitABit(2000);
			}
			
			public void validComStructure() {

				waitABit(3000);
				WebElement item = getDriver().findElement(By.xpath(".//span[text()='Validate COM Structure']"));
				JavascriptExecutor js = (JavascriptExecutor)getDriver();
				//** Fix provided on 16th Oct ** BVT REG097 **
				js.executeScript("arguments[0].scrollIntoView(true);", item);
				js.executeScript("arguments[0].click();", item);
				waitABit(2000);
			}
			
			public void importComStruc() {
				//waitForElement("a[title='Import COM Structure'] span",
				//		ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				//disableFlash();
				waitABit(2000);
				
				//** Fix provided on 16th Oct ** BVT REG097 **
				JavascriptExecutor js = (JavascriptExecutor)getDriver();				
				js.executeScript("arguments[0].scrollIntoView(true);", importComStruc);
				js.executeScript("arguments[0].click();", importComStruc);
				/*element(importComStruc).waitUntilVisible();
				importComStruc.click();*/
				waitABit(3000);
			}

			//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**			
			public void uploadNewVersionButtonDocumentActionsClick() {
				waitABit(1000);
				element(uploadNewVersionButton).waitUntilVisible();
				uploadNewVersionButton.click();
				}
	
			//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
			public void uploadNewVersionDocument(String filePath) {
			
				element(uploadNewVersionDocument).waitUntilVisible();
				uploadNewVersionDocument.click();
				uploadNewVersionDocument.sendKeys(filePath);
			
				
			}
		//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**	
			public void uploadButtonClick() {
				waitABit(1000);
				element(uploadButton).waitUntilVisible();
				uploadButton.click();
			}
		//*****ALF -2099  - Exclude Habitat-Generated ePubs from Deep Copy **Sprint 7.3.2 **
			public void epubNotPresent(final String assetName) {
				waitABit(5000);
				System.out.println(assetName);
				boolean isAssetPresent = false;
				String s = new StringBuilder().append(assetName).append("_teacher.epub").toString();
				String ePubasset = "//a[@class='dynatree-title']//div[contains(text(),'"+s+"')]";
				
				isAssetPresent=waitUntilElementNotPresentOrInvisible(By.xpath(ePubasset), 1000);
				if (isAssetPresent == true) {
					waitABit(3000);
					System.out.println("Enhanced Deep copied structure excludes ePub and verified successfully..");

				}
				
				Assert.assertTrue(
						"Asset is present in the list!",
						isAssetPresent);
			}
		//** ALF -2099 ** - Exclude Habitat-Generated ePubs from Deep Copy **Sprint 7.3.2 **	
			public void deepCopy(String site) {
				
				waitForElementX(".//*[contains(text(),'Enhanced Deep Copy to..')]",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());				
				deepCopyTo.click();
				waitABit(3000);
				checkPS.click();
				checkSB.click();
				checkCCO.click();
				checkAsset.click();
				preFix.clear();
				preFix.sendKeys("EDC");
				Select dest = new Select(destination);
				List<WebElement> items = dest.getOptions();
				for(WebElement e : items)
				{
					if(e.getText().toLowerCase().contains(site.toLowerCase()))
					{
						System.out.println("Site found in deep copy");
						dest.selectByVisibleText(e.getText());					
					}}
				enDeepCopy.click();
			}
			
			public void clickOnValidateLearningSpine() {
				waitForElementX(".//*[text()='Validate Learning Spine']",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				element(learningSpine).waitUntilVisible();
				learningSpine.click();
				System.out.println("validate learning spine");
			}
			
			public void clickOnUploadLearningSpine() {
				waitForElementX(".//*[text()='Upload Learning Spine']",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				element(uploadLS).waitUntilVisible();
				uploadLS.click();
				System.out.println("upload learning spine");
		  	}

		//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.3 **
			public void uploadLearningSpineNotPresent() {
				boolean isAssetPresent = false;
				isAssetPresent=waitUntilElementNotPresentOrInvisible(By.xpath(".//*[text()='Upload Bulk LearningSpine']"), 1000);
				if (isAssetPresent == true) {
					waitABit(3000);
					System.out.println("Upload Learning Spine folder is not present in the list");

				}
				
				Assert.assertTrue(
						"Asset is present in the list!",
						isAssetPresent);
			}

		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
			public void assetFromSearchResultsListClick(String assetName) {
				
				waitABit(500);
				System.out.println(assetName);
				boolean isAssetPresent = false;
				String assetX = ".//span[text()='"
						+ assetName + "']";

				isAssetPresent = isElementVisible(By.xpath(assetX));
				waitABit(500);
				if (isAssetPresent == true) {
					
					getDriver().findElement(By.xpath(assetX)).click();
					waitABit(500);
					
				}
				else
				{
					LOG.info("Element not found");
				Assert.assertTrue(
						"Asset is not in the list! or not loaded in 5 Minutes",
						isAssetPresent);
				}
			}

		// ** Fixed Regression Script REG044 - Edit habitat data in InkLink site ** Sprint 7.3.3. **
			public void verifyCCOIsPresent(String objectName) {
				
				boolean found = false;
				String asset = "//table/tbody/tr/td[5]/div/h3/span[2]/a";
				waitForElementX(asset, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,
						getDriver());
				
				WebElement listPresent = getDriver().findElement(By.xpath(asset));
					
				if (listPresent.isDisplayed()) {
					waitABit(500);
					getDriver().findElement(By.xpath(asset)).click();			
					System.out.println("Asset/Object is found:  " + objectName);
					
				} else
				
				Assert.assertTrue("The Asset not found in Document Library" + objectName,
						found);
				
			}

		//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
			public void deleteDocOnViewDetailsLS() {
				waitForElementX(".//*[text()='Delete Document']",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				element(deleteLS).waitUntilVisible();
				deleteLS.click();
				System.out.println("Deleted Document");
				element(deleteButtonLS).waitUntilVisible();
				deleteButtonLS.click();
				
				
			}

		//** Create new PSF  **Habitat functionality changes Sprint 7.3.5 **
			public void createPSFFolder(String name) {
				waitForElementX(".//button[text()='Create...']",
						ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				element(createButtonOnPSF).waitUntilVisible();
				createButtonOnPSF.click();
				element(createPSF).waitUntilVisible();
				createPSF.click();
				
				createPSFName.clear();
				createPSFName.sendKeys(name);
				
				saveButton.click();			
				
			}
					
				
}


