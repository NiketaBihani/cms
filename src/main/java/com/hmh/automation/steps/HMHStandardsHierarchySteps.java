package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHStandardsHierarchyPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHStandardsHierarchySteps extends AbstractSteps<HMHStandardsHierarchyPage> {

    private static final long serialVersionUID = -854611134541075184L;

    public HMHStandardsHierarchySteps(Pages pages) {
        super(pages, HMHStandardsHierarchyPage.class);
    }

    @Step("Verify the current status of standard {0}")
    public void verifyStatusOfStandard(String currentStatus) {
        currentPage().verifyStatusOfStandard(currentStatus);
    }
    
    @Step("Change the current status of standard to {0}")
    public void changeStatusOfStandard(String currentStatus) {
        currentPage().changeStatusOfStandard(currentStatus);
    }
    
    

    @Step("Click on PLUS button to expand grade {0} standards")
    public void expandTheGradeStandards(String grade) {
        currentPage().expandTheGradeStandards(grade);
    }
    
    @Step("Click on PLUS button to expand standard folder {0}")
    public void expandStandardFolder(String stdFolderName) {
        currentPage().expandTheGradeStandards(stdFolderName);
    }
    
    @Step("Click on Standard {0} to view the details")
    public void clickOnStandard(String standard) {
        currentPage().expandTheGradeStandards(standard);
    }
    
    @Step("Move the standard {1} from one grade {0} to other grade {2} by drag and drop")
    public void  dragAndDropStandardAtGradeLevel(String sourceGrade, String sourceStandard, String targetGrade) {
        currentPage().dragAndDropStandardAtGradeLevel(sourceGrade, sourceStandard, targetGrade);
    }
    
    @Step("Click on Save structure button")
    public void saveStructure() {
        currentPage().saveStructure();
    }
    
    @Step("Click on Approve button")
    public void clickApproveButton() {
        currentPage().clickOnApprove();
    }
    
    @Step("Verify that moved the standard {1} from one grade {0} to other grade {2} is displaying correctly")
    public void  verifyTheChangesAreReflected(String sourceGrade, String sourceStandard, String targetGrade) {
        currentPage().verifyTheChangesAreReflected(sourceGrade, sourceStandard, targetGrade);
    }
    

}
