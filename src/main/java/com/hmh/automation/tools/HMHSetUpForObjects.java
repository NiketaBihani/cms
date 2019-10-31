package com.hmh.automation.tools;

import net.thucydides.core.annotations.Steps;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.steps.HMHSetupSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

public class HMHSetUpForObjects {
	
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
	    
	    private String folderName, typeCO, objectNameCO, activityType, grade, language, market, lifecycle, learningStyle, interactivityLevel, socialInteraction, rights, title, resourceType, siteTypeTest, events, description, cwOriginalcontent, viewportSizes, characters, interests;

	    String nameLabel = "Name";
	    String gradeLabel = "Grade";
	    String CodeLabel = "Code Repository URL";
	    String cwOriginalcontentLabel = "CW Original Content(HMH Owned)";
	    String descriptionLabel = "Meaningful Description";
	    String interestLabel = "Interest";
	    String characterLabel ="Characters";
	    String viewportLabel="Minimum Viewport Size:";
	    String learningStylesLabel ="Learning Styles";
	    String eventsLabel ="Events";

	 public void createContentObjectConsumer() {
    	
    	hmhDocumentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentDetailsSteps.createLOforConsumer();
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(objectNameCO, grade, rights, market, title);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        hmhDocumentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.assetFromListClick(objectNameCO);
        shareHeaderSteps.customWait(4);
//        hmhDocumentDetailsSteps.clickOnEditPropertiesDetails();
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editCwOriginalContent(cwOriginalcontent);
        hmhEditPropertiesSteps.editLearningStyles(learningStyle);
        hmhEditPropertiesSteps.editCharacterList(characters);
        hmhEditPropertiesSteps.editMinViewportSizeList(viewportSizes);
        hmhEditPropertiesSteps.editInterestWithMultipleSelect(interests); 
        hmhEditPropertiesSteps.editEvents(events);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        editPropertiesDocumentSteps.saveButtonClick(); 
	}    

	 
	 String typeAsset, objectNameAsset, cwOriginalcontent2;
	 
	 public void createAssetConsumer() {

    	 hmhDocumentLibrarySteps.assetFromListClick(folderName);
    	 documentLibrarySteps.createNewContent(typeAsset);
         hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
         hmhDocumentLibrarySteps.createComponentConsumerSite(objectNameAsset, title, rights, grade, lifecycle, resourceType);
         hmhDocumentLibrarySteps.refresh();
         hmhDocumentLibrarySteps.assetFromListClick(objectNameAsset);
         shareHeaderSteps.customWait(3);
         
         documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
         hmhEditPropertiesSteps.editDescription(description);
         hmhEditPropertiesSteps.editCwOriginalContent(cwOriginalcontent2);
         hmhEditPropertiesSteps.editLearningStyles(learningStyle);
         hmhEditPropertiesSteps.editCharacterList(characters);
	     hmhEditPropertiesSteps.editMinViewportSizeList(viewportSizes);
	     editPropertiesDocumentSteps.saveButtonClick();
	 }

}
