package com.hmh.automation.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//import com.ixxus.ipm.automation.alfresco.Test22_SearchAllTaggedItemsByClickedTagLink;

import com.hmh.automation.steps.EndAutomation;
import com.hmh.automation.steps.StartAutomation;
import com.hmh.automation.tests.Test_REG001_Login;
import com.hmh.automation.tests.Test_REG002_SetupForConsumerAndK12WithFolderAndAllAspects;
import com.hmh.automation.tests.Test_REG003_CreateProgramK12;
import com.hmh.automation.tests.Test_REG004_CreateProductSetK12;
import com.hmh.automation.tests.Test_REG006_CreateLearningBundleK12;
import com.hmh.automation.tests.Test_REG007_CreateContentObjectK12;
import com.hmh.automation.tests.Test_REG008_CreateCompositeContentObjectK12;
import com.hmh.automation.tests.Test_REG009_CreateAssetK12;
import com.hmh.automation.tests.Test_REG011_CreateProductSetConsumer;
import com.hmh.automation.tests.Test_REG012_CreateSequenceBundleConsumer;
import com.hmh.automation.tests.Test_REG016_CreateAssetConsumer;
import com.hmh.automation.tests.Test_REG017a_K12BulkUploadAndExtract;
import com.hmh.automation.tests.Test_REG019_EditSequenceReferenceVersionAndPublishToDraftandQAinK12;
import com.hmh.automation.tests.Test_REG020_EditSequenceReferenceVersionAndPublishToDraftandQAinConsumer;
import com.hmh.automation.tests.Test_REG024_AdvanceSearchForK12;
import com.hmh.automation.tests.Test_REG026_QuickSearch;
import com.hmh.automation.tests.Test_REG031_VersionAProductSet;
import com.hmh.automation.tests.Test_REG042_PSFPushAndPullFromHabitatNlevel;
import com.hmh.automation.tests.Test_REG043_VerifyHabitatDataInInklingHabitatCoreSiteAfterPush;
import com.hmh.automation.tests.Test_REG050_CreateAndVerifyProductObjectK12;
import com.hmh.automation.tests.Test_REG059_CorrelateObjectToStandardViewAndRemoveCorrelation;
import com.hmh.automation.tests.Test_REG068_PublishPSobjectToPOforK12;
import com.hmh.automation.tests.Test_REG083_CopyHabitatCCOdisplayafterPushToHabitatNlevel;
import com.hmh.automation.tests.Test_REG089a_K12_Enhance_Deep_Copy;
import com.hmh.automation.tests.Test_REG097_Enhance_COM_Import;
import com.hmh.automation.tests.Test_REG101_PersistSearchResultsForHIPAdvancedSearch;
import com.hmh.automation.tests.Test_REG102_GenerateRenditionsofCoverImagesBasedonAssetStatus;
import com.hmh.automation.tests.Test_REG104_LearningSpinePhase1UploadViaExcel;
import com.hmh.automation.tests.Test_REG107_VerifyContentAndMetadata_CO_Assets_WithRevertOption;
import com.hmh.automation.tests.Test_REG110_SetDeliveryLocationOnPlaceholderFiles;
import com.hmh.automation.tests.Test_REG125_LearningSpineCorrelations_VisibleOnViewDetailsPage;

@RunWith(Suite.class)
@SuiteClasses({
	
	//***** BVT SUITE *****
	//Start automation -- send email notification
	StartAutomation.class,	
	Test_REG001_Login.class,
	Test_REG002_SetupForConsumerAndK12WithFolderAndAllAspects.class, //Creating Site and adding all 6 buckets
	Test_REG003_CreateProgramK12.class,
	Test_REG004_CreateProductSetK12.class, 
	Test_REG006_CreateLearningBundleK12.class,
	Test_REG007_CreateContentObjectK12.class,
	Test_REG008_CreateCompositeContentObjectK12.class,
	Test_REG009_CreateAssetK12.class,
	Test_REG011_CreateProductSetConsumer.class,
	Test_REG012_CreateSequenceBundleConsumer.class,
	Test_REG016_CreateAssetConsumer.class,
	Test_REG050_CreateAndVerifyProductObjectK12.class,
	Test_REG017a_K12BulkUploadAndExtract.class,  //Bulkupload taking more time to extract files from R5S0
	Test_REG019_EditSequenceReferenceVersionAndPublishToDraftandQAinK12.class,
	Test_REG020_EditSequenceReferenceVersionAndPublishToDraftandQAinConsumer.class, // Added on 3rd Oct 2018
	Test_REG024_AdvanceSearchForK12.class, //indexing issue
	Test_REG026_QuickSearch.class, //indexing issue
	Test_REG031_VersionAProductSet.class,
	//***** PSF & Habitat related functionalities
	Test_REG042_PSFPushAndPullFromHabitatNlevel.class,
	Test_REG059_CorrelateObjectToStandardViewAndRemoveCorrelation.class, // Added on 3rd Oct 2018
	
	//Test_REG043_VerifyHabitatDataInInklingHabitatCoreSiteAfterPush.class, // Excluding from BVT suite as REG042 would suffice the functionality check
	//Test_REG046_VerifyBulkUploadFilesAfterExtractK12.class,// Bulk upload taking more time to extract
	Test_REG068_PublishPSobjectToPOforK12.class,
	Test_REG083_CopyHabitatCCOdisplayafterPushToHabitatNlevel.class, // Added on 3rd Oct 2018
	Test_REG089a_K12_Enhance_Deep_Copy.class, // Added on 3rd Oct 2018
	Test_REG097_Enhance_COM_Import.class, // Added on 3rd Oct 2018
	Test_REG101_PersistSearchResultsForHIPAdvancedSearch.class, // Added on 3rd Oct 2018
	Test_REG102_GenerateRenditionsofCoverImagesBasedonAssetStatus.class, // Added on 3rd Oct 2018
	Test_REG104_LearningSpinePhase1UploadViaExcel.class,
	Test_REG107_VerifyContentAndMetadata_CO_Assets_WithRevertOption.class, // Added on 3rd Oct 2018
	Test_REG110_SetDeliveryLocationOnPlaceholderFiles.class,
	//Test_REG125_LearningSpineCorrelations_VisibleOnViewDetailsPage.class,  // Added on 3rd Oct 2018
	//End automation--send email notification
	EndAutomation.class	
	
})

public class BVTTestSuite {

}