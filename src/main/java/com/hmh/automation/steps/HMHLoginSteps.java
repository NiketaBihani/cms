package com.hmh.automation.steps;

	import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHLoginPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

	public class HMHLoginSteps extends AbstractSteps<HMHLoginPage> {
		private static final long serialVersionUID = -6683966261201431368L;

		public HMHLoginSteps(Pages pages) {
			super(pages, HMHLoginPage.class);
		}

		@Step("Navigate to url: {0}")
		public void navigateToUrl(String url) {
			((HMHLoginPage) currentPage()).navigateToUrl(url);
		}

		@Step("Login with username {0} and password {1}")
		public void login(String username, String password) {
			((HMHLoginPage) currentPage()).login(username, password);
		}

		@Step("Verify that the correct error message is displayed {0}")
		public void verifyThatTheCorrectErrorMessageIsDisplayed(
				String expectedMessage) {
			((HMHLoginPage) currentPage())
					.verifyThatCorrectErrorMessageIsDisplayed(expectedMessage);
		}

		@Step("Verify Logo is displayed on login page")
		public void verifyLogoIsDisplayed() {
			((HMHLoginPage) currentPage()).verifyLogoIsDisplayed();
		}

		@Step("Verify Login")
		@Pending
		public void verifyLogin() {
		}

		@Step("Login should be rejected")
		public void loginRejected(String username, String password) {
			((HMHLoginPage) currentPage()).loginRejected(username, password);
		}


}
