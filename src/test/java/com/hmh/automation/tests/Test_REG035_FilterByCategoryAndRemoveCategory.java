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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Categories.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG035_FilterByCategoryAndRemoveCategory.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG035_FilterByCategoryAndRemoveCategory extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Steps
	private DashboardSteps dashboardSteps;
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	@Steps
	private CategoryManagerSteps categoryManagerSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	@Steps
	private MyProfileSteps myProfileSteps;
	@Steps
	private UserTrashcanSteps userTrashcanSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;

	String username, password, fileName, title, categoryName, right, grade, description, sitTypeTest, style, resourceType, siteTypeTest;

	boolean isFileFound = false;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG035 - Add Category, Filter By Category, Remove Category")
	public void test_REG035_FilterByCategoryAndRemoveCategory() {

		hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
    	siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		this.isFileFound = hmhDocumentLibrarySteps.isAssetPresent(fileName);    	
    	if (isFileFound == false){
			documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
			hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			editPropertiesDocumentSteps.selectCategories();
			categoryManagerSteps.addCategoryFromEditProperties(categoryName);
			categoryManagerSteps.saveCategoriesButtonClick();
			shareHeaderSteps.customWait(3);
			hmhEditPropertiesSteps.editDescription(description);
			hmhEditPropertiesSteps.editRight(right);
			hmhEditPropertiesSteps.editGrade(grade);
			hmhEditPropertiesSteps.editTitle(title);
			hmhEditPropertiesSteps.editLearningStyles(style);
			hmhEditPropertiesSteps.editResourceType(resourceType);
			editPropertiesDocumentSteps.saveButtonClick();
    	}
		shareHeaderSteps.customWait(3);
		//        siteHeaderSteps.clickOnDocumentLibraryButton();
		//        hmhDocumentLibrarySteps.assetFromListClick(folderName);
		//        shareHeaderSteps.customWait(5);
		//*   	  documentLibrarySteps.checkIfCategoryWasAdded(fileName, categoryName);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.filterByCategory(categoryName);
		shareHeaderSteps.customWait(3);
		documentLibrarySteps.checkIfDocumentIsPresent(fileName);
		hmhDocumentLibrarySteps.refresh();
	}
}
