package com.hmh.automation.pages;

import java.util.Arrays;
import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.hmh.automation.tools.AbstractBaseSiteTestNew;
import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.alfresco.EditPropertiesDocumentPage;

public class HMHEditPropertiesPage extends EditPropertiesDocumentPage {

	public HMHEditPropertiesPage(WebDriver driver) {
		super(driver);
	}
	int i=1;

	@FindBy(css = "select[id*='publicationRights'] option")
	private List<WebElement> rightsList;
	
	@FindBy(xpath = ".//*[text()='Generate Trade Renditions']")
	private WebElement tradeRendition;
	
	@FindBy(css = "select[id*='prop_hmh-cms_intendedUserRole'] option")
	private List<WebElement> roleList;
	
	
	@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_intendedUserRole']/option")
	private List<WebElement> userRoleList;
	
	@FindBy(css = "div.document-edit-metadata > a")
	private WebElement Editproperty;

	@FindBy(css = "select[id*='hmh-cms_grade-entry'] option")
	private List<WebElement> gradesList;

	@FindBy(css = "textarea[id*='prop_cm_description']")
	private WebElement descriptionTextAreaInput;
	
	@FindBy(xpath = ".//*[text()='Previous Unique ID:']/following::input[1]")
	private WebElement prevUnIdTextAreaInput;

	@FindBy(xpath = ".//*/input[@class='formsCheckBox']")
	private WebElement searchChkBox;
	
	@FindBy(css = "textarea[id*='prop_cm_title']")
	private WebElement titleTextAreaInput;

	@FindBy(xpath = ".//*/input[@name='prop_hmh-cms_keywords']")
	private WebElement HMHKeywordsTextAreaInput;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	private WebElement confirmEditButton;

	@FindBy(css = "select[id$='learningStyles-entry'] option")
	private List<WebElement> learningStylesList;

	@FindBy(css = "select[id*='prop_hmh-cms_lifecycle'] option")
	private List<WebElement> lifecycleList;

	@FindBy(css = "select[id*='hmh-cms_markets-entry'] option")
	private List<WebElement> marketList;

	@FindBy(css = "select[id*='subMarketsStates-entry'] option")
	private List<WebElement> subMarkestUsList;

	@FindBy(css = "select[id*='subMarketsInternational-entry'] option")
	private List<WebElement> subMarketsInternationalList;

	@FindBy(css = "select[id$='productTypeID-entry'] option")
	private List<WebElement> productTypeIDList;
	
	//Delivery Structure check box
	@FindBy(xpath = "//input[contains(@id,'isDeliveryStructure-entry')]")
	private WebElement deliveryStrucure;
	
	//Create Downloadable check box
	@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_createDownloadableEpub-entry']")
	private WebElement downloadepub;
	
	//Program Label Text box
	@FindBy(id = "template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_programLabel")
	private WebElement programLabel;
	
	//added by cts QA
	@FindBy(css = "select[id$='resourceType'] option")
	private List<WebElement> resourceTypeList;

	@FindBy(xpath = ".//*[@id='template_x002e_document-actions_x002e_document-details_x0023_default-actionSet']/div/a/span[contains(text(),'Edit Properties')]")
	private WebElement editPropertiesDetails;

	@FindBy(css = "select[id*='productCategory-entry']")
	private WebElement prodCat; 

	@FindBy(css = "select[id*='productType'] option ")
	private List<WebElement> productType; 

	@FindBy(css = "select[id*='productTypeID'] option ")
	private List<WebElement> prodTypeID; 

	@FindBy(css = "input[id*='productTypeSubID'] ")
	private WebElement productSub; 

	@FindBy(css = "select[id*='intendedUserRole'] option ")
	private List<WebElement> useeRol; 

	@FindBy(css = "select[id*='activityType'] option ")
	private List<WebElement> activeType;

	@FindBy(css = "select[id*='studentFacing'] option ")
	private List<WebElement> studentFace;

	@FindBy(css = "select[id$='hmh-cms_hmhOriginal'] option")
	private List<WebElement> cwOriginalContentList;        

	@FindBy(css = "select[id*='interest-entry']")
	private WebElement interestList; 

	@FindBy(css = "select[id$='prop_hmh-cms_characters'] option")
	private List<WebElement> charactersList;  

	@FindBy(css = "select[id*='hmh-cms_minViewPortSize-entry']")
	private WebElement minViewportSizeList; 

	@FindBy(css = "select[id$='hmh-cms_hmhFeaturedCollection'] option")
	private List<WebElement> featuredList; 

	@FindBy(css = "select[id$='learningStyles-entry']")
	private WebElement learningStylesListMulti;

	@FindBy(css = "select[id$='events-entry']")
	private WebElement eventsList;

	@FindBy(css = "select[id$='hmh-cms_productType'] option")
	private List<WebElement> productTypeList;

	@FindBy(css = "select[id*='productTypeID'] option ")
	private List<WebElement> prodTypeIDList;

	@FindBy(css = "button[id $='form-submit-button']")
	private WebElement saveButton;

	@FindBy(css="input[id*='excludeLevelNumber-entry']")
	private WebElement excludeLevelNumberCHKBOX;

	@FindBy(css="input[id*='excludeLevelLabel-entry']")
	private WebElement excludeLevelLabelCHKBOX;

	@FindBy(css="input[id*='sequenceBundleLabel']")
	private WebElement sbLabelInput; //Label to be used instead of Product Set level label

	@FindBy (css="div.form-field input[id*='coLabel']")
	private WebElement ccoLabelInput;

	//MasterLibrary folder edit properties 

	@FindBy(css="div[id*='assoc_hmh-cms_psreferences-cntrl-itemGroupActions']>span>span>button[type$='button']")
	private WebElement productSetRefSelect;

	@FindBy(css = "div[id*='psreferences-cntrl-picker-results'] tbody[class$='data'] tr h3 a")
	private List<WebElement> itemsSelectPSrefDialgoBox;
	@FindBy(css = "button[id*='cntrl-ok-button']")
	private WebElement okButton;
	@FindBy(css="div.form-field input[id*='level1Label']")
	WebElement level1LabelInput;
	@FindBy(css="div.form-field select[id*='level1Restart']")
	List<WebElement> level1Numbering;
	@FindBy(css="div.form-field input[id*='level2Label']")
	WebElement level2LabelInput;
	@FindBy(css="div.form-field select[id*='level2Restart']")
	List<WebElement> level2Numbering;
	@FindBy(css="div.form-field input[id*='level6Label']")
	WebElement level6LabelInput;
	@FindBy(css="div.form-field select[id*='level6Restart']")
	List<WebElement> level6Numbering;
	
	//Select Differentiation Level on Edit properties (Sprint 7.2.5) 
	@FindBy(xpath=".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_differentiationLevel']/option")
	List<WebElement> selectDiffLevel;
	
	//Programlabel in Advanced search
	@FindBy(css = "input[id*='default_1_prop_hmh-cms_programLabel']")
	private WebElement advSearchProgramlabel;
	
	//Product Category Position Text box
	@FindBy(css="input[id*='prop_hmh-cms_productCategoryPosition']")
	WebElement productCategoryPosition;
			
	//Product Category Title Text box
	@FindBy(css="input[id*='prop_hmh-cms_productCategoryTitle']")
	WebElement productCategoryTitle;
			
	//Launch Type Text box
	@FindBy(css="input[id*='prop_hmh-cms_launchType']")
	WebElement productLaunchType;
	
	//HMH ID Text Box
	@FindBy(css="input[id*='prop_hmh-cms_productTypeSubID']")
	WebElement hmhID;
	
	//Assessment Bank ID Text Box
	@FindBy(css="input[id*='prop_hmh-cms_assessmentBankID']")
	WebElement assessmentbankID;
	
	//HMH ID Help Icon
	@FindBy(css="img[id*='prop_hmh-cms_productTypeSubID-help-icon']")
	WebElement hmhIDHelpIcon;
	
	//HMH ID Help Icon Text
	@FindBy(css="div[id*='prop_hmh-cms_productTypeSubID-help']")
	WebElement hmhIDHelpIconText;
	
	//Product Category Icon Text Box
	@FindBy(css="input[id*='prop_hmh-cms_productCategoryIcon']")
	WebElement productCategoryIconText;
	
	//Asset Management Site Elements
	@FindBy(css = "input[id*='default_prop_cm_name']")
	private WebElement nameTextbox;


	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_assetStatus']")
	private List<WebElement> assetStatusList;
	
	@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms-dam_assetType']")
	private List<WebElement> assettypeList;
	
	@FindBy(xpath = ".//span[text()='Restricted Elo Release:']")
	private WebElement restrictedElo;
	
	@FindBy(xpath = "(.//button[text()='Select'])[2]")
	private WebElement selectCategory;
		
	@FindBy(xpath = ".//a[text()='Discipline']")
	private WebElement selectDiscipline;
	
	@FindBy(xpath = ".//*[text()='Mathematics']/following::td[1]")
	private WebElement selectMathCategory;
	
	@FindBy(xpath = ".//*[text()='Social Studies']/following::td[1]")
	private WebElement selectSSCategory;

	
	@FindBy(xpath = ".//a[text()='k-12']")
	private WebElement selectK12;
	
	@FindBy(css = "div[id*='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_cm_categories-cntrl-picker-results'] tbody[class$='data'] tr h3 a")
	private List<WebElement> itemsSelectCategoryDialgoBox;
	
	@FindBy(css = "input[id*='edit-metadata_x0023_default_prop_hmh-cms-dam_plannedAssetReleaseDate-cntrl-date']")
	private WebElement plannedAssetReleaseDate;	
 

	@FindBy(css = "input[id*='edit-metadata_x0023_default_prop_hmh-cms-dam_actualAssetReleaseDate-cntrl-date']")
	private WebElement actualAssetReleaseDate;
	
	
	
	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_isRenditionsCreated']")
	private List<WebElement> renditionsCreatedList;
	
	
	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_isAssetReleaseRestricted'] option")
	private List<WebElement> assetReleaseRestrictedList;
	
	
	@FindBy(css = "textarea[id*='default_prop_hmh-cms-dam_assteReleaseNotes']")
	private WebElement assteReleaseNotesTextbox;
	
	
	@FindBy(css = "textarea[id*='default_prop_hmh-cms-dam_assetStatusNotes']")
	private WebElement assetStatusNotesTextbox;
	
	
	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_assetType'] option")
	private List<WebElement> assetTypeList;
	
	
	@FindBy(css = "textarea[id*='default_prop_hmh-cms-dam_assetTypeNotes']")
	private WebElement assetTypeNotesTextbox;
	
	
	@FindBy(css = "textarea[id*='default_prop_hmh-cms-dam_proposedProdEffectsNotes']")
	private WebElement proposedProdEffectsNotesTextbox;
	
	
	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_isAssetWebEnhanced']")
	private List<WebElement> assetWebEnhancedList;
	
	
	@FindBy(css = "textarea[id*='default_prop_hmh-cms-dam_collectionTitle']")
	private WebElement collectionTitleTextbox;
	
	
	@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms-dam_author']")
	private WebElement author1Textbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_author2']")
	private WebElement author2Textbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_bookTitle']")
	private WebElement bookTitleTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_subTitle']")
	private WebElement booksubTitleTextbox;
	
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_isbn13']")
	private WebElement isbn13Textbox;
	
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_materialNumber']")
	private WebElement materialNumberTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_workkey']")
	private WebElement workkeyTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_format']")
	private WebElement formatTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_bisacStatus']")
	private WebElement bisacStatusTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_season']")
	private WebElement seasonTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_imprintGroup']")
	private WebElement imprintGroupTextbox;
	
	
	
	@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms-dam_imprint']")
	private WebElement imprintTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_pageCount']")
	private WebElement pageCountTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_trimSize']")
	private WebElement trimSizeTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_price']")
	private WebElement priceTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_editor1']")
	private WebElement editor1Textbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_editor2']")
	private WebElement editor2Textbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_managingEditor1']")
	private WebElement managingEditor1Textbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_managingEditor2']")
	private WebElement managingEditor2Textbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_designer']")
	private WebElement designerTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_jacketDesigner']")
	private WebElement jacketDesignerTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_illustrator']")
	private WebElement illustratorTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_ageRange']")
	private WebElement ageRangeTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_gradeRange']")
	private WebElement gradeRangeTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_bisacsubject']")
	private WebElement bisacsubjectTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_audience']")
	private WebElement audienceTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_series']")
	private WebElement seriesTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_volume']")
	private WebElement volumeTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_keyTitleIndicator']")
	private WebElement keyTitleIndicatorTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_primaryIsbn']")
	private WebElement primaryIsbnTextbox;
	
	
	@FindBy(css = "input[id*='default_prop_hmh-cms-dam_associatedIsbns']")
	private WebElement associatedIsbnsTextbox;
	
	
	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_neverSendToElo']")
	private List<WebElement> SendToEloquenceList;
	
	
	@FindBy(css = "select[id*='default_prop_hmh-cms-dam_proposedProdEffects-entry']")
	private WebElement proposedProdEffectsentry;
	
	
	//Verify name for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[1]/div[1]/div/span[2]")
	private WebElement am_Name;
	
	//Verify Asset Release Date Notes for Asset management
	@FindBy(xpath = ".//*/span[contains(text(),'Asset Release Date Notes')]/following::span[1]")
	private WebElement am_AssetReleasedatenotes;
	
	
	//Verify Asset Asset Status / Rights Notes for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[3]/div/div[2]/div[7]/div/span[2]")
	private WebElement am_AssetStatusnotes;
	
	//Verify Asset Type Notes  for Asset management
	@FindBy(xpath = ".//*/span[contains(text(),'Asset Type Notes:')]/following::span[1]")
	private WebElement am_AssetTypeNotes;
	
	//Verify Proposed Production Effects Notes  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[3]/div/div[2]/div[11]/div/span[2]")
	private WebElement am_ProposedProductionEffectsNotes;
	
	
	//Verify Collection Title  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[3]/div/div[2]/div[13]/div/span[2]")
	private WebElement am_CollectionTitle;
	
	
	//Verify Author 1  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[1]/div/span[2]")
	private WebElement am_Author1;
	
	//Verify Author 2  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[2]/div/span[2]")
	private WebElement am_Author2;
	
	//Verify Book Title  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[3]/div/span[2]")
	private WebElement am_BookTitle;
	
	//Verify Book Subtitle  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[4]/div/span[2]")
	private WebElement am_BookSubtitle;
	
	//Verify ISBN-13  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[5]/div/span[2]")
	private WebElement am_ISBN13;
	
	//Verify  Material Number  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[6]/div/span[2]")
	private WebElement am_MaterialNumber;
	
	
	//Verify  Workkey  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[7]/div/span[2]")
	private WebElement am_Workkey;
	
	//Verify  Format  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[8]/div/span[2]")
	private WebElement am_Format;
	
	//Verify  BISAC Status  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[9]/div/span[2]")
	private WebElement am_BISACStatus;
	
	//Verify  Season  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[10]/div/span[2]")
	private WebElement am_Season;
	
	//Verify  Imprint Group  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[11]/div/span[2]")
	private WebElement am_ImprintGroup;
	
	//Verify  Imprint  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[4]/div/div[2]/div[12]/div/span[2]")
	private WebElement am_Imprint;
	
	//Verify  Page Count  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[1]/div/span[2]")
	private WebElement am_PageCount;
	
	//Verify  Trim Size  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[2]/div/span[2]")
	private WebElement am_TrimSize;
	
	//Verify  Price  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[3]/div/span[2]")
	private WebElement am_Price;
	
	//Verify  Editor 1  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[8]/div/span[2]")
	private WebElement am_Editor1;
	
	//Verify  Editor 2  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[9]/div/span[2]")
	private WebElement am_Editor2;
	
	//Verify   Managing Editor 1  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[10]/div/span[2]")
	private WebElement am_ManagingEditor1;
	
	//Verify   Managing Editor 2  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[11]/div/span[2]")
	private WebElement am_ManagingEditor2;
	
	//Verify   Designer  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[12]/div/span[2]")
	private WebElement am_Designer;
	
	//Verify   Jacket Designer  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[13]/div/span[2]")
	private WebElement am_JacketDesigner;
	
	//Verify   Illustrator  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[14]/div/span[2]")
	private WebElement am_Illustrator;
	
	//Verify   Age Range  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[15]/div/span[2]")
	private WebElement am_AgeRange;
	
	//Verify   Grade Range  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[16]/div/span[2]")
	private WebElement am_GradeRange;
	
	//Verify   BISAC Subject  for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[17]/div/span[2]")
	private WebElement am_BISACSubject;
	
	
	//Verify   Audience for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[18]/div/span[2]")
	private WebElement am_Audience;
	
	//Verify   Series for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[19]/div/span[2]")
	private WebElement am_Series;
	
	//Verify   Volume for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[20]/div/span[2]")
	private WebElement am_Volume;
	
	//Verify   Key Title Indicator for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[21]/div/span[2]")
	private WebElement am_KeyTitleIndicator;
	
	//Verify   Primary ISBN for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[22]/div/span[2]")
	private WebElement am_PrimaryISBN;
	
	//Verify   Associated ISBNs for Asset management
	@FindBy(xpath = ".//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[5]/div/div[2]/div[23]/div/span[2]")
	private WebElement am_AssociatedISBNs;
	
	
	//Verify Asset status for Asset management
	@FindBy(xpath = "//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[3]/div/div[2]/div[1]/div/span[2]")
	private WebElement am_AssetStatus;
	
	
	//Verify Renditions created for Asset management
	@FindBy(xpath = "//*[@id='template_x002e_document-metadata_x002e_document-details_x0023_default-formContainer-form-fields']/div[3]/div/div[2]/div[4]/div/span[2]")
	private WebElement am_RenditionsCreated;
	
	//Verify Proposed multiple select for Asset management
	@FindBy(xpath = ".//*/span[contains(text(),'Proposed Production Effects:')]/following::span[1]")
	private WebElement am_proposedProdMultiplselect;

	// HIP objects edit properties
		@FindBy(css = "input[id*='prop_hmh-cms_caption']")
		private WebElement captionInput;
		
		@FindBy(css="div.form-field select[id*='hmh-cms_hipGenre'] option")
		List<WebElement> genreSelect;
		
		@FindBy(css = "select[id*='hmh-cms_assetsubType'] option")
		private List<WebElement> assetTypeSelect;
	
		// Tag Items
		@FindBy(css = "input[class='create-new-input']")
		private WebElement tagsTextBox;
		
		//URI Primary Text Box
		@FindBy(css = "#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_uriPrimary")
		private WebElement uriPrimaryTextBox;
			
		//URI Supplemental Text Box
		@FindBy(css = "#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_uriSupplemental")
		private WebElement uriSupplementalTextBox;
		
		//URI Primary Help Icon
		@FindBy(css = "#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_uriPrimary-help-icon")
		private WebElement uriPrimaryHelpIcon;
		
		//URI Help Icon Text
		@FindBy(css = "#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_uriPrimary-help")
		private WebElement uriPrimaryHelpIconText;
		
		//URI Supplemental Help Icon
		@FindBy(css = "#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_uriSupplemental-help-icon")
		private WebElement uriSupplementalHelpIcon;
		
		//URI Supplemental Help Text
		@FindBy(css = "#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_uriSupplemental-help")
		private WebElement uriSupplementalHelpIconText;
		
		@FindBy(css = "button[id $='prop_cm_taggable-cntrl-picker-navigator-button']")
		private WebElement tagsButton;
		@FindBy(css = "div.bd a > span.item-name")
		public WebElement tagsDropDownButton;
		@FindBy(css = "span[id $='prop_cm_taggable-cntrl-ok']")
		private WebElement tag_okButton;
		
		String tagsListContainer = "div[id $='prop_cm_taggable-cntrl-picker-left'] tbody[class $='data']";
		String addTagPlusIcon = "a[class^='add-item'] span[class ='addIcon']";
		String removeTagIcon = "span[class ='removeIcon']";
		String tagsLeft = "div[id $='prop_cm_taggable-cntrl-picker-left'] tbody[class $='data'] tr";
		String tagTitle = "td[headers*=name] div";
		
		//BrightCove Account Name Field edit page
		@FindBy (css="#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_accountName")
		private WebElement brtacname;
		
		@FindBy (css="#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_brightcoveLocationID")
		private WebElement brtlocid;
		
		@FindBy (css="#template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_brightcoveID")
		private WebElement brtcovid;
		
		@FindBy (xpath=".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_accountName']/option[1]")
		private WebElement dfltbrtacname;
	
	
		//BrightCove Account Name Field on page
		@FindBy (xpath=".//*[contains(text(),'Brightcove Account Name:')]/following::span[1]")
		private WebElement vrfybrtacname;
		
		@FindBy (xpath=".//*[contains(text(),'Brightcove Location ID:')]/following::span[1]")
		private WebElement vrfybrtlocid;
		
		@FindBy (xpath=".//*[contains(text(),'Brightcove ID:')]/following::span[1]")
		private WebElement vrfybrtcovid;
		//verify the Pop up message for invalid characters on program label field
		@FindBy (xpath=".//*[@title='Value contains illegal characters.']")
		private WebElement vrfyPopupMessageProgramLabel;
		//Verify the Tool tip on program label metadata field
		@FindBy (xpath=".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_programLabel-help']")
		private WebElement vrfyToolTipProgramLabel;
		
		@FindBy(xpath = ".//*[@id='regenerateEpubID']")
		private WebElement selectRegenerateEpub;
		//Asset Management Site Elements
		
		@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_teProductLabel-help-icon']")
		private WebElement teacherProductLabelToolTip;
		
		@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_teProductLabel']")
		private WebElement selectTeacherProductLabel;
		
		@FindBy(xpath = ".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_standardsRecommendation']/option")
		private  List<WebElement> standardRecommendationDropdownValue;
		
		@FindBy(xpath = ".//div[@class='folder-view-details']/a")
		private WebElement viewDetailsOnRenditionsFolder;
		
		@FindBy(xpath = "(.//a[text()='Renditions']/following::td[contains(@class,'yui-dt')])[1]")
		private WebElement moreActionsSectionOnRenditionsFolder;
		
		@FindBy(xpath = "(.//a[text()='Product Sets']/following::td[contains(@class,'yui-dt')])[1]")
		private WebElement moreActionsSectionOnPSFolder;
		
		@FindBy(xpath = ".//*[@id='onActionShowMore']/a")
		private WebElement clickMoreOnFolder;
		
		@FindBy(xpath = ".//*[@id='onActionGenerateCorrelationsReport']/a")
		private WebElement clickGenerateCorrelationAction;
		
		@FindBy(xpath = ".//*[@id='onActionLearningSkillCorrelation']/a/span")
		private WebElement clickCorrelateLearningSkills;
		
		@FindBy(xpath = ".//span[text()='All Sites']")
		private WebElement allSites;
		
		@FindBy(xpath = "(//table/tbody//tr/td[3]/span/img)[1]")
		private WebElement selectAssets;
		
		@FindBy(xpath = ".//span[text()='Move']")
		private WebElement moveButtonClick;		
			
			
		private String itemNames = "div[id*='psreferences-cntrl-picker-results'] tbody[class$='data'] tr";
		private String referenceItemAddButton = " span";


	public void editRights(String right) {
		boolean rightsFound = false;
		for (WebElement rightsElement : rightsList) {
			if (rightsElement.getText().toLowerCase().contentEquals(right.toLowerCase())) {
				rightsFound = true;
				rightsElement.click();
				break;
			}
		}
		Assert.assertTrue("The right was not found", rightsFound);
	}

	public void editGrades(String grade) {
		System.out.println(grade);
		boolean gradeFound = false;
		for (WebElement gradeElement : gradesList) {
			if (gradeElement.getText().toLowerCase().contentEquals(grade.toLowerCase())) {
				gradeFound = true;
				waitABit(3000);
				gradeElement.click();
				waitABit(3000);
				break;
			}
		}
		Assert.assertTrue("The grade was not found", gradeFound);
	}

	@Override
	public void editDescription(String descritpion) {
		waitForElement("textarea[id*='prop_cm_description']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(descriptionTextAreaInput).waitUntilVisible();
		descriptionTextAreaInput.clear();
		descriptionTextAreaInput.sendKeys(descritpion);
	}

	
	public void editPrevUniqId(String PrevUnId) {
		waitForElementX(".//*[text()='Previous Unique ID:']/following::input[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(prevUnIdTextAreaInput).waitUntilVisible();
		prevUnIdTextAreaInput.clear();
		prevUnIdTextAreaInput.sendKeys(PrevUnId);
	}
	
	public void searchCheckBox() {
		waitForElementX(".//*/input[@class='formsCheckBox']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(searchChkBox).waitUntilVisible();
		searchChkBox.isSelected();
		searchChkBox.click();
	}
	
	@Override
	public void editTitle(String title) {
		waitForPageToLoadCompletely(150);
		element(titleTextAreaInput).waitUntilVisible();
		titleTextAreaInput.clear();
		titleTextAreaInput.sendKeys(title);
	}
	
	
	public void editHMHKeywords(String keyword) {
		waitForPageToLoadCompletely(150);
		waitForElementX(".//*/input[@name='prop_hmh-cms_keywords']",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		LOG.info("Found HMHKeyword text field");
		HMHKeywordsTextAreaInput.clear();
		HMHKeywordsTextAreaInput.sendKeys(keyword);
	}

	public void confirmMultipleEdit() {
		element(confirmEditButton).waitUntilVisible();
		confirmEditButton.click();
	}

	public void editLearningStyles(String learningStyle) {
		boolean found = false;
		System.out.println("Learning Style"+learningStyle);
		for (WebElement style : learningStylesList) {
			if (style.getText().toLowerCase().contains(learningStyle.toLowerCase())) {
				found = true;
				waitABit(3);
				style.click();
				break;
			}
		}
		Assert.assertTrue("The learning style was not found", found);
	}

	public void editLifeCycle(String lifeCycle) {
		boolean found = false;
		for (WebElement cycle : lifecycleList) {
			if (cycle.getText().toLowerCase().contains(lifeCycle.toLowerCase())) {
				found = true;
				cycle.click();
				break;
			}
		}
		Assert.assertTrue("The lifecycle was not found ", found);
	}

	public void editMarkets(String markets) {
		boolean found = false;
		for (WebElement market : marketList) {
			if (market.getText().toLowerCase().contains(markets.toLowerCase())) {
				found = true;
				market.click();
				break;
			}
		}
		Assert.assertTrue("The markets was not found ", found);
	}

	public void editSubMarketUS(String subMarket) {
		boolean found = false;
		for (WebElement market : subMarkestUsList) {
			if (market.getText().toLowerCase().contains(subMarket.toLowerCase())) {
				found = true;
				market.click();
				break;
			}
		}
		Assert.assertTrue("The sub market US was not found ", found);
	}

	public void editSubMarketInternational(String subMarket) {
		boolean found = false;
		for (WebElement market : subMarketsInternationalList) {
			if (market.getText().toLowerCase().contains(subMarket.toLowerCase())) {
				found = true;
				market.click();
				break;
			}
		}
		Assert.assertTrue("The sub market International was not found ", found);
	}

	public void editProductTypeID(String id) {
		boolean found = false;
		for (WebElement productTypeID : productTypeIDList) {
			if (productTypeID.getText().toLowerCase().contains(id.toLowerCase())) {
				found = true;
				productTypeID.click();
				break;
			}
		}
		Assert.assertTrue("The product type id was not found ", found);
	}

	public void editResourceType (final String resourceType) {
		boolean resourceTypeFound = false;
		for (final WebElement resource : resourceTypeList) {
			if (resource.getText().toLowerCase().contains(resourceType.toLowerCase())) {
				resourceTypeFound = true;
				resource.click();
				break;
			}
		}
		Assert.assertTrue("The resource type was not found", resourceTypeFound);
	}



	public void clickOnEditPropertiesDetails() {

		waitForPageToLoadCompletely(500);
		waitForElementX(".//*[@id='template_x002e_document-actions_x002e_document-details_x0023_default-actionSet']/div/a/span[contains(text(),'Edit Properties')]", 300, getDriver());
		element(editPropertiesDetails).waitUntilClickable();
		editPropertiesDetails.click();    
	}
	public void productTypeDropDown(final String inputProdType) {
		boolean productTypeFound = false;
		for (final WebElement prodType: productType) {
			if (prodType.getText().toLowerCase().contains(inputProdType.toLowerCase())) {
				productTypeFound = true;
				prodType.click();               
				break;
			}  

		}
		Assert.assertTrue("The Product Type Drop down was not found", productTypeFound);
	}

	
	public void verifyProductTypeDropDown(final String productTypeID) {
		boolean productTypeIDFound = false;
		for (final WebElement ProdTypeID: productType) {
			if (ProdTypeID.getText().toLowerCase().contains(productTypeID.toLowerCase())) {
				productTypeIDFound = true;
				LOG.info("elementfound");
				break;
			}

		}
		Assert.assertTrue("The Product Type ID Drop down was not found", productTypeIDFound);
	}
	public void productTypeIDDropDown(final String productTypeID) {
		boolean productTypeIDFound = false;
		/*for (final WebElement ProdTypeID: prodTypeID) {
			if (ProdTypeID.getText().toLowerCase().contains(productTypeID.toLowerCase())) {
				productTypeIDFound = true;
				ProdTypeID.click();
				break;
			}

		}
		*/
		if(isElementVisible(By.cssSelector("select[id*='productTypeID']")))
		{
			productTypeIDFound = true;
			Select drpdown= new Select(getDriver().findElement(By.cssSelector("select[id*='productTypeID']")));
			waitABit(2000);
			drpdown.selectByVisibleText(productTypeID);
		}
		
		Assert.assertTrue("The Product Type ID Drop down was not found", productTypeIDFound);
	}


	public void productTypeSubIDTextBox(String productTypeSubID) {
		waitABit(2000);
		productSub.clear();
		productSub.sendKeys(productTypeSubID);

	}


	public void userRoleDropDown(final String UserRole) {
		waitABit(2000);
		boolean UserRoleFound = false;
		for (final WebElement UseRol: useeRol) {
			if (UseRol.getText().toLowerCase().contains(UserRole.toLowerCase())) {
				UserRoleFound = true;
				UseRol.click();
				break;
			}

		}
		Assert.assertTrue("The User Role Drop down was not found", UserRoleFound);
	}

	public void activityTypeDropDown(final String activityType) {
		boolean activityTypeFound = false;
		waitABit(2000);
		for (final WebElement activType: activeType) {
			if (activType.getText().toLowerCase().contains(activityType.toLowerCase())) {
				activityTypeFound = true;
				activType.click();
				break;
			}

		}
		Assert.assertTrue("The User Role Drop down was not found", activityTypeFound);
	}

	public void studentFacingDropDown(final String studentFacing) {
		waitABit(2000);
		boolean activityTypeFound = false;
		for (final WebElement studentFaceBoolean: studentFace) {
			if (studentFaceBoolean.getText().toLowerCase().contains(studentFacing.toLowerCase())) {
				activityTypeFound = true;
				studentFaceBoolean.click();
				break;
			}

		}
		Assert.assertTrue("The User Role Drop down was not found", activityTypeFound);
	}

	public void productCategoryMultiSelect(String productCategory){
		element(this.prodCat).waitUntilVisible();
		waitABit(2000);
		Select select= new Select(prodCat);                                 
		String productCategorytoSelect[] = productCategory.split(",");      
		select.deselectAll();
		for(String proCat:productCategorytoSelect){             
			select.selectByVisibleText(proCat);                 
		}
		waitABit(2000);

	}

	public void editCwOriginalContent (final String cwOriginalcontent){
		waitABit(2000);
		boolean cwOriginalcontentFound = false;         
		for (final WebElement cwOriginal: cwOriginalContentList) 
		{
			if (cwOriginal.getText().toLowerCase().contains(cwOriginalcontent.toLowerCase())) 
			{
				cwOriginalcontentFound = true;
				cwOriginal.click();                
				break;
			}

		}
		Assert.assertTrue("The CWOriginal Content was not found", cwOriginalcontentFound);
	}
	//




	public void  editInterestWithMultipleSelect(final String interests) {
		waitABit(2000);
		Select allInterests= new Select(interestList);                             
		String interestsToSelect[] = interests.split(",");                  
		for(String interest:interestsToSelect)
		{             
			allInterests.selectByVisibleText(interest);  

		}           
	}               

	public void editCharacterList(final String characters) {
		waitABit(2000);
		boolean characterFound = false;
		for (final WebElement chars : charactersList) {
			if (chars.getText().toLowerCase().contains(characters.toLowerCase())) {
				characterFound = true;
				chars.click();
				break;
			}
		}
		Assert.assertTrue("The character was not found", characterFound);
	}


	public void  editMinViewportSizeList(final String viewportSizes) {
		waitABit(2000);
		Select vpSizes= new Select(minViewportSizeList);                                  
		String vpSizesToSelect[] = viewportSizes.split(",");                
		for(String viewportSize:vpSizesToSelect)
		{             
			vpSizes.selectByVisibleText(viewportSize);   
			System.out.println(viewportSize);
		}           
		//   minViewportSizeList.submit();
	}     


	public void editFeaturedList(String featured) {
		waitABit(2000);
		boolean featuresFound = false;   
		for (final WebElement features: featuredList) 
		{
			if (features.getText().toLowerCase().contains(featured.toLowerCase())) 
			{
				featuresFound = true;
				features.click();                
				break;
			}

		}
		Assert.assertTrue("The Featured values were not found", featuresFound);
	}


	public void editEvents(final String events) {
		waitABit(2000);
		Select allevents= new Select(eventsList);                             
		String eventsToSelect[] = events.split(",");                  
		for(String eves:eventsToSelect){             
			allevents.selectByVisibleText(eves);  
		}           

	}   

	public void  editLearningStylesMutli(final String learningStyle) {
		waitABit(2000);
		Select allLearning= new Select(learningStylesListMulti);                             
		String learningStyleToSelect[] = learningStyle.split(",");                  
		for(String lStyles:learningStyleToSelect)
		{             
			allLearning.selectByVisibleText(lStyles);  

		}   

	}
	public void editProductTypeK12(String productTypes) {
		waitABit(2000);
		boolean productTypeFound = false;   	
		for (final WebElement prdctType: productTypeList)  {
			if (prdctType.getText().toLowerCase().contains(productTypes.toLowerCase())) 
			{
				productTypeFound = true;
				prdctType.click();   

				break;
			}

		}
		Assert.assertTrue("The product type values were not found", productTypeFound);
	}

	public void editProductTypeIDK12(String productTypeID) {
		waitABit(2000);
		boolean productTypeIDFound = false;   	
		for (final WebElement prdctTypeID: prodTypeIDList) 
		{
			if (prdctTypeID.getText().toLowerCase().contains(productTypeID.toLowerCase())) 
			{
				productTypeIDFound = true;
				prdctTypeID.click();                
				break;
			}
			waitABit(2000);
		}
		Assert.assertTrue("The productType ID values were not found",productTypeIDFound);
	}

	//Sequence Bundle Specific Fields	 
	public void selectExcludeLevelNumberCHKBOX() {
		element(excludeLevelNumberCHKBOX).waitUntilVisible();
		excludeLevelNumberCHKBOX.click();
	}

	public void selectExcludeLevelLabelCHKBOX() {
		element(excludeLevelLabelCHKBOX).waitUntilVisible();
		excludeLevelLabelCHKBOX.click();
	}

	public void sequenceBundleLabelInput(String sbLabel) {
		element(sbLabelInput).waitUntilVisible();
		sbLabelInput.clear();
		sbLabelInput.sendKeys(sbLabel);
	}

	public void saveButtonClick() {
		element(this.saveButton).waitUntilVisible();
		this.saveButton.click();
		waitABit(1000);
		waitForElement("div[id='HEADER_SITE_DOCUMENTLIBRARY'] a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());

	}

	//CCO Label field
	public void editCcoLabel(String enterCcoLabel){
		element(this.ccoLabelInput).waitUntilVisible();
		ccoLabelInput.clear();
		ccoLabelInput.sendKeys(enterCcoLabel);
	}

	//Release4 Sprint 4 Publisher Dropdown

	@FindBy (css ="div select[id*='hmh-cms_publisher'] option")
	List<WebElement> publisherList;

	public void publisherDropDown(final String publisher) {
		boolean isFound = false;

		waitABit(2000);

		for (final WebElement publisherIs: publisherList) {

			if (publisherIs.getText().toLowerCase().contains(publisher.toLowerCase())) {
				isFound = true;
				publisherIs.click();
				break;
			}

		}
		Assert.assertTrue("The User Role Drop down was not found", isFound);
	}


	@SuppressWarnings("null")
	public void verifySortingOfPublishingDropDown () {

		boolean isMapped = false;
		String beforePublishers[] = null;
		for(int i=1; i<46; i++)
		{
			beforePublishers[i]= getDriver().findElement(By.cssSelector("div select[id*='hmh-cms_publisher']"+i)).getText();
		}

		System.out.println(Arrays.toString(beforePublishers));

		String afterPublishers[] = null;
		for(int i=0;i<20;i++)
		{
			afterPublishers[i]= getDriver().findElement(By.cssSelector("div select[id*='hmh-cms_publisher']"+i)).getText();
		}

		Arrays.sort(afterPublishers);
		System.out.println(Arrays.toString(afterPublishers));

		if (beforePublishers == afterPublishers) {
			isMapped = true;
		}

		Assert.assertTrue("The  publishing dropdown is not arranged in alphabetical order", isMapped);

	}


	public void manualScrollForSelectButton (int manualScrollSeconds) {

		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(this.productSetRefSelect).build().perform();
			waitABit(1000L);
		}
	}


	//Program Support Folder Specific Fields
	public void clickProductSetRefSelect() {
		waitForElement("div[id*='assoc_hmh-cms_psreferences-cntrl-itemGroupActions']>span>span>button[type$='button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(productSetRefSelect).waitUntilClickable();
		manualScrollForSelectButton(2);
		productSetRefSelect.click();
		waitForElement("button[id*='cntrl-ok-button']", 100, getDriver());
	}
	
	public void waitForLoadingMsgToDissapear(){
		boolean isPresent=isElementVisible(By.xpath("//div[contains(text(),'Loading...')]"));
		for(int i=0;i<60;++i){
			if(isPresent==false){
				break;
			}
			waitABit(500);
			isPresent=isElementVisible(By.xpath("//div[contains(text(),'Loading...')]"));
			i++;
		}
		boolean isStillPresent=isElementVisible(By.xpath("//div[contains(text(),'Loading...')]"));
		for(int i=0;i<60;++i){
			if(isStillPresent==false){
				break;
			}
			waitABit(500);
			isStillPresent=isElementVisible(By.xpath("//div[contains(text(),'Loading...')]"));
			i++;
		}
	}

	public void navigateInPSreferencesDialogBox(String itemName) {
		waitForAngularRequestsToFinish();
		waitForElement("div[id*='psreferences-cntrl-picker-results'] tbody[class$='data'] tr:nth-child(1) h3 a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean found = false;
		for (WebElement item : itemsSelectPSrefDialgoBox) {
			if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
				found = true;
				item.click();
				break;
			}
		}
		Assert.assertTrue("The item was not found in PSF reference dialog box", found);
	}

	public void addPStoMasterReference(String psName) {
		boolean found = false;
		for (WebElement item : getDriver().findElements(By.cssSelector(itemNames))) {
			if (item.getText().toLowerCase().contains(psName.toLowerCase())) {
				found = true;
				if(isElementVisible(By.xpath(".//*[contains(text(),'"+psName+"')]/following::span[1]")))
				{
					WebElement add = item.findElement(By.xpath(".//*[contains(text(),'"+psName+"')]/following::span[1]"));
					add.click();
					LOG.info("PS added to master library site");
				}
				else {
					LOG.info("PS already associated with PSF");
				}
				break;
			}
		}
		Assert.assertTrue("The item was not found in PSF reference dialog box", found);
		okButton.click();
		System.out.println("Added to Program Support Folder in Master Library Site");
	}


	public void clearLevel1Label() {
		element(level1LabelInput).waitUntilVisible();
		level1LabelInput.clear();
	}

	public void editLevel1Label(String level1Label) {
		element(level1LabelInput).waitUntilVisible();
		level1LabelInput.clear();
		level1LabelInput.sendKeys(level1Label);
	}

	public void selectLvl1Number(String level1Number){

		boolean isFound = false;
		for(final WebElement selectNumbering: level1Numbering){
			if(selectNumbering.getText().toLowerCase().contains(level1Number.toLowerCase())){
				isFound=true;
				selectNumbering.click();
				break;
			}
		}
		Assert.assertTrue("The given numbering is not found", isFound);
	}

	public void clearLevel2Label(String level2Label) {
		element(level1LabelInput).waitUntilVisible();
		level1LabelInput.clear();
	}

	public void editLevel2Label(String level2Label) {
		element(level2LabelInput).waitUntilVisible();
		level2LabelInput.clear();
		level2LabelInput.sendKeys(level2Label);
	}

	public void selectLvl2Number(String level2Number){
		boolean isFound = false;
		for(final WebElement selectNumbering: level2Numbering){
			if(selectNumbering.getText().toLowerCase().contains(level2Number.toLowerCase())){
				isFound=true;
				selectNumbering.click();
				break;
			}
		}
		Assert.assertTrue("The given numbering is not found", isFound);
	}

	public void editLevel6Label(String level6Label) {
		element(level6LabelInput).waitUntilVisible();
		level6LabelInput.clear();
		level6LabelInput.sendKeys(level6Label);
	}

	public void selectLvl6Number(String level6Number){
		boolean isFound = false;
		for(final WebElement selectNumbering: level6Numbering){
			if(selectNumbering.getText().toLowerCase().contains(level6Number.toLowerCase())){
				isFound=true;
				selectNumbering.click();
				break;
			}
		}
		Assert.assertTrue("The given numbering is not found", isFound);
	}
	//**** ALF-1975 New Metadata Field on COs, CCOs, and POs: “Differentiation Level" (Sprint 7.2.5)****
	public void selectDifferentiationLevel(String diffLevel){
		boolean isFound = false;
		for(final WebElement selectLevel: selectDiffLevel){
			if(selectLevel.getText().toLowerCase().contains(diffLevel.toLowerCase())){
				System.out.println(selectLevel);				
				isFound=true;
				selectLevel.click();
				break;
			}
		}
		Assert.assertTrue("The given differentiation level is not found", isFound);
	}
	
	
	
	@FindBy(css="input[id*='habitatShortName']")
	WebElement habitatShortName;
	
	public void enterShortNameForHabitat(String habitatShtname) {
		
		/* Old Code 
		 i++;
		//System.out.println("value"+i);
		//String upd=i+"";
		habitatShortName.sendKeys(habitatShtname.toLowerCase()+upd);
		*/
		//**** Fixed on 11/06/2018 (Sprint 7.2.4)****
		waitForElement("input[id*='habitatShortName']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(habitatShortName).waitUntilVisible();
		habitatShortName.clear();
		habitatShortName.sendKeys(habitatShtname.toLowerCase());
		//getDriver().manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(getDriver(),3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms-habitat_habitatShortName']"))).click();
			
		/*if(habitatShortName.isDisplayed()) {
			habitatShortName.sendKeys(habitatShtname);
			wait.until(ExpectedConditions.textToBePresentInElementValue(habitatShortName, habitatShtname));
			*/
	}
	
	public void editUserRoleMetadataField(String role) {
		boolean isFound=false;	
	//	waitForElementX("select[id*='prop_hmh-cms_intendedUserRole'] option",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			for(WebElement roleN : roleList)
			{
				if(roleN.getText().toLowerCase().contains(role.toLowerCase())){
					isFound=true;
					roleN.click();
					break;
				}
			}
			Assert.assertTrue("The User role drop down is not found", isFound);
			
		}
	
	// **Create Downloadable Epub checkbox**
	public void checkCreateDownladableEpub() {
		waitABit(1000);
		element(downloadepub).waitUntilClickable();
		if(!downloadepub.isSelected())
		{
			downloadepub.click();
		}
	}
		
	// **Delivery Structure Check box**
	public void checkDeliveryStructure() {
		waitABit(1000);
		element(deliveryStrucure).waitUntilClickable();
		if(!deliveryStrucure.isSelected())
		{
			deliveryStrucure.click();
		}		
		
	}
	
	//Program Label Text box
	public void programLabel(String textprogramLabel){
	waitABit(1000);
	programLabel.clear();
	programLabel.sendKeys(textprogramLabel); 
		
	}
	//Product Category Position Text box
	public void productCategoryPositionLabel(String textproductCategoryPositionLabel){
	waitABit(1000);
	productCategoryPosition.clear();
	productCategoryPosition.sendKeys(textproductCategoryPositionLabel);
	}
		
	//Product Category Title Text box
	public void productTitleLabel(String textproductTitleLabel){
	waitABit(1000);
	productCategoryTitle.clear();
	productCategoryTitle.sendKeys(textproductTitleLabel);
	}
		
	//Product Launch Type Text box
	public void productLaunchTypeLabel(String textproductLaunchTypeLabel){
	waitABit(1000);
	productLaunchType.clear();
	productLaunchType.sendKeys(textproductLaunchTypeLabel);
	}
	
	//HMH ID Text box
	public void hmhID(String texthmhID){
	waitABit(1000);
	hmhID.clear();
	hmhID.sendKeys(texthmhID); 
	}
	
	//Assessment Bank ID Text box
	public void assessmentbankID(String textassessbankID){
	waitABit(1000);
	assessmentbankID.clear();
	assessmentbankID.sendKeys(textassessbankID); 
	}
	
	//HMH ID Help Icon
	public void hmhIDHelpIcon(String helpText) {
	waitABit(1000);
	element(hmhIDHelpIcon).waitUntilClickable();
	hmhIDHelpIcon.click();
	waitABit(1000);
	Assert.assertTrue("HMH ID Help Text not matched", hmhIDHelpIconText.getText().contains(helpText));
	}
	
	//Product Category Icon Text box
	public void productCategoryIconText(String textproductcategoryIcon){
	waitABit(1000);
	productCategoryIconText.clear();
	productCategoryIconText.sendKeys(textproductcategoryIcon); 
	}
	
	//Asset Management Methods
	//Name Textbox

	public void nameLabel(String nametext) {
	waitABit(2000);
	nameTextbox.clear();
	nameTextbox.sendKeys(nametext);

		}



	//Asset Status dropdown


	public void assetstatusDropDown(final String assetsstatus) {
			waitABit(2000);
			boolean AssetstatusFound = false;
			for (final WebElement assestatus: assetStatusList) {
				if (assestatus.getText().toLowerCase().contains(assetsstatus.toLowerCase())) {
					AssetstatusFound = true;
					assestatus.click();
					break;
				}

			}
			Assert.assertTrue("The Asset status Drop down was not found", AssetstatusFound);
		}
	

	//Renditions Created? Dropdown


	public void renditionsCreatedDropDown(final String renditionCreated) {
			waitABit(2000);
			boolean RenditioCreated = false;
			for (final WebElement RendtionCreated: renditionsCreatedList) {
				if (RendtionCreated.getText().toLowerCase().contains(renditionCreated.toLowerCase())) {
					RenditioCreated = true;
					RendtionCreated.click();
					break;
				}

			}
			Assert.assertTrue("The Rendtion Created Drop down was not found", RenditioCreated);
	}



	//Asset Release Restricted? dropdown




	public void assetReleaseRestrictedDropDown(final String assetReleasRestricted) {
		System.out.println(assetReleasRestricted);	
		waitABit(2000);
			boolean AssetReleseRestricted = false;
			for (final WebElement AssetReleseRestrictd: assetReleaseRestrictedList) {
				if (AssetReleseRestrictd.getText().toLowerCase().contains(assetReleasRestricted.toLowerCase())) {
					AssetReleseRestricted = true;
					AssetReleseRestrictd.click();
					break;
				}

			}
			Assert.assertTrue("The Asset Release Restricted Drop down was not found", AssetReleseRestricted);

	}

	//Asset Release Date Notes textbox



	public void assetReleaseDateNotesTextBox(String assetReleaseDateNotestext) {
	waitABit(2000);
	assteReleaseNotesTextbox.clear();
	assteReleaseNotesTextbox.sendKeys(assetReleaseDateNotestext);

		}
	//generate trade renditions
		public void clickOnGenerateTradeRenditions() {
			waitABit(2000);
			tradeRendition.click();
		}
		
		


	//Asset Status / Rights Notes: textbox




	public void assetStatusRightsNotesTextBox(String assetStatusRightsNotestext) {
	waitABit(2000);
	assetStatusNotesTextbox.clear();
	assetStatusNotesTextbox.sendKeys(assetStatusRightsNotestext);

		}



	//Asset Type: dropdown



	public void assetTypeDropDown(final String assetTyp) {
		System.out.println(assetTyp);
			waitABit(2000);
			boolean AssetsType = false;
			for (final WebElement AssetTypee: assetTypeList) {
				System.out.println(AssetTypee.getText());
				if (AssetTypee.getText().toLowerCase().contains(assetTyp.toLowerCase())) {
					AssetsType = true;
					AssetTypee.click();
					break;
				}

			}
			Assert.assertTrue("The Asset Type Drop down was not found", AssetsType);
	}



	//Asset Type Notes:textbox



	public void assetTypNotesTextBox(String assetTypeNotestext) {
	waitABit(2000);
	assetTypeNotesTextbox.clear();
	assetTypeNotesTextbox.sendKeys(assetTypeNotestext);

		}



	//Proposed Production Effects Notes : textbox




	public void proposedProductionEffectNotesTextBox(String proposedProductionEffectsNotestext) {
	waitABit(2000);
	proposedProdEffectsNotesTextbox.clear();
	proposedProdEffectsNotesTextbox.sendKeys(proposedProductionEffectsNotestext);

		}



	//Asset Enhanced for Web?: dropdown





	public void assetEnhancdforwebDropDown(final String assetEnhancedWeb) {
			waitABit(2000);
			boolean AssetsEnhancedWeb = false;
			for (final WebElement AssetsEnhancdWeb: assetWebEnhancedList) {
				if (AssetsEnhancdWeb.getText().toLowerCase().contains(assetEnhancedWeb.toLowerCase())) {
					AssetsEnhancedWeb = true;
					AssetsEnhancdWeb.click();
					break;
				}

			}
			Assert.assertTrue("The Asset Web Enhanced Drop down was not found", AssetsEnhancedWeb);
	}


	//Collection Title: textbox


	public void collectionsTitleTextBox(String collectionTitletext) {
	waitABit(2000);
	collectionTitleTextbox.clear();
	collectionTitleTextbox.sendKeys(collectionTitletext);

		}



	//Key Title Metadata - Author 1: textbox


	public void authors1TextBox(String author1text) {
	waitABit(2000);
	author1Textbox.clear();
	author1Textbox.sendKeys(author1text);

		}




	//Author 2: textbox



	public void authors2TextBox(String author2text) {
	waitABit(2000);
	author2Textbox.clear();
	author2Textbox.sendKeys(author2text);

		}


	//Book Title: textbox



	public void booksTitleTextBox(String bookTitletext) {
	waitABit(2000);
	bookTitleTextbox.clear();
	bookTitleTextbox.sendKeys(bookTitletext);

		}


	//Book Subtitle: textbox


	public void booksSubtitleTextBox(String bookSubtitletext) {
	waitABit(2000);
	booksubTitleTextbox.clear();
	booksubTitleTextbox.sendKeys(bookSubtitletext);

		}


	//ISBN-13: textbox



	public void iSBN13TextBox(String iSBN13text) {
	waitABit(2000);
	isbn13Textbox.clear();
	isbn13Textbox.sendKeys(iSBN13text);

		}


	//Material Number: textbox


	public void materialsNumberTextBox(String materialNumbertext) {
	waitABit(2000);
	materialNumberTextbox.clear();
	materialNumberTextbox.sendKeys(materialNumbertext);

		}


	//Workkey: textbox


	public void workkeysTextBox(String workkeytext) {
	waitABit(2000);
	workkeyTextbox.clear();
	workkeyTextbox.sendKeys(workkeytext);

		}


	//Format: textbox


	public void formatsTextBox(String formattext) {
	waitABit(2000);
	formatTextbox.clear();
	formatTextbox.sendKeys(formattext);

		}



	//BISAC Status: textbox




	public void bISACSstatusTextBox(String bISACStatusText) {
	waitABit(2000);
	bisacStatusTextbox.clear();
	bisacStatusTextbox.sendKeys(bISACStatusText);

		}


	//Season: textbox


	public void seasonsTextBox(String seasonText) {
	waitABit(2000);
	seasonTextbox.clear();
	seasonTextbox.sendKeys(seasonText);

		}


	//Imprint Group: textbox


	public void imprintGroupsTextBox(String imprintGroupText) {
	waitABit(2000);
	imprintGroupTextbox.clear();
	imprintGroupTextbox.sendKeys(imprintGroupText);

		}


	//Imprint: textbox


	public void imprintsTextBox(String imprintText) {
	waitABit(2000);
	imprintTextbox.clear();
	imprintTextbox.sendKeys(imprintText);

		}


	//Additional Title Metadata - Page Count: textbox

	public void pagesCountTextBox(String pageCountText) {
	waitABit(2000);
	pageCountTextbox.clear();
	pageCountTextbox.sendKeys(pageCountText);

		}


	//Trim Size: textbox


	public void trimsSizeTextBox(String trimSizeText) {
	waitABit(2000);
	trimSizeTextbox.clear();
	trimSizeTextbox.sendKeys(trimSizeText);

		}


	//Price: textbox


	public void pricesTextBox(String priceText) {
	waitABit(2000);
	priceTextbox.clear();
	priceTextbox.sendKeys(priceText);

		}


	// Editor 1: PriceText textbox



	public void editors1TextBox(String editor1Text) {
	waitABit(2000);
	editor1Textbox.clear();
	editor1Textbox.sendKeys(editor1Text);

		}



	// Editor 2: textbox


	public void editors2TextBox(String editor2Text) {
	waitABit(2000);
	editor2Textbox.clear();
	editor2Textbox.sendKeys(editor2Text);

		}


	//Managing Editor 1: textbox



	public void managingEditors1TextBox(String managingEditor1Text) {
	waitABit(2000);
	managingEditor1Textbox.clear();
	managingEditor1Textbox.sendKeys(managingEditor1Text);

		}



	// Managing Editor 2: textbox


	public void managingEditors2TextBox(String managingEditor2Text) {
	waitABit(2000);
	managingEditor2Textbox.clear();
	managingEditor2Textbox.sendKeys(managingEditor2Text);

		}


	//Designer: textbox


	public void designersTextBox(String designerText) {
	waitABit(2000);
	designerTextbox.clear();
	designerTextbox.sendKeys(designerText);

		}



	//Jacket Designer: textbox



	public void jacketDesignersTextBox(String jacketDesignerText) {
	waitABit(2000);
	jacketDesignerTextbox.clear();
	jacketDesignerTextbox.sendKeys(jacketDesignerText);

		}



	// Illustrator: textbox


	public void illustratorsTextBox(String illustratorText) {
	waitABit(2000);
	illustratorTextbox.clear();
	illustratorTextbox.sendKeys(illustratorText);

		}



	//Age Range: textbox



	public void ageRangesTextBox(String ageRangeText) {
	waitABit(2000);
	ageRangeTextbox.clear();
	ageRangeTextbox.sendKeys(ageRangeText);

		}


	//Grade Range: textbox



	public void gradeRangesTextBox(String gradeRangeText) {
	waitABit(2000);
	gradeRangeTextbox.clear();
	gradeRangeTextbox.sendKeys(gradeRangeText);

		}



	//BISAC Subject: textbox


	public void bISACSubjectsTextBox(String bISACSubjectText) {
	waitABit(2000);
	bisacsubjectTextbox.clear();
	bisacsubjectTextbox.sendKeys(bISACSubjectText);

		}



	// Audience: textbox




	public void audiencesTextBox(String audienceText) {
	waitABit(2000);
	audienceTextbox.clear();
	audienceTextbox.sendKeys(audienceText);

		}



	//Series: textbox



	public void serieesTextBox(String seriesText) {
	waitABit(2000);
	seriesTextbox.clear();
	seriesTextbox.sendKeys(seriesText);

		}



	//Volume: textbox

	public void volumesTextBox(String volumeText) {
	waitABit(2000);
	volumeTextbox.clear();
	volumeTextbox.sendKeys(volumeText);

		}




	//Key Title Indicator: textbox


	public void keyTitlesIndicatorTextBox(String keyTitleIndicatorText) {
	waitABit(2000);
	keyTitleIndicatorTextbox.clear();
	keyTitleIndicatorTextbox.sendKeys(keyTitleIndicatorText);

		}



	//Primary ISBN: textbox



	public void primaryISBNsTextBox(String primaryISBNText) {
	waitABit(2000);
	primaryIsbnTextbox.clear();
	primaryIsbnTextbox.sendKeys(primaryISBNText);

		}



	//Associated ISBNs: textbox


	public void associatdISBNsTextBox(String associatedISBNsText) {
	waitABit(2000);
	associatedIsbnsTextbox.clear();
	associatedIsbnsTextbox.sendKeys(associatedISBNsText);

		}



	//Never Send To Eloquence: textbox


	public void neverSendToEloquencesDropDown(final String neverSendEloquence) {
			waitABit(2000);
			boolean NeverSendEloqunce = false;
			for (final WebElement NeverSendEloqueence: SendToEloquenceList) {
				if (NeverSendEloqueence.getText().toLowerCase().contains(neverSendEloquence.toLowerCase())) {
					NeverSendEloqunce = true;
					NeverSendEloqueence.click();
					break;
				}

			}
			Assert.assertTrue("The Never Send To Eloquence Drop down was not found", NeverSendEloqunce);
	}
	
	
	
	
public void verifyAssetStatusValue(String assetstatus1){

		System.out.println(am_AssetStatus.getText());
		Assert.assertTrue("Asset Status value is not found: " + am_AssetStatus.getText(),  am_AssetStatus.getText().contains(assetstatus1));
		

	}


public void verifyNameValue(String am_name1){

	System.out.println(am_Name.getText());
	
	Assert.assertTrue("Name value is not found: " + am_Name.getText(),  am_Name.getText().contains(am_name1));
	

}

public void verifyRenditionscreatedValue(String am_RenditionsCreated1){

	System.out.println(am_RenditionsCreated.getText());
	
	Assert.assertTrue("Renditions Created value is not found: " + am_RenditionsCreated.getText(),  am_RenditionsCreated.getText().contains(am_RenditionsCreated1));
	

}
	

public void verifyAssetReleasedatenotesValue(String am_AssetReleasedatenotes1){

	System.out.println(am_AssetReleasedatenotes.getText());
	
	Assert.assertTrue("Asset Release date notes value is not found: " + am_AssetReleasedatenotes.getText(),  am_AssetReleasedatenotes.getText().contains(am_AssetReleasedatenotes1));
	

}

public void verifyAssetStatusnotesnotesValue(String am_AssetStatusnotes1){

	System.out.println(am_AssetStatusnotes.getText());
	
	Assert.assertTrue("Asset Status notes value is not found: " + am_AssetStatusnotes.getText(),  am_AssetStatusnotes.getText().contains(am_AssetStatusnotes1));
	

}

public void verifyAssetTypeNotesValue(String am_AssetTypeNotes1){

	System.out.println(am_AssetTypeNotes.getText());
	
	Assert.assertTrue("Asset Type Notes value is not found: " + am_AssetTypeNotes.getText(),  am_AssetTypeNotes.getText().contains(am_AssetTypeNotes1));
	

}

public void verifyCollectionTitleValue(String am_CollectionTitle1){

	System.out.println(am_CollectionTitle.getText());
	
	Assert.assertTrue("Collection Title value is not found: " + am_CollectionTitle.getText(),  am_CollectionTitle.getText().contains(am_CollectionTitle1));
	

}


public void verifyAuthor1Value(String am_Author11){

	System.out.println(am_Author1.getText());
	
	Assert.assertTrue("Author1 value is not found: " + am_Author1.getText(),  am_Author1.getText().contains(am_Author11));
	

}

public void verifyAuthor2Value(String am_Author21){

	System.out.println(am_Author2.getText());
	
	Assert.assertTrue("Author2 value is not found: " + am_Author2.getText(),  am_Author2.getText().contains(am_Author21));
	

}

public void verifyBookTitleValue(String am_BookTitle1){

	System.out.println(am_BookTitle.getText());
	
	Assert.assertTrue("BookTitle value is not found: " + am_BookTitle.getText(),  am_BookTitle.getText().contains(am_BookTitle1));
	

}


public void verifyBookSubtitleValue(String am_BookSubtitle1){

	System.out.println(am_BookSubtitle.getText());
	
	Assert.assertTrue("BookSubtitle value is not found: " + am_BookSubtitle.getText(),  am_BookSubtitle.getText().contains(am_BookSubtitle1));
	

}

public void verifyISBN13Value(String am_ISBN131){

	System.out.println(am_ISBN13.getText());
	
	Assert.assertTrue("ISBN13 value is not found: " + am_ISBN13.getText(),  am_ISBN13.getText().contains(am_ISBN131));
	

}

public void verifyMaterialNumberValue(String am_MaterialNumber1){

	System.out.println(am_MaterialNumber.getText());
	
	Assert.assertTrue("MaterialNumber value is not found: " + am_MaterialNumber.getText(),  am_MaterialNumber.getText().contains(am_MaterialNumber1));
	

}


public void verifyWorkkeyValue(String am_Workkey1){

	System.out.println(am_Workkey.getText());
	
	Assert.assertTrue("Workkey value is not found: " + am_Workkey.getText(),  am_Workkey.getText().contains(am_Workkey1));
	

}

public void verifyFormatValue(String am_Format1){

	System.out.println(am_Format.getText());
	
	Assert.assertTrue("Format value is not found: " + am_Format.getText(),  am_Format.getText().contains(am_Format1));
	

}

public void verifyBISACStatusValue(String am_BISACStatus1){

	System.out.println(am_BISACStatus.getText());
	
	Assert.assertTrue("BISACStatus value is not found: " + am_BISACStatus.getText(),  am_BISACStatus.getText().contains(am_BISACStatus1));
	

}


public void verifySeasonValue(String am_Season1){

	System.out.println(am_Season.getText());
	
	Assert.assertTrue("Season value is not found: " + am_Season.getText(),  am_Season.getText().contains(am_Season1));
	

}

 
public void verifyImprintGroupValue(String am_ImprintGroup1){

	System.out.println(am_ImprintGroup.getText());
	
	Assert.assertTrue("ImprintGroup value is not found: " + am_ImprintGroup.getText(),  am_ImprintGroup.getText().contains(am_ImprintGroup1));
	

}


public void verifyImprintValue(String am_Imprint1){

	System.out.println(am_Imprint.getText());
	
	Assert.assertTrue("Imprint value is not found: " + am_Imprint.getText(),  am_Imprint.getText().contains(am_Imprint1));
	

}


public void verifyPageCountValue(String am_PageCount1){

	System.out.println(am_PageCount.getText());
	
	Assert.assertTrue("PageCount value is not found: " + am_PageCount.getText(),  am_PageCount.getText().contains(am_PageCount1));
	

}


public void verifyTrimSizeValue(String am_TrimSize1){

	System.out.println(am_TrimSize.getText());
	
	Assert.assertTrue("TrimSize value is not found: " + am_TrimSize.getText(),  am_TrimSize.getText().contains(am_TrimSize1));
	

}

public void verifyPriceValue(String am_Price1){

	System.out.println(am_Price.getText());
	
	Assert.assertTrue("Price value is not found: " + am_Price.getText(),  am_Price.getText().contains(am_Price1));
	

}

public void verifyEditor1Value(String am_Editor11){

	System.out.println(am_Editor1.getText());
	
	Assert.assertTrue("Editor1 value is not found: " + am_Editor1.getText(),  am_Editor1.getText().contains(am_Editor11));
	

}

public void verifyEditor2Value(String am_Editor21){

	System.out.println(am_Editor2.getText());
	
	Assert.assertTrue("Editor2 value is not found: " + am_Editor2.getText(),  am_Editor2.getText().contains(am_Editor21));
	

}


public void verifyManagingEditor1Value(String am_ManagingEditor11){

	System.out.println(am_ManagingEditor1.getText());
	
	Assert.assertTrue("ManagingEditor1 value is not found: " + am_ManagingEditor1.getText(),  am_ManagingEditor1.getText().contains(am_ManagingEditor11));
	

}

public void verifyManagingEditor2Value(String am_ManagingEditor21){

	System.out.println(am_ManagingEditor2.getText());
	
	Assert.assertTrue("ManagingEditor2 value is not found: " + am_ManagingEditor2.getText(),  am_ManagingEditor2.getText().contains(am_ManagingEditor21));
	

}


public void verifyDesignerValue(String am_Designer1){

	System.out.println(am_Designer.getText());
	
	Assert.assertTrue("Designer value is not found: " + am_Designer.getText(),  am_Designer.getText().contains(am_Designer1));
	

}


public void verifyJacketDesignerValue(String am_JacketDesigner1){

	System.out.println(am_JacketDesigner.getText());
	
	Assert.assertTrue("JacketDesigner value is not found: " + am_JacketDesigner.getText(),  am_JacketDesigner.getText().contains(am_JacketDesigner1));
	

}

public void verifyIllustratorValue(String am_Illustrator1){

	System.out.println(am_Illustrator.getText());
	
	Assert.assertTrue("Illustrator value is not found: " + am_Illustrator.getText(),  am_Illustrator.getText().contains(am_Illustrator1));
	

}

public void verifyAgeRangeValue(String am_AgeRange1){

	System.out.println(am_AgeRange.getText());
	
	Assert.assertTrue("AgeRange value is not found: " + am_AgeRange.getText(),  am_AgeRange.getText().contains(am_AgeRange1));
	

}


public void verifyGradeRangeValue(String am_GradeRange1){

	System.out.println(am_GradeRange.getText());
	
	Assert.assertTrue("GradeRange value is not found: " + am_GradeRange.getText(),  am_GradeRange.getText().contains(am_GradeRange1));
	

}


public void verifyBISACSubjectValue(String am_BISACSubject1){

	System.out.println(am_BISACSubject.getText());
	
	Assert.assertTrue("BISACSubject value is not found: " + am_BISACSubject.getText(),  am_BISACSubject.getText().contains(am_BISACSubject1));
	

}

public void verifyAudienceValue(String am_Audience1){

	System.out.println(am_Audience.getText());
	
	Assert.assertTrue("Audience value is not found: " + am_Audience.getText(),  am_Audience.getText().contains(am_Audience1));
	

}

public void verifySeriesValue(String am_Series1){

	System.out.println(am_Series.getText());
	
	Assert.assertTrue("Series value is not found: " + am_Series.getText(),  am_Series.getText().contains(am_Series1));
	

}

public void verifyVolumeValue(String am_Volume1){

	System.out.println(am_Volume.getText());
	
	Assert.assertTrue("Volume value is not found: " + am_Volume.getText(),  am_Volume.getText().contains(am_Volume1));
	

}
	

public void verifyKeyTitleIndicatorValue(String am_KeyTitleIndicator1){

	System.out.println(am_KeyTitleIndicator.getText());
	
	Assert.assertTrue("KeyTitleIndicator value is not found: " + am_KeyTitleIndicator.getText(),  am_KeyTitleIndicator.getText().contains(am_KeyTitleIndicator1));
	

}

public void verifyPrimaryISBNValue(String am_PrimaryISBN1){

	System.out.println(am_PrimaryISBN.getText());
	
	Assert.assertTrue("PrimaryISBN value is not found: " + am_PrimaryISBN.getText(),  am_PrimaryISBN.getText().contains(am_PrimaryISBN1));
	

}

public void verifyAssociatedISBNsValue(String am_AssociatedISBNs1){

	System.out.println(am_AssociatedISBNs.getText());
	
	Assert.assertTrue("AssociatedISBNs value is not found: " + am_AssociatedISBNs.getText(),  am_AssociatedISBNs.getText().contains(am_AssociatedISBNs1));
	

}



public void proposedProdEffectsentryMultipleSelect(final String ProdEffectsentryMultipleSelect) {
	waitABit(2000);
	
	Select proposedProdMultipleSelect= new Select(proposedProdEffectsentry);                             
	String proposedProdMultipleToSelect[] = ProdEffectsentryMultipleSelect.split(",");                  
	for(String ProdMultipleToSelect:proposedProdMultipleToSelect)
	{    
		proposedProdMultipleSelect.selectByIndex(0);
		proposedProdMultipleSelect.selectByIndex(1);
		proposedProdMultipleSelect.selectByIndex(2);
	}
}


public void verifyproposedProdEffectsentryMultipleSelect(final String am_proposedMultipleselect1) {

	
System.out.println(am_proposedProdMultiplselect.getText());
	
	Assert.assertTrue("proposedProdMultipleselect value is not found: " + am_proposedProdMultiplselect.getText(),  am_proposedProdMultiplselect.getText().contains(am_proposedMultipleselect1));
	
}

//Asset management Steps End

//HIP objects edit properties

	public void enterCaptionForHipObject(String captionValue){
		manualScrollForInputField(1);
		waitForElement("input[id*='prop_hmh-cms_caption']",ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(captionInput).waitUntilVisible();
		captionInput.clear();
		captionInput.sendKeys(captionValue);		
	}	

	public void selectGenreForHipObject(String genreSelectdrop){
		boolean isFound = false;
		for(final WebElement selectGenre: genreSelect){
			if(selectGenre.getText().toLowerCase().contains(genreSelectdrop.toLowerCase())){
				isFound=true;
				selectGenre.click();
				break;
			}
		}
		Assert.assertTrue("The given genre is not found", isFound);
	}
	
	public void selectAssetSubtypeForHipObject(String assetSubtypeSelectdrop){
		boolean isFound = false;
		for(final WebElement selectAssetsubtype: assetTypeSelect){
			if(selectAssetsubtype.getText().toLowerCase().contains(assetSubtypeSelectdrop.toLowerCase())){
				isFound=true;
				selectAssetsubtype.click();
				break;
			}
		}
		Assert.assertTrue("The given genre is not found", isFound);
	}

	public void manualScrollForInputField(int manualScrollSeconds) {

		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(this.titleTextAreaInput).build().perform();

			waitABit(1000L);
		}
	  }
	
	public void addNewTag(String newTag) {
		this.waitABit(40000L);	
		this.element(this.tagsTextBox).waitUntilVisible();
		
		this.tagsTextBox.sendKeys(new CharSequence[] { newTag });
		this.tagsTextBox.sendKeys(new CharSequence[] { Keys.RETURN });
		this.waitABit(2000L);
	}
	public void editPropClick() {
		element(Editproperty).waitUntilVisible();
		if(isElementVisible(By.cssSelector("div.document-edit-metadata > a")))
		{
			System.out.println("element found");
			Editproperty.click();
		}
		else
		{
			System.out.println("element not found");
		}
		
	}



	public void addExistingTag(String existingTag) {
		boolean isPresent = false;
		this.waitABit(30000L);	
		this.tagsButton.click();
		this.waitABit(20000L);
		this.element(this.tagsDropDownButton).waitUntilVisible();
		this.tagsDropDownButton.click();
		this.waitABit(20000L);
		WebElement inTagsList = this.getDriver().findElement(
				By.cssSelector(this.tagsListContainer));
		this.waitABit(20000L);

		for (int i = 0; i < inTagsList.findElements(
				By.cssSelector(this.tagsLeft)).size(); ++i) {
			WebElement tagInList = (WebElement) inTagsList.findElements(
					By.cssSelector(this.tagsLeft)).get(i);
			if (tagInList.getText().toLowerCase()
					.contains(existingTag.toLowerCase())) {
				isPresent = true;
				WebElement plusIconButton = tagInList.findElement(By
						.cssSelector(this.addTagPlusIcon));
				this.element(plusIconButton).waitUntilPresent();
				plusIconButton.click();
				break;
			}
		}

		Assert.assertTrue("ExistingTag in not in the list!", isPresent);
	}
	
	public void okButtonOnTagsPopUpClick() {
		this.waitABit(3000L);
		this.element(this.tag_okButton).waitUntilVisible();
		this.tag_okButton.click();
	}
	
	//URI Primary Help Icon
		public void uriPrimaryHelpIcon(String uriPrimaryHelpText) {
		waitABit(1000);
		element(uriPrimaryHelpIcon).waitUntilClickable();
		uriPrimaryHelpIcon.click();
		waitABit(1000);
		Assert.assertTrue("URI Primary Help Text not matched", uriPrimaryHelpIconText.getText().contains(uriPrimaryHelpText));
		System.out.println(uriPrimaryHelpIconText.getText());
		System.out.println(uriPrimaryHelpText);
		}

	public void uriPrimary(String uri_primary) {
		waitABit(2000);
		uriPrimaryTextBox.clear();
		uriPrimaryTextBox.sendKeys(uri_primary);
		}

	public void uriSupplementalHelpIcon(String uriSupplementalHelpText) {
		waitABit(1000);
		element(uriSupplementalHelpIcon).waitUntilClickable();
		uriSupplementalHelpIcon.click();
		waitABit(1000);
		Assert.assertTrue("URI Primary Help Text not matched", uriSupplementalHelpIconText.getText().contains(uriSupplementalHelpText));
		System.out.println(uriSupplementalHelpIconText.getText());
		System.out.println(uriSupplementalHelpText);
		}
	public void uriSupplemental(String uri_supplemental) {
		waitABit(2000);
		uriSupplementalTextBox.clear();
		uriSupplementalTextBox.sendKeys(uri_supplemental);

			}

	public void programLabelAdvSearch(String searchText) {

	advSearchProgramlabel.clear();
	advSearchProgramlabel.sendKeys(searchText);
	}
		//Brightcove functionality
	
	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTestNew.class);
	
	public boolean BrightcoveAccountName(String brtcoveacnm, String locid, String covid) {
		Select dropdown = new Select(brtacname);
		boolean found=false;
		WebElement first = dropdown.getFirstSelectedOption();
		System.out.println(first.getText());
		if(dfltbrtacname.getText().equalsIgnoreCase(first.getText())){
			
			dropdown.selectByVisibleText(brtcoveacnm);	
			found= true;
		}
		else {
			LOG.info("Brightcove Account Name already selected");
			
		}
		
		if (brtlocid.getAttribute("value").isEmpty()) {
			
			brtlocid.clear();
			brtlocid.sendKeys(locid);
		}
		else {
			LOG.info(brtlocid.getAttribute("value"));
			LOG.info("Brightcove Location ID already exist");
			
		}
		if (brtcovid.getAttribute("value").isEmpty()) {
			brtcovid.clear();
			brtcovid.sendKeys(covid);
			}
		else {
			LOG.info(brtcovid.getAttribute("value"));
			LOG.info("Brightcove ID already exist");
			
		}
		return found;

			}
	
	

	
	public void ValidateBrightcoveAccountDetails(String brtcoveacnm, String locid, String covid) {
		if(vrfybrtacname.getText().contains(brtcoveacnm)){
			
			LOG.info("Brightcove Account Name updated");	
		}
		else {
			LOG.info("Brightcove Account Name not updated");
		}
		if (vrfybrtlocid.getText().contentEquals(locid)) {
			
			LOG.info("Brightcove Location ID updated");
		}
		else {
			LOG.info("Brightcove Location ID not updated");
		}
		if (vrfybrtcovid.getText().contentEquals(covid)) {
			
			LOG.info("Brightcove ID updated");
			}
		else {
			LOG.info("Brightcove ID not updated");
		}

			}
	//**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
	public void changeUserRoleMetadataField(String userrole) {
		boolean isFound=false;	
			for(WebElement role : userRoleList)
				{
					if(role.getText().toLowerCase().contains(userrole.toLowerCase())){
						isFound=true;
						role.click();
						break;
					}
				}
				Assert.assertTrue("The User role drop down is not found", isFound);
				
			}
	//**** ALF-2073  ** Improve Validation of User-Populated Program Label Values ** Sprint 7.3.1 **
	public void validatePopUpMsgProgramLabelMetadata() {
		waitABit(2000);
		element(vrfyPopupMessageProgramLabel).waitUntilVisible();
		System.out.println("Pop Up message verified successfully");
		
	}
	//**** ALF-2073  ** Improve Validation of User-Populated Program Label Values ** Sprint 7.3.1 **
	public void validateToolTipProgramLabelMetadata() {
		waitABit(2000);
		WebElement tooltip=getDriver().findElement(By.id("template_x002e_edit-metadata_x002e_edit-metadata_x0023_default_prop_hmh-cms_programLabel-help-icon"));
		tooltip.click();
		element(vrfyToolTipProgramLabel).waitUntilVisible();		
		System.out.println("Tool Tip verified successfully");
		
	}
	//**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
		public void selectRegenerateEpub() {
			waitABit(2000);
			element(selectRegenerateEpub).waitUntilVisible();
			selectRegenerateEpub.click();
			System.out.println("Clicked on Regenerate ePub");
			
		}
		
	//** ALF -2083 ** Changes to Genre Values in OneCMS ** Sprint 7.3.3 **	
		public void verifyGenreFieldForHipObject(String newgenreSelectdrop1,String newgenreSelectdrop2){
			boolean isFound = false;
			for(final WebElement selectGenre: genreSelect){
				if(selectGenre.getText().toLowerCase().contains(newgenreSelectdrop1.toLowerCase()))
				{
					isFound=true;
					System.out.println("Non-fiction genre field value is changed to :"+ " "+newgenreSelectdrop1);
					
				if(selectGenre.getText().toLowerCase().contains(newgenreSelectdrop2.toLowerCase()))
					isFound=true;
					System.out.println("Narrative Non-fiction genre field value is changed to :"+ " "+newgenreSelectdrop2);
					break;
				}
			}
			Assert.assertTrue("The given genre is not found", isFound);
		}

		//** ALF 2108 ** Create a Second Product Label for Teacher CO/CCOs in Dual-Delivery POs ** Sprint 7.3.1 **
		public void selectTeacherProductLabel(String teacherproductLabel) {
			waitABit(2000);
			element(selectTeacherProductLabel).waitUntilVisible();
			selectTeacherProductLabel.clear();
			selectTeacherProductLabel.sendKeys(teacherproductLabel);
			
		}
		
		//** ALF 2108 ** Create a Second Product Label for Teacher CO/CCOs in Dual-Delivery POs ** Sprint 7.3.1 **
		public void validateToolTipTeacherProductLabel() {
			waitABit(1000);
			element(teacherProductLabelToolTip).click();
			System.out.println("Tool Tip verified successfully");
							
		}
		
		public void standardRecommendationDropdown(final String dropValue) {
			boolean value = false;
			for (WebElement flagValue:standardRecommendationDropdownValue) {
				if (flagValue.getText().toLowerCase().contains(dropValue.toLowerCase())) {
					value = true;
					flagValue.click();               
					break;
				}  

			}
			Assert.assertTrue("The Recommendation flag Drop down was not found", value);
		}

		 //** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		public void clickViewDetailsOnRenditionsFolder() {
		
		waitForElementX("(.//a[text()='Renditions']/following::td[contains(@class,'yui-dt')])[1]",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,getDriver());
		
		Actions moveToActions = new Actions(getDriver());
		moveToActions.moveToElement(this.moreActionsSectionOnRenditionsFolder).build().perform();
		waitABit(1000L);
		moveToActions.moveToElement(this.viewDetailsOnRenditionsFolder).build().perform();
		moveToActions.moveToElement(this.viewDetailsOnRenditionsFolder).click();
		element(this.viewDetailsOnRenditionsFolder).click();
					
			
		}
		
		//** ALF-2277 **  Trade: Modify existing Asset Status dropdown values ** Sprint 7.3.4 **
		public void verifyAssetStatusDropDown(final String assetsstatus,final String asset) {
			waitABit(2000);
			boolean AssetstatusFound = false;
			for (final WebElement assestatus: assetStatusList) {
				if (assestatus.getText().toLowerCase().contains(assetsstatus.toLowerCase())) {
					AssetstatusFound = true;
					System.out.println("Dropdown value found :"+assestatus.getText());
					break;
				}
				
				Assert.assertTrue("The Asset status Drop down value :" +assetsstatus+" was not found", AssetstatusFound);
			}
				
			for (final WebElement asseststatus: assetStatusList) {
				if (asseststatus.getText().toLowerCase().contains(asset.toLowerCase())) {
					AssetstatusFound = true;
					System.out.println("Dropdown value found :"+asseststatus.getText());
					break;
				}

			 Assert.assertTrue("The Asset status Drop down value :" +asset+" was not found", AssetstatusFound);
			 }
			
		}
		
		//** ALF-2276 **  Trade: Add  "Restricted Elo Release" field to Title Metadata ** Sprint 7.3.4 **
		
		public void verifyRestrictedEloReleaseField(final String assetstatus) {
			waitABit(2000);
			boolean AssetstatusFound = false;
			
				if (restrictedElo.getText().toLowerCase().contains(assetstatus.toLowerCase())) {
					AssetstatusFound = true;
					System.out.println("Restrcited Elo Release displayed");
				}
		
			Assert.assertTrue("The Restrcited Elo Read only was not found", AssetstatusFound);
			
		}
		
		// ** ALF - 2292 ** Add new Discipline values ** Sprint 7.3.4 **
		
		public void selectCategory(String itemName1,String itemName2) {
			
				boolean found = false;
				//waitForElement("(.//button[text()='Select'])[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
				waitABit(1000);
				element(selectCategory).waitUntilVisible();
				selectCategory.click();
				waitABit(1000);
				element(selectDiscipline).waitUntilVisible();				
				selectDiscipline.click();
				waitABit(1000);
				element(selectK12).waitUntilVisible();
				selectK12.click();
				waitABit(1000);
				
				for (WebElement item : itemsSelectCategoryDialgoBox) {
					if (item.getText().toLowerCase().contains(itemName1.toLowerCase())) {
						found = true;
						System.out.println("Mathematics discipline displayed");
						
					}
					if (item.getText().toLowerCase().contains(itemName2.toLowerCase())) {
						found = true;						
						System.out.println("Social Studies discipline displayed");
						break;
					}
					
				}
				Assert.assertTrue("The item was not found in Category Dialog Box", found);
				
			
				element(selectMathCategory).waitUntilVisible();
				selectMathCategory.click();
				waitABit(500);
				element(selectSSCategory).waitUntilVisible();				
				selectSSCategory.click();
				waitABit(500);
				
				okButton.click();
		
		}	
	  //** ALF-2128 ** Learning Spine Correlations are Visible on the View Details Page ** Sprint 7.3.4 **
	  //** ALF-2140 **  Deleting a Learning Spine Correlations ** Sprint 7.3.4 **
		public void clickGenerateCorrelationActionOnPS() {
			
			waitABit(2000);	
			waitForElementX("(.//a[text()='Product Sets']/following::td[starts-with(@class,'yui-dt')])[1]",
					ConstantsHMH.DEFAULT_TIMEOUT_SECONDS,getDriver());
			WebElement ps= getDriver().findElement(By.xpath("(.//a[text()='Product Sets']/following::td[starts-with(@class,'yui-dt')])[1]"));
			JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
			Actions moveToActions = new Actions(getDriver());
			moveToActions.moveToElement(ps).moveToElement(this.clickMoreOnFolder).click().build().perform();
			//moveToActions.moveToElement(this.clickMoreOnFolder).click();
		//	js.executeScript("arguments[0].click();", clickMoreOnFolder);
			
			/*moveToActions.moveToElement(this.clickMoreOnFolder).build().perform();
			moveToActions.moveToElement(this.clickMoreOnFolder).click();*/
			waitABit(1000L);
			moveToActions.moveToElement(this.clickGenerateCorrelationAction).build().perform();
			moveToActions.moveToElement(this.clickGenerateCorrelationAction).click();
			
						
				
			}
		//** ALF-2128 ** Learning Spine Correlations are Visible on the View Details Page ** Sprint 7.3.4 **
		//** ALF-2140 **  Deleting a Learning Spine Correlations ** Sprint 7.3.4 **
		public void clickCorrelateStandards() {
			
		waitABit(500);	
		element(this.clickCorrelateLearningSkills).click();
			
		}
		
		//** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **	
		public void navigateInAssetsFolderandMoveAction() {
			
			element(selectAssets).waitUntilVisible();
			selectAssets.click();
			waitABit(1000);
			element(moveButtonClick).waitUntilVisible();
			moveButtonClick.click();						
			
		}
		//** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **	
		public void navigateInMoveFilesreferencesDialogBox(String itemName) {
			WebElement element=getDriver().findElement(By.xpath(".//*[@class='dijitMenuPassive dijitMenuBar']"));
			//waitForElement(".//*[@class='dijitMenuPassive dijitMenuBar']/div/span[contains(text(),'"+itemName+"')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			waitABit(3000);
			WebElement item = element.findElement(By.xpath("//span[contains(text(),'"+itemName+"')]"));
			JavascriptExecutor js = (JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].scrollIntoView(true);", item);
			js.executeScript("arguments[0].click();", item);
			waitABit(2000);
			/*boolean found = false;
			System.out.println("Item clicked in the box:" + item.isDisplayed());
			if (item.getText().toLowerCase().contains(itemName.toLowerCase())) {
				found = true;
				item.click();
			}
			Assert.assertTrue("The item was not found in reference dialog box", found);*/
		}	
		
		
  //** ALF-2335 ** Trade: Create new asset types for Author Questionnaire, Excerpt, Launch Script, Text, and Selling Sample ** Sprint 7.3.5
	public void verifyAssettypeDropDown(final String assetsstatus) {
		waitABit(2000);
		boolean AssetstatusFound = false;
		for (final WebElement assestatus: assettypeList) {
			if (assestatus.getText().toLowerCase().contains(assetsstatus.toLowerCase())) {
				AssetstatusFound = true;
				assestatus.click();
				break;
			}
	
		}
		Assert.assertTrue("The Asset type Drop down was not found", AssetstatusFound);
	}


	}
	
	
	
	
	
