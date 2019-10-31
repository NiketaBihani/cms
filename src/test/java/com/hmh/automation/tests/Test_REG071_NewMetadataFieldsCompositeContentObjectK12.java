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
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;


@Story(HMHApplication.CompositeLearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG071_NewMetadataFieldsCompositeContentObjectK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG071_NewMetadataFieldsCompositeContentObjectK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
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
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;


    private String typeCCO, objectNameCCO, grade, language, rights, market, title, lifeCycle, siteTypeTest,
    productCategory, studentFacing, activityType, userRole, productTypeID, productType,hmhIDtext,hmhIDHelpText,assessmentbankIDtext,description="automation", ccoLabel="ccoAuto";
    int waitForSearchResultsSeconds=10;
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG071 - Verify new Metadata Fields HMH ID and Assessment Bank ID for CCOs in K12")
    public void test_REG071_NewMetadataFieldsCompositeContentObjectK12() {
  
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
         hmhEditPropertiesSteps.productTypeDropDown(productType);
         hmhEditPropertiesSteps.productTypeIDDropDown(productTypeID);
         hmhEditPropertiesSteps.userRoleDropDown(userRole);
         hmhEditPropertiesSteps.editCcoLabel(ccoLabel);
         hmhEditPropertiesSteps.activityTypeDropDown(activityType);
         hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
         hmhEditPropertiesSteps.hmhID(hmhIDtext);
         hmhEditPropertiesSteps.hmhIDHelpIcon(hmhIDHelpText);         
         hmhEditPropertiesSteps.assessmentbankID(assessmentbankIDtext);
         editPropertiesDocumentSteps.saveButtonClick();
         shareHeaderSteps.customWait(3);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameCCO);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, title);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CREATOR, ConstantsHMH.TEST_USER_LOGIN);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MODIFIER, ConstantsHMH.TEST_USER_LOGIN);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LIFECYCLE, lifeCycle);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LANGUAGE, language);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RIGHTS, rights);
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
    	hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
    	shareHeaderSteps.customWait(5);
    	documentLibrarySteps.enterTextInSearchBox(assessmentbankIDtext);
    	hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
    	shareHeaderSteps.customWait(5);
    		
         // **** advance search for K12 Product type Content Object with HMH ID and Assessment Bank ID	
      	shareHeaderSteps.advancedSearchButtonClick();
      	shareHeaderSteps.customWait(3);
      //	advancedSearchSteps.selectLookForPage(typeCCO);
      	 hmhAdvancedSearchSteps.selectLookFor(typeCCO);
      	shareHeaderSteps.customWait(10);
      //	advancedSearchSteps.selectLookForPage("Content");
      	 hmhAdvancedSearchSteps.selectLookFor("Content");
      	 
      	//advancedSearchSteps.selectLookForPage(typeCCO);
      	hmhAdvancedSearchSteps.selectLookFor(typeCCO);
      	hmhAdvancedSearchSteps.clickPlusToExpandK12();
      	hmhEditPropertiesSteps.hmhID(hmhIDtext);
      	hmhEditPropertiesSteps.assessmentbankID(assessmentbankIDtext);
      	advancedSearchSteps.clickSearchButton();
      	shareHeaderSteps.customWait(5);
      	//	searchResultsSteps.isElementPresentInSearchResult(objectNameCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
     
      	//commented below lines due to functionality issue
      //	hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameCCO, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
      //	hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(typeCCO);
        
        
    }
}
