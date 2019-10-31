package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.Publishing.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG063_ApplyMetadataToPSToReplicateAStructureK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG063_ApplyMetadataToPSToReplicateAStructureK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
	@Steps
	private SiteHeaderSteps siteHeaderSteps;
	@Steps
	private DocumentLibrarySteps documentLibrarySteps;
	@Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
	@Steps
	private DocumentDetailsSteps documentDetailsSteps;
	@Steps
	private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
	@Steps
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHShareHeaderSteps hmhShareHeaderSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	//
	@Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;


	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3,productType1,productType2,fileName1,fileName2,description="automation";
	int noOfLevels = 2; //level 2 tree structure
	String nameLabel = "Name";
	String gradeLabel = "Grade";
	String rightsLabel = "Publication Rights";
	String languageLabel = "Language";
	String versiontwo = "2.0";
	String cwOriginalcontentLabel = "CW Original Content(HMH Owned)";
	String IsPushed ="Is Pushed To Habitat?:";
	String objectName = ConstantsHMH.PREFIX_PRODUCTSET_NAME;
	String sbNameD=sbName+ConstantsHMH.TODAY_DATE;
	String ccoNameD=ccoName+ConstantsHMH.TODAY_DATE;
	String versionComment = "New Version";
	String textprogramLabel = "New Program Label";
	//path = ConstantsHMH.TC19_PATH;
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	@Override
	public void setPath(){
		path = ConstantsHMH.TC19_PATH;
	}


	@Test
	@WithTag(type="feature", name="publish")

	@Title("Test_REG063 - K-12: Apply Metadata to PS to Replicate a structure")
	public void test_REG063_ApplyMetadataToPSToReplicateAStructureInK12() {
	//ALF1406 - TC03_R6.1.1_ALF1406_ Valid Product set structure with CCOs inside SBs_Flag set as true
		
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);	
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		//
		shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.programLabel(textprogramLabel);
        hmhEditPropertiesSteps.checkDeliveryStructure(); //Delivery Structure Step
        editPropertiesDocumentSteps.saveButtonClick();
		//
        siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName); //level 3 tree structure
		//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
		//
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName1);
		hmhDocumentLibrarySteps.navBarClick(ccoName1);
		shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.productTypeDropDown(productType1);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
		//
        //
        siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName2);
		hmhDocumentLibrarySteps.navBarClick(ccoName2);
		shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.productTypeDropDown(productType2);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        //
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName1);
		//hmhDocumentLibrarySteps.navBarClick(ccoName);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName2);
		//hmhDocumentLibrarySteps.navBarClick(ccoName);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName2);
		//
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		// **Verify the Outgoing reference for product set      
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(sbName1);
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(sbName2);
		hmhDocumentLibrarySteps.refresh();
		// **Verify Version a product set functionality       
		hmhDocumentDetailsSteps.clickonVersion();
		
		//Version Pop up
		
		// **Verify Version pop up Cancel button
		hmhDocumentDetailsSteps.clickonVersioncancel();
		hmhDocumentDetailsSteps.clickonVersion();
		// **Enter comment
		hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
		// **Verify Version pop up Save button
		hmhDocumentDetailsSteps.clickonVersionsave();
		
		//
		
		//hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		//hmhDocumentDetailsSteps.clickgenerateSnapshot();
		siteHeaderSteps.customWait(50);
		hmhDocumentLibrarySteps.refresh();
		// **Publish to draft and publish to content functionality       
		//hmhDocumentDetailsSteps.publishToDraft();
		hmhDocumentDetailsSteps.publishToContent();
		
		siteHeaderSteps.customWait(50);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName1);
		hmhDocumentLibrarySteps.navBarClick(ccoName1);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.verifyDeliveryStructureValue(sbName1);
		siteHeaderSteps.customWait(50);
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName2);
		hmhDocumentLibrarySteps.navBarClick(ccoName2);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.verifyDeliveryStructureValue(sbName2);


	}
}
