package com.hmh.automation.steps;

import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import org.openqa.selenium.By;

import com.hmh.automation.pages.HMHDocumentDetailsPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;
import com.jayway.restassured.builder.ResponseSpecBuilder;

public class HMHDocumentDetailsSteps extends AbstractSteps<HMHDocumentDetailsPage> {

	private static final long serialVersionUID = -854602134541078184L;

	String projFolder= System.getProperty("user.dir");
	ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();


	public HMHDocumentDetailsSteps(final Pages pages) {
		super(pages, HMHDocumentDetailsPage.class);
	}

	@Step("Create reference")
	public void selectReference(final String referenceName) {
		currentPage().selectReference(referenceName);
	}

	@Step("Check correlation is present in document details page")
	public void checkCorrelationIsVisible(final String correlationName) {
		currentPage().checkCorrelationIsVisible(correlationName);
	}

	@Step("Click on manage references link")
	public void clickOnManageReferenceLink() {
		currentPage().clickOnManageReferenceLink();
	}

	@Step("Click on outgoing references")
	public void outgoingReferencesClick() {
		currentPage().outgoingReferencesClick();
	}

	@Step("Click on outgoing references")
	public void outgoingReferencesLinkClick() {
		currentPage().outgoingReferencesLinkClick();
	}
	
	@Step("Check if refernece was added")
	public void checkIfReferenceWasAdded(final String itemName) {
		currentPage().checkIfReferenceWasAdded(itemName);
	}
	@Step("Close the reference dailog box")
	public void closeReferenceDailog() {
		currentPage().cancelReferenceDailog();
	}

	@Step("Check if reference is present in Document Details Page")
	public void clickOnReference(final String referenceName) {
		currentPage().clickOnReference(referenceName);
	}

	@Step("Check if correlation is present in Document details page and click on it")
	@Screenshots(onlyOnFailures=true)
	public void clickOnCorrelation(final String correlationName) {
		currentPage().clickOnCorrelation(correlationName);
	}

	@Step("Check if standard was correlated to Item and click on it")
	public void checkIfStandardWasCorrelatedToItemAndClickOnIt(String itemName) {
		currentPage().checkIfStandardWasCorrelatedToItemAndClickOnIt(itemName);
	}

	@Step("Delete Object")
	public void deleteObject() {
		currentPage().deleteObject();
	}

	@Step("Check message for not being able to delete an object")
	public void checkObjectCanNotBeDeleted(final String message) {
		currentPage().checkObjectCanNotBeDeleted(message);
	}

	@Step("Navigate in references dialogue box")
	public void clickItemInReferencesPane(String itemName) {
		currentPage().clickItemInReferencesPane(itemName);
	}

	@Step("Delete a reference")
	public void deleteReference(final String itemName) {
		currentPage().deleteReference(itemName);
	}

	@Step("Check if references list is empty")
	public void checkIfReferencesListIsEmpty() {
		currentPage().checkIfTheReferencesAreRemoved();
	}

	@Step("Check derived from object")
	public void checkDerivedFrom(final String object) {
		currentPage().checkDerivedFrom(object);
	}

	@Step("Check if incoming reference to object {0} is present")
	public void checkIfIncomingReferenceWasAdded(final String referencedItem) {
		currentPage().checkIfIncomingReferenceWasAdded(referencedItem);
	}

	@Step("Check if outgoing reference to object {0} is present")
	@Pending
	public void checkIfOutgoingReferenceWasAdded(final String referencedItem) {
		currentPage().checkIfOutgoingReferenceWasAdded(referencedItem);
	}

	@Step("Check if property{0} has the value{1}")
	public void verifyHMHPropertyValue(final String propertyName,
			final String propertyValue) {
		currentPage().verifyHMHPropertyValue(propertyName, propertyValue);
	}

	@Step("Check the latest version is {0}")
	public void checkLatestVersion(String version) {
		currentPage().checkLatestVersion(version);
	}

	@Step("Return the latest version as boolean {0}")
	public boolean returnLatestVersion(String version) {
		return currentPage().returnLatestVersion(version);
	}

	@Step("Check the latest version is {0}")
	public void checkLatestVersionDoc(String version) {
		currentPage().checkLatestVersionDoc(version);
	}

	@Step("Wait for version to update- Max 5 min {0}")
	public void waitUntilLatestVersionUpdated(String version) {
		currentPage().waitUntilLatestVersionUpdated(version);
	}

	
	@Step("Validate version text {0}")
	public void checkLatestVersionText(String version) {
		currentPage().checkLatestVersionText(version);
	}
	
	@Step("Wait for version to update- Max 5 min {0}")
	public void waitUntilLatestVersionDocUpdated(String version) {
		currentPage().waitUntilLatestVersionDocUpdated(version);
	}


	@Step("Click on Manage Aspects Button")
	public void manageAspectsButtonDocumentActionsClick(By by) {
		currentPage().manageAspectsButtonDocumentActionsClick(by);
	}

	@Step("Click on Manage Aspects Button")
	public void manageAspectsButtonDocumentActionsClick() {
		currentPage().manageAspectsButtonDocumentActionsClick();
	}

	@Step("Click on Manage Aspects Button")
	public void manageAspectsButtonDocumentActionsClick(String id) {
		currentPage().manageAspectsButtonDocumentActionsClick(id);
	}


	@Step("Verify that property {0} has value {1}")
	public void verifyPropertyValue(final String propertyName,
			final String propertyValue) {
		currentPage().verifyPropertyValue(propertyName, propertyValue);
	}
	
	@Step("Create Learning Object")
	public void createLOforConsumer() {
		currentPage().createLOfork12();
	}

	@Step("Create Learning Object")
	public void createLOforK12() {
		currentPage().createLOfork12();
	}
	
	@Step("Create Any Object")
	public void createNewContentNew(String option){
		currentPage().createNewContentNew(option);
	}
	

	@Step("Click on reference folder ")
	public void selectReferenceFolder (final String folderName) {
		currentPage().selectReferenceFolder(folderName);
	}

	@Step("Click on Version Link ")
	public void clickonVersion() {
		currentPage().clickonVersion();
	}
	
	//Version Pop up
	@Step("Click on Cancel button")
	public void clickonVersioncancel(){
		currentPage().cancelVersionPopup();
	}
	
	@Step("Enter Comment")
	public void commentVersionPopup(String versionComment){
		currentPage().commentVersionPopup(versionComment);
	}
	
	@Step("Click on Save button")
	public void clickonVersionsave(){
		currentPage().saveVersionPopup();
	}
	//
	@Step("Click on Push to Habitat button ")
	public void pushToHabitat() {
		currentPage().pushToHabitat();
	}

	@Step("Click on Push to Habitat OK button ")
	public void pushToHabitatOK() {
		currentPage().pushToHabitatOK();
	}

	@Step("Wait for Habitat metadata displayed on page ")
	public void waitUntilPushToHabitatDone() {
		currentPage().waitUntilPushToHabitatDone();
	}

	@Step("Verify that property {0} has value {1} ")
	public void verifyPushTohabitatStatus(final String propertyName,
			final String propertyValue) {
		currentPage().verifyPushTohabitatStatus(propertyName, propertyValue);
	}

	@Step("Verify Habitat push status for the product set")
	public boolean pushTohabitatStatus(final String propertyName, final String propertyValue) {
		return currentPage().pushTohabitatStatus(propertyName, propertyValue);
	}

	@Step("Verify that item is alredy pushed to habitat; property {0} has value {1} ")
	public boolean isPushedToHabitat(final String propertyName, final String propertyValue) {
		return currentPage().isPushedToHabitat(propertyName, propertyValue);
	}
	//pull from Habitat
	@Step("Click on Habitat pull button ")
	public void clickHabitatPull() {
		currentPage().clickHabitatPull();
	}

	@Step("Click on popup Habitat pull OK button ")
	public void checkHabitatLoginPopup() {
		currentPage().checkHabitatLoginPopup();
	}

	@Step("Select the options of Habitat for pull then Click on OK button ")
	public void habitatPullPopUp() {
		currentPage().habitatPullPopUp();
	}
	@Step("Login to Habitat for pull then Click on Submit button ")
	public void habitatLoginForPull(final String habitatUserName, final String habitatPassword) {
		currentPage().habitatLoginForPull(habitatUserName, habitatPassword);
	}

	@Step("Click on popup Habitat pull OK button ")
	public void publishTo(final String option) {
		currentPage().publishTo(option);
	}

	@Step("Click on Publish Draft icon ")
	public void publishToDraft() {
		currentPage().publishToDraft();
	}
	@Step("Click on Publish QA icon ")
	public void publishToQA() {
		currentPage().publishToQA();
	}
	@Step("Click on Publish Content icon")
	public void publishToContent() {
		currentPage().publishToContent();
	}
	@Step("Click on Publish Manifest icon")
    public void publishToManifest() {
           currentPage().publishToManifest();
    }


	@Step("Click on Generate SnapShot")
	public void clickgenerateSnapshot() {
		currentPage().clickgenerateSnapshot();
	}

	@Step("Verify username for selected asset in latest version section")
	public void verifyUsernameForLastVersion(final String username) {
		currentPage().verifyUsernameForLastVersion(username);
	}

	@Step("Click on Publish QA icon")
	public void publishToQAwithResponse() {
		currentPage().publishToQAwithResponse();
	}
	@Step("Click on Publish Content icon")
	public void publishToContentwithResponse() {
		currentPage().publishToContentwithResponse();
	}
	@Step("Dismiss the window popup if any")
	public void windowPopup() {
		currentPage().windowPopup();
	}

	@Step("Click on Edit Properties on details page")
	public void clickOnEditPropertiesDetails() {
		currentPage().clickOnEditPropertiesDetails();
	}
	@Step("Click on View Program Suport Folder Link ")
	public  void clickOnProgramSupportFolderLink() {
		currentPage().clickOnProgramSupportFolderLink();
	}

	@Step("Click on Edit Sequence ")
	public  void clickEditSequence() {
		currentPage().clickeditsequence();
	}

	@Step ("Check If program support folder details page is displayed  ")
	public void checkIfOnProgramSupportFolderDetailsPage(String masterLibFolder) {
		currentPage().checkIfOnProgramSupportFolderDetailsPage(masterLibFolder);
	}
	@Step("Verify Habitat is disabled for {0} user ")
	public  void verifyHabitatIsDisabled(String user) {
		currentPage().verifyHabitatIsDisabled(user);
	}
	@Step("Verify Publish to Content is disabled for {0} user ")
	public  void publishToQADisabled(String user) {
		currentPage().publishToContentDisabled(user);
	}
	@Step("Verify Publish to Draft is disabled for {0} user ")
	public  void publishToDraftDisabled(String user) {
		currentPage().publishToDraftDisabled(user);
	}
	@Step("Verify Publish to Draft is disabled for {0} user ")
	public  void publishToQAEnabled(String user) {
		currentPage().publishToQAEnabled(user);
	}
	@Step("Verify and get the manifest URL")
	public String getManifestURL(){
		return currentPage().getManifestURL();
	}


	//Only for Manifest file validation in Firefox browser - DO NOT Use for other tests	
	@Step("Save the manifest URL in Target folder")
	public void saveTheManifestFile() {
		currentPage().saveTheManifestFile();
	}
	
	@Step("Wait until manifest URL is updated")
	public void waitUntilManifestURLisUpdated() {
		currentPage().waitUntilManifestURLisUpdated();
	}

	@Step("Validate the manifest XML located at {0} having node {1} with value {2}")
	public void verifyNodeNameAndValue(String loc, String nodeName, String expValue){
		currentPage().verifyNodeNameAndValue(loc, nodeName, expValue);
	}
	@Step("Validate the manifest XML located at {0} having node {1} should not have value {2}")
	public void verifyNodeShouldNotContainValue(String loc, String nodeName, String ccoName){
		currentPage().verifyNodeShouldNotContainValue(loc, nodeName, ccoName);
	}

	@Step("Validate the manifest XML located at {0} having node {1} with attribute {2} and value {3}")
	public void verifyNodeNameAttributeAndValue(String loc, String nodeName, String attribute, String expValue){
		currentPage().verifyNodeNameAttributeAndValue(loc, nodeName, attribute, expValue);
	}
	@Step("Validate the manifest XML located at {0} having node {1} should not have value {2}")
	public void verifyNodeNameAttributeShouldNotHaveValue(String loc, String nodeName, String attribute, String ccoName){
		currentPage().verifyNodeNameAttributeShouldNotHaveValue(loc, nodeName, attribute, ccoName);
	}

	@Step("verify CCO- {3} with Actual Content And Valid ResourceType Contains Href Value in Manifest XML")
	public void verifyCCOwithActualContentAndValidResourceTypeContainsHrefValue(String loc, String nodeName, String attribute, String expValue){
		currentPage().verifyNodeNameAttributeAndValue(loc, nodeName, attribute, "CLO_index.html?page=/cards/"+expValue+".xhtml");
	}

	
	@Step("Get the all nodes of xml  {0}")
	public void loopingNodes(String loc){
		currentPage().loopingNodes(loc);
	}
	
	@Step("Verify Adding Contents to Standards Cart ")
	public  void addToStandardsCartButtonDocumentActionsClick() {
		currentPage().addToStandardsCartButtonDocumentActionsClick();
	}
	
	@Step("Click on Standards Correlation Cart ")
	public  void clickOnStandardCorrelationCart(String fileName) {
	  	currentPage().clickOnStandardCorrelationCart(fileName);
	}
	 
	@Step("Verify Delivery Structure Value")
	public void verifyDeliveryStructureValue(String delivery){
		currentPage().verifyDeliveryStructureValue(delivery);
	}
	
	@Step("Click on Generate Metadata Report")
	public void generateMetadataReport(){
		currentPage().generateMetadataReport();
    }
	
	@Step("Download Metadata Report")
	public void downloadMetadataReport(){
		currentPage().downloadMetadataReport();
    }
	
	  @Step("Click on Download button")
	  public  void clickOnDownloadClick() {
	  	currentPage().clickOnDownload();
		}
	  
	//Habitat Push New Changes
		
		@Step("Click on pushToHabitatlink")
	    public void pushToHabitatlink(){
	           currentPage().pushToHabitat();
	    }
	    
	    @Step("Enter Habitat push Username")
	    public void pushToHabitat_Username(String pushToHabitatInput_Username){
                currentPage().pushToHabitat_Username(pushToHabitatInput_Username);
	    }
	    
	    
	    @Step("Enter Habitat push Password")
	    public void pushToHabitat_Password(String pushToHabitatInput_Password){
	           currentPage().pushToHabitat_Password(pushToHabitatInput_Password);
	     }
	    
	    @Step("Click on Submit button")
	    public void pushToHabitat_submitbtn(){
	    currentPage().pushToHabitat_submitbtn();
	    }
	    
	    @Step("Click on Push to Habiatat Submit button")
	    public void pushToHabitat_submitbutton(){
	    currentPage().pushToHabitat_submitbutton();
	    }
	    
	    
	    
	    @Step("Click on radiobutton")
	    public void pushToHabitatUserTemplateRadiobtn(final String pushToHabitatUserTemplate){
	           currentPage().pushToHabitatUserTemplateRadiobtn(pushToHabitatUserTemplate);
	    }
	    
	    @Step("Verify title in edit properties")
	    public void verifyTitleInEditProperties(String title) {
	    	currentPage().verifyTitleInEditProperties(title);
	    }
	    
	    @Step("Click on cancel button")
	    public void pushToHabitat_cancelbtn(){
	           currentPage().pushToHabitat_cancelbtn();
	    }
	    
	    @Step("Click on copy Habitat CCO link")
	    public void copyHabitatCCOlink(){
	           currentPage().copyHabitatCCOlink();
	    }
	    
	    @Step("Click on copy Habitat CCO link")
	    public void selectCopyHabitatCCO(String copyHabitatCCO){
	    	
			currentPage().selectCopyHabitatCCO(copyHabitatCCO);
	    }
	           
	  //**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
	    @Step("Verify the Warning message on Pop Up Box")
	    public void verifyWarningMessageOnPopup(){
	           currentPage().verifyWarningMessageOnPopup();
	    }
		
	  //**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
	    @Step("Select the radio button on Push to Habitat Pop Up box")
	    public void selectRadiobuttonOnPopUp(){
	           currentPage().selectRadiobuttonOnPopUp();
	    }
	  //**** ALF-2015 - Update ePubs when User Role Value is Changed (Sprint 7.3.1)****
	    @Step("Select the radio button on Push to Habitat Pop Up box")
	    public void clickOkbuttonOnPopUp(){
	           currentPage().clickOkbuttonOnPopUp();
	    }
	 
	 //**** ALF1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
	    @Step("Click the Revert button")
	    public void revertbutton(){
	           currentPage().revertbutton();
	    }
	    
	  //**** ALF-1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
	    @Step("Click the Revert content and Metadata radio button")
	    public void revertContentAndMetadataRadio(){
	           currentPage().revertContentAndMetadataRadio();
	    }
	    
	  //**** ALF-1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
	    @Step("Click the Revert content radio button")
	    public void revertContentRadio(){
	           currentPage().revertContentRadio();
	    }
	  //**** ALF-1979** Preserve current metadata when reverting to previously versioned files** Sprint 7.3.2**
	    @Step("Add the version and comment on Revert window")
	    public void selectTheVersionAndAddCommentOnRevertWindow(String versionType, String comment){
	           currentPage().selectTheVersionAndAddCommentOnRevertWindow(versionType, comment);
	    }
	  //**** ALF-2088** Associate a Product Set or Product Object with One or More Learning Spines** Sprint 7.3.3**  
		@Step("Click on Associate Learning Spine on details page")
		public void clickOnAssociatelearningSpineAction(String spine) {
			currentPage().clickOnAssociatelearningSpineAction(spine);
		}
	  //**** ALF-2110** Make Changes to Learning Spine User Interface ** Sprint 7.3.3**  
		@Step("Check order on Associate Learning Spine window")
		public void checkOrderOnAssociatelearningSpine() {
			currentPage().checkOrderOnAssociatelearningSpine();
		}
		//**** ALF-2088** Associate a Product Set or Product Object with One or More Learning Spines** Sprint 7.3.3**  
		@Step("Save Learning Spine on Learning spine window")
		public void saveAssociatelearningSpine() {
		currentPage().saveAssociatelearningSpine();
				}
		
		//**** ALF-2128** Learning Spines correlation are visible on View details page ** Sprint 7.3.3**  
		@Step("View Learning Spine details")
		public void viewAssociatelearningSpine(String spine,String label) {
			currentPage().viewAssociatelearningSpine(spine,label);
				}
		
		//**** ALF-2140** Deleting a Learning Spines correlation ** Sprint 7.3.3 **  
		@Step("Delete Learning Spine")
		public void deleteAssociatelearningSpine() {
			currentPage().deleteAssociatelearningSpine();
		}
		
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		@Step("Click on Audit History action")
		public void auditHistoryAction() {
			currentPage().auditHistoryAction();
		}
		
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		@Step("Click on Audit History action")
		public void noAuditHistoryFound() {
			currentPage().noAuditHistoryFound();
		}
		
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		@Step("Click on View details on Audit History Log")
		public void clickViewDetailsOnAuditHistory(String userName) {
			currentPage().clickViewDetailsOnAuditHistory(userName);
		}
		
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		@Step("Verify Property on View details on Audit History Log")
		public void verifyPropertyOnViewDetailsAuditHistory(String propertyName, String propertyValue) {
			currentPage().verifyPropertyOnViewDetailsAuditHistory(propertyName, propertyValue);
		}
		
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		@Step("Click on View details on Audit History Log")
		public void clickOkButtonOnAuditHistory() {
			currentPage().clickOkButtonOnAuditHistory();
		}
		
		//** ALF-2129 **  Audit Trail for Bulk Changes to Any Object - UI Changes ** Sprint 7.3.3 **
		@Step("Click on View details on Audit History Log")
		public void clickOkButtonOnAuditHistoryViewDetailsPopUp() {
			currentPage().clickOkButtonOnAuditHistoryViewDetailsPopUp();
		}
		
		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		@Step("Click on Add Collections")
		public void clickOnAddNewCollectionAction(String collectionName) {
			currentPage().clickOnAddNewCollectionAction(collectionName);
		}
		
		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		@Step("Click on Add Collections")
		public void clickOnAddExistingCollectionAction(String collectionName) {
			currentPage().clickOnAddExistingCollectionAction(collectionName);
		}
		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		@Step("Click on My Collections")
		public void clickOnMyCollection() {
			currentPage().clickOnMyCollection();
		}
		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		@Step("Click on My Collections")
		public void clickOnGeneratePDF() {
			currentPage().clickOnGeneratePDF();
		}
		
		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		@Step("Click on My Collection folder")
		public void clickOnPDFReportsFolder() {
			currentPage().clickOnPDFReportsFolder();
		}
		
		//** ALF-2206 **  Ability to Generate PDF for a collection ** Sprint 7.3.3 **
		@Step("Verify the Generated PDF")
		public void verifyGeneratedPDFReport(String asset1, String asset2) {
			currentPage().verifyGeneratedPDFReport(asset1, asset2);
		}
		
		//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		@Step("Click on Manage aspect")
		public void clickManageAspectAction() {
			currentPage().clickManageAspectAction();
		}
		
		//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		@Step("Select Timestamp aspect on Manage aspect")
		public void selectTimestampAspectOnManageAspect() {
			currentPage().selectTimestampAspectOnManageAspect();
		}
		
		//** ALF-2227 ** Trade : Asset Upload To renditions Folder ** Sprint 7.3.3 **
		@Step("Verify Timestamp aspect on folder")
		public String [] verifyAspectOnAssetFolder() {
			String a[] = currentPage().verifyAspectOnAssetFolder();
			return a;
		}
		
		//** ALF-2224 ** Additional Columns in QA Report ** Sprint 7.3.3 **
		@Step("Click on QA Report")
		public void clickQAReport() {
			currentPage().clickQAReport();
		}
		
		@Step("Download the File")
		public void clickDownloadAction() {
			currentPage().clickDownloadAction();
		}

		//** ALF-2128 ** Learning Spine Correlations are Visible on the View Details Page ** Sprint 7.3.4 **
		public void viewCorrelatelearningSkill(String spine, String label) {
			
			currentPage().viewCorrelatelearningSkill(spine,label);
		}

		//** ALF-2140 **  Deleting a Learning Spine Correlations ** Sprint 7.3.4 **
		public void deleteCorrelatelearningSkill() {
			currentPage().deleteCorrelatelearningSkill();
			
		}
		
		//** ALF-2333 **  Trade: Ability to generate a PDF without first creating a collection ** Sprint 7.3.5 **	
		
		@Step("Click on Generate PDF")
		public void clickOnGeneratePDFOnAssets() {
			currentPage().clickOnGeneratePDFOnAssets();
		}
		
}

