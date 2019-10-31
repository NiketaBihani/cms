package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHStandardsHierarchySteps;
import com.hmh.automation.steps.HMHStandardsSearchSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

//@Story(HMHApplication.StandardCorrelation.AddToCart.class)
//@Story(HMHApplication.Habitat.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG058_AddObjectsToCart.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG058_AddObjectsToCart extends com.hmh.automation.tools.AbstractBaseSiteTest {
	
	@Steps
	public SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private HMHStandardsSearchSteps hmhStandardsSearchSteps;
	@Steps
	private HMHStandardsHierarchySteps hmhStandardsHierarchySteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	
	String siteTypeTest,fileName,description,title,resourceType;
	String fileName1 = "ChrysanthemumStandards";
	
	@Override
	public void setSiteType() {		
		siteType = siteTypeTest;
	}
	
	@Test
	@Title("Test_REG058 - Add Objects To Cart")
	public void test_REG058_AddObjectsToCart(){
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
		hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
		hmhDocumentDetailsSteps.addToStandardsCartButtonDocumentActionsClick();		
		hmhShareHeaderSteps.clickOnMyFiles();
		hmhDocumentDetailsSteps.clickOnStandardCorrelationCart(fileName1);		

		//hmhShareHeaderSteps.clickOnSearchStandards();
}
}
