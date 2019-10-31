package com.hmh.automation.steps;


	import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHShareHeaderPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

	public class HMHShareHeaderSteps extends AbstractSteps<HMHShareHeaderPage> {
		private static final long serialVersionUID = -8157730923059473886L;

		public HMHShareHeaderSteps(Pages pages) {
			super(pages, HMHShareHeaderPage.class);
		}

		

		@Step("Create a new site")
		public String createNewSite() {
			return ((HMHShareHeaderPage) currentPage()).createNewSite();
		}

		@Step("Create a new site")
		public void createNewSite(String newSiteName) {
			((HMHShareHeaderPage) currentPage()).createNewSite(newSiteName);
		}


		@Step("Click on user menu")
		public void userButtonClick() {
			((HMHShareHeaderPage) currentPage()).userButtonClick();
		}


		@Step("Click on logout menu")
		public void logoutButtonClick() {
			((HMHShareHeaderPage) currentPage()).logoutButtonClick();
		//	getDriver().close();
		}
		
		@Step("Get current URL and Store as string")
		public String getCurrentURLasString() {
			return getDriver().getCurrentUrl();
		}
		
		@Step("Navigate to saved URL")
		public void loadTheSavedURL(String savedURL) {
			getDriver().get(savedURL);
		}
		
		@Step("Click on Standards Button")
		public void clickOnStandards() {
			 ((HMHShareHeaderPage) currentPage()).clickOnStandards();
		}
		
		@Step("Click on Import Standards Option")
		public void clickOnImportStandards() {
			 ((HMHShareHeaderPage) currentPage()).clickOnImportStandards();
		}
		
		@Step("Click on Search Standards Option")
		public void clickOnSearchStandards() {
			 ((HMHShareHeaderPage) currentPage()).clickOnSearchStandards();
		}
		
		@Step("Click on  Reports Option")
		public void clickOnReports() {
			 ((HMHShareHeaderPage) currentPage()).clickOnReports();
		}
		
		@Step("Click on  Reports Option")
		public void clickOnReportsLearningSpine() {
			 ((HMHShareHeaderPage) currentPage()).clickOnReportsLearningSpine();
		}
		
		@Step("Dynamic wait For Element {1} Seconds")
		public void waitForElement(String cssInput, int seconds) {
			 ((HMHShareHeaderPage) currentPage()).waitForElement(cssInput, seconds);
		}
		
		@Step("Dynamic wait For Element {1} Seconds")
		public void waitForElementX(String xpathInput, int seconds) {
			 ((HMHShareHeaderPage) currentPage()).waitForElementX(xpathInput, seconds);
		}
		@Step("Click on My Files Option")
		public void clickOnMyFiles() {
			 ((HMHShareHeaderPage) currentPage()).clickOnMyFiles();
		}
		//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.3 **	
		@Step("Click on Shared Files Option")
		public void clickOnSharedFiles() {
			 ((HMHShareHeaderPage) currentPage()).clickOnSharedFiles();
		}
		
		@Step("Click on Export to Excel Learning spine in reports")
		public void clickOnExportToExcelLearningSpine(String lsTitle) {
			 ((HMHShareHeaderPage) currentPage()).clickOnExportToExcelLearningSpine(lsTitle);	
			 
		}
		
		@Step("Click on Exported Excel report")
		public String verifyLearningSpineTitle(String lsTitle) {
			String title = ((HMHShareHeaderPage) currentPage()).verifyLearningSpineTitle(lsTitle);
			return title;
			 
		}
		
		//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
		@Step("Click on Exported Excel report")
		public String setDownloadFilePath(String filePath, String title) {
			return ((HMHShareHeaderPage) currentPage()).setDownloadFilePath(filePath, title);
		}
		
		@Step("Click on Exported Excel report")
		public void verifyExportedLearningSpineReport(String lsTitle) {
		//	String title = ((HMHShareHeaderPage) currentPage()).verifyLearningSpineTitle(lsTitle);
			 ((HMHShareHeaderPage) currentPage()).verifyExportedLearningSpineReport(lsTitle);
						 
		}
		
		//** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 **	
		@Step("Click on Delete Learning spine in reports")
		public void clickOnDeleteLearningSpine(String lsTitle) {
			 ((HMHShareHeaderPage) currentPage()).clickOnDeleteLearningSpine(lsTitle);	
			 
		}
		
		//** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 **	
		@Step("Click on Ok Button On Delete Learning spine in reports")
		public void clickOnOkButtonOnDeleteLS() {
			((HMHShareHeaderPage) currentPage()).clickOnOkButtonOnDeleteLS();	

		}
			
		//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
		@Step("Click on Shared Files Option")
		public void clickOnHelpMenu() {
			((HMHShareHeaderPage) currentPage()).clickOnHelpMenu();
		}
		//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
		@Step("Click on Shared Files Option")
		public void clickOnReleaseNotes() {
			((HMHShareHeaderPage) currentPage()).clickOnReleaseNotes();
		}
		//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
		@Step("Click on Shared Files Option")
		public void clickOnKnowledgeBase() {
			((HMHShareHeaderPage) currentPage()).clickOnKnowledgeBase();
		}
		
		//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
		@Step("Click on Shared Files Option")
		public void verifyReleaseNotes(String asset) {
			((HMHShareHeaderPage) currentPage()).verifyReleaseNotes(asset);
		}
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **	
		@Step("Click on Checkbox to check the multiple objects")
		public void clickCheckBoxToAddToCart() {
			((HMHShareHeaderPage) currentPage()).clickCheckBoxToAddToCart();
		}
		// ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **	
		@Step("Click on Add to Standards cart Action on Document library page")
		public void clickAddToCartAction() {
			((HMHShareHeaderPage) currentPage()).clickAddToCartAction();
		}
		
		//** ALF- 2375 ** Search: Search content by standard text and code - UI Changes  ** Sprint 7.3.5 **
		@Step("Click on Standards Button")
		public void clickOnSearchByStandards() {
			 ((HMHShareHeaderPage) currentPage()).clickOnSearchByStandards();
		}
}
