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
public class Test_REG064a_K12ImportZipFileCCO extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    @Title("Test_REG064 - K12: Import Zip File as CCO")
    public void test_REG064_VerifyImportZipFileforCCOK12() {

    	hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
    	this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(item5);
    	
    	if (this.isAssetFound == false){
	        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileNameBU);
	        hmhDocumentLibrarySteps.assetFromListClickSub(fileNameBU);
	        hmhDocumentLibrarySteps.clickExtractCCO();
	      
	        shareHeaderSteps.customWait(5);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
	        this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(fileNameBU);
	        shareHeaderSteps.customWait(10);
	      
	        
    	}
        
    }
}
