package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.pages.HMHAlfrescoServices;
import com.hmh.automation.pages.HMHSiteFinderPage;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.AbstractBaseSiteTestNew;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;


@Story(HMHApplication.DeleteTestSite.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_Reg099_DeleteCreatedSite.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_Reg000099_DeleteCreatedSite extends AbstractBaseSiteTestNew {

	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private MyProfileSteps myProfileSteps;
	@Steps
	private UserTrashcanSteps userTrashcanSteps;
	@Steps
	private LoginSteps loginSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
	@Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
	@Steps
	private HMHAlfrescoServices hmhAlfrescoServicesSteps;
	//
	@Steps
	private HMHSiteFinderPage hmhSiteFinderPage;
	@Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
    private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	
	
	public String name,userSiteList,navBarClick,refresh,fileName,AssetsFolder, ContentObjectsFolder, LearningBundlesFolder,
	SequenceBundlesFolder, ProductObjectsFolder, ProductSetsFolder, ProgramsFolder;
	boolean isSiteFound;

	String siteTypeTest;
	@Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

	@Test
	@Title("Test_REG099 - Delete Created Site")
	public void test_REG099_DeleteCreatedSite() {
		/****Using Search Site Option ****/	
		//		this.shareHeaderSteps.siteFinderButtonClick();
		//		this.hmhSiteFinderSteps.searchForASite2(this.siteName+ConstantsHMH.TODAY_DATE);
		//		this.siteFinderSteps.deleteSite(this.siteName+ConstantsHMH.TODAY_DATE, true);
		//		
		/**** Using Site Manager ***/	
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.navigateToASpecificTool("Sites Manager");
		hmhSiteFinderSteps.searchAndDeleteSiteFromSiteManager(this.siteName+ConstantsHMH.TODAY_DATE);
		shareHeaderSteps.customWait(5);
		//Changes Start
		hmhSiteFinderSteps.verifySiteWasDeleted(this.siteName+ConstantsHMH.TODAY_DATE);
		
		//Delete references
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(LearningBundlesFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       
	       
           
		
		//Changes End
		/**** using Alfresco API***/
        this.hmhAlfrescoServicesSteps.deleteSite(this.siteName+ConstantsHMH.TODAY_DATE);
		this.shareHeaderSteps.myProfileButtonClick();
		this.myProfileSteps.trashcanMenuClick();
		this.userTrashcanSteps.emptyTrashcan();		
		this.shareHeaderSteps.homeButtonClick();
		hmhSiteFinderSteps.verifySiteWasDeleted(this.siteName+ConstantsHMH.TODAY_DATE);

	}
}
