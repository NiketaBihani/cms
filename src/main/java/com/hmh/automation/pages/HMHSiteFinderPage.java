package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHSiteFinderPage extends AbstractPage {
	private static final Logger LOG = LoggerFactory
			.getLogger(HMHSiteFinderPage.class);

	@FindBy(css = "div#prompt")
	private WebElement deleteSitePopup;

	@FindBy(css = "div.site-finder")
	private WebElement searchForSitesContainer;

	@FindBy(css = "input[id *= 'default-term']")
	private WebElement inputSearchSite;

	@FindBy(css = "div[class='search-button'] span span button")
	private WebElement searchSiteButton;

	@FindBy(css = "table tbody[class *= 'data'] tr h3 a")
	private List<WebElement> siteList;

	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	private WebElement deleteContentButton;

	@FindBy(css = "table tbody[class *= 'data'] tr")
	private List<WebElement> siteListRows;

	@FindBy(css = "span[id *= 'deleteButton'] button")
	private List<WebElement> deleteSiteButton;

	@FindBy(xpath = "//span[contains(@class,'group')]//button[contains(text(),'Delete')]")
	private WebElement confirmDeleteSiteButton;

	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	private WebElement confirmDeleteContentSite;

	@FindBy(css = "td[class *= 'dt-last']>div>span:nth-child(2) button")
	private WebElement leaveSiteButton;

	@FindBy(css = "div[class*='liner'] span[class*='push-button'] buttonn")
	private WebElement joinSiteButton;
	String deleteSiteFromSearch = "span[id *= 'deleteButton'] button";

	@FindBy(css = "td[class *= 'description'] > div > h3 > a")
	private List<WebElement> siteLink;

	@FindBy(css = "span[id *= 'HEADER_SITES']")
	private WebElement sitesButton;

	@FindBy(id = "HEADER_SITES_MENU_SITE_FINDER_text")
	private WebElement siteFinderHeaderMenuButton;

	@FindBy(css = "tbody tr td[id$='HEADER_SITES_MENU_MY_SITES_text'] a")
	private WebElement mySitesHeadermenuButton;

	@FindBy(css = "div.viewcolumn ul li p a")
	private List<WebElement> userSiteList;

	@FindBy(css = "tbody[id*='AlfDocumentListView'] tr")
	private List<WebElement> siteManagerList;

	@FindBy(css = "td[id*='AlfMenuItem'] ")
	private List<WebElement> siteActions;

	@FindBy(css = "tr[aria-label$='Delete Site'] td[id*='AlfMenuItem']")
	private WebElement deleteSiteAction;

	@FindBy(xpath = "//span[contains(@id,'AlfButton')]//span[contains(text(),'OK')]")
	private WebElement confirmOKbtn;

	@FindBy (css="div[id*='RESULTS_PER_PAGE_SELECTOR'] span.alf-menu-arrow")
	private WebElement resultsPerPage;

	@FindBy (css="tr[id*='AlfCheckableMenuItem'] td[class*='dijitMenuItemLabel']")
	private List<WebElement> numberOfResults;

	@FindBy(css = "div[id*='AlfMenuBarPopup'] div div div[class*='items'] table tbody tr td:nth-child(2)")
	private WebElement deleteSiteAction1;

	@FindBy(css="div[id $= 'default'] > div ul li span a")
	private List<WebElement> toolsNameList;

	@FindBy(css="li span a[title$='Sites Manager']")
	private WebElement siteManagerLink;

	String siteNames = "//td[contains(@class,'siteName')]//span";
	String actionButton = " div[id*='AlfMenuBarPopup'] span.alf-menu-arrow";
	public String siteManagerTable = "//tbody[contains(@id,'AlfDocumentListView')]/tr/td/span/span/span[text()='491Testing']/ancestor::tbody/tr/td[5]/div/div";
	public String deleteButton = "span[id *= 'deleteButton'] button";
	public String siteNameElement = "table tbody[class *= 'data'] tr h3 a";
	public String siteListRow = "table tbody[class *= 'data'] tr";
	public String tableSummarySite = "table[summary]";
	public String noSitesFoundMessage = "tbody[class*='dt-message'] span";
	public String popupNotificationCssSelector = "div.bd > span";

	public HMHSiteFinderPage(WebDriver driver) {
		super(driver);
	}

	public void searchForASite(String siteName) {
		element(this.inputSearchSite).waitUntilVisible();
		this.inputSearchSite.clear();
		this.inputSearchSite.sendKeys(new CharSequence[] { siteName });
		waitABit(2000);
		this.searchSiteButton.click();
		if (verifyElementPresent(By.cssSelector(this.noSitesFoundMessage), 30)) {
			this.searchSiteButton.click();
		}
		waitForListToLoad(this.siteList, 15, false);
		Assert.assertTrue(
				"Site not found!",
				(verifyElementPresent(By.cssSelector(this.noSitesFoundMessage),
						3)) || (this.siteList.size() > 0));
	}

	public void openTheSiteFound(String siteName) {
		boolean found = false;
		for (WebElement siteFound : this.siteLink) {
			if (siteFound.getText().toLowerCase() // removed trim() method
					.contentEquals(siteName.toLowerCase())) {
				siteFound.click();
				found = true;
				break;
			}
		}
		Assert.assertTrue("The site " + siteName + "was not found", found);
	}

	public void deleteSite(String siteName, boolean assertDeleted) {
		WebElement siteRow = checkIfSitePresentInResultsList(siteName);
		WebElement deleteButtonSite = siteRow.findElement(By
				.cssSelector(this.deleteButton));
		deleteButtonSite.sendKeys(new CharSequence[] { "" });
		deleteButtonSite.click();
		element(this.confirmDeleteSiteButton).waitUntilVisible();
		element(this.deleteSitePopup).waitUntilVisible();
		this.confirmDeleteSiteButton.click();
		String text1 = "";
		String text2 = "";
		element(this.confirmDeleteContentSite).waitUntilVisible();
		this.confirmDeleteContentSite.click();
		String notificationTexts = waitUntilNotificationNotVisible();
		String[] notifications = notificationTexts.split("\\|");
		text1 = notifications[0];
		text2 = notifications[1];
		if (assertDeleted) {
			Assert.assertTrue("Popup notification messages are empty",
					(!(text1.isEmpty())) || (!(text2.isEmpty())));
			Assert.assertFalse("Site could not be deleted", text2.toLowerCase()
					.contains("could not"));
		}
	}

	public void deleteAllSites() {
		searchForASite("");
		int searchResultsSize = getDriver().findElements(
				By.cssSelector(this.deleteButton)).size();
		int siteIndexToDelete = 0;
		for (int i = 0; i < searchResultsSize; ++i) {
			((WebElement) this.deleteSiteButton.get(siteIndexToDelete)).click();
			element(this.deleteSitePopup).waitUntilVisible();
			this.confirmDeleteSiteButton.click();
			element(this.confirmDeleteContentSite).waitUntilVisible();
			this.confirmDeleteContentSite.click();
			String text1 = "";
			String text2 = "";
			try {
				element(By.cssSelector(this.popupNotificationCssSelector))
				.waitUntilVisible();
				text1 = element(
						By.cssSelector(this.popupNotificationCssSelector))
						.getText();
				element(By.cssSelector(this.popupNotificationCssSelector))
				.waitUntilNotVisible();
				element(By.cssSelector(this.popupNotificationCssSelector))
				.waitUntilVisible();
				text2 = element(
						By.cssSelector(this.popupNotificationCssSelector))
						.getText();
				element(By.cssSelector(this.popupNotificationCssSelector))
				.waitUntilNotVisible();
			} catch (Exception e) {
				LOG.info("Exception on delete site notification popups");
				if ((text1.toLowerCase().contains("could not".toLowerCase()))
						|| (text2.toLowerCase().contains("could not"
								.toLowerCase()))) {
					++siteIndexToDelete;
				}
			}
		}
	}

	public void leaveSite(String siteName) {
		for (WebElement siteFound : this.siteList)
			if (siteFound.getText().contains(siteName)) {
				element(this.leaveSiteButton).waitUntilVisible();
				this.leaveSiteButton.click();
			}
	}

	public void joinSite(String siteName) {
		for (WebElement resultItem : this.siteList)
			if (resultItem.getText().equals(siteName)) {
				element(this.joinSiteButton).waitUntilVisible();
				this.joinSiteButton.click();
				waitABit(2500L);
			}
	}

	public WebElement checkIfSitePresentInResultsList(String siteName) {
		waitForListToLoad(this.siteListRows, 10, true);
		for (WebElement resultSiteRow : this.siteListRows) {
			WebElement resultSite = resultSiteRow.findElement(By
					.cssSelector(this.siteNameElement));
			if (resultSite.getText().trim().equalsIgnoreCase(siteName.trim())) {
				return resultSiteRow;
			}
		}
		Assert.fail("Site was not found in the search results!");
		return null;
	}

	public void checkIfSiteIsNotPresentInResultsList(String siteName) {
		boolean foundDocument = false;
		for (WebElement resultSiteList : this.siteList) {
			if (resultSiteList.getText().toLowerCase()
					.contains(siteName.toLowerCase())) {
				foundDocument = true;
				break;
			}
		}
		Assert.assertFalse("Document was found in the search results!",
				foundDocument);
	}

	public boolean searchForASite1(String siteName) {
		element(this.inputSearchSite).waitUntilVisible();
		boolean isSiteFound = false;
		boolean noSitesMessage = true;
		int counter = 0;
		this.inputSearchSite.clear();
		this.inputSearchSite.sendKeys(new CharSequence[] { siteName });
		this.searchSiteButton.click();

		while ((isSiteFound == false) && (noSitesMessage == true)
				&& counter < 20) {
			if (!(siteList.isEmpty())) {
				for (WebElement resultSiteList : this.siteList) {
					if (resultSiteList.getText().toLowerCase()
							.contains(siteName.toLowerCase())) {
						isSiteFound = true;
						break;
					}
				}
			}
			waitABit(1000);
			this.searchSiteButton.click();
			noSitesMessage = verifyElementPresent(
					By.cssSelector(this.noSitesFoundMessage), 3);
			counter++;

		}
		waitForListToLoad(this.siteList, 15, false);
		Assert.assertTrue(
				"Site not found!",
				(verifyElementPresent(By.cssSelector(this.noSitesFoundMessage),
						3)) || (this.siteList.size() > 0));

		return isSiteFound;
	}

	public void sitesButtonClick() {
		waitForElement("span[id *= 'HEADER_SITES']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.sitesButton).waitUntilVisible();
		this.sitesButton.click();
	}

	public boolean searchUserSites(String siteName) {

		sitesButtonClick();
		waitForElement("tbody tr td[id$='HEADER_SITES_MENU_MY_SITES_text'] a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.mySitesHeadermenuButton).waitUntilClickable();
		this.mySitesHeadermenuButton.click();
		boolean isSiteFound = false;
		waitForListToLoad(this.userSiteList, 60, false);

		for (WebElement userSites : this.userSiteList) {
			if (userSites.getText().toLowerCase()
					.contains(siteName.toLowerCase())) {
				isSiteFound = true;
				break;
			}
		}

		return isSiteFound;
	}

	public void verifySiteWasDeleted(String siteName){

		sitesButtonClick();
		waitForElement("tbody tr td[id$='HEADER_SITES_MENU_MY_SITES_text'] a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.mySitesHeadermenuButton).waitUntilClickable();
		this.mySitesHeadermenuButton.click();
		boolean isSiteFound = false;
		waitForListToLoad(this.userSiteList, 300, false);

		for (WebElement userSites : this.userSiteList) {
			if (userSites.getText().toLowerCase()
					.contains(siteName.toLowerCase())) {
				isSiteFound = true;
				break;
			}
		}

		Assert.assertFalse("Site is not Deleted "+siteName, isSiteFound);

	}

	public void openTheUserSiteFound(String siteName) {

		boolean isSiteFound = false;
		waitForListToLoad(this.userSiteList, 100, false);
		for (WebElement userSites : this.userSiteList) {
			if (userSites.getText().toLowerCase()
					.contains(siteName.toLowerCase())) {
				isSiteFound = true;
				userSites.click();
				break;
			}
		}

		Assert.assertTrue("Site not found!", isSiteFound);
	}

	public void searchForASite2(String siteName) {
		element(this.inputSearchSite).waitUntilVisible();
		boolean isSiteFound = false;
		boolean noSitesMessage = true;
		int counter = 0;
		this.inputSearchSite.clear();
		this.inputSearchSite.sendKeys(new CharSequence[] { siteName });
		this.searchSiteButton.click();

		while ((isSiteFound == false) && (noSitesMessage == true)
				&& counter < 30) {
			if (!(siteList.isEmpty())) {
				for (WebElement resultSiteList : this.siteList) {
					if (resultSiteList.getText().toLowerCase()
							.contains(siteName.toLowerCase())) {
						isSiteFound = true;
						break;
					}
				}
			}
			waitABit(6000);
			this.searchSiteButton.click();
			noSitesMessage = verifyElementPresent(
					By.cssSelector(this.noSitesFoundMessage), 3);
			counter++;

		}
		waitForListToLoad(this.siteList, 15, false);
		Assert.assertTrue(
				"Site not found!",
				(verifyElementPresent(By.cssSelector(this.noSitesFoundMessage),
						3)) || (this.siteList.size() > 0));
	}

	public void searchForASiteAfterDelete(String siteName) {
		element(this.inputSearchSite).waitUntilVisible();
		this.inputSearchSite.clear();
		this.inputSearchSite.sendKeys(new CharSequence[] { siteName });
		waitABit(2000);
		this.searchSiteButton.click();
		if (verifyElementPresent(By.cssSelector(this.noSitesFoundMessage), 30)) {
			this.searchSiteButton.click();
		}
		waitForListToLoad(this.siteList, 15, false);

	}


	public void selectItemsPerPage(String noOfItems){
		boolean isFound= false;
		element(resultsPerPage).waitUntilVisible();
		resultsPerPage.click();
		for(WebElement selectOption:numberOfResults){
			if(selectOption.getText().toLowerCase().contains(noOfItems)){
				isFound=true;
				selectOption.click();
				waitABit(2000);
			}
		}
		waitForElement("div[id*='RESULTS_PER_PAGE_SELECTOR'] span.alf-menu-arrow", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		Assert.assertTrue("The slected option was not found", isFound);
	}


	// //span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'textToReplace')]
	public void searchAndDeleteSiteFromSiteManager(String siteName) {
		waitForPageToLoadCompletely(300);
		selectItemsPerPage("100 per page");
		waitForRenderedElementsToBePresent(By.cssSelector("span[id*='AlfMenuBarPopup']"));
		boolean isMatched = false;
		String textToReplace = siteName;
		final Actions action = new Actions(getDriver());
		waitForElementX("//tr[1]//td[@class='alfresco-documentlibrary-views-layouts-Cell siteName mediumpad']/span/span[@class='inner']/span[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		boolean isSiteVisible =isElementVisible(By.xpath("//td/span/span/span[contains(text(),'"+textToReplace+"')]"));
		if (isSiteVisible==true){
			System.out.println("Site is present in the list");
			waitForElementX("//td/span/span/span[contains(text(),'"+textToReplace+"')]", 300, getDriver());
			final WebElement siteAction = getDriver().findElement(
					By.xpath("//td/span/span/span[contains(text(),'"+textToReplace+"')]/following::td[6]/div/div/div/span/following-sibling::span[@class='alf-menu-arrow']"));
	
			//	action.moveToElement(siteAction).build().perform();
			siteAction.click();
			waitABit(1000);
			action.moveToElement(deleteSiteAction1).build().perform();
			deleteSiteAction1.click();
			waitABit(1000);
			confirmDelete();
		}
		else{
			System.out.println("Site is NOT present in the Current List");
			
			
		}
	}

	public void confirmDelete() {
		waitABit(1000);
		waitForElementX("//span[contains(@id,'AlfButton')]//span[contains(text(),'OK')]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(confirmOKbtn).waitUntilVisible();
		confirmOKbtn.click();
	}


	public void clickOnSiteMangerLink(){ 
		waitForPageToLoadCompletely(15);
		element(siteManagerLink).waitUntilVisible();
		siteManagerLink.click();
		waitABit(1000);
	}

	public void siteFinderButton()
	{
		sitesButtonClick();
		waitForElement("tr[id$='HEADER_SITES_MENU_SITE_FINDER'] td[id$='HEADER_SITES_MENU_SITE_FINDER_text'] a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.siteFinderHeaderMenuButton).waitUntilVisible();
		this.siteFinderHeaderMenuButton.click();
	}

}
