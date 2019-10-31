package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHSiteMembersPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;



public class HMHSiteMembersSteps extends AbstractSteps<HMHSiteMembersPage> {
	private static final long serialVersionUID = -8813399822498097799L;


		public HMHSiteMembersSteps(Pages pages) {
			super(pages, HMHSiteMembersPage.class);
		}
		
		public Pages pages;
		
		@Step("Open the Site Members found by click on link {0}")
		public void clickSiteMembers() {
			((HMHSiteMembersPage) currentPage()).clickSiteMembers();
		
		}
		
		@Step("Add the member")
		public void checkSiteMember(String memberName, String role)
		{
			((HMHSiteMembersPage) currentPage()).checkSiteMember(memberName,role);
			
		}
		
		@Step("Add the member")
		public void addUser(String userName) {
			((HMHSiteMembersPage) currentPage()).addUser(userName);
			
		}
		@Step("Open the Site Members and click on Groups Link")
		public void clickGroups() {
			((HMHSiteMembersPage) currentPage()).clickGroups();}
		@Step("Open the Site Members and click on Groups Link")
		public void verifyGroupIsPresent() {
				((HMHSiteMembersPage) currentPage()).verifyGroupIsPresent();
}
}
