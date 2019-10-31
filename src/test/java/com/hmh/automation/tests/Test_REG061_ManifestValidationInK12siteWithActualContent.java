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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG061_ManifestValidationInK12site.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG061_ManifestValidationInK12siteWithActualContent extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {
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


	String  type, objectNameOld, title, description, productType, level1, numbering1, sbObjName, year, grade, markets, resourceType, cloObjName, cloObjDispTitle,
	cloPubRights, fileName1, fileName2, siteTypeTest, pushed, sbName, ccoName, assetName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, assetName1, assetName2, assetName3;
	int noOfLevels = 2; //level 2 tree structure
	String versionTwo = "2.0";
	String objectName = ConstantsHMH.TC61;
	String sbNameD=sbName+ConstantsHMH.TODAY_DATE;
	String ccoNameD=ccoName+ConstantsHMH.TODAY_DATE;
	//path = ConstantsHMH.TC19_PATH;
	
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
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createValidManifestStructureEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName, assetName); //level 3 tree structure
		//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
		hmhSequenceViewSteps.expandTreeInSequenceView();
		hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(ccoName1);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
		hmhSequenceViewSteps.expandTreeInSequenceView();
		hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(ccoName2);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName2);		
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName1);
        hmhDocumentLibrarySteps.navBarClick(ccoName1);
        shareHeaderSteps.customWait(3);       
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
        hmhEditPropertiesSteps.editTitle(ccoName1);
        hmhEditPropertiesSteps.editDescription(ccoName1);
        hmhEditPropertiesSteps.editProductTypeK12(productType);
        hmhEditPropertiesSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		hmhDocumentLibrarySteps.assetFromListClickSub(assetName1);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editDescription(assetName1);
		hmhEditPropertiesSteps.editTitle(assetName1);
		hmhEditPropertiesSteps.editProductTypeK12(productType);
		hmhEditPropertiesSteps.saveButtonClick();
	
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);    
		hmhDocumentDetailsSteps.clickonVersion();
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		hmhDocumentDetailsSteps.clickgenerateSnapshot();
		siteHeaderSteps.customWait(50);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.publishToContent();
		hmhDocumentDetailsSteps.waitUntilManifestURLisUpdated();
		hmhDocumentDetailsSteps.saveTheManifestFile();

		hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", objectName);
		hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "manifest", versionTwo);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", versionTwo);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "metadata", "K-12 Product Title");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:version", versionTwo);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:resource", "HMH Product Title");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:resource", "Official Product Title");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:resource", "K-12 Product Title");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:lom", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:lom", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:general", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:general", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:title", objectName);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:title", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "lomimscc:version", versionTwo);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "metadata", sbName1);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "metadata", ccoName1);
    	
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", title);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", level1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "organization", level1+" "+"2"+" "+sbName2);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", level1+" "+"1"+" "+sbName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", level1+" "+"2"+" "+sbName2);
    	
    	// with actual content and valid product type verify S3 publishing Href value in manifest
    	hmhDocumentDetailsSteps.verifyNodeNameAttributeAndValue(path, "file", "href", ccoName1.toLowerCase());
    	hmhDocumentDetailsSteps.verifyCCOwithActualContentAndValidResourceTypeContainsHrefValue(path, "file", "href", ccoName1.toLowerCase());
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", ccoName1);
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(path, "item", assetName1);
    	// with NO actual content and valid product type
    	hmhDocumentDetailsSteps.verifyNodeNameAttributeShouldNotHaveValue(path, "file", "href", ccoName2.toLowerCase());
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "item", fileName1);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "organization", ccoName2); 
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "organization", fileName2);
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(path, "organization", assetName2);
	
    //Delete References	
		siteHeaderSteps.refreshPage();
		siteHeaderSteps.clickOnDocumentLibraryButton(); 
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName1);
		hmhDocumentLibrarySteps.navBarClick(sbName1);
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.checkIfReferenceWasAdded(ccoName1);
		hmhDocumentDetailsSteps.deleteReference(ccoName1);
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		hmhDocumentDetailsSteps.deleteReference(objectName);

		siteHeaderSteps.clickOnDocumentLibraryButton(); 
		hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
		hmhDocumentLibrarySteps.assetFromListClick(sbName2);
		hmhDocumentLibrarySteps.navBarClick(sbName2);
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(ccoName2);
		hmhDocumentDetailsSteps.clickOnManageReferenceLink();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(objectName);
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName1);
        hmhDocumentLibrarySteps.navBarClick(ccoName1);
    	hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(assetName1);
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ccoName2);
        hmhDocumentLibrarySteps.navBarClick(ccoName2);
    	hmhDocumentDetailsSteps.outgoingReferencesClick();
		siteHeaderSteps.customWait(3);
		hmhDocumentDetailsSteps.deleteReference(assetName2);


	}
}
