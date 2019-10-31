package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.ProgramSupportFolder.ReferProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG027_ReferencingPSContentFilesWhilePushK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG027_ReferencingPSContentFilesWhilePush extends com.hmh.automation.tools.AbstractBaseSiteTestHabitat {

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
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHDataListsSteps hmhDataListsSteps;
    @Steps
	private SiteDashboardSteps siteDashboardSteps;
    @Steps
	private SiteFinderSteps siteFinderSteps;
	@Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    
    String  type, objectNameOld, title, level1, numbering1, sbObjName, year, grade, markets, cloObjName, cloObjDispTitle,
    cloPubRights, siteTypeTest, masterLibSite, masterLibFolder, pushed, versionTwo, sbName, ccoName, sbName1, sbName2, sbName3, sbName4, sbName5, sbName6, ccoName1, ccoName2, ccoName3, sitesLevel, documentLibraryLevel;
    
    int noOfLevels = 2; //level 2 tree structure
    String nameLabel = "Name";
    String gradeLabel = "Grade";
    String rightsLabel = "Publication Rights";
    String languageLabel = "Language";
    String cwOriginalcontentLabel = "CW Original Content(HMH Owned)";
    String IsPushed ="Is Pushed To Habitat?:";
    String objectName = "tc027"+ConstantsHMH.REG_PRODUCTSET_NAME+ConstantsHMH.TODAY_DATE;
    String sbNameD="tc027sb"+ConstantsHMH.TODAY_DATE, sbName1D="sb"+ConstantsHMH.TODAY_DATE+"1", sbName2D="sb"+ConstantsHMH.TODAY_DATE+"2", sbNameND="updatedSB"+ConstantsHMH.TODAY_DATE;
	String ccoNameD="tc027cco"+ConstantsHMH.TODAY_DATE, ccoName1D="cco"+ConstantsHMH.TODAY_DATE+"1", ccoName2D="cco"+ConstantsHMH.TODAY_DATE+"2", ccoNameND="updatedCCO"+ConstantsHMH.TODAY_DATE;
    private boolean isAssetFound=true; 	String habitatShortName=objectName;
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }
    
    
    @Test
    @WithTag(type="feature", name="Habitat")
    
    @Title("Test_REG027 - K-12: Referencing PS Content Files While Push ")
    public void test_REG027_ReferencingPSContentFilesWhilePush() {
  
    	hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
    	this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectName);
    	if (this.isAssetFound == false){
    		documentLibrarySteps.createNewContent(type);
            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
            hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, level1, numbering1, markets, title);
            hmhDocumentLibrarySteps.assetFromListClick(objectName);
            hmhDocumentLibrarySteps.navBarClick(objectName);
            shareHeaderSteps.customWait(4);
            hmhDocumentDetailsSteps.clickEditSequence();
            hmhSequenceViewSteps.checkIfOnSequenceViewPage();
            hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName);
            hmhSequenceViewSteps.createAndVerifyObjInEditSequenceforNlevels(noOfLevels, objectName, sbNameD, ccoNameD); //level 2 tree structure
            //hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
	    }
    	
    	// Referencing Program Support Folder for product set
    	shareHeaderSteps.siteFinderButtonClick();
		hmhSiteFinderSteps.searchForASite2(masterLibSite);
		hmhSiteFinderSteps.openTheSiteFound(masterLibSite);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(masterLibFolder);
		hmhDocumentLibrarySteps.navBarClick(masterLibFolder);
		documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
		hmhEditPropertiesSteps.clickProductSetRefSelect();
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(sitesLevel);
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(habSiteNameReg);
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(documentLibraryLevel);
		hmhEditPropertiesSteps.navigateInPSreferencesDialogBox(ProductSetsFolder);
		hmhEditPropertiesSteps.addPStoMasterReference(this.objectName);
		hmhEditPropertiesSteps.saveButtonClick();
		//hmhSequenceViewSteps.checkSequenceTreeStructure(objectName, sbName1, ccoName1);
		shareHeaderSteps.customWait(5);        
		hmhSiteFinderSteps.searchUserSites(habSiteNameReg);
		hmhSiteFinderSteps.openTheUserSiteFound(habSiteNameReg);
		siteHeaderSteps.clickOnDocumentLibraryButton();
		hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
    	hmhDocumentLibrarySteps.assetFromListClick(objectName);
    	hmhDocumentLibrarySteps.navBarClick(objectName);
    	hmhDocumentDetailsSteps.clickOnProgramSupportFolderLink();
    	hmhDocumentDetailsSteps.checkIfOnProgramSupportFolderDetailsPage(masterLibFolder);
    	siteHeaderSteps.clickOnDocumentLibraryButton();
    	
    }
}
