//****ALF-1581 Return to Search Results Screen from Standards Hierarchy (Sprint 7.3.1)*****
package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHStandardsHierarchySteps;
import com.hmh.automation.steps.HMHStandardsSearchSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG103_PersistSearchStandardsResults_InOneCMS.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG103_PersistSearchStandardsResults_InOneCMS extends com.hmh.automation.tools.AbstractBaseSiteTestHIP {
	

	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private HMHStandardsSearchSteps hmhStandardsSearchSteps;
	@Steps
	private HMHStandardsHierarchySteps hmhStandardsHierarchySteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	

	String  importStdName, docName, standard, standardFolder, grade, sourceGrade, targetGrade, sourceStandard, targetStandard, siteTypeTest;
	int waitForSearchResultsSeconds;
	
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Standards")
	@Title("Test_REG103 - Persist Search Standards Results In OneCMS")
	public void test_REG103_PersistSearchStandardsResults_InOneCMS() {
		
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnImportStandards();
		hmhStandardsSearchSteps.importStandardsToOneCMS(importStdName);		
		hmhShareHeaderSteps.customWait(3);
		hmhStandardsSearchSteps.verifyImportStandardPopupIsPresent("Import Standard");
		hmhShareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnSearchStandards();
		hmhStandardsSearchSteps.clickOnSearch();
		hmhStandardsSearchSteps.waitUntilStandardIsImported(docName);
		hmhStandardsSearchSteps.keyWordSearch(docName);
		hmhStandardsSearchSteps.clickOnSearch();
		hmhStandardsSearchSteps.verifyStandardIsPresentInSearchList(docName);
		hmhStandardsSearchSteps.selectShowStandard();
		shareHeaderSteps.customWait(5);
		hmhSearchResultsSteps.returnToSearchButton();
		shareHeaderSteps.customWait(15);
		hmhSearchResultsSteps.verifyElementPresentInSearchResults(docName, waitForSearchResultsSeconds);
		shareHeaderSteps.customWait(3);
        System.out.println("Script completed");
	}

}

