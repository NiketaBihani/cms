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
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.VersionControl.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG031_VersionAProductSet.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG031_VersionAProductSet extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
	@Steps
	private MyProfileSteps myProfileSteps;
	@Steps
	private UserTrashcanSteps userTrashcanSteps;
	@Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;

    String siteTypeTest, productSetType, name, year, grade, levle1, numbering0, market, title, fileName, versionAction, description, right;
    String resourceType = "Other";
    String firstVersion = "1.0";
    String versionTwo = "2.0";
    String versionThree = "3.0";
    String versionFour = "4.0";
    String versionComment = "New Version";
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG031 - Version a product set")
    public void test_REG031_VersionAProductSet() {
   
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        documentLibrarySteps.createNewContent(productSetType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(name, year, grade, levle1, numbering0, market, title);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick(name);
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);
        hmhDocumentDetailsSteps.clickonVersion();
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);

        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick(name);
        hmhDocumentDetailsSteps.clickonVersion(); //documentLibrarySteps.moreActionMenuClick(versionAction, name);
        
        //Version Pop up
		
      	// **Verify Version pop up Cancel button
      	hmhDocumentDetailsSteps.clickonVersioncancel();
      	hmhDocumentDetailsSteps.clickonVersion();
      	// ** Enter Comment
      	hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
      	// **Verify Version pop up Save button
      	hmhDocumentDetailsSteps.clickonVersionsave();
      		
      	hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionTwo);
        hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
        hmhDocumentDetailsSteps.waitUntilLatestVersionDocUpdated(firstVersion);
        hmhDocumentDetailsSteps.checkLatestVersionDoc(firstVersion);
        hmhDocumentLibrarySteps.refresh();
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.editDescripton(description);
        hmhEditPropertiesSteps.editRight(right);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        editPropertiesDocumentSteps.saveButtonClick();
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick(name);
        hmhDocumentDetailsSteps.clickonVersion(); //documentLibrarySteps.moreActionMenuClick(versionAction, name);
        
        //Version Pop up
		
      	// **Verify Version pop up Cancel button
      	hmhDocumentDetailsSteps.clickonVersioncancel();
      	hmhDocumentDetailsSteps.clickonVersion();
      	// ** Enter Comment
      	hmhDocumentDetailsSteps.commentVersionPopup(versionComment);
      	// **Verify Version pop up Save button
      	hmhDocumentDetailsSteps.clickonVersionsave();
      		
      	//
        hmhDocumentDetailsSteps.waitUntilLatestVersionUpdated(versionThree);
        hmhDocumentDetailsSteps.checkLatestVersion(versionThree);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
        hmhDocumentDetailsSteps.waitUntilLatestVersionDocUpdated(versionTwo);
        hmhDocumentDetailsSteps.checkLatestVersionDoc(versionTwo);

      //Delete references and Check version
	       siteHeaderSteps.clickOnDocumentLibraryButton();
	       hmhDocumentLibrarySteps.assetFromListClick(ProductSetsFolder);
	       hmhDocumentLibrarySteps.assetFromListClick(name);
	       hmhDocumentLibrarySteps.navBarClick(name);
	       hmhDocumentDetailsSteps.outgoingReferencesClick();
	       hmhDocumentDetailsSteps.deleteReference(fileName);
	       hmhDocumentLibrarySteps.refresh();
	       hmhDocumentDetailsSteps.checkLatestVersion(versionThree);
	       
	 //From TC999
	       	this.shareHeaderSteps.myProfileButtonClick();
			this.myProfileSteps.trashcanMenuClick();
			this.userTrashcanSteps.emptyTrashcan();		
			this.shareHeaderSteps.homeButtonClick();
    }
}
