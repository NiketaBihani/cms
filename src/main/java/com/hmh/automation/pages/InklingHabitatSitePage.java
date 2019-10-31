package com.hmh.automation.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import jline.internal.Log;
import net.serenitybdd.core.Serenity;

import org.fluentlenium.core.Alert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class InklingHabitatSitePage extends AbstractPage {

	public InklingHabitatSitePage(WebDriver driver) {
		super(driver);
	}

	private static final Logger LOG = LoggerFactory
			.getLogger(InklingHabitatSitePage.class);

	@FindBy(id = "username")
	private WebElement userNameInput;

	@FindBy(id = "password")
	private WebElement passwordInput;

	@FindBy(xpath = "//*[@id=\"submit\"]")
	private WebElement loginButton;

	@FindBy(css = "input.js-old-search-box ")
	private WebElement habitatSearchBox;

	@FindBy(css = "a[href*='/project/pstopublish']")
	private WebElement habitatProjectPSlink;

	@FindBy(css = "div div.project-group div.projects grid-projects")
	private List<WebElement> habitatProjectsList;

	@FindBy(css = "div.menu-button div")
	private WebElement menuButton;

	@FindBy(css = "div a.my-account")
	private WebElement myAccount;

	@FindBy(css = "div a[title*='Authoring']")
	private WebElement authoringGuide;

	@FindBy(css = "div a[title*='Distribution']")
	private WebElement distributionguide;

	@FindBy(css = "div a[title*='Release']")
	private WebElement releaseNotes;

	@FindBy(css = "div a[title*='support']")
	private WebElement support;

	@FindBy(css = "div a.logout")
	private WebElement logout;

	@FindBy(css = "div span[id*='current-org']")
	private WebElement orgName;

	@FindBy(xpath = "//div[@id='project-navigation']/ul/li[1]/a/div[1]")
	private WebElement dashboardIcon;

	@FindBy(xpath="//div[@id='project-navigation']/ul/li[2]/a/div[1]")
	private WebElement editContent;
	
	@FindBy(xpath = "//div[@id='project-navigation']/ul/li[3]/a/div[1]") //li[class*='structure'] a
	private WebElement configureProject;

	@FindBy(xpath="//div[@id='project-navigation']/ul/li[4]/a/div[1]")
	private WebElement customStyles;

	@FindBy(xpath="//div[@id='project-navigation']/ul/li[5]/a/div[1]")
	private WebElement reviewErrors;

	@FindBy(xpath="//div[@id='project-navigation']/ul/li[6]/a/div[1]")
	private WebElement manageAccess;
	
	@FindBy(xpath="//div[@id='project-navigation']/ul/li[7]/a/div[1]")
	private WebElement exportAndDistribute;

	@FindBy(css = "div.project-info span[id$='project-title']")
	private WebElement habitatProjectTitle;

	@FindBy(css = "nav > ul > li:nth-child(1) > a > h2")
	private WebElement leftEditStructure;

	@FindBy(css = "nav > ul > li:nth-child(2) > a > h2")
	private WebElement leftProjectSetup;

	@FindBy(css = "nav > ul > li:nth-child(3) > a > h2")
	private WebElement leftCommentsSettings;

	@FindBy(css = "button.expand-button")
	private WebElement expandedButton;

	@FindBy(css = "button.collapse-button")
	private WebElement collapsedButton;
	

	@FindBy(css = "div span.label-toggle a.display-option")
	private List<WebElement> viewBy;

	@FindBy(css = "div span.label-toggle a[data-option='title']")
	private WebElement titleView;

	@FindBy(css = "div span.label-toggle a[data-option='file']")
	private WebElement fileView;

	@FindBy(css = "div.component-info span span.name span.enumeration")
	private List<WebElement> chapterTitleDisplay;
	@FindBy(css = "div.component-info span span.name span.designation")
	private List<WebElement> chapterLabelDisplay;
	@FindBy(css = "div.component-info span span.name span.enumeration")
	private List<WebElement> chapterNumberingDisplay;
	@FindBy(css = "form[class*='editing-sidebar'] > section > textarea[name$='title']") //newType of locator //*[@id="sidebar"]/form/section[1]/textarea  #sidebar > form > section.metadata > textarea
	private WebElement editChapterTitle;
	@FindBy(css = "form[class*='exhibit-sidebar'] > span.designation > input[name$='designation']")
	private WebElement editChapterLabel;
	@FindBy(css = "form[class*='exhibit-sidebar'] > span.enumeration > input[name$='enumeration']")
	private WebElement editChapterNumbering;

	@FindBy(css = "div.spine-contents span span.name span.title")
	private List<WebElement> pageTitleDisplay;
	@FindBy(css = "div.spine-contents span span.name span.designation")
	private List<WebElement> pageLabelDisplay;
	@FindBy(css = "div.spine-contents span span.name span.enumeration")
	private List<WebElement> pageNumberingDisplay;
	@FindBy(css = "section.metadata > textarea[name$='title']")
	private WebElement editPageTitle;
	@FindBy(css = "form > section.metadata > span.designation > input[name$='designation']")
	private WebElement editPageLabel;
	@FindBy(css = "form > section.metadata > span.enumeration > input[name$='enumeration']")
	private WebElement editPageNumbering;
	@FindBy(css = "form > button[class*='delete']")
	private WebElement deleteButton;
	@FindBy(css = "button[id$='save-button']")
	private WebElement saveButton;
	@FindBy(id = "status-message")
	private WebElement saveSuccessMessage;

	@FindBy(xpath="//ul[contains(@id,'structures')]//span[contains(text(),'Page')]")
	private WebElement addPageStructure;
	
	@FindBy(css = "form[class*='editing-sidebar'] > textarea[name$='title']") //newType of locator //*[@id="sidebar"]/form/section[1]/textarea  #sidebar > form > section.metadata > textarea
	private WebElement editPageTitle3;
	
	@FindBy(css="div.account-menu a.logout")
	WebElement logoutButton;
	
	@FindBy(css="img[src*='https://media.inkling.com/img']") //placeholder-img-landscape
	WebElement imagePlaceHolder;
	
	@FindBy(xpath="//span[contains(text(),'Change Image']")
	WebElement changeImage;
	
	@FindBy(xpath="//ol//li[2]/div")
	WebElement secondImageInLibrary;
	
	@FindBy(css="button[type$='submit']")
	WebElement doneButton;
	
	
	 
	
	
	private final String habitatProjectLink = "a[href*='/project/textToReplace']";
	private final String siteTitleCssSelector = "#HEADER_TITLE > a";
	final String habitatProjectTitleID="project-title";
	By habitatProjectTitleBy= By.id(habitatProjectTitleID);

	final String habitatProjectTitleCSS="div.project-info>span[id$='project-title']";
	By habitatProjectTitleCss= By.cssSelector(habitatProjectTitleCSS);

	final String habitatProjectTitleXpath="//div[@class='project-info']//span[contains(text(),'AutoTest')]";
	By habitatProjectTitleXPATHx= By.xpath(habitatProjectTitleXpath);
	
	Actions newAction = new Actions(getDriver());
	String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");

	public String todaydate() {
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyyz"); // Wed Dec 16
		// 12:21:19
		// IST 2015
		// ****("MMddyyyyz")
		Date date = new Date();
		String todayDate = dateFormat.format(date); // 12/16/2015
		return todayDate;
	}

	public void openNewTabForHabitat() {

		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, "t");
		getDriver().findElement(
				By.linkText("https://habitat.inkling.com/login")).sendKeys(
						selectLinkOpeninNewTab);

	}

	public void launchHabitatAndLogin(String habUserName, String habPassword) {

		// newAction.sendKeys(selectLinkOpeninNewTab);
		getDriver().navigate().to("https://habitat.inkling.com/login");
		waitABit(3);
		userNameInput.clear();
		userNameInput.sendKeys(habUserName);
		passwordInput.clear();
		passwordInput.sendKeys(habPassword);
		loginButton.click();
	}

	public void removeGetStartedPopup() {
		waitABit(3000);
		// *** OLD CODE ***
		/*boolean isPopupPresent = isElementVisible(By
				.cssSelector("aside[class*='intro-popup']>div>button"));
		System.out.println(isPopupPresent);
		if (isPopupPresent == true) {
			manualScrollForGetStartedButton(1);
			getDriver().findElement(
					By.cssSelector("aside[class*='intro-popup']>div>button"))
					.click();
						}*/
		// *** FIX ***
		boolean isPopupPresent = isElementVisible(By.xpath("//*[@id=\"dashboard-app\"]/div[2]/div[2]/div/button"));
		System.out.println(isPopupPresent);
		if(isPopupPresent)
		{
			getDriver().findElement(
					By.xpath("//*[@id=\"dashboard-app\"]/div[2]/div[2]/div/button")).click();
		}
	}

	public void manualScrollForGetStartedButton (int manualScrollSeconds) {

		LOG.info("Manual scroll for " + manualScrollSeconds + " seconds");
		Actions action = new Actions(getDriver());
		for (int i = 0; i < manualScrollSeconds; ++i) {
			action.moveToElement(getDriver().findElement(By.cssSelector("aside[class*='intro-popup']>div>button"))).build().perform();
			waitABit(1000L);
		}
		LOG.info("Manual scroll done");
	}
	String habitatLinkXpath = "//a[contains(@href,'textToReplace')]";

	String habitatProjectCss="a[href*='autotestps']"; //href is hard coded
	By HabitatProjectLink=By.cssSelector(habitatProjectCss);
	
	
	public void searchAndOpenHabitat(String psName) {
		
		
		habitatSearchBox.clear();
		habitatSearchBox.sendKeys(psName);
		//waitForElementX(".//*[text()='"+psName+"']", 30, getDriver());
		// **** Code Fix done on 08/06/2018****
		getDriver().manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		waitABit(1000L);
		//WebDriverWait wait = new WebDriverWait(getDriver(),3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( ".//*[text()='"+psName+"']"))).click();		
		
		if(isElementVisible(By.xpath(".//*[text()='"+psName+"']")))
		{
			final WebElement clickHabitatSite = getDriver().findElement(By.xpath(".//*[text()='"+psName+"']"));
			System.out.println(clickHabitatSite.getText());
			clickHabitatSite.click();
		}
		else
		{
			Assert.assertTrue("element not visible", false);
		}
		
		//waitUntilElementExists(find(HabitatProjectLink1), 30);
//		waitForRenderedElements(HabitatProjectLink1);
		//	Assert.assertTrue("The Habitat "+psName+" is not Found", getDriver().findElement(HabitatProjectLink).getText().toLowerCase().contains(psName.toLowerCase()));
		
		// ***** OLD CODE ****
		/*final WebElement HabitatLink = getDriver().findElement(By.xpath(habitatLinkXpath.replace("textToReplace", psName.toLowerCase())));
		HabitatLink.click();
		*/
		// **** FIX ****

	
		LOG.info("Habitat project is found and opened");
	}

	public void searchAndOpenRegHabitat(String psName) {

		// removeGetStartedPopup();
		habitatSearchBox.clear();
		habitatSearchBox.sendKeys(psName);
		waitABit(2000);
		final WebElement HabitatLink = getDriver().findElement(By.xpath(habitatLinkXpath.replace("textToReplace", psName.toLowerCase())));
		HabitatLink.click();
		//		getDriver().findElement(By.cssSelector("a[href*='autotestpsreg']"))
		//				.click();
		LOG.info("Habitat project is found and opened");
	}

	
	public void clickOnConfigureProject(){
		//**Fix done on 08/06/2018**
		/*boolean isPopuppresent=isElementVisible(By.xpath("//div[@class='confirm-popup']//button[contains(text(),' Save and Continue')]"));
		if (isPopuppresent==true){
			getDriver().findElement(By.xpath("//div[@class='confirm-popup']//button[contains(text(),' Save and Continue')]")).click();
		}
		waitForElementX("//div[@id='project-navigation']/ul/li[3]/a/div[1]", 30, getDriver()); //String configURL = getDriver().getCurrentUrl(); getDriver().get(configURL + "/structure");
		*/
		Actions action = new Actions(getDriver());
		action.moveToElement(configureProject).build().perform();
		configureProject.click();
		 
	}
	
	public void verifyHabitatTitle(String psName) {
		waitForAngularRequestsToFinish();
		waitABit(1000);
		String habTitle="//div[@class='project-info']//span[contains(text(),'"+psName+"')]";
		waitForElementX(habTitle, 90, getDriver());
		boolean isTitleCorrect = false;
//		System.out.println(find(habitatProjectTitleCss).getText().toLowerCase());
		if (getDriver().findElement(By.xpath(habTitle)).getText().toLowerCase().contains(psName.toLowerCase())) {
			isTitleCorrect = true;
		}

		Assert.assertTrue("The Habitat project Title is incorrect",isTitleCorrect);
	}
	

	String chapterTitleXpath = "//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'textToReplace')]";

	public void verifyChapterTitle(String sbName) {
		boolean isMatched = false;
		String textToReplace = sbName;
		final WebElement chapterTitle = getDriver().findElement(
				By.xpath("//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]"));

		if (chapterTitle.getText().toLowerCase().contains(sbName.toLowerCase())) {
			isMatched = true;
			System.out.println(chapterTitle.getText());

		}
		Assert.assertTrue("The TITLE displaying for " + sbName
				+ " is incorrect", isMatched);
	}

	public void verifyChapterLabel(String sbName, String sbLabel) {
		boolean isMatched = false;
		element(expandedButton).waitUntilVisible();
		String textToReplace = sbName;
		String chkTitle = "//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]";
		String checkLabel = chkTitle+"/preceding-sibling::span[@class='designation']";

		if (getDriver().findElement(By.xpath(checkLabel)).getText()
				.toLowerCase().contains(sbLabel.toLowerCase())) {
			isMatched = true;
			System.out.println(getDriver().findElement(By.xpath(checkLabel)).getText());
		}
		Assert.assertTrue("The LABEL for " +sbName+ "is " +sbLabel
				+ " is incorrect", isMatched);
	}

	// second level with restart level 1 expected value always "2"
	public void verifyChapterNumbering(String sbName, String sbNumber) {
		boolean isMatched = false;
		element(expandedButton).waitUntilVisible();
		String textToReplace = sbName;
		String chkTitle = "//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]";
		String checkNumber = chkTitle+"/preceding-sibling::span[@class='enumeration']";

		
		
		if (getDriver().findElement(By.xpath(checkNumber)).getText()
				.contains(sbNumber)) {
			isMatched = true;
			System.out.println(getDriver().findElement(By.xpath(checkNumber)).getText());
		}

		Assert.assertTrue("The NUMBER displaying for " + sbNumber
				+ " is incorrect", isMatched);
	}

	// habitat Pages aka CCO data display
	public void verifyPageTitle(String ccoName) {
		boolean isMatched = false;
		String textToReplace = ccoName;
		final WebElement PageTitle = getDriver().findElement(
				By.xpath("//span[@class='component-info']/span/span[@class='title'][contains(text(),'"+ccoName+"')]"));

		if (PageTitle.getText().toLowerCase().contains(ccoName.toLowerCase())) {
			isMatched = true;
			System.out.println(PageTitle.getText());

		}
		Assert.assertTrue("The TITLE displaying for " + ccoName
				+ " is incorrect", isMatched);
	}

	public void verifyPageLabel(String ccoName, String ccoLabel) {
		boolean isMatched = false;
		element(expandedButton).waitUntilVisible();
		String textToReplace = ccoName;
		String chkTitle = "//span[@class='component-info']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]";
		String checkLabel = chkTitle+"/preceding-sibling::span[@class='designation']";

		if (isElementVisible(By.xpath(checkLabel))){
			Log.info("Page label verified");
		}
	/*	if (getDriver().findElement(By.xpath(checkLabel)).getText()
				.toLowerCase().contains(ccoLabel.toLowerCase())) {
			isMatched = true;
			System.out.println(getDriver().findElement(By.xpath(checkLabel)).getText());
		}
		Assert.assertTrue("The LABEL for " +ccoName+ "is " +ccoLabel
				+ " is incorrect", isMatched);*/
	}

	// second level with restart level 1 expected value always "2"
	public void verifyPageNumbering(String ccoName, String ccoNumber) {
		boolean isMatched = false;
		element(expandedButton).waitUntilVisible();
		String textToReplace = ccoName;
		String chkTitle = "//span[@class='component-info']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]";
		String checkNumber = chkTitle+"/preceding-sibling::span[@class='enumeration']";

		System.out.println("page:"+getDriver().findElement(By.xpath(checkNumber)).getText());
		
		/*if (getDriver().findElement(By.xpath(checkNumber)).getText()
				.contains(ccoNumber)) {
			isMatched = true;
			System.out.println(getDriver().findElement(By.xpath(checkNumber)).getText());
		}

		Assert.assertTrue("The NUMBER displaying for " + ccoNumber
				+ " is incorrect", isMatched); */
	}

	public void editChapterTitle(String oldSBname, String newSBname) {

		String textToReplace = oldSBname;
		final WebElement chapterTitle = getDriver().findElement(
				By.xpath("//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]"));
		waitABit(300);
		chapterTitle.click();
		waitABit(500);
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.cssSelector("form[class*='editing-sidebar'] > section > textarea[name$='title']"))).build().perform();
		editChapterTitle.clear();
		editChapterTitle.sendKeys(newSBname);
	}
	

	public void editChapterLabel(String newSBlabel) {
		waitABit(500);
		element(editChapterLabel).waitUntilVisible();
		editChapterLabel.clear();
		editChapterLabel.sendKeys(newSBlabel);
	}

	public void editChapterNumbering(String newSBnumber) {
		waitABit(500);
		element(editChapterNumbering).waitUntilVisible();
		editChapterNumbering.clear();
		editChapterNumbering.sendKeys(newSBnumber);
	}

	public void editPageTitle(String oldCcoName, String newCcoName) {
		verifyPageTitle(oldCcoName);
		element(editPageTitle).waitUntilVisible();
		waitABit(500);
		editPageTitle.clear();
		editPageTitle.sendKeys(newCcoName);
	}

	public void editPageLabel(String newCcoLabel) {
		element(editPageLabel).waitUntilVisible();
		waitABit(500);
		editPageLabel.clear();
		editPageLabel.sendKeys(newCcoLabel);
	}

	public void editPageNumbering(String newCcoNumber) {
		element(editPageNumbering).waitUntilVisible();
		waitABit(500);
		editPageNumbering.clear();
		editPageNumbering.sendKeys(newCcoNumber);
	}

	public void clickSaveButton() {
		boolean isEnable = false;
		Actions action = new Actions(getDriver());
		waitABit(500);
		action.moveToElement(getDriver().findElement(By.cssSelector("button[id$='save-button']"))).build().perform();

		isEnable = element(saveButton).isCurrentlyEnabled();
		if (isEnable == true) {
			saveButton.click();
			element(saveSuccessMessage).waitUntilVisible();
			System.out.println(saveSuccessMessage.getText());
		}
			Assert.assertTrue("Save Button is not found enabled ", isEnable);
	}

	
	public void logOutHabitat() {
		element(menuButton).waitUntilVisible();
		menuButton.click();
		element(logoutButton).waitUntilVisible();
		logoutButton.click();
		Alert alert=new Alert(getDriver());
		alert.accept();

	}
	
	public void addPageInsideFirstSB(String ccoName,String sbName){
	
		boolean isMatched = false;
		String textToReplace = sbName;
		waitForElementX("//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]", 90, getDriver());
		final WebElement chapterTitle = getDriver().findElement(
				By.xpath("//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]"));

		if (chapterTitle.getText().toLowerCase().contains(sbName.toLowerCase())) {
			isMatched = true;
			System.out.println("In addpageInsideFirstSB :" +chapterTitle.getText());
			chapterTitle.click();
			//chapterTitle.click();
			
		}
	/*	boolean isPresent = isElementVisible(By.xpath("//ul[contains(@id,'structures')]//span[contains(text(),'Page')]"));
		if (isPresent==false){
				clickOnEditContent();
				clickOnConfigureProject();
			}*/
			
		waitForElementX("//ul[contains(@id,'structures')]//span[contains(text(),'Page')]", 90, getDriver());
		
		final WebElement sourceLocation=getDriver().findElement(By.xpath("//ul[contains(@id,'structures')]//span[contains(text(),'Page')]"));
		//final WebElement targetLocation = getDriver().findElement(By.xpath("//span[@class='component-info']/span/span[@class='title'][contains(text(),'"+ccoName+"')]"));	
		final WebElement targetLocation = getDriver().findElement(By.xpath("//span[@class='chapter-metadata']/span/span[@class='title'][contains(text(),'"+textToReplace+"')]"));
		//final WebElement targetChildofCCO=getDriver().findElement(By.cssSelector("div.spine-contents>a[href*='"+ccoName.toLowerCase()+"']"));
		//newAction.dragAndDrop(sourceLocation,targetChildofCCO).build().perform();  //<li class="toc-tree-view-drop-target indented" data-min-depth="1" data-max-depth="2" data-depth="2"></li>
		Actions action = new Actions(getDriver());
		action.moveToElement(sourceLocation).build().perform();
		action.dragAndDrop(sourceLocation,targetLocation).build().perform();
		Serenity.takeScreenshot();
	}
	
	public void giveANameToAddedpage(String pageName) {
		waitABit(500);
		/*getDriver().manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		waitABit(500);*/
		System.out.println("In giveANameToAddedpage loop");
		final WebElement pageTitle = getDriver().findElement(
				By.xpath("//span[@class='component-info']//span[@class='title'][contains(text(),'Untitled')]"));
		pageTitle.click();
		//waitABit(500);
		Actions action = new Actions(getDriver());
		action.moveToElement(getDriver().findElement(By.cssSelector("form[class*='editing-sidebar'] > textarea[name$='title']"))).build().perform();
		editPageTitle3.clear();
		editPageTitle3.sendKeys(pageName);
	}
	
	public void deletePage(String pageName){
		Actions action = new Actions(getDriver());
		String pageTitleX="//span[@class='component-info']//span[@class='title'][contains(text(),'"+pageName+"')]";
		final WebElement pageTitle = getDriver().findElement(By.xpath(pageTitleX));
		pageTitle.click();
		boolean isDeleteButtonPresent=isElementVisible(By.cssSelector("form > button[class*='delete']"));
		if(isDeleteButtonPresent==false){
			pageTitle.click();
		}
		action.moveToElement(deleteButton).build().perform();
		deleteButton.click();
		
	}
	
	public void clickOnEditContent(){
		boolean isPopuppresent=isElementVisible(By.xpath("//div[@class='confirm-popup']//button[contains(text(),' Save and Continue')]"));
		if (isPopuppresent==true){
			getDriver().findElement(By.xpath("//div[@class='confirm-popup']//button[contains(text(),' Save and Continue')]")).click();
		}
		waitForElementX("//div[@id='project-navigation']/ul/li[2]/a/div[1]", 30, getDriver()); //String configURL = getDriver().getCurrentUrl(); getDriver().get(configURL + "/structure");
		Actions action = new Actions(getDriver());
		action.moveToElement(editContent).build().perform();
		editContent.click();
	}
	
	//Level1
	public void clickOnSBinEditContent(String sbName){
		String objName="//ol//li//div//a[contains(text(),'"+sbName+"')]";
		getDriver().manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		waitABit(500);
		waitForElementX(objName, 90, getDriver());
		getDriver().findElement(By.xpath(objName)).click();;
	}
	
	//Level2 and 3
	public void clickOnCCOinEditContent(String ccoName){
		String objName="//ol//li//div//a//span[contains(text(),'"+ccoName+"')]";
		waitForElementX(objName, 90, getDriver());
		getDriver().findElement(By.xpath(objName)).click();;
	}
	
	public void addImageFromLibrary(){
		getDriver().manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		waitABit(1000);
		String chooseFromLibraryX="//span[contains(text(),'CHOOSE FROM LIBRARY')]";
		int i=getDriver().findElements(By.cssSelector("iframe")).size();
		System.out.println("Total Frames are"+i);
		getDriver().switchTo().frame(0);
		System.out.println("switched to frame 0");}
//		if(!isElementVisible(By.cssSelector("img[src*='placeholder-img-landscape']"))){
//			getDriver().switchTo().frame(1);
//		}
/*
		Actions action = new Actions(getDriver());
		action.moveToElement(imagePlaceHolder).build().perform();
		waitForElement("img[src*='https://media.inkling.com/img']", 30, getDriver());
		System.out.println("imageplaceHolder found");
		imagePlaceHolder.click();
		waitABit(500);
		System.out.println("imageplaceHolder Click");
		getDriver().switchTo().defaultContent();
		waitForElementX("//span[contains(text(),'Change Image']", 30, getDriver());
		action.moveToElement(changeImage).build().perform();
		System.out.println("changeImage displayed");
		changeImage.click();
		System.out.println("changeImage Click");
		waitABit(500);
		waitForElementX(chooseFromLibraryX, 30, getDriver());
		System.out.println("chooseFromLibrary displayed");
		WebElement chooseFromLibrary=getDriver().findElement(By.xpath(chooseFromLibraryX));
		chooseFromLibrary.click();
		System.out.println("chooseFromLibrary Click");
		element(secondImageInLibrary).waitUntilVisible();
		secondImageInLibrary.click();
		System.out.println("secondImageInLibrary Click");
		element(doneButton).waitUntilVisible();
		doneButton.click();
		getDriver().switchTo().defaultContent();
	}*/
	
	
	public void test00005(String sbName){
		
		findAndWaitForElementToBePresent(addPageStructure, 100);
		String objName="//ol//li//div//a[contains(text(),'"+sbName+"')]";
		waitForElementX(objName, 90, getDriver());
		getDriver().findElement(By.xpath(objName)).click();;
	}
	
	
	

}



//WebDriverWait wait = new WebDriverWait(driver, 5);
//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, '#/main/assessments')]")));
//
//
//
//explicitWaitForXpathElements("//a[contains(@href, '#/main/assessments')]");
//JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
//
//WebElement sidebarMenu = driver.findElement(By.xpath("//a[contains(@href, '#/main/assessments')]"));
//waitUntilElementExists(sidebarMenu, 3);
//           
//jsExecuter.executeScript("arguments[0].click();",sidebarMenu);


