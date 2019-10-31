package com.hmh.automation.pages;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHCreateUserPage extends AbstractPage {
	private static final Logger LOG = LoggerFactory
			.getLogger(HMHCreateUserPage.class);

	@FindBy(css = "[id $= 'create-main']")
	private WebElement newUserPageContainer;

	@FindBy(css = "[id $= 'create-firstname']")
	private WebElement firstNameField;

	@FindBy(css = "[id $= 'create-lastname']")
	private WebElement lastNameField;

	@FindBy(css = "[id $= 'create-email']")
	private WebElement userEmailField;

	@FindBy(css = "[id $= 'create-username']")
	private WebElement userNameField;

	@FindBy(css = "[id $= 'create-password']")
	private WebElement userPasswordField;

	@FindBy(css = "[id $= 'create-verifypassword']")
	private WebElement verifyPasswordField;

	@FindBy(css = "[id $= 'createuser-ok-button-button']")
	private WebElement createNewUserButton;

	@FindBy(className = "grouppicker-row")
	private WebElement searchGroupContainer;

	@FindBy(css = "input[id $= 'groupfinder-search-text']")
	private WebElement searchGroupField;

	@FindBy(css = "button[id $= 'group-search-button-button']")
	private WebElement searchGroupButton;

	@FindBy(css = "div[id $= 'create-groupfinder-results'] tr")
	private WebElement groupSearchResultsContainer;

	@FindBy(css = "div[id $= 'create-groupfinder-results'] div h3")
	private List<WebElement> groupSearchResultList;

	@FindBy(css = "div[id $= 'create-groupfinder-results'] td[headers *= 'actions'] div span span button")
	private WebElement addGroupButton;

	@FindBy(css = "div[id $= 'create-groupfinder-results']")
	private WebElement groupFinderResultsContainer;

	@FindBy(css = "input[id*='default-update-disableaccount']")
	private WebElement disableAccountCheckbox;

	@FindBy(css = "button[id*='updateuser-save-button']")
	private WebElement saveChangesButton;
	
	@FindBy(xpath = ".//*[@id='page_x002e_ctool_x002e_admin-console_x0023_default-edituser-button-button']")
	private WebElement editUser;
	
	@FindBy(xpath = ".//*[@id='page_x002e_ctool_x002e_admin-console_x0023_default-update-groupfinder-search-text']")
	private WebElement searchGroup;
	
	@FindBy(xpath = ".//*[@id='page_x002e_ctool_x002e_admin-console_x0023_default-update-groupfinder-group-search-button-button']")
	private WebElement searchButton;
	
	
	String addGroupBtns = "div[id $= 'create-groupfinder-results'] td[headers *= 'actions'] div span span button";
	String addButton = "button";
	String returnedSearchGroups = " div h3";
	String notificationMessageCssSelector = "div[id='message'] div.bd span";

	public HMHCreateUserPage(WebDriver driver) {
		super(driver);
	}

	public void createNewUser(String firstName, String lastName,
			String userEmail, String userName, String password,
			String verificationPassword, String group, boolean assertUserCreated) {
		element(this.newUserPageContainer).waitUntilVisible();
		int counter = 0;
		 
		this.firstNameField.click();
		this.firstNameField.sendKeys(new CharSequence[] { firstName });
		this.lastNameField.sendKeys(new CharSequence[] { lastName });
		this.userEmailField.sendKeys(new CharSequence[] { userEmail });
		this.userNameField.sendKeys(new CharSequence[] { userName });
		this.userPasswordField.sendKeys(new CharSequence[] { password });
		this.verifyPasswordField.sendKeys(new CharSequence[] { verificationPassword });
		String[] groupArray=group.split(",");
		int groupSize=groupArray.length;
		
		if (!(group.isEmpty())) {
			for(int j=0;j<groupSize;j++)
			{
				waitABit(3000);
				this.searchGroupField.clear();
				waitABit(3000);
				this.searchGroupField.sendKeys(new CharSequence[] { groupArray[j] });
				waitABit(3000);
				this.searchGroupButton.click();
				waitABit(3000);
				WebElement addBtn=getDriver().findElement(By.xpath(".//*[text()='"+groupArray[j]+"']/following::button"));
				waitABit(5000);
				addBtn.click();
					/*waitABit(2000L);
					boolean found = false;
					List groups = this.groupFinderResultsContainer.findElements(By.cssSelector(this.returnedSearchGroups));
					while ((groups.size() <= 0) && (counter < 10)) {
						waitABit(2000L);
						++counter;
					}
					Assert.assertTrue("List is <= 0", groups.size() > 0);
		
					List addBtns = getDriver().findElements(By.cssSelector(this.addGroupBtns));
					for (int i = 0; i < groups.size(); ++i) {
						if (!(((WebElement) groups.get(i)).getText().toLowerCase().toString().contains(group.toLowerCase())))
							continue;
							((WebElement) addBtns.get(i)).click();
							found = true;
							break;
					}
				*/

			//Assert.assertTrue("The group " + group + "was not found", found);
			}
		}
		element(this.createNewUserButton).waitUntilEnabled();
		this.createNewUserButton.click();
		String notificationTexts = waitUntilNotificationNotVisible();
		if (!(assertUserCreated))
			return;
		String[] notifications = notificationTexts.split("\\|");
		String text1 = "";
		String text2 = "";
		text1 = notifications[0];
		text2 = notifications[1];
		LOG.info("Notification message1: " + text1);
		LOG.info("Notification message2: " + text2);
		Assert.assertTrue("Notification message1: " + text1 + " and message2: " + text2
						  + " Expected: " + "Successfully created new user",
						(text1.contains("Successfully created new user"))
						|| (text2.contains("Successfully created new user")));
	}

	public void createAndCreateAnotherUser(String firstName, String lastName,
			String userEmail, String userName, String password,
			String verificationPassword, String group, String firstName1,
			String lastName1, String userEmail1, String userName1,
			String password1, String verificationPassword1, String group1) {
	}

	public void disableAccountCheckboxClick() {
		element(this.disableAccountCheckbox).waitUntilVisible();
		this.disableAccountCheckbox.click();
	}

	public void saveChangesButtonClick() {
		element(this.saveChangesButton).waitUntilVisible();
		this.saveChangesButton.click();
	}

	public void cancelCreateNewUser() {
	}
	//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.3 **	
	public void editUserAndAssignGroup(String groupName,String user) {
		
		
		waitForElementX(".//a[contains(text(),'"+user+"')]",
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		
		WebElement clickUserFound = getDriver().findElement(By.xpath(".//a[contains(text(),'"+user+"')]"));
		clickUserFound.click();
		
		element(this.editUser).waitUntilVisible();
		this.editUser.click();
		
		element(this.searchGroup).waitUntilVisible();
		this.searchGroup.clear();
		this.searchGroup.sendKeys(groupName);
		
		element(this.searchButton).waitUntilVisible();
		this.searchButton.click();
		
		waitForElementX(".//*[text()='"+groupName+"']/following::button[1]", 
				ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
		
		WebElement addButton = getDriver().findElement(By.xpath(".//*[text()='"+groupName+"']/following::button[1]"));
		addButton.click();
		
	}
	
}