package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Asset.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG080_CreateVerifyAssetManagemtSiteMetadata.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG080_CreateVerifyAssetManagemtSiteMetadata extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHSetupSteps hmhSetupSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    

    
    private String  siteTypeTest, fileName,
    nametext,assetsstatus,renditionCreated,assetReleasRestricted,assetReleaseDateNotestext,assetStatusRightsNotestext,
    assetTyp,assetTypeNotestext,proposedProductionEffectsNotestext,assetEnhancedWeb,collectionTitletext,author1text,
    author2text,bookTitletext,bookSubtitletext,iSBN13text,materialNumbertext,workkeytext,formattext,bISACStatusText,
    seasonText,imprintGroupText,imprintText,pageCountText,trimSizeText,priceText,editor1Text,editor2Text,managingEditor1Text,
    managingEditor2Text,designerText,jacketDesignerText,illustratorText,ageRangeText,gradeRangeText,bISACSubjectText,audienceText,
    seriesText,volumeText,keyTitleIndicatorText,primaryISBNText,associatedISBNsText,neverSendEloquence,ProdEffectsentryMultipleSelect,
    onsalemonthCalender1,onsalemonthCalenderyear1;
   
    @Override
    public void setSiteType() {
    	siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG080 - Create Asset(Component) in Asset Management Site, Edit properties and Verify Metadata Properties")
    public void test_REG080_CreateVerifyAssetManagemtSiteMetadata() {
    	
    	 documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
    	 hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         shareHeaderSteps.customWait(3);
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         hmhEditPropertiesSteps.nameLabel(nametext);
         hmhEditPropertiesSteps.assetstatusDropDown(assetsstatus);
         hmhEditPropertiesSteps.renditionsCreatedDropDown(renditionCreated);
         hmhEditPropertiesSteps.assetReleaseRestrictedDropDown(assetReleasRestricted);
         hmhEditPropertiesSteps.assetReleaseDateNotesTextBox(assetReleaseDateNotestext);
         hmhEditPropertiesSteps.assetStatusRightsNotesTextBox(assetStatusRightsNotestext);
         hmhEditPropertiesSteps.assetTypeDropDown(assetTyp);
         hmhEditPropertiesSteps.assetTypNotesTextBox(assetTypeNotestext);
         hmhEditPropertiesSteps.proposedProdEffectsentryMultipleSelect(ProdEffectsentryMultipleSelect);
         hmhEditPropertiesSteps.proposedProductionEffectNotesTextBox(proposedProductionEffectsNotestext);
         hmhEditPropertiesSteps.assetEnhancdforwebDropDown(assetEnhancedWeb);
         hmhEditPropertiesSteps.collectionsTitleTextBox(collectionTitletext);
         /*hmhEditPropertiesSteps.authors1TextBox(author1text);
         hmhEditPropertiesSteps.authors2TextBox(author2text);
         hmhEditPropertiesSteps.booksTitleTextBox(bookTitletext);
         hmhEditPropertiesSteps.booksSubtitleTextBox(bookSubtitletext);
         hmhEditPropertiesSteps.iSBN13TextBox(iSBN13text);
         hmhEditPropertiesSteps.materialsNumberTextBox(materialNumbertext);
         hmhEditPropertiesSteps.workkeysTextBox(workkeytext);
         hmhEditPropertiesSteps.formatsTextBox(formattext);
         hmhEditPropertiesSteps.bISACSstatusTextBox(bISACStatusText);
         hmhEditPropertiesSteps.seasonsTextBox(seasonText);
         hmhEditPropertiesSteps.imprintGroupsTextBox(imprintGroupText);
         hmhEditPropertiesSteps.imprintsTextBox(imprintText);
         hmhEditPropertiesSteps.pagesCountTextBox(pageCountText);
         hmhEditPropertiesSteps.trimsSizeTextBox(trimSizeText);
         hmhEditPropertiesSteps.pricesTextBox(priceText);
         hmhEditPropertiesSteps.editors1TextBox(editor1Text);
         hmhEditPropertiesSteps.editors2TextBox(editor2Text);
         hmhEditPropertiesSteps.managingEditors1TextBox(managingEditor1Text);
         hmhEditPropertiesSteps.managingEditors2TextBox(managingEditor2Text);
         hmhEditPropertiesSteps.designersTextBox(designerText);
         hmhEditPropertiesSteps.jacketDesignersTextBox(jacketDesignerText);
         hmhEditPropertiesSteps.illustratorsTextBox(illustratorText);
         hmhEditPropertiesSteps.ageRangesTextBox(ageRangeText);
         hmhEditPropertiesSteps.gradeRangesTextBox(gradeRangeText);
         hmhEditPropertiesSteps.bISACSubjectsTextBox(bISACSubjectText);
         hmhEditPropertiesSteps.audiencesTextBox(audienceText);
         hmhEditPropertiesSteps.serieesTextBox(seriesText);
         hmhEditPropertiesSteps.volumesTextBox(volumeText);
         hmhEditPropertiesSteps.keyTitlesIndicatorTextBox(keyTitleIndicatorText);
         hmhEditPropertiesSteps.primaryISBNsTextBox(primaryISBNText);
         hmhEditPropertiesSteps.associatdISBNsTextBox(associatedISBNsText);
         hmhEditPropertiesSteps.neverSendToEloquencesDropDown(neverSendEloquence);*/
         editPropertiesDocumentSteps.saveButtonClick();
         shareHeaderSteps.customWait(10);
         hmhEditPropertiesSteps.verifyNameValue(nametext);
         hmhEditPropertiesSteps.verifyAssetReleasedatenotesValue(assetReleaseDateNotestext);
         hmhEditPropertiesSteps.verifyAssetStatusnotesnotesValue(assetStatusRightsNotestext);		         		       
         hmhEditPropertiesSteps.verifyAssetTypeNotesValue(assetTypeNotestext);	 
         /*hmhEditPropertiesSteps.verifyCollectionTitleValue(collectionTitletext);
         hmhEditPropertiesSteps.verifyAuthor1Value(author1text);
         hmhEditPropertiesSteps.verifyAuthor2Value(author2text);
         hmhEditPropertiesSteps.verifyBookTitleValue(bookTitletext);
         hmhEditPropertiesSteps.verifyBookSubtitleValue(bookSubtitletext);
         hmhEditPropertiesSteps.verifyISBN13Value(iSBN13text);
         hmhEditPropertiesSteps.verifyMaterialNumberValue(materialNumbertext);
         hmhEditPropertiesSteps.verifyWorkkeyValue(workkeytext);
         hmhEditPropertiesSteps.verifyFormatValue(formattext);
         hmhEditPropertiesSteps.verifyBISACStatusValue(bISACStatusText);
         hmhEditPropertiesSteps.verifySeasonValue(seasonText);
         hmhEditPropertiesSteps.verifyImprintGroupValue(imprintGroupText);
         hmhEditPropertiesSteps.verifyImprintValue(imprintText);
         hmhEditPropertiesSteps.verifyPageCountValue(pageCountText);
         hmhEditPropertiesSteps.verifyTrimSizeValue(trimSizeText);
         hmhEditPropertiesSteps.verifyPriceValue(priceText);
         hmhEditPropertiesSteps.verifyEditor1Value(editor1Text);
         hmhEditPropertiesSteps.verifyEditor2Value(editor2Text);
         hmhEditPropertiesSteps.verifyManagingEditor1Value(managingEditor1Text);
         hmhEditPropertiesSteps.verifyManagingEditor2Value(managingEditor2Text);
         hmhEditPropertiesSteps.verifyDesignerValue(designerText);
         hmhEditPropertiesSteps.verifyJacketDesignerValue(jacketDesignerText);
         hmhEditPropertiesSteps.verifyIllustratorValue(illustratorText);
         hmhEditPropertiesSteps.verifyAgeRangeValue(ageRangeText);
         hmhEditPropertiesSteps.verifyGradeRangeValue(gradeRangeText);
         hmhEditPropertiesSteps.verifyBISACSubjectValue(bISACSubjectText);
         hmhEditPropertiesSteps.verifyAudienceValue(audienceText);
         hmhEditPropertiesSteps.verifySeriesValue(seriesText);
         hmhEditPropertiesSteps.verifyVolumeValue(volumeText);
         hmhEditPropertiesSteps.verifyKeyTitleIndicatorValue(keyTitleIndicatorText);
         hmhEditPropertiesSteps.verifyPrimaryISBNValue(primaryISBNText);
         hmhEditPropertiesSteps.verifyAssociatedISBNsValue(associatedISBNsText);*/
         hmhEditPropertiesSteps.verifyproposedProdEffectsentryMultipleSelect(ProdEffectsentryMultipleSelect);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ASSET_STATUS,assetsstatus);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RENDITIONS_CREATED,renditionCreated);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ASSET_RELEASE_RESTRICTED,assetReleaseDateNotestext);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ASSET_TYPE,assetTyp);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ASSET_ENHANCEDFOR_WEB,assetEnhancedWeb);
         //hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NEVER_SENDTO_ELOQUENCE,neverSendEloquence);
         
         
         
        
         
       

    }
}
