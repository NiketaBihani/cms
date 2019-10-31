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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG056_ModifyStructureOrHierarchyOfStandardsImportedToOneCMSDragAndDrop.csv", separator = ConstantsHMH.CSV_SEPARATOR)
//public class Test_REG056_ModifyStructureOrHierarchyOfStandardsImportedToOneCMSDragAndDrop extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
public class Test_REG056_ModifyStructureOrHierarchyOfStandardsImportedToOneCMSDragAndDrop extends com.hmh.automation.tools.AbstractBaseSiteTestHIP {
	
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
	

	String  importStdName, docName, standard, standardFolder, grade, sourceGrade = "1", targetGrade = "3", sourceStandard = "Shows curiosity", targetStandard, siteTypeTest;

	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type="feature", name="Standards")
	@Title("Test_REG056 - Modify Structure/Hierarchy Of Standards Imported To OneCMS by Drag And Drop and Verify the changes")
	public void test_REG056_ModifyStructureOrHierarchyOfStandardsImportedToOneCMSDragAndDrop() {

		
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnImportStandards(); //English Language Arts (2010)
		hmhStandardsSearchSteps.importStandardsToOneCMS(importStdName);
		
		hmhShareHeaderSteps.customWait(3);
		//Script updated to handle if Subject already exists - June 2017
		hmhStandardsSearchSteps.verifyImportStandardPopupIsPresent("Import Standard");
		hmhShareHeaderSteps.customWait(3);
		
		hmhShareHeaderSteps.clickOnStandards();
		hmhShareHeaderSteps.clickOnSearchStandards();
		hmhStandardsSearchSteps.clickOnSearch();	
		//hmhStandardsSearchSteps.waitUntilStandardIsImported(docName);
		hmhStandardsSearchSteps.keyWordSearch(docName);
		hmhStandardsSearchSteps.clickOnSearch();
		hmhStandardsSearchSteps.clickOnActionsForDocument(docName);
		hmhShareHeaderSteps.customWait(3);
		
		hmhStandardsHierarchySteps.dragAndDropStandardAtGradeLevel(sourceGrade, sourceStandard, targetGrade);
		hmhShareHeaderSteps.customWait(3);
		hmhStandardsHierarchySteps.saveStructure();
		hmhShareHeaderSteps.customWait(3);
		hmhStandardsHierarchySteps.verifyTheChangesAreReflected(sourceGrade, sourceStandard, targetGrade);
		hmhShareHeaderSteps.customWait(3);
		/*hmhStandardsHierarchySteps.dragAndDropStandardAtGradeLevel(targetGrade, sourceStandard, sourceGrade);
		hmhStandardsHierarchySteps.saveStructure();
		hmhStandardsHierarchySteps.verifyTheChangesAreReflected(targetGrade, sourceStandard, sourceGrade);*/
	}

}
