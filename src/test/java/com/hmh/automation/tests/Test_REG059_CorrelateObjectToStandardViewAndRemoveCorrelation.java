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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG059_CorrelateObjectToStandard.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG059_CorrelateObjectToStandardViewAndRemoveCorrelation extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
	private ShareHeaderSteps shareHeaderSteps;
	

	String  importStdName, docName, standard, standardFolder, grade, sourceGrade, targetGrade, sourceStandard, targetStandard, siteTypeTest, subjectName, collectionName, gradeNumber
	         , standardText,fileName = "ChrysanthemumStandards.jpg", subject;
	String fileName1= "test.jpg";
	String AssetsFolder ="Assets";

	 
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG059 - Correlate Objects To Standards")
	public void test_REG059_CorrelateObjectToStandard(){
		
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
		// Add and upload the assets to be added to cart
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
		
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
		// Select checkbox to be added to Cart
		hmhShareHeaderSteps.clickCheckBoxToAddToCart();
		
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
		// Click Action Add to Standards Cart
		hmhShareHeaderSteps.clickAddToCartAction();
		
		// Check the objects added in the Approved Standards
		hmhShareHeaderSteps.clickOnStandards();			
		hmhShareHeaderSteps.clickOnSearchStandards();
		hmhStandardsSearchSteps.selectStandardCollection(collectionName);
		hmhStandardsSearchSteps.keyWordSearch(subjectName);
		hmhStandardsSearchSteps.clickOnSearch();
		hmhStandardsSearchSteps.verifyStandardIsPresentInSearchList(docName);
		hmhStandardsSearchSteps.clickOnActionsForDocument(docName);
		// *** Fix ***
		hmhStandardsSearchSteps.expandGradeButton(gradeNumber,standardText,importStdName,subject);
		hmhStandardsSearchSteps.CorrelateObjectToStandard(fileName);
		
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
		// Correlate objects uploaded filename and filename1 both
		shareHeaderSteps.customWait(5);
		hmhStandardsSearchSteps.CorrelateObjectToStandard(fileName1);
		hmhStandardsSearchSteps.viewCorrelations(fileName);
		
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
		// View the objects correlated
		hmhStandardsSearchSteps.viewCorrelations(fileName1);
		//*** Fix ***
		hmhStandardsSearchSteps.removeCorrelations(fileName);
		
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
		// Remove the correlations
		hmhStandardsSearchSteps.removeCorrelations(fileName1);
		
	}

}

