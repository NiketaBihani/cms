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
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;


@Story(HMHApplication.Publishing.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG020_EditSequenceReferenceVersionAndPublishToDraftandQAinConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG062_ManifestValidationInConsumerSite extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {
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


	   String  type, objectName, title, label1, numbering2, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
       cloPubRights, siteTypeTest, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3;
	    int noOfLevels = 2; //level 2 tree structure
	    String nameLabel = "Name";
	    String gradeLabel = "Grade";
	    String rightsLabel = "Publication Rights";
	    String languageLabel = "Language";
	    String versiontwo = "2.0";

	    String IsPushed ="Is Pushed To Habitat?:";
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	@Override
	public void setPath(){
		path = ConstantsHMH.TC61_PATH;
	}


	@Test
	@WithTag(type="feature", name="manifest")

	@Title("Test_REG061 - Manifest Validation In K12 site with and without product type")
	public void test_REG061_ManifestValidationInK12site() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);	
    	documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering2, markets, title);
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);
        
        hmhDocumentDetailsSteps.clickEditSequence();
        hmhSequenceViewSteps.checkIfOnSequenceViewPage();
        hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
        hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName); //level 3 tree structure
        //hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);
        // **Verify the Outgoing reference for product set      
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        siteHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(sbName1);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(sbName2);
        hmhDocumentLibrarySteps.refresh();
        // **Verify Version a product set functionality       
        hmhDocumentDetailsSteps.clickonVersion();
        hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
        hmhDocumentDetailsSteps.clickgenerateSnapshot();
        siteHeaderSteps.customWait(50);
        hmhDocumentLibrarySteps.refresh();
        // **Publish to draft and publish to QA functionality       
        hmhDocumentDetailsSteps.publishToDraft();
        hmhDocumentDetailsSteps.publishToContent();
        String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
        shareHeaderSteps.sharedFilesButtonClick();
        hmhDocumentLibrarySteps.assetFromListClick("Draft Common Cartridge Manifest");
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.verifyUsernameAndTimeForAsset(ConstantsHMH.ALFRESCO_DISPLAY_NAME, "just now");	// validation of Publish to Draft functionality    	
        hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		hmhDocumentDetailsSteps.saveTheManifestFile();
		hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", objectName);
		hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", versiontwo);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", versiontwo);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "metadata", sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:lom", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:lom", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:general", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:general", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:title", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:title", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:version", versiontwo);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", sbName2);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "item", label1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "item", label1+" "+"2"+" "+sbName2);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", sbName2);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", sbName2);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", ccoName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", ccoName);
    	
		//  ** verify Incoming References for SB in document Details Page
		siteHeaderSteps.refreshPage();
    	siteHeaderSteps.clickOnDocumentLibraryButton(); 
    	hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
    	hmhDocumentLibrarySteps.assetFromListClick(sbName1);
    	hmhDocumentLibrarySteps.navBarClick(sbName1);
    	//  ** verify Incoming References for SB in document Details Page   	
    	hmhDocumentDetailsSteps.checkIfIncomingReferenceWasAdded(objectName);
    	//  ** verify OutGoing References for SB in document Details Page
    	hmhDocumentDetailsSteps.outgoingReferencesClick();
    	siteHeaderSteps.customWait(3);
    	hmhDocumentDetailsSteps.checkIfReferenceWasAdded(ccoName1);
    	//  ** Delete Outgoing References for SB in document Details Page
    	hmhDocumentDetailsSteps.deleteReference(ccoName1);
    	//  ** Delete Incoming References for SB in document Details Page
    	hmhDocumentDetailsSteps.clickOnManageReferenceLink();
    	siteHeaderSteps.customWait(3);
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


	}
}
