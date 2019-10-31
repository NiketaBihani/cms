//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **

package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.Constants;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement;

@Story(HMHApplication.Asset.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG118_AddAssetsToCollections_And_VerifyInGeneratedPDF.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG118_AddAssetsToCollections_And_VerifyInGeneratedPDF  extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

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
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
    

    
    private String  siteTypeTest, fileName,assetsstatus,fileName1;
    String collectionName = "AutomationCollectionBag" +RandomStringUtils.randomNumeric(1);
    
    
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test -REG118 Add Assets To Collections and Verify In Generated PDF")
    public void test_REG118_AddAssetsToCollections_And_VerifyInGeneratedPDF() {
    	
    	//Create Asset
    	 documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
    	 hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         shareHeaderSteps.customWait(3);
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         shareHeaderSteps.customWait(3);
         hmhEditPropertiesSteps.assetstatusDropDown(assetsstatus);
         hmhEditPropertiesSteps.assetReleaseDateNotesTextBox(ConstantsHMH.TODAY_DATE);
         editPropertiesDocumentSteps.saveButtonClick();
         shareHeaderSteps.customWait(5);
         
         // Create new Collection and Add the asset to it
         hmhDocumentDetailsSteps.clickOnAddNewCollectionAction(collectionName);
         
         siteHeaderSteps.clickOnDocumentLibraryButton();
         shareHeaderSteps.customWait(3);
         
         // Create another asset
         documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
    	 hmhDocumentLibrarySteps.assetFromListClickSub(fileName1);
         shareHeaderSteps.customWait(3);
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         shareHeaderSteps.customWait(3);
         hmhEditPropertiesSteps.assetstatusDropDown(assetsstatus);
         hmhEditPropertiesSteps.assetReleaseDateNotesTextBox(ConstantsHMH.TODAY_DATE);
         editPropertiesDocumentSteps.saveButtonClick();
         shareHeaderSteps.customWait(5);
         
         // Add the asset to the collection created
         hmhDocumentDetailsSteps.clickOnAddExistingCollectionAction(collectionName);
         
         // Navigate to My Collections and Select the collection created
         hmhShareHeaderSteps.clickOnMyFiles();
	     shareHeaderSteps.customWait(5);
	     hmhDocumentDetailsSteps.clickOnMyCollection();
	     hmhDocumentLibrarySteps.assetFromListClickSub(collectionName);
	     hmhDocumentLibrarySteps.navBarClick(collectionName);
	     shareHeaderSteps.customWait(3);
	           
         // Generate PDF and Verify the assets added to the collection
	     hmhDocumentDetailsSteps.clickOnGeneratePDF();
	     shareHeaderSteps.customWait(5);
	     hmhShareHeaderSteps.clickOnMyFiles();
	     shareHeaderSteps.customWait(10);
	     
	     // Verify the PDF generated file
	     hmhDocumentDetailsSteps.clickOnPDFReportsFolder();
	     shareHeaderSteps.customWait(5);
	     hmhDocumentLibrarySteps.assetFromListClickSub(collectionName);
	     shareHeaderSteps.customWait(5);
	     hmhDocumentDetailsSteps.verifyGeneratedPDFReport(fileName, fileName1);
	     System.out.println("Script Completed..");

    }
}



	


