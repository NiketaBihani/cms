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


@Story(HMHApplication.ProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG011_CreateProductSetConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG011_CreateProductSetConsumer extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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

    
    String type, year, grade, markets, label1, numbering1, objectName, aspectName, title, siteTypeTest, description ="hmhqa";
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG011 - Create ProductSet in Consumer Site, Edit properties and Verify Metadata Properties")
    public void test_REG011_CreateProductSetConsumer() {

        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, numbering1, markets, title);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.checkIfAssetIsPresent(objectName);
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);       
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        editPropertiesDocumentSteps.saveButtonClick();
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.COPY_RIGHT_YEAR, year);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_1_LABEL, label1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NUMBERING_1, numbering1);
        
        

    }
}
