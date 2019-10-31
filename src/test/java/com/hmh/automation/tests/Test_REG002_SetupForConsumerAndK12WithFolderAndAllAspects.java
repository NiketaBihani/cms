package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Setup.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG002_SetupForConsumerAndK12WithFolderAndAllAspects.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG002_SetupForConsumerAndK12WithFolderAndAllAspects extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Managed(uniqueSession = false)
	
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

    String siteTypeTest;
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    
    @Test
    @Title("Test_REG002 - Create Consumer & K12Sites With Folder and Add All Aspects")
    public void test_REG002_SetupForConsumerAndK12WithFolderAndAllAspects() {
    	
    		documentLibrarySteps.checkIfAssetIsPresent(AssetsFolder);
    		documentLibrarySteps.checkIfAssetIsPresent(ContentObjectsFolder);
    		documentLibrarySteps.checkIfAssetIsPresent(LearningBundlesFolder);
    		documentLibrarySteps.checkIfAssetIsPresent(SequenceBundlesFolder);
    		documentLibrarySteps.checkIfAssetIsPresent(ProductObjectsFolder);
    		documentLibrarySteps.checkIfAssetIsPresent(ProductSetsFolder);
    		documentLibrarySteps.checkIfAssetIsPresent(ProgramsFolder);
	        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	        hmhDocumentLibrarySteps.navBarClick(AssetsFolder);
	        hmhDocumentDetailsSteps.manageAspectsButtonDocumentActionsClick();
	        hmhDocumentLibrarySteps.verifyAspectIsSet("Asset Bucket");
	        hmhDocumentLibrarySteps.cancelManageAspectButtonClick();
	
	        
    }

}
