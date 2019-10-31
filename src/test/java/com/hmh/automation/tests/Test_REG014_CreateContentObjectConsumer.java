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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.hmh.automation.steps.HMHSiteFinderSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;




@Story(HMHApplication.LearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "Test_REG014_CreateContentObjectConsumer.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class Test_REG014_CreateContentObjectConsumer extends com.hmh.automation.tools.AbstractBaseSiteTestNew {
	
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHSetupSteps hmhSetupSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    //
    @Steps
	private HMHSiteFinderSteps hmhSiteFinderSteps;
    @Steps
	private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
	private MyProfileSteps myProfileSteps;
    @Steps
	private UserTrashcanSteps userTrashcanSteps;


    private String typeCO, objectNameCO, activityType, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest, events, description, cwOriginalcontent, viewportSizes, characters, interests, publisher ="DHX";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test_REG014 - Create Content Object in Consumer Site and Verify Metadata Properties")
    public void test_REG014_CreateContentObjectConsumer() {
    	
    
    	hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentDetailsSteps.createLOforConsumer();
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(objectNameCO, grade, rights, market, title);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(ContentObjectsFolder);
        hmhDocumentLibrarySteps.assetFromListClickSub(objectNameCO);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editCwOriginalContent(cwOriginalcontent);
        //hmhEditPropertiesSteps.editLearningStyles(learningStyle);
        hmhEditPropertiesSteps.editCharacterList(characters);
        hmhEditPropertiesSteps.editMinViewportSizeList(viewportSizes);
        hmhEditPropertiesSteps.editInterestWithMultipleSelect(interests); 
        hmhEditPropertiesSteps.editEvents(events);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        hmhEditPropertiesSteps.selectFromPublisherDropDown(publisher);
        shareHeaderSteps.customWait(3);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(5);
        
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME,objectNameCO); 
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.GRADE, grade);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.MEANINGFUL_DESCRIPTION,description);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.cwOriginalcontentLabel,cwOriginalcontent);
        //hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.learningStylesLabel,learningStyle);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.characterLabel,characters);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.viewportLabel,viewportSizes);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.interestLabel,interests);
        hmhDocumentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.eventsLabel,events);

      
        
    }
}
