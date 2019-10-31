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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG040b_InviteUsersToMySiteAsDiffrentRoles.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG040b_InviteUsersToMySiteAsDiffrentRoles extends com.hmh.automation.tools.AbstractBaseSiteTest {

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

	String username, password, userEmail, userPassword, roleName, taskName, siteTypeTest,type,objectName, year, grade, label1, numbering1, markets, title;
	String newUserName = "Abd"+RandomStringUtils.randomNumeric(4);
	String siteN = siteName;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}


	@Test
	@Title("Test_REG040b - Invite Users to my Site as consumer, contributor, collaborator")
	public void test_REG040b_InviteUsersToMySiteAsDiffrentRoles() {

		siteHeaderSteps.customWait(3);
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		System.out.println(siteName);
		usersSteps.newUserButtonClick();
		hmhCreateUserSteps.createNewUser(newUserName, "", userEmail, newUserName, userPassword, userPassword,"", false );
		hmhSiteFinderSteps.searchUserSites(siteName);
		hmhSiteFinderSteps.openTheUserSiteFound(siteName);

		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering1, markets, title);

		hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);

		siteHeaderSteps.clickOnMembersButton();
		membersSteps.invitePeopleButtonClick();
		inviteUserSteps.addUser(newUserName);

		inviteUserSteps.checkIfUserWasAddedToLeftPanel(newUserName);
		siteGroupsSteps.selectRole(newUserName, roleName);
		inviteUserSteps.clickToInvite();
		siteHeaderSteps.customWait(5);
		hmhShareHeaderSteps.logoutButtonClick();
		//login as new user which is created
		loginSteps.login(newUserName, userPassword);
		dashboardSteps.selectTaskFromMyTask(taskName);
		//editTaskSteps.approveButtonClick();
		editTaskSteps.acceptButtonClick();

		hmhSiteFinderSteps.searchUserSites(siteName);
		hmhSiteFinderSteps.openTheUserSiteFound(siteName);
		siteDashboardSteps.checkSiteMember(newUserName, roleName);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		/*if (roleName.contains("Consumer")) {
                                                createContentSteps.verifyCreateFolderIsDisabled();
                                }*/
		if (roleName.contains("Viewer")) {
			createContentSteps.verifyCreateFolderIsDisabled();
			hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);

			hmhDocumentLibrarySteps.verifyDownloadAsZipIsDisplayed();
			hmhDocumentLibrarySteps.verifyCopyToIsDisplayed();

		}
		shareHeaderSteps.logoutButtonClick();
		loginSteps.login(username, password);
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.adminToolsUsersMenuClick();
		usersSteps.searchUser(newUserName);
		//Fix to wait for 8 seconds
		siteHeaderSteps.customWait(8);
		usersSteps.selectUserFromSearchResults(newUserName);
		usersSteps.deleteUserButtonClick();
		shareHeaderSteps.sitesButtonClick();
		shareHeaderSteps.customWait(3);
	}
}

