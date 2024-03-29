package com.hmh.automation.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.hmh.automation.steps.EndAutomation;
import com.hmh.automation.steps.StartAutomation;
import com.hmh.automation.tests.*;

@RunWith(Suite.class)
@SuiteClasses({
		
	//***** Regression Test Suite *****//
	//Start automation -- send email notification
	StartAutomation.class,
	
	Test_REG001_Login.class,
	Test_REG002_SetupForConsumerAndK12WithFolderAndAllAspects.class,
	Test_REG003_CreateProgramK12.class,
	Test_REG004_CreateProductSetK12.class,
	Test_REG004a_CreateProductObjectK12.class,
	Test_REG005_CreateSequenceBundleK12.class, 
	Test_REG006_CreateLearningBundleK12.class,
	Test_REG007_CreateContentObjectK12.class,
	Test_REG008_CreateCompositeContentObjectK12.class,
	Test_REG009_CreateAssetK12.class,
	Test_REG010_CreateProgramConsumer.class,
	
	Test_REG011_CreateProductSetConsumer.class,
	Test_REG011a_CreateProductObjectConsumer.class,
	Test_REG012_CreateSequenceBundleConsumer.class,
	Test_REG013_CreateLearningBundleConsumer.class,
	Test_REG014_CreateContentObjectConsumer.class,
	Test_REG015_CreateCompositeContentObjectConsumer.class,
	Test_REG016_CreateAssetConsumer.class,	
	Test_REG017a_K12BulkUploadAndExtract.class,
	Test_REG017b_ConsumerBulkUploadAndExtract.class,
	Test_REG018_DeleteStructuralAndContentObjects.class,
	Test_REG019_EditSequenceReferenceVersionAndPublishToDraftandQAinK12.class,
	Test_REG020_EditSequenceReferenceVersionAndPublishToDraftandQAinConsumer.class,
	//Test_REG021_CorrelationsAndDataListsInConsumer.class,
	//Test_REG022_CorrelationsAndDataListsInK12.class,
	Test_REG023_AdvanceSearchForConsumer.class,
	Test_REG024_AdvanceSearchForK12.class,
	Test_REG025_FacettedSearch.class,
	Test_REG026_QuickSearch.class,
	
	Test_REG031_VersionAProductSet.class,
	Test_REG032_UploadFileFromEditSequence.class,
	Test_REG033_UploadNewVersion.class,
	Test_REG034_SearchAllTaggedItemsByClickedTagLink.class,  
	Test_REG035_FilterByCategoryAndRemoveCategory.class, 
	//Test_REG036_SavedSearchDashlet.class, 
	Test_REG037_EditPropertiesForMoreThanOneObject.class, //craeteAndDeleteSite
	Test_REG038_CopyAndMoveAnObject.class, //craeteAndDeleteSite
	Test_REG039_ChangeTheTypeOfAnObject.class,
	Test_REG040a_InviteGroupsToMySiteAsViewerRole.class, //craeteAndDeleteSite
	Test_REG040b_InviteUsersToMySiteAsDiffrentRoles.class,
	Test_REG041_AdminFunctionalities.class,
	Test_REG063_ApplyMetadataToPSToReplicateAStructureK12.class,

    //	HABITAT Related Tests***
	Test_REG027_ReferencingPSContentFilesWhilePush.class,
	Test_REG028_PushToHabitatNlevel.class,
	Test_REG028a_PushToHabitatNlevelforPO.class,
	Test_REG029_PullFromHabitatNlevel.class,  //Ignore, duplicate test 
	Test_REG042_PSFPushAndPullFromHabitatNlevel.class,				// BVT test Create and Delete Site
	Test_REG043_VerifyHabitatDataInInklingHabitatCoreSiteAfterPush.class,
	//Test_REG044_EditHabitatDataInInklingHabitatCoreSite.class,
    // Test_REG045_VerifyModifiedHabitatDataInOneCMSusingPullAndVersion.class, // Duplicated as REG117
	//Test_REG046_VerifyBulkUploadFilesAfterExtractK12.class,// Rearranged the test order since open issues related to indexing causing failures	
	//Test_REG047_VerifyBulkUploadFilesAfterExtractConsumer.class,// Rearranged the test order since open issues related to indexing causing failures	
	//Test_REG048_RePushHabitatWithEditsAfterSuccessfullPull.class,
	Test_REG050_CreateAndVerifyProductObjectK12.class,
	Test_REG051_CreateProductObjectAndChangeTypeToPSinConsumer.class,
	Test_REG052_POk12EditSequenceReferenceVersionAndPublishToDraftandQA.class,
	Test_REG053_POConsumerEditSequenceReferenceVersionAndPublishToDraftandQA.class,
	//Test_REG054_ProductObjectPSFPushAndPullFromHabitatNlevelByChangingType.class,
    Test_REG055_ImportAndSearchStandardInOneCMS.class, 
	//Test_REG056_ModifyStructureOrHierarchyOfStandardsImportedToOneCMSDragAndDrop.class, //IN:20492 logged for this script so commented
	Test_REG057_VerifyStatusOfStandardInDraftAndApprovedCollections.class,
	Test_REG058_AddObjectsToCart.class,
	Test_REG059_CorrelateObjectToStandardViewAndRemoveCorrelation.class,	
	Test_REG030_RoleSpecificFunctionlity.class,
	Test_REG060_AdvancedSearchForStructuralObjects.class, // Indexing Issue
	//Test_REG061_ManifestValidationInK12siteWithActualContent.class,
	//Test_REG062_ManifestValidationInConsumerSite.class,
	Test_REG063_QuickSearchTextFieldsWithinResultsforHIP.class,
	Test_REG064_DeliverKeyResourcesToEdK12.class,
	Test_REG064a_K12ImportZipFileCCO.class,
	Test_REG064b_ConsumerImportZipFileCCO.class,
	Test_REG065_AdvanceSearchTextFieldsWithinResultsforHIP.class,
	Test_REG066_FilterDifferentDropdownForSearchStandards.class,
	Test_REG067_FilterDifferentDropdownForImportStandards.class,
	Test_REG068_PublishPSobjectToPOforK12.class,
	Test_REG069_AllSitesAdvanceSearchTextFieldsWithinResultsforHIP.class,
	Test_REG070_RepositoryAdvanceSearchTextFieldsWithinResultsforHIP.class,
	Test_REG071_NewMetadataFieldsCompositeContentObjectK12.class,
	Test_REG072_NewMetadataFieldsContentObjectK12.class,
	Test_REG073_ApplyMetadataToPSToReplicateAStructureCOsInSBsFlagTrueK12.class,
	Test_REG074_ApplyMetadataToPSToReplicateAStructureAssetsInSBsFlagTrueK12.class,
	Test_REG075_AddProductCategoryIcontoProductObject.class,
	Test_REG080_CreateVerifyAssetManagemtSiteMetadata.class,
	Test_REG081_MetadataProductLabeltoProductSetandSearchfunctionality.class,
	Test_REG082_MetadataProductLabeltoProductObjectandSearchfunctionality.class,
	Test_REG084_AssetAdvancedSearchLookForDropdown.class,
	Test_REG085_Bright_Cove_Account_Name_Field.class,
	Test_REG086_K12Auto_Update_File_Ext_Name_COorAsset.class,
	Test_REG087_K12_Remove_Delivary_Loc_Bulk_Copy.class,
	Test_REG089a_K12_Enhance_Deep_Copy.class,
	Test_REG089b_Consumer_Enhance_Deep_Copy.class,
	Test_REG090_Generate_Draft_ePub.class,
	Test_REG091_Relocate_Content_as_a_Collaborator_to_Different_Folder.class,
	Test_Reg092_Allow_Production_Services_to_DisableNDelete_Accounts.class,
	Test_Reg093_Action_on_PS_to_generate_detailsjson_file.class,
	Test_Reg094_K12_HMH_Keywords_free_text_field.class,
	Test_Reg095_Cons_HMH_Keywords_free_text_field.class,
	Test_Reg096_K12_Add_values_product_type_dropdown_metadata_field.class,
	Test_REG097_Enhance_COM_Import.class,
	Test_REG098a_CascadeVersionCommentFromPOdownToAllObjectsK12.class,
	Test_REG098b_CascadeVersionCommentFromPSdownToAllObjectsCon.class,
	Test_REG099_AddUserRoleMetadataFieldtoProductSets.class,
	Test_REG100_Generate_Downladable_Launchable_epubs.class,
	Test_REG101_PersistSearchResultsForHIPAdvancedSearch.class,
	Test_REG102_GenerateRenditionsofCoverImagesBasedonAssetStatus.class,
	Test_REG103_PersistSearchStandardsResults_InOneCMS.class,
	Test_REG104_LearningSpinePhase1UploadViaExcel.class,
	Test_REG105_RegenerateEpubsAndVerify_UserRolevalueChanged.class,
	Test_REG106_ImprovedValidationofProgramLabel.class,
	Test_REG107_VerifyContentAndMetadata_CO_Assets_WithRevertOption.class,
	Test_REG108_ExcludeEpubs_fromStructure_AfterDeepCopy.class,
	Test_REG109_AssociateLearningSpine_fromViewDetailsPage.class, 
	Test_REG110_SetDeliveryLocationOnPlaceholderFiles.class,
	Test_REG111_CreateLearningSpineAdminRoleK12.class,
	Test_REG112_PersistSearchResultsonAssetAdvancedSearch_K12.class,
	//Test_REG113_DeleteLearningSpineAssocations_fromViewDetailsPage.class,// Commented since covering E2E scenario in REG109
	Test_REG114_StandardRecommendationFlag_IncludeIn_PO_CCO_K12.class,
	Test_REG115_CreateAssetRenditionsUponUpdate.class,
	Test_REG116_AuditRecordUpdate_ForAssets_inK12.class,
	Test_REG117_SpecialCharacters_PulledFromHabitat_VerifyInOneCMS.class,
	Test_REG118_AddAssetsToCollections_And_VerifyInGeneratedPDF.class,
	//Test_REG119_DeleteLearningSpine_AndAssociatedSkills.class, // Commented since Amended the delete spine code in REG104(E2E)
	Test_REG120_SelectMetadataToIncludeInStandardsReport.class,
	Test_REG121_AssetUploadToRenditionsFolder_Verify_WithAddingManageAspect.class,
	Test_REG122_VerifyQAReport_OnProductSet_InK12.class,
	Test_REG123_AdvanceSearchbyHabitatShortName.class,
	Test_REG124_VerifyNewHelpMenuOption_InOneCMS.class,
	Test_REG127_InvokeMoveToAction_OnMultipleSearchResults_InK12.class,
	//End automation--send email notification
	EndAutomation.class	
	
	
})

public class TestSuite {

}

