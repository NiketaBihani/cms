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
import com.hmh.automation.steps.HMHSiteMembersSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteGroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


	@Story(HMHApplication.Program.class)
	@RunWith(SerenityParameterizedRunner.class)
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG003_CreateProgramK12_SiteMembers.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class Test_REG003_CreateProgramK13_SiteMembers extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

		@Managed(uniqueSession = true) 
		
	    @Steps
	    private SiteHeaderSteps siteHeaderSteps;
		@Steps
	    private SiteGroupsSteps siteGroupsSteps;
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
	    @Steps
	    private HMHSiteMembersSteps hmhSiteMembersSteps;
	    //
	    @Steps
		private HMHSiteFinderSteps hmhSiteFinderSteps;
	    @Steps
		private AdminToolsNavigationSteps adminToolsNavigationSteps;



	    String typePG, objectNamePG, title, grade, markets, siteTypeTest;
	    
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }

	    @Test
	    @Title("Test_REG003 - Create a Program in K12 site and Verify Metadata Properties")
	    public void test_REG003_CreateProgramK13() {

	      
	        siteHeaderSteps.clickOnMembersButton();
	        hmhSiteMembersSteps.clickGroups();
	        hmhSiteMembersSteps.verifyGroupIsPresent();
	        
	         
	        
	    }
	    

}
