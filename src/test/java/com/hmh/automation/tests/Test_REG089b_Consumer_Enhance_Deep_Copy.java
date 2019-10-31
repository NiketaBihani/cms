package com.hmh.automation.tests;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.steps.InklingHabitatSiteSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.Publishing.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG089b_Consumer_Enhance_Deep_Copy.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG089b_Consumer_Enhance_Deep_Copy extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {

	@Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private LoginSteps loginSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHDataListsSteps hmhDataListsSteps;
	@Steps
	private SiteDashboardSteps siteDashboardSteps;
	@Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
	@Steps
	private InklingHabitatSiteSteps inklingHabitatSiteSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	int noOfLevels = 1;
	String siteTypeTest, type, assetName, objectNameOld, productType, coName, year, grade,sbName, ccoName, versionType, comment, level1, numbering1, markets, title, Asset,ContentObject;
	
	String objectName = "TC089b" +ConstantsHMH.PREFIX_PRODUCTSET_NAME;
	
	

	//String jpeg1=ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH;
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	
	@Test
	@Title("Test_REG089b_Consumer_Enhance_Deep_Copy")
	public void test_REG089b_Consumer_Enhance_Deep_Copy() {
		
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);	
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductObject(objectName, year, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevelsForManifest(noOfLevels, objectName, sbName, ccoName, coName, assetName);
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentLibrarySteps.deepCopyTo(siteName + ConstantsHMH.TODAY_DATE);
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClickSub("EDC"+objectName);
		hmhDocumentLibrarySteps.navBarClick("EDC"+objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.verifyObjInEditSequenceforEnhanceDeepCopy(objectName, sbName, ccoName, coName, assetName);
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClickSub("EDC"+objectName);
		hmhDocumentLibrarySteps.navBarClick("EDC"+objectName);
		hmhDocumentLibrarySteps.enhDeepCopySearchReplace(siteName + ConstantsHMH.TODAY_DATE);
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClickSub("Replace"+objectName);
		hmhDocumentLibrarySteps.navBarClick("Replace"+objectName);
		siteHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton();
					
	}
	
}