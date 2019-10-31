package com.hmh.automation.tests;

import junit.framework.TestCase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.hmh.automation.steps.HMHLoginSteps;
import com.hmh.automation.steps.HMHShareHeaderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;


@Story(HMHApplication.Login.LoginIntoShare.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG001_Login.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG001_Login extends TestCase {

    @Steps
    private HMHLoginSteps loginSteps;
    @Steps
    private HMHShareHeaderSteps hmhshareHeaderSteps;
    
    @Steps
	private ShareHeaderSteps shareHeaderSteps;

    
    String username, password, siteTypeTest, invUsername, invPassword;
    @Managed(uniqueSession = false)
    public WebDriver driver;
    @ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
    public Pages pages;


    @Test
    @Title("Test_REG001 - Login Functionality")
    public void test_REG001_Login() {
    	shareHeaderSteps.customWait(3);
    	loginSteps.verifyLogoIsDisplayed();
        loginSteps.login(ConstantsHMH.TEST_USER_LOGIN,ConstantsHMH.TEST_PASS_LOGIN);
        hmhshareHeaderSteps.logoutButtonClick();
       // loginSteps.loginRejected(invUsername, password);
     //   loginSteps.loginRejected(username, invPassword);
     //   loginSteps.loginRejected(invUsername, invPassword);
    }
    
    
}
