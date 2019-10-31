package com.hmh.automation.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

import com.hmh.automation.utils.AutomationUtils;

public class ConstantsHMH {

	/**** Master Test Data for All Tests ****/

	public static final String TODAY_DATE= todaysDate();
	public static final String SITE_SUFFIX = "CMS";//siteSuffix(); // change this variable for dry runs

	public static final String CONSUMER_SITE_NAME= "zautomation_consumer_search_doNotDelete";
	public static final String K12_SITE_NAME= "zautomation_k12_search_doNotDelete";
	public static final String HABITAT_SITE_NAME= "AUTOBVT_HABITAT_SITE";
	public static final String REG_HABITAT_SITE_NAME= "AUTOREG_HABITAT_SITE1";

	public static final String HIP_SITE_NAME= "HIP Site";

	// CMS51- http://cms-52-no-elasticl-1sophgj0w3j8a-1720185260.us-east-1.elb.amazonaws.com
	// QA- http://10.34.36.46:8080/share/page
	// DEV- http://10.34.36.44:8080/share/page
	//public static final String ALFRESCO_URL = AutomationUtils.getEnvironment();
	//TODO:: Need to populate dynamically. @ManagePages annotation is preventing dynamic urls
	public static final String ALFRESCO_URL = "http://10.34.36.46:8080/share/page"; // QA environment

	//automation_user_02
	public static final String TEST_USER_LOGIN = AutomationUtils.getUserName();

	//welcome
	public static final String TEST_PASS_LOGIN = AutomationUtils.getPassword();

	//Automation User 02
	public static final String ALFRESCO_DISPLAY_NAME = AutomationUtils.getUserDisplayName();

	//Download path
	public static final String DOWNLOAD_PATH = AutomationUtils.getDownloadPath();

	//Driver Path
	public static final String DRIVER_PATH = AutomationUtils.getDriverPath();

	public static final String HABITAT_TEST_USER_LOGIN = "cms.engineering@hmhco.com";
	public static final String HABITAT_TEST_PASS_LOGIN = "habitatToken";


	public static final String CSV_FILES_BASE_PATH_HMH = "csv/";
	public static final String TESTDATA_FILES_BASE_PATH_HMH = "target/test-classes/filesToUpload/";
	public static final String TC19_PATH = "\\target\\TC19manifest\\";
	public static final String TC20_PATH = "\\target\\TC20manifest\\";
	public static final String TC61 = "PSTC61"+SITE_SUFFIX;
	public static final String TC61_PATH = "\\target\\TC61manifest\\";
	public static final String TC62_PATH = "\\target\\TC62manifest\\";
	public static final String DOWNLOADS_PATH = "\\target\\TC19manifest\\";
	public static final String MANIFEST_XSD = "target/test-classes/schema/ccv1p3_lommanifest_v1p0.xsd";
	public static final String DOWNLOADED_FILES_PATH = "\\target\\test-classes\\downloads";
	// public static final String ALFRESCO_URL = "http://alf-qa.hmh.ixxus.co.uk/share";
	public static final String SCRIPT_HELPER="target/test-classes/filesToUpload/script_helper.js";

	public static final char CSV_SEPARATOR = ',';

	public static final String ADMIN_USERNAME = "admin";
	public static final String ADMIN_PASSWORD = "Ohd7raev";

	public static final String TEST_USER_EMAIL = "TestUser@norealemail23143213.com";
	public static final String TEST_USER_GROUP = "alfresco_administrators";

	public static final int SEARCH_RESULTS_MANUAL_SCROLL = 20;
	public static final int DEFAULT_TIMEOUT_SECONDS = 240;

	//roles for permissions
	public static final String USER_ROLE_MANAGER = "Manager";
	public static final String USER_ROLE_COLLABORATOR = "Collaborator";
	public static final String USER_ROLE_CONTRIBUTOR = "Contributor";
	public static final String USER_ROLE_CONSUMER = "Consumer";


	public static final String PREFIX_PRODUCTSET_NAME = "AutoTestPSbvt"+SITE_SUFFIX;
	public static final String REG_PRODUCTSET_NAME = "AutoTestPS3"+SITE_SUFFIX;
	public static final String PREFIX_PRODUCTOBJECT_NAME = "AutoTestPO"+SITE_SUFFIX;

	public static final String todaysDate() {
		DateFormat dateFormat = new SimpleDateFormat("MMddyyz"); //Wed Dec 16 12:21:19 IST 2015  ****("MMddyyyyz")
		Date date = new Date();
		String todayDate= dateFormat.format(date)+ConstantsHMH.SITE_SUFFIX;
		return todayDate;
	}

	public static final String siteSuffix(){

		String siteSuff=RandomStringUtils.randomAlphabetic(4);

		return siteSuff;
	}


	/*
	 * how to run from command line: mvn clean dependency:unpack verify -U -P ft -Dwebdriver.driver=firefox
	 * -Dwebdriver.base.url=http://alf-qa.hmh.ixxus.co.uk/share thucydides:aggregate -Dmaven.test.failure.ignore=true
	 * 
	 * Created in HMH Alfresco Share, the following user from vanilla alfresco constants public static final String ALFRESCO_TEST_USER_LOGIN = "TestUser";
	 * public static final String ALFRESCO_TEST_PASS_LOGIN = "Auto.m@tion";
	 */

}
