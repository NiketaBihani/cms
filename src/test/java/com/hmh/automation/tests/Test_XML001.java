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

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;


@Story(HMHApplication.Login.LoginIntoShare.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG001_Login.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_XML001 extends TestCase {

	@Steps
	private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;

	String username, password, siteTypeTest, invUsername, invPassword;
	String tagName, expValue;
    
    @Managed(uniqueSession = false)
    public WebDriver driver;
    @ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
    public Pages pages;


    @Test
    @Title("Test_REG001 - Login Functionality")
    public void test_REG001_Login() {

//    	hmhDocumentDetailsSteps.verifyManifest(ConstantsHMH.DOWNLOADS_PATH, "sb060816ISTBVYT1");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "manifest", "AutoTestPSbvtBVYT");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "manifest", "PStoPublish");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "manifest", "3.0");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "metadata", "AutoTestPSbvtBVYT");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "metadata", "PStoPublish");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "metadata", "3.0");
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(ConstantsHMH.DOWNLOADS_PATH, "metadata", "sb060816ISTBVYT");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:lom", "AutoTestPSbvtBVYT");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:lom", "PStoPublish");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:general", "AutoTestPSbvtBVYT");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:general", "PStoPublish");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:title", "AutoTestPSbvtBVYT");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:title", "PStoPublish");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "lomimscc:version", "3.0");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "organization", "level1test 1 sb060816ISTBVYT1");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "organization", "level1test 2 sb060816ISTBVYT2");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "item", "level1test 1 sb060816ISTBVYT1");
    	hmhDocumentDetailsSteps.verifyNodeNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "item", "level1test 2 sb060816ISTBVYT2");
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(ConstantsHMH.DOWNLOADS_PATH, "organization", "cco");
    	hmhDocumentDetailsSteps.verifyNodeShouldNotContainValue(ConstantsHMH.DOWNLOADS_PATH, "item", "cco");
    //	hmhDocumentDetailsSteps.verifyTagNameAndValue(ConstantsHMH.DOWNLOADS_PATH, "title", "sb060816ISTBVYT1");
    	
    }
    
    
}
