//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **
package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.Publishing.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG110_SetDeliveryLocationOnPlaceholderFiles.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG124_VerifyNewHelpMenuOption_InOneCMS  extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private LoginSteps loginSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;

	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	
	String siteTypeTest;
	String onecmsreleasenotes ="OneCMS Release Notes"; 
	String releasenotes = "Release Notes";
	
	
	@Override
	public void setSiteType() {
		
		siteType = siteTypeTest;
	}
	
	@Test
	@Title("Test REG124 Verify New Help Menu Option In OneCMS")
	public void test_REG124_VerifyNewHelpMenuOption_InOneCMS() {
		
		// Click on New Help Menu Release option and verify
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
		hmhShareHeaderSteps.clickOnHelpMenu();
		hmhShareHeaderSteps.clickOnReleaseNotes();
		hmhDocumentLibrarySteps.assetFromListClick(onecmsreleasenotes);
		//hmhShareHeaderSteps.verifyReleaseNotes(releasenotes);
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		
		//Click on New Help Menu Knowledge Base option and verify
		hmhShareHeaderSteps.clickOnHelpMenu();
		hmhShareHeaderSteps.clickOnKnowledgeBase();
		
					
}



}
