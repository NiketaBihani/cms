//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **

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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG121_AssetUploadToRenditionsFolder_Verify_WithAddingManageAspect.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG121_AssetUploadToRenditionsFolder_Verify_WithAddingManageAspect  extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

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
    

    private String  siteTypeTest,updatedzip, fileName,assetsstatus,version,rendition,zip,versionType,comment,newFileName;
    String updatedVersion= "1.0";
   
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test_REG121 Asset Upload To Renditions Folder & Verify With Adding Manage Aspect to Renditions folder")
    public void test_REG121_AssetUploadToRenditionsFolder_Verify_WithAddingManageAspect() {
    	
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
         
         //Perform Generate Trade Renditions action
         hmhEditPropertiesSteps.clickOnGenerateTradeRenditions();
         shareHeaderSteps.customWait(3);
         siteHeaderSteps.clickOnDocumentLibraryButton();
         shareHeaderSteps.customWait(5);
         
        // Verify When No time stamp aspect is present on the Renditions folder
         hmhDocumentLibrarySteps.assetFromListClickSubCO(rendition);
         hmhDocumentLibrarySteps.assetFromListClickSubCO(zip);
         shareHeaderSteps.customWait(3);
        // Verify the rendition version
         hmhDocumentLibrarySteps.verifyRenditionsVersion(version);
         siteHeaderSteps.clickOnDocumentLibraryButton();
         shareHeaderSteps.customWait(8);
         
         // Create a time stamp Aspect in Manage aspect for Renditions folder   
         hmhEditPropertiesSteps.clickViewDetailsOnRenditionsFolder();
         shareHeaderSteps.customWait(5);
         hmhDocumentDetailsSteps.clickManageAspectAction();
         hmhDocumentDetailsSteps.selectTimestampAspectOnManageAspect();
         shareHeaderSteps.customWait(3);
         siteHeaderSteps.clickOnDocumentLibraryButton();
         shareHeaderSteps.customWait(5);
         
         // Upload another asset
         documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + newFileName);
         shareHeaderSteps.customWait(5);
         
  		 // Navigate to Renditions Folder and verify the asset uploaded is using the time stamp created rule
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(rendition);
  		  shareHeaderSteps.customWait(3);
  		  String a[] = hmhDocumentDetailsSteps.verifyAspectOnAssetFolder();	
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(a[0]);
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(a[1]);
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(a[2]);
  		  
  		 // Verify the rendition version
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(updatedzip);
          hmhDocumentLibrarySteps.verifyRenditionsVersion(updatedVersion);
          System.out.println("Script completed..");
           
    }
}



	


