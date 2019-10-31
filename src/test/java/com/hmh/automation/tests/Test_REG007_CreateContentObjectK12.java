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
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;


@Story(HMHApplication.LearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG007_CreateContentObjectK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG007_CreateContentObjectK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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


    private String typeCO, objectNameCO, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest,diffLevel,
    productCategory, PrevUnId = "PU ID#1",studentFacing, activityType, userRole, productTypeID, productType, productTypeSubID="CO product Sub ID Text", description="automation", publisher ="DHX", fileName="ctsQA.txt"; 
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG007 - Create Content(Learning) Object in K12 Site, Edit properties and Verify Metadata Properties")
    public void test_REG007_CreateContentObjectK12() {

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
      //**** ALF-1975 New Metadata Field on COs, CCOs, and POs: “Differentiation Level" (Sprint 7.2.5)****
        hmhEditPropertiesSteps.selectDifferentiationLevel(diffLevel);
        hmhEditPropertiesSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameCO);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodCatLab,productCategory);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeIDLab,productTypeID);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.userRolLab,userRole);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE,activityType);
        hmhDocumentDetailsSteps.verifyPropertyValue("Previous Unique ID:",PrevUnId);
        hmhDocumentDetailsSteps.verifyPropertyValue("Searchable:","No");
      //**** ALF-1975 New Metadata Field on COs, CCOs, and POs: “Differentiation Level" (Sprint 7.2.5)****
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DIFFERENTIATION_LEVEL,diffLevel);


        
    }
}
