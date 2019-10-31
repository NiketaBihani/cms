package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.LearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG072_NewMetadataFieldsContentObjectK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG072_NewMetadataFieldsContentObjectK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;


    private String typeCO, objectNameCO, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest,
    productCategory, studentFacing, activityType, userRole, productTypeID, productType,hmhIDtext,hmhIDHelpText,assessmentbankIDtext, description="automation", publisher ="DHX", fileName="ctsQA.txt"; 
    int waitForSearchResultsSeconds=10;
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_Test_REG072 - Verify new Metadata Fields HMH ID and Assessment Bank ID for COs in K12")
    public void test_REG072_NewMetadataFieldsContentObjectK12() {

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
        hmhEditPropertiesSteps.hmhID(hmhIDtext);
        hmhEditPropertiesSteps.hmhIDHelpIcon(hmhIDHelpText);
        hmhEditPropertiesSteps.assessmentbankID(assessmentbankIDtext);
        hmhEditPropertiesSteps.userRoleDropDown(userRole);
        hmhEditPropertiesSteps.activityTypeDropDown(activityType);
        hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
        hmhEditPropertiesSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameCO);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodCatLab,productCategory);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab,productType);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeIDLab,productTypeID);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.userRolLab,userRole);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE,activityType);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.HMH_ID,hmhIDtext);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ASSESSMENT_BANK_ID,assessmentbankIDtext);
        shareHeaderSteps.customWait(5);
        
        //***Quick Search with HMH ID and Assessment Bank ID
   		documentLibrarySteps.enterTextInSearchBox(hmhIDtext);
   		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
   		shareHeaderSteps.customWait(5);
   		documentLibrarySteps.enterTextInSearchBox(assessmentbankIDtext);
   		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
   		shareHeaderSteps.customWait(5);
   		
        // **** advance search for K12 Product type Content Object with HMH ID and Assessment Bank ID	
     	shareHeaderSteps.advancedSearchButtonClick();
     	shareHeaderSteps.customWait(3);
     	hmhAdvancedSearchSteps.selectLookFor(typeCO);
     //	advancedSearchSteps.selectLookForPage(typeCO);
     	shareHeaderSteps.customWait(10);
    // 	advancedSearchSteps.selectLookForPage("Content");
     	hmhAdvancedSearchSteps.selectLookFor("Content");
     	hmhAdvancedSearchSteps.selectLookFor(typeCO);
     	//advancedSearchSteps.selectLookForPage(typeCO);
     	hmhAdvancedSearchSteps.clickPlusToExpandK12();
     	hmhEditPropertiesSteps.hmhID(hmhIDtext);
     	hmhEditPropertiesSteps.assessmentbankID(assessmentbankIDtext);
     	advancedSearchSteps.clickSearchButton();
     	shareHeaderSteps.customWait(5);
     	//	searchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
     	hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
     	hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typeCO);

        
    }
}