package com.hmh.automation.steps;
	
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHSetupPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

	public class HMHSetupSteps extends AbstractSteps<HMHSetupPage> {
		private static final long serialVersionUID = -6683966261201431368L;

		public HMHSetupSteps(Pages pages) {
			super(pages, HMHSetupPage.class);
		}
		
		@StepGroup ("Setup to create a folder and add all aspects")
		public void setupMasterFolderWithAllAspects(final String option, final String name, final String description,
				final String aspectName1, final String aspectName2, final String aspectName3, final String aspectName4, final String aspectName5, final String aspectName6) {
			createNewContent(option);
			insertNameForFolder(name);
			insertDescriptionForFolder(description);
			saveFolderClick();
			assetFromListClick(name);
			navBarClick();
			manageAspectsButtonDocumentActionsClick();
			selectAspectForAFolder(aspectName1);
			selectAspectForAFolder(aspectName2);
			selectAspectForAFolder(aspectName3);
			selectAspectForAFolder(aspectName4);
			selectAspectForAFolder(aspectName5);
			selectAspectForAFolder(aspectName6);
			aspectsChangesApplyClick();
			clickOnDocumentLibraryButton();
		}
		
		@Step("Click on an option from create content link")
		public void createNewContent(String option) {
			((HMHSetupPage) currentPage()).createNewContent(option);
		}
	
		@Step("Insert name")
		public void insertNameForFolder(String name) {
			((HMHSetupPage) currentPage()).insertFolderName(name);
		}
		@Step("Insert Description")
		public void insertDescriptionForFolder(String description) {
			((HMHSetupPage) currentPage())
					.insertNewFolderDescription(description);
		}
		@Step("Click Save for Folder")
		public void saveFolderClick() {
			((HMHSetupPage) currentPage()).saveFolder();
		}
		
		@Step("Click on document library button")
		public void clickOnDocumentLibraryButton() {
			((HMHSetupPage) currentPage()).clickOnDocumentLibraryButton();
		}
		
		@Step("Click on asset name (exact title)")
		public void assetFromListClick(final String assetName) {
				currentPage().assetFromListClick(assetName);
		}
		
	    @Step("Click on Navigation bar to view the details")
	    public void navBarClick() {
	    	currentPage().navBarClick();
	    }
	    
	    @Step("Click on Manage Aspects Button")
	  	public void manageAspectsButtonDocumentActionsClick() {
	  		currentPage().manageAspectsButtonDocumentActionsClick();
	  	}
	    
		@Step("Select an aspect for a folder")
		public void selectAspectForAFolder(String aspectName) {
			currentPage().selectAspectForAFolder(aspectName);
		}

		@Step("Click on Apply aspects changes")
		public void aspectsChangesApplyClick() {
			((HMHSetupPage) currentPage())
					.aspectsChangesApplyClick();
		}
		
		@Step("Click on logout menu")
		public void logoutButtonClick() {
			((HMHSetupPage) currentPage()).logoutButtonClick();
		 //	getDriver().close();
		}
		

}
