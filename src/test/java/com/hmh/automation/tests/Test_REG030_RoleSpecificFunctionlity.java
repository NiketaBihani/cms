package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.steps.HMHSiteMembersSteps;
import com.hmh.automation.steps.InklingHabitatSiteSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.CreateContentSteps;
import com.ixxus.ipm.automation.steps.alfresco.CreateUserSteps;
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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH+ "Test_REG030_RoleSpecificFunctionlity.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG030_RoleSpecificFunctionlity extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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
	private CreateUserSteps createUserSteps;
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
	private HMHSiteMembersSteps hmhSiteMembersSteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHDataListsSteps hmhDataListsSteps;
	   
	@Steps
	private InklingHabitatSiteSteps inklingHabitatSiteSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;

	String type, objectNameOld, title, level1, numbering1, userEmail,sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo,
	sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel, 
	username, password, userPassword, roleNameConsumer, roleNameContributor, roleNameCollaborator, testUserConsumer, testUserContributor, testUserCollaborator, taskName, userEmail1, userEmail2, userEmail3;

	private boolean isAssetFound = true;
	int noOfLevels = 2; // level 2 tree structure
	String habitatProperty = "Is Pushed To Habitat?";
	String habitatStatus = "Yes";
	String objectName = ConstantsHMH.REG_PRODUCTSET_NAME +ConstantsHMH.TODAY_DATE;
	String sbNameD = "sb" +ConstantsHMH.TODAY_DATE, sbName1D = "sb" +ConstantsHMH.TODAY_DATE + "1", sbName2D = "sb" +ConstantsHMH.TODAY_DATE + "2", sbNameND = "updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD = "cco" +ConstantsHMH.TODAY_DATE, ccoName1D = "cco" +ConstantsHMH.TODAY_DATE+ "1", ccoName2D = "cco" +ConstantsHMH.TODAY_DATE + "2", ccoNameND = "updatedCCO" +ConstantsHMH.TODAY_DATE;
	String habUserName = ConstantsHMH.HABITAT_TEST_USER_LOGIN;
	String habPassword = ConstantsHMH.HABITAT_TEST_PASS_LOGIN;
	String taskNameSite=this.taskName+this.habSiteNameReg;
	String group="CMS_USER_ADMINISTRATORS,Build Studio,CMS-QA-TEAM,ALFRESCO_STANDARD_ADMINISTRATOR,ALFRESCO_STANDARD_QA,HIP Catalogers,CMS_REPORTS_ADMINISTRATOR,Learning Architect,Standards Editor";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type = "feature", name = "Roles")
	@Title("Test_REG030 - Role Specific Functionlity")
	public void test_REG030_RoleSpecificFunctionlity() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);

		if (this.isAssetFound == false) {

			documentLibrarySteps.createNewContent(type);
			hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
			hmhDocumentLibrarySteps.createProductSet(objectName, year, grade,level1, numbering1, markets, title);
			hmhDocumentLibrarySteps.refresh();
			hmhDocumentLibrarySteps.assetFromListClick(objectName);
			hmhDocumentLibrarySteps.navBarClick(objectName);
			hmhDocumentDetailsSteps.clickEditSequence();
			hmhSequenceViewSteps.checkIfOnSequenceViewPage();
			hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
			hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbNameD, ccoNameD); // level 2 tree structure
			// Referencing Program Support Folder for product set
			shareHeaderSteps.siteFinderButtonClick();
			hmhSiteFinderSteps.searchForASite2(masterLibSite);
			hmhSiteFinderSteps.openTheSiteFound(masterLibSite);
			siteHeaderSteps.clickOnDocumentLibraryButton();
			hmhDocumentLibrarySteps.assetFromListClick(masterLibFolder);
			hmhDocumentLibrarySteps.navBarClick(masterLibFolder);
			documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
			hmhEditPropertiesSteps.clickProductSetRefSelect();
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(sitesLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(habSiteNameReg);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
			hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductSetsFolder);
			hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
			hmhEditPropertiesSteps.saveButtonClick();
			shareHeaderSteps.customWait(5);
			hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
			hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		}

		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(3);
		
		String currentOneCMSHabitatURL = hmhShareHeaderSteps.getCurrentURLasString();

		
		// Inviting existing users(all three types) to newly created K-12 Site
		siteHeaderSteps.clickOnMembersButton();
		membersSteps.invitePeopleButtonClick();
		hmhSiteMembersSteps.addUser(testUserConsumer);
		
		siteGroupsSteps.selectRole(testUserConsumer, roleNameConsumer);
		inviteUserSteps.clickToInvite();
		shareHeaderSteps.customWait(5);
		hmhSiteMembersSteps.addUser(testUserContributor);
		siteGroupsSteps.selectRole(testUserContributor, roleNameContributor);
		inviteUserSteps.clickToInvite();
		shareHeaderSteps.customWait(5);
		hmhSiteMembersSteps.addUser(testUserCollaborator);
		siteGroupsSteps.selectRole(testUserCollaborator, roleNameCollaborator);
		inviteUserSteps.clickToInvite();
		shareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.logoutButtonClick();

		// Consumer Login
		loginSteps.login(testUserConsumer, userPassword);
		dashboardSteps.selectTaskFromMyTask(taskName);
		editTaskSteps.acceptButtonClick();
		shareHeaderSteps.customWait(5);
		hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
		hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		createContentSteps.verifyCreateFolderIsDisabled();
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSHabitatURL);
		hmhDocumentDetailsSteps.verifyHabitatIsDisabled(testUserConsumer);

		shareHeaderSteps.customWait(5);
		hmhShareHeaderSteps.logoutButtonClick();

		// Contributor Login and verify roles
		loginSteps.login(testUserContributor, userPassword);
		dashboardSteps.selectTaskFromMyTask(taskName);
		editTaskSteps.acceptButtonClick();
		shareHeaderSteps.customWait(5);
		hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
		hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSHabitatURL);
		hmhDocumentDetailsSteps.verifyHabitatIsDisabled(testUserContributor);
		
		shareHeaderSteps.customWait(5);		
		hmhShareHeaderSteps.logoutButtonClick();

		// Collaborator Login and verify roles
		loginSteps.login(testUserCollaborator, userPassword);
		dashboardSteps.selectTaskFromMyTask(taskName);
		editTaskSteps.acceptButtonClick();
		shareHeaderSteps.customWait(5);
		hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
		hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSHabitatURL);
		hmhDocumentDetailsSteps.verifyHabitatIsDisabled(testUserCollaborator);
		
		shareHeaderSteps.customWait(5);
		hmhShareHeaderSteps.logoutButtonClick();

		// Login as a Manager
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.customWait(3);

	}
}
