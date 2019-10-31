package com.hmh.automation.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

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
public abstract class AbstractHabitatBVT {
	

	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTestNew.class);

	@Managed(uniqueSession = false, driver="chrome")  //old value is ""false"  driver="chrome"
	public WebDriver driver;

	@ManagedPages(defaultUrl = "http://10.34.36.46:8080/share/page")

	public Pages pages;
	protected String siteType;
	public String siteName, AssetsFolder, ContentObjectsFolder, LearningBundlesFolder,
	SequenceBundlesFolder, ProductObjectsFolder, ProductSetsFolder, ProgramsFolder;
	public boolean siteFound=true;
	public boolean isFoldersFound = true;
	
	public void setSiteType() {
		this.siteType = null;
	}

	
	public String habSiteName=ConstantsHMH.HABITAT_SITE_NAME+ConstantsHMH.TODAY_DATE;

	@Before
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\chromedriver\\chromedriver.exe");
	setSiteType();
		((LoginPage) this.pages.currentPageAt(LoginPage.class)).loginChrome(
				ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
		LOG.info("Done: login");
		
		this.siteFound=((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class)).searchUserSites(habSiteName);
		LOG.info("Done: searchForUserSite");

		if (this.siteFound==false){
			
			((HMHShareHeaderPage) this.pages
					.currentPageAt(HMHShareHeaderPage.class)).createNewSiteWithSiteType(habSiteName, this.siteType); //K-12 site
			LOG.info("Done: create New Site  " +habSiteName +" " +this.siteType);
		}
		else {
			
		LOG.info("Done: SiteFound");
		((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class))
		.openTheUserSiteFound(habSiteName);
		
		LOG.info("Done: OpenTheUserSiteFound " +habSiteName +" " +this.siteType);
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
		/*	StepEventBus.getEventBus().clearStepFailures();
		LOG.info("Done: clearStepFailures");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class)).adminToolsButtonClick();
		LOG.info("Done: adminToolsButtonClick");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class)).customWait(3);
	//	((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class)).clickOnSiteMangerLink();
		((AdminToolsNavigationPage)  this.pages.currentPageAt(AdminToolsNavigationPage.class)).navigateToASpecificTool("Sites Manager");
		LOG.info("Done: navigate To Sites Manager");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class)).customWait(3);
		((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class)).searchAndDeleteSiteFromSiteManager(habSiteName);
		LOG.info("Done: From Site manager, search And Delete Site");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class)).customWait(3);
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
			.myProfileButtonClick();
		LOG.info("Done: myProfileButtonClick");
		((MyProfilePage) this.pages.currentPageAt(MyProfilePage.class))
			.trashcanMenuClick();
		LOG.info("Done: trashcanMenuClick");
		((UserTrashcanPage) this.pages.currentPageAt(UserTrashcanPage.class))
			.emptyTrashcan();
		LOG.info("Done: emptyTrashcan");*/
//		
		((HMHSetupPage) this.pages.currentPageAt(HMHSetupPage.class))
				.logoutButtonClick();
		LOG.info("Done: logoutButtonClick");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String todaysDateHour() {
		DateFormat dateFormat = new SimpleDateFormat("haMMddyyyyz"); //Wed Dec 16 12:21:19 IST 2015  ****("MMddyyyyz")
		Date date = new Date();
		String todayDateHour= dateFormat.format(date); //12/16/2015
		return todayDateHour;
	}
}







//((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
//.siteFinderButton();
//LOG.info("Done: siteFinderButton");
//((HMHSiteFinderPage) this.pages.currentPageAt(HMHSiteFinderPage.class))
//		.searchForASite(this.siteName+todaydate() );
//LOG.info("Done: searchForASite");
//((SiteFinderPage) this.pages.currentPageAt(SiteFinderPage.class))
//		.deleteSite(this.siteName+todaydate(), false);
//LOG.info("Done: deleteSite");
//((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
//		.myProfileButtonClick();
//LOG.info("Done: myProfileButtonClick");
//((MyProfilePage) this.pages.currentPageAt(MyProfilePage.class))
//		.trashcanMenuClick();
//LOG.info("Done: trashcanMenuClick");
//((UserTrashcanPage) this.pages.currentPageAt(UserTrashcanPage.class))
//		.emptyTrashcan();
//LOG.info("Done: emptyTrashcan");
