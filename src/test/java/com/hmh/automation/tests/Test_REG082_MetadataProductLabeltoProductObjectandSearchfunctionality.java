package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.ProductObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG082_CreateProductObjectandSearch.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG082_MetadataProductLabeltoProductObjectandSearchfunctionality extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Managed(uniqueSession = false) 
	
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
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
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	@Steps
	private SearchResultsSteps searchResultsSteps;
//
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;
	
    String type, year, grade, markets, subMarket, label1, numbering1, objectName, title, siteTypeTest, description, label6, numbering6,textprogramLabel,
    searchText,VerifyQuickSearch,type1;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG082 - Create Product Object in K12 Site, MetadataProductLabeltoProductObjectandSearchfunctionality")
    public void test_REG082_MetadataProductLabeltoProductObjectandSearchfunctionality() {

        hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductObject(objectName, year, title);
        documentLibrarySteps.checkIfAssetIsPresent(objectName);
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);
        shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.programLabel(textprogramLabel);
        hmhEditPropertiesSteps.editGrade(grade);
        hmhEditPropertiesSteps.editMarkets(markets);
        hmhEditPropertiesSteps.editSubMarketInternational(subMarket);
        hmhEditPropertiesSteps.editLevel1Label(label1);
        hmhEditPropertiesSteps.selectLvl1Number(numbering1);
        hmhEditPropertiesSteps.editLevel6Label(label6);
        hmhEditPropertiesSteps.selectLvl6Number(numbering6);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.COPY_RIGHT_YEAR, year);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MARKETS, markets);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_1_LABEL, label1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_6_LABEL, label6);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.PROGRAM_LABEL,textprogramLabel);
       
        documentLibrarySteps.enterTextInSearchBox(searchText);
        shareHeaderSteps.customWait(5);
        hmhSearchResultsSteps.isElementPresentInSearchResult(VerifyQuickSearch, 20, 20, true);
        shareHeaderSteps.advancedSearchButtonClick();
        hmhAdvancedSearchSteps.selectLookFor(type);
		shareHeaderSteps.customWait(10);
		hmhEditPropertiesSteps.programLabelAdvSearch(searchText);
		//advancedSearchSteps.inputSearchName(name);
		//hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
	//	hmhAdvancedSearchSteps.selectYearInAdvancedSearch(year);
		advancedSearchSteps.clickSearchButton();
		shareHeaderSteps.customWait(5);
		searchResultsSteps.isElementPresentInSearchResult(VerifyQuickSearch, 20, 20, true);
		//searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
	System.out.println("Advsearchverified verified");

       

    }
}
