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
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.ZIP.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG097_Enhance_COM_Import.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG097_Enhance_COM_Import extends com.hmh.automation.tools.AbstractBaseSiteTestNew{

	
	@Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHSetupSteps hmhSetupSteps;
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
	private HMHSequenceViewSteps hmhSequenceViewSteps;
    
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;

    String siteTypeTest, PO, SB, CCO, CO, Asset, objectName, fileNameCOM ="automationcomimport.zip"  ;

    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    
    @Test
    @Title("Test_REG097_Enhance_COM_Import")
    public void test_REG097_Enhance_COM_Import() {

        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileNameCOM);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileNameCOM);
        hmhDocumentLibrarySteps.customWait(10);    
        hmhDocumentLibrarySteps.validComStructure(); 
   
      
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileNameCOM);
        hmhDocumentLibrarySteps.customWait(5);
        hmhDocumentLibrarySteps.importComStruc();
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.expandTreeInSequenceView();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(PO);
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(SB);
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(CCO);
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(CO);
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(Asset);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(CCO);
        hmhDocumentLibrarySteps.navBarClick(CCO);
        hmhDocumentLibrarySteps.customWait(3);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhDocumentLibrarySteps.customWait(3);
        hmhEditPropertiesSteps.editPrevUniqId("RQ9743");
        hmhEditPropertiesSteps.searchCheckBox();
        hmhEditPropertiesSteps.saveButtonClick(); 
        siteHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(CO);
        hmhDocumentLibrarySteps.customWait(3);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhDocumentLibrarySteps.customWait(3);
        hmhEditPropertiesSteps.editPrevUniqId("RQ9743");
        hmhEditPropertiesSteps.searchCheckBox();
        hmhEditPropertiesSteps.saveButtonClick(); 
        siteHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        
    }

}
