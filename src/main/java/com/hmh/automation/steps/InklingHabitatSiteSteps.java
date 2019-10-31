package com.hmh.automation.steps;


	import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.InklingHabitatSitePage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

	public class InklingHabitatSiteSteps extends AbstractSteps<InklingHabitatSitePage> {

		private static final long serialVersionUID = 8294813212647928057L;
		
		public InklingHabitatSiteSteps(Pages pages) {
			super(pages, InklingHabitatSitePage.class);
		}

		

		@Step("Launch habitat Core site in new tab")
		public void launchHabitatAndLogin(String habUserName, String habPassword) {
			((InklingHabitatSitePage) currentPage()).launchHabitatAndLogin(habUserName, habPassword);
		}
		
		@Step("Remove the welcome popup if any on Home page of Habitat core site")
		public void removeGetStartedPopup(){
			currentPage().removeGetStartedPopup();
		}

		@Step("Search for Habitat project in Inkling Habitat core site and click on it {0}")
		public void searchAndOpenHabitat(String psName) {
			currentPage().searchAndOpenHabitat(psName);
		}
		@Step("Search for Habitat project in Inkling Habitat core site and click on it {0}")
		public void searchAndOpenRegHabitat(String psName) {
			currentPage().searchAndOpenRegHabitat(psName);
		}
		@Step("Click on Configure Project")
		public void clickOnConfigureProject() {
			currentPage().clickOnConfigureProject();
		}
		
		@Step("Verify Habitat project Title in Edit Structure Page") 
		public void verifyHabitatTitle(String psName){
			currentPage().verifyHabitatTitle(psName);
		}
		
		@Step("Verify Habitat Chapter Title in Inkling Habitat Site") 
		public void verifyChapterTitle(String sbName) {
			currentPage().verifyChapterTitle(sbName);
		}
		
		@Step("Verify Habitat Chapter Label in Inkling Habitat Site") 
		public void verifyChapterLabel(String sbName, String sbLabel) {
			currentPage().verifyChapterLabel(sbName, sbLabel);
		}
		
		@Step("Verify Habitat Chapter Number in Inkling Habitat Site") 
		public void verifyChapterNumber(String sbName, String sbNumber) {
			currentPage().verifyChapterNumbering(sbName, sbNumber);
		}
		
		@Step("Verify Habitat Page Title in Inkling Habitat Site") 
		public void verifyPageTitle(String ccoName) {
			currentPage().verifyPageTitle(ccoName);
		}
		
		@Step("Verify Habitat Page Label in Inkling Habitat Site") 
		public void verifyPageLabel(String ccoName, String ccoLabel) {
			currentPage().verifyPageLabel(ccoName, ccoLabel);
		}
		
		@Step("Verify Habitat Page Number in Inkling Habitat Site") 
		public void verifyPageNumber(String ccoName, String ccoNumber) {
			currentPage().verifyPageNumbering(ccoName, ccoNumber);
		}
		
		@Step("Edit the Chapter Title in Habitat core site {1}")
		public void editChapterTitle(String oldSBname, String newSBname) {
			currentPage().editChapterTitle(oldSBname, newSBname);
		}
		
		@Step("Edit the Chapter Label in Habitat core site {0}")
		public void editChapterLabel(String newSBlabel) {
			currentPage().editChapterLabel(newSBlabel);
		}
		
		@Step("Edit the Chapter Number in Habitat core site {0}")
		public void editChapterNumbering(String newSBnumber) {
			currentPage().editChapterNumbering(newSBnumber);
		}
		
		@Step("Edit the Page Title in Habitat core site {1}")
		public void editPageTitle(String oldSBname, String newSBname) {
			currentPage().editPageTitle(oldSBname, newSBname); 
		}
		@Step("Edit the Page Label in Habitat core site {0}")
		public void editPageLabel(String newSBlabel) {
			currentPage().editPageLabel(newSBlabel);
		}
		@Step("Edit the Page Number in Habitat core site {0}")
		public void editPageNumbering(String newSBnumber) {
			currentPage().editPageNumbering(newSBnumber);
		}
		@Step("Add a Page structure to the project using Drag and Drop as child for {0}")
		public void addPageInsideFirstSB(String ccoName,String sbName) {
			currentPage().addPageInsideFirstSB(ccoName, sbName);
		}
		
		@Step("Give a name to newly added Page in Habitat structure")
		public void giveANameToAddedpage(String pageName) {
			currentPage().giveANameToAddedpage(pageName);
		}
		@Step("Click on edit Content Tab")
		public void clickOnEditContent(){
			currentPage().clickOnEditContent();
		}
		@Step("Click on SB in edit content page {0}")
		public void clickOnSBinEditContent(String sbName){
			currentPage().clickOnSBinEditContent(sbName);
		}
		@Step("Click on CCO/Page in edit content page {0}")
		public void clickOnPageinEditContent(String pageName){
			currentPage().clickOnCCOinEditContent(pageName);
		}
		@Step("Add an image from Habitat Library to newly added Page")
		public void addImageFromLibrary() {
			currentPage().addImageFromLibrary();
		}
		@Step("Click on Save Button in Habitat core site")
		public void clickSaveButton() {
			currentPage().clickSaveButton();
		}
		@Step("Logout from Habitat Inkling")
		public void logOutFromHabitat(){
			currentPage().logOutHabitat();
		}
}
