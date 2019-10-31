package com.hmh.automation.steps;

	import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHShareHeaderPage;
import com.hmh.automation.pages.HMHSiteFinderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteHeaderPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

	public class HMHSiteFinderSteps extends AbstractSteps<HMHSiteFinderPage> {
		private static final long serialVersionUID = -8813399822498097799L;

		public HMHSiteFinderSteps(Pages pages) {
			super(pages, HMHSiteFinderPage.class);
		}
		
		public Pages pages;
		
		@Step("Open the site found by click on link {0}")
		public void openTheSiteFound(String siteName) {
			((HMHSiteFinderPage) currentPage()).openTheSiteFound(siteName);
		}

		@Step("Join a site {0}")
		public void joinSite(String siteName) {
			((HMHSiteFinderPage) currentPage()).joinSite(siteName);
		}

		@Step("Delete a site")
		public void deleteSite(String siteName, boolean assertDeleted) {
			((HMHSiteFinderPage) currentPage()).deleteSite(siteName, assertDeleted);
		}

		@Step("Delete all sites")
		public void deleteAllSites() {
			((HMHSiteFinderPage) currentPage()).deleteAllSites();
		}

		@Step("Leave a site {0}")
		public void leaveSearchedSite(String siteName) {
			((HMHSiteFinderPage) currentPage()).leaveSite(siteName);
		}

		@Step("Search for a site {0}")
		public void searchForASite(String siteName) {
			((HMHSiteFinderPage) currentPage()).searchForASite(siteName);
		}
		
		@Step("Search for a site {0}")
		public void searchForASiteAfterDelete(String siteName) {
			((HMHSiteFinderPage) currentPage()).searchForASiteAfterDelete(siteName);
		}
		
		@Step("Search for a site {0}")
		public void searchForASite1(String siteName) {
			((HMHSiteFinderPage) currentPage()).searchForASite1(siteName);
		}
		
		@Step("Search for a site {0}")
		public void searchForASite2(String siteName) {
			((HMHSiteFinderPage) currentPage()).searchForASite2(siteName);
		}

		@Step("Check if site is present in the results list{0}")
		public void checkSiteResultsList(String siteName) {
			((HMHSiteFinderPage) currentPage())
					.checkIfSitePresentInResultsList(siteName);
		}

		@Step("Check if site is not present in the results list{0}")
		public void checkIfSiteIsNotPresentInResultsList(String siteName) {
			((HMHSiteFinderPage) currentPage())
					.checkIfSiteIsNotPresentInResultsList(siteName);
		}
		
		@Step("Verify that search user site {0} is created")
		public void isSearchSitePresent(String siteName, String siteType) {
			boolean isFound = searchUserSites(siteName);
			if(isFound==false){
				((HMHShareHeaderPage) this.pages.currentPageAt(HMHShareHeaderPage.class))
						.createNewSiteWithSiteType(siteName, siteType);
				((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class))
						.clickOnDocumentLibraryButton();
			}
		}
		
		@Step("Search user sites for logged in user")
		public boolean searchUserSites(String siteName) {
			return ((HMHSiteFinderPage) currentPage()).searchUserSites(siteName);
		}
		
		@Step("Open the user site found from user sites")
		public void openTheUserSiteFound(String siteName)  {
			((HMHSiteFinderPage) currentPage())
				.openTheUserSiteFound(siteName);
		}
		
		@Step("Search site in Site manager list And Clcik on Delete from site Actions")
		public void searchAndDeleteSiteFromSiteManager(String sitename) {
			((HMHSiteFinderPage) currentPage()).searchAndDeleteSiteFromSiteManager(sitename);
		}
		
		@Step("Verify Deleted Site {0} is not in the User Sites List")
		public void verifySiteWasDeleted(String sitename) {
			((HMHSiteFinderPage) currentPage()).verifySiteWasDeleted(sitename);
		}
		
		@Step("Click on Site Manager Link")
		public void clickOnSiteMangerLink(){
			((HMHSiteFinderPage) currentPage()).clickOnSiteMangerLink();
		}
		
	    @Step("Click on site finder menu button")
	   public void siteFinderButtonClick() {
	    	((HMHSiteFinderPage) currentPage()).siteFinderButton();
	   }
	  
	}