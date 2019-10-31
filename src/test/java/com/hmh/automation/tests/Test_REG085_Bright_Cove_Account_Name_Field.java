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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG085_Bright_Cove_Account_Name_Field.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG085_Bright_Cove_Account_Name_Field extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	    
	   
	    
	    
	    private String typeAsset, objectNameAsset, rights, grade, title, lifecycle, siteTypeTest, brtcoveacnm, locid, covid;
	   
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }

	    @Test
	    @Title("Test_REG085_Bright_Cove_Account_Name_Field")
	    public void Test_REG085_Bright_Cove_Account_Name_Field() {
	    	 
	    	 boolean found=false;
	    	 hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	    	 documentLibrarySteps.createNewContent(typeAsset);
	         hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	         hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
	         hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
	         shareHeaderSteps.customWait(3);

	         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
	         found=hmhEditPropertiesSteps.BrightcoveAccountName(brtcoveacnm, locid, covid);	
	         hmhEditPropertiesSteps.saveButtonClick();
	         shareHeaderSteps.customWait(3);
	         if(found)
	         {
	          hmhEditPropertiesSteps.ValidateBrightcoveAccountDetails(brtcoveacnm, locid, covid);
	         }
	         else
	         {
	        	 System.out.println("boolean value is false");
	         }
	
}
}
