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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG088_K12_Set_Delivary_Location.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG088_K12_Set_Delivary_Location extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	String siteTypeTest, type, userRole, objectNameOld, assetName, folderName2, folderType,versionComment, productType, coName, year, grade,sbName, ccoName, versionType, comment, level1, numbering1, markets, title, Asset,ContentObject, jpeg1, image;
	String textprogramLabel = "programlbl";
	String objectName = "TC088"+ConstantsHMH.PREFIX_PRODUCTSET_NAME;
	//String elementCopytable="div[id*='copyMoveTo']>div>div>div>div:nth-child(2)>div>table>tbody>tr>td[id*='content']>span:nth-child(1)";
	//String copy = "Copy of ";
	

	//String jpeg1=ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH;
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	
	@Test
	@Title("Test_REG088_K12_Set_Delivary_Location")
	public void test_REG088_K12_Set_Delivary_Location() {
		
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);	
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.programLabel(textprogramLabel);
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevelsForManifest(noOfLevels, objectName, sbName, ccoName, coName, assetName);
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSub(ccoName);
		hmhDocumentLibrarySteps.navBarClick(ccoName);
		hmhDocumentLibrarySteps.verifyTargetDeliveryLoc();
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.productTypeDropDown(productType);
		hmhEditPropertiesSteps.userRoleDropDown(userRole);
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSubCO(coName);
		hmhDocumentLibrarySteps.verifyTargetDeliveryLoc();
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.productTypeDropDown(productType);
		hmhEditPropertiesSteps.userRoleDropDown(userRole);
		editPropertiesDocumentSteps.saveButtonClick(); 
		siteHeaderSteps.customWait(5);
		documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + image);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        hmhDocumentLibrarySteps.refreshToExitPopup();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(Asset);
		hmhDocumentLibrarySteps.assetFromListClickSub(assetName);
		hmhDocumentLibrarySteps.verifyTargetDeliveryLoc();
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.productTypeDropDown(productType);
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.customWait(5);
		documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + jpeg1);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.refreshToExitPopup();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentLibrarySteps.verifySetDeliveryLoc();
		siteHeaderSteps.customWait(10);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSubCO(coName);
		hmhDocumentLibrarySteps.afterSetverifyTargetDeliveryLoc();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSub(ccoName);
		hmhDocumentLibrarySteps.navBarClick(ccoName);
		hmhDocumentLibrarySteps.afterSetverifyTargetDeliveryLoc();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClick(Asset);
		hmhDocumentLibrarySteps.assetFromListClickSub(assetName);
		hmhDocumentLibrarySteps.afterSetverifyTargetDeliveryLoc();
		
		
		
}
}