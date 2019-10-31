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
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

	@Story(HMHApplication.Program.class)
	@RunWith(SerenityParameterizedRunner.class)
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG003_CreateProgramK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class Test_REG003_CreateProgramK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

		@Managed(uniqueSession = true) 
		
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
	    private ShareHeaderSteps shareHeaderSteps;
	    @Steps
	    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
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


	    String typePG, objectNamePG, title, grade, markets, siteTypeTest;
	    
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }

	    @Test
	    @Title("Test_REG003 - Create a Program in K12 site and Verify Metadata Properties")
	    public void test_REG003_CreateProgramK12() {

	        hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
	        documentLibrarySteps.createNewContent(typePG);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createProgram(objectNamePG, title, markets);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
	        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectNamePG);
//	        // verify Duplicate Object message     
	        documentLibrarySteps.createNewContent(typePG);
	        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	        hmhDocumentLibrarySteps.createProgram(objectNamePG, title, markets);
	        hmhDocumentLibrarySteps.duplicataAssetNotCreated(objectNamePG);
	        hmhDocumentLibrarySteps.assetFromListClick(objectNamePG);
	        hmhDocumentLibrarySteps.navBarClick(objectNamePG);
	        // Meta data properties validation
	        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNamePG);
	        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.DISPLAY_TITLE, title);
	        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MARKETS, markets);
	        
	        
	    }
	    

}


