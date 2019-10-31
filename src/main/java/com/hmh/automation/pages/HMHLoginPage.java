package com.hmh.automation.pages;

	import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.pages.AbstractPage;

	public class HMHLoginPage extends AbstractPage {

		@FindBy(name = "username")
		private WebElement userInput;

		@FindBy(name = "password")
		private WebElement passwordInput;

		@FindBy(css = "button[id*='submit-button']")
		private WebElement loginButton;

		@FindBy(css = "div.error")
		private WebElement errorMessageText;

		@FindBy(css = "div#HEADER_HOME")
		private WebElement homeButton;

		@FindBy(css = "div.theme-company-logo")
		private WebElement logo;
		private String logoutCssSelector = "#HEADER_USER_MENU_LOGOUT_text";

		public HMHLoginPage(WebDriver driver) {
			super(driver);
		}

		public void navigateToUrl(String url) {
			getDriver().get(url);
			getDriver().manage().window().maximize();
		}

		public void enterUsername(String userName) {
			waitForElement("button[id*='submit-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			element(this.userInput).waitUntilVisible();
			this.userInput.clear();
			this.userInput.sendKeys(new CharSequence[] { userName });
		}

		public void enterPassword(String password) {
			element(this.passwordInput).waitUntilVisible();
			this.passwordInput.clear();
			this.passwordInput.sendKeys(new CharSequence[] { password });
		}

		public void loginButtonClick() {
			waitForElement("button[id*='submit-button']", ConstantsHMH.DEFAULT_TIMEOUT_SECONDS, getDriver());
			element(this.loginButton).waitUntilVisible();
			element(this.loginButton).click();
		}

		public void login(String username, String password) {
			getDriver().manage().window().maximize();
	        Dimension d = new Dimension(1364,768);
	        getDriver().manage().window().setSize(d);
	        getDriver().manage().deleteAllCookies();
			try {
				if ((System.getProperty("webdriver.driver") != null)
						&& (System.getProperty("webdriver.driver")
								.contains("iexplorer"))) {
					String currentURL = getDriver().getCurrentUrl();
					if (currentURL.contains("invalidcert")) {
						currentURL = currentURL.split("#")[1];
					}
					String commandLineURL = "";
					if (System.getProperty("webdriver.base.url") != null) {
						commandLineURL = System.getProperty("webdriver.base.url");
					}
					if ((currentURL
							.contentEquals("http://10.34.36.46:8080/share/page"))
							|| (currentURL.contentEquals(commandLineURL))) {
						getDriver()
								.navigate()
								.to("javascript:document.getElementById('overridelink').click()");
						waitABit(2000L);
						Assert.assertTrue(
								"IE redirect in case of invalidcert did not work",
								getDriver()
										.getCurrentUrl()
										.contentEquals(
												"http://10.34.36.46:8080/share/page"));
					} else {
						getDriver().navigate().refresh();
						element(By.cssSelector(this.logoutCssSelector))
								.waitUntilVisible();
						element(By.cssSelector(this.logoutCssSelector)).click();
						Assert.assertTrue("Logout in case of failure did not work",
								this.loginButton.isDisplayed());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			enterUsername(username);
			enterPassword(password);
			element(this.loginButton).click();
			waitABit(2000);
			element(this.homeButton).waitUntilClickable();
			Assert.assertTrue("Home button should exist!",
					this.homeButton.isDisplayed());
		}

		public void verifyLogoIsDisplayed() {
			getDriver().manage().window().maximize();
			element(this.logo).waitUntilVisible();
			Assert.assertTrue("Home button should exist!", this.logo.isDisplayed());
		}

		public void loginRejected(String username, String password) {
			getDriver().manage().window().maximize();
			enterUsername(username);
			enterPassword(password);
			loginButtonClick();
			waitABit(2000L);
			Assert.assertTrue(
					"Error message is not displayed or login was accepted!",
					this.errorMessageText.isDisplayed());
		}

		public void verifyThatCorrectErrorMessageIsDisplayed(String expectedMessage) {
			String message = this.errorMessageText.getText();
			Assert.assertTrue("The message was: " + message,
					message.contains(expectedMessage));
		}


}
