package com.hmh.automation.tools;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.StepEventBus;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.pages.HMHSetupPage;
import com.hmh.automation.pages.HMHShareHeaderPage;
import com.hmh.automation.pages.HMHSiteFinderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteHeaderPage;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractBaseSiteTestAssetManagement {

	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTestAssetManagement.class);
	@Managed(uniqueSession = false)  //old value is ""false"
	public WebDriver driver;

//	@ManagedPages(defaultUrl = "https://alfresco.demo.ixxus.co.uk:8443/share/page/")
	@ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
	
	public Pages pages;
	protected String siteType, path;
	public String siteName, AssetsFolder, ContentObjectsFolder, LearningBundlesFolder,
			SequenceBundlesFolder, ProductObjectsFolder, ProductSetsFolder, ProgramsFolder;
	public boolean siteFound = true;
	public boolean isFoldersFound = true;
	public boolean isListPresent = false;
	
	public void setSiteType() {
		this.siteType = null;
	}
	
	public void setPath() {
		this.path = null;
	}

	@Before
	public void setup() {
			setPath();
			String downloadsPath= System.getProperty("user.dir");
	        downloadsPath=downloadsPath+path;
//	        System.out.println(downloadsPath);
	        downloadsPath=downloadsPath.replace("\\", "\\");
	        FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("browser.download.folderList", 2);
	        profile.setPreference("browser.download.manager.showWhenStarting", false);
	        profile.setPreference("browser.download.dir", downloadsPath);
	        profile.setPreference("browser.helperApps.neverAsk.openFile","application/json");
	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/json");
			Serenity.useFirefoxProfile(profile);
			setSiteType();
		((LoginPage) this.pages.currentPageAt(LoginPage.class)).login(
				ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		LOG.info("Done: login");
		this.siteFound = ((HMHSiteFinderPage) this.pages
				.currentPageAt(HMHSiteFinderPage.class))
				.searchUserSites(this.siteName + ConstantsHMH.TODAY_DATE);
		LOG.info("Done: searchForUserSite" + this.siteName
				+ ConstantsHMH.TODAY_DATE);

		if (this.siteFound == false) {
			((HMHShareHeaderPage) this.pages
					.currentPageAt(HMHShareHeaderPage.class))
					.createNewSiteWithSiteType(this.siteName
							+ ConstantsHMH.TODAY_DATE, this.siteType);
			LOG.info("Done: create New Site  " + this.siteName
					+ ConstantsHMH.TODAY_DATE + " " + this.siteType);
			((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class))
					.clickOnDocumentLibraryButton();
			LOG.info("Done: clickOnDocumentLibraryButton");

		} else {

			LOG.info("Done: SiteFound");
			((HMHSiteFinderPage) this.pages
					.currentPageAt(HMHSiteFinderPage.class))
					.openTheUserSiteFound(this.siteName
							+ ConstantsHMH.TODAY_DATE);

			LOG.info("Done: OpenTheSiteFound " + siteName
					+ ConstantsHMH.TODAY_DATE + " " + this.siteType);
			((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class))
					.clickOnDocumentLibraryButton();
			LOG.info("Done: clickOnDocumentLibraryButton");
		}
		
		/*((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class)).clickOnDocumentLibraryButton();
		this.isFoldersFound = ((HMHDocumentLibraryPage) this.pages
				.currentPageAt(HMHDocumentLibraryPage.class)).checkIfAutoCreatedFoldersArePresent();
		LOG.info("Done: Auto Created Folders Status: "+isFoldersFound);
		if (isFoldersFound == false) {
			((HMHDocumentLibraryPage) this.pages
					.currentPageAt(HMHDocumentLibraryPage.class)).createFoldersLikeAutoCreatedFolders();
			LOG.info("Done: Auto Created like Folders are created successfully ");
		}*/
	}

	@After
	public void tearDown() {
		StepEventBus.getEventBus().clearStepFailures();
		LOG.info("Done: clearStepFailures");
		((HMHSetupPage) this.pages.currentPageAt(HMHSetupPage.class))
				.logoutButtonClick();
		LOG.info("Done: logoutButtonClick");
	}

}