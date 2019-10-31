package com.hmh.automation.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

import com.hmh.automation.pages.HMHDatalistsPage;
import com.ixxus.ipm.automation.steps.AbstractSteps;

public class HMHDataListsSteps extends AbstractSteps<HMHDatalistsPage> {

    private static final long serialVersionUID = -357722727581958583L;

    public HMHDataListsSteps(final Pages pages) {
        super(pages, HMHDatalistsPage.class);
    }

    @Step("Select item from standard list")
    public void selectStandardFromList(String list) {
        currentPage().selectStandardFromList(list);
    }

    @Step("Check corrleation in Data lists")
    public void checkIfItemWasCorrelatedToStandard(String standard, String item) {
        currentPage().checkIfItemWasCorrelatedToStandard(standard, item);
    }

    @Step("Check if there the object has no correlation")
    public void checkIfThereIsNoCorrelation(String standard, String item) {
        currentPage().checkIfThereIsNoCorrelation(standard, item);
    }

    @Step("Check correlated items in edit standard pane")
    public void checkCorrelationsInEditStandardPane(String itemName) {
        currentPage().checkCorrelationsInEditStandardPane(itemName);
    }

    @Step("Remove correlation in Data Lists page")
    public void removeCorrelationInDataSetsPage(String itemName) {
        currentPage().removeCorrelationInDataSetsPage(itemName);
    }

    @Step("Click on edit Standard Button")
    public void editButtonForStandardClick(String standard) {
        currentPage().editStandardButtonClick(standard);
    }

    @Step("Click on Corelations button in Edit Standard Pane")
    public void selectCorrleationButtonClick() {
        currentPage().selectCorrelationButtonClick();
    }

    @Step("Check if item is in corrleation in data sets page")
    public void checkIfItemIsInCorrleationInDataSetsPage(String itemName) {
        currentPage().checkIfItemIsInCorrleationInDataSetsPage(itemName);
    }

    @Step("Check if corrleated pane is empty")
    public void checkIfNoItemIsCorrelatedForStandardInDataListsPage() {
        currentPage().checkIfNoItemIsCorrelatedForStandardInDataListsPage();
    }

    @Step("Click Save button in edit correlations")
    public void editCorrelationPaneSaveButtonClick() {
        currentPage().editCorrelationPaneSaveButtonClick();
    }

    @Step("Check if Standard has no corrleation")
    public void checkIfStandardHasNoCorrelation(String standard) {
        currentPage().checkIfStandardHasNoCorrelation(standard);
    }

    @Step("Navigate in Corrleation dialgo box")
    public void navigateInCorelationsDialgoBox(String itemName) {
        currentPage().navigateInCorelationsDialgoBox(itemName);
    }

    @Step("Add Item to correlate")
    public void addItemToCorrelate(String itemName) {
        currentPage().addItemToCorrelate(itemName);
    }
    @Step("Click on Correlate 'OK' button")
    public void correlateOKbuttonClick() {
        currentPage().correlateOKbuttonClick();
    }
    
}
