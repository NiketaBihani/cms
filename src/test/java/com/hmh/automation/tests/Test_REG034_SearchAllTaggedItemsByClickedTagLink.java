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
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SelectTagsPopUpMenuSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.TagManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;

@Story(HMHApplication.Tagging.SearchTags.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG034_SearchAllTaggedItemsByClickedTagLink.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG034_SearchAllTaggedItemsByClickedTagLink extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private SelectTagsPopUpMenuSteps selectTagsPopUpMenuSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private MyProfileSteps myProfileSteps;
    @Steps
    private UserTrashcanSteps userTrashcanSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;
    @Steps
    private TagManagerSteps tagManagerSteps;
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;

    String fileName, fileName2, style, title, siteTypeTest, resourceType, right, grade;
    String tagName = "christmas";
    String description = "test descr";
    boolean isFound = false;
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG034 - Search All Tagged Items By Clicked Tag Link")
    public void test_REG034_SearchAllTaggedItemsByClickedTagLink() {
  
		hmhSiteFinderSteps.isSearchSitePresent(ConstantsHMH.CONSUMER_SITE_NAME, this.siteType);
    	hmhSiteFinderSteps.searchUserSites(ConstantsHMH.CONSUMER_SITE_NAME);
    	hmhSiteFinderSteps.openTheUserSiteFound(ConstantsHMH.CONSUMER_SITE_NAME);
    	siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        this.isFound = hmhDocumentLibrarySteps.isAssetPresent(fileName);    	
		if (isFound == false){
	        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH+fileName);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	        hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
	        editPropertiesDocumentSteps.selectTagsButtonClick();
	        //   selectTagsPopUpMenuSteps.addNewTag(tagName);
	        
		       // hmhEditPropertiesSteps.addNewTag(tagName);
		    hmhEditPropertiesSteps.addExistingTag(tagName);
		    hmhEditPropertiesSteps.okButtonOnTagsPopUpClick();		           
	        //selectTagsPopUpMenuSteps.addExistingTag(tagName);
	        //selectTagsPopUpMenuSteps.okButtonOnTagsPopUpClick();
	        shareHeaderSteps.customWait(3);        
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editRight(right);
	        hmhEditPropertiesSteps.editGrade(grade);
	        hmhEditPropertiesSteps.editTitle(title);
	        hmhEditPropertiesSteps.editLearningStyles(style);
	        hmhEditPropertiesSteps.editResourceType(resourceType);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(3);
		}
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        documentLibrarySteps.tagInListClick(tagName);
        shareHeaderSteps.customWait(10);
        // upload new file
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        this.isFound = hmhDocumentLibrarySteps.isAssetPresent(fileName2);    	
		if (isFound == false){
	        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName2);
	        siteHeaderSteps.clickOnDocumentLibraryButton();
	        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
	        hmhDocumentLibrarySteps.assetFromListClickSub(fileName2);
	        shareHeaderSteps.customWait(3);
	        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
	        editPropertiesDocumentSteps.selectTagsButtonClick();
	        
	        hmhEditPropertiesSteps.addExistingTag(tagName);
	        hmhEditPropertiesSteps.okButtonOnTagsPopUpClick();
	        
	        //selectTagsPopUpMenuSteps.addExistingTag(tagName);
	        //selectTagsPopUpMenuSteps.okButtonOnTagsPopUpClick();
	        shareHeaderSteps.customWait(3);        
	        hmhEditPropertiesSteps.editDescription(description);
	        hmhEditPropertiesSteps.editRight(right);
	        hmhEditPropertiesSteps.editGrade(grade);
	        hmhEditPropertiesSteps.editTitle(title);
	        hmhEditPropertiesSteps.editLearningStyles(style);
	        hmhEditPropertiesSteps.editResourceType(resourceType);
	        editPropertiesDocumentSteps.saveButtonClick();
	        shareHeaderSteps.customWait(5);
		}
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(AssetsFolder);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.compareNumberOfOccurrencesOfTag(documentLibraryLeftPanelSteps.getTagNumericValue(tagName),
        documentLibrarySteps.countNumberOfOccurrencesForATag(tagName));
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectTagFilter(tagName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.checkIfAssetIsPresent(fileName);
        documentLibrarySteps.checkIfAssetIsPresent(fileName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectTagFilter(tagName);
        shareHeaderSteps.customWait(5);
        // The count should be 2
        documentLibrarySteps.compareNumberOfOccurrencesOfTag(documentLibraryLeftPanelSteps.getTagNumericValue(tagName),
        documentLibrarySteps.countNumberOfOccurrencesForATag(tagName));

    }
}
