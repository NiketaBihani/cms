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
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.ConstantsHMH;
//import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Application;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(Application.VersionControl.UploadNewVersion.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG038_CopyAndMoveAnObject.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG038_CopyAndMoveAnObject extends com.hmh.automation.tools.AbstractBaseSiteTest{

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
    private HMHShareHeaderSteps hmhShareHeaderSteps;
    @Steps
    private AdvancedSearchSteps advancedSearchSteps;
    @Steps
    private SearchResultsSteps searchResultsSteps;
    @Steps
    private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;

    String type, name, grade, year, level1Label, rights, language, ActivityType, folderType, folderName, aspectName, MoveAction, URL, fileName,
    siteTypeTest, folderName2;
    String elementCopytable="div[id*='copyMoveTo']>div>div>div>div:nth-child(2)>div>table>tbody>tr>td[id*='content']>span:nth-child(1)";
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG038 - Copy aaction and Move action in Document Details page")
    public void test_REG038_CopyAndMoveAnObject() {

    	
         hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
         documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
         siteHeaderSteps.clickOnDocumentLibraryButton();
         hmhDocumentLibrarySteps.createNewContent(folderType);
         documentLibrarySteps.createFolder(folderName2, "");
         siteHeaderSteps.clickOnDocumentLibraryButton();
         hmhDocumentLibrarySteps.assetFromListClick(folderName2);
         hmhDocumentLibrarySteps.navBarClick(folderName2);
         hmhDocumentDetailsSteps.manageAspectsButtonDocumentActionsClick();
         hmhDocumentLibrarySteps.selectAspectForAFolder(aspectName6);
         documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
         siteHeaderSteps.clickOnDocumentLibraryButton();
         hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
         hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         shareHeaderSteps.customWait(3);
         hmhDocumentLibrarySteps.clickMoveto();
         hmhShareHeaderSteps.waitForElement(elementCopytable, 200);
         shareHeaderSteps.customWait(2);
         documentLibrarySteps.selectPathToCopy(folderName2);
         shareHeaderSteps.customWait(3);
         documentLibrarySteps.confirmCopyButtonClick();
         shareHeaderSteps.customWait(3);
         hmhDocumentLibrarySteps.refresh();
         siteHeaderSteps.clickOnDocumentLibraryButton();
         hmhDocumentLibrarySteps.assetFromListClick(folderName2);
         hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         siteHeaderSteps.clickOnDocumentLibraryButton();
       //  hmhDocumentDetailsSteps.checkDerivedFrom(fileName);
         
    }
}
