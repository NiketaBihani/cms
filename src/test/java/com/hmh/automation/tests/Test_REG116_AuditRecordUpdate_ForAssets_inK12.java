//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **

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
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.tools.Constants;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;


@Story(HMHApplication.Asset.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG116_AuditRecordUpdate_ForAssets_inK12.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG116_AuditRecordUpdate_ForAssets_inK12 extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

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
	private HMHSearchResultsSteps hmhSearchResultsSteps;
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


    
    private String typeAsset, objectNameAsset, rights, grade, title, lifecycle,productTypeName, newDescription,
    siteTypeTest, activityType, productType, description,fileName,versionType, comment,username;
    
	int waitForSearchResultsSeconds = 10;
   
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test REG116 - Audit Record History Update For Assets in K12")
    public void test_REG116_AuditRecordUpdate_ForAssets_inK12() {
    	
      // Create Asset 
    	 hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
    	 documentLibrarySteps.createNewContent(typeAsset);
         hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
         hmhDocumentLibrarySteps.createComponentK12Site(objectNameAsset, title, rights, grade, lifecycle);
         hmhDocumentLibrarySteps.assetFromListClickSub(objectNameAsset);
         shareHeaderSteps.customWait(3);
         
      // Click on Audit History Action to verify no recorded actions yet
         hmhDocumentDetailsSteps.auditHistoryAction();
         hmhDocumentDetailsSteps.noAuditHistoryFound();

      // To Edit the Meta data properties for an asset object
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         hmhEditPropertiesSteps.editDescription(description);
         hmhEditPropertiesSteps.productTypeDropDown(productType);
         hmhEditPropertiesSteps.activityTypeDropDown(activityType);
         editPropertiesDocumentSteps.saveButtonClick();
         
      // Verify the updated properties on the document details page       
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectNameAsset);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.RIGHTS, rights);
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.prodTypeLab, productType);        
         hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE, activityType);
         
      // Click on Audit History Action to verify Recorded actions 
         hmhDocumentDetailsSteps.auditHistoryAction();
         hmhDocumentDetailsSteps.clickViewDetailsOnAuditHistory(username);
         hmhDocumentDetailsSteps.verifyPropertyOnViewDetailsAuditHistory(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, description);
         hmhDocumentDetailsSteps.verifyPropertyOnViewDetailsAuditHistory(ConstantsProprtyLabelsHMH.prodTypeLab, productType);
         hmhDocumentDetailsSteps.verifyPropertyOnViewDetailsAuditHistory(ConstantsProprtyLabelsHMH.ACTIVITY_TYPE, activityType);
         hmhDocumentDetailsSteps.clickOkButtonOnAuditHistoryViewDetailsPopUp();
      
      // Click Ok button on Audit History Button
         hmhDocumentDetailsSteps.clickOkButtonOnAuditHistory();
         
      // Enter the search criteria in Quick Search textbox and Verify
        documentLibrarySteps.enterTextInSearchBox(objectNameAsset);
        shareHeaderSteps.customWait(15);
 		hmhSearchResultsSteps.isElementPresentInSearchResult(objectNameAsset, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
 		hmhSearchResultsSteps.SearchCheck();
 		hmhSearchResultsSteps.clickEditCommonPropertiesAction();
 		hmhSearchResultsSteps.selectAndCheckEditCommonProperties(productTypeName, newDescription);
 		shareHeaderSteps.refreshPage();
 		shareHeaderSteps.customWait(20);
 		
 	  // Navigate to object view details Audit History and Verify the updated Metadata in the Audit Log
 		hmhDocumentLibrarySteps.assetFromSearchResultsListClick(objectNameAsset);
 		shareHeaderSteps.customWait(5);
 		
 	  // Commented the below code since IN:20556 is logged in Spira for the sort order of Audit History ** Sprint 7.3.4 ** 19th Sep 2018 	
	/*  hmhDocumentDetailsSteps.auditHistoryAction();
 		hmhDocumentDetailsSteps.clickViewDetailsOnAuditHistory(username);
        hmhDocumentDetailsSteps.verifyPropertyOnViewDetailsAuditHistory(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION, newDescription);
        hmhDocumentDetailsSteps.verifyPropertyOnViewDetailsAuditHistory(ConstantsProprtyLabelsHMH.prodTypeLab, productTypeName);
        hmhDocumentDetailsSteps.clickOkButtonOnAuditHistoryViewDetailsPopUp();
     
     // Click Ok button on Audit History Button
        hmhDocumentDetailsSteps.clickOkButtonOnAuditHistory();*/
        
        System.out.println("Script completed..");
           
    }
}



	


