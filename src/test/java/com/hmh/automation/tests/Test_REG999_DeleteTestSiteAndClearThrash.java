package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.pages.HMHAlfrescoServices;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.AbstractBaseSiteTestNew;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;


@Story(HMHApplication.DeleteTestSite.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG999_DeleteTestSiteAndClearThrash.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG999_DeleteTestSiteAndClearThrash extends AbstractBaseSiteTestNew {

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
	
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps HMHDocumentLibrarySteps;
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	
	String siteTypeTest;
	@Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

	@Test
	@Title("Test_REG999 - Delete Test Site And Clear Thrash")
	public void test_REG999_DeleteTestSiteAndClearThrash() {
		/****Using Search Site Option ****/	
		//		this.shareHeaderSteps.siteFinderButtonClick();
		//		this.hmhSiteFinderSteps.searchForASite2(this.siteName+ConstantsHMH.TODAY_DATE);
		//		this.siteFinderSteps.deleteSite(this.siteName+ConstantsHMH.TODAY_DATE, true);
		//		
		hmhSiteFinderSteps.searchAndDeleteSiteFromSiteManager(this.siteName+ConstantsHMH.TODAY_DATE);
		shareHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		
		
		if (HMHDocumentLibrarySteps.verifyFolderIsDisplayed("ProductSets")){
				
		documentLibrarySteps.checkIfAssetIsPresent(ProductSetsFolder);
		documentLibrarySteps.assetFromListClick("ProductSets");
		documentLibrarySteps.selectAllItems();
		shareHeaderSteps.customWait(3);
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		documentLibrarySteps.deleteItemsFromSelectedItemsClick();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		
		documentLibrarySteps.checkIfAssetIsPresent(ProductObjectsFolder);
		
		documentLibrarySteps.assetFromListClick("ProductObjects");
		documentLibrarySteps.selectAllItems();
		shareHeaderSteps.customWait(3);
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		documentLibrarySteps.deleteItemsFromSelectedItemsClick();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		
		documentLibrarySteps.checkIfAssetIsPresent(SequenceBundlesFolder);
		
		documentLibrarySteps.selectAllItems();
		shareHeaderSteps.customWait(3);
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		documentLibrarySteps.deleteItemsFromSelectedItemsClick();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		
		documentLibrarySteps.checkIfAssetIsPresent(LearningBundlesFolder);
		
		documentLibrarySteps.selectAllItems();
		shareHeaderSteps.customWait(3);
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		documentLibrarySteps.deleteItemsFromSelectedItemsClick();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
			
		documentLibrarySteps.checkIfAssetIsPresent(ContentObjectsFolder);
		
		documentLibrarySteps.selectAllItems();
		shareHeaderSteps.customWait(3);
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		documentLibrarySteps.deleteItemsFromSelectedItemsClick();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		
		documentLibrarySteps.checkIfAssetIsPresent(AssetsFolder);
		
		documentLibrarySteps.selectAllItems();
		shareHeaderSteps.customWait(3);
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		documentLibrarySteps.deleteItemsFromSelectedItemsClick();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		}
		
		
		/**** Using Site Manager ***/	
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.navigateToASpecificTool("Sites Manager");
		hmhSiteFinderSteps.searchAndDeleteSiteFromSiteManager(this.siteName+ConstantsHMH.TODAY_DATE);
		shareHeaderSteps.customWait(5);
		
	
		
		/**** using Alfresco API***/
//		this.hmhAlfrescoServicesSteps.deleteSite(this.siteName+ConstantsHMH.TODAY_DATE);
		this.shareHeaderSteps.myProfileButtonClick();
		this.myProfileSteps.trashcanMenuClick();
		this.userTrashcanSteps.emptyTrashcan();		
		this.shareHeaderSteps.homeButtonClick();
		// hmhSiteFinderSteps.verifySiteWasDeleted(this.siteName+ConstantsHMH.TODAY_DATE);

	}

}