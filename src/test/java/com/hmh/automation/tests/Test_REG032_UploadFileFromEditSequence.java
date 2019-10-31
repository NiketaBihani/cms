package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.ProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG032_UploadFileFromEditSequence.csv", separator = ConstantsHMH.CSV_SEPARATOR)

public class Test_REG032_UploadFileFromEditSequence extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Steps
	private SiteHeaderSteps siteHeaderSteps;
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

	String  siteTypeTest, ProductSetName, programType, programName1, title,
	grade, markets, editSequence, programName2, productSetType, year, levle1, numbering6, sequenceBundleType, SequenceBundleName,
	learningBundleType, learningBundleName, lifecycle, learningStyle, interactivityLevel, socialInteraction, outgoing,
	componentType, compoName, activityType, language, rights, compoLearningObjectType, cloName, productCategory, productType, fileName;


	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG032 - UploadFile From Edit Sequence")
	public void test_REG032_UploadFileFromEditSequence() {


		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		documentLibrarySteps.createNewContent(productSetType);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductSet(ProductSetName, year, grade, levle1, numbering6, markets, title);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetName);
		hmhDocumentLibrarySteps.navBarClick(ProductSetName);
		shareHeaderSteps.customWait(3);
		documentDetailsSteps.editSequenceButtonDocumentActionClick(); // documentLibrarySteps.moreActionMenuClick(editSequence, programName1);     

		hmhSequenceViewSteps.checkIfOnSequenceViewPage();
		hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(ProductSetName);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetName);
		hmhDocumentLibrarySteps.navBarClick(ProductSetName);
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.outgoingReferencesClick();
		hmhDocumentDetailsSteps.deleteReference(fileName);

	}	







}
