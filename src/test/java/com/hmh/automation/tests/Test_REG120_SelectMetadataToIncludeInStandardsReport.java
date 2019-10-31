//** ALF-1086 ** Select Metadata to Include in Standards Report ** Sprint 7.3.3 **
package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHStandardsHierarchySteps;
import com.hmh.automation.steps.HMHStandardsSearchSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG120_SelectMetadataToIncludeInStandardsReport.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG120_SelectMetadataToIncludeInStandardsReport extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
	

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
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;

	String  authorityName,importStdName, docName, standard, standardFolder, grade, sourceGrade, targetGrade, sourceStandard, targetStandard, siteTypeTest,standardreport;
		
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Standards")
	@Title("Test REG120 Select Metadata To Include In Standards Report")
	public void test_REG120_SelectMetadataToIncludeInStandardsReport() {
		
		// Click on Import standards 
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnImportStandards(); 
	
		// Import a standard
		hmhStandardsSearchSteps.importStandardsToOneCMS(importStdName);		
		hmhShareHeaderSteps.customWait(3);
		
		// Verify the imported standard in search standard
		hmhStandardsSearchSteps.verifyImportStandardPopupIsPresent("Import Standard");
		hmhShareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnSearchStandards();
		hmhStandardsSearchSteps.clickOnSearch();
		hmhStandardsSearchSteps.waitUntilStandardIsImported(docName);
		hmhStandardsSearchSteps.keyWordSearch(docName);
		hmhStandardsSearchSteps.clickOnSearch();
		hmhStandardsSearchSteps.verifyStandardIsPresentInSearchList(docName);
		
		// Click on Excel Report button for the searched standard
		hmhStandardsSearchSteps.clickOnExportStandards(authorityName);
		
		// Check the option in AB & HMH Metadata and Generate Standard Report
		hmhStandardsSearchSteps.selectMetadataOnExportStandards();
		hmhStandardsSearchSteps.generateStandardReport();
	
		// Navigate to My Files to verify the generated report
		hmhShareHeaderSteps.clickOnMyFiles();
    	shareHeaderSteps.customWait(5);
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(standardreport);
    	//hmhDocumentLibrarySteps.assetFromListClick(authorityName);
    	
    

	}

}
