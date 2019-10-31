=========== HMHCMS-Automation ===================================

###In order to execute the project:

/*com.hmh.automation.tools.ConstatsHMH.java*/
for Dry run/testing of automation tests change the below static value
public static final String SITE_SUFFIX = siteSuffix(); // "sampath"; // change this variable for dry runs
public static final String ALFRESCO_TEST_USER_LOGIN = "automation_user_01";
public static final String ALFRESCO_TEST_PASS_LOGIN = "welcome";

---------------------------------------------------------------------------------------
###Clean project dependencies:

mvn clean dependency:unpack verify -U -P ft -Dwebdriver.driver=firefox -Dwebdriver.base.url=http://10.34.36.46:8080/share thucydides:aggregate -Dmaven.test.failure.ignore=true

###Execute test suite:

mvn clean antrun:run -Dtest.suite=BVTTestSuite -Dshare.instance=http://10.34.36.46:8080 -Dshare.userName=automation_user_02 -Dshare.pass=welcome -Dshare.dispName="Automation User 02" -Ddownload.path=C:\Downloads -Ddriver.path=<fileSystemPath>\chromedriver.exe verify

###Execute test suite with custom settings:

mvn clean antrun:run -Dtest.suite=BVTTestSuite -Dshare.instance=http://10.34.36.46:8080 -Dshare.userName=automation_user_02 -Dshare.pass=welcome -Dshare.dispName="Automation User 02" -Ddownload.path=C:\Downloads -Ddriver.path=<fileSystemPath>\chromedriver.exe verify -s <fileSystemPath>\settings.xml