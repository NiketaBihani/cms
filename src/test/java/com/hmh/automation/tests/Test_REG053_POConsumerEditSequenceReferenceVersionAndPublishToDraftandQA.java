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
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.Publishing.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG053_POConsumerEditSequenceReferenceVersionAndPublishToDraftandQAinConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG053_POConsumerEditSequenceReferenceVersionAndPublishToDraftandQA extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {
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
	private HMHDocumentDetailsSteps HMHDocumentDetailsSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private HMHSequenceViewSteps hmhSequenceViewSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;


	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle, newType,
	cloPubRights, siteTypeTest, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3;
	int noOfLevels = 2; //level 2 tree structure
	String nameLabel = "Name";
	String gradeLabel = "Grade";
	String rightsLabel = "Publication Rights";
	String languageLabel = "Language";
	String cwOriginalcontentLabel = "CW Original Content(HMH Owned)";
	String IsPushed ="Is Pushed To Habitat?:";
	String objectName = ConstantsHMH.PREFIX_PRODUCTOBJECT_NAME;
	String versionComment = "New Version";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}


	@Test
	@WithTag(type="feature", name="publish")

	@Title("Test_REG053 - Product Object Consumer: EditSequence, Reference, Versioning And PublishToDraft and Publish to QA")
	public void test_REG053_POConsumerEditSequenceReferenceVersionAndPublishToDraftandQAinConsumer() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);	
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductObject(objectName, year, title);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);

		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName); //level 3 tree structure
		//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
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
		
		// ** Enter Comment
		hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
		// **Verify Version pop up Save button
		hmhDocumentDetailsSteps.clickonVersionsave();
						
		//
		
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		//hmhDocumentDetailsSteps.clickgenerateSnapshot();
		siteHeaderSteps.customWait(50);
		hmhDocumentLibrarySteps.refresh();
		// **Publish to draft and publish to QA functionality       
		hmhDocumentDetailsSteps.publishToDraft();
		hmhDocumentDetailsSteps.publishToQA();
		shareHeaderSteps.sharedFilesButtonClick();
		hmhDocumentLibrarySteps.assetFromListClick("Draft Common Cartridge Manifest");
		siteHeaderSteps.customWait(5);
		hmhDocumentLibrarySteps.verifyUsernameAndTimeForAsset(ConstantsHMH.ALFRESCO_DISPLAY_NAME, "just now");	// validation of Publish to Draft functionality    	

		/*
		//  ** verify Incoming References for SB in document Details Page
		siteHeaderSteps.goBack();
		siteHeaderSteps.customWait(3);
		siteHeaderSteps.goBack();
		siteHeaderSteps.customWait(3);
		siteHeaderSteps.clickOnDocumentLibraryButton(); 
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1);
		hmhDocumentLibrarySteps.navBarClick(sbName1);
		//  ** verify Incoming References for SB in document Details Page   	
		//	hmhDocumentDetailsSteps.checkIfIncomingReferenceWasAdded(objectName);
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(objectName);
		hmhDocumentDetailsSteps.closeReferenceDailog();
		//  ** verify OutGoing References for SB in document Details Page
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(ccoName1);
		//  ** Delete Outgoing References for SB in document Details Page
		hmhDocumentDetailsSteps.deleteReference(ccoName1);
		//  ** Delete Incoming References for SB in document Details Page
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		hmhDocumentDetailsSteps.deleteReference(objectName);

		siteHeaderSteps.clickOnDocumentLibraryButton(); 
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName2);
		hmhDocumentLibrarySteps.navBarClick(sbName2);
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		//  ** Delete Outgoing References for SB in document Details Page
		hmhDocumentDetailsSteps.deleteReference(ccoName2);
		//  ** Delete Incoming References for SB in document Details Page
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(objectName);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		*/    	
	}
}
