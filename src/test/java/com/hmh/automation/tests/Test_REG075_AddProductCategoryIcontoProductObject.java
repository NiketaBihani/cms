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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG075_AddProductCategoryIcontoProductObject.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG075_AddProductCategoryIcontoProductObject extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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

    String type, year, grade, markets, subMarket, label1, numbering1, objectName, title, siteTypeTest, description, label6, numbering6,textproductcategoryIcon,MetadataReports;
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }
    @Override
	public void setPath(){
		path = ConstantsHMH.DOWNLOADED_FILES_PATH;
	}

    @Test
    @Title("Test_REG075 - Add Product Category Icon for Product Object")
    public void test_REG075_AddProductCategoryIcontoProductObject() {

        hmhDocumentLibrarySteps.assetFromListClick(ProductObjectsFolder);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductObject(objectName, year, title);
        documentLibrarySteps.checkIfAssetIsPresent(objectName);
        hmhDocumentLibrarySteps.assetFromListClick(objectName);
        hmhDocumentLibrarySteps.navBarClick(objectName);
        shareHeaderSteps.customWait(5);        
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        shareHeaderSteps.customWait(3); 
        hmhEditPropertiesSteps.editGrade(grade);
        hmhEditPropertiesSteps.editMarkets(markets);
        hmhEditPropertiesSteps.editSubMarketInternational(subMarket);
        hmhEditPropertiesSteps.productCategoryIconText(textproductcategoryIcon);
        hmhEditPropertiesSteps.editLevel1Label(label1);
        hmhEditPropertiesSteps.selectLvl1Number(numbering1);
        hmhEditPropertiesSteps.editLevel6Label(label6);
        hmhEditPropertiesSteps.selectLvl6Number(numbering6);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(10);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.COPY_RIGHT_YEAR, year);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MARKETS, markets);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_1_LABEL, label1);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_6_LABEL, label6);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.PRODUCT_CATEGORY_ICON, textproductcategoryIcon);
        shareHeaderSteps.customWait(5);
        
        hmhDocumentDetailsSteps.generateMetadataReport();
        shareHeaderSteps.customWait(50);
        
        shareHeaderSteps.myFilesButtonClick();
        hmhDocumentLibrarySteps.assetFromListClick(MetadataReports);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.clickonMetadataReport();
        hmhDocumentDetailsSteps.downloadMetadataReport();
    }
}
