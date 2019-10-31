package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;

	public class HMHSetupPage extends AbstractPage {
	    public HMHSetupPage(final WebDriver driver) {
	        super(driver);
	    }

	    @FindBy(css = "button[id*='createContent-button-button']")
		private WebElement createButton;
	    
		@FindBy(css = "div.create-content div.bd ul li a")
		private List<WebElement> contentToCreateList;
		
		@FindBy(css = "input[name='prop_cm_name']")
		private WebElement folderNameField;
	    
		@FindBy(css = "textarea[id $= 'prop_cm_description']")
		private WebElement newFolderDescriptionInput;

		@FindBy(css = "button[id $= 'createFolder-form-submit-button']")
		private WebElement saveFolderButton;
		
		@FindBy(css = "div[id='HEADER_SITE_DOCUMENTLIBRARY'] a")
		private WebElement documentLibraryButton;
		
		@FindBy(css = "tbody[class $= 'data'] > tr h3 > span a")
		private List<WebElement> documentLibraryAssetName;
		
		@FindBy(css="div[id*='default-navBar'] span.label a")  // div[id*='default-navBar'] span a || div[id*='default-navBar'] span[class*='label'] a
		private WebElement navBarViewDetails;
		
	    @FindBy(xpath =".//*[@id='onActionManageAspects']/a/span")					// css = "div.document-manage-aspects > a span" xpath =".//*[@id='onActionManageAspects']/a/span")
		private WebElement manageAspectsButtonDocumentActions;
	    
	    @FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec']")
		private List<WebElement> aspectsAvailableList;

		@FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec'] > td > div > h3")
		private List<WebElement> aspectsAvailableForFoldersList;

		@FindBy(css = "div[id $= 'aspects-left'] tr[class *= 'dt-rec'] td > div > a > span.addIcon")
		private List<WebElement> addAspectButtonList;

		@FindBy(css = "div[id $= 'aspects-right'] tr[class *='dt-rec']")
		private List<WebElement> aspectsCurrentlySelectedList;

		@FindBy(css = "button[id $= 'aspects-ok-button']")
		private WebElement applyChangesButton;
	    
	    
		public void manageAspectsButtonDocumentActionsClick() {
			waitForElementX(".//*[@id='onActionManageAspects']/a/span", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			element(manageAspectsButtonDocumentActions).waitUntilVisible();
			manageAspectsButtonDocumentActions.click();
			waitABit(2000);
//			waitForPageToLoadCompletely(15);
//			this.actionsonDocumentDetails.click();
		}
		
		public void selectAspectForAFolderX(final String aspectName) {
			boolean found = false;
			waitABit(1000);
			for (int i = 0; i < addAspectButtonList.size(); i++) {
				for (int j = 0; j < aspectsAvailableForFoldersList.size(); j++) {
					if (aspectsAvailableForFoldersList.get(j).getText()
							.toLowerCase().contentEquals(aspectName.toLowerCase())) {
						found = true;
						waitABit(2000);
						element(addAspectButtonList.get(i)).waitUntilVisible();
						addAspectButtonList.get(i).click();
						break;
					}
					i++;
				}
				if (found = true) {
					break;
				}
			}
			Assert.assertTrue("The aspect was not found", found);
		}	
		
		public void selectAspectForAFolder(final String aspectName) {
			waitABit(1000);
			waitForElement("tbody>tr:nth-child(1)>td:nth-child(2)>div>h3:nth-child(1)", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			boolean isAspectPresent=isElementVisible(By.xpath("//tr/td/div/h3[text()='"+aspectName+"']/following::td[1]/div/a/span"));
			WebElement aspectNameX=getDriver().findElement(By.xpath("//tr/td/div/h3[text()='"+aspectName+"']/following::td[1]/div/a/span"));
			Actions action = new Actions(getDriver());
			action.moveToElement(aspectNameX).build().perform();
			aspectNameX.click();
			Assert.assertTrue("The aspect was not found", isAspectPresent);
		}
		
		public void aspectsChangesApplyClick() {
			element(this.applyChangesButton).waitUntilVisible();
			this.applyChangesButton.click();
			waitForRenderedElementsToBePresent(By.cssSelector("div#message"));
		}
		
		public void navBarClick() {
			element(navBarViewDetails).waitUntilVisible();
			navBarViewDetails.click();
			waitABit(2000);
		}
		
		String navBarXpath="//span[@class='label']/a[contains(text(),'textToReplace')]";
		public void navBarClick(String asset) {
		//	waitForLoadingMsgDisappear();
			waitForElementX("//span[@class='label']/a[contains(text(),'"+asset+"')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());//waitForElementX
			WebElement navBarCurrent = getDriver().findElement(By.xpath(navBarXpath.replace("textToReplace", asset)));
			System.out.println(navBarViewDetails.getText());
			navBarCurrent.click();
		}
		
	    public void createNewContent(final String option) {
	    	waitForElement("button[id*='createContent-button-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			element(createButton).waitUntilVisible();
			createButton.click();
			boolean foundOption = false;
			for (final WebElement optionType : contentToCreateList) {
				if (optionType.getText().toLowerCase()
						.contains(option.toLowerCase())) {
					foundOption = true;
					optionType.sendKeys("");
					optionType.click();
					break;
				}
			}
			Assert.assertTrue("The " + option + " type was not found!", foundOption);
		}

	    public void insertFolderName(String folderName) {
			element(this.folderNameField).waitUntilVisible();
			this.folderNameField.sendKeys(new CharSequence[] { folderName });
		}
	    
		public void insertNewFolderDescription(String description) {
			element(this.newFolderDescriptionInput).waitUntilVisible();
			this.newFolderDescriptionInput
					.sendKeys(new CharSequence[] { description });
		}
		public void saveFolder() {
			element(this.saveFolderButton).waitUntilVisible();
			this.saveFolderButton.click();
			waitABit(3000L);
		}
		
		public void clickOnDocumentLibraryButton() {
			element(this.documentLibraryButton).waitUntilVisible();
			this.documentLibraryButton.click();
		}
		
		public void assetFromListClick(final String assetName) {
			disableFlash();
			waitABit(500);
			boolean isAssetPresent=false;
			String assetX= "//table/tbody//div/h3/span/a[contains(text(),'"+assetName+"')]";
			waitForElementX(assetX, ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			isAssetPresent=isElementVisible(By.xpath(assetX));
			if(isAssetPresent==true){
				getDriver().findElement(By.xpath(assetX)).click();
				waitABit(500);
				
			}
			Assert.assertTrue("Asset is not in the list! or not loaded in 5 Minutes", isAssetPresent);
		}
		
		
	@FindBy(css = "span[id *= 'HEADER_USER_MENU']")
	private WebElement userButton;
	@FindBy(id = "HEADER_USER_MENU_LOGOUT_text")
	private WebElement logoutButton;
		    
		    public void userButtonClick() {
				element(this.userButton).waitUntilVisible();
				this.userButton.click();
			}
		    
		    public void logoutButtonClick() {
				userButtonClick();
				element(this.logoutButton).waitUntilVisible();
				this.logoutButton.click();
				Assert.assertTrue(
						"Login Page password field was not displayed",verifyElementPresent(
								By.cssSelector("input[id $= 'default-password']"), 10));
			}
		
}
