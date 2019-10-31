package com.hmh.automation.tests;

//package com.hmh.automation.tests;

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

@Story(HMHApplication.ProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG081_CreateProductSetandSearch.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG081_MetadataProductLabeltoProductSetandSearchfunctionality extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	
	@Managed(uniqueSession = true) 
	
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
    //
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;
	@Steps
	private HMHSearchResultsSteps hmhSearchResultsSteps;
	@Steps
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
	@Steps
	private SearchResultsSteps searchResultsSteps;


    String type, year, grade, markets, label1, numbering1, objectName, title, siteTypeTest, description="automation",textprogramLabel,
    		searchText,waitForSearchResultsSeconds,name,VerifyQuickSearch,lookForOption,type1;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG081 - Create ProductSet in K12 Site, Metadata Product Label to Product Set and Search functionality")
    public void test_REG081_MetadataProductLabeltoProductSetandSearchfunctionality() {

    	hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering1, markets, title);
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);
        shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.programLabel(textprogramLabel);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.COPY_RIGHT_YEAR, year);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_1_LABEL, label1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NUMBERING_1, numbering1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.PROGRAM_LABEL,textprogramLabel);
        
       documentLibrarySteps.enterTextInSearchBox(searchText);
        shareHeaderSteps.customWait(5);
        hmhSearchResultsSteps.isElementPresentInSearchResult(VerifyQuickSearch, 20, 20, true);
       
        shareHeaderSteps.advancedSearchButtonClick();
        hmhAdvancedSearchSteps.selectLookFor(type);
		shareHeaderSteps.customWait(10);
		hmhEditPropertiesSteps.programLabelAdvSearch(searchText);
		
		advancedSearchSteps.clickSearchButton();
		shareHeaderSteps.customWait(5);
		searchResultsSteps.isElementPresentInSearchResult(VerifyQuickSearch, 20, 20, true);
		


    }
}
