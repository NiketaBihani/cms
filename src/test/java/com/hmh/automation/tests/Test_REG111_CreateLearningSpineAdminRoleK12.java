//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.3 **
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
import com.hmh.automation.steps.HMHLoginSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.CreateContentSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.GroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.InviteUsersSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.MembersSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteGroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.UserEditProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.UsersSteps;
import com.ixxus.ipm.automation.steps.alfresco.workflows.EditTaskSteps;
import com.ixxus.ipm.automation.steps.alfresco.workflows.TasksSteps;

@Story(HMHApplication.ManageRoles.Roles.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG111_CreateLearningSpineAdminRoleK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG111_CreateLearningSpineAdminRoleK12 extends com.hmh.automation.tools.AbstractBaseSiteTest {

	@Steps
	private LoginSteps loginSteps;
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
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
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
	private UsersSteps usersSteps;
	@Steps
	private HMHCreateUserSteps hmhCreateUserSteps;
	@Steps
	private UserEditProfileSteps editUserProfileSteps;
	@Steps
	private MembersSteps membersSteps;
	@Steps
	private SiteGroupsSteps siteGroupsSteps;
	@Steps
	private InviteUsersSteps inviteUserSteps;
	@Steps
	private TasksSteps taskSteps;
	@Steps
	private EditTaskSteps editTaskSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	@Steps
	private CreateContentSteps createContentSteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private HMHLoginSteps hmhloginSteps;

	String username, password, userEmail, userPassword, roleName, taskName, siteTypeTest,type,objectName, year, grade, label1, numbering1, markets, title,uploadlearningspine,groupName;
	String newUserName = "tc111"+RandomStringUtils.randomNumeric(4);
	String siteN = siteName;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}


	@Test
	@Title("Test_REG111 - Create Learning Spine Administrator Role in K12 site")
	public void test_REG111_CreateLearningSpineAdminRoleK12() {

		siteHeaderSteps.customWait(3);
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		
		// Create New User	
		usersSteps.newUserButtonClick();
		hmhCreateUserSteps.createNewUser(newUserName, "", userEmail, newUserName, userPassword, userPassword,"", false );
		siteHeaderSteps.customWait(5);
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		shareHeaderSteps.logoutButtonClick();
				
		// Verify that for the new User Upload Learning spine option is unavailable if learning spine admin role is not assigned
		hmhloginSteps.login(newUserName, userPassword);
		hmhShareHeaderSteps.clickOnSharedFiles();
		hmhDocumentLibrarySteps.uploadLearningSpineNotPresent();
		siteHeaderSteps.customWait(3);
		shareHeaderSteps.logoutButtonClick();
		
		// Login with the Admin user to assign new role to new user 
		hmhloginSteps.login(username, password);
		shareHeaderSteps.customWait(3);
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		usersSteps.searchUser(newUserName);
		hmhCreateUserSteps.editUserAndAssignGroup(groupName,newUserName);
		hmhCreateUserSteps.saveChangesButtonClick();
		shareHeaderSteps.customWait(3);
		shareHeaderSteps.logoutButtonClick();
		
		// Verify the New user is able to display upload the Learning spine option	
		hmhloginSteps.login(newUserName, userPassword);
		hmhShareHeaderSteps.clickOnSharedFiles();
    	hmhDocumentLibrarySteps.assetFromListClickSubCO(uploadlearningspine);
    	siteHeaderSteps.customWait(3);
    	shareHeaderSteps.logoutButtonClick();
		
    	// Search and Delete the Newly created User
     	hmhloginSteps.login(username, password);
		shareHeaderSteps.customWait(3);
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		usersSteps.searchUser(newUserName);
		siteHeaderSteps.customWait(5);
		usersSteps.selectUserFromSearchResults(newUserName);
		usersSteps.deleteUserButtonClick();
		shareHeaderSteps.sitesButtonClick();
		shareHeaderSteps.customWait(3);
		System.out.println("Script Completed..");

	
		
	}}