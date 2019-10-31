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
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.LearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_Reg095_Cons_HMH_Keywords_free_text_field.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_Reg095_Cons_HMH_Keywords_free_text_field extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	
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
	    
	    private String  PStype, POtype, typeSB, typeLB, typePG, PSobjectName, POobjectName, objectNameSB, objectNameLB, objectNamePG,  keyword ,  year, typeCCO, objectNameCCO, label1,  typeCO, objectNameCO, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest, ccoLabel="ccoAuto",
	    productCategory,    numbering1 = "Number, Level 1 restart",   typeAsset, objectNameAsset, studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text", description="automation", publisher ="DHX", fileName="ctsQA.txt";
	    
	   
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }
	    
	    @Test
	    @Title("Test_Reg095_Cons_HMH_Keywords_free_text_field")
	    public void test_Reg095_Cons_HMH_Keywords_free_text_field(){
	    	
	    	hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
	    	hmhDocumentDetailsSteps.createNewContentNew(PStype);
	    	hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createProductSet(PSobjectName, year, grade, label1, numbering1, market, title);
	        hmhDocumentLibrarySteps.refresh();
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(PSobjectName);
	        hmhDocumentLibrarySteps.assetFromListClick(PSobjectName);
	        hmhDocumentLibrarySteps.navBarClick(PSobjectName);
	        shareHeaderSteps.customWait(3);        
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        
	        hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
	        hmhDocumentDetailsSteps.createNewContentNew(POtype);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createProductSet(POobjectName, year, grade, label1, numbering1, market, title);
	        hmhDocumentLibrarySteps.refresh();
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(POobjectName);
	        hmhDocumentLibrarySteps.assetFromListClick(POobjectName);
	        hmhDocumentLibrarySteps.navBarClick(POobjectName);
	        shareHeaderSteps.customWait(3);        
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        
	        hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
	        hmhDocumentDetailsSteps.createNewContentNew(typeSB);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createSequenceBundle(objectNameSB, market, title);
	        hmhDocumentLibrarySteps.refreshToExitPopup();
	        hmhDocumentLibrarySteps.assetFromListClick(objectNameSB);
	        hmhDocumentLibrarySteps.navBarClick(objectNameSB);
	        shareHeaderSteps.customWait(3);       
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        shareHeaderSteps.customWait(3);
	        
	        hmhDocumentLibrarySteps.assetFromListClick(LearningBundlesFolder);
	        hmhDocumentDetailsSteps.createNewContentNew(typeLB);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createLearningBundleK12Site(objectNameLB, title, lifecycle, market, grade );
	        hmhDocumentLibrarySteps.refresh();
	        hmhDocumentLibrarySteps.assetFromListClick(objectNameLB);
	        hmhDocumentLibrarySteps.navBarClick(objectNameLB);
	        shareHeaderSteps.customWait(3);
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        shareHeaderSteps.customWait(3);
	        
	        
	    	hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
	    	hmhDocumentDetailsSteps.createNewContentNew(typeCO);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createLearningObjectK12Site(objectNameCO, grade, language, rights, market, title, lifecycle);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
	        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameCO);
	        shareHeaderSteps.customWait(3);       
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        hmhEditPropertiesSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        shareHeaderSteps.customWait(3);

	        
	        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
	        documentLibrarySteps.createNewContent(typeCCO);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createLearningObjectK12Site(objectNameCCO, grade, language, rights, market, title, lifecycle);
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectNameCCO);
	        hmhDocumentLibrarySteps.assetFromListClick(objectNameCCO);
	        hmhDocumentLibrarySteps.navBarClick(objectNameCCO);
	        shareHeaderSteps.customWait(3);       
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
	        hmhEditPropertiesSteps.editTitle(title);
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
		    shareHeaderSteps.customWait(3);
		    
		    
		    hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		    shareHeaderSteps.customWait(3);
		    hmhDocumentDetailsSteps.createNewContentNew(typeAsset);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
	        shareHeaderSteps.customWait(3);
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectNameAsset);
	        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
	        shareHeaderSteps.customWait(3);
	        hmhEditPropertiesSteps.editPropClick();;
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        shareHeaderSteps.customWait(3);
	        
	        
	        hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
	        documentLibrarySteps.createNewContent(typePG);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createProgram(objectNamePG, title, market);
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectNamePG);
	        hmhDocumentLibrarySteps.assetFromListClickSub(objectNamePG);
	        hmhDocumentLibrarySteps.navBarClick(objectNamePG);
	        hmhEditPropertiesSteps.editPropClick();
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editHMHKeywords(keyword);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        
	        
	    }
}

