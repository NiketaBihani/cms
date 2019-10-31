//** ALF-2203 **  Create Asset Renditions upon update ** Sprint 7.3.3 **

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
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Asset.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG115_CreateAssetRenditionsUponUpdate.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG115_CreateAssetRenditionsUponUpdate  extends com.hmh.automation.tools.AbstractBaseSiteTestAssetManagement {

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
    

    private String  siteTypeTest, fileName,assetsstatus,version,rendition,zip,versionType,comment,newFileName,updatedVersion;
    
   
    @Override
    public void setSiteType() {
    	siteType = this.siteTypeTest;
    }

    @Test
    @Title("Test_REG115 Create Asset Renditions Upon Update")
    public void test_REG115_CreateAssetRenditionsUponUpdate() {
    	
    	//Create Asset
    	 documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
    	 hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
         shareHeaderSteps.customWait(3);
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         shareHeaderSteps.customWait(3);
         hmhEditPropertiesSteps.assetstatusDropDown(assetsstatus);
         hmhEditPropertiesSteps.assetReleaseDateNotesTextBox(ConstantsHMH.TODAY_DATE);
         editPropertiesDocumentSteps.saveButtonClick();
         shareHeaderSteps.customWait(10);
         
         //Perform Generate Trade Renditions action
         hmhEditPropertiesSteps.clickOnGenerateTradeRenditions();
         shareHeaderSteps.customWait(3);
         siteHeaderSteps.clickOnDocumentLibraryButton();
         shareHeaderSteps.customWait(8);
         hmhDocumentLibrarySteps.assetFromListClickSubCO(rendition);
         hmhDocumentLibrarySteps.assetFromListClickSubCO(zip);
         shareHeaderSteps.customWait(3);
         
         //Upload the image again to verify the document version
         documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
         documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
         documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
         shareHeaderSteps.customWait(8);
         
         //Verify the rendition version
          hmhDocumentLibrarySteps.verifyRenditionsVersion(version);
           
         //Navigate to uploaded image
          siteHeaderSteps.customWait(5);
  		  siteHeaderSteps.clickOnDocumentLibraryButton();
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(fileName);
  		  shareHeaderSteps.customWait(3);

  		  //Upload the different image content again
  		  documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
  		  documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + newFileName);
  		  documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
  		  shareHeaderSteps.customWait(8);
  		 
  		 //Verify whether new image is updated in rendition
  		  siteHeaderSteps.clickOnDocumentLibraryButton();
  		  shareHeaderSteps.customWait(5);
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(rendition);
  		  hmhDocumentLibrarySteps.assetFromListClickSubCO(zip);
  		  shareHeaderSteps.customWait(3);

  		 //Verify the rendition version
          hmhDocumentLibrarySteps.verifyRenditionsVersion(updatedVersion);
          System.out.println("Script completed..");
           
    }
}



	


