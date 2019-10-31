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


@Story(HMHApplication.LearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_Reg096_K12_Add_values_product_type_dropdown_metadata_field.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_Reg096_K12_Add_values_product_type_dropdown_metadata_field extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	
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
	    
	    private String typeCCO, objectNameCCO, typeCO, objectNameCO, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest, ccoLabel="ccoAuto",
	    productCategory, lifeCycle = "Planning", productTypeID1, productTypeID2, typeAsset, objectNameAsset, studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text", description="automation", publisher ="DHX", fileName="ctsQA.txt";
	    
	    
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }
	    
	    @Test
	    @Title("Test_Reg096_K12_Add_values_product_type_dropdown_metadata_field")
	    public void test_Reg096_K12_Add_values_product_type_dropdown_metadata_field(){
	    	
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
	        hmhEditPropertiesSteps.productCategoryMultiSelect(productCategory);
	        hmhEditPropertiesSteps.verifyProductTypeDropDown(productTypeID1);
	        hmhEditPropertiesSteps.verifyProductTypeDropDown(productTypeID2);
	        hmhEditPropertiesSteps.productTypeDropDown(productType);
	        hmhEditPropertiesSteps.productTypeIDDropDown(productTypeID);
	        hmhEditPropertiesSteps.productTypeSubIDTextBox(productTypeSubID);//HMH ID text
	        hmhEditPropertiesSteps.userRoleDropDown(userRole);
	        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
	        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
	        hmhEditPropertiesSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        shareHeaderSteps.customWait(3);
	    	hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
	        documentLibrarySteps.createNewContent(typeCCO);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createLearningObjectK12Site(objectNameCCO, grade, language, rights, market, title, lifeCycle);
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectNameCCO);
	        hmhDocumentLibrarySteps.assetFromListClick(objectNameCCO);
	        hmhDocumentLibrarySteps.navBarClick(objectNameCCO);
	        shareHeaderSteps.customWait(3);       
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
	        hmhEditPropertiesSteps.editTitle(title);
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.productCategoryMultiSelect(productCategory);
	        hmhEditPropertiesSteps.verifyProductTypeDropDown(productTypeID1);
	        hmhEditPropertiesSteps.verifyProductTypeDropDown(productTypeID2);
	        hmhEditPropertiesSteps.productTypeDropDown(productType);
	        hmhEditPropertiesSteps.productTypeIDDropDown(productTypeID);
	        hmhEditPropertiesSteps.productTypeSubIDTextBox(productTypeSubID);//HMH ID text
	        hmhEditPropertiesSteps.userRoleDropDown(userRole);
	        hmhEditPropertiesSteps.editCcoLabel(ccoLabel);
	        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
	        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
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
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.verifyProductTypeDropDown(productTypeID1);
	        hmhEditPropertiesSteps.verifyProductTypeDropDown(productTypeID2);
	        hmhEditPropertiesSteps.productTypeDropDown(productType);
	        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
	        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
	        
	        
	      
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
	        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
	         siteHeaderSteps.clickOnDocumentLibraryButton();
	        
	        
	    }
}

