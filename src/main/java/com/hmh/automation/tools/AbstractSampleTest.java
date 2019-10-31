package com.hmh.automation.tools;

import java.util.Hashtable;
import java.util.Map;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.pages.HMHDocumentLibraryPage;
import com.hmh.automation.pages.HMHSetupPage;
import com.hmh.automation.pages.HMHShareHeaderPage;
import com.hmh.automation.pages.HMHSiteFinderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteHeaderPage;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractSampleTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractSampleTest.class);
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

	public String siteSearch= "HABITAT_SITE" + ConstantsHMH.TODAY_DATE;
	public String habSiteNameReg=ConstantsHMH.REG_HABITAT_SITE_NAME+ConstantsHMH.TODAY_DATE;
	
	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","D:\\LatestCode01June\\webdrivers\\chromedriver.exe");
		
		
		setPath();
		/*String downloadsPath= System.getProperty("user.dir");
        downloadsPath=downloadsPath+path;
//       System.out.println(downloadsPath);
        downloadsPath=downloadsPath.replace("\\", "\\");
        
       
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", downloadsPath);
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/xml");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/xml");
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/json");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/json");
        profile.setPreference("browser.helperApps.neverAsk.openFile","application/xlsx");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/xlsx");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/xls;text/csv");
		Serenity.useFirefoxProfile(profile);*/
		
		
		/*Object Capabilities = DesiredCapabilities.chrome();

		ChromeOptions chromeOptions = new ChromeOptions();
		
		chromeOptions.AddUserProfilePreference("download.default_directory", downloadsPath);
		chromeOptions.AddUserProfilePreference("intl.accept_languages", "nl");
		chromeOptions.AddUserProfilePreference("disable-popup-blocking", "true");

		return new ChromeDriver(chromeDriverPath, chromeOptions);

		IWebDriver driver = new RemoteWebDriver(new Uri("http://path/to/selenium/server"), chromeOptions.ToCapabilities());*/
		String downloadFilepath = "D:\\LatestCode01June\\downloads";
		Map<String, Object> preferences = new Hashtable<String, Object>();
		preferences.put("profile.default_content_settings.popups", 0);
		preferences.put("download.prompt_for_download", "false");
		preferences.put("download.default_directory", downloadFilepath);

		// disable flash and the PDF viewer
		preferences.put("plugins.plugins_disabled", new String[]{
		    "Adobe Flash Player", "Chrome PDF Viewer"});

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		
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
		
		((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class)).clickOnDocumentLibraryButton();
		this.isFoldersFound = ((HMHDocumentLibraryPage) this.pages
				.currentPageAt(HMHDocumentLibraryPage.class)).checkIfAutoCreatedFoldersArePresent();
		LOG.info("Done: Auto Created Folders Status: "+isFoldersFound);
		if (isFoldersFound == false) {
			((HMHDocumentLibraryPage) this.pages
					.currentPageAt(HMHDocumentLibraryPage.class)).createFoldersLikeAutoCreatedFolders();
			LOG.info("Done: Auto Created like Folders are created successfully ");
		}
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