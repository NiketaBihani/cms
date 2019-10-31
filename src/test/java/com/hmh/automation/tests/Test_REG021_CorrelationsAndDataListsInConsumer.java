package com.hmh.automation.tests;

	import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDmaSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeSiteSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

	@Story(HMHApplication.Correlations.class)
	@RunWith(SerenityParameterizedRunner.class)
	@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG021_CorrelationsAndDataListsInConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)
	public class Test_REG021_CorrelationsAndDataListsInConsumer extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
	    @Steps
	    private HMHDmaSteps hmhDmaSteps;
	    @Steps
	    private DashboardSteps dashboardSteps;
	    @Steps
	    private CustomizeDashboardSteps customizeDashboardSteps;
	    @Steps
	    private ShareHeaderSteps shareHeaderSteps;
	    @Steps
	    private CustomizeSiteSteps customizeSiteSteps;
	    @Steps
	    private HMHDataListsSteps hmhDataListsSteps;
	    @Steps
	    private HMHSetupSteps hmhSetupSteps;
	    
	    String objectNameAsset, typeAsset, rights, grade, language, standardD, actionName, standardFolder, standard, dashlet, title,
	            lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, dataList, siteTypeTest, level1, documentLibraryLevel ;
	    private boolean isAssetFound=true;
	    
	    @Override
	    public void setSiteType() {
	        siteType = siteTypeTest;
	    }
	    
	    @Test
	    @Title("Test_REG021 - Correlations And DataLists Functionality in Consumer site")
	    public void test_REG021_CorrelationsAndDataListsInConsumer() {

	  // ***Pre-Requisites: Dynamic creation of Objects/Assets
	    	hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	    	this.isAssetFound = hmhDocumentLibrarySteps.isAssetPresent(objectNameAsset);
	    	if (isAssetFound == false){
	    		documentLibrarySteps.createNewContent(typeAsset);
	            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
	            hmhDocumentLibrarySteps.createComponentConsumerSite(objectNameAsset, title, rights, grade, lifecycle, resourceType);
		    }
	    	
	   //*** verifying Correlations from document details - Document Library
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        siteHeaderSteps.clickOnDataListsButton();
	        hmhDataListsSteps.selectStandardFromList(dataList);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
	        siteHeaderSteps.customWait(5);
	        hmhDocumentLibrarySteps.clickCorrelations(); //  documentLibrarySteps.moreActionMenuClick(actionName, name);
	        hmhDocumentLibrarySteps.clickItemInCorrelationsPane(standardFolder);
	        hmhDocumentLibrarySteps.selectStandardToCorrelate(standardD);
	        siteHeaderSteps.customWait(5);
	        documentDetailsSteps.checkThatDocumentActionIsPresent("Correlations");
	        hmhDocumentLibrarySteps.refresh();	     
	        hmhDocumentLibrarySteps.clickCorrelations(); //documentLibrarySteps.moreActionMenuClick(actionName, name);
	        hmhDocumentLibrarySteps.removeACorrelation(standard);
	        hmhDocumentLibrarySteps.refresh();	
	        hmhDocumentLibrarySteps.clickCorrelations();
	        //hmhDocumentLibrarySteps.checkIfThereAreNoCorrelations();  // Fixed
	        hmhDocumentLibrarySteps.refresh();
	        
	   //*** Verifying standards correlations through Data list  - Data Lists 
	        hmhDocumentLibrarySteps.clickCorrelations();  
	        hmhDocumentLibrarySteps.clickItemInCorrelationsPane(standardFolder);
	        hmhDocumentLibrarySteps.selectStandardToCorrelate(standard);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        siteHeaderSteps.clickOnDataListsButton();
	        hmhDataListsSteps.selectStandardFromList(standardFolder);
	        hmhDataListsSteps.checkIfItemWasCorrelatedToStandard(standard, objectNameAsset);  // Fixed
	        hmhDataListsSteps.editButtonForStandardClick(standard);
	        hmhDataListsSteps.checkCorrelationsInEditStandardPane(objectNameAsset);
	        hmhDataListsSteps.selectCorrleationButtonClick();
	        hmhDataListsSteps.checkIfItemIsInCorrleationInDataSetsPage(objectNameAsset);
	        hmhDataListsSteps.removeCorrelationInDataSetsPage(objectNameAsset);
	        hmhDataListsSteps.selectCorrleationButtonClick();
	        
	        hmhDocumentLibrarySteps.refresh();
	        hmhDataListsSteps.selectStandardFromList(standardFolder);
	        hmhDataListsSteps.editButtonForStandardClick(standard);
	        hmhDataListsSteps.selectCorrleationButtonClick();
	        
	        hmhDataListsSteps.checkIfNoItemIsCorrelatedForStandardInDataListsPage(); // need a change
	        hmhDataListsSteps.correlateOKbuttonClick();
	        hmhDataListsSteps.editCorrelationPaneSaveButtonClick();
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
	        hmhDocumentLibrarySteps.clickCorrelations();   //  documentLibrarySteps.moreActionMenuClick(actionName, name);
	        hmhDocumentLibrarySteps.checkIfThereAreNoCorrelations();  
	        hmhDocumentLibrarySteps.refresh();
/*	        
	 //*** Create Correlations from Data Lists - Data Lists      
	        siteHeaderSteps.clickOnDataListsButton();
	        hmhDataListsSteps.selectStandardFromList(dataList);
	        hmhDataListsSteps.editButtonForStandardClick(standard);
	        hmhDataListsSteps.selectCorrleationButtonClick();
	        shareHeaderSteps.customWait(5);
	        hmhDataListsSteps.navigateInCorelationsDialgoBox(level1);
	        hmhDataListsSteps.navigateInCorelationsDialgoBox(siteName);
	        hmhDataListsSteps.navigateInCorelationsDialgoBox(documentLibraryLevel);
	        hmhDataListsSteps.navigateInCorelationsDialgoBox(folderName);
	        hmhDataListsSteps.addItemToCorrelate(objectNameAsset);
	        hmhDataListsSteps.editCorrelationPaneSaveButtonClick();
	        shareHeaderSteps.customWait(5);
	        //   hmhDataListsSteps.checkIfItemWasCorrelatedToStandard(standard, name);  // need a change
	        hmhDocumentLibrarySteps.refresh();
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(folderName);
	        hmhDocumentLibrarySteps.assetFromListClick(objectNameAsset);
	        hmhDocumentLibrarySteps.clickCorrelations();    //documentLibrarySteps.moreActionMenuClick(actionName, name);
	        shareHeaderSteps.customWait(5);
	        hmhDocumentLibrarySteps.checkIfStandardWasAdded(standard);
	        hmhDocumentLibrarySteps.removeACorrelation(standard);
	        hmhDocumentLibrarySteps.refresh(); */
	        
	   //*** Delete Object and check that correlation was removed - Document Library   
	        hmhDocumentLibrarySteps.clickCorrelations(); //documentLibrarySteps.moreActionMenuClick(actionName, name);
	        hmhDocumentLibrarySteps.clickItemInCorrelationsPane(standardFolder);
	        hmhDocumentLibrarySteps.selectStandardToCorrelate(standard);
	        hmhDocumentLibrarySteps.refresh();
	        hmhDocumentLibrarySteps.clickDeleteObject();//documentLibrarySteps.moreActionMenuClick(deleteAction, name);
	        documentLibrarySteps.confirmDelete();
	        hmhDocumentLibrarySteps.refresh();
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        siteHeaderSteps.clickOnDataListsButton();
	        hmhDataListsSteps.selectStandardFromList(dataList);
	        hmhDataListsSteps.checkIfStandardHasNoCorrelation(standard);
	        hmhDocumentLibrarySteps.refresh();
	        
	    }


}
