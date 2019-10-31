package com.hmh.automation.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ixxus.ipm.automation.pages.AbstractPage;

public class HMHSiteMembersPage extends AbstractPage {
	public HMHSiteMembersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = ".//*[@class='search-text']/input[1]")
	private WebElement searchUsersInput;

	@FindBy(xpath = ".//*/button[text()='Search']")
	private WebElement searchUserButton;
	
	
	
	@FindBy(css = "div[id = 'HEADER_SITE_MEMBERS']")
	private WebElement siteMembersLink;
	
	@FindBy(xpath = "//a[contains(text(),'Groups')]")
	private WebElement GroupsLink;
	
	@FindBy(xpath = "//button[@id='yui-gen16-button']")
	private WebElement RemoveButton;
	
	@FindBy(xpath = "//input[@id='template_x002e_site-groups_x002e_site-groups_x0023_default-term']")
	private WebElement SearchText;
	
	@FindBy(xpath = "//button[@id='template_x002e_site-groups_x002e_site-groups_x0023_default-button-button']")
	private WebElement Search;
	
	@FindBy(xpath = "//a[contains(text(),'Add Groups')]")
	private WebElement AddGroups;
	
	@FindBy(xpath = "//a[contains(text(),'Add')]")
	private WebElement Add;
	
	@FindBy(xpath = "//h3[contains(text(),'CMS Production Services')]")
	private WebElement Group;
	
	public void clickSiteMembers(){
		element(siteMembersLink).waitUntilVisible();
		siteMembersLink.click();
		waitABit(500);		
	}
	public void clickGroups(){
		element(GroupsLink).waitUntilVisible();
		GroupsLink.click();
		waitABit(500);		
	}
	public void verifyGroupIsPresent(){
		element(Group).waitUntilVisible();
		
		System.out.println("Group is:"+Group.getText());
		String GroupPresent=Group.getText();
		//Group.click();
		waitABit(500);	
		Assert.assertTrue("Group name not matched", (GroupPresent.trim()).equals((Group).getText().trim()));
		System.out.println("Group Matched ");
	}
	String NumberOfGroups=".//*[@class='yui-dt0-col-fullName yui-dt-col-fullName']";
	org.openqa.selenium.By NumberOfGroupsXpath=By.xpath(NumberOfGroups);
	
	
	public void addUser(String userName) {
		boolean found = true;
		this.element(this.searchUsersInput).waitUntilVisible();
		this.searchUsersInput.clear();
		this.searchUsersInput.sendKeys(new CharSequence[]{userName});
		this.element(this.searchUserButton).waitUntilVisible();
		this.searchUserButton.click();
		waitABit(5000);
		WebElement add = getDriver().findElement(By.xpath(".//*/span[text()='"+"("+userName+")"+"']/following::button[1]"));
		waitABit(5000);
		add.click();
	
		
		
		Assert.assertTrue("The user was not found", found);
	}
	
	public void verifyGroupIsDeleted(){
		
			int RowsizeBeforeDeletion=findAll(NumberOfGroupsXpath).size();
			System.out.println("Rowsize before deletion:"+RowsizeBeforeDeletion);
				int RowsizeAfterDeletion=findAll(NumberOfGroupsXpath).size()	;
				System.out.println("Rowsize after deletion:"+RowsizeAfterDeletion);
				Assert.assertTrue("Group not deleted", RowsizeAfterDeletion>RowsizeAfterDeletion);
				System.out.println("Group is Deleted");
				
			}
	

public void checkSiteMember(String memberName, String role) {
	boolean nameCorrect = false;
	boolean roleCorrect = false;
	System.out.println(memberName);
	System.out.println(role);
	getDriver().switchTo().defaultContent();
	getDriver().switchTo().frame("main");
	WebElement roleName= getDriver().findElement(By.xpath(".//*/a[text()='"+memberName+"']/following::div[1]"));
	System.out.println(roleName.getText());
	if(isElementVisible(By.xpath(".//*/a[text()='"+memberName+"']")))
	{
		nameCorrect=true;
		if(roleName.getText().toLowerCase().contentEquals(role.toLowerCase()))
		{
			roleCorrect=true;
		}
	}
	

	Assert.assertTrue("The member was not found!", nameCorrect);
	Assert.assertTrue("The role was not found", roleCorrect); 
	}
}

