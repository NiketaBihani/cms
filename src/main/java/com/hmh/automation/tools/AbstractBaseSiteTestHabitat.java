package com.hmh.automation.tools;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.pages.HMHDocumentLibraryPage;
import com.hmh.automation.pages.HMHSetupPage;
import com.hmh.automation.pages.HMHShareHeaderPage;
import com.hmh.automation.pages.HMHSiteFinderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteHeaderPage;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractBaseSiteTestHabitat {
	
//	public AbstractBaseSiteTest1(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}

	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTestNew.class);

	//@Managed(uniqueSession = false, driver="IE")  //old value is ""false"  driver="chrome"
	@Managed(uniqueSession = false,driver="chrome")
	public WebDriver driver;


	@ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
	
	public Pages pages;
	protected String siteType;
	public String siteName, AssetsFolder, ContentObjectsFolder, LearningBundlesFolder,
	SequenceBundlesFolder, ProductObjectsFolder, ProductSetsFolder, ProgramsFolder;
	public boolean siteFound = true;
	public boolean isFoldersFound = true;
	public boolean isListPresent=false;
	public void setSiteType() {
		this.siteType = null;
	}
	
	public String habSiteNameReg=ConstantsHMH.REG_HABITAT_SITE_NAME+ConstantsHMH.TODAY_DATE;

	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","D:\\LatestCode01June\\webdrivers\\chromedriver.exe");
		
		
	setSiteType();

	
	
		((LoginPage) this.pages.currentPageAt(LoginPage.class)).loginChrome(
				ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		LOG.info("Done: login");
		
		this.siteFound=((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class)).searchUserSites(habSiteNameReg);
		LOG.info("Done: searchForUserSite");
		if (this.siteFound==false){
			((HMHShareHeaderPage) this.pages
					.currentPageAt(HMHShareHeaderPage.class)).createNewSiteWithSiteType(habSiteNameReg, this.siteType); //K-12 site
			LOG.info("Done: create New Site  " +habSiteNameReg +" " +this.siteType);
		}
		else {
			
		LOG.info("Done: SiteFound");
		((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class))
		.openTheUserSiteFound(habSiteNameReg);
		
		LOG.info("Done: OpenTheUserSiteFound " +habSiteNameReg +" " +this.siteType);
		}
		
		((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class))
				.clickOnDocumentLibraryButton();
		LOG.info("Done: clickOnDocumentLibraryButton");
		
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
