//** ALF-2361  **  Trade: Create New Meta data Fields for Contributor** Sprint 7.3.5**
//** ALF-2362 ** Trade: Populate Contributor Image with TMM Meta data ** Sprint 7.3.5 **
//** ALF-2354 ** Trade: Contributor Meta data feed from TMM ** Sprint 7.3.5 **

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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG130_ContributorImageUploadInoneCMSUpdatesMetadataFromTMM.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG130_ContributorImageUploadInoneCMSUpdatesMetadataFromTMM  extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

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
    
    
    private String  siteTypeTest, fileName,assetsstatus,asset,assetstatus,assettype;
    private String  contributor_Id,contributor_fName,contributor_lName,contributor_fullName,contributor_fileName,contributor_photoCredit,contributor_photoURLHi,contributor_photoURLLo,contributor_relatedTitles;

    
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test REG130 Contributor Image Upload In oneCMS Updates Metadata From TMM")
    public void test_REG130_ContributorImageUploadInoneCMSUpdatesMetadataFromTMM() {
    	
    	//Create Asset
    	 documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
    	 hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         shareHeaderSteps.customWait(3);
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         shareHeaderSteps.customWait(3);
         
        // Edit Mandatory properties in the asset
         hmhEditPropertiesSteps.verifyAssetStatusDropDown(assetstatus, asset);
         hmhEditPropertiesSteps.assetstatusDropDown(assetsstatus);
         hmhEditPropertiesSteps.assetReleaseDateNotesTextBox(ConstantsHMH.TODAY_DATE);
         
        // Verify the drop downs for Asset type 
         hmhEditPropertiesSteps.verifyAssettypeDropDown(assettype);     
         
        // ** Test data validation depends upon the feeds from TMM so may vary, check on QA environment before run**
        //Verify All the Contributor Meta Data Fields which are the Feeds from TMM in oneCMS.
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_ID, contributor_Id);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_fName, contributor_fName);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_LName,contributor_lName);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_full_Name, contributor_fullName);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_file_Name, contributor_fileName);      
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_Photo_Credit, contributor_photoCredit);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_PhotoURL_Hi, contributor_photoURLHi);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_PhotoURL_Lo, contributor_photoURLLo);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CONTRIBUTOR_Related_Titles, contributor_relatedTitles);
                           

    }
}



	


