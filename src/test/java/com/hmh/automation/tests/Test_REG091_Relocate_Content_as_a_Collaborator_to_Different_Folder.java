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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH+ "Test_REG091_Relocate_Content_as_a_Collaborator_to_Different_Folder.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG091_Relocate_Content_as_a_Collaborator_to_Different_Folder extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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

	String type, objectNameOld,  title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo,
	sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel, 
	username, password, userPassword, Documents, collaboratorId, description, roleNameConsumer,folderName, roleNameContributor, roleNameCollaborator, testUserConsumer, testUserContributor, testUserCollaborator, taskName, userEmail1, userEmail2, userEmail3;

	private boolean isAssetFound = true;
	int noOfLevels = 1; // level 2 tree structure
	String habitatProperty = "Is Pushed To Habitat?";
	String habitatStatus = "Yes";
	String objectName ="t091"+ ConstantsHMH.REG_PRODUCTSET_NAME +ConstantsHMH.TODAY_DATE;
	String taskNameSite=this.taskName+this.siteSearch;
	String elementCopytable="div[id*='copyMoveTo']>div>div>div>div:nth-child(2)>div>table>tbody>tr>td[id*='content']>span:nth-child(1)";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@WithTag(type = "feature", name = "Roles")
	@Title("Test_REG091_Relocate_Content_as_a_Collaborator_to_Different_Folder")
	public void test_REG091_Relocate_Content_as_a_Collaborator_to_Different_Folder() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);	
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName); //level 3 tree structure
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnMembersButton();
		membersSteps.invitePeopleButtonClick();
		shareHeaderSteps.customWait(3);
		inviteUserSteps.addUser(testUserCollaborator);
		siteGroupsSteps.selectRole(testUserCollaborator, roleNameCollaborator);
		inviteUserSteps.clickToInvite();
		shareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.logoutButtonClick();
		
		loginSteps.login(collaboratorId, userPassword);
		dashboardSteps.selectTaskFromMyTask(taskName);
		editTaskSteps.acceptButtonClick();
		hmhSiteFinderSteps.searchUserSites(siteSearch);
		hmhSiteFinderSteps.openTheUserSiteFound(siteSearch);
		siteDashboardSteps.checkSiteMember(testUserCollaborator, roleNameCollaborator);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.createNewContent("Folder");
		hmhDocumentLibrarySteps.insertFolderNameDescriptionAndSave(folderName, description);
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentLibrarySteps.clickMoveto();
		
		hmhShareHeaderSteps.waitForElement(elementCopytable, 200);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectPathToCopy(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.confirmCopyButtonClick();
        shareHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(folderName);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentLibrarySteps.clickMoveto();
		
		hmhShareHeaderSteps.waitForElement(elementCopytable, 200);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectPathToCopy(ProductSetsFolder);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.confirmCopyButtonClick();
        shareHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.documentCheckboxClick();
		hmhDocumentLibrarySteps.selectAnItemFromSelectedItemsDropDown("Delete");
		hmhDocumentLibrarySteps.confirmDelete();
		


	}
	
}
