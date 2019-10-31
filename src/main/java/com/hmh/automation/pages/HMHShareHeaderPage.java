package com.hmh.automation.pages;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

public class HMHShareHeaderPage extends AbstractPage {

	public HMHShareHeaderPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "span[id *= 'HEADER_SITES']")
	private WebElement sitesButton;

	@FindBy(id = "HEADER_SITES_MENU_CREATE_SITE_text")
	private WebElement createSiteHeaderMenuButton;

	@FindBy(css = "input[id*='createSite-instance-title']")
	private WebElement siteName;

	@FindBy(css = "button[id*='createSite-instance-ok']")
	private WebElement createSiteOKButton;
	
	/*@FindBy(xpath=".//*[text()='Shared Files']")
	WebElement sharedFiles;*/
	
	@FindBy(xpath=".//*[text()='Reports']")
	WebElement reports;
	
	@FindBy(xpath=".//*[text()='Learning Spine']")
	WebElement learningSpine;
	

	@FindBy(css = "div[class*='simple-dialog']")
	private WebElement siteNotCreatedPopup;

	@FindBy(css = "span[class*='button-group'] button")
	private WebElement siteNotCreatedPopupOkButton;

	@FindBy(css = "select[id$='instance-sitePreset']")
	private WebElement siteTypeDrop;

	@FindBy(css = "select[id$='instance-sitePreset'] option")
	private List<WebElement> siteTypeOptions;

	@FindBy(css = "span[id *= 'HEADER_USER_MENU']")
	private WebElement userButton;

	@FindBy(id = "HEADER_USER_MENU_LOGOUT_text")
	private WebElement logoutButton;

	@FindBy(id="HEADER_SEARCH_STANDARDS_LINK_text")
	WebElement standards;
	
	@FindBy(xpath=".//*[@id='HEADER_SEARCH_CONTENT_BY_STANDARDS_text']/a")
	WebElement searchContentByStandards;
	
	@FindBy(id="HEADER_SEARCH_STANDARDS_text")
	WebElement importStandards;

	@FindBy(id="HEADER_IMPORT_STANDARDS_text")
	WebElement searchStandards;

	@FindBy(id="HEADER_MY_FILES_text")
	WebElement myFiles;
	
	@FindBy(xpath=".//*[@id='HEADER_SHARED_FILES_text']/a")
	WebElement sharedFiles;
	
	@FindBy(xpath=".//span[text()='OK']")
	WebElement clickOnOkButtonOnDeleteLS;
	
	@FindBy(xpath="//*[@id='HEADER_HELP']")
	WebElement helpMenu;
	
	@FindBy(xpath=".//*[@id='HEADER_HELP_RELEASE_NOTES_text']/a")
	WebElement relNotes;
	
	@FindBy(xpath=".//*[@id='HEADER_HELP_KNOWL_BASE_text']/a")
	WebElement knowledgeBase;
	
	@FindBy(xpath=".//*[@id='template_x002e_web-preview_x002e_document-details_x0023_default-viewer-pageContainer-1']/div[2]/div[3]")
	WebElement releaseNotes;
	
	@FindBy(xpath=".//*[@id='template_x002e_web-preview_x002e_document-details_x0023_default-viewer-pageContainer-1']/div[2]/div[4]")
	WebElement sprintHeaderDetails;
	
	private final String siteTitleCssSelector = "#HEADER_TITLE > a";

	public String createNewSite(String siteType) {
		String newSiteName = generateSiteName();
		while (!createNewSite(newSiteName, siteType)) {
			newSiteName = generateSiteName();
		}
		return newSiteName;
	}

	private String generateSiteName() {
		return Constants.PREFIX_SITE + UUID.randomUUID();
	}

	public boolean createNewSite(final String newSiteName, String siteType) {
		boolean siteTypeFound = false;
		element(sitesButton).waitUntilVisible();
		element(By.cssSelector(siteTitleCssSelector)).waitUntilVisible();
		//final String siteTitleBefore = getDriver().findElement(By.cssSelector(siteTitleCssSelector)).getText();
		sitesButton.click();
		element(createSiteHeaderMenuButton).waitUntilVisible();
		createSiteHeaderMenuButton.click();
		element(siteName).waitUntilVisible();
		siteName.click();
		siteName.sendKeys(newSiteName);
		siteTypeDrop.click();
		waitABit(1000);
		for (WebElement type : siteTypeOptions) {
			if (type.getText().toLowerCase().contains(siteType.toLowerCase())) {
				siteTypeFound = true;
				type.click();
				break;

			}
		}
		Assert.assertTrue("The type was not found", siteTypeFound);
		createSiteOKButton.click();
		final WebDriverWait wait = new WebDriverWait(getDriver(), 20);
		final boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(siteTitleCssSelector), newSiteName));
		//                waitForCreateResult(newSiteName);
		//                if (!onSiteDashboard(getDriver(), newSiteName) && errorPopup()) {
		//                    siteNotCreatedPopupOkButton.click();
		//                    return false;
		//                }
		//                return true;

		//int counter = 0;
		//        waitForPageToLoadCompletely(30);
		//        while (getDriver().findElement(By.cssSelector(siteTitleCssSelector))
		//                .getText().contains(siteTitleBefore) && (counter < 120)) {
		//            waitABit(2000);
		//            counter++;
		//        }
		if (element) {
			return true;
		}
		else {
			element(siteNotCreatedPopupOkButton).waitUntilVisible();
			siteNotCreatedPopupOkButton.click();
			return false;
		}
	}
	public boolean createNewSite1(String newSiteName) {
		element(this.sitesButton).waitUntilVisible();
		element(By.cssSelector("#HEADER_TITLE > a")).waitUntilVisible();

		this.sitesButton.click();
		element(this.createSiteHeaderMenuButton).waitUntilVisible();
		this.createSiteHeaderMenuButton.click();
		element(this.siteName).waitUntilVisible();
		this.siteName.click();
		this.siteName.sendKeys(new CharSequence[] { newSiteName });
		this.createSiteOKButton.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), 20L);
		boolean element = ((Boolean) wait.until(ExpectedConditions
				.textToBePresentInElementLocated(
						By.cssSelector("#HEADER_TITLE > a"), newSiteName)))
				.booleanValue();
		if (element) {
			return true;
		}
		element(this.siteNotCreatedPopupOkButton).waitUntilVisible();
		this.siteNotCreatedPopupOkButton.click();
		return false;
	}

	public String createNewSite() {
		String newSiteName = generateSiteName();
		while (!(createNewSite1(newSiteName))) {
			newSiteName = generateSiteName();
		}
		return newSiteName;
	}

	public boolean createNewSiteWithSiteType(String newSiteName, String siteType)
	{
		waitForElement("span[id *= 'HEADER_SITES']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.sitesButton).waitUntilVisible();
		waitForElement("#HEADER_TITLE > a", 100, getDriver());
		element(By.cssSelector("#HEADER_TITLE > a")).waitUntilVisible();
		waitForElement("span[id *= 'HEADER_SITES']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		this.sitesButton.click();
		waitForElementID("HEADER_SITES_MENU_CREATE_SITE_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.createSiteHeaderMenuButton).waitUntilVisible();
		this.createSiteHeaderMenuButton.click();
		waitForElement("input[id*='createSite-instance-title']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.siteName).waitUntilVisible();
		this.siteName.click();
		this.siteName.sendKeys(new CharSequence[] { newSiteName });

		element(this.siteTypeDrop).selectByVisibleText(siteType);
		element(this.createSiteOKButton).waitUntilVisible();
		this.createSiteOKButton.click();
		boolean isMessagePresent = isElementVisible(By.cssSelector("span.wait"));
		if(isMessagePresent==true){
			getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		WebDriverWait wait = new WebDriverWait(getDriver(), ConstantsHMH.DEFAULT_TIMEOUT_SECONDS);
		boolean element = ((Boolean)wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#HEADER_TITLE > a"), newSiteName))).booleanValue();
		if (element) {
			return true;
		}
		else{
			element(this.siteNotCreatedPopupOkButton).waitUntilVisible();
			this.siteNotCreatedPopupOkButton.click();
			return false;
		}
	}

	public void userButtonClick() {
		waitForElement("span[id *= 'HEADER_USER_MENU']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(this.userButton).waitUntilVisible();
		this.userButton.click();
	}

	public void logoutButtonClick() {
		userButtonClick();
		element(this.logoutButton).waitUntilVisible();
		this.logoutButton.click();
		Assert.assertTrue(
				"Login Page password field was not displayed",
				verifyElementPresent(
						By.cssSelector("input[id $= 'default-password']"), 10));
	}



	public void clickOnStandards(){
		waitForElementID("HEADER_SEARCH_STANDARDS_LINK_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(standards).waitUntilVisible();
		standards.click();
	}

	public void clickOnImportStandards(){
		waitForElementID("HEADER_SEARCH_STANDARDS_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(importStandards).waitUntilVisible();
		importStandards.click();
	}

	public void clickOnSearchStandards(){
		waitForElementID("HEADER_IMPORT_STANDARDS_text", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(searchStandards).waitUntilVisible();
		searchStandards.click();
	}

	public void waitForElement(String cssLocator, int n){

		waitForElement(cssLocator,n,getDriver());

	}
	public void waitForElementX(String xpathLocator, int n){

		waitForElementX(xpathLocator,n,getDriver());

	}
	
	public void clickOnReports(){
		waitForElementX(".//*[text()='Reports']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(reports).waitUntilVisible();
		reports.click();
	}

	public void clickOnReportsLearningSpine() {
		waitForElementX(".//*[text()='Learning Spine']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(learningSpine).waitUntilVisible();
		learningSpine.click();
	}

	public void clickOnMyFiles(){
		element(myFiles).waitUntilVisible();
		myFiles.click();
	}
	
	//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.3 **
	public void clickOnSharedFiles()
	{
		waitForElementX(".//*[text()='Shared Files']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(sharedFiles).waitUntilVisible();
		sharedFiles.click();
	}

	//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
	public  String setDownloadFilePath(String filePath,String title) {
		WebElement txt= getDriver().findElement(By.xpath(("(.//a[contains(text(), '"+title+"')])[1]")));
		return txt.getText();	
	}	

	//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
	public void clickOnExportToExcelLearningSpine(String lsTitle) 
	
	 {
		waitForElementX(".//*[text()='"+lsTitle+"']/following::td[3]//img[1]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement clickOnExportToExcelLS = getDriver().findElement(By.xpath(".//*[text()='"+lsTitle+"']/following::td[3]//img[1]"));
		element(clickOnExportToExcelLS).waitUntilVisible();
		clickOnExportToExcelLS.click();
		System.out.println(lsTitle);
			
		}
	
	//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
	public  String verifyLearningSpineTitle(String lsTitle) {
		
		waitForElementX(".//*[text()='"+lsTitle+"']/following::td[2]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement learningSpineTitle = getDriver().findElement(By.xpath(".//*[text()='"+lsTitle+"']/following::td[2]"));
		element(learningSpineTitle).waitUntilVisible();
		
		String Title = learningSpineTitle.getText();
		String lsverifyTitle = new StringBuilder("LearningSpine_").append(Title).toString();
		System.out.println(lsverifyTitle);
		return lsverifyTitle;
		
	}	
	
	//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
	public void verifyExportedLearningSpineReport(String title) {
					
		WebElement t= getDriver().findElement(By.xpath(("(.//a[contains(text(), '"+title+"')])[1]")));
		System.out.println(t.getText());
		waitABit(500);
		
		boolean isAssetPresent = false;
		isAssetPresent = isElementVisible(By.xpath(("(.//a[contains(text(), '"+title+"')])[1]")));
		if (isAssetPresent == true) {
			System.out.println(title);
		if(t.getText().toLowerCase().contains(title.toLowerCase())) {
			getDriver().findElement(By.xpath(("(.//a[contains(text(), '"+title+"')])[1]"))).click();
		}}
		
		else
		{
			Assert.assertTrue(
					"Asset is not in the list! or not loaded in 5 Minutes",
					isAssetPresent);
		}		
		
		waitABit(1000);
		waitForElementX(".//span[text()='Download']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement download = getDriver().findElement(By.xpath(".//span[text()='Download']"));
		element(download).waitUntilVisible();
		download.click();
		System.out.println(download.getText());
		//waitABit(1000);
		//String sourceLocation = download.getAttribute("href");
		String sourceLocation = (String) ((JavascriptExecutor)getDriver()).executeScript("return arguments[0].innerHTML;", download);
        String wget_command = "cmd /c D:\\LatestCode01June\\Wget\\wget.exe -P D:\\LatestCode01June\\downloads --no-check-certificate " + sourceLocation;
        //String wgetDownloadFile = "wget +sourceLocation+ -O D:\\LatestCode01June\\downloads";
        System.out.println(wget_command);
        try { 
        Process exec = Runtime.getRuntime().exec(wget_command);
        int exitVal = exec.waitFor();
        System.out.println("Exit value: " + exitVal);
        System.out.println("Download completed");
        } catch (InterruptedException | IOException ex) {
        System.out.println(ex.toString());
        System.out.println("Download failed");
        }
		/*
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitABit(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		String filePath = System.getProperty("user.dir");
		String fileName = filePath  + t;
		
		System.out.println(fileName);*/
	}

	//** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 **
	public void clickOnDeleteLearningSpine(String lsTitle) {
	
		waitForElementX(".//*[text()='"+lsTitle+"']/following::td[3]//span[3]", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement clickOnDeleteLS = getDriver().findElement(By.xpath(".//*[text()='"+lsTitle+"']/following::td[3]//span[3]"));
		element(clickOnDeleteLS).waitUntilVisible();
		clickOnDeleteLS.click();
		System.out.println(lsTitle);
		
	}	
	
	//** ALF-2127 ** Delete a Learning Spine and all its associated skills ** Sprint 7.3.3 **
	public void clickOnOkButtonOnDeleteLS()
	{
		
		element(clickOnOkButtonOnDeleteLS).waitUntilVisible();
		clickOnOkButtonOnDeleteLS.click();
	}
	//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
	public void clickOnHelpMenu() {
		waitForElementX("//*[@id='HEADER_HELP']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(helpMenu).waitUntilVisible();
		helpMenu.click();
		
	}

	//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
	public void clickOnReleaseNotes() {
		waitForElementX(".//*[@id='HEADER_HELP_RELEASE_NOTES_text']/a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(relNotes).waitUntilVisible();
		relNotes.click();
		
	}
	
	//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **	
	public void clickOnKnowledgeBase() {
		waitForElementX(".//*[@id='HEADER_HELP_KNOWL_BASE_text']/a", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		element(knowledgeBase).waitUntilVisible();
		knowledgeBase.click();
		
	}
	//** ALF-2158  ** Import and Help option in Alfresco Menu Bar ** Sprint 7.3.3 **
	public void verifyReleaseNotes(String asset) {
		
		boolean isFound =false;
		element(releaseNotes).waitUntilVisible();
		if(releaseNotes.getText().equalsIgnoreCase(asset))
		{
		isFound = true;
		System.out.println(releaseNotes.getText());
		}
			
		element(sprintHeaderDetails).waitUntilVisible();
		System.out.println(sprintHeaderDetails.getText());
		
		Assert.assertTrue("Details not found in the Release Notes", isFound);
		
		
		
		
	}
  // ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
	public void clickCheckBoxToAddToCart() {
		
		waitForElementX("(.//*[@name='fileChecked'])[1]",
				  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement checkBox = getDriver().findElement(By.xpath("(.//*[@name='fileChecked'])[1]"));
		checkBox.click();
		
		waitForElementX("(.//*[@name='fileChecked'])[2]",
				  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement checkBox1 = getDriver().findElement(By.xpath("(.//*[@name='fileChecked'])[2]"));
		checkBox1.click();
				
		
	}
 // ** ALF 993 ** Multi select Content Objects for Correlations Cart ** Sprint 7.3.4 **
	public void clickAddToCartAction() {
		
		waitForElementX(".//button[text()='Selected Items...']",
				  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement selectItems = getDriver().findElement(By.xpath(".//button[text()='Selected Items...']"));
		selectItems.click();
		
		waitForElementX(".//span[@class='onActionAddStandardsCart']",
				  ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		WebElement addToCart = getDriver().findElement(By.xpath(".//span[@class='onActionAddStandardsCart']"));
		addToCart.click();
		
		WebElement okButton = getDriver().findElement(By.xpath(".//button[text()='OK']"));
		okButton.click();
						
	}

	public void clickOnSearchByStandards() {
		
		element(searchContentByStandards).waitUntilVisible();
		searchContentByStandards.click();
		
	}
	
	
	
}
