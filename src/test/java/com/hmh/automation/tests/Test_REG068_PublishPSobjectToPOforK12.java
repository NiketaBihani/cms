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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG068_PublishPSobjectToPOforK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG068_PublishPSobjectToPOforK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
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

	String  type,draftcommoncartridgemanifest, type1,objectNameOld, title,title1, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3,fileName,description="automation";
	int noOfLevels = 1; //level 2 tree structure
	String nameLabel = "Name";
	String gradeLabel = "Grade";
	String rightsLabel = "Publication Rights";
	String languageLabel = "Language";
	String versiontwo = "2.0";
	String cwOriginalcontentLabel = "CW Original Content(HMH Owned)";
	String IsPushed ="Is Pushed To Habitat?:";
	String objectName = "TC068"+ConstantsHMH.PREFIX_PRODUCTSET_NAME;
	String POobjectName = "PO_068"+ConstantsHMH.PREFIX_PRODUCTOBJECT_NAME;
	String sbNameD="TC068"+sbName+ConstantsHMH.TODAY_DATE;
	String ccoNameD="TC068"+ccoName+ConstantsHMH.TODAY_DATE;
	String versionComment = "New Version";
	String textprogramLabel = "newprogramlabel";
	String textproductCategoryPositionLabel = "100";
	String textproductTitleLabel = "ProductTitle";
	String textproductLaunchTypeLabel = "ApiLaunch"; //ApiLaunch or ContentLaunch
	
	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}
	@Override
	public void setPath(){
		path = ConstantsHMH.TC20_PATH;
	}


	@Test
	@WithTag(type="feature", name="publish")

	@Title("Test_REG068 - K-12: Publish PS Object to PO for JSON Validation")
	public void test_REG068_PublishPSobjectToPOforK12() {
		
		
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
        editPropertiesDocumentSteps.saveButtonClick();
        
    	hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevelsPSPO(noOfLevels, objectName, POobjectName, sbName); //level 3 tree structure
        siteHeaderSteps.clickOnDocumentLibraryButton();
       
        hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		//documentLibrarySteps.checkIfAssetIsPresent(POobjectName);
		hmhDocumentLibrarySteps.assetFromListClick(POobjectName);
		hmhDocumentLibrarySteps.navBarClick(POobjectName);
		shareHeaderSteps.customWait(5);
		
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editDescription(description);
		hmhEditPropertiesSteps.editGrade(grade);
		hmhEditPropertiesSteps.programLabel(textprogramLabel);
		hmhEditPropertiesSteps.productCategoryPositionLabel(textproductCategoryPositionLabel);
		hmhEditPropertiesSteps.productTitleLabel(textproductTitleLabel);
		hmhEditPropertiesSteps.productLaunchTypeLabel(textproductLaunchTypeLabel);
		editPropertiesDocumentSteps.saveButtonClick();
		
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		
		//Version Pop up
		hmhDocumentDetailsSteps.clickonVersion();
		// **Enter comment
		hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
		// **Verify Version pop up Save button
		hmhDocumentDetailsSteps.clickonVersionsave();
		
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
		siteHeaderSteps.customWait(10);
		hmhDocumentLibrarySteps.refresh();
		// **Publish to draft and publish to content functionality       
		//hmhDocumentDetailsSteps.publishToDraft();
		hmhDocumentDetailsSteps.publishToContent();
		
		siteHeaderSteps.customWait(10);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentLibrarySteps.generateJsonFile();//action for json generate
		siteHeaderSteps.customWait(10);			
		siteHeaderSteps.clickOnDocumentLibraryButton();
		
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);	
		String PSObject = objectName.toLowerCase();
		System.out.println(PSObject);
		String jsonValidation = "details_"+PSObject+".json";
		//siteHeaderSteps.customWait(10);

    	hmhDocumentLibrarySteps.assetFromListClickSubCO(jsonValidation);
		System.out.println("Script completed..");
	
		//hmhDocumentDetailsSteps.clickOnDownloadClick();
				
		
}
	

}

