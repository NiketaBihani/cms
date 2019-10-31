package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHEditPropertiesPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHEditPropertiesSteps extends AbstractSteps<HMHEditPropertiesPage> {

    private static final long serialVersionUID = -854601134541075184L;

    public HMHEditPropertiesSteps(Pages pages) {
        super(pages, HMHEditPropertiesPage.class);
    }

    @Step("Edit grade{0} for Object")
    public void editGrade(String grade) {
        currentPage().editGrades(grade);
    }

    @Step("Edit right{0} for Object")
    public void editRight(String right) {
        currentPage().editRights(right);
    }

    @Step("Edit description{0}")
    public void editDescription(String description) {
        currentPage().editDescription(description);
    }
    
    @Step("Edit Previous Unique ID{0}")
    public void editPrevUniqId(String PrevUnId) {
        currentPage().editPrevUniqId(PrevUnId);
    }
    
    @Step("Uncheck the Searchable Check box{0}")
    public void searchCheckBox() {
        currentPage().searchCheckBox();
    }   

    @Step("Verify and Edit HMH Keywords")
    public void editHMHKeywords(String keyword) {
        currentPage().editHMHKeywords(keyword);
    }
    
    @Step("Edit title{0}")
    public void editTitle(String title) {
        currentPage().editTitle(title);
    }

    @Step("Confirm multiple edit propertiesc ")
    public void confirmMultipleEdit() {
        currentPage().confirmMultipleEdit();
    }

    @Step("Edit a learning style{0} in Edit Properties")
    public void editLearningStyles(String style) {
        currentPage().editLearningStyles(style);

    }

    @Step("Edit the lifecycle {0}")
    public void editLifeCycle(String lifecycle) {
        currentPage().editLifeCycle(lifecycle);
    }

    @Step("Edit Markets 0}")
    public void editMarkets(String markets) {
        currentPage().editMarkets(markets);
    }

   
    @Step("Edit Properties Click")
    public void editPropClick() {
        currentPage().editPropClick();
    }
    
    @Step("Edit sub market US {0}")
    public void editSubMarketUS(String subMarket) {
        currentPage().editSubMarketUS(subMarket);
    }

    @Step("Edit sub market International {0}")
    public void editSubMarketInternational(String subMarket) {
        currentPage().editSubMarketInternational(subMarket);
    }

    @Step("Edit the product type id{0}")
    public void editProductTypeID(String id) {
        currentPage().editProductTypeID(id);
    }
    
    @Step("Edit the resource type id{0}")
    public void editResourceType (String resourceType) {
        currentPage().editResourceType(resourceType);
    } 
	  @Step("Click on Edit Properties on details page")
	  public void clickOnEditPropertiesDetails() {
	      currentPage().clickOnEditPropertiesDetails();
	    }
	
	
	  @Step("Click on ProductType DropDown ")
	  public void productTypeDropDown(String productType) {
	      currentPage().productTypeDropDown(productType);
	    }
	  
	  @Step("Click on ProductTypeID DropDown")
	  public void productTypeIDDropDown(final String productTypeID) {
	      currentPage().productTypeIDDropDown(productTypeID);
	    }
	  
	  @Step("Click on ProductTypeID DropDown")
	  public void verifyProductTypeDropDown(final String productTypeID) {
	      currentPage().verifyProductTypeDropDown(productTypeID);
	    }
	  
	  @Step("Click on UserRole DropDown")
	  public void userRoleDropDown(String userRole) {
	      currentPage().userRoleDropDown(userRole);
	    }
	  
	  @Step("Click on ProductTypeSubID TextBox ")
	  public void productTypeSubIDTextBox(String productTypeSubID) {
	      currentPage().productTypeSubIDTextBox(productTypeSubID);
	    }
	  @Step("Click on ActivityType DropDown")
	  public void activityTypeDropDown(String activityType) {
	      currentPage().activityTypeDropDown(activityType);
	    }
	  
	  @Step("Click on StudentFacing DropDown")
	  public void studentFacingDropDown(String studentFacing) {
	      currentPage().studentFacingDropDown(studentFacing);
	    }
	  
	  @Step("Click on ProductCategory MultiSelect ")
	  public void productCategoryMultiSelect(String productCategory) {
	      currentPage().productCategoryMultiSelect(productCategory);
	    }
	  @Step("Edit CW ORiginal content field")
	  public void editCwOriginalContent(String cwOriginalcontent) {
	      currentPage().editCwOriginalContent(cwOriginalcontent);
	    }
	  
	  @Step("Edit interest {0}")
	  public void editInterestWithMultipleSelect(String interests) {
	      currentPage().editInterestWithMultipleSelect(interests);
	  }
	  
	  @Step("Edit characters {0}")
	  public void editCharacterList(String characters)
	  {
	         currentPage().editCharacterList(characters);
	  }
	  
	  @Step("Edit Minimum viewport size {0}")
	  public void editMinViewportSizeList(String viewportSizes) {
	      currentPage().editMinViewportSizeList(viewportSizes);
	  }
	  
	
	  @Step("Edit Featured List {0}")
	  public void editFeaturedList(String featured) {
	      currentPage().editFeaturedList(featured);
	  }
	
	  @Step("Edit events {0} in Edit Properties")
	  public void editEvents(String events) {
	      currentPage().editEvents(events);
	
	  }
	  @Step("Edit a learning style{0} in Edit Properties")
	  public void editLearningStylesMutli(String style) {
	      currentPage().editLearningStylesMutli(style);
	
	  }
	
	  @Step("Edit product type List {0}")
	  public void editProductTypeK12(String productTypes) {
	      currentPage().editProductTypeK12(productTypes);
	  }
	  
	  @Step("Edit student facing List {0}")
	  public void editProductTypeIDK12(String productTypeID) {
	      currentPage().editProductTypeIDK12(productTypeID);
	  }
	  
	  @Step("Click on Exclude Level Numbering  CheckBox")
	  public void selectExcludeLevelNumberCHKBOX() {
		  currentPage().selectExcludeLevelNumberCHKBOX();
		}
	  
	  @Step("Click on Exclude Level Label CheckBox")
	  public void selectExcludeLevelLabelCHKBOX() {
		  currentPage().selectExcludeLevelLabelCHKBOX();
		}
	  
	  @Step("Enter the Label to be used instead of Product Set level label:  {0}")
	  public void sequenceBundleLabelInput(String sbLabelInput) {
		  currentPage().sequenceBundleLabelInput(sbLabelInput);
		}
	  @Step("Enter the CCO Label to be displayed in Habitat core site:  {0}")
	  public void editCcoLabel(String enterCcoLabel) {
		  currentPage().editCcoLabel(enterCcoLabel);
		}
	  
	  @Step("Verify the dropdown is alphabetically arranged except first and last")
	  public void verifySortingOfPublishingDropDown() {
		  currentPage().verifySortingOfPublishingDropDown();
	  	}
	  
	  @Step("Click on Publisher DropDown")
	  public void selectFromPublisherDropDown(String publisher) {
	      currentPage().publisherDropDown(publisher);
	    }
	  
	  
	  @Step("Click on Select Button for ProductSet reference to Master Library Site Folder")
	  public void clickProductSetRefSelect() {
		  currentPage().clickProductSetRefSelect();
		}

	  @Step("Click on {0} to navigate in PS references Dialog Box")
	  public void navigateInPSreferencesDialogBox(String itemName) {
		  currentPage().navigateInPSreferencesDialogBox(itemName);
		}
	  
	  @Step("PSF Add: Click on Add button to refer the Program Support Folder")
	  public void addPStoMasterReference(String psName) {
		  currentPage().addPStoMasterReference(psName);
	  }
	  
	  @Step("Click Save Button")
	  public void saveButtonClick() {
		  currentPage().saveButtonClick();
		}

	  @Step("Delete the level 1 Label for product set")
	  public void clearLevel1Label(){
		  currentPage().clearLevel1Label();
	  }
   
	  @Step("Edit the level 1 Label for product set {0}")
	  public void editLevel1Label(String level1Label){
		  currentPage().editLevel1Label(level1Label);
	  }
	  @Step("Edit the level 2 Label for product set {0}")
	  public void editLevel2Label(String level2Label){
		  currentPage().editLevel2Label(level2Label);
	  }
	  @Step("Edit the level 6 Label for product set {0}")
	  public void editLevel6Label(String level6Label){
		  currentPage().editLevel6Label(level6Label);
	  }
	  
	  @Step("Select the level 1 Numbering for product set {0}")
	  public void selectLvl1Number(String level1Number){
		  currentPage().selectLvl1Number(level1Number);
	  }
	  @Step("Select the level 2 Numbering for product set {0}")
	  public void selectLvl2Number(String level2Number){
		  currentPage().selectLvl2Number(level2Number);
	  }
	  @Step("Select the level 6 Numbering for product set {0}")
	  public void selectLvl6Number(String level6Number){
		  currentPage().selectLvl6Number(level6Number);
	  }
	  
	  @Step("Select the Differentiation level for product object {0}")
	  public void selectDifferentiationLevel(String diffLevel){
		  currentPage().selectDifferentiationLevel(diffLevel);
	  }
	 
	  @Step("Eneter Habitat Short Name {0}")
	  public void enterShortNameForHabitat(String habitatShtname){
		  currentPage().enterShortNameForHabitat(habitatShtname);
	  }
	  @Step("Check the Is Delivery Structure check box")
		public void checkDeliveryStructure() {
			currentPage().checkDeliveryStructure();
		}
	  @Step("Enter text in Program Label text box")
	  public void programLabel(String textprogramLabel) {
			currentPage().programLabel(textprogramLabel);
		}
	  @Step("Enter text in Product Category Position Label text box")
	  public void productCategoryPositionLabel(String textproductCategoryPositionLabel) {
			currentPage().productCategoryPositionLabel(textproductCategoryPositionLabel);
		}
	  @Step("Enter text in Product Category Title Label text box")
	  public void productTitleLabel(String textproductTitleLabel) {
			currentPage().productTitleLabel(textproductTitleLabel);
		}
	  @Step("Enter text in Product Launch Type Label text box")
	  public void productLaunchTypeLabel(String textproductLaunchTypeLabel) {
			currentPage().productLaunchTypeLabel(textproductLaunchTypeLabel);
		} 
	  @Step("Enter text in HMH ID text box")
	  public void hmhID(String texthmhID) {
			currentPage().hmhID(texthmhID);
		} 
	  @Step("Enter text in Assessment Bank ID text box")
	  public void assessmentbankID(String textassessbankID) {
			currentPage().assessmentbankID(textassessbankID);
		} 
	  @Step("Click HMH ID Help Icon")
	  public void hmhIDHelpIcon(String helpText) {
		  currentPage().hmhIDHelpIcon(helpText);
		}
	  @Step("Enter text in Product Category Icon text box")
	  public void productCategoryIconText(String textproductcategoryIcon) {
			currentPage().productCategoryIconText(textproductcategoryIcon);
	  }
	  //Asset Management Steps Start
	  @Step("Enter text in Name text box")
	  public void nameLabel(String nametext){
		  currentPage().nameLabel(nametext);
	  }
	  
	  @Step("Click on Assetsstatus DropDown")
	  public void assetstatusDropDown(final String assetsstatus) {
	      currentPage().assetstatusDropDown(assetsstatus);
	    }
	  
	  @Step("Click on RenditionCreated DropDown")
	  public void renditionsCreatedDropDown(final String renditionCreated) {
	      currentPage().renditionsCreatedDropDown(renditionCreated);
	    }  
	  
	  @Step("Click on AssetReleasRestricted DropDown")
	  public void assetReleaseRestrictedDropDown(final String assetReleasRestricted) {
	      currentPage().assetReleaseRestrictedDropDown(assetReleasRestricted);
	    }  
	  
	  
	  @Step("Enter text in AssetReleaseDateNotes text box")
	  public void assetReleaseDateNotesTextBox(String assetReleaseDateNotestext) {
		  currentPage().assetReleaseDateNotesTextBox(assetReleaseDateNotestext);
	  }
	  
	  @Step("Click on generate trade  DropDown")
	  public void clickOnGenerateTradeRenditions()  {
	      currentPage().clickOnGenerateTradeRenditions();
	    } 
	  
	  
	  @Step("Enter text in AssetStatusRightsNotes text box")
	  public void assetStatusRightsNotesTextBox(String assetStatusRightsNotestext){
		  currentPage().assetStatusRightsNotesTextBox(assetStatusRightsNotestext);
	  }  
	  
	  @Step("Click on AssetTyp DropDown")
	  public void assetTypeDropDown(final String assetTyp)  {
	      currentPage().assetTypeDropDown(assetTyp);
	    }  
	  
	  @Step("Enter text in AssetTypeNotes text box")
	  public void assetTypNotesTextBox(String assetTypeNotestext){
		  currentPage().assetTypNotesTextBox(assetTypeNotestext);
	  } 
	  
	  @Step("Enter text in ProposedProductionEffectsNotes text box")
	  public void proposedProductionEffectNotesTextBox(String proposedProductionEffectsNotestext){
		  currentPage().proposedProductionEffectNotesTextBox(proposedProductionEffectsNotestext);
	  }   
	  
	  @Step("Click on AssetEnhancedWeb DropDown")
	  public void assetEnhancdforwebDropDown(final String assetEnhancedWeb) {
	      currentPage().assetEnhancdforwebDropDown(assetEnhancedWeb);
	    }   
	  
	  @Step("Enter text in CollectionTitle text box")
	  public void collectionsTitleTextBox(String collectionTitletext){
		  currentPage().collectionsTitleTextBox(collectionTitletext);
	  }  
	  
	  @Step("Enter text in Author1 text box")
	  public void authors1TextBox(String author1text) {
		  currentPage().authors1TextBox(author1text);
	  }  
	  
	  @Step("Enter text in Author2 text box")
	  public void authors2TextBox(String author2text){
		  currentPage().authors2TextBox(author2text);
	  }  
	  
	  @Step("Enter text in BookTitle text box")
	  public void booksTitleTextBox(String bookTitletext){
		  currentPage().booksTitleTextBox(bookTitletext);
	  } 
	  
	  @Step("Enter text in BookSubtitle text box")
	  public void booksSubtitleTextBox(String bookSubtitletext) {
		  currentPage().booksSubtitleTextBox(bookSubtitletext);
	  }  
	  
	  @Step("Enter text in ISBN13 text box")
	  public void iSBN13TextBox(String iSBN13text){
		  currentPage().iSBN13TextBox(iSBN13text);
	  } 
	  
	  @Step("Enter text in MaterialNumber text box")
	  public void materialsNumberTextBox(String materialNumbertext){
		  currentPage().materialsNumberTextBox(materialNumbertext);
	  } 
	  
	  @Step("Enter text in Workkey text box")
	  public void workkeysTextBox(String workkeytext) {
		  currentPage().workkeysTextBox(workkeytext);
	  } 
	  
	  @Step("Enter text in Format text box")
	  public void formatsTextBox(String formattext){
		  currentPage().formatsTextBox(formattext);
	  }  
	  
	  @Step("Enter text in BISACStatus text box")
	  public void bISACSstatusTextBox(String bISACStatusText){
		  currentPage().bISACSstatusTextBox(bISACStatusText);
	  } 
	  
	  @Step("Enter text in Season text box")
	  public void seasonsTextBox(String seasonText){
		  currentPage().seasonsTextBox(seasonText);
	  } 
	  
	  @Step("Enter text in ImprintGroup text box")
	  public void imprintGroupsTextBox(String imprintGroupText){
		  currentPage().imprintGroupsTextBox(imprintGroupText);
	  } 
	  
	  @Step("Enter text in Imprint text box")
	  public void imprintsTextBox(String imprintText){
		  currentPage().imprintsTextBox(imprintText);
	  } 
	  
	  @Step("Enter text in PageCount text box")
	  public void pagesCountTextBox(String pageCountText){
		  currentPage().pagesCountTextBox(pageCountText);
	  } 
	  
	  @Step("Enter text in TrimSize text box")
	  public void trimsSizeTextBox(String trimSizeText){
		  currentPage().trimsSizeTextBox(trimSizeText);
	  } 
	  
	  @Step("Enter text in Price text box")
	  public void pricesTextBox(String priceText){
		  currentPage().pricesTextBox(priceText);
	  }  
	  
	  @Step("Enter text in Editor1 text box")
	  public void editors1TextBox(String editor1Text){
		  currentPage().editors1TextBox(editor1Text);
	  } 
	  
	  @Step("Enter text in Editor2 text box")
	  public void editors2TextBox(String editor2Text){
		  currentPage().editors2TextBox(editor2Text);
	  } 
	  
	  @Step("Enter text in ManagingEditor1 text box")
	  public void managingEditors1TextBox(String managingEditor1Text){
		  currentPage().managingEditors1TextBox(managingEditor1Text);
	  } 
	  
	  @Step("Enter text in ManagingEditor2 text box")
	  public void managingEditors2TextBox(String managingEditor2Text){
		  currentPage().managingEditors2TextBox(managingEditor2Text);
	  }
	  
	  @Step("Enter text in Designer text box")
	  public void designersTextBox(String designerText){
		  currentPage().designersTextBox(designerText);
	  }
	  
	  @Step("Enter text in JacketDesigner text box")
	  public void jacketDesignersTextBox(String jacketDesignerText){
		  currentPage().jacketDesignersTextBox(jacketDesignerText);
	  }
	  
	  @Step("Enter text in Illustrator text box")
	  public void illustratorsTextBox(String illustratorText){
		  currentPage().illustratorsTextBox(illustratorText);
	  }
	  

	  @Step("Enter text in AgeRange text box")
	  public void ageRangesTextBox(String ageRangeText){
		  currentPage().ageRangesTextBox(ageRangeText);
	  }
	  
	  @Step("Enter text in GradeRange text box")
	  public void gradeRangesTextBox(String gradeRangeText){
		  currentPage().gradeRangesTextBox(gradeRangeText);
	  }
	  
	  @Step("Enter text in BISACSubject text box")
	  public void bISACSubjectsTextBox(String bISACSubjectText){
		  currentPage().bISACSubjectsTextBox(bISACSubjectText);
		  }
	  
	  @Step("Enter text in Audience text box")
	  public void audiencesTextBox(String audienceText){
		  currentPage().audiencesTextBox(audienceText);
	  }
	  
	  @Step("Enter text in Series text box")
	  public void serieesTextBox(String seriesText){
		  currentPage().serieesTextBox(seriesText);
	  }
	  
	  @Step("Enter text in Volume text box")
	  public void volumesTextBox(String volumeText){
		  currentPage().volumesTextBox(volumeText);
		  
	  }
	  
	  @Step("Enter text in KeyTitleIndicator text box")
	  public void keyTitlesIndicatorTextBox(String keyTitleIndicatorText){
		  currentPage().keyTitlesIndicatorTextBox(keyTitleIndicatorText);
	  }
	  
	  @Step("Enter text in PrimaryISBN text box")
	  public void primaryISBNsTextBox(String primaryISBNText) {
		  currentPage().primaryISBNsTextBox(primaryISBNText);
	  }
	  
	  @Step("Enter text in AssociatedISBNs text box")
	  public void associatdISBNsTextBox(String associatedISBNsText){
		  currentPage().associatdISBNsTextBox(associatedISBNsText);
	  }
	  
	  @Step("Click on NeverSendEloquence DropDown")
	  public void neverSendToEloquencesDropDown(final String neverSendEloquence) {
	      currentPage().neverSendToEloquencesDropDown(neverSendEloquence);
	    } 
	  
	  @Step("Verify am_Name Value")
		public void verifyNameValue(String am_name1){
			currentPage().verifyNameValue(am_name1);
		}
	  
	  
	  @Step("Verify Asset Status Value")
		public void verifyAssetStatusValue(String assetstatus1){
			currentPage().verifyAssetStatusValue(assetstatus1);
		}
	  
	  
	  @Step("Verify Renditions created Value")
	  public void verifyRenditionscreatedValue(String am_RenditionsCreated1){
			currentPage().verifyRenditionscreatedValue(am_RenditionsCreated1);
		}
	  
	  @Step("Verify Asset Release date notesValue")
	  
	  public void verifyAssetReleasedatenotesValue(String am_AssetReleasedatenotes1){
		  currentPage().verifyAssetReleasedatenotesValue(am_AssetReleasedatenotes1);
} 
	  
	  @Step("Verify Asset Status notes Value")
	  public void verifyAssetStatusnotesnotesValue(String am_AssetStatusnotes1){
		  currentPage().verifyAssetStatusnotesnotesValue(am_AssetStatusnotes1);
	  }

	  @Step("Verify Asset Type notes Value")
	  public void verifyAssetTypeNotesValue(String am_AssetTypeNotes1){
		  currentPage().verifyAssetTypeNotesValue(am_AssetTypeNotes1);  
	  }
	  
	  
		  @Step("Verify Collection Title Value")
		  public void verifyCollectionTitleValue(String am_CollectionTitle1){
			  currentPage().verifyCollectionTitleValue(am_CollectionTitle1);  
			  
		  }
		  
		  @Step("Verify Author1 Value")
		  public void verifyAuthor1Value(String am_Author11){
			  currentPage().verifyAuthor1Value(am_Author11);
		  }
		  
		  
		  @Step("Verify Author2 Value")
		  public void verifyAuthor2Value(String am_Author21){
			  currentPage().verifyAuthor2Value(am_Author21);
		  }
		  
		  @Step("Verify BookTitle Value")
		  public void verifyBookTitleValue(String am_BookTitle1){
			  currentPage().verifyBookTitleValue(am_BookTitle1);  
		  }
		  
		  @Step("Verify BookSubtitle Value")
		  public void verifyBookSubtitleValue(String am_BookSubtitle1){
			  currentPage().verifyBookSubtitleValue(am_BookSubtitle1); 
		  }
		  
		  @Step("Verify ISBN13 Value")
		  public void verifyISBN13Value(String am_ISBN131){
			  currentPage().verifyISBN13Value(am_ISBN131);
		  }
		  
		  @Step("Verify MaterialNumber Value")
		  public void verifyMaterialNumberValue(String am_MaterialNumber1){
			  currentPage().verifyMaterialNumberValue(am_MaterialNumber1);
		  }
		  
		  @Step("Verify Workkey Value")
		  public void verifyWorkkeyValue(String am_Workkey1){
			  currentPage().verifyWorkkeyValue(am_Workkey1);
		  }
		  
		  
		  @Step("Verify Format Value")
		  public void verifyFormatValue(String am_Format1){
			  currentPage().verifyFormatValue(am_Format1);
		  }
		  
		  @Step("Verify BISACStatus Value")
		  public void verifyBISACStatusValue(String am_BISACStatus1){
			  currentPage().verifyBISACStatusValue(am_BISACStatus1);
		  }
		  
		  @Step("Verify Season Value")
		  public void verifySeasonValue(String am_Season1){
			  currentPage().verifySeasonValue(am_Season1);
		  }
		  
		  @Step("Verify ImprintGroup Value")
		  public void verifyImprintGroupValue(String am_ImprintGroup1){
			  currentPage().verifyImprintGroupValue(am_ImprintGroup1);
		  }
		  
		  @Step("Verify Imprint Value")
		  public void verifyImprintValue(String am_Imprint1){
			  currentPage().verifyImprintValue(am_Imprint1);
		  }
		  
		  @Step("Verify PageCount Value")
		  public void verifyPageCountValue(String am_PageCount1){
			  currentPage().verifyPageCountValue(am_PageCount1);
		  }
		  
		  @Step("Verify TrimSize Value")
		  public void verifyTrimSizeValue(String am_TrimSize1){
			  currentPage().verifyTrimSizeValue(am_TrimSize1); 
		  }
		  
		  @Step("Verify Price Value")
		  public void verifyPriceValue(String am_Price1){
			  currentPage().verifyPriceValue(am_Price1);
		  }
		  
		  @Step("Verify Editor1 Value")
		  public void verifyEditor1Value(String am_Editor11){
			  currentPage().verifyEditor1Value(am_Editor11);
		  }
		  
		  @Step("Verify Editor2 Value")
		  public void verifyEditor2Value(String am_Editor21){
			  currentPage().verifyEditor2Value(am_Editor21);
		  }
		  
		  @Step("Verify ManagingEditor1 Value")
		  public void verifyManagingEditor1Value(String am_ManagingEditor11){
			  currentPage().verifyManagingEditor1Value(am_ManagingEditor11);  
		  }
		  
		  @Step("Verify ManagingEditor2 Value")
		  public void verifyManagingEditor2Value(String am_ManagingEditor21){
			  currentPage().verifyManagingEditor2Value(am_ManagingEditor21);
		  }
		  
		  @Step("Verify Designer Value")
		  public void verifyDesignerValue(String am_Designer1){
			  currentPage().verifyDesignerValue(am_Designer1);
		  }
		  
		  
		  @Step("Verify JacketDesigner Value")
		  public void verifyJacketDesignerValue(String am_JacketDesigner1){
			  currentPage().verifyJacketDesignerValue(am_JacketDesigner1);
		  }
		  
		  @Step("Verify Illustrator Value")
		  public void verifyIllustratorValue(String am_Illustrator1){
			  currentPage().verifyIllustratorValue(am_Illustrator1); 
		  }
		  
		  
		  @Step("Verify AgeRange Value")
		  public void verifyAgeRangeValue(String am_AgeRange1){
			  currentPage().verifyAgeRangeValue(am_AgeRange1);
		  }
		  
		  
		  @Step("Verify GradeRange Value")
		  public void verifyGradeRangeValue(String am_GradeRange1){
			  currentPage().verifyGradeRangeValue(am_GradeRange1);
		  }
		  
		  
		  @Step("Verify BISACSubject Value")
		  public void verifyBISACSubjectValue(String am_BISACSubject1){
			  currentPage().verifyBISACSubjectValue(am_BISACSubject1);
		  }
		  
		  @Step("Verify Audience Value")
		  public void verifyAudienceValue(String am_Audience1){
			  currentPage().verifyAudienceValue(am_Audience1); 
		  }
		  
		  @Step("Verify Series Value")
		  public void verifySeriesValue(String am_Series1){
			  currentPage().verifySeriesValue(am_Series1);
		  }
		  
		  @Step("Verify Volume Value")
		  public void verifyVolumeValue(String am_Volume1){
			  currentPage().verifyVolumeValue(am_Volume1);
		  }
		  
		  
		  @Step("Verify KeyTitleIndicator Value")
		  public void verifyKeyTitleIndicatorValue(String am_KeyTitleIndicator1){
			  currentPage().verifyKeyTitleIndicatorValue(am_KeyTitleIndicator1);
		  }
		  
		  
		  @Step("Verify PrimaryISBN Value")
		  public void verifyPrimaryISBNValue(String am_PrimaryISBN1){
			  currentPage().verifyPrimaryISBNValue(am_PrimaryISBN1);
		  }
		  
		  
		  @Step("Verify AssociatedISBNs Value")
		  public void verifyAssociatedISBNsValue(String am_AssociatedISBNs1){
			  currentPage().verifyAssociatedISBNsValue(am_AssociatedISBNs1);
		  }

		  @Step("Verify proposedProdEffectsentryMultiple select Value")
		  
		  public void proposedProdEffectsentryMultipleSelect(final String ProdEffectsentryMultipleSelect){
			  currentPage().proposedProdEffectsentryMultipleSelect(ProdEffectsentryMultipleSelect);
		  }
		  
		  
          @Step("Verify VproposedProdEffectsentryMultiple select Value")
		  
          public void verifyproposedProdEffectsentryMultipleSelect(final String am_Multipleselect1) {
        		
			  currentPage().verifyproposedProdEffectsentryMultipleSelect(am_Multipleselect1);
          }
          
          //Asset management Steps End
	  
        //added by Salai (Incident 8797)
      	
    	  @Step("Enter Caption for HIP object {0}")
    	  public void enterCaptionForHipObject(String caption){
    		  currentPage().enterCaptionForHipObject(caption);
    	  }
    	  
    	  @Step("Select the Genre for HIP object {0}")
    	  public void selectGenreForHipObject(String genreSelectdrop){
    		  currentPage().selectGenreForHipObject(genreSelectdrop);
    	  }
    	  
    	  @Step("Select the Asset Subtype for HIP object {0}")
    	 public void selectAssetSubtypeForHipObject(String assetSubtypeSelectdrop){
    		  currentPage().selectAssetSubtypeForHipObject(assetSubtypeSelectdrop);
    	  }
    	  
//Tag Methods
          
          @Step("Add a new tag {0}")
      	public void addNewTag(String newTag) {
      		currentPage().addNewTag(newTag);
      	}
          @Step("Edit title{0}")
          public void addExistingTag(String tagName) {
              currentPage().addExistingTag(tagName);
          }

          @Step("Confirm multiple edit propertiesc ")
          public void okButtonOnTagsPopUpClick() {
              currentPage().okButtonOnTagsPopUpClick();
          }
          //pradeep
          @Step("click on uri_primary help text")
    	  public void uriPrimaryHelpIcon(String uriPrimaryHelpText) {
    		  currentPage().uriPrimaryHelpIcon(uriPrimaryHelpText);
    	  }
          @Step("Enter text in uri_primary text box")
    	  public void uriPrimary(String uri_primary) {
    		  currentPage().uriPrimary(uri_primary);
    	  }
          @Step("click on uri_primary help text")
    	  public void uriSupplementalHelpIcon(String uriSupplementalHelpText) {
    		  currentPage().uriSupplementalHelpIcon(uriSupplementalHelpText);
    	  }
         
          @Step("Enter text in uri_supplemental text box")
    	  public void uriSupplemental(String uri_supplemental) {
    		  currentPage().uriSupplemental(uri_supplemental);
    	  }
          
          public void programLabelAdvSearch(String searchText) {
        	  currentPage().programLabelAdvSearch(searchText);
          }
		   
          //BrightCove Account Name Field
          
          @Step("Fill in details for BrightCove section")
    	  public boolean BrightcoveAccountName(String brtcoveacnm, String locid, String covid) {
    		 boolean found=false;
        	  found=currentPage().BrightcoveAccountName(brtcoveacnm,locid,covid);
        	  return found;
    	  }
          
          
          //BrightCove Account Name Field validation
          
          @Step("Validate details for BrightCove section")
    	  public void ValidateBrightcoveAccountDetails(String brtcoveacnm, String locid, String covid) {
    		  currentPage().ValidateBrightcoveAccountDetails(brtcoveacnm,locid,covid);
    	  }
          @Step("edit User Role Metadata Field")
    	  public void editUserRoleMetadataField(String role) {
    		  currentPage().editUserRoleMetadataField(role); 
    	  }
          
          @Step("Check the checkbox for Create Downladable epub") 
          public void checkCreateDownladableEpub() {
    		  currentPage().checkCreateDownladableEpub(); 
        	  
          }
        //**** ALF-2015 ** Update ePubs when User Role Value is Changed ** Sprint 7.3.1 **         
          @Step("Change the User Role Metadata Field")
    	  public void changeUserRoleMetadataField(String userrole) {
    		  currentPage().changeUserRoleMetadataField(userrole); 
    	  }  
        //**** ALF-2073  ** Improve Validation of User-Populated Program Label Values ** Sprint 7.3.1 **
          @Step("Validate the pop up message on program label metadata field")
    	  public void validatePopUpMsgProgramLabelMetadata() {
    		  currentPage().validatePopUpMsgProgramLabelMetadata(); 
    	  }  
        //**** ALF-2073  ** Improve Validation of User-Populated Program Label Values ** Sprint 7.3.1 **
          @Step("Validate the tool tip on program label metadata field")
    	  public void validateToolTipProgramLabelMetadata() {
    		  currentPage().validateToolTipProgramLabelMetadata(); 
    	  }  
        //** ALF - 2015 ** Update ePubs when User Role Value is Changed ** Sprint 7.3.1 **
  	    @Step("Select the radio button on Push to Habitat Pop Up box")
  	    public void selectRegenerateEpub(){
  	           currentPage().selectRegenerateEpub();
  	    }
  	    //** ALF - 2083 ** Changes to Genre Values in OneCMS ** Sprint 7.3.2 **
  	    @Step("Verfify the new Genre fields for HIP object")
  	    public void verifyGenreFieldForHipObject(String newgenreSelectdrop1,String newgenreSelectdrop2){
  	    	currentPage().verifyGenreFieldForHipObject(newgenreSelectdrop1,newgenreSelectdrop2);
  	    }
  	    //** ALF 2108 ** Create a Second Product Label for Teacher CO/CCOs in Dual-Delivery POs ** Sprint 7.3.2 **
  	    @Step("Select Teacher product label metadata field")
  	    public void selectTeacherProductLabel(String teacherproductLabel) {
	      currentPage().selectTeacherProductLabel(teacherproductLabel);
	    }
  	    //** ALF 2108 ** Create a Second Product Label for Teacher CO/CCOs in Dual-Delivery POs ** Sprint 7.3.2 **
  	    @Step("Validate the tool tip on Teacher product label metadata field")
  	    public void validateToolTipTeacherProductLabel() {
  	    	currentPage().validateToolTipTeacherProductLabel(); 
  	    } 

  	    //** ALF 2167 ** Standards Recommendation Data  ** Sprint 7.3.3 **
  	    @Step("Validate the tool tip on Teacher product label metadata field")
  	    public void standardRecommendationDropdown(String dropValue) {
  	    	currentPage().standardRecommendationDropdown(dropValue); 
  	    } 
  	    
  	    //** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
  	    @Step(" Click on View Details on Renditions folder")
  	    public void clickViewDetailsOnRenditionsFolder() {
  	    	currentPage().clickViewDetailsOnRenditionsFolder(); 
  	    } 
  	   
  	    //** ALF-2277 **  Trade: Modify existing Asset Status Dropdown values ** Sprint 7.3.4 **
  	    @Step("Verify the Assets status for the DropDown values")
  	    public void verifyAssetStatusDropDown(final String assetsstatus,final String asset) {
  	    	currentPage().verifyAssetStatusDropDown(assetsstatus, asset);
  	    }
  	    
  	    //** ALF-2276 **  Trade: Add  "Restricted Elo Release" field to Title Metadata ** Sprint 7.3.4 ** 
  	    @Step("Verify the Restricted Elo Release Read only property")
  	    public void verifyRestrictedEloReleaseField(final String assetstatus) {
  	    	currentPage().verifyRestrictedEloReleaseField(assetstatus);
  	    }
  	    
  	    // ** ALF - 2292 ** Add new Discipline values ** Sprint 7.3.4 **
  	    @Step("Click on ProductCategory MultiSelect ")
  	    public void selectCategory(String itemName1,String itemName2) {
  	    	currentPage().selectCategory(itemName1, itemName2);
  	    }
  	    
	  	//** ALF-2128 ** Learning Spine Correlations are Visible on the View Details Page ** Sprint 7.3.4 **
	  	//** ALF-2140 **  Deleting a Learning Spine Correlations ** Sprint 7.3.4 **
  	    @Step(" Click on Generate Correlations Action on Product Sets folder")
  	    public void clickGenerateCorrelationActionOnPS()
  	    {
  	    	currentPage().clickGenerateCorrelationActionOnPS();
  	    }
  	    
  	    //** ALF-2128 ** Learning Spine Correlations are Visible on the View Details Page ** Sprint 7.3.4 **
  	    //** ALF-2140 **  Deleting a Learning Spine Correlations ** Sprint 7.3.4 **
  	    @Step(" Click on Generate Correlations Action on Product Sets folder")
  	    public void clickCorrelateStandards()
  	    {
  	    	currentPage().clickCorrelateStandards();
  	    }
  	  //** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **
  	    @Step("Click on {0} to navigate in Move to action references Dialog Box")
	    public void navigateInMoveFilesreferencesDialogBox(String siteName) {
		  currentPage().navigateInMoveFilesreferencesDialogBox(siteName);
		}
  	    
  	 //** ALF - 1585  - Invoke Move to Action on Multiple Items from Search Results ** Sprint 7.3.4 **
  	    @Step("Click on {0} to navigate in Move to action references Dialog Box")
	    public void navigateInAssetsFolderandMoveAction() {
		  currentPage().navigateInAssetsFolderandMoveAction();
		}
  	 //** ALF-2335 ** Trade: Create new asset types for Author Questionnaire, Excerpt, Launch Script, Text, and Selling Sample ** Sprint 7.3.5    
  	    @Step("Click on Assetsstatus DropDown")
  	    public void verifyAssettypeDropDown(final String assetsstatus) {
  	    	currentPage().verifyAssettypeDropDown(assetsstatus);
  	    }
}




