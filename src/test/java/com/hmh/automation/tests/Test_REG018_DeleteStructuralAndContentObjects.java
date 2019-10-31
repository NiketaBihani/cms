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
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.StructuralAndContentObjects.DeleteStructuralOrContentObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG018_DeleteStructuralAndContentObjects.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG018_DeleteStructuralAndContentObjects extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
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
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHSetupSteps hmhSetupSteps;

    String programType, ProgramName, item3, title, grade, markets, actionName, deleteAction, message, siteTypeTest;
    private boolean isAssetFound=true;
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG018 - Delete Structural And Content Objects")
    public void test_REG018_DeleteStructuralAndContentObjects() {

	       documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + item3);
	       siteHeaderSteps.clickOnDocumentLibraryButton();
           hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
           documentLibrarySteps.createNewContent(programType);
           hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
           hmhDocumentLibrarySteps.createProgram(ProgramName, title, markets);
           hmhDocumentLibrarySteps.assetFromListClick(ProgramName);
           hmhDocumentLibrarySteps.navBarClick(ProgramName);
           hmhDocumentDetailsSteps.outgoingReferencesClick();
           hmhDocumentDetailsSteps.clickItemInReferencesPane(AssetsFolder);
           hmhDocumentDetailsSteps.selectReference(item3);
           siteHeaderSteps.clickOnDocumentLibraryButton();
           hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
           
           //**Deleting object with incoming reference (cannot be deleted)
           hmhDocumentLibrarySteps.assetFromListClickSub(item3);
           hmhDocumentDetailsSteps.deleteObject();
           //siteHeaderSteps.clickOnDocumentLibraryButton();
           //hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
           //hmhDocumentLibrarySteps.isAssetPresent(item3);
           hmhDocumentDetailsSteps.checkObjectCanNotBeDeleted(message);
           siteHeaderSteps.clickOnDocumentLibraryButton();
           hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
    
           //**Deleting structural object with outgoing reference (should be successfully deleted)
           hmhDocumentLibrarySteps.assetFromListClick(ProgramName);
           hmhDocumentLibrarySteps.navBarClick(ProgramName);
           shareHeaderSteps.customWait(3);
           documentDetailsSteps.deleteDocumentButtonDocumentActionsClick();
           shareHeaderSteps.customWait(3);
           siteHeaderSteps.clickOnDocumentLibraryButton();
           hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
           hmhDocumentLibrarySteps.assetFromListClickSub(item3);
           //**Now delete the Object (should be successfully deleted)
           hmhDocumentDetailsSteps.deleteObject();
           shareHeaderSteps.customWait(3);
           siteHeaderSteps.clickOnDocumentLibraryButton();
           shareHeaderSteps.customWait(5);
           hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
           hmhDocumentLibrarySteps.checkIfObjectIsNotPresent(item3);
        
    }

}
