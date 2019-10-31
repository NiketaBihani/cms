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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG009_CreateAssetK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG009_CreateAssetK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;


    
    private String typeAsset, objectNameAsset, rights, grade, language, title, lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, 
    siteTypeTest, studentFacing, activityType, productType, description;
   
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG009 - Create Asset(Component) in K12 Site, Edit properties and Verify Metadata Properties")
    public void test_REG009_CreateAssetK12() {
    	
    	 hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
    	 documentLibrarySteps.createNewContent(typeAsset);
         hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
         hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
         hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
         shareHeaderSteps.customWait(3);

         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         hmhEditPropertiesSteps.editDescription(description);
         hmhEditPropertiesSteps.productTypeDropDown(productType);
         hmhEditPropertiesSteps.activityTypeDropDown(activityType);
         hmhEditPropertiesSteps.studentFacingDropDown(studentFacing);
         editPropertiesDocumentSteps.saveButtonClick();
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameAsset);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RIGHTS, rights);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab, productType);         
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE, activityType);
         
        


    }
}
