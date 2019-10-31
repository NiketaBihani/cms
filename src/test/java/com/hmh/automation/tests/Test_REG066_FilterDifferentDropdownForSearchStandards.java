package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHStandardsHierarchySteps;
import com.hmh.automation.steps.HMHStandardsSearchSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG055_ModifyStructureOrHierarchyOfStandardsImportedToOneCMSDragAndDrop.csv", separator = ConstantsHMH.CSV_SEPARATOR)
//public class Test_REG055_ImportAndSearchStandardInOneCMS extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
public class Test_REG066_FilterDifferentDropdownForSearchStandards extends com.hmh.automation.tools.AbstractBaseSiteTestHIP {
	

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
	

	String  importStdName, docName, standard, standardFolder, grade, sourceGrade, targetGrade, sourceStandard, targetStandard, siteTypeTest;
	String selectCountryVal = "United States", selectAuthorityVal = "Alaska";
	String selectDocumentFileVal = "Early Learning Guidelines",selectSubYearVal = "Approaches to Learning (2006)";
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Standards")
	@Title("Test_REG066 - Filter By different dropdowns for Search Standards In OneCMS")
	public void test_REG066_FilterDifferentDropdownForSearchStandardsInOneCMS() {
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnSearchStandards();
		//hmhStandardsSearchSteps.clickOnSearch();
		hmhShareHeaderSteps.customWait(2);
		hmhStandardsSearchSteps.waitUntilStandardIsImported(docName);
		
		hmhStandardsSearchSteps.selectCountryInStandards(selectCountryVal);
		hmhShareHeaderSteps.customWait(2);
		hmhStandardsSearchSteps.selectAuthorityInStandards(selectAuthorityVal);
		hmhShareHeaderSteps.customWait(2);
		hmhStandardsSearchSteps.selectDocumentFileInStandards(selectDocumentFileVal);
		hmhShareHeaderSteps.customWait(2);
		hmhStandardsSearchSteps.selectSubjectYearInStandards(selectSubYearVal);
		
		hmhStandardsSearchSteps.keyWordSearch(docName);
		hmhShareHeaderSteps.customWait(2);
		hmhStandardsSearchSteps.clickOnSearch();
		
		hmhStandardsSearchSteps.verifyStandardIsPresentInSearchList(docName);
	
	}

}
