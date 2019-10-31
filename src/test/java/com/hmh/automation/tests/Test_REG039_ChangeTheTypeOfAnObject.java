package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.ObjectOperations.ChangeType.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG039_ChangeTheTypeOfAnObject.csv", separator = Constants.CSV_SEPARATOR)
public class Test_REG039_ChangeTheTypeOfAnObject extends com.hmh.automation.tools.AbstractBaseSiteTestNew {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;

    String ProgramType, name, title, grade, markets, newType, newType2, numberingValue, siteTypeTest, label1;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG039 - Change the type of an object Program>>ProductSet>>ProductObject in Consumer Site")
    public void test_REG039_ChangeTheTypeOfAnObject() {


        hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
        documentLibrarySteps.createNewContent(ProgramType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(name, title, markets);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ProgramsFolder);
        hmhDocumentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick(name);
        documentDetailsSteps.changeTypeButtonDocumentActionsClick();
        documentDetailsSteps.changeType(newType);
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.LEVEL_1_LABEL, label1);
        documentDetailsSteps.changeTypeButtonDocumentActionsClick();
        documentDetailsSteps.changeType(newType2);
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
    }
}
