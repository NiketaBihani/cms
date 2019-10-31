//** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG128_SearchContentByStandardTextAndCodeInK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG128_SearchContentByStandardTextAndCodeInK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    @Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	

	String  importStdName, docName, standard, standardFolder, grade, sourceGrade, targetGrade, sourceStandard, targetStandard, siteTypeTest, subjectName, collectionName, gradeNumber,
	        standardText,fileName, subject,stdText,ABGUID,sText,sCode,standardCode,text;
	String AssetsFolder ="Assets";
	String fileName1 = "test.jpg";
	int waitForSearchResultsSeconds = 10;

	 
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test REG128 Search Content By Standard Text And Code In K12")
	public void test_REG128_SearchContentByStandardTextAndCodeInK12(){
		
		// Add and upload the assets to be added to cart
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
		shareHeaderSteps.customWait(2);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
		shareHeaderSteps.customWait(2);
		
		// Select checkbox to be added to Cart
		hmhShareHeaderSteps.clickCheckBoxToAddToCart();
		
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
		hmhStandardsSearchSteps.expandGradeButton(gradeNumber,standardText,importStdName,subject);
		hmhStandardsSearchSteps.CorrelateObjectToStandard(fileName);
		
		// Correlate objects uploaded filename and filename1 both
		shareHeaderSteps.customWait(5);
		//hmhStandardsSearchSteps.CorrelateObjectToStandard(fileName1);
		
		
		// View the objects correlated
		 hmhStandardsSearchSteps.viewCorrelations(fileName);		
		//hmhStandardsSearchSteps.viewCorrelations(fileName1);
		 
		// Read the AB GUID value and store in a variable
		 String ABGUIDValue = hmhStandardsSearchSteps.storeABGUIDValue();
				
		// Navigate to quick search option and search filename and verify the ABGUID correlations and details
		 documentLibrarySteps.enterTextInSearchBox(fileName);
	     shareHeaderSteps.customWait(5);
	     hmhSearchResultsSteps.isElementPresentInSearchResult(fileName, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
	     hmhDocumentLibrarySteps.assetFromSearchResultsListClick(fileName);
	     shareHeaderSteps.customWait(5);
	     hmhStandardsSearchSteps.verifyStdTextForCorrelatedObject(stdText);
		
		// Navigate to Search Content by Standards and search with all the three options and verify
	     hmhShareHeaderSteps.clickOnStandards();
	     hmhShareHeaderSteps.clickOnSearchByStandards();
	     
	    // Search by ABGUID and verify
	     hmhStandardsSearchSteps.selectDropdownSearchContent(ABGUID);
	     hmhStandardsSearchSteps.keywordSearch(ABGUIDValue);
	     shareHeaderSteps.customWait(3);
	     hmhStandardsSearchSteps.verifyDisplayNameOnSearchResults(fileName);
	     hmhStandardsSearchSteps.refreshPage();
	    
	    // Search by Standard Text and verify
	     hmhStandardsSearchSteps.selectDropdownSearchContent(sText);
	     hmhStandardsSearchSteps.keywordSearch(text);
	     shareHeaderSteps.customWait(3);
	     hmhStandardsSearchSteps.verifyDisplayNameOnSearchResults(fileName);
	     hmhStandardsSearchSteps.refreshPage();
	     
	    // Search by Standard Code and verify
	     hmhStandardsSearchSteps.selectDropdownSearchContent(sCode);
	     hmhStandardsSearchSteps.keywordSearch(standardCode);
	     shareHeaderSteps.customWait(3);
	     hmhStandardsSearchSteps.verifyDisplayNameOnSearchResults(fileName);
	     hmhStandardsSearchSteps.refreshPage();
	}

}

