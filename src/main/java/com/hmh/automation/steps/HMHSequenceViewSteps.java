package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHSequenceViewPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHSequenceViewSteps extends AbstractSteps<HMHSequenceViewPage> {

    private static final long serialVersionUID = -854602132341076184L;

    public HMHSequenceViewSteps(Pages pages) {
        super(pages, HMHSequenceViewPage.class);
    }

    @Step("Select folder view in Edit Sqeuence View")
    public void folderViewButtonClick() {
        currentPage().folderViewButtonClick();
    }

    @Step("Click Metadata button in Edit Sequence view")
    public void metadataButtonClickInEditSqeuence() {
        currentPage().metadataSequenceViewButtonClick();
    }

    @Step("Check if current page is Sequence View")
    public void checkIfOnSequenceViewPage() {
        currentPage().checkIfOnSequenceViewPage();
    }

    @Step("Go Back button click")
    public void goBackClick() {
        currentPage().goBackClick();
    }
    
    @Step("Click on save button")
    public void saveButtonClick(){
        currentPage().saveButtonClick();
    }
    
   

    @Step("Move element {0} in element {1}")
    public void changeSequenceTreeStructure(String item, String dest) {
        currentPage().changeSequenceTreeStructure(item, dest);
    }

    @Step("Check if order is correct in Sequence View")
    public void checkSequenceTreeStructure(String firstItem, String secondItem, String thirdItem) {
        currentPage().checkSequenceTreeStructure(firstItem, secondItem, thirdItem);
    }

    @Step("Click on an element in the tree view")
    public void clickOnAnElementInTheSequenceView(String element) {
        currentPage().clickOnAnElementInTheSequenceView(element);
    }

    @Step("Check if an element is present in the galleri view for a sequence")
    public void checkIfElementIsDisplayedInSequenceViewGallery(String elementName) {
        currentPage().checkIfElementIsDisplayedInSequenceViewGallery(elementName);
    }
    
    @Step("Expand Tree in Sequence View")
    public void expandTreeInSequenceView() {
        currentPage().expandTreeInSequenceView();
    }
    
    @Step(" Create Objects in Sequence View with {0} levels")
  	public void createAndVerifyObjInEditSequenceforNlevels(int NoOfLevels, String psObjName, String lbName, String ccoName) {
  		currentPage().createObjInEditSequence(NoOfLevels, psObjName, lbName, ccoName);
  		
  	}
    
    //Created for Test Reg_087
    @Step("Upload to content")
    public void uploadToContent(String jpeg) {
        currentPage().ulpoadContent(jpeg);
    }
    
    //Delete objected
    
    @Step("Check if the objects present")
    public void checkSelectedItemsEnabledAndDelete() {
        currentPage().checkSelectedItemsEnabledAndDelete();
    }
    
    //Create PO in PS
    @Step("Create PO in PS")
  	public void createPOinPS(int noOfLevels, String psObjName,String poName) {
  		currentPage().createPOinPS(noOfLevels, psObjName, poName);
  		
  	}
    
    
    //Created for Publish to Manifest
    @Step(" Create Objects in Sequence View with {0} levels to publish to manifest")
  	public void createAndVerifyObjInEditSequenceforNlevelsForManifest(int NoOfLevels, String psObjName, String lbName, String ccoName,String coName, String assetName) {
  		currentPage().createObjInEditSequenceForManifest(NoOfLevels, psObjName, lbName, ccoName, coName, assetName);
  		
  	}
    
    @Step(" Create valid manifest structure in Sequence View with {0} levels")
  	public void createValidManifestStructureEditSequenceforNlevels(int NoOfLevels, String psObjName, String sbName, String ccoName, String assetName) {
  		currentPage().createValidManifestStructureEditSequenceforNlevels(NoOfLevels, psObjName, sbName, ccoName, assetName);
  		
  	}
    
    @Step(" Create Objects in Sequence View with {0} levels PS PO")
  	public void createAndVerifyObjInEditSequenceforNlevelsPSPO(int NoOfLevels, String psObjName, String poName, String sbName) {
  		currentPage().createObjInEditSequencePSPO(NoOfLevels, psObjName, poName, sbName);
  		
  	}
    
    @Step(" Create Objects in Sequence View with {0} levels CO in SB")
  	public void createAndVerifyObjInEditSequenceCOInSB(int NoOfLevels, String psObjName, String lbName, String coname) {
  		currentPage().createObjInEditSequenceCOInSB(NoOfLevels, psObjName, lbName, coname);
  		
  	}
    
    @Step(" Create Objects in Sequence View with {0} levels Asset in SB")
  	public void createAndVerifyObjInEditSequenceAssetInSB(int NoOfLevels, String psObjName, String lbName, String assetname) {
  		currentPage().createObjInEditSequenceAssetInSB(NoOfLevels, psObjName, lbName, assetname);
  		
  	}
    
    @Step(" Verify Enhanced Deep Copy Objects in Sequence View in SB ")
  	public void verifyObjInEditSequenceforEnhanceDeepCopy(String psObjName, String sbName, String ccoName,String coName, String assetName) {
  		currentPage().verifyObjInEditSequenceforEnhanceDeepCopy(psObjName, sbName, ccoName, coName, assetName);
  		
  	}
    
    
}
