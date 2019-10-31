//** ALF-1247  **  Generate Renditions of Cover Images Based on Asset Status ** Sprint 7.1.1**

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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG102_GenerateRenditionsofCoverImagesBasedonAssetStatus.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG102_GenerateRenditionsofCoverImagesBasedonAssetStatus  extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

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
    

    
    private String  siteTypeTest, fileName,assetsstatus,version,rendition,zip,versionType,comment;
    String assetstatus = "Approved for Internal Use Only", asset= "Approved for Internal and Catalog Use";
    String restrictedElo= "Restricted Elo Release:";
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test- 102 Generate Renditions of Cover Images Based on Asset Status")
    public void test_REG102_GenerateRenditionsofCoverImagesBasedonAssetStatus() {
    	//Create Asset
    	 documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
    	 hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         shareHeaderSteps.customWait(3);
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         shareHeaderSteps.customWait(3);
         
        //** ALF-2277 **  Trade: Modify existing Asset Status Dropdown values ** Sprint 7.3.4 **
         hmhEditPropertiesSteps.verifyAssetStatusDropDown(assetstatus, asset);
         hmhEditPropertiesSteps.assetstatusDropDown(assetsstatus);
         hmhEditPropertiesSteps.assetReleaseDateNotesTextBox(ConstantsHMH.TODAY_DATE);
         
        //** ALF-2276 **  Trade: Add  "Restricted Elo Release" field to Title Metadata ** Sprint 7.3.4 **
         hmhEditPropertiesSteps.verifyRestrictedEloReleaseField(restrictedElo);
         editPropertiesDocumentSteps.saveButtonClick();
         shareHeaderSteps.customWait(8);
         
        //Verify the property on document details page
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RESTRICTED_ELO, "(None)");
         
        //Perform Generate Trade Renditions action
         hmhEditPropertiesSteps.clickOnGenerateTradeRenditions();
         shareHeaderSteps.customWait(3);
         siteHeaderSteps.clickOnDocumentLibraryButton();
         shareHeaderSteps.customWait(8);
         hmhDocumentLibrarySteps.assetFromListClickSubCO(rendition);
         hmhDocumentLibrarySteps.assetFromListClickSubCO(zip);
         shareHeaderSteps.customWait(3);
         
         //Upload the image again to verify the document version
         documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
         documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
         documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
         shareHeaderSteps.customWait(8);
         
         //Verify the rendition version
         hmhDocumentLibrarySteps.verifyRenditionsVersion(version);
                           
       

    }
}



	


