package com.hmh.automation.tests;


import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHCreateUserSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.InviteUsersSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.MembersSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteGroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.UsersSteps;
import com.ixxus.ipm.automation.steps.alfresco.workflows.EditTaskSteps;
import com.ixxus.ipm.automation.steps.alfresco.workflows.TasksSteps;



@Story(HMHApplication.Publishing.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_Reg092_Allow_Production_Services_to_DisableNDelete_Accounts.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_Reg092_Allow_Production_Services_to_DisableNDelete_Accounts extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
	
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	
	@Steps
	private MembersSteps membersSteps;
	@Steps
	private SiteGroupsSteps siteGroupsSteps;
	@Steps
	private InviteUsersSteps inviteUserSteps;
	@Steps
	private TasksSteps taskSteps;
	
	@Steps
    private AdminToolsNavigationSteps adminToolsNavigationSteps;
	
	@Steps
    private UsersSteps usersSteps;
    @Steps
    private HMHCreateUserSteps hmhCreateUserSteps;
 
    
	@Steps
	private LoginSteps loginSteps;
	@Steps
	private DashboardSteps dashboardSteps;
	
	@Steps
	private EditTaskSteps editTaskSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;


	String   siteTypeTest, newUserName, userEmail, userPassword;
	String group="CMS_USER_ADMINISTRATORS,Build Studio,CMS-QA-TEAM,ALFRESCO_STANDARD_ADMINISTRATOR,ALFRESCO_STANDARD_QA,HIP Catalogers,CMS_REPORTS_ADMINISTRATOR,Learning Architect,Standards Editor";
	String newUserName1 = "prodserv_user"+ConstantsHMH.TODAY_DATE;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
//	
	@Test
	@WithTag(type="feature", name="publish")

	@Title("Test_Reg092_Allow_Production_Services_to_DisableNDelete_Accounts")
	public void test_Reg092_Allow_Production_Services_to_DisableNDelete_Accounts() {
		
		
		siteHeaderSteps.customWait(3);
        shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsUsersMenuClick();
        usersSteps.newUserButtonClick();
        hmhCreateUserSteps.createNewUser(newUserName1, "", userEmail, newUserName1, userPassword, userPassword,group, false );
        shareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.logoutButtonClick();
		shareHeaderSteps.customWait(3);
		loginSteps.login(newUserName1, userPassword);
		shareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.logoutButtonClick();
		shareHeaderSteps.customWait(3);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsUsersMenuClick();
        usersSteps.searchUser(newUserName1);
        usersSteps.checkIfUserExistsInSearchResults(newUserName1);
        usersSteps.selectUserFromSearchResults(newUserName1);
		usersSteps.editUserButtonClick();
		hmhCreateUserSteps.disableAccountCheckboxClick();
		hmhCreateUserSteps.saveChangesButtonClick();
		shareHeaderSteps.customWait(3);
		hmhShareHeaderSteps.logoutButtonClick();
		loginSteps.loginRejected(newUserName1, userPassword);
		shareHeaderSteps.customWait(3);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsUsersMenuClick();
        usersSteps.searchUser(newUserName1);
        usersSteps.checkIfUserExistsInSearchResults(newUserName1);
        usersSteps.selectUserFromSearchResults(newUserName1);
		usersSteps.deleteUserButtonClick();
		hmhShareHeaderSteps.logoutButtonClick();
		loginSteps.loginRejected(newUserName1, userPassword);
		loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsUsersMenuClick();
        usersSteps.searchUser(newUserName1);
        usersSteps.checkIfUserDoesNotExistsInSearchResults(newUserName1); 
        
		
	}
}
