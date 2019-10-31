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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG017b_ConsumerBulkUploadAndExtract.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG017b_ConsumerBulkUploadAndExtract extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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


    String siteTypeTest, fileNameBU, item1, title1, language1, rights1, grade1, lifecycle1, 
    item2, title2, item3, item4, item5, item6, item7, outgoing, actionName, nameLabel, titleLabel, languageLabel, rightsLabel, gradeLabel;

    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG017b - Consumer Bulk Upload of 7 items (jpg, pdf, xls, docx, xml) then extract in Consumer Site")
    public void test_REG017b_BulkUploadAndExtractConsumer() {

        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileNameBU);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileNameBU);
        hmhDocumentLibrarySteps.clickExtract();  
/*        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.waitForZipToFinishExtract(item5); 
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(folderName);
        
        shareHeaderSteps.customWait(10);
        documentLibrarySteps.checkIfAssetIsPresent(item1);
        documentLibrarySteps.checkIfAssetIsPresent(item2);
        documentLibrarySteps.checkIfAssetIsPresent(item3);
        documentLibrarySteps.checkIfAssetIsPresent(item4);  
        documentLibrarySteps.checkIfAssetIsPresent(item5);
   //   documentLibrarySteps.checkIfAssetIsPresent(item6);//XLS and XLSX files are not allowing 

        hmhDocumentLibrarySteps.assetFromListClick(item1);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(nameLabel, item1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(titleLabel, title1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(languageLabel, language1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(rightsLabel, rights1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(gradeLabel, grade1);*/
        


    
	       
    }
}
