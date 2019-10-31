//** ALF1979 ** Preserve current metadata when reverting to previously versioned files ** Sprint 7.3.2 **
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


@Story(HMHApplication.LearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG107_VerifyContentAndMetadata_CO_Assets_WithRevertOption.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG107_VerifyContentAndMetadata_CO_Assets_WithRevertOption extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    //
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;


    private String typeCO,typeAsset,objectNameAsset, objectNameCO,name, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest,diffLevel,jpeg1,versionType, comment,
    productCategory, PrevUnId = "PU ID#1",studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text", description="automation", publisher ="DHX", fileName="tc107.jpeg",newfile="fileBen10.jpg";
    String versionComment = "New Version";
    String newDescription="newDescription";
    String fileNameExt="jpeg";
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG107_VerifyContentAndMetadata  on CO & Assets With Revert Option")
    public void test_REG107_VerifyContentAndMetadata_CO_Assets_WithRevertOption() {
     /*
    	// Preserve current metadata by creating new CO object
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentDetailsSteps.createLOforK12();
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectK12Site(objectNameCO, grade, language, rights, market, title, lifecycle);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameCO);
        shareHeaderSteps.customWait(3);     
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.productCategoryMultiSelect(productCategory);
        hmhEditPropertiesSteps.productTypeDropDown(productType);
        hmhEditPropertiesSteps.productTypeIDDropDown(productTypeID);
        hmhEditPropertiesSteps.productTypeSubIDTextBox(productTypeSubID);
        hmhEditPropertiesSteps.userRoleDropDown(userRole);
        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
        hmhEditPropertiesSteps.editPrevUniqId(PrevUnId);
        hmhEditPropertiesSteps.searchCheckBox();
        hmhEditPropertiesSteps.selectDifferentiationLevel(diffLevel);
        hmhEditPropertiesSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        hmhDocumentLibrarySteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);       
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
  		siteHeaderSteps.clickOnDocumentLibraryButton();
  		siteHeaderSteps.customWait(3);
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(objectNameCO);
        hmhDocumentLibrarySteps.navBarClick(objectNameCO);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        // Adding new description on Edit Properties page
        hmhEditPropertiesSteps.editDescription(newDescription);
        hmhEditPropertiesSteps.saveButtonClick();
        siteHeaderSteps.customWait(3);
        hmhEditPropertiesSteps.refreshPage();
        // To check the latest updated version
        hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
        hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
        // To click on Revert button and perform Revert Content and Metadata action 
        hmhDocumentDetailsSteps.revertbutton();
        hmhDocumentDetailsSteps.revertContentAndMetadataRadio();
        hmhDocumentDetailsSteps.selectTheVersionAndAddCommentOnRevertWindow(versionType, comment);
        shareHeaderSteps.customWait(3);        
        // Verify the properties on view details page for version 1.0
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameCO);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodCatLab,productCategory);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeIDLab,productTypeID);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.userRolLab,userRole);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE,activityType);
        hmhDocumentDetailsSteps.verifyPropertyValue("Previous Unique ID:",PrevUnId);
        hmhDocumentDetailsSteps.verifyPropertyValue("Searchable:","No");
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DIFFERENTIATION_LABEL, diffLevel);
        siteHeaderSteps.clickOnDocumentLibraryButton();
  		siteHeaderSteps.customWait(3);*/
    
  		// Preserve current content and metadata by creating new Asset object
  		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
  		documentLibrarySteps.createNewContent(typeAsset);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
        shareHeaderSteps.customWait(3);

        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.productTypeDropDown(productType);
        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
        editPropertiesDocumentSteps.saveButtonClick();
        documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        shareHeaderSteps.customWait(8);
        hmhEditPropertiesSteps.refreshPage();
        //To edit the description metadata
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(newDescription);
        editPropertiesDocumentSteps.saveButtonClick();
        documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + newfile);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        shareHeaderSteps.customWait(8);
        hmhEditPropertiesSteps.refreshPage();
       // To click on Revert button and perform Revert Content and Metadata action 
        shareHeaderSteps.customWait(3);
        hmhDocumentDetailsSteps.revertbutton();
        hmhDocumentDetailsSteps.revertContentAndMetadataRadio();
        hmhDocumentDetailsSteps.selectTheVersionAndAddCommentOnRevertWindow(versionType, comment);
        shareHeaderSteps.customWait(8);      
        // Verify the properties on view details page for version 3.0
        hmhEditPropertiesSteps.refreshPage();
        // Verify the Metadata properties on View details page 
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameAsset);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RIGHTS, rights);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab, productType);         
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE, activityType);
        hmhDocumentLibrarySteps.verifymimext(fileNameExt);
        System.out.println("Script Completed..");
      	
    
    
    
    
    }}