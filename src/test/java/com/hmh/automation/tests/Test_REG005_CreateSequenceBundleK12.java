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



@Story(HMHApplication.SequenceBundle.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG005_CreateSequenceBundleK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG005_CreateSequenceBundleK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

	@Managed(uniqueSession = true) 
	
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
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    //
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;

    
    String typeSB, year, grade, markets, label1, lable1Restart, objectNameSB, title, siteTypeTest, description="automation", sbLabelInput="sbTestLabel";
    String itemName1 = "Mathematics" , itemName2 ="Social Studies";
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test  //Need to add new changes in R4S5 (in edit properties add new check boxes and a new field)
    @Title("Test_REG005 - Create Sequence Bundle in K12 Site, Edit properties and Verify Metadata Properties")
    public void test_REG005_CreateSequenceBundleK12() {
 
        hmhDocumentLibrarySteps.assetFromListClick(SequenceBundlesFolder);
        documentLibrarySteps.createNewContent(typeSB);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createSequenceBundle(objectNameSB, markets, title);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        hmhDocumentLibrarySteps.assetFromListClick(objectNameSB);
        hmhDocumentLibrarySteps.navBarClick(objectNameSB);
        shareHeaderSteps.customWait(3);       
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick(); 
        hmhEditPropertiesSteps.editTitle(title);
        hmhEditPropertiesSteps.editDescription(description);
        
      //hmhEditPropertiesSteps.selectExcludeLevelNumberCHKBOX();
      //hmhEditPropertiesSteps.selectExcludeLevelLabelCHKBOX();
      //hmhEditPropertiesSteps.sequenceBundleLabelInput(sbLabelInput);
        shareHeaderSteps.customWait(3);
      // ** ALF - 2292 ** Add new Discipline values ** Sprint 7.3.4 **
        hmhEditPropertiesSteps.selectCategory(itemName1, itemName2);
        
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameSB);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.EXCLUDE_LEVEL_LABEL, "No");
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.EXCLUDE_LEVEL_NUMBER, "No");
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.SEQUENCE_BUNDLE_LABEL, "(None)");
        
     // ** ALF - 2292 ** Add new Discipline values ** Sprint 7.3.4 **
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CATGEGORIES, "Mathematics");
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.CATGEGORIES, "Social Studies");

    }
}
