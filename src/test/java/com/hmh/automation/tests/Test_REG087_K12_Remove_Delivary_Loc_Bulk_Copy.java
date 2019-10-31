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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG087_K12_Remove_Delivary_Loc_Bulk_Copy.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG087_K12_Remove_Delivary_Loc_Bulk_Copy extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {

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
	String siteTypeTest, type, userRole, assetName, folderName2, folderType,versionComment, productType, coName, year, grade,sbName, ccoName, versionType, comment, level1, numbering1, markets, title, Asset,ContentObject, jpeg1, image;
	String textprogramLabel = "programlabel";
	String objectName = "tc087"+ConstantsHMH.PREFIX_PRODUCTSET_NAME;
	String elementCopytable="div[id*='copyMoveTo']>div>div>div>div:nth-child(2)>div>table>tbody>tr>td[id*='content']>span:nth-child(1)";
	String copy = "Copy of ";
	

	//String jpeg1=ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH;
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	
	@Test
	@Title("Test_REG087_K12_Remove_Delivary_Loc_Bulk_Copy")
	public void test_REG087_K12_Remove_Delivary_Loc_Bulk_Copy() {
		
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
		siteHeaderSteps.customWait(5);
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.clickEditSequence();
		siteHeaderSteps.customWait(10);
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		siteHeaderSteps.customWait(5);
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevelsForManifest(noOfLevels, objectName, sbName, ccoName, coName, assetName);
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(Asset);
		hmhDocumentLibrarySteps.assetFromListClickSub(assetName+noOfLevels);
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.productTypeDropDown(productType);
		//hmhSequenceViewSteps.saveButtonClick();
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSubCO(coName+noOfLevels);
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.productTypeDropDown(productType);
		hmhEditPropertiesSteps.userRoleDropDown(userRole);
		//hmhSequenceViewSteps.saveButtonClick();
		editPropertiesDocumentSteps.saveButtonClick(); 
		siteHeaderSteps.customWait(5);
		documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + image);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        hmhDocumentLibrarySteps.refreshToExitPopup();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSub(ccoName+noOfLevels);
		hmhDocumentLibrarySteps.navBarClick(ccoName+noOfLevels);
		hmhEditPropertiesSteps.editPropClick();
		hmhEditPropertiesSteps.productTypeDropDown(productType);
		hmhEditPropertiesSteps.userRoleDropDown(userRole);
		//hmhSequenceViewSteps.saveButtonClick();
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(Asset);
		hmhDocumentLibrarySteps.assetFromListClickSub(assetName+noOfLevels);
		documentDetailsSteps.uploadNewVersionButtonDocumentActionsClick();
        documentLibrarySteps.uploadNewVersionDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + jpeg1);
        documentLibrarySteps.selectTheVersionAndAddCommentForTheNewUploadedFile(versionType, comment);
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickonVersion();
		hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
		hmhDocumentDetailsSteps.clickonVersionsave();
		siteHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.publishToContent();
		siteHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSub(ccoName+noOfLevels);
		hmhDocumentLibrarySteps.navBarClick(ccoName+noOfLevels);
		hmhDocumentLibrarySteps.verifyDeliveryLoc();
		hmhDocumentLibrarySteps.clickCopyTo();
		hmhShareHeaderSteps.waitForElement(elementCopytable, 200);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectPathToCopy(ContentObject);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.confirmCopyButtonClick();
        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSubCO(coName+noOfLevels);
		hmhDocumentLibrarySteps.verifyDeliveryLoc();
		hmhDocumentLibrarySteps.clickCopyTo();
		hmhShareHeaderSteps.waitForElement(elementCopytable, 200);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectPathToCopy(ContentObject);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.confirmCopyButtonClick();
        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(Asset);
		hmhDocumentLibrarySteps.assetFromListClickSub(assetName+noOfLevels);
		hmhDocumentLibrarySteps.verifyDeliveryLoc();
		hmhDocumentLibrarySteps.clickCopyTo();
		hmhShareHeaderSteps.waitForElement(elementCopytable, 200);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectPathToCopy(Asset);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.confirmCopyButtonClick();
        shareHeaderSteps.customWait(5);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		hmhDocumentLibrarySteps.assetFromListClickSubCO(copy+coName+noOfLevels);
		hmhDocumentLibrarySteps.verifyDeliveryLoc();//Delivery location should not be available or displayed
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObject);
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClickSub(copy+ccoName+noOfLevels);
		hmhDocumentLibrarySteps.navBarClick(copy+ccoName+noOfLevels);
		hmhDocumentLibrarySteps.verifyDeliveryLoc();//Delivery location should not be available or displayed
		siteHeaderSteps.clickOnDocumentLibraryButton();
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.assetFromListClick(Asset);
		siteHeaderSteps.customWait(3);
		hmhDocumentLibrarySteps.assetFromListClickSub(copy+assetName+noOfLevels);
		hmhDocumentLibrarySteps.verifyDeliveryLoc();
		siteHeaderSteps.clickOnDocumentLibraryButton();
			
	}
	
}
