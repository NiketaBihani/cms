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
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.VersionControl.UploadNewVersion.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG033_UploadNewVersion.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG033_UploadNewVersion extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
   	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    
    String fileName, menuOption, itemName, versionType, comment, versionNumber, selectAction, siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG033 - Upload New Version in Document Details Page")
    public void test_REG033_UploadNewVersion() {

        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + itemName);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.checkIfAssetIsPresent(fileName);
        documentLibrarySteps.checkTheVersionOfTheFile(fileName, versionNumber);
    }
}
