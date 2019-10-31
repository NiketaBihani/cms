package com.hmh.automation.steps;

import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHDocumentLibraryPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHDocumentLibrarySteps extends AbstractSteps<HMHDocumentLibraryPage> {

    private static final long serialVersionUID = -854602134541078184L;

    public HMHDocumentLibrarySteps(final Pages pages) {
        super(pages, HMHDocumentLibraryPage.class);
    }

   
    @Step("Verify draft ePub")
    public void ePubDraftClcik(String shortname){
        currentPage().ePubDraftClick(shortname);
    }
    
    
    @Step("Verify Folder displayed in Document Library page")
    public boolean verifyFolderIsDisplayed(String foldername){
        
    boolean fold = currentPage().verifyFolderIsDisplayed(foldername);
    return fold;
    }
    
    
    @Step("Verify Delivery Location")
    public void verifyDeliveryLoc(){
        currentPage().verifyDeliveryLoc();
    }
    
    @Step("Verify Set Target Delivery Location Before ")
    public void verifyTargetDeliveryLoc(){
        currentPage().verifyTargetDeliveryLoc();
    }
    
    
    @Step("Verify Set Target Delivery Location Before ")
    public void afterSetverifyTargetDeliveryLoc(){
        currentPage().afterSetverifyTargetDeliveryLoc();
    }
    
   
    
    @Step("Verify & Click on Target Delivery Location")
    public void verifySetDeliveryLoc(){
        currentPage().verifySetDeliveryLoc();
    }
    
    @Step("Generate details.json File option")
    public void generateJsonFile(){
        currentPage().generateJsonFile();
    }
    
    
    @Step("Verify details.json file")
    public void json(String objectName){
        currentPage().json(objectName);
    }
    
    @Step("Chose option from selected items")
    public void choseOptionFromSelectedItems(final String optionToSelect) {
        currentPage().choseOptionFromSelectedItems(optionToSelect);
    }
    
    @Step ("Verify the Aspeect {0} Is Set to the folder")
    public void verifyAspectIsSet(final String aspectName) {
    	currentPage().verifyAspectIsSet(aspectName);
    }
    
    @Step ("Click on Cancel button on Manage Aspect Window")
    public void cancelManageAspectButtonClick() {
    	currentPage().cancelManageAspectButtonClick();
    }
    

    @Step("Select item in document library")
    public void selectItem(final String itemName) {
        currentPage().selectItem(itemName);
    }

    @Step("Create a Program named {0} with grade{1}")
    public void createProgram(final String name, final String title, String market) {
        currentPage().createProgram(name, title, market);
    }
    
    @Step("Select hnh EditProperties")
    public void hmhEditPropertiesClick(final String asset) {
        currentPage().hmhEditPropertiesClick(asset);
    }

    @Step("Click create button when mandatory fields are not filled")
    public void createObjectWhenNotAllMandatoryMetadataFieldsAreFilled() {
        currentPage().createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
    }

    @Step("Check if duplicate file is created")
    public void duplicataAssetNotCreated(String assetName) {
        currentPage().duplicataNameMessageShow(assetName);
    }

    @Step("Create product set {0}")
    public void createProductSet(final String name, final String year, final String grade, final String levle1, final String level1Restart,
            final String market, final String title) {
        currentPage().createProductSet(name, year, grade, levle1, level1Restart, market, title);
    }
    
    @Step("Create product object {0}")
    public void createProductObject(final String name, final String year, final String title) {
        currentPage().createProductObject(name, year, title);
    }

    @Step("Create Sequence bundle {0}")
    public void createSequenceBundle(final String name, final String market, final String title) {
        currentPage().createSequenceBundle(name, market, title);
    }

    @Step("Create Learinig bundle {0} in Consumer Site")
    public void createLearningBundleConsumerSite(final String name, final String grade, 
    		  final String market, final String title) {
        
    	currentPage().createLearningBundleConsumerSite(name, grade, market, title);
    }

    @Step("Create Learning Bundle {0} in K-12 Site")
    public void createLearningBundleK12Site(final String name, final String title, final String lifecycle, final String market, final String grade) {
        currentPage().createLearningBundleK12Site(name, title, lifecycle, market, grade);
    }

    @Step("Create Learning object {0} in Consumer Site")
    public void createLearningObjectConsumerSite(
    		final String name, final String grade,
            final String rights, final String market, 
            final String title) {
        currentPage().createLearningObjectConsumerSite(name, grade,
                rights, market, title);
    }

    @Step("Create Component {0} in Consumer Site")
    public void createComponentConsumerSite(final String name, final String title, final String rights,
            final String grade, final String lifecycle, final String resourceType) {
        currentPage().createComponentConsumerSite(name, title, rights, grade, lifecycle, resourceType);
    }

    @Step("Create Component {0} in K-12 Site")
    public void createComponentK12Site(final String name, final String title, final String rights, final String grade, final String lifeCycle) {
        currentPage().createComponentK12Site(name, title, rights, grade, lifeCycle);
    }

    @Step("Wait for extract to complete")
    public void waitForZipToFinishExtract(String assetExtracted) {
        currentPage().waitForZipToFinishExtract(assetExtracted);
    }

    @Step("Navigate to a standard in correlatons dialog box")
    public void clickItemInCorrelationsPane(String standardName) {
        currentPage().clickItemInCorrelationsPane(standardName);
    }

    @Step("Select a standard to correlate")
    public void selectStandardToCorrelate(String standard) {
        currentPage().selectStandardToCorrelate(standard);
    }

    @Step("Check if standard was added")
    public void checkIfStandardWasAdded(String standard) {
        currentPage().checkIfStandardWasAdded(standard);
    }

    @Step("Remove an added correlation")
    public void removeACorrelation(String standard) {
        currentPage().removeACorrelation(standard);
    }

    @Step("Check if there are no correlations")
    public void checkIfThereAreNoCorrelations() {
        currentPage().checkIfThereAreNoCorrelations();
    }

    @Step("Delete HMH keword")
    public void deleteTagFromDocLibViewHMH(final String assetName, final String tagName) {
        currentPage().deleteTagFromDocLibView(assetName, tagName);
    }

    @Step("Check message for no spreadSheet in zip file")
    public void checkExtractErrorMessage(String message) {
        currentPage().checkExtractErrorMessage(message);
    }

    @Step("Click on refresh button")
    public void refresh() {
        currentPage().refresh();
    }

    @Step("Create Content Object{0} in K-12 Site")
    public void createLearningObjectK12Site(final String name, final String grade, final String language,
            final String rights, final String market, final String title, final String lifecycle) {
        currentPage().createLearningObjectK12Site(name, grade, language, rights, market, title, lifecycle);
    }

    @Step("Check if message for publishing action is displayed")
    public void checkPublishMessage() {
        currentPage().checkPublishMessage();
    }

    @Step("Select {0}")
    public void selectAnItemFromSelectedItemsDropDown(String actionName) {
        currentPage().selectAnItemFromSelectedItemsDropDown(actionName);
    }
    
    @Step("Click on the first check box")
    public void documentCheckboxClick() {
        currentPage().documentCheckboxClick();
    }
    
    //Added by Sampath - CognizantQA
    @Step("Refresh page to exit from - item moved popup")
    public void refreshToExitPopup() {
    	currentPage().refreshToExitPopup();
    }
    
    @Step("Click on folder to view the content")
    public void clickOnFolder() {
    currentPage().clickOnFolder();	
    
    }
    
    @Step("Click on View Detials for folder {0}")
	public void viewDetailsClick(final String assetName) {
		currentPage().viewDetailsClick(assetName);
	}

    @Step("Click on different actions from MoreActions Menu")
	public void moreActionMenuClick(final String menuOption,
			final String itemName) {
		currentPage().moreActionMenuClick(menuOption, itemName);
	}
    
    @Step("Click on asset name- {0}")
	public void assetFromListClick(final String assetName) {
		currentPage().assetFromListClick(assetName);
		currentPage().waitForLoadingLibraryToDisppear(assetName);
	}
    
    @Step("Wait For Loading Library To Disppear {1} seconds")
    public void waitForLoadingLibraryToDisppear(final String asset){
    	currentPage().waitForLoadingLibraryToDisppear(asset);
    }
    
    @Step("Click on asset name (exact title) {0}")
	public void assetFromListClickSub(final String assetName) {
		currentPage().assetFromListClick(assetName);
	}
    
    @Step("Click on asset name (exact title) {0}")
  	public void assetFromListClickSubCO(final String assetName) {
  		currentPage().assetFromListClickCO(assetName);
  	}
    
    @Step("Click on Validate learning spine")
  	public void clickOnValidateLearningSpine() {
  		currentPage().clickOnValidateLearningSpine();
  	}
    
    @Step("verify Renditions Version {0}")
	public void verifyRenditionsVersion(String version) {
		currentPage().verifyRenditionsVersion(version);
	}
    
    @Step("Click on asset name (exact title) {0}")
  	public void downloadableAssetFromListClickSubCO(final String assetName) {
  		currentPage().downloadableAssetFromListClickSubCO(assetName);
  	}
    
    @Step("Click on Delete Object Button")
	public void clickDeleteObject() {
		currentPage().clickDeleteObject();
	}
    @Step("Click on Delete Object Button")
	public void clickDeleteFolder() {
		currentPage().clickDeleteFolder();
	}
    @Step("Confirm delete")
	public void confirmDelete() {
		currentPage().confirmDelete();
	}
    
    @Step("Filter by category {0}")
	public void filterByCategory(final String categoryName) {
		currentPage().filterByCategory(categoryName);
	}
    
    @Step("Click on Move to.. button")
    public void clickMoveto() {
    	currentPage().clickMoveto();
    }
    
    @Step("Click on Copy to.. button")
    public void clickCopyTo() {
    	currentPage().clickCopyTo();
    }
    @Step("Click on Extract button")
    public void clickExtract() {
    	currentPage().clickExtract();
    }
    
    @Step("Click on Navigation bar to view the details")
    @Screenshots(onlyOnFailures=true)
    public void navBarClick() {
    	currentPage().navBarClick();
    }
    
    @Step("Click on Navigation bar to view the details")
    @Screenshots(onlyOnFailures=true)
    public void navBarClick(String assetname) {
    	currentPage().navBarClick(assetname);
    }
    
    @Step("Click on create and select content type as {0}")
    public void createNewContent(String contentType) {
    currentPage().createNewContent(contentType);	
    
    }
    
    @Step("Select all items on document library")
	public void selectAllItems() {
		currentPage().selectAllItems();
	}
    
    @Step("Click on Correlations in view details page")
  	public void clickCorrelations() {
  		currentPage().clickCorrelations();
  	}
    
    @Step("Select an aspect for a folder")
	public void selectAspectForAFolder(String aspectName) {
		currentPage().selectAspectForAFolder(aspectName);
	}
    @Step("Check If asset is present {0}")
   	public void checkIfAssetIsPresent(final String docPath) {
   		currentPage().checkIfAssetIsPresent(docPath);
   	}
    
    @Step("Verify username and time for Asset in document Library")
	public void verifyUsernameAndTimeForAsset(
			final String username, final String time) {
		currentPage().verifyUsernameAndTimeForAsset(username,
				time);
	}
    
    @Step("Check If Folder is present {0}")
    @Screenshots(onlyOnFailures=true)
   	public boolean checkIfFolderIsPresent(final String folderName) {
   		return currentPage().checkIfFolderIsPresent(folderName);
	
   	}
    
    @Step("Check If Folder is present {0}")
    @Screenshots(onlyOnFailures=true)
   	public boolean checkIfFolderIsPresentCh(final String folderName) {
   		return currentPage().checkIfFolderIsPresentCh(folderName);
	
   	}
    
    @Step("Check if the document not exists")
	public void checkIfAssetIsNotPresent(final String[] docPath) {
		currentPage().checkIfAssetIsNotPresent(docPath);
	}
    
    @Step("Check if the object not exists")
  	public void checkIfObjectIsNotPresent(final String name) {
  		currentPage().checkIfObjectIsNotPresent(name);
  	}
    
    @Step("Check If Asset/Object is present {0}")
    @Screenshots(onlyOnFailures=true)
   	public boolean isAssetPresent(final String objectName) {
   		return currentPage().isAssetPresent(objectName);
	
   	}
    
    
    @Step("Verify If Asset/Object is present {0}")
   	public void verifyIfAssetIsPresent(final String objectName, String title) {
   		currentPage().verifyIfAssetIsPresent(objectName, title);
   	}
    
    @Step("Verify If Asset/Object is present {0}")
   	public void verifyCCOIsPresent(final String objectName) {
   		currentPage().verifyCCOIsPresent(objectName);
   	}
    
    @Step("Verify If Folder/Object is present {0}")
   	public void verifyIfFolderIsPresent(final String objectName) {
   		currentPage().verifyIfFolderIsPresent(objectName);
   	}
    
    @Step("Verify Habitat added page is present {0}")
   	public void verifyHabitatAddedPageIsPresent(final String objectName) {
   		currentPage().verifyHabitatAddedPageIsPresent(objectName);
   	}
   	
    @Step("Create product set {0}")
    public void createProductSet(final String name,final String levle1,final String title) {
        currentPage().createProductSet(name,levle1,title);
    }
    
    @Step("Check if auto created folders are present")
    public boolean checkIfAutoCreatedFoldersArePresent(){
    	 return currentPage().checkIfAutoCreatedFoldersArePresent();
    }
    
    @Step("Create the folders and ADD aspects like auto creation of folders")
    public void createFoldersLikeAutoCreatedFolders(){
    	 currentPage().createFoldersLikeAutoCreatedFolders();
    }
    
    @Step("verify is Dowload as Zip link is present")
    public void verifyDownloadAsZipIsDisplayed() {
           currentPage().verifyDownloadAsZipIsDisplayed();
           
    }
 @Step("verify is Copy To link is present")
    public void verifyCopyToIsDisplayed() {
           currentPage().verifyCopyToIsDisplayed();
           
    }
 
 @Step("Click on the Metadata Report")
	public void clickonMetadataReport(){
		currentPage().clickonMetadataReport();
 }
   
//Added by Salai - CognizantQA
 @Step("Create hip object {0}")
 public void createHipObject(final String name, final String title, final String grade){
     currentPage().createHipObject(name, title, grade);
 }
 
 @Step("Click on hip object name- {0}")
	public void hipobjectFromListClick(final String hipObjectName) {
		currentPage().hipobjectFromListClick(hipObjectName);
	}
   
 @Step("Click on Extract as CCO button")
 public void clickExtractCCO() {
 	currentPage().clickExtractCCO();
 }
 
 @Step("Click on Validate COM Structure button")
 public void validComStruc() {
 	currentPage().validComStruc();
 }
 
 @Step("Click on Validate COM Structure button")
 public void validComStructure() {
 	currentPage().validComStructure();
 }
 
 @Step("Click on Import COM Structure button")
 public void importComStruc() {
 	currentPage().importComStruc();
 }
 
 
 @Step("Go Back to Previous Page")
 public void goBackToPreviousPage() {
 	currentPage().goBackToPreviousPage();
 }
 
//Auto update extension
 
@Step("Verify Mimetype extension")
public void verifymimext(String fileNameExt) {
	currentPage().verifymimetype(fileNameExt);
}	


@Step("Enhanced Deep Copy")
public void deepCopyTo(String site) {
	currentPage().deepCopyTo(site);
}	

@Step("Enhanced Deep Copy for Habitat pushed object")
public void deepCopy(String site) {
	currentPage().deepCopy(site);
}

@Step("Enhanced Deep Copy Replace & Replace with")
public void enhDeepCopySearchReplace(String site) {
	currentPage().enhDeepCopySearchReplace(site);
}	

@Step("Add folder details")
public void insertFolderNameDescriptionAndSave(String folderName,String description) {
	currentPage().insertFolderNameDescriptionAndSave(folderName,description );
}

//**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
public void uploadNewVersionDocument(String filepath) {
	currentPage().uploadNewVersionDocument(filepath);
	
}	
//** ALF1979 ** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
public void uploadButtonClick() {
	currentPage().uploadButtonClick();
	
}	
//** ALF1979 ** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
public void uploadNewVersionButtonDocumentActionsClick() {
	currentPage().uploadNewVersionButtonDocumentActionsClick();
}
//** ALF -2099 **  - Exclude Habitat-Generated ePubs from Deep Copy ** Sprint 7.3.2**
public void epubNotPresent(String assetName) {
	currentPage().epubNotPresent(assetName);
	
}
//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
@Step("Click on Upload learning spine")
	public void clickOnUploadLearningSpine() {
		currentPage().clickOnUploadLearningSpine();
	}

//** ALF-1988  ** Create Learning Spine Administrator role  ** Sprint 7.3.2 **
public void uploadLearningSpineNotPresent() {
	currentPage().uploadLearningSpineNotPresent();
	
}

//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
@Step("Click on asset name on Search results page (exact title) {0}")
public void assetFromSearchResultsListClick(final String assetName) {
	currentPage().assetFromSearchResultsListClick(assetName);
}
//** ALF-1989  ** Learning spine phase 1 upload via excel  ** Sprint 7.3.1 **
@Step("Click on Delete document")
	public void deleteDocOnViewDetailsLS() {
		currentPage().deleteDocOnViewDetailsLS();
	}

//** Create new PSF  **Habitat functionality changes Sprint 7.3.5 **
public void createPSFFolder(String name) {
	currentPage().createPSFFolder(name);
	
}
}
