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
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.ObjectOperations.EditProperties.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG037_EditPropertiesForMoreThanOneObject.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG037_EditPropertiesForMoreThanOneObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private AdvancedSearchSteps advancedSearchSteps;
    @Steps
    private SearchResultsSteps searchResultsSteps;
    @Steps
    private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;

    String type, programName, grade, title, description, actionName, componentName, rights, language,
            lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, siteTypeTest, folderName, folderType, folderName2, componentType, aspectName="Asset Bucket";

   
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG037 - Edit properties for more than one object")
    public void test_REG037_EditPropertiesForMoreThanOneObject() {
    	
    
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.createNewContent(componentType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentConsumerSite(componentName, title, rights, grade, lifecycle, resourceType);
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName2, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.selectAllItems();
       // documentLibrarySteps.selectedItemsClick();;
        hmhDocumentLibrarySteps.selectAnItemFromSelectedItemsDropDown(actionName);
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editTitle(title);
        editPropertiesDocumentSteps.saveButtonClick();
        hmhEditPropertiesSteps.confirmMultipleEdit();
        
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(componentName);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, title);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.navBarClick(folderName2);
		shareHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, title);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
    }
}
