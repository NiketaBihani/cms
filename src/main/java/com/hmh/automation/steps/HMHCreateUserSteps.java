package com.hmh.automation.steps;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHCreateUserPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

	
	public class HMHCreateUserSteps extends AbstractSteps<HMHCreateUserPage> {
		private static final long serialVersionUID = 7698079881582854346L;

		public HMHCreateUserSteps(Pages pages) {
			super(pages, HMHCreateUserPage.class);
		}

		@Step("Create new user: {0},{1},{2},{3},{4},{5},{6} and add it to {7} group")
		public void createNewUser(String firstName, String lastName,
				String userEmail, String userName, String userPassword,
				String verificationPassword, String group, boolean assertUserCreated) {
			((HMHCreateUserPage) currentPage()).createNewUser(firstName, lastName,
					userEmail, userName, userPassword, verificationPassword, group,
					assertUserCreated);
		}

		@Step("Create user {0},{1},{2},{3},{4},{5},{6},{7} and create another user {8},{9},{10},{11},{12},{13},{14}")
		@Pending
		public void createAndCreateAnotherUser(String firstName, String lastName,
				String userEmail, String userName, String password,
				String verificationPassword, String group, String firstName1,
				String lastName1, String userEmail1, String userName1,
				String password1, String verificationPassword1, String group1) {
			((HMHCreateUserPage) currentPage()).createAndCreateAnotherUser(firstName,
					lastName, userEmail, userName, verificationPassword,
					verificationPassword, group, firstName1, lastName1, userEmail1,
					userName1, password1, verificationPassword1, group1);
		}

		@Step
		@Pending
		public void cancelCreateNewUser() {
			((HMHCreateUserPage) currentPage()).cancelCreateNewUser();
		}

		@Step("Click on Disable Account checkbox")
		public void disableAccountCheckboxClick() {
			((HMHCreateUserPage) currentPage()).disableAccountCheckboxClick();
		}

		@Step("Click on Save Changes button")
		public void saveChangesButtonClick() {
			((HMHCreateUserPage) currentPage()).saveChangesButtonClick();
		}
		//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.3 **	
		@Step("Search for Learning Spine Admin group")
		public void editUserAndAssignGroup(String groupName,String user) {
			((HMHCreateUserPage) currentPage()).editUserAndAssignGroup(groupName,user);
		}
		


}
