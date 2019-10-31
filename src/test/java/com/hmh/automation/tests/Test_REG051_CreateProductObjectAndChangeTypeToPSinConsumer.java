package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
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
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.ProductObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG051_CreateAndVerifyProductObjectConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG051_CreateProductObjectAndChangeTypeToPSinConsumer extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Managed(uniqueSession = false) 

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

	String type, newType, year, grade, markets, subMarket, label1, numbering1, label6, numbering6, objectName, title, siteTypeTest, description="automation";

	@Override
	public void setSiteType() {
		siteType = siteTypeTest;
	}

	@Test
	@Title("Test_REG051 - Create Product Object in Consumer Site, Edit Properties and Verify Metadata Properties Change type to PS and then back to PO")
	public void test_REG051_CreateProductObjectAndChangeTypeToPSinConsumer() {

		hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
		documentLibrarySteps.createNewContent(type);
		hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
		hmhDocumentLibrarySteps.createProductObject(objectName, year, title);
		hmhDocumentLibrarySteps.refresh();
		documentLibrarySteps.checkIfAssetIsPresent(objectName);
		hmhDocumentLibrarySteps.assetFromListClick(objectName);
		hmhDocumentLibrarySteps.navBarClick(objectName);
		shareHeaderSteps.customWait(5);        
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.editDescription(description);
		hmhEditPropertiesSteps.editGrade(grade);
		hmhEditPropertiesSteps.editLevel6Label(label6);
		hmhEditPropertiesSteps.selectLvl6Number(numbering6);
		editPropertiesDocumentSteps.saveButtonClick();
		shareHeaderSteps.customWait(5);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.COPY_RIGHT_YEAR, year);
		//   hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NUMBERING_1, numbering1);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_6_LABEL, label6);
		documentDetailsSteps.changeTypeButtonDocumentActionsClick();
		documentDetailsSteps.changeType(newType);
		hmhDocumentLibrarySteps.refresh();
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
		hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_6_LABEL, label6);
		documentDetailsSteps.changeTypeButtonDocumentActionsClick();
		documentDetailsSteps.changeType(type);
		hmhDocumentLibrarySteps.refresh();
	}
}
