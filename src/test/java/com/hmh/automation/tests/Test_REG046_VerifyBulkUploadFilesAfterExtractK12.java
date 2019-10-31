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
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.ZIP.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG017a_BulkUploadAndExtract.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG046_VerifyBulkUploadFilesAfterExtractK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;

    String siteTypeTest, fileNameBU, item1, title1, language1, rights1, grade1, lifecycle1, 
    item2, title2, item3, item4, item5, item6, item7, outgoing, actionName, nameLabel, titleLabel, languageLabel, rightsLabel, gradeLabel;

    boolean isAssetFound = true;
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG046 - K12: Bulk Upload of 7 items (jpg, pdf, xls, docx, xml) then extract and verify Metadata for item1 in Both Consumer and K-12 Sites")
    public void test_REG046_VerifyBulkUploadFilesAfterxtractK12() {

                hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
                this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(item5);
                
                if (this.isAssetFound == false){
                        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileNameBU);
                        hmhDocumentLibrarySteps.assetFromListClickSub(fileNameBU);
                        hmhDocumentLibrarySteps.clickExtract();  
                        shareHeaderSteps.customWait(5);
                        siteHeaderSteps.clickOnDocumentLibraryButton();
                        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
                        hmhDocumentLibrarySteps.waitForZipToFinishExtract(item2); 
                        siteHeaderSteps.clickOnDocumentLibraryButton();
                        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
                        shareHeaderSteps.customWait(10);
                }
                shareHeaderSteps.customWait(6);
                
                hmhDocumentLibrarySteps.isAssetPresent(item1);
                hmhDocumentLibrarySteps.isAssetPresent(item2);
                hmhDocumentLibrarySteps.isAssetPresent(item3);
                hmhDocumentLibrarySteps.isAssetPresent(item4);
                hmhDocumentLibrarySteps.isAssetPresent(item5);
                //shareHeaderSteps.customWait(5);
        /*documentLibrarySteps.checkIfAssetIsPresent(item1);
     
        documentLibrarySteps.checkIfAssetIsPresent(item2);

        documentLibrarySteps.checkIfAssetIsPresent(item3);
       
        documentLibrarySteps.checkIfAssetIsPresent(item4); 
  
        documentLibrarySteps.checkIfAssetIsPresent(item5);
        */
   //   documentLibrarySteps.checkIfAssetIsPresent(item6);//XLS and XLSX files are not allowing 

        hmhDocumentLibrarySteps.assetFromListClickSub(item1);
        shareHeaderSteps.customWait(5);
      //  documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
       /* hmhDocumentDetailsSteps.verifyHMHPropertyValue(nameLabel, item1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(titleLabel, title1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(languageLabel, language1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(rightsLabel, rights1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(gradeLabel, grade1);*/
       // editPropertiesDocumentSteps.saveButtonClick();
      //  shareHeaderSteps.customWait(5);
                       
        
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, item1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, title1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LANGUAGE, language1);
        //hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NUMBERING_1, numbering1);
        
    
                       
    }
}
