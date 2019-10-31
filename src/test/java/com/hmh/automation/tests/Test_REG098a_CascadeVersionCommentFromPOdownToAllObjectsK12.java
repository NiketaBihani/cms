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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG098a_CascadeVersionCommentFromPOdownToAllObjectsK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)


public class Test_REG098a_CascadeVersionCommentFromPOdownToAllObjectsK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew  {
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
	
	
	String  type, objectNameOld,  title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
	cloPubRights, siteTypeTest, version="New Version", pushed, versionTwo,versionThree, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3;
	int noOfLevels = 1; //level 2 tree structure
	String POtype = "Product Object";
	String nameLabel = "Name";
	String gradeLabel = "Grade";
	String rightsLabel = "Publication Rights";
	String languageLabel = "Language";
	String versiontwo = "2.0";
	String cwOriginalcontentLabel = "CW Original Content(HMH Owned)";
	String IsPushed ="Is Pushed To Habitat?:";
	String objectName = "TC098b"+ConstantsHMH.PREFIX_PRODUCTSET_NAME;
	String sbNameD=sbName+ConstantsHMH.TODAY_DATE;
	String ccoNameD=ccoName+ConstantsHMH.TODAY_DATE;
	String versionComment = "New Version";
	
	

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

	@Title("Test_REG098a_Cascade Version Comment From PO down To All Objects K12")
	public void test_REG09a_CascadeVersionCommentFromPOdownToAllObjectsCon() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);	
		hmhDocumentDetailsSteps.createNewContentNew(POtype);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		hmhDocumentDetailsSteps.clickEditSequence();
		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
		hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbName, ccoName);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		siteHeaderSteps.customWait(5);
	  	hmhDocumentDetailsSteps.clickonVersion();
		hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
		hmhDocumentDetailsSteps.clickonVersionsave();
		siteHeaderSteps.customWait(50);
		hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated("");
		siteHeaderSteps.customWait(10);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.checkLatestVersionText(version);
		hmhDocumentDetailsSteps.outgoingReferencesLinkClick();
		siteHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.checkLatestVersionText(version);


		
	}
}



