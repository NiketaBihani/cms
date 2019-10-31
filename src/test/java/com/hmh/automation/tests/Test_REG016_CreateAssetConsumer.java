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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;


@Story(HMHApplication.Asset.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG016_CreateAssetConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG016_CreateAssetConsumer extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	private ShareHeaderSteps shareHeaderSteps;
	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	@Steps
	private HMHSetupSteps hmhSetupSteps;
	@Steps
	private HMHEditPropertiesSteps hmhEditPropertiesSteps;
	@Steps
	private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
	//
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;



	private String typeAsset, objectNameAsset, rights, grade, language, title, lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, 
	siteTypeTest, learningStyle, description, cwOriginalcontent2, viewportSizes, characters, fileName;

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG016 - Create Asset in Consumer Site, Edit properties and Verify Metadata Properties")
	public void test_REG016_CreateAssetConsumer() {

		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		documentLibrarySteps.createNewContent(typeAsset);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createComponentConsumerSite(objectNameAsset, title, rights, grade, lifecycle, resourceType);
		hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editDescription(description);
		hmhEditPropertiesSteps.editCwOriginalContent(cwOriginalcontent2);
		shareHeaderSteps.customWait(3);
		hmhEditPropertiesSteps.editLearningStyles(learningStyle);
		shareHeaderSteps.customWait(3);
		hmhEditPropertiesSteps.editCharacterList(characters);
		shareHeaderSteps.customWait(3);
		hmhEditPropertiesSteps.editMinViewportSizeList(viewportSizes);
		shareHeaderSteps.customWait(3);
		editPropertiesDocumentSteps.saveButtonClick();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameAsset);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RIGHTS, rights);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION,description);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.cwOriginalcontentLabel,cwOriginalcontent2);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.learningStylesLabel,learningStyle);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.characterLabel,characters);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.viewportLabel,viewportSizes);

		//Added these Steps to upload a flat text file
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
		documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
		hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editDescription(description);
		hmhEditPropertiesSteps.editTitle(title);
		hmhEditPropertiesSteps.editResourceType(resourceType);
		hmhEditPropertiesSteps.saveButtonClick();
		siteHeaderSteps.clickOnDocumentLibraryButton();
		


	}
}
