package com.hmh.automation.tests;


import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.pages.HMHAlfrescoServices;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.AbstractBaseSiteTestHIP;
//import com.hmh.automation.tools.AbstractBaseSiteTestNew;
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

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;


@Story(HMHApplication.DeleteTestSite.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG98_DeleteTestSiteAndClearThrash.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_098_Delete_Reference_Objects extends AbstractBaseSiteTestHIP {

	
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
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
	private SiteHeaderSteps siteHeaderSteps;
	
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	
	
	

	String siteType,ContentObjectsFolder,SiteManager,LearningBundlesFolder,AssetsFolder,SequenceBundlesFolder,ProductObjectsFolder,ProductSetsFolder,ProgramsFolder;
	String siteTypeAsset="Asset Management Site";
	@Override
    public void setSiteType() {
        siteType = this.siteType;
    }

	@Test
	@Title("Test_098_Delete_Reference_Objects")
	public void test_098_Delete_Reference_Objects() {
		
		/**** Using Site Manager ***/	
		if(siteType.contentEquals(siteTypeAsset))
		{
			shareHeaderSteps.customWait(8); 
			documentLibrarySteps.selectAllItems();
			shareHeaderSteps.customWait(3);
			hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
			
		}
		else
		{
			
		
		documentLibrarySteps.assetFromListClick(ProductSetsFolder);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.selectAllItems();
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		documentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.selectAllItems();
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		documentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.selectAllItems();
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		documentLibrarySteps.assetFromListClick(LearningBundlesFolder);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.selectAllItems();
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		documentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.selectAllItems();
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		documentLibrarySteps.assetFromListClick(AssetsFolder);
		shareHeaderSteps.customWait(5);
		documentLibrarySteps.selectAllItems();
		hmhSequenceViewSteps.checkSelectedItemsEnabledAndDelete();
		shareHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(3);
		}
		shareHeaderSteps.adminToolsButtonClick();
		adminToolsNavigationSteps.navigateToASpecificTool(SiteManager);
		hmhSiteFinderSteps.searchAndDeleteSiteFromSiteManager(this.siteName);
			shareHeaderSteps.customWait(5);
			//Changes Start
			hmhSiteFinderSteps.verifySiteWasDeleted(this.siteName);
		
		
		//Changes End
		/**** using Alfresco API***/
   //  this.hmhAlfrescoServicesSteps.deleteSite(this.siteName+ConstantsHMH.TODAY_DATE);
		this.shareHeaderSteps.myProfileButtonClick();
		this.myProfileSteps.trashcanMenuClick();
		this.userTrashcanSteps.emptyTrashcan();		
		this.shareHeaderSteps.homeButtonClick();
		hmhSiteFinderSteps.verifySiteWasDeleted(this.siteName);

		
		
	
	
	}
}