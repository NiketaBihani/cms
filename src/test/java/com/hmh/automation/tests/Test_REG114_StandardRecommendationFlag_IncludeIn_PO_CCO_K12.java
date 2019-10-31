//** ALF 2167 **  Standards Recommendation Data include in PO's & CO's  ** Sprint 7.3.3 **
package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
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
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.ProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG114_StandardRecommendationFlag_IncludeIn_PO_CCO_K12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG114_StandardRecommendationFlag_IncludeIn_PO_CCO_K12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Managed(uniqueSession = true) 
	
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
    //
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;


    String type, year, grade, markets, label1, numbering1, objectName, title, siteTypeTest, description="automation";
    String dropValue="True";
    private String objectNameCO, language, market, lifecycle, rights ,diffLevel,
    productCategory,studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text"; 
    

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG114 - Standard Recommendation Flag to Include In POs & CCOs")
    public void test_REG114_StandardRecommendationFlag_IncludeIn_PO_CCO_K12() {

      // Create a PO structure
        hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering1, markets, title);
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);
        shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
      
      // Verify the Standards Recommendation Flag in PO
        
        hmhEditPropertiesSteps.standardRecommendationDropdown(dropValue); 
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.COPY_RIGHT_YEAR, year);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_1_LABEL, label1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NUMBERING_1, numbering1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.STANDARDS_RECOMMENDATION_LABEL, dropValue);


        siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		
	 // Create CO structure 
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentDetailsSteps.createLOforK12();
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectK12Site(objectNameCO, grade, language, rights, market, title, lifecycle);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameCO);
        shareHeaderSteps.customWait(3);       
      
     // Verify the Standards Recommendation Flag in CO
        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.productCategoryMultiSelect(productCategory);
        hmhEditPropertiesSteps.productTypeDropDown(productType);
        hmhEditPropertiesSteps.productTypeIDDropDown(productTypeID);
        hmhEditPropertiesSteps.productTypeSubIDTextBox(productTypeSubID);
        hmhEditPropertiesSteps.userRoleDropDown(userRole);
        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
        hmhEditPropertiesSteps.selectDifferentiationLevel(diffLevel);
        hmhEditPropertiesSteps.standardRecommendationDropdown(dropValue); 
        hmhEditPropertiesSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameCO);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodCatLab,productCategory);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeIDLab,productTypeID);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.userRolLab,userRole);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE,activityType);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DIFFERENTIATION_LEVEL,diffLevel);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.STANDARDS_RECOMMENDATION_LABEL, dropValue);
        System.out.println("Script Completed..");
        
    }
}
