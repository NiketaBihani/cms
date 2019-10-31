package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHCreateUserSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.GroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.UserEditProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.UsersSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Groups.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG041_AdminFunctionalities.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG041_AdminFunctionalities extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	private AdvancedSearchSteps advancedSearchSteps;
	@Steps
	private SearchResultsSteps searchResultsSteps;
	@Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
	@Steps
	private GroupsSteps groupsSteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private UsersSteps usersSteps;
	@Steps
	private HMHCreateUserSteps hmhCreateUserSteps;
	@Steps
	private UserEditProfileSteps editUserProfileSteps;
	@Steps
	private CategoryManagerSteps categoryManagerSteps;


	String newUserName, users, userEmail, userPassword, verificationPassword, siteTypeTest, 
	categoryName1 = "test"+RandomStringUtils.randomAlphabetic(5), newCategoryName2 = "test"+RandomStringUtils.randomAlphabetic(3);

	String newGroup = "test"+RandomStringUtils.randomAlphabetic(5);

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG041 - Admin Functionalities: Create Group, Adda user to Group, Remove a Group, Adding and Removing categories ")
	public void test_REG041_AdminFunctionalities() {

		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsGroupsMenuClick();
		groupsSteps.browseButtonClick();
		shareHeaderSteps.customWait(7);
		groupsSteps.newGroupButtonClick();
		groupsSteps.groupIdentifierInsert(newGroup+ConstantsHMH.todaysDate());
		groupsSteps.groupNameInsert(newGroup+ConstantsHMH.todaysDate());
		groupsSteps.createGroupButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		usersSteps.newUserButtonClick();
		//    hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhCreateUserSteps.createNewUser(newUserName+ConstantsHMH.todaysDate(), "", userEmail, newUserName+ConstantsHMH.todaysDate(), userPassword, userPassword, newGroup+ConstantsHMH.todaysDate(), false);
		usersSteps.searchUser(newUserName+ConstantsHMH.todaysDate());
		usersSteps.selectUserFromSearchResults(newUserName+ConstantsHMH.todaysDate());
		usersSteps.editUserButtonClick();
		editUserProfileSteps.checkIfUserInGroup(newGroup+ConstantsHMH.todaysDate());
		editUserProfileSteps.clickSaveButton();
		usersSteps.deleteUserButtonClick();
		hmhDocumentLibrarySteps.refresh();
		adminToolsNavigationSteps.adminToolsGroupsMenuClick();
		groupsSteps.browseButtonClick();
		groupsSteps.deleteGroup(newGroup+ConstantsHMH.todaysDate());
		hmhDocumentLibrarySteps.refresh();

		//Adding and removing categories    
		/*     shareHeaderSteps.adminToolsButtonClick();
        categoryManagerSteps.categoryManagerMenuClick();
        categoryManagerSteps.addCategory(categoryName1);
        hmhDocumentLibrarySteps.refresh();
        categoryManagerSteps.checkIfCategoryIsPresent(categoryName1);
        categoryManagerSteps.deleteCategoryFromCategoryManager(categoryName1); //mouse hover build perform
        shareHeaderSteps.customWait(3);
        categoryManagerSteps.checkIfCategoryIsNotPresent(categoryName1);*/
	}

}
