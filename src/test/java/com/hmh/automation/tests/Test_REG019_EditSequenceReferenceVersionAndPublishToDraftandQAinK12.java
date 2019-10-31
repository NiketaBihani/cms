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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG019_EditSequenceReferenceVersionAndPublishToDraftandQAinK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG019_EditSequenceReferenceVersionAndPublishToDraftandQAinK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {
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
	


	String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, pushed, versionTwo,versionThree, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3;
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
	//String path = ConstantsHMH.TC19_PATH;
	String textprogramLabel = "newprogramlabel";
	
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

	@Title("Test_REG019 - K-12: EditSequence, Reference, Versioning And PublishToDraft and Publish to QA")
	public void test_REG019_EditSequenceReferenceVersionAndPublishToDraftandQAinK12() {

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
        hmhEditPropertiesSteps.saveButtonClick(); 
        siteHeaderSteps.customWait(5);
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
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(sbName1);
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(sbName2);
		hmhDocumentLibrarySteps.refresh();
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		shareHeaderSteps.customWait(5);  
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(5);        


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
		siteHeaderSteps.customWait(10);
		//hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
	/// **** FIX *** Move to Page for enhancements
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated("");
		//hmhDocumentDetailsSteps.clickgenerateSnapshot();
		siteHeaderSteps.customWait(50);
		hmhDocumentLibrarySteps.refresh();
		// **Publish to draft and publish to content functionality       
		hmhDocumentDetailsSteps.publishToDraft();
		//hmhDocumentDetailsSteps.publishToContent();
		//hmhDocumentDetailsSteps.publishToManifest();
		
		String currentOneCMSURL = hmhShareHeaderSteps.getCurrentURLasString();
		System.out.println(currentOneCMSURL);
		shareHeaderSteps.sharedFilesButtonClick();
		hmhDocumentLibrarySteps.assetFromListClick("Draft Common Cartridge Manifest");
		siteHeaderSteps.customWait(5);
		//hmhDocumentLibrarySteps.verifyUsernameAndTimeForAsset(ConstantsHMH.ALFRESCO_DISPLAY_NAME, "just now");	// validation of Publish to Draft functionality  		   	
		// Fix provided to validate Time stamp aspect on manifest folder on 20th Aug 2018
		String a[] = hmhDocumentDetailsSteps.verifyAspectOnAssetFolder();
		hmhDocumentLibrarySteps.assetFromListClickSubCO(a[0]);
		hmhDocumentLibrarySteps.assetFromListClickSubCO(a[1]);		
		hmhDocumentLibrarySteps.assetFromListClickSubCO(a[2]);
		hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL);
		
		
		
		//**Validate Manifest XML //
		/*hmhShareHeaderSteps.loadTheSavedURL(currentOneCMSURL); 
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
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", level1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", level1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", level1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", level1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "organization", ccoName);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "item", ccoName);*/
    	
		//  ** verify Incoming References for SB in document Details Page
		// Commented these extra lines,not required now after the above fix provided  
		/*siteHeaderSteps.refreshPage();
		hmhDocumentLibrarySteps.goBackToPreviousPage();
		hmhDocumentLibrarySteps.goBackToPreviousPage();*/
		siteHeaderSteps.clickOnDocumentLibraryButton(); 
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1);
		hmhDocumentLibrarySteps.navBarClick(sbName1);
		shareHeaderSteps.customWait(5);  
		//  ** verify Incoming References for SB in document Details Page   	
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


	}
}
