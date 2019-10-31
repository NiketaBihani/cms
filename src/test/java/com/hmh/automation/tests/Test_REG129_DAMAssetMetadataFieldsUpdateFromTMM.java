//** ALF-2332  **  Trade: Add Primary indicator and Short Title to TMM feed ** Sprint 7.3.5**
//** ALF-2335 ** Trade: Create new asset types for Author Questionnaire, Excerpt, Launch Script, Text, and Selling Sample ** Sprint 7.3.5

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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG129_DAMAssetMetadataFieldsUpdateFromTMM.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG129_DAMAssetMetadataFieldsUpdateFromTMM  extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

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
    
    
    private String  siteTypeTest, fileName,assetsstatus,asset,assetstatus,assettype,assettype1,assettype2,assettype3;
    private String  shortTitle,bookTitle,bisacStatus,imprintGroup,imprint,primaryIndicator,restrictedElo;
    
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test REG129 DAM Asset Metadata Fields Primary Key indicator & Short Title Update From TMM")
    public void test_REG129_DAMAssetMetadataFieldsUpdateFromTMM() {
    	
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
         hmhEditPropertiesSteps.verifyAssettypeDropDown(assettype1);
         hmhEditPropertiesSteps.verifyAssettypeDropDown(assettype2);
         hmhEditPropertiesSteps.verifyAssettypeDropDown(assettype3);
         
        // ** Test data validation depends upon the feeds from TMM so may vary, check on QA before run**
        //Verify the Primary indicator value and Short Title property on document details page
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.SHORT_TITLE, shortTitle);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.BOOK_TITLE, bookTitle);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.BISAC_STATUS,bisacStatus);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.IMPRINT_GROUP, imprintGroup);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.IMPRINT, imprint);      
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.PRIMARY_INDICATOR, primaryIndicator);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RESTRICTED_ELO, restrictedElo);
         
                           
       

    }
}



	


